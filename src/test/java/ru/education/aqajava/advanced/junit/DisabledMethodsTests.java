package ru.education.aqajava.advanced.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DisabledMethodsTests {

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }
}
