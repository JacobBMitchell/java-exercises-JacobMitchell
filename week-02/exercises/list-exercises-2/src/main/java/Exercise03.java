import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise03 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        BoardGame dungeonsAndDragons = new BoardGame("Dungeons and Dragons",2,8,"RPG");
        // 1. Add three new games to `games` with the `add` method.
        games.add(dungeonsAndDragons);
        System.out.println(games);
        // 2. Print `games` after each add.
        BoardGame hanabi = new BoardGame("Hanabi",2,4,"Card Game");
        games.add(hanabi);
        System.out.println(games);

        BoardGame chess = new BoardGame("Chess",2,2,"Strategy");
        games.add(chess);
        System.out.println(games);
    }
}
