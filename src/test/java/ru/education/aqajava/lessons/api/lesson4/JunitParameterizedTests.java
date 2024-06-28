package ru.education.aqajava.lessons.api.lesson4;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class JunitParameterizedTests {

    @ParameterizedTest
    @ValueSource(strings = {"мясо", "рыба"})
    public void paramsTestExample(String food) {
        System.out.println("Начало теста");
        System.out.println(food);
        System.out.println("Конец теста");
    }

    @ParameterizedTest
    @MethodSource("myArgumentsProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        Assertions.assertEquals(8, str.length());
        Assertions.assertTrue(num >= 1 && num <= 3);
        Assertions.assertEquals(2, list.size());
    }

    static Stream<Arguments> myArgumentsProvider() {
        return Stream.of(
                arguments("John", 1, List.of("s", "d")),
                arguments("David", 3, List.of("s", "f"))
        );
    }

    public static int getNewID() {
        double randomNumber = Math.random() * 10000;
        return (int) randomNumber;
    }

    @ParameterizedTest()
    @ValueSource(strings = {"Барсик", "Васька", "Мурзик"})
    void addNewPetTest(String petsName) {
        JSONObject jsonBody = new JSONObject()
                .put("id", getNewID())
                .put("name", petsName)
                .put("status", "available");

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(jsonBody.toString())
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .prettyPrint();
    }

    @ParameterizedTest
    @MethodSource("getOrderProp")
    void placeOrderForPetTest(int petId, String status) {
        JSONObject jsonBody = new JSONObject()
                .put("petId", petId)
                .put("name", status)
                .put("status", "available");

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(jsonBody.toString())
                .post("https://petstore.swagger.io/v2/store/order")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .prettyPrint();
    }

    static Stream<Arguments> getOrderProp() {
        return Stream.of(
                arguments(getNewID(), "placed"),
                arguments(getNewID(), "approved"),
                arguments(getNewID(), "placed"));
    }

}
