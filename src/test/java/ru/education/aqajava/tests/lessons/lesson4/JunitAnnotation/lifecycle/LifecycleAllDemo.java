package ru.education.aqajava.tests.lessons.lesson4.JunitAnnotation.lifecycle;

import org.junit.jupiter.api.*;

public class LifecycleAllDemo {

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }


    @Test
    void test1() {
        System.out.println("-> test1");
    }

    @Test
    void test2() {
        System.out.println("-> test2");
    }

    @Test
    void test3() {
        System.out.println("-> test3");
    }

}
