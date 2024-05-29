package ru.education.aqajava.advanced.junit.lifecycle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AfterEachTests {

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach ");
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
