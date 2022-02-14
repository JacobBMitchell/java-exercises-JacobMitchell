import java.util.Scanner;

public class Exercise04 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // 1. Add an empty constructor to Musician.
        // 2. Uncomment the code below and make sure it runs.
        boolean running = true;
        while(running) {
            Musician m = new Musician();
            System.out.print("Musician name:");
            m.setName(console.nextLine());
            System.out.print("Musician rating:");
            int rating = Integer.parseInt(console.nextLine());
            m.setRating(rating);
            System.out.printf("%s: %s%n", m.getName(), m.getRating());
            System.out.println("Continue? [yes]/[end]");
            String end = console.nextLine();
            if (end.equalsIgnoreCase("end")){
                running = false;
            }
        }
        // 3. Add a loop. The exercise should ask the user for musicians and print
        // them out until the user types "end".
    }
}
