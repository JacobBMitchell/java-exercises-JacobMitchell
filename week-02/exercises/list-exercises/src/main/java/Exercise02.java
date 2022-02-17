import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise02 { //reload pom.xml file through maven to fix the error I was having!!!!

    // 1. Create a method to print all BoardGames in an ArrayList<BoardGame>.
    // Consider making it `public` so you can use it in other exercises.

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        printAll(games);

        // 2. Print `games` using your "print all" method.
    }

    private static void printAll(ArrayList<BoardGame> games) {
        for (BoardGame game : games) {
            System.out.println(game.getName());

        }
//        for (int i = 0; i < games.size(); i++) {
//            System.out.println(games.get(i).getName());
//
//        }
    }
}
