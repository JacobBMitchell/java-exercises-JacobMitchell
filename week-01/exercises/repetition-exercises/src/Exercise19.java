import java.util.Scanner;

public class Exercise19 {
    public static void main(String[] args) {
        // INTERLEAVE
        Scanner console = new Scanner(System.in);

        System.out.print("First string: ");
        String first = console.nextLine();

        System.out.print("Second string: ");
        String second = console.nextLine();

        // 1. Write a loop to interleave two strings to form a new string.
        // To interleave, during each loop take one character from the first string and add it to the result
        // and take one character from the second string and add it to the result.
        // If there are no more characters available, don't add characters.
        // 2. Print the result.
        int max = Math.max(first.length(),second.length());
        String mix = "";
        for (int i = 0; i < max; i++) {
            if (i < Math.min(first.length(), second.length())) {
                mix += (Character.toString(first.charAt(i)) + Character.toString(second.charAt(i)));
                continue;
            }
            if (first.length() == max){
                mix += (Character.toString((first.charAt(i))));
            }
            if (second.length() == max){
                mix += (Character.toString((second.charAt(i))));
            }
        }
        System.out.println(mix);

        // Examples
        // "abc", "123" -> "a1b2c3"
        // "cat", "dog" -> "cdaotg"
        // "wonder", "o" -> "woonder"
        // "B", "igstar" -> "Bigstar"
        // "", "huh?" -> "huh?"
        // "wha?", "" -> "wha?"
    }
}
