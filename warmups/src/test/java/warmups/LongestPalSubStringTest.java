package warmups;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalSubStringTest {

    @Test
    void LPSS() {
        assertEquals("", LongestPalSubString.LPSS(""));
        assertEquals("ada", LongestPalSubString.LPSS("ada"));
        assertEquals("ada", LongestPalSubString.LPSS("bradaf"));
        assertEquals("oooo", LongestPalSubString.LPSS("ooooada"));
        assertEquals("oooo", LongestPalSubString.LPSS("brooooppadab"));
        assertEquals("racecar", LongestPalSubString.LPSS("adapbpracecar"));
        assertEquals("racecar", LongestPalSubString.LPSS("racecar"));
        assertEquals("b", LongestPalSubString.LPSS("bread"));
        assertEquals("ommo", LongestPalSubString.LPSS("commom"));
    }

}