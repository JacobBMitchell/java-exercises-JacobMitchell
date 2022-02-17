public class Exercise07 {

    // 1. Read the reverse JavaDocs.
    // 2. Implement reverse.
    // 3. Create tests for reverse and confirm that it is correct.

    /**
     * Reverses the order of elements in an array argument and returns them in a new array.
     * It does not alter the existing array.
     *
     * @param values the array to reverse
     * @return a new array with elements in reverse order.
     */
    public String[] reverse(String[] values) {
        if (values == null) {
            return null;
        }
        if (values.length == 0) {
            return new String[0];
        }
        String[] reversed = new String[values.length];
        int j = 0;
        for (int i = values.length-1; i >= 0; i--) {
            reversed[j] = values[i];
            j++;

        }
        return reversed;
    }
}
