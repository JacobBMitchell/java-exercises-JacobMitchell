package warmups;

import java.util.Scanner;

public class Panagram {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Input a message: ");
        String word = scn.nextLine();
        boolean check = isPanagram(word);

        if(check) {
            System.out.println(word + " is a panagram!");
        }else {
            System.out.println(word + " isn't a panagram!");
        }
    }
    //Hi Jodi
    public static boolean isPanagram(String input){
        String toBeChecked = input.toLowerCase();
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k",
            "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (String letter: alphabet){
            if (!toBeChecked.contains(letter)){
                return false;
            }
        }
        return true;

    }
}
