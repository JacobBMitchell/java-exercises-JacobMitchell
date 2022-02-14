import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise04 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        ArrayList<BoardGame> newGames = new ArrayList<>();

        BoardGame dungeonsAndDragons = new BoardGame("Dungeons and Dragons",2,8,"RPG");
        newGames.add(dungeonsAndDragons);

        BoardGame hanabi = new BoardGame("Hanabi",2,4,"Card Game");
        newGames.add(hanabi);


        BoardGame chess = new BoardGame("Chess",2,2,"Strategy");
        newGames.add(chess);

        System.out.println(newGames);
        games.addAll(newGames);
        System.out.println(games);

        // 1. Instantiate a new ArrayList<BoardGame>.
        // 2. Add three BoardGames to the new list.
        // 3. Print the new list.
        // 4. Add items in the new list to `games` with the `addAll` method.
        // 5. Print `games`.
    }
}
