import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise11 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Swap the 2nd game with the 4th and the 3rd with the 7th.
        System.out.println(games);
        BoardGame temp;
        temp = games.get(1);
        games.remove(1);
        games.add(1,games.get(3-1)); // the remove above changes the index of all the rest to one less
        games.remove(3);
        games.add(3,temp);
        temp = games.get(2);
        games.remove(2);
        games.add(2,games.get(6-1));
        games.remove(6);
        games.add(6,temp);
        System.out.println(games);
        // 2. Print `games` and confirm their order.
    }
}
