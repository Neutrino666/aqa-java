package ru.education.aqajava.theory.base;

import org.junit.jupiter.api.Test;

public class TryCatch {

    @Test
    void errorExample() {
        int oops;
        oops = 5 / 0;
        System.out.println(oops);
    }

    @Test
    void simpleTryCatch() {
        int oops = 0;

        try {
            oops = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
//            System.out.println("Ащибка");
        }
        System.out.println(oops);
    }

    @Test
    void simpleTryCatchWithComments() {
        int oops;

        try {
            System.out.println("Попытка деления.");
            oops = 5 / 0;
            System.out.println("Поделили");
        } catch (ArithmeticException e) {
            System.out.println("Обнаружено деление на ноль");
            oops = 0;
            System.out.println(e.getMessage());
        }
        System.out.println(oops);
    }

    @Test
    void finallyExample() {
        int oops = 0;

        try {
            System.out.println("Попытка деления.");
            oops = 5 / 0;
            System.out.println("Поделили");
        } catch (ArithmeticException e) {
            System.out.println("Обнаружено деление на ноль");
        } finally {
            System.out.println("Очищаем ресурсы");
        }

        System.out.println(oops);
    }

    private int div(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Попытка деления на ноль");
        }
        return a / b;
    }

    @Test
    void throwExample() {
        // Проброс исключений сложная тема для изучения.
        // Возможно в рамках курса и не стоит давать.
        int res = div(5, 0); // ??? Требуется консультация
        System.out.println(res);
    }
}