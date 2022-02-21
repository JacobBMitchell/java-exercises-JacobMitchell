package learn.gomoku;

import learn.gomoku.game.GameController;
import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Hud;
import learn.gomoku.players.Player;


public class App {

    public static void main(String[] args) {
        GameController gm = new GameController();
        System.out.println("Hello, welcome to the Game of Gomoku! \n=================================== ");
        Player player1 = Hud.selectPlayer();
        Player player2 = Hud.selectPlayer();

        Gomoku gomoku = new Gomoku(player1,player2);

        gm.gameLoop(gomoku);
    }

}

