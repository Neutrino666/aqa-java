package ru.education.aqajava.tests.lessons.lesson5;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.education.aqajava.tests.lessons.lesson5.apiHelper.Endpoints;

public class ProjectRefactoringAndAllure extends BaseTest {

    @Test
    @DisplayName("Find pet by ID")
    @Description("test for find pet by id")
    @TmsLink("125")
    void findPetByID() {
        String petName = "Каркуша";
        JSONObject reqBody = new JSONObject()
                .put("id", 0)
                .put("category", new JSONObject().put("name", "birds"))
                .put("name", petName)
                .put("status", "available");

        long petId = addNewPetToStore(reqBody.toString(), petName);

        String actualName = apiHelper.get(Endpoints.PET_ID, resp200, petId)
                .jsonPath()
                .getString("name");

        Assertions.assertEquals(petName, actualName, "Ошибка при проверке имени созданного животного");
    }


    @Step("Добавление питомца {petNames} в магазин ")
    long addNewPetToStore(String pet, String petNames) {
        return apiHelper.post(Endpoints.NEW_PET, pet, resp200)
                .jsonPath()
                .getLong("id");
    }

}
