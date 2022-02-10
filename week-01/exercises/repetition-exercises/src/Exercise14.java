import java.util.Scanner;

public class Exercise14 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Give a phrase: ");
        String phrase = console.nextLine();
        // 1. Collect a phrase from a user via the console.
        // 2. Count the number of digits in the phrase.
        int theCount = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (Character.isDigit(phrase.charAt(i))){
                theCount += 1;
            }
        }
        System.out.println(theCount);
        // Hint: Character.isDigit
        // 3. Print the result.
    }
}
