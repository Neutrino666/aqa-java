package ru.education.aqajava.tests.lessons.lesson4.JunitAnnotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


//при @TestInstance(TestInstance.Lifecycle.PER_METHOD) для каждого тестого метода создается отдельный класс.Используется по умолчанию
//при @TestInstance(TestInstance.Lifecycle.PER_CLASS) все тестовые методы шарят один объект
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class InstanceLifecycle {

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
