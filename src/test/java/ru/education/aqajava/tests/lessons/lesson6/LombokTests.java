package ru.education.aqajava.tests.lessons.lesson6;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.education.aqajava.tests.lessons.lesson6.models.User;

import static io.restassured.RestAssured.given;


public class LombokTests {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("create user")
    @TmsLink("189")
    void createUserTest() {
        User user = new User();
        user.setId(25);
        user.setUsername("Гена");
        user.setFirstName("Генадий");
        user.setLastName("Трубогиб");
        user.setEmail("gena2025@mail.ru");

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(user)
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200);

        User userActual = given()
                .when()
                .contentType(ContentType.JSON)
                .pathParam("username", user.getUsername())
                .get("https://petstore.swagger.io/v2/user/{username}")
                .then()
                .statusCode(200)
                .extract()
                .as(User.class);

        Assertions.assertEquals(user.getEmail(), userActual.getEmail());
    }

}
