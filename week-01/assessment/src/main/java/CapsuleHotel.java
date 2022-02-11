import java.util.Scanner;

public class CapsuleHotel {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int numberOfRooms;
        while(true) {
            System.out.print("Hello and Welcome to Capsule Hotel! How many rooms do you have? ");
            numberOfRooms = scn.nextInt();
            if(numberOfRooms >= 0){
                System.out.printf("You have created a hotel with %d rooms! \n",numberOfRooms);
                break;
            }
        }
        String[] rooms = new String[numberOfRooms];
        lab1: while(true){
            printMenuOptions();
            System.out.print("Choose an option [1-4]: ");
            int choice = scn.nextInt();
            switch (choice){
                case 1:
                    checkIn(rooms);
                    break;
                case 2:
                    checkOut(rooms);
                    break;
                case 3:
                    viewRooms(rooms);
                    break;
                case 4:
                    break lab1;
                default:
                    continue;
            }
        }
    }

    private static void viewRooms(String[] rooms) {

    }

    private static void checkOut(String[] rooms) {

    }

    private static void checkIn(String[] rooms) {
        System.out.println("What room would you like to check into? ");
        int newRoom = scn.nextInt();

    }

    private static void printMenuOptions() {
        System.out.println("Guest Menu \n ==========");
        System.out.println("1. Check In");
        System.out.println("2. Check Out");
        System.out.println("3. View Guests");
        System.out.println("4. Exit");

    }
}
