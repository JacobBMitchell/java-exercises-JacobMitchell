package warmups;

public class Clump {
    /*
    Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. Return the number of clumps in the given array.

    countClumps([1, 2, 2, 3, 4, 4]) → 2
    countClumps([1, 1, 2, 1, 1]) → 2
    countClumps([1, 1, 1, 1, 1]) → 1
     */
    public static void main(String[] args) {
        int[] arrs = {1,3,3,3,2};


        int count = getClumps(arrs);
        System.out.println(count);
    }

    private static int getClumps(int[] arrs) {
        int count = 0;
        for(int i = 0; i < arrs.length - 1; i++) {
            boolean isNotLengthOne = false;
            while (i < arrs.length-1 && arrs[i] == arrs[i+1]){
                i++;
                isNotLengthOne = true;
            }
            if (isNotLengthOne) {
                count++;
            }
        }
        return count;
    }

}
