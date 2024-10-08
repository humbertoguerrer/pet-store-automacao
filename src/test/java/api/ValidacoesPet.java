package api;

import io.restassured.response.Response;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidacoesPet {

    public void validarPesquisaPorPetInexistente(int petId) {
        Response response = given()
                .when()
                .get("/pet/" + petId);
        response.then().statusCode(404);
        response.then().body(matchesJsonSchemaInClasspath("schema-pet-inexistente.json"));
        response.then()
                .body("code", equalTo(1))
                .body("type", equalTo("error"))
                .body("message", equalTo("Pet not found"));
    }
}