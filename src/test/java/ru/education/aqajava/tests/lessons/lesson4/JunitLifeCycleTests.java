package ru.education.aqajava.tests.lessons.lesson4;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import ru.education.aqajava.tests.lessons.lesson5.structure.tests.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class JunitLifeCycleTests extends BaseTest {

    static final String USERNAME = "Ivanov";
    static final String EMAIL = "ivanov@mail.ru";
    static final String PASSWORD = "abc123";

    static void createUser() {
        JSONObject jsonBody = new JSONObject()
                .put("password", PASSWORD)
                .put("username", USERNAME)
                .put("email", EMAIL);
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(jsonBody.toString())
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200);
    }

    static void deleteUser() {
        given()
                .when()
                .pathParam("username", USERNAME)
                .delete("https://petstore.swagger.io/v2/user/{username}")
                .then()
                .statusCode(200);
    }

    @BeforeAll
    static void beforeAll() {
        createUser();
    }

    @BeforeEach
    void beforeEach() {
        JSONObject jsonBody = new JSONObject().put("email", "ivanov707@mail.ru");
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(jsonBody.toString())
                .pathParam("username", USERNAME)
                .put("https://petstore.swagger.io/v2/user/{username}")
                .then()
                .statusCode(200);
    }

    @Test
    void userLoginPositiveTest() {
        Map<String, String> creds = new HashMap<>();
        creds.put("username", USERNAME);
        creds.put("password", PASSWORD);

        given()
                .when()
                .contentType(ContentType.JSON)
                .get("https://petstore.swagger.io/v2/user/login")
                .then()
                .statusCode(200)
                .body("message", Matchers.containsString("logged in user session"));
    }

    //petstore отвечает 200 на любые креды :(
    @Test
    void userLoginNegativeTest() {
        String wrongUsername = USERNAME + "n";
        String wrongPassword = PASSWORD + ".ru";

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("username", wrongUsername);
        queryParams.put("password", wrongPassword);

        given()
                .when()
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .get("https://petstore.swagger.io/v2/user/login")
                .then()
                .statusCode(401);
    }

    @AfterEach
    void afterEach() {
        JSONObject jsonBody = new JSONObject().put("email", EMAIL);
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(jsonBody.toString())
                .pathParam("username", USERNAME)
                .put("https://petstore.swagger.io/v2/user/{username}")
                .then()
                .statusCode(200);
    }

    @AfterAll
    static void afterAll() {
        deleteUser();
    }

}
