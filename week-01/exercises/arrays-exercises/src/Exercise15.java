import java.util.Arrays;
import java.util.Random;

public class Exercise15 {

    public static void main(String[] args) {
        int[] one = makeRandomArray();
        int[] two = makeRandomArray();
        int[] combo = addToArrays(one, two);
        System.out.println(Arrays.toString(combo));

        // 1. Create a new int[] with room enough for all elements in `one` and `two`.
        // 2. Copy elements from `one` into the beginning of the array.
        // 3. Copy elements from `two` at the end of the array.
        // 4. Print the results to confirm that it worked.
    }

    private static int[] addToArrays(int[] one, int[] two) {
        int[] combo = new int[one.length+two.length];
        for (int i = 0; i < combo.length; i++) {
            if(i < one.length){
                combo[i] = one[i];
            }
            else if (i >= one.length){
                combo[i] = two[i-one.length];
            }
        }
        return combo;

    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }
}
