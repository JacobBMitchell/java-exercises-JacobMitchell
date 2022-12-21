package warmups;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalSubStringTest {

    @Test
    void LPSS() {
        assertEquals("", LongestPalSubString.longestSubPal(""));
        assertEquals("ada", LongestPalSubString.longestSubPal("ada"));
        assertEquals("ada", LongestPalSubString.longestSubPal("bradaf"));
        assertEquals("oooo", LongestPalSubString.longestSubPal("ooooada"));
        assertEquals("oooo", LongestPalSubString.longestSubPal("brooooppadab"));
        assertEquals("racecar", LongestPalSubString.longestSubPal("adapbpracecar"));
        assertEquals("racecar", LongestPalSubString.longestSubPal("racecar"));
        assertEquals("b", LongestPalSubString.longestSubPal("bread"));
        assertEquals("ommo", LongestPalSubString.longestSubPal("commom"));
    }

}