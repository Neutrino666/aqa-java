package ru.education.aqajava.tests.lessons.lesson7;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.education.aqajava.tests.lessons.lesson5.BaseTest;
import ru.education.aqajava.tests.lessons.lesson5.apiHelper.Endpoints;
import ru.education.aqajava.tests.lessons.lesson7.models.User;


public class MoreAutotestsAndLombok extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("create user")
    @TmsLink("189")
    void checkUserCreation() {
        User userReq = new User();
        userReq.setId(25);
        userReq.setUsername("Гена");
        userReq.setFirstName("Генадий");
        userReq.setLastName("Трубогиб");
        userReq.setEmail("gena2025@ma.ru");

        apiHelper.post(Endpoints.USER, userReq, resp200);
        User userActual = apiHelper.get(Endpoints.USERNAME, resp200, userReq.getUsername()).as(User.class);
        Assertions.assertEquals(userReq.getEmail(), userActual.getEmail());

    }

}
