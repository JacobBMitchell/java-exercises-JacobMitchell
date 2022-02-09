import java.util.Scanner;

public class Exercise16 {

    public static void main(String[] args) {
        // 1. Display the following menu and collect an integer choice from the user.
        // (See Exercise14 for a menu example.)
        //
        // Menu
        // 1. Print the name of an animal.
        // 2. Print the name of a state.
        // 3. Print the name of a beetle.
        // 4. Print the name of a mineral.
        // Select [1-4]:
        //
        // 2. Use a switch to cover cases 1-4 as well as a default.
        // For 1-4, print an animal, state, beetle, or mineral respectively.
        // For the default case, print "Unknown Menu Option".
        Scanner scn = new Scanner(System.in);
        System.out.println(" 1. Print the name of an animal.\n" +
                "         2. Print the name of a state.\n" +
                "         3. Print the name of a beetle.\n" +
                "         4. Print the name of a mineral.");
        System.out.println("select a option 1-4");
        int menu = scn.nextInt();
        switch (menu){
            case 1:
                System.out.println("animal");
            case 2:
                System.out.println("state");
            case 3:
                System.out.println("beetle");
            case 4:
                System.out.println("mineral");
            default:
                System.out.println("Unknown Menu Option");
        }
    }
}
