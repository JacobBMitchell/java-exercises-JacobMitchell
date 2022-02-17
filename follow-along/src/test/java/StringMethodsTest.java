import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodsTest {

    @Test
    void countDigits() {
        int expected = 0;
        int actual = StringMethods.countDigits(null);
        // A null string should return 0 counted digits.
        assertEquals(expected,actual);

        actual = StringMethods.countDigits("");
        assertEquals(expected,actual);

        actual = StringMethods.countDigits("There are no digits in this string.");
        assertEquals(actual,expected);

        expected = 1;
        actual = StringMethods.countDigits("5");
        // The string "5" should return 1 counted digit.
        assertEquals(expected, actual);

        expected = 2;
        actual = StringMethods.countDigits("There are 12 sandwiches.");
        // "There are 12 sandwiches." should return 2 counted digits.
        assertEquals(expected, actual);

        expected = 5;
        actual = StringMethods.countDigits("Th3re are 5, dig1ts in 7his sentence! :0");
        assertEquals(expected,actual);
    }
}