import java.util.Scanner;

public class Exercise14 {

    public static void main(String[] args) {
        // DAYS OF THE WEEK
        Scanner console = new Scanner(System.in);

        System.out.println("1. Monday");
        System.out.println("2. Tuesday");
        System.out.println("3. Wednesday");
        System.out.println("4. Thursday");
        System.out.println("5. Friday");
        System.out.println("6. Saturday");
        System.out.println("7. Sunday");
        System.out.print("Select a day [1-7]: ");

        int day = Integer.parseInt(console.nextLine());

        // 1. Add cases for days 2-7. Print a tired cliché for each day.
        switch (day) {
            case 1:
                System.out.println("I refuse to say \"a case of the Mondays\".");
                break;
            case 2:
                System.out.println("I refuse to say \"the club is going up on a Tuesday\".");
                break;
            case 3:
                System.out.println("I refuse to say \"Hump day\".");
                break;
            case 4:
                System.out.println("I refuse to say \"sorry Honey its Thursday\".");
                break;
            case 5:
                System.out.println("I refuse to say \"TGIF\".");
                break;
            case 6:
                System.out.println("I refuse to say \"Saturday's are for the boys\".");
                break;
            case 7:
                System.out.println("I refuse to say \"Pray\".");
                break;
            default:
                System.out.println("I don't recognize that day.");
                break;
        }
    }
}
