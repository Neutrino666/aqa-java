package ru.education.aqajava.theory;

import org.junit.jupiter.api.Test;

public class Sout {

    @Test
    void sout1() {
        System.out.println("Hello!");
        System.out.println("World!");
    }

    @Test
    void sout2() {
        System.out.print("Hello!");
        System.out.print("World!");
    }

    @Test
    void sout3() {
        String name = "World";
        String pattern = "Hello, %s!";

        System.out.printf(pattern, name);
    }
}
