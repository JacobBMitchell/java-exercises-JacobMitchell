import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        String firstName = getStr("What is your first name? ");
        String lastName = getStr("What is your last name? ");
        int cities = Integer.parseInt(getStr("How many cities did you live in? "));
        int instruments = Integer.parseInt(getStr("How many instruments can you play? "));
    }

    private static String getStr(String question) {
        Scanner scn = new Scanner(System.in);
        System.out.print(question);
        return scn.nextLine();
    }
    /* SHORT SURVEY

    Write a program that asks a user four questions and prints the results:
    - What is your first name?
    - What is your last name?
    - How many towns/cities have you lived in?
    - How many musical instruments can you play?

    Store each answer in a variable with an appropriate type.
    Print the results after the user has answered all four questions.

    Use methods to break the program into reusable blocks of code.
     */
}
