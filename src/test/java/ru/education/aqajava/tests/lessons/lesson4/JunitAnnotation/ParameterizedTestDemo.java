package ru.education.aqajava.tests.lessons.lesson4.JunitAnnotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ParameterizedTestDemo {

    //использование строки, в качестве аргумента тестовой функции
    @ParameterizedTest
    @ValueSource(strings = {"шалаш", "дом", "мадам"})
    void palindromes(String candidate) {
        assertTrue(StringUtils.isPalindrome(candidate));
    }

    //использование целого числа, в качестве аргумента тестовой функции
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }


    //использование возвращающегося значения метода, в качестве аргумента тестовой функции. Название метода идентично тестовому
    @ParameterizedTest
    @MethodSource
    void testWithDefaultLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> testWithDefaultLocalMethodSource() {
        return Stream.of("мясо", "рыба");
    }

    //использование возвращающегося значения метода, в качестве аргумента тестовой функции. Название метода отлично от тестового
    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        assertNotEquals(9, argument);
    }

    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }

    //использование возвращающегося значения метода, в качестве аргументов тестовой функции. Метод возвращает несколько значении
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(1, str.length());
        assertTrue(num >= 1 && num <= 3);
        assertEquals(2, list.size());
    }


    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("mandarin", 1, Arrays.asList("s", "d")),
                arguments("qivi", 3, Arrays.asList("s", "f"))
        );
    }


    //использование csv значении, в качестве аргументов тестового метода
    @ParameterizedTest
    @CsvSource({
            "meat,        4",
            "qivi,        8",
            "'fish',       0xF1",
            "icecreame,    700_000"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }

    //использование csv значении, в качестве аргументов тестовой функции. Набор значении задается файлом с расшерением .csv в папке resources проекта
    @ParameterizedTest
    @CsvFileSource(resources = "/country-reference.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromClasspath(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }

    //использование csv значении, в качестве аргументов тестовой функции. Набор значении задается файлом с расшерением .csv в произвольном месте проекта
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/ru/education/aqajava/tests/lessons/lesson4/food-price.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String food, int price) {
        assertNotNull(food);
        assertNotEquals(0, price);
    }
}



