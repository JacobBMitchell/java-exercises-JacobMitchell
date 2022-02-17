import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise05Test {

    @Test
    void isWithinFiveOfAHundred() {
        Exercise05 inst = new Exercise05();
        assertTrue(inst.isWithinFiveOfAHundred(98));
        assertTrue(inst.isWithinFiveOfAHundred(205));
        assertFalse(inst.isWithinFiveOfAHundred(3045));
        assertFalse(inst.isWithinFiveOfAHundred(6));
        assertFalse(inst.isWithinFiveOfAHundred(294));
        assertTrue(inst.isWithinFiveOfAHundred(-99));
        assertTrue(inst.isWithinFiveOfAHundred(-296));
        assertTrue(inst.isWithinFiveOfAHundred(-4000));
        assertTrue(inst.isWithinFiveOfAHundred(995));
    }
}