package warmups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Phone {
    private static final String[][] letters = {
            {}, //0
            {}, //1
            {"a","b","c"},//2
            {"d","e","f"},//3
            {"g","h","i"},//4
            {"j","k","l"},//5
            {"m","n","o"},//6
            {"p","q","r","s"},//7
            {"t","u","v"},//8
            {"w","x","y","z"}//9
    };

    private static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) {
        String phoneNumber = "354";
        String[] output = makeWords(phoneNumber);
        System.out.println(Arrays.toString(output));

    }

    private static String[] makeWords(String phoneNumber) {
        ArrayList<Integer> numbers = getNumberForm(phoneNumber);
        ArrayList<String> toSend = new ArrayList<>();
        ArrayList<String> toReturn = getWords(toSend, numbers);
        return (String[]) toReturn.toArray();
    }

    private static ArrayList<String> getWords(ArrayList<String> toSend, ArrayList<Integer> numbers) {
        String[] phoneLetters = letters[numbers.get(0)];
        numbers.remove(0);
        for(String letter: phoneLetters){
            if (numbers.size() != 0) {
                ArrayList<String> words = getWords(toSend, numbers);
                for (int i = 0; i < words.size(); i++) {
                    String temp = words.get(i);
                    temp = letter + temp;
                    words.set(i, temp);
                }
                toSend.addAll(words);
            }
            else {
                toSend.add(letter);
            }
        }
        return toSend;
    }

    private static ArrayList<Integer> getNumberForm(String phoneNumber) {
        String[] phoneNumberDigits = phoneNumber.split("");
        ArrayList<Integer> numbers = new ArrayList<>();
        for(String digit: phoneNumberDigits){
            numbers.add(Integer.parseInt(digit));
        }
        return numbers;
    }

}
