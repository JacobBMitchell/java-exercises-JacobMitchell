import java.util.Locale;
import java.util.Scanner;

public class RNA { // {a:u, u:a
    //Hello!!!
    //Hey!!
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {

        //String sequence ="aucg";
        System.out.print("Provide your RNA sequence! ");
        String sequence = scn.nextLine();

        sequence = sequence.toLowerCase(Locale.ROOT);
        String encoded = rnaEncode(sequence);
        System.out.println(encoded);
    }

    private static String rnaEncode(String sequence) {
        String result = "";
        for (int i = 0; i < sequence.length(); i++) {
            if ( sequence.charAt(i) == 'a' ) {
                result += "u";
            }
            else if (sequence.charAt(i) == 'u'){
                result += "a";
            }
            else if ( sequence.charAt(i) == 'c' ) {
                result += "g";
            }
            else if ( sequence.charAt(i) == 'g' ) {
                result += "c";
            }
            else {
                System.out.println("Input contains illegal characters! ");
                System.out.println(sequence.charAt(i));
                break;
            }
        }

        return result;
    }


}
