package ru.education.aqajava.advanced.junit.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ParameterizedTests {

    // Параметризация через строки
    @ParameterizedTest
    @ValueSource(strings = {"шалаш", "дом", "мадам"})
    void stringTest(String word) {
        assertTrue(word.contains("д"));
    }

    // Параметризация через числа
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void digitTest(int digit) {
        assertTrue(digit > 0 && digit < 4);
    }

    // Параметризация через метод.
    // Имя метода идентично тестовому
    @ParameterizedTest
    @MethodSource
    void methodSourceTest(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> methodSourceTest() {
        return Stream.of("мясо", "рыба");
    }

    // Параметризация через метод.
    // Имена методов отличаются
    @ParameterizedTest
    @MethodSource("myRangeSource")
    void rangeTest(int argument) {
        assertNotEquals(9, argument);
    }

    static IntStream myRangeSource() {
        return IntStream.range(0, 20).skip(10);
    }

    // Параметризация через метод.
    // Несколько аргументов
    @ParameterizedTest
    @MethodSource("myProvider")
    void moreArgTest(String str, int num, List<String> list) {
        assertEquals(1, str.length());
        assertTrue(num >= 1 && num <= 3);
        assertEquals(2, list.size());
    }

    static Stream<Arguments> myProvider() {
        return Stream.of(
                arguments("mandarin", 1, Arrays.asList("s", "d")),
                arguments("qivi", 3, Arrays.asList("s", "f"))
        );
    }

    // Параметризация через csv-значения
    @ParameterizedTest
    @CsvSource({
            "meat,         4",
            "qivi,         8",
            "'fish',       0xF1",
            "icecreame,    700_000"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }

    // Параметризация через csv-файл
    // csv в папке resources проекта
    @ParameterizedTest
    @CsvFileSource(resources = "/country-reference.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromClasspath(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }

    // Параметризация через csv-файл
    // csv в произвольном месте проекта или os
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/ru/education/aqajava/advanced/junit/parameterized/food-price.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String food, int price) {
        assertNotNull(food);
        assertNotEquals(0, price);
    }
}



