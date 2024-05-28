package ru.education.aqajava.tests.lessons.lesson1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Introduction {

    @Test
    void printText() {
        System.out.println("Just work");
    }

    @Test
    void checkSum() {
//        printText();
        Assertions.assertEquals(4, 2 + 1, "Неверная сумма");
    }

    @Test
    void checkSum2() {
        int actualSum = 1 + 1;
        Assertions.assertEquals(2, actualSum);
    }

    @Test
    void checkSum3() {
//        int sum = 1 + 1 + 1;
//        Assertions.assertEquals(2, sum, "Неверная сумма");
        Assertions.assertTrue(2==2, "Неверная сумма");
    }

}
