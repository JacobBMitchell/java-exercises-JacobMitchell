public class ArrayMethods {
    public int[] removeZero(int[] numbers){
        if (numbers == null) {
            return null;
        }
        int max = 0;
        for (int number:numbers){
            if (number != 0){
                max++;
            }
        }
        int[] output = new int[max];
        int j = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0){
                output[j] = numbers[i];
                j++;
            }
        }
        return output;
    }
}
