import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // USPS
        // Below is an abbreviated version of the US Postal Service retail parcel rates:
        /*
        Lbs | Zones 1&2 | Zone 3
        ===============
        1      $7.50      $7.85
        2       8.25       8.70
        3       8.70       9.70
        4       9.20      10.55
        5      10.20      11.30
        */

        // 1. Collect the parcel lbs and zone (1, 2, or 3) from the user.
        // 2. Add `if`/`else if`/`else` logic to cover all rates.
        // Use whatever strategy you think is best. You can create compound conditions or nest if/else statements.
        // If a lbs/zone combo does not exist, print a warning message for the user.

        Scanner console = new Scanner(System.in);
        System.out.print("How many lbs? ");
        int lbs = console.nextInt();
        System.out.print("What zone? ");
        int zone = console.nextInt();
        if (!(zone == 1 || zone == 2 || zone ==3) || lbs <1 || lbs >5){
            System.out.println("Package not accepted >1 lbs and needs a proper zone");
            main(new String[]{"nan"});
        }
        switch (lbs){
            case 1:
                if (zone == 1 || zone == 2){
                    System.out.println("$7.50");
                }
                else{
                    System.out.println("$7.85");
                }
                break;
            case 2:
                if (zone == 1 || zone == 2){
                    System.out.println("$8.25");
                }
                else{
                    System.out.println("$8.70");
                }
                break;
            case 3:
                if (zone == 1 || zone == 2){
                    System.out.println("$8.70");
                }
                else{
                    System.out.println("$9.70");
                }
                break;
            case 4:
                if (zone == 1 || zone == 2){
                    System.out.println("$9.20");
                }
                else{
                    System.out.println("$10.55");
                }
                break;
            case 5:
                if (zone == 1 || zone == 2){
                    System.out.println("$10.20");
                }
                else{
                    System.out.println("$11.30");
                }
                break;

        }
    }
}
