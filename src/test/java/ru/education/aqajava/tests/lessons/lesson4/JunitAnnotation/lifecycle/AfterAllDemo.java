package ru.education.aqajava.tests.lessons.lesson4.JunitAnnotation.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class AfterAllDemo {

    @AfterAll
    static void beforeAll() {
        System.out.println("AfterAll");
    }

    @Test
    void test1() {
        System.out.println("-> test1");

    }

    @Test
    void test2() {
        System.out.println("-> test2");

    }
}
