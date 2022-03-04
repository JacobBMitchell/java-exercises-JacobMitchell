import java.util.Arrays;

public class MusicConverter {
    private static String[] scale = {"A", "A#","B", "C", "C#", "D", "D#", "E",
            "F","F#", "G", "G#","A", "A#","B", "C"};

    public static void main(String[] args) {
        //Take input
        String input = "A B C L G# C A T L";
        //method -> transcribe the input
        String output = majorThird(input);
        System.out.println(output);
        //{A,#A, B, C, C#...
        //list[i].equals(letter in our input){
        // list[i] = list [i+4]
    }

    private static String majorThird(String input) { //A B C D# F G
        String[] letters = input.split(" ");
        //System.out.println(Arrays.toString(letters));
        String output = "";
        for (String letter: letters){
            boolean valid = false;
            for (int i = 0; i < scale.length; i++){
                if (letter.equalsIgnoreCase(scale[i])){
                    output += scale[i+4];
                    valid = true;
                    break;
                }
            }
            if(!valid) {
                System.out.println("Bad input " + letter);
            }
        }
        return output;
    }
}
