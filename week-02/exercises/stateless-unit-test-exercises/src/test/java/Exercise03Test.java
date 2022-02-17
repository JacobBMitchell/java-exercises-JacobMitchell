import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise03Test {

    @Test
    void hasAllVowels() {
        assertTrue(Exercise03.hasAllVowels("aeiou"));
        assertTrue(Exercise03.hasAllVowels("AeIoU"));
        assertFalse(Exercise03.hasAllVowels("Aeio"));
        assertFalse(Exercise03.hasAllVowels("Jacob B Mitchell"));
        assertTrue(Exercise03.hasAllVowels("ae javob o uaa jaco i"));
    }
}