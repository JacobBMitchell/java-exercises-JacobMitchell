import java.util.Scanner;

public class KnockKnock {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        System.out.print("Do you want to hear a Knock Knock Joke? ");
        String answer = prompt.nextLine();
        boolean hearJoke = true;
        while (hearJoke) {
            if (answer.equalsIgnoreCase("yes 1")) {
                System.out.println("Knock Knock");
                while (!prompt.nextLine().equalsIgnoreCase("who's there")) {
                    System.out.println("try again");
                }
                String setup = "yodelay";
                System.out.println(setup);
                while (!prompt.nextLine().equalsIgnoreCase(setup + " who")) {
                    System.out.println("try again");
                }
                System.out.println("Yodelayeeehooo");

            }

            if (answer.equalsIgnoreCase("yes 2")) {
                System.out.println("Knock Knock");
                while (!prompt.nextLine().equalsIgnoreCase("who's there")) {
                    System.out.println("try again");
                }
                String setup = "yodelay";
                System.out.println(setup);
                while (!prompt.nextLine().equalsIgnoreCase(setup + " who")) {
                    System.out.println("try again");
                }
                System.out.println("Yodelayeeehooo");
            }

            if (answer.equalsIgnoreCase("yes 3")) {
                System.out.println("Knock Knock");
                while (!prompt.nextLine().equalsIgnoreCase("who's there")) {
                    System.out.println("try again");
                }
                String setup = "yodelay";
                System.out.println(setup);
                while (!prompt.nextLine().equalsIgnoreCase(setup + " who")) {
                    System.out.println("try again");
                }
                System.out.println("Yodelayeeehooo");
            }
            System.out.println("Do you want to hear another? ");
            String again =prompt.nextLine();
            if (!again.equalsIgnoreCase("yes")){
                 hearJoke = false;
            }
        }
    }

}
