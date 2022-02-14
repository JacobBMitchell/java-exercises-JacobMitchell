import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise06 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Use a loop to find the game in `games` that can be played by the most players.
        // 2. Print the game. (Expected: "Ultimate Werewolf...")
        int tempMax = 0;
        //BoardGame tempBG;
        for(BoardGame game: games){
            if (game.getMaxPlayers() > tempMax) {
                tempMax = game.getMaxPlayers();
                //tempBG = game;
            }
        }
        //System.out.println(tempBG);
        for (BoardGame game:games){
             if (game.getMaxPlayers() == tempMax){
                 System.out.println(game);
             }
        } // is there a better way of doing this rather than looping over the array twice?
    }
}

