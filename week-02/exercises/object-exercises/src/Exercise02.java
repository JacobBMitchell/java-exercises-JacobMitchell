public class Exercise02 {

    public static void main(String[] args) {

        // 1. Add a getter for the rating field in Musician.

        Musician ocean = new Musician("Frank Ocean", 10);
        System.out.println(ocean.getName());
        // 2. Uncomment the line below and insure that it compiles and runs.
        System.out.println(ocean.getRating());

        // 3. Instantiate two musicians and assign them to new variables.
        Musician paul = new Musician("Paul McCartney", 10);
        Musician lamar = new Musician("Kendrick Lamar", 15);
        // 4. Print each musicians' name and rating on a single line.
        System.out.println(paul.getName()+": "+paul.getRating());
        System.out.println(lamar.getName()+": "+lamar.getRating());
    }
}
