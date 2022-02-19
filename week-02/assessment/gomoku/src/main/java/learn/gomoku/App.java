package learn.gomoku;

import learn.gomoku.game.GameController;
import learn.gomoku.game.Gomoku;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.Scanner;

public class App {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        GameController gm = new GameController();
        RandomPlayer player2 = new RandomPlayer();
        boolean notSet = true;
        Player player1 = null;
        while(notSet) {
            System.out.println("Hello, welcome to the Game of Gomoku! \n=================================== ");
            System.out.print("Would you like to play(1) or have a random player play(2)?");
            int choice = scn.nextInt();
            scn.nextLine();
            if (choice == 1) {
                System.out.print("What is your name?: ");
                String name = scn.nextLine();
                player1 = new HumanPlayer(name);
                notSet = false;
            } else if (choice == 2) {
                player1 = new RandomPlayer();
                notSet = false;
            } else {
                System.out.println("Not a valid input.");

            }
        }

        Gomoku gomoku = new Gomoku(player1,player2);

        gm.gameLoop(gomoku);
    }
}
