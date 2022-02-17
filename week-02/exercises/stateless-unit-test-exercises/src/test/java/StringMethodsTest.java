import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodsTest {
    StringMethods sm = new StringMethods();

    @Test
    void startsWithDayOfWeek() {
        assertTrue(sm.startsWithDayOfWeek("Monday"));
        assertFalse(sm.startsWithDayOfWeek("SoMonday"));
        assertTrue(sm.startsWithDayOfWeek("Fri french fri"));
        assertFalse(sm.startsWithDayOfWeek("mondey"));
    }

    @Test
    void containsDayOfWeek() {
        assertTrue(sm.containsDayOfWeek("wow it is Mon didnt you know"));
        assertFalse(sm.containsDayOfWeek("wow it is mn didnt you know"));
        assertTrue(sm.containsDayOfWeek("wow it is didTuesnt you know"));
        assertFalse(sm.containsDayOfWeek("wow it is mon didnt you know"));
    }

    @Test
    void removeVowelFromBetweenX() {
        assertEquals("xx",sm.removeVowelFromBetweenX("xox"));
        assertEquals("onexxx",sm.removeVowelFromBetweenX("onexexx"));
        assertEquals("xerrex",sm.removeVowelFromBetweenX("xerrex"));
        assertEquals("xxxxxx",sm.removeVowelFromBetweenX("xuxxuxxux"));

    }

    @Test
    void isVowel() {
        char letter = 'A';
        assertTrue(StringMethods.isVowel(letter));
//        System.out.println(letter);
        assertFalse(StringMethods.isVowel('b'));
    }
}