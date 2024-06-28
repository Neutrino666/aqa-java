package ru.education.aqajava.theory.advanced.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #100 has been fixed")
class DisabledClassTests {

    @Test
    void testWillBeSkipped() {
    }

}
