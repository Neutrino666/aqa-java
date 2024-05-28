package ru.education.aqajava.tests.lessons.lesson4;

import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.education.aqajava.tests.lessons.lesson5.BaseTest;
import ru.education.aqajava.tests.lessons.lesson5.apiHelper.Endpoints;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PetStoreParametrizedTest extends BaseTest {


    public static int genRandomNumber() {
        double randomNumber = Math.random() * 10000;
        return (int) randomNumber;
    }

    @ParameterizedTest()
    @ValueSource(strings = {"чапи", "тапи", "папи"})
    void addNewPetToStoreTest(String petsName) {

        JSONObject reqBody = new JSONObject()
                .put("id", genRandomNumber())
                .put("name", petsName)
                .put("status", "available");

        apiHelper.post(Endpoints.NEW_PET, reqBody.toString(), resp200).body().prettyPrint();

    }


    @ParameterizedTest
    @MethodSource("getOrderProp")
    void placeOrderforPetTest(int petId, String status) {

        JSONObject reqBody = new JSONObject()
                .put("petId", petId)
                .put("name", status)
                .put("status", "available");

        apiHelper.post(Endpoints.ORDER, reqBody.toString(), resp200).body().prettyPrint();

    }

    static Stream<Arguments> getOrderProp() {
        return Stream.of(
                arguments(genRandomNumber(), "placed"),
                arguments(genRandomNumber(), "approved"),
                arguments(genRandomNumber(), "placed"));
    }


}
