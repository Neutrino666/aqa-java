package ru.education.aqajava.tests.lessons.lesson4.JunitAnnotation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #100 has been fixed")
class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
    }

}
