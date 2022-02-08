public class Exercise05 {

    public static void main(String[] args) {
        // 1. Declare an array to hold the names of the world's continents.
        String[] continents = new String[7];
        // Do not use array literal notation. Allocate space for 6 continents and then set each value by index.
        continents[0] = "North America";
        continents[1] = "South America";
        continents[2] = "Europe";
        continents[3] = "Africa";
        continents[4] = "Asia";
        continents[5] = "Australia";
        continents[6] = "Antarctica";
        // 2. Loop over each element and print it.
        for (int i = 0; i < continents.length; i++) {
            System.out.println(continents[i]);

        }
    }
}
