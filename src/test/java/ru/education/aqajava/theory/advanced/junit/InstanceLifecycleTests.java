package ru.education.aqajava.theory.advanced.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


// При @TestInstance(TestInstance.Lifecycle.PER_METHOD)
// для каждого тестового метода создается отдельный класс.
// Используется по умолчанию

// При @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// все тестовые методы используют один объект
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class InstanceLifecycleTests {

    private int instanceVar = 0;

    @Test
    public void test1() {
        instanceVar += 1;
        System.out.println("test1: " + this + " instanceVar: " + instanceVar);
    }

    @Test
    public void test2() {
        instanceVar += 1;
        System.out.println("test2: " + this + " instanceVar: " + instanceVar);
    }

}
