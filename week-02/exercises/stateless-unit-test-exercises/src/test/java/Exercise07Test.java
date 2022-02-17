import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise07Test {

    @Test
    void reverse() {
        Exercise07 inst = new Exercise07();

        String[] input = {};
        String[] expected = {};
        String[] actual = inst.reverse(input);
        assertArrayEquals(expected, actual);

        String[] input1 = null;
        String[] expected1 = null;
        String[] actual1 = inst.reverse(input1);
        assertArrayEquals(expected1, actual1);

        String[] input2 = {"Hi"};
        String[] expected2= {"Hi"};
        String[] actual2 = inst.reverse(input2);
        assertArrayEquals(expected2, actual2);

        String[] input3 = {"Hi","How", "Are you"};
        String[] expected3= {"Are you","How","Hi"};
        String[] actual3 = inst.reverse(input3);
        assertArrayEquals(expected3, actual3);
    }
}