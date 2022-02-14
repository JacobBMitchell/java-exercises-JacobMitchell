import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise12 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        System.out.println(games);
        for (int i = 0; i < 2; i++) {
            BoardGame temp = games.get(0);
            games.add(temp);
            games.remove(0);
        }

        System.out.println(games);
        // 1. Shift all games two positions to the left. A game at index 0 "shifts" to the end of the list.
        // Example: A,B,C,D,E -> shifted two positions is -> C,D,E,A,B
        // 2. Print `games` and confirm the new order.
    }
}
