public class Exercise06 {

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static void main(String[] args) {
        boolean between = isBetween(3,2,5);
        System.out.println(between);
    }

    private static boolean isBetween(int mid, int low, int high) {
        return (low < mid && mid < high);
    }
}
