public class Exercise06 {

    // 1. Read the capitalizeAll JavaDocs.
    // 2. Implement capitalizeAll.
    // 3. Implement suggestions in Exercise06Test.
    // 4. Confirm implementation correctness by running tests.
    // 5. Stretch Goal: instead of capitalizing the first character of each element, capitalize the first character
    // of each word in each element.

    /**
     * Capitalizes the first character of each element in a String[]
     * and returns the result in a new array.
     * A null argument should return null.
     * An empty array should return a new empty array.
     * Null or empty array elements should be ignored.
     *
     * @param values an array containing elements to capitalize.
     * @return a new String[] with each element capitalized.
     */
    public String[] capitalizeAll(String[] values) {
        if (values == null) {
            return null;
        }
        if (values.length == 0) {
            return new String[0];
        }
        String[] capitalized = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                capitalized[i] = null;
                continue;
            }
            char[] sentence = values[i].toCharArray();
            String upperCaseSentence = "";
//            sentence[0] = Character.toUpperCase(sentence[0]);
//            upperCaseSentence += Character.toString(sentence[0]);
            boolean capNext = true;
            for (int j = 0; j < sentence.length; j++) {
                if (capNext) {
                    sentence[j] = Character.toUpperCase(sentence[j]);
                    capNext = false;
                }
                upperCaseSentence += Character.toString(sentence[j]);
                if (sentence[j] == ' ') {
                    capNext = true;
                }

                capitalized[i] = upperCaseSentence;
            }
        }
        return capitalized;
    }
}
