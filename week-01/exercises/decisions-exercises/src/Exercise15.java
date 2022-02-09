import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        // SWITCH OPPOSITES
        // Given a word, print its opposite using a switch statement.
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = console.nextLine();
        String opposite = null;

        // 1. Re-implement Exercise08 using a switch statement.
        switch (word){
            case "Hot":
                opposite = "cold";
                break;
            case "Love":
                opposite = "hate";
                break;
            default:
                System.out.println("Not in here");
        }
        System.out.println("The opposite of "+word+ "is" + opposite);
    }
}
