import java.util.Scanner;

public class Palindromes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("What is your word?: ");
        String word = s.nextLine();
        word = word.replaceAll("\\s","");
        System.out.println(isPalindrome(word));

    }

    public static boolean isPalindrome(String word){
        String holder = "";
        for (int i = word.length()-1; i >= 0; i--) {
            //get charater at i
            //
            holder += String.valueOf(word.charAt(i));
        }

        return (word.equalsIgnoreCase(holder));
    }

}



/*
Take the word in, and flip it, then compare each position at i of the two words

 */

//    Create a method to determine if a string is a palindrome
//    Start with single words (e.g. "madam", "civic", "radar", "kayak", etc.)
//    Increase sophistication from single words to phrases with punctuation