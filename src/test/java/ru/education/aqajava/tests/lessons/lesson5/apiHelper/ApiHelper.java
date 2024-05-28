package ru.education.aqajava.tests.lessons.lesson5.apiHelper;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    private final String URI = "https://petstore.swagger.io/v2";

    public ApiHelper() {
        RestAssured.baseURI = URI;
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.filters(new AllureRestAssured());
    }

    //GET without path parameters
    @Step("get {endpoint}")
    public Response get(String endpoint, ResponseSpecification resp) {
        return given()
                .contentType(ContentType.JSON)
                .expect()
                .spec(resp)
                .when()
                .get(endpoint);
    }

    //GET with path parameters
    @Step("get {endpoint}")
    public Response get(String endpoint, ResponseSpecification resp, Object... pathParams) {
        return given()
                .contentType(ContentType.JSON)
                .expect()
                .spec(resp)
                .when()
                .get(endpoint, pathParams);
    }

    //GET with query parametres
    @Step("get {endpoint}")
    public Response get(String endpoint, ResponseSpecification resp, Map<String, String> queryParams) {
        return given()
                .params(queryParams)
                .contentType(ContentType.JSON)
                .expect()
                .spec(resp)
                .when()
                .get(endpoint);
    }

    @Step("get {endpoint}")
    public Response getWithAuth(String endpoint, ResponseSpecification resp) {
        return given()
                .header("api_key", "special-key")
                .contentType(ContentType.JSON)
                .expect()
                .spec(resp)
                .when()
                .get(endpoint);
    }

    //POST without path parameters
    @Step("post {endpoint}")
    public Response post(String endpoint, Object body, ResponseSpecification resp) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .expect()
                .spec(resp)
                .when()
                .post(endpoint);
    }

    //POST with path parameters
    @Step("delete {endpoint}")
    public Response delete(String endpoint, ResponseSpecification resp, Object... pathParams) {
        return given()
                .contentType(ContentType.JSON)
                .expect()
                .spec(resp)
                .when()
                .delete(endpoint, pathParams);

    }

    //PUT with path parameters
    @Step("put {endpoint}")
    public Response put(String endpoint, Object body, ResponseSpecification resp, Object... pathParams) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .expect()
                .spec(resp)
                .when()
                .put(endpoint, pathParams);
    }
}
