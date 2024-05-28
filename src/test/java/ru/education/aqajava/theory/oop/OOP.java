package ru.education.aqajava.theory.oop;

import org.junit.jupiter.api.Test;
import ru.education.aqajava.theory.oop.cars.Jeep;
import ru.education.aqajava.theory.oop.cars.Sedan;
import ru.education.aqajava.theory.oop.cars.Truck;

public class OOP {

    @Test
    void carExample() {
        Sedan car = new Sedan();

        car.setColor("red");

        System.out.println(car.getColor());

        car.go();
    }


    @Test
    void truckExample() {
        Truck truck = new Truck();
        truck.beep();
        truck.go();
    }


    @Test
    void carEquals() {
        Car kia = new Sedan();
        Car dodge = new Jeep();

        System.out.println(kia.equals(dodge));
//        System.out.println(kia == dodge);

//        System.out.println(kia);
//        System.out.println(dodge);
    }

}
