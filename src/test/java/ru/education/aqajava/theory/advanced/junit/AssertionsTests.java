package ru.education.aqajava.theory.advanced.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class AssertionsTests {
    /*
     * -----Осветил----
     * assertEquals
     * assertTrue
     * assertAll
     * assertThrows
     * assertTimeout
     * ----Не осветил----
     * assertFalse
     * assertNull
     * assertNotNull
     * assertArrayEquals
     * assertIterableEquals
     * assertLinesMatch
     * assertNotEquals
     * assertSame
     * assertNotSame
     * assertThrowsExactly
     * assertDoesNotThrow
     * assertTimeoutPreemptively
     * assertInstanceOf
     * */
    @Test
    void standardAssertions() {
        // assert на сравнение двух значений
        assertEquals(2, 1 + 1);

        // assert на сравнение двух значений с выводом сообщения в случае, если они не равны
        assertEquals(4, 2 * 2,
                "ожидаемое значение отлично от переданного");
        // assert на сравнение истинности условия
        assertTrue('a' < 'b');

        // assert на сравнение истинности условия с выводом  сообщения в случае ложного условия
        assertTrue('a' < 'b', "условие не истинно");
    }

    @Test
    void groupedAssertions() {
        //Выполнение всех ассертов без прерывания при неудачном одном из них. Репорт о падениях ассертов, если таковые имеются,происходит вместе
        assertAll("operations with numbers",
                () -> assertEquals(3, 2 + 65),
                () -> assertEquals(8, 4 * 5)
        );
    }


    //исключение соответствующего типа не было выброшено.Тест не пройден
    @Test
    public void exceptionDoesntThrown() {
        Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("1");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    //исключение соответствующего типа было выброшено.Тест пройден
    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }


    //assert на выполнение кода в течении заданного периода времени. Если по окончанию таймаута код не выполнился, тогда тест упадет
    @Test
    void timeoutNotExceeded() {

        assertTimeout(ofSeconds(1), () -> {
            TimeUnit.SECONDS.sleep(3);
            // какая-то логика
        });
    }

    //assert на выполнение кода в течении заданного периода времени. Если по окончанию таймаута код выполнился,можно вернуть как-либо значение
    @Test
    void timeoutNotExceededWithResult() {
        String actualResult = assertTimeout(ofSeconds(2), () -> {
            return "java" + " the best";
        });
        assertEquals("java the best", actualResult);
    }

}