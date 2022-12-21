package warmups;

public class LongestPalSubString {
    public static void main(String[] args) {
        String input = ""; //Icarat
        String output = LPSS(input);
        System.out.println(output);
    }


/*
    LPSS Longest Palindromic sub string
    This function takes a string
    returns a string that is the largest palindrom substring
 */
    public static String LPSS(String input) {
        //edge case for empty strings
        if (input.length() == 0){
            return "";
        }
        String output = "";
        //loops over all letters in the string from left and narrowing to the right
        for (int i = 0; i < input.length(); i++) {
            for (int j = input.length()-1; j > i; j--) {
                //checks for palindrome potential
                if (input.charAt(i) == input.charAt(j)){
                    String sub = input.substring(i,j+1);
                    //checks if the sub string is a palidrome
                    if(palindromeCheck(sub)) {
                        //retains largest palindrome
                        if (sub.length() > output.length()) {
                            output = sub;
                        }
                    }
                }

            }
        }
        if (output.equals("")){
            return input.charAt(0) + "";
        }
        return output;
    }

    //checks to see if a string is a palindrome
    //takes a string
    //returns a boolean if the string is a palindrome
    private static Boolean palindromeCheck(String sub) {
        for (int i = 0; i < sub.length()/2; i++) {
            if (sub.charAt(i) != sub.charAt(sub.length()-i-1)){
                return false;
            }
        }
        return true;

    }
}
