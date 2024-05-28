package ru.education.aqajava.theory.oop;

public interface Vehicle {

    int wheels = 0;

    default void beep() {
        System.out.println("beep");
    }

    void go();

}
