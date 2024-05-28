package ru.education.aqajava.theory;

import org.junit.jupiter.api.Test;

public class LogicalOperators {

    @Test
    public void operatorOR() {
        boolean a;
        boolean b;
        boolean res;

        a = true;
        b = false;
        res = a || b;
        System.out.println(res);

        a = false;
        b = false;
        res = a || b;
        System.out.println(res);

        a = true;
        b = true;
        res = a || b;
        System.out.println(res);
    }

    @Test
    public void operatorAND() {
        boolean a;
        boolean b;
        boolean res;

        a = true;
        b = false;
        res = a && b;

        System.out.println(res);

        a = false;
        b = false;
        res = a && b;
        System.out.println(res);

        a = true;
        b = true;
        res = a && b;
        System.out.println(res);
    }

    @Test
    public void operatorNot() {
        boolean a;
        boolean res;

        a = true;
        res = !a;
        System.out.println(res);

        a = false;
        res = !a;
        System.out.println(res);
    }

}
