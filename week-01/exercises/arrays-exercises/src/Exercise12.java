import java.util.Arrays;
import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();
        int[][] divided = splitArray(values);
        System.out.println("The positive numbers are: " + Arrays.toString(divided[0]));
        System.out.println("The negative numbers are: " + Arrays.toString(divided[1]));

        // 1. Count the number of positive and non-positive elements in `values`.
        // 2. Create two new int[]s, one for positive elements and one for non-positive.
        // (We count first to determine the capacity to allocate.)
        // 3. Loop through `values` a second time. If an element is positive, add it to the positive array.
        // If it is non-positive, add it to the non-positive array.
        // 4. Confirm that your secondary arrays are properly populated either by debugging or printing their elements.
    }

    private static int[][] splitArray(int[] values) {
        int i = 0, j= 0;
        for(int value:values){
            if(value >= 0){
                i++;
            }
            else{
                j++;
            }
        }
        int[] positive = new int[i];
        int[] negative = new int[j];
        i = 0; j =0;
        for(int value:values){
            if(value >= 0){
                positive[i] = value;
                i++;
            }
            else{
                negative[j] = value;
                j++;
            }
        }
        return new int[][] {positive, negative};
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
