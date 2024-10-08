package api;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseApi {
    public static void configurar() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}