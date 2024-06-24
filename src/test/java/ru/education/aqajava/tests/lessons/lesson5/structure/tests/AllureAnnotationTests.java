package ru.education.aqajava.tests.lessons.lesson5.structure.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.education.aqajava.tests.lessons.lesson5.structure.helpers.Endpoints;

@Epic("Petstore api regression tests")
public class AllureAnnotationTests extends BaseTest {

    @Test
    @DisplayName("Add a new pet to the store")
    @TmsLink("156")
    @Feature("Pets section")
    @Story("create new pet")
    void addNewPetTest() {

        JSONObject jsonBody = new JSONObject()
                .put("id", 0)
                .put("category", new JSONObject().put("name", "birds"))
                .put("name", "Каркуша")
                .put("status", "available");

        apiHelper.post(Endpoints.NEW_PET, jsonBody.toString(), resp200)
                .then()
                .body("$", Matchers.notNullValue());
    }

}
