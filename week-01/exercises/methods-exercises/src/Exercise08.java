public class Exercise08 {

    // 1. Create a method.
    // Name: getRandomFruit
    // Inputs: none
    // Output: String
    // Description: returns a random fruit name as a string.
    // See Exercise01.
    // Choose from at least 5 fruit.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        String fruit = getRandomFruit();
        System.out.println(fruit);
    }

    private static String getRandomFruit() {
        String base = "";
        int randInt = (int) (Math.random()*5 +1);
        switch (randInt){
            case 1:
                base = "Watermelon";
                break;
            case 2:
                base = "Apple";
                break;
            case 3:
                base = "Lemon";
                break;
            case 4:
                base = "Cherry";
                break;
            case 5:
                base = "Pomegranate";
                break;
        }
        return base;
    }
}
