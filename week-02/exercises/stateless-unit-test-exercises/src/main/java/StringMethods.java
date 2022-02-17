import java.util.Arrays;

public class StringMethods {
    public boolean startsWithDayOfWeek(String input){
        return (input.startsWith("Mon") || input.startsWith("Tues") || input.startsWith("Weds") ||
                input.startsWith("Thurs") || input.startsWith("Fri") || input.startsWith("Sat") ||
                input.startsWith("Sun"));
    }

    public boolean containsDayOfWeek(String input){
        return (input.contains("Mon") || input.contains("Tues") || input.contains("Weds") ||
                input.contains("Thurs") || input.contains("Fri") || input.contains("Sat") ||
                input.contains("Sun"));
    }

    public String removeVowelFromBetweenX (String input){
        char[] toRemove = input.toCharArray();
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if (isVowel(toRemove[i])){
                if (i -1 < 0 || i +1 >= input.length()){
                    output += Character.toString(toRemove[i]);
                    continue;
                }
                else if (toRemove[i-1] == 'x' && toRemove[i+1] == 'x'){
                    output += "";
                    continue;
                }
            }
            output += Character.toString(toRemove[i]);

        }
        // if i - 1 >= 0
        // -> if i - 1 == 'x'
        // if i is a vowel
        // if i + 1 < input.length()
        // -> if i + 1 == 'x'
        return output;
    }

    public static boolean isVowel(char c1) {
        char c = Character.toLowerCase(c1);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' ||c == 'u');
    }
}
