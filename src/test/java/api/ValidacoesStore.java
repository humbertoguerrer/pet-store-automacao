package api;

import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;


public class ValidacoesStore {

    private final Utils utilitarios = new Utils();

    public Response fazerPostOrder() throws IOException {
        String jsonPost = utilitarios.obterDados("src/test/resources/post-order.json");

        return given()
                .contentType("application/json")
                .body(jsonPost)
                .when()
                .post("/store/order");
    }

    public void validarPostOrder(Response response) {
        response.then().statusCode(200);
        response.then().body(matchesJsonSchemaInClasspath("schema-post-order.json"));
        response.then()
                .body("id", equalTo(1))
                .body("petId", equalTo(1))
                .body("quantity", equalTo(2))
                .body("shipDate", equalTo("2024-10-07T22:45:14.341+0000"))
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true));
    }
}