package ru.education.aqajava.theory.advanced.junit.lifecycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeforeEachTests {

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
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


