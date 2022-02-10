import static java.lang.Character.isWhitespace;

public class Exercise10 {
    public static void main(String[] args) {
        String noWhite = removeWhiteSpace("Hey how are you? ");
        System.out.println(noWhite);
    }

    private static String removeWhiteSpace(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (!isWhitespace(text.charAt(i))){
                result += text.charAt(i);
            }
        }
        return result;
    }
}
    // 1. Add a `main` method.
    // 2. Create method that accepts a String and returns that string with all of its whitespace remove.
    // 2. Call your method in various ways in the main method.

