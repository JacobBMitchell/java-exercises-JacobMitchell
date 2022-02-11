import java.util.Scanner;

public class RPGInventory {
    public static void main(String[] args) {
        //show intro
        String[] backpack = new String[8];
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to your inventory");
        boolean playing = true;
        do{
            System.out.println("Main Menu");
            System.out.println("1. Add Item\n2. Display Backpack\n3. Exit ");
            System.out.print("Select [1-3]: ");
            String choice = scn.nextLine();
            switch (choice){
                case "1":
                    backpack = addItem(backpack);
                    break;
                case "2":
                    displayBackpack(backpack);
                    break;
                case "3":
                    playing = false;
                    break;
                default:
                    System.out.println("Not a valid input. ");
                    continue;
            }
        }while(playing);
        //goodbye
        System.out.println("Thanks for using backpack... Goodbye");

    }

    private static void displayBackpack(String[] backpack) {
        int i = 1;
        for (String item: backpack){
            System.out.printf("Slot #%d: %s\n",i, backpack[i-1] == null ? "[EMPTY]":item);
            i++;
        }
    }

    private static String[] addItem(String[] backpack) {
        Scanner scn = new Scanner(System.in);
        System.out.print("What do you want to add? ");
        String newItem = scn.nextLine();
        System.out.print("What slot? ");
        int slot = scn.nextInt() -1;
        if (slot < 0 || slot > backpack.length){
            return backpack;
        }
        backpack[slot] = newItem;

        return backpack;
    }
}
