package ru.education.aqajava.theory.base.oop;

public abstract class Car implements Vehicle {

    private final int wheels = 4;
    private String color = "white";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {

        if (color.equals("black") || color.equals("white")) {
            this.color = color;
        }

    }

    public abstract void go();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        Car automobile = (Car) o;

        return color == automobile.color;
    }
}
