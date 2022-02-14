public class Exercise15 {

    // 1. Create a new method in the Hero class.
    // Name: toLine
    // Inputs: none
    // Output: String
    // Description: returns the Hero's name and powers as a single line of text.

    public static void main(String[] args) {

        // 2. Instantiate your three favorite super heroes with appropriate powers.
        Hero Spiderman = new Hero("SpiderMan", new Power[]{new Power("Web shooting"),new Power( "Spider Climbing")});
        Hero DrStrange = new Hero("Steven Strange", new Power[]{new Power("Flying"),new Power( "Space")});
        Hero Hulk = new Hero("Bruce Banner", new Power[]{new Power("Strength")});
        // 3. Use the `toLine` method to print each hero's details to the console.
        System.out.println(Spiderman.toLine());
        System.out.println(DrStrange.toLine());
        System.out.println(Hulk.toLine());
    }
}
