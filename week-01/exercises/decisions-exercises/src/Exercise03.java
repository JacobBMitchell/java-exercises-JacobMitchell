import java.util.Scanner;

public class Exercise03 {

    public static void main(String[] args) {
        // 1. Change the code to accept input from the user.
        // Use a Scanner and parse the input with Integer.parseInt.
        int value;
        Scanner scn = new Scanner(System.in);
        System.out.print("Pick a number greater than or equal to 10 & less than 26: ");
        value = scn.nextInt();
        if (value >= 10 && value < 26) {
            System.out.println("Value is in the acceptable range.");
        }
    }
}
