package ru.education.aqajava.tests.lessons.lesson3;

import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestTests {

    @Test
    void checkSoldItem() {
        given()
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then()
                .statusCode(200)
                .body("$", Matchers.hasKey("sold"))
                .body("sold", Matchers.notNullValue());
    }

    @Test
    void checkSoldItem2() {
        JsonPath jsonPath = given()
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath();

        Assertions.assertNotNull(jsonPath.getString("sold"));
    }

    @Test
    void hamcrestExamples() {
        // Сравнение
        assertThat("word", Matchers.equalTo("word"));

        // Содержит подстроку
        assertThat("wordpress", Matchers.containsString("word"));

        // Логическое И
        assertThat("wordpress", Matchers.allOf(
                Matchers.containsString("word"),
                Matchers.containsString("press")));

        // Логическое ИЛИ
        assertThat("wordpress", Matchers.anyOf(
                Matchers.containsString("word"),
                Matchers.containsString("paper")));
    }
}
