package ru.education.aqajava.theory.base.oop.cars;

import ru.education.aqajava.theory.base.oop.Car;

public class Truck extends Car {
    String signal = "beep";

    public void beep() {
        System.out.println(signal);
    }

    @Override
    public void go() {

    }

//    public void go() {
//        System.out.println("brbrbrbrrb");
//    }
}
