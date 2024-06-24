package ru.education.aqajava.advanced.junit;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.Random.class)
public class OrderedTests {

    @Test
    @Order(5)
    void test1() {
        System.out.println("test1");
    }

    @Test
    @Order(2)
    void test2() {
        System.out.println("test2");
    }

    @Test
    @Order(3)
    void test3() {
        System.out.println("test3");
    }

    @Test
    @Order(4)
    void test4() {
        System.out.println("test4");
    }
}
