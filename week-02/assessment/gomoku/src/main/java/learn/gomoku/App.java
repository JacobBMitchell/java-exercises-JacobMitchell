package learn.gomoku;

import learn.gomoku.game.GameController;
import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Hud;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.Scanner;

public class App {

    static Scanner scn = new Scanner(System.in);
//    static Hud hd = new Hud();

    public static void main(String[] args) {
        GameController gm = new GameController();
        Player player1 = null;
        System.out.println("Hello, welcome to the Game of Gomoku! \n=================================== ");
        player1 = Hud.selectPlayer();
        Player player2 = Hud.selectPlayer();

        Gomoku gomoku = new Gomoku(player1,player2);

        gm.gameLoop(gomoku);
    }

//    private static Player selectPlayer() {
//        boolean notSet = true;
//        Player playerN = null;
//        while(notSet) {
//            System.out.print("Would you like to play(1) or have a random player play(2)?");
//            int choice = scn.nextInt();
//            scn.nextLine();
//
//            if (choice == 1) {
//                System.out.print("What is your name?: ");
//                String name = scn.nextLine();
//                playerN = new HumanPlayer(name);
//                notSet = false;
//            } else if (choice == 2) {
//                System.out.println("Randomizing Player...");
//                playerN = new RandomPlayer();
//                notSet = false;
//            } else {
//                System.out.println("Not a valid input.");
//
//            }
//        }
//        return playerN;
//    }
}
/**
 * Innitializes the game, asks for the player to either play or not, get their name and begin the game.
 */
//    public void run() {
//        System.out.println("Hello, welcome to the Game of Gomoku! \n=================================== ");
//        System.out.print("Would you like to play(1) or have a random player play(2)?");
//        int choice = scn.nextInt();
//        scn.nextLine();
//        Player player1 = null;
//        if (choice == 1) {
//            System.out.print("What is your name?: ");
//            String name = scn.nextLine();
//            player1 = new HumanPlayer(name);
//        }
//        else if (choice == 2){
//           player1 = new RandomPlayer();
//        }
//        else {
//            System.out.println("Not a valid input.");
//            run(); //recursion
//        }
//
//        Gomoku gomoku = new Gomoku(player1,player2);
//
//        gameLoop(gomoku);
//
//    }
