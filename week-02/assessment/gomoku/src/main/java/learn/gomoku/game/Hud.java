package learn.gomoku.game;

import learn.gomoku.App;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.List;
import java.util.Scanner;

public class Hud {
    static Scanner scn =  new Scanner(System.in);

    /**
     * This function asks for integers from the user, and uses the pair of integers to return a stone in the spot chosen
     * @param gomoku
     * @return stone
     */
    public static Stone getNextMove(Gomoku gomoku) {
        Stone output;

        //System.out.println(gomoku.getCurrent().getName()+"'s Turn");
        System.out.print("What is the x (col) coordinate of your next move?(1-15): ");
        int col = Integer.parseInt(scn.nextLine())-1;
        System.out.print("What is the y (row) coordinate of your next move?(1-15): ");
        int row = Integer.parseInt(scn.nextLine())-1;

        if (!GameController.isValidMove(gomoku, row,col)){

            System.out.println("Not a valid move! ");
            output = getNextMove(gomoku);
        }
        else {output = new Stone(row, col, gomoku.isBlacksTurn());}
        return output;
//        return new Stone(row,col,true);
    }

    /**
     *This function displays a stylized Gomoku board wherein it creates an array
     * looks through the stones in the list of stones and assigns them to their spot on the array
     * prints out 1-15 in the rows and columns
     * and creates the board marking W for white and B for black
     * @param stones
     */
    public static void displayBoard(List<Stone> stones) {
        int[][] stoneArray = new int[15][15];
        for(Stone stone: stones){
            if (stone.isBlack()) {
                stoneArray[stone.getRow()][stone.getColumn()] = 1;
            }
            if (!stone.isBlack()){
                stoneArray[stone.getRow()][stone.getColumn()] = 2;
            }
        }
        //create
        System.out.print("   ");
        for (int i = 1; i <= 15; i++) {
            if (i >= 10){
                System.out.print(i+ " ");
                continue;
            }
            System.out.print(i+ "  ");
        }
        System.out.println();

        for (int i = 0; i < 15; i++) {
            System.out.printf("%2d",i+1);
            for (int j = 0; j < 15; j++) {
                if(stoneArray[i][j] == 0){
                    System.out.print(" . ");
                }
                else if(stoneArray[i][j] == 1){
                    System.out.print(" W ");
                }
                else if(stoneArray[i][j] == 2){
                    System.out.print(" B ");
                }

            }
            System.out.println();

        }
    }
    /**
     * Asks the user if they want to play again, if they respond 'y' the program runs the main fxn
     * and re-runs the entire program, else it ends the program.
     */
    public static void playAgain() {
        System.out.print("Want to play again?[y/n] ");
        String choice = scn.nextLine();
        if(choice.equalsIgnoreCase("y")){
            App.main(new String[0]);
        }
        else {
            System.out.println("Goodbye!");
        }
    }


    public static Player selectPlayer() {
        boolean notSet = true;
        Player playerN = null;
        while(notSet) {
            System.out.print("Would you like to play(1) or have a random player play(2)?");
            int choice = scn.nextInt();
            scn.nextLine();

            if (choice == 1) {
                System.out.print("What is your name?: ");
                String name = scn.nextLine();
                playerN = new HumanPlayer(name);
                notSet = false;
            } else if (choice == 2) {
                System.out.println("Randomizing Player...");
                playerN = new RandomPlayer();
                notSet = false;
            } else {
                System.out.println("Not a valid input.");

            }
        }
        return playerN;
    }
}
