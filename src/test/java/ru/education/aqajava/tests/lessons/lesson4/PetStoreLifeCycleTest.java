package ru.education.aqajava.tests.lessons.lesson4;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import ru.education.aqajava.tests.lessons.lesson5.BaseTest;
import ru.education.aqajava.tests.lessons.lesson5.apiHelper.Endpoints;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PetStoreLifeCycleTest extends BaseTest {

    final String USERNAME = "Stepa";
    final String EMAIL = "stepa@mail.ru";
    final String PASSWORD = "abc123";

    @BeforeAll
    void beforeAll() {
        createUser();
    }

    @BeforeEach
    void beforeeach() {
        JSONObject reqBody = new JSONObject().put("email", "stepa707@mail.ru");
        apiHelper.put(Endpoints.USERNAME, reqBody.toString(), resp200, USERNAME);

    }

    @Test
    void userLoginPositiveTest() {
        Map<String, String> creds = new HashMap<>();
        creds.put("username", USERNAME);
        creds.put("password", PASSWORD);

        apiHelper.get(Endpoints.USER_LOGIN, resp200, creds).then()
                .body("message", Matchers.containsString("logged in user session"));


    }

    //petstore отвечает 200 на любые креды :(
    @Test
    void userLoginNegativeTest() {

        String wrongUsername = USERNAME + "n";
        String wrongPassword = PASSWORD + ".ru";

        Map<String, String> wrongCreds = new HashMap<>();
        wrongCreds.put("username", wrongUsername);
        wrongCreds.put("password", wrongPassword);

        apiHelper.get(Endpoints.USER_LOGIN, resp401, wrongCreds).then();
    }

    @AfterEach
    void afterEach() {
        JSONObject reqBody = new JSONObject().put("email", EMAIL);
        apiHelper.put(Endpoints.USERNAME, reqBody.toString(), resp200, USERNAME);
    }

    @AfterAll
    void afterAll() {
        deleteUser();
    }


    void createUser() {
        JSONObject reqBody = new JSONObject()
                .put("password", PASSWORD)
                .put("username", USERNAME)
                .put("email", EMAIL);
        apiHelper.post(Endpoints.USER, reqBody.toString(), resp200);
    }

    void deleteUser() {
        apiHelper.delete(Endpoints.USERNAME, resp200, USERNAME);
    }
}
