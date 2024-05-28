package ru.education.aqajava.theory;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Loops {

    @Test
    void forExample1() {

//        int i = i + 1;

        for (int i = 0; i < 10; i += 3) {
            System.out.println(i);
        }
    }

    @Test
    void forExample2() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(i);
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    @Test
    void forExample3() {
        List<String> l = new ArrayList<>();
        l.add("Арсений"); // 0
        l.add("Данила"); // 1

//        List<String> m = List.of("Мясо", "Рис");
//        m.add("asd");

//        System.out.println(l.get(1));

        for (String s : l) {
            System.out.println(s);
        }
//
//        // Вариант через счетчик
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    @Test
    void whileExample() {
        byte i = 0;
        while (i < 3) {
            System.out.println(i);
            i++;
        }
    }

    @Test
    void doWhileExample() {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 3);
    }

    @Test
    void doWhileExample2() {
        boolean taskIsDone;

//        do {
//            taskIsDone = execTaskAndGetStatus();
//            System.out.println("loop");
//        } while (!taskIsDone);

        System.out.println("Task is DONE!");

        // Тот же вариант через while
        taskIsDone = execTaskAndGetStatus();
        while (!taskIsDone) {
            taskIsDone = execTaskAndGetStatus();
        }

//        System.out.println("Task is DONE!");
    }

    private boolean execTaskAndGetStatus() {
        return true;
    }

}
