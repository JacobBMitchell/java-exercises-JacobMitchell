public class Exercise01 {

    public static void main(String[] args) {
        String[] legendaryCreatures = {"fairies", "goblins", "gnomes", "unicorns", "harpies", "solar fish"};
        System.out.println(legendaryCreatures[2]); // third creature - gnomes
        // 1. Print the first, fourth, and sixth creature to the console.
        int[] chosen = {0,3,5};
             for (int item : chosen) {
                 System.out.println(legendaryCreatures[item]);
             }
        {

        }
    }
}
