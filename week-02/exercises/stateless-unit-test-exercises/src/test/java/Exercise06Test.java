import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise06Test {

    Exercise06 instance = new Exercise06();

    // Suggested test additions:
    // shouldBeNullForNulLArg
    // shouldCapitalizeMultipleElements (several scenarios)
    // shouldIgnoreNullElements
    // shouldIgnoreEmptyElements

    @Test
    void shouldCapitalizeOneElement() {
        String[] values = {"lower"};
        String[] expected = {"Lower"};
        String[] actual = instance.capitalizeAll(values);
        assertArrayEquals(expected, actual);

        String[] values1 = {"lower","upper","dog"};
        String[] expected1 = {"Lower","Upper","Dog"};
        String[] actual1 = instance.capitalizeAll(values1);
        assertArrayEquals(expected1, actual1);

        String[] values2 = {"lower",null,"dog"};
        String[] expected2 = {"Lower",null,"Dog"};
        String[] actual2 = instance.capitalizeAll(values2);
        assertArrayEquals(expected2, actual2);

        String[] values3 = {null};
        String[] expected3 = {null};
        String[] actual3 = instance.capitalizeAll(values3);
        assertArrayEquals(expected3, actual3);

        String[] values4 = {"lower","Jacob loves his new dog", "or Does he?"};
        String[] expected4 = {"Lower","Jacob Loves His New Dog", "Or Does He?"};
        String[] actual4 = instance.capitalizeAll(values4);
        assertArrayEquals(expected4, actual4);
    }

    @Test
    void shouldBeEmptyForEmptyArg() {
        assertArrayEquals(new String[0], instance.capitalizeAll(new String[0]));
    }
}