package api;

import io.restassured.response.Response;

import java.io.IOException;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ValidacoesPet {

    private final Utils utilitarios = new Utils();

    public void validarPesquisaPorPetInexistente(int petId) {
        Response response = given()
                .when()
                .get("/pet/" + petId);
        response.then().statusCode(404);
        response.then().body(matchesJsonSchemaInClasspath("schema-get-pet-inexistente.json"));
        response.then()
                .body("code", equalTo(1))
                .body("type", equalTo("error"))
                .body("message", equalTo("Pet not found"));
    }

    public void fazerPostPet() throws IOException {
        String jsonPost = utilitarios.obterDados("src/test/resources/post-pet.json");
        given()
                .contentType("application/json")
                .body(jsonPost)
                .when()
                .post("/pet");
    }

    public void validarGetPetPending() {
        Response response = given()
                .queryParam("status", "pending")
                .when()
                .get("/pet/findByStatus"); // Endpoint corrigido
        response.then().statusCode(200);
        response.then().body(matchesJsonSchemaInClasspath("schema-get-pet-pending.json"));
        response.then()
                .body("[0].id", equalTo(200))
                .body("[0].category.id", equalTo(1))
                .body("[0].category.name", equalTo("cachorro"))
                .body("[0].name", equalTo("pluto"))
                .body("[0].photoUrls[0]", equalTo("https://lumiere-a.akamaihd.net/v1/images/eb_chara_pluto_sp_d7070adc.jpeg"))
                .body("[0].tags[0].id", equalTo(1))
                .body("[0].tags[0].name", equalTo("cachorros"))
                .body("[0].status", equalTo("pending"));
    }

    public Response fazerPutPet() throws IOException {
        String jsonPut = utilitarios.obterDados("src/test/resources/put-pet.json");

        return given()
                .contentType("application/json")
                .body(jsonPut)
                .when()
                .put("/pet");
    }

    public void validarPutPet(Response response) {
        response.then().statusCode(200);
        response.then().body(matchesJsonSchemaInClasspath("schema-atualizacao-pet.json"));
        response.then()
                .body("id", equalTo(200))
                .body("category.id", equalTo(1))
                .body("category.name", equalTo("cachorro"))
                .body("name", equalTo("pluto"))
                .body("photoUrls", hasItem("string"))
                .body("tags[0].id", equalTo(1))
                .body("tags[0].name", equalTo("cachorros"))
                .body("status", equalTo("available"));
    }
}