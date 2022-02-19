package learn.gomoku.game;

import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.List;
import java.util.Scanner;

public class GameController {

    Scanner scn = new Scanner(System.in);


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

    /**
     * The basic game loop takes the game and runs it displaying the board, checking whose move it is
     * and sees if the game is over, once the game finishes displays whose won and shows the winning board
     * @param gomoku
     */
    public void gameLoop(Gomoku gomoku) {
        boolean playing = true;
        while (playing){
            displayBoard(gomoku.getStones());

            Player player = gomoku.getCurrent();
            //asks whoevers turn it is to automatically generate a move if possible
            Stone nextMove = null;
            while(true) {
                nextMove = player.generateMove(gomoku.getStones());
                if (nextMove == null){
                    break;
                }
                if (validMove(gomoku,nextMove.getRow(),nextMove.getColumn())){
                    break;
                }
            }
            //if it is a human player the HumanPlayer class returns null so we would then need to generate a move
            if (nextMove == null){
                nextMove = getNextMove(gomoku);
            }
            Result result = gomoku.place(nextMove);
            System.out.println(!(result.getMessage() == null)?result.getMessage():"");
            playing = result.isSuccess(); //fails when an error msg is introduced like duplicate move
        }
        //displayBoard(gomoku.getStones());
        System.out.println(gomoku.getWinner().getName() + " wins!!!");
    }

    /**
     * This function asks for integers from the user, and uses the pair of integers to return a stone in the spot chosen
     * @param gomoku
     * @return stone
     */
    private Stone getNextMove(Gomoku gomoku) {
        Stone output;

        System.out.println(gomoku.getCurrent().getName()+"'s Turn");
        System.out.print("What is the x (col) coordinate of your next move?(0-14): ");
        int col = Integer.parseInt(scn.nextLine());
        System.out.print("What is the y (row) coordinate of your next move?(0-14): ");
        int row = Integer.parseInt(scn.nextLine());

        if (!validMove(gomoku, row,col)){
            System.out.println("Not a valid move! ");
            output = getNextMove(gomoku);
        }
        else {output = new Stone(row, col, gomoku.isBlacksTurn());}
        return output;
//        return new Stone(row,col,true);
    }

    /**
     *This method checks if it is out of range or is already in the list of stones placed.
     * @param gomoku
     * @param row
     * @param col
     * @return
     */

    private boolean validMove(Gomoku gomoku, int row, int col) {
        if (col > 14 || col < 0 || row >14 || row <0){
            return false;
        }
        for(Stone stone: gomoku.getStones()){
            if(stone.getRow() == row && stone.getColumn() == col){
                return false;
            }
        }
        return true;
    }


    /**
     *This function displays a stylized Gomoku board wherein it creates an array
     * looks through the stones in the list of stones and assigns them to their spot on the array
     * prints out 0-14 in a the rows and columns
     * and creates the board marking W for white and B for black
     * @param stones
     */

    private void displayBoard(List<Stone> stones) {
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
        for (int i = 0; i < 15; i++) {
            if (i >= 10){
                System.out.print(i+ " ");
                continue;
            }
            System.out.print(i+ "  ");
        }
        System.out.println();

        for (int i = 0; i < 15; i++) {
            System.out.printf("%2d",i);
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


}
