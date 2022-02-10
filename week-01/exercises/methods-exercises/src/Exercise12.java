import java.util.Scanner;

public class Exercise12 {

    // 1. Create a method.
    // Name: readRequiredString
    // Inputs: String
    // Output: String
    // Description: prompts a user to enter a required string and returns their validated input.
    // The parameter is the message displayed to the user.
    //
    // See the readRequiredString implementation in the methods lesson.
    // You can definitely improve it. Make sure you don't allow blank input. Checking the length() is not enough.

    // 2. Create a method.
    // Name: printNounPhrase
    // Inputs: none
    // Output: none
    // Description: prints an adjective + noun phrase to the console based on user input.
    // Internally, prompts a user for an adjective and a noun with readRequiredString.
    // Concatenates adjective and noun and prints it to the console.

    public static void main(String[] args) {
        // 3. Uncomment the code below and confirm it works.
        Scanner console = new Scanner(System.in);
        System.out.print("Give me a sentence: ");
        String sentence = console.nextLine();
        String myStr = readRequiredString(sentence);
         printNounPhrase();
         printNounPhrase();
         printNounPhrase();
    }

    private static String readRequiredString(String input) {
        Scanner console = new Scanner(System.in);
        if (input.length() != 0){
            do {
                System.out.print("Give me a sentence");
                input = console.nextLine();
            } while (input.length() == 0);
        }
        return input;
    }

    private static void printNounPhrase() {
        Scanner console = new Scanner(System.in);
        System.out.println("Give noun: ");
        String noun = console.nextLine();
        System.out.println("Give adjective: ");
        String adj = console.nextLine();
        System.out.println(adj + noun);
    }
}
