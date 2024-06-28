package ru.education.aqajava.theory.base;

import org.junit.jupiter.api.Test;

public class ComparisonOperators {

    @Test
    public void operatorLess() {
        int a;
        int b;
        boolean res;

        a = 4;
        b = 5;

        res = a < b;
        System.out.println(res);

        res = b < a;
        System.out.println(res);
    }

    @Test
    public void operatorMore() {
        int a;
        int b;
        boolean res;

        a = 4;
        b = 5;

        res = a > b;
        System.out.println(res);

        res = b > a;
        System.out.println(res);
    }

    @Test
    public void operatorEquals() {
        int a;
        int b;
        boolean res;

        a = 4;
        b = 5;
        res = a == b;
        System.out.println(res);

        a = 5;
        b = 5;
        res = a == b;
        System.out.println(res);
    }

    @Test
    public void operatorLessEquals() {
        int a;
        int b;
        boolean res;

        a = 4;
        b = 5;
        res = a <= b;
        System.out.println(res);

        res = b <= a;
        System.out.println(res);
    }

    @Test
    public void operatorMoreEquals() {
        int a;
        int b;
        boolean res;

        a = 4;
        b = 5;
        res = a <= b;
        System.out.println(res);

        res = b <= a;
        System.out.println(res);
    }

    @Test
    public void operatorNotEquals() {
        int a;
        int b;
        boolean res;

        a = 4;
        b = 5;
        res = a != b;
        System.out.println(res);

        a = 5;
        b = 5;
        res = a != b;
        System.out.println(res);
    }

}
