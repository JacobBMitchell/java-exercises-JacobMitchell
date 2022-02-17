import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMethodsTest {
    ArrayMethods am = new ArrayMethods();

    @Test
    void removeZero() {

        int[] input = {0,1,2,3,0};
        int[] expected = {1,2,3};
        assertArrayEquals(expected,am.removeZero(input));

        int[] input1 = {0,1,2,3,0,5};
        int[] expected1 = {1,2,3,5};
        assertArrayEquals(expected1,am.removeZero(input1));

        int[] input2 = null;
        int[] expected2 = null;
        assertArrayEquals(expected2,am.removeZero(input2));

        int[] input3 = {};
        int[] expected3 = {};
        assertArrayEquals(expected3,am.removeZero(input3));
    }
}