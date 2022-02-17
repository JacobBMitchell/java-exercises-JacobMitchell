import java.util.HashSet;
import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        Random random = new Random();
        HashSet<Integer> numbers = new HashSet<>();
        while (numbers.size() != 10){
            int next = random.nextInt(100);
            numbers.add(next);
        }
        for (int i: numbers){
            System.out.println(i);
        }
//        System.out.println();
//        for(int i: numbers){
//            System.out.println(i);
//        }

        // 1. Generate 10 unique random numbers between 0 and 100.
        // 2. Print the numbers to the console.
        // (Hint: You can add random numbers to the `numbers` HashSet until its size is 10.
        // That guarantees the numbers are unique.)

    }
}
