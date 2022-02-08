public class Exercise02 {

    public static void main(String[] args) {

        String[] tenFavoriteFoods = new String[10]; // space for 10 favorite foods

        tenFavoriteFoods[5] = "squid ink";
        tenFavoriteFoods[0] = "lasagna";
        tenFavoriteFoods = new String[]{"Lasagna", "Lobster", "Cookies", "Sushi", "Wings",
                "Cheese", "Steak", "Eel", "Crab", "Pizza"};
        System.out.println(tenFavoriteFoods[5]);
        System.out.println(tenFavoriteFoods[6]);

        // 1. Set your 10 favorite foods. (It's okay to replace squid ink.)
        // 2. Print your top, 6th, and last favorite from tenFavoriteFoods.
        System.out.println(tenFavoriteFoods[0]);
        System.out.println(tenFavoriteFoods[5]);
        System.out.println(tenFavoriteFoods[9]);
    }
}
