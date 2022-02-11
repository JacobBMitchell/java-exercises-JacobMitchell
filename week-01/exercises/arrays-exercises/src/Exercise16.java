import java.util.Arrays;
import java.util.Random;

public class Exercise16 {

    public static void main(String[] args) {
        // MERGE
        int[] one = makeRandomAscendingArray();
        int[] two = makeRandomAscendingArray();
        int[] merge = mergeAndSort(one, two);
        System.out.println(Arrays.toString(merge));
        Planet[] planets = new Planet[3];
        planets[0] = new Planet(30);
        planets[1] = new Planet(31);
        planets[2] = new Planet(35);

        for (Planet planet: planets){
            System.out.println(planet.mass);
        }

        // makeRandomAscendingArray creates a random array with a capacity between 50 and 150.
        // Its elements are guaranteed to be sorted ascending.
        // 1. Create a new int[] with capacity for all elements from `one` and `two`.
        // 2. "Merge" elements from `one` and `two` into the new array so that its values are sorted.

         /* Pseudocode:
         Create an integer index for `one`, `two`, and the result array, all starting at 0.
         Loop resultIndex from 0 to result.length - 1:
           if one[oneIndex] is less than two[twoIndex], add it to the result and increment oneIndex.
           if two[twoIndex] is less than one[oneIndex], add it to the result and increment twoIndex.
           determine how to settle ties
           if oneIndex >= one.length, there are no `one` elements remaining so use elements from two
           if twoIndex >= two.length, there are no `two` elements remaining so use elements from one
          */
    }

    private static int[] mergeAndSort(int[] one, int[] two) {
        int[] combo = new int[one.length+two.length];
        int j = 0;
        for (int i = 0; i < 2*Math.min(one.length,two.length); i+= 2) {
            if(one[j]>=two[j]){
                combo[i] = one[j];
                combo[i+1] = two[j];
            }
            else if(one[j]<two[j]){
                combo[i] = two[j];
                combo[i+1] = one[j];
            }
            j++;
        }
        for (int i = 2*j; i< combo.length; i++){
            if (one.length > two.length){
                combo[i] = one[j];
            }
            else if (two.length > one.length){
                combo[i] = two[j];
            }
            j++;
        }

        return combo;
    }

    public static int[] makeRandomAscendingArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        int current = random.nextInt(11);
        for (int i = 0; i < result.length; i++) {
            result[i] = current;
            current += random.nextInt(4);
        }
        return result;
    }
}
