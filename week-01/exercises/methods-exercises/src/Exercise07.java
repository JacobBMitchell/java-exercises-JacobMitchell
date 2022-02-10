public class Exercise07 {

    // 1. Create a method.
    // Name: areInOrder
    // Inputs: int, int, int, int
    // Output: boolean
    // Description: return true if the four parameters are in ascending order.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        boolean ordercheck = areInOrder(1,2,3,4);
    }

    private static boolean areInOrder(int first, int second, int third, int fourth) {
        return (first < second && second < third && third < fourth);
    }
}
