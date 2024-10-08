package api;

import io.restassured.RestAssured;

public class BaseApi {
    public static void configurar() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}