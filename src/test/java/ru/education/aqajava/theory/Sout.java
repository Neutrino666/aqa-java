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

        String name = "Irek!";
        String pattern = "Hellooooooooooooooooooooooooooooo %s !!!!!!!!!!!!!!!!!!!!!";

//        System.out.println("asd"+" Sirius "+"dfg");

        System.out.printf(pattern, 4);
//        System.out.println();
//        System.out.println("str1".equals("str1"));
//        System.out.println("str1" == "str1"); // Недопустим
//        System.out.println(12 == 12);

//        System.out.println(pattern.replace("%s", name));

    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
