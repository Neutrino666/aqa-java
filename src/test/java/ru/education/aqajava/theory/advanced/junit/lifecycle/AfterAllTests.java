package ru.education.aqajava.theory.advanced.junit.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class AfterAllTests {
    @AfterAll
    static void afterAll() {
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
