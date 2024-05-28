package ru.education.aqajava.tests.lessons.lesson4.JunitAnnotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

class AssumptionsDemo {

    // прерывает выполнение теста,если условие не истинно. В этом случае тест помечается как Aborted
    @Test
    void assumeTrueTest() {
        assumeTrue("Windows_NT".equals(System.getenv("OS")),
                "Aborting test");
        System.out.println("it is work");
    }

    @Test
    void assumeFalseTest() {
        assumeFalse("Linux".equals(System.getenv("OS")),
                "Aborting test");
        System.out.println("it is work");
    }

    // позволяет выполнить определенный участок кода, в зависимости от условия. Не прерывает выполнение теста
    @Test
    void testInAllOS() {
        assumingThat("Windows_NT".equals(System.getenv("OS")),
                () -> {
                    assertEquals(2, 3 - 1);
                    System.out.println("2");
                });


        assertEquals(40, 5 * 8);
        System.out.println("40");
    }
}
