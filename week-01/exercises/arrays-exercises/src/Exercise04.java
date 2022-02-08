public class Exercise04 {

    public static void main(String[] args) {
        // 1. Declare an array to hold the names of the world's oceans.
        String[] oceans = {"Atlantic", "Pacific", "Indian", "Arctic"};
        // Set its value using array literal notation.
       /* oceans[0] = "Atlantic";
        oceans[1] = "Pacific";
        oceans[2] = "Indian";
        oceans[3] = "Arctic";*/
        // 2. Loop over each element and print it.
        for (String ocean:oceans){
            System.out.println(ocean);
        }
    }
}
