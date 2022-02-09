import java.util.Scanner;

public class Exercise12 {

    public static void main(String[] args) {
        // ARE ORDERED
        // Determine if three numbers are in order.
        Scanner console = new Scanner(System.in);

        System.out.print("Enter the first value: ");
        int first = Integer.parseInt(console.nextLine());

        System.out.print("Enter the second value: ");
        int second = Integer.parseInt(console.nextLine());

        System.out.print("Enter the third value: ");
        int third = Integer.parseInt(console.nextLine());

        // 1. Add decisions statements to determine if first, second, and third are in order.
        if (first > second && second > third){
            System.out.println("Ordered");
        }
        // 2. Print messages for both ordered and unordered cases.
        if (first > second && second < third){
            System.out.println("Swap second and third.");
        }
        else if (first > third && first < second){
            System.out.println("Swap first and second.");
        }
        else if (first < third && first < second){
            System.out.println("Send first to the end.");
        }


    }
}
