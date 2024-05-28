package ru.education.aqajava.theory;

import org.junit.jupiter.api.Test;

public class IfElse {

    @Test
    public void exampleIfElse() {
        if (2 > 3) {
            System.out.println("Work!");
        }
    }

    @Test
    public void exampleIfElse1() {
        if (false) {
            System.out.println("Work!");
        } else {
            System.out.println("Error!");
        }
    }

    @Test
    public void exampleIfElse2() {
        int a = 1;
        int b = 2;

        if (a == 1) {
            if (a == b) {
                System.out.println("aa");
            } else {
                System.out.println("ab");
            }
        } else {
            if (a == b) {
                System.out.println("bb");
            } else {
                System.out.println("ba");
            }
        }
    }

    @Test
    public void exampleIfElse3() {
        if (1 == 1) {
            if (2 == 2) {
                if (3 == 3) {
                    if (4 == 4) {
                        if (5 == 5) {
                            System.out.println("Work");
                        } // 5
                    } // 4
                } // 3
            } // 2
        } // 1
    }

    @Test
    public void exampleIfElse4() {
        int i = 4;

        if (i == 0) {
            System.out.println("i == 0");
        }

        if (i == 1) {
            System.out.println("i == 1");
        }

        if (i == 2) {
            System.out.println("i == 2");
        }

        if (i == 3) {
            System.out.println("i == 3");
        } else {
            System.out.println("i == ?");
        }
    }

    @Test
    public void exampleSwitch() {
        int i = 2;

        switch (i) {
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                System.out.println("2");
                System.out.println("2");
                System.out.println("2");
                System.out.println("2");
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("?");
        }
    }

    @Test
    public void exampleSwitch2() {
        int i = 0;

        switch (i) {
            case 0:
            case 1:
                System.out.println("0 or 1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("?");
        }
    }
}