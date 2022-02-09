import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Pick a minimum: ");
        int min = scn.nextInt();
        System.out.print("Pick a max: ");
        int max = scn.nextInt();
        System.out.println("Pick in between: ");
        int guess = scn.nextInt();

        if (guess >min && guess<max){
            System.out.println("The guess is between the two given numbers.");
        }
        else{
            System.out.println("The guess fails to be between the two given numbers.");
        }
    }
}
