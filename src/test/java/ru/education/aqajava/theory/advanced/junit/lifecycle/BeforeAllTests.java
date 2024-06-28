package ru.education.aqajava.theory.advanced.junit.lifecycle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BeforeAllTests {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
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
