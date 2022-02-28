import java.util.Scanner;

public class CapsuleHotel {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        //Create primary string array this application is based on
        int numberOfRooms;
        while(true) {
            System.out.print("Hello and Welcome to Capsule Hotel!\nHow many rooms do you have? ");
            numberOfRooms = scn.nextInt();
            if(numberOfRooms >= 0){
                System.out.printf("You have created a hotel with %d rooms! \n",numberOfRooms);
                break;
            }
        }
        String[] rooms = new String[numberOfRooms];

        //Main for loop that allows for application to run
        boolean running = true;
        while(running){
            printMenuOptions();
            System.out.print("Choose an option [1-4]: "); // hi
            int choice = scn.nextInt();
            scn.nextLine();
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
                    System.out.print("Are you sure you want to leave?\nAll data will be lost?[y/n] ");
                    String quit = scn.nextLine();
                    if (quit.equalsIgnoreCase("y")) {
                        running = false; //equivalent to having a running boolean and setting it to false
                    }
                    break;

                default:
                    System.out.println("This isn't a valid input! ");


            }
        }
    }

    private static void viewRooms(String[] rooms) {
        //determine if input is valid
        int selectedRoom = Integer.MIN_VALUE;
        while ((selectedRoom >= rooms.length || selectedRoom < 1)){
            System.out.print("Please select a room about which to view ");
            selectedRoom = scn.nextInt();
            scn.nextLine();
            if (selectedRoom <= rooms.length && selectedRoom > 1){
                break;
            }
        }
        //Display room logic

        for (int i = selectedRoom -5; i < selectedRoom + 6 ; i++) {
            if (i > rooms.length){
                int roomIndex = i -rooms.length-1;
                System.out.printf("Room %d: %s\n",i-rooms.length,
                        rooms[roomIndex] == null ? "Empty":rooms[roomIndex]);
            }
            else if (i <= 0){
                int roomIndex = rooms.length +i -1;
                System.out.printf("Room %d: %s\n",i+rooms.length,
                        rooms[roomIndex] == null ? "Empty":rooms[roomIndex]);
            }
            else {
                System.out.printf("Room %d: %s\n", i,
                        rooms[i - 1] == null ? "Empty" : rooms[i - 1]);
            }
        }
    }

    private static void checkOut(String[] rooms) {
        //check if all rooms are empty
        int counter = 0;
        for (String room: rooms){
            if (room == null){
                counter += 1;
            }
        }
        if (counter == rooms.length){
            System.out.println("There is no one in any rooms.");
            return;
        }
        //ask for valid room number
        int exitRoom = Integer.MIN_VALUE; boolean isValid = false;
        while ((exitRoom > rooms.length || exitRoom < 1) || !isValid){
            System.out.print("Please select a room to check out of. ");
            exitRoom = scn.nextInt();
            scn.nextLine();
            if (exitRoom <= rooms.length && exitRoom >= 1){
                if(rooms[exitRoom-1] != null){
                    isValid = true;
                }
                else {
                    System.out.println("Sorry no one is in that room. ");
                }
            }
        }
        //check if room is occupied
        //set room value to null
        System.out.println(rooms[exitRoom-1] + " has been checked out.");
        rooms[exitRoom-1] = null;
    }

    private static void checkIn(String[] rooms) {
        int counter = 0;
        for (String room: rooms){
            if (room != null){
                counter++;
            }
        }
        if (counter == rooms.length){
            System.out.println("All rooms are booked.");
            return;
        }
        //in a loop ask for valid input
        int newRoom = Integer.MIN_VALUE; boolean isValid = false;
        while ((newRoom > rooms.length || newRoom < 1) || !isValid){
            System.out.print("Please select a room to check into! ");
            newRoom = scn.nextInt();
            scn.nextLine();
            if (newRoom <= rooms.length && newRoom >= 1){
                if(rooms[newRoom-1] == null){
                    isValid = true;
                }
                else {
                    System.out.println("This room is occupied!");
                }
            }
        }
        System.out.print("What is the name of the guest? ");
        String name = scn.nextLine();
        System.out.println( name + "has been booked for room: "+ newRoom);
        rooms[newRoom-1] = name;

        //ask for name
        //add name to hotel

    }

    private static void printMenuOptions() { //menu options
        System.out.println("Guest Menu \n==========");
        System.out.println("1. Check In");
        System.out.println("2. Check Out");
        System.out.println("3. View Guests");
        System.out.println("4. Exit");

    }
}
