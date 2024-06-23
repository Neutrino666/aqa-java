package ru.education.aqajava.tests.lessons.lesson2;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

//import static io.restassured.RestAssured.given;

public class RestAssuredTests {

    @Test
    void checkStoreInventoryStatusCode() {
        given()
//                .log().all()
                .when()
                .get("https://petstore.swagger.io/v2/store/invegntory")
                .then()
//                .log().all()
                .statusCode(400);
    }

    @Test
    void printResponseBody() {
        String body = given()
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then()
                .extract()
                .body()
                .asString();

        System.out.println(body);
    }

    @Test
    void getStoreOrder() {
        given()
                .when()
                .log().all()
                .pathParam("id", 10)
                .get("https://petstore.swagger.io/v2/store/order/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    void postNewStoreOrder() {
        String body = "{\n" +
                "  \"id\": 1,\n" +
                "  \"petId\": 1,\n" +
                "  \"quantity\": 1,\n" +
                "  \"shipDate\": \"2022-04-11T04:23:19.390Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        JSONObject bodyJO = new JSONObject()
                .put("id", 5)
                .put("petId", 1)
                .put("quantity", 1)
                .put("shipDate", "2022-04-11T04:23:19.390Z")
                .put("status", "placed")
                .put("complete", true);

        String id = given()
                .when()
                .contentType(ContentType.JSON)
//                .log().all()
                .body(bodyJO.toString())
                .post("https://petstore.swagger.io/v2/store/order")
                .then()
//                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("id");

        System.out.println(id);
    }

    @Test
    void deleteStoreOrder() {
        given()
                .when()
                .log().all()
                .pathParam("orderId", 5)
                .delete("https://petstore.swagger.io/v2/store/order/{orderId}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void updatePet() {
        String dogsName = "chappi";
        JSONObject bodyJO = new JSONObject()
                .put("id", 5)
                .put("name", dogsName)
                .put("status", "available");


        given()
                .when()
                .contentType(ContentType.JSON)
                .log().all()
                .body(bodyJO.toString())
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .statusCode(200);
    }
}