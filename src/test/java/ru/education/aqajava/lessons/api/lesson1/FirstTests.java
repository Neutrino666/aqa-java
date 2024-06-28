package ru.education.aqajava.lessons.api.lesson1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstTests {

    @Test
    void printTextTest() {
        System.out.println("Just work");
    }

    @Test
    void simplePositiveTest() {
        Assertions.assertEquals(4, 2 + 2, "Неверная сумма");
    }

    @Test
    void simpleNegativeTest() {
        Assertions.assertEquals(4, 2 + 1, "Неверная сумма");
    }

    @Test
    void varsSumTest() {
        int expectedSum = 2;
        int actualSum = 1 + 1;
        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    void assertTrueExampleTest() {
        int sum = 1 + 1;
        Assertions.assertEquals(2, sum, "Неверная сумма");

        boolean result = (2 == 2);
        Assertions.assertTrue(result, "Неверная сумма");
    }
}
