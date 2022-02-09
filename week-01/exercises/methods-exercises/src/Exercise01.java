public class Exercise01 {

    public static void main(String[] args) {

        String firstCompliment = getRandomCompliment();
        System.out.println(firstCompliment);

        // Call the getRandomCompliment method two more times.
        // 1. Store the result in a new string variable.
        String secondCompliment = getRandomCompliment();
        System.out.println(secondCompliment);
        System.out.println(getRandomCompliment());
        // 2. Print the result.
        // 3. Print the value returned directly without an intermediate variable.
    }

    public static String getRandomCompliment() {

        return switch ((int) (Math.random() * 10)) {
            case 0 -> "Your hard work is inspiring.";
            case 1 -> "Your outfit is cute.";
            case 2 -> "You're a very nice person.";
            case 3 -> "Great attitude. Keep going!";
            case 4 -> "You always know how to put a smile on my face.";
            case 5 -> "Well done!";
            case 6 -> "Excellent job.";
            case 7 -> "Thank you for your kindness.";
            case 8 -> "Bravo.";
            case 9 -> "Really, really great.";
            default -> "";
        };

        // Should never happen.
    }
}
