package ru.education.aqajava.theory.base;

public class Variables {

    void digitVars() {
        // Целочисленные
        byte d1 = 127; // хранит целое число от -128 до 127 и занимает 1 байт
        short d2 = 32767; // хранит целое число от -32768 до 32767 и занимает 2 байта
        int d3 = 2147483647; // хранит целое число от -2147483648 до 2147483647 и занимает 4 байта
        long d4 = 9223372036854775807L; // хранит целое число от –9 223 372 036 854 775 808 до 9 223 372 036 854 775 807 и занимает 8 байт

        // Дробные
        float d5 = 8.5F;
        double d6 = 8.5;
    }

    void charVars() {
        char c = 'd';
    }

    void stringVars() {
        String s = "Work!";
        System.out.println(s);
    }

    void logicVars() {
        boolean b;

        b = true;
        System.out.println(b);

        b = false;
        System.out.println(b);
    }

    void namespace() {
//        public String s1;
//        private String s2;
//        protected String s3;
//
//        static String s4;
//
//        public static String s5;
//
//        final String s6;
//
//        public static final String s7;
    }
}