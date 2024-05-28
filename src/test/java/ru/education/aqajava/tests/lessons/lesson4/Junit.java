package ru.education.aqajava.tests.lessons.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Junit {

//    @ParameterizedTest
//    @ValueSource(strings = {"мясо", "рыба"})
//    public void paramsTestExample(String food) {
//        System.out.println("Начало теста");
//        System.out.println(food);
//        System.out.println("Конец теста");
//    }

    @Test
    @Order(1)
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


    @ParameterizedTest
    @MethodSource("myArgumentsProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        Assertions.assertEquals(8, str.length());
        Assertions.assertTrue(num >= 1 && num <= 3);
        Assertions.assertEquals(2, list.size());
    }

    static Stream<Arguments> myArgumentsProvider() {
        return Stream.of(
                arguments("John", 1, List.of("s", "d")),
                arguments("David", 3, List.of("s", "f"))
        );
    }


}
