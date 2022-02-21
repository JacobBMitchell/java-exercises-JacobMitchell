package learn.gomoku.game;

import learn.gomoku.App;
import learn.gomoku.players.Player;
import learn.gomoku.game.Hud;


import java.util.List;
import java.util.Scanner;

public class GameController {

    private Scanner scn = new Scanner(System.in);
    /**
     * The basic game loop takes the game and runs it displaying the board, checking whose move it is
     * and sees if the game is over, once the game finishes displays whose won and shows the winning board
     * @param gomoku
     */
    public void gameLoop(Gomoku gomoku) {
        boolean playing = true;
        System.out.println(gomoku.getCurrent().getName() + "'s turn is first!");
        while (playing){
            Hud.displayBoard(gomoku.getStones());

            Player player = gomoku.getCurrent();
            if (!gomoku.isOver()) {
                System.out.println(player.getName() + " its your turn!");
            }
            //asks whoever turn it is to automatically generate a move if possible
            Stone nextMove = null;
            while(true) {
                nextMove = player.generateMove(gomoku.getStones());
                if (nextMove == null){
                    break;
                }
                if (isValidMove(gomoku,nextMove.getRow(),nextMove.getColumn())){
                    break;
                }
            }
            //if it is a human player the HumanPlayer class returns null, so we would then need to generate a move
            if (nextMove == null && !gomoku.isOver()){
                nextMove = Hud.getNextMove(gomoku);
            }
            Result result = gomoku.place(nextMove);
            System.out.println(!(result.getMessage() == null)?result.getMessage():"");
            playing = result.isSuccess(); //fails when an error msg is introduced like duplicate move
        }
        //displayBoard(gomoku.getStones());
        if (gomoku.getWinner() == null){
            System.out.println("Its a draw! ");
        }
        else {
            System.out.println(gomoku.getWinner().getName() + " wins!!!");
        }
        Hud.playAgain();
    }

    /**
     *This method checks if it is out of range or is already in the list of stones placed.
     * @param gomoku
     * @param row
     * @param col
     * @return
     */

    public static boolean isValidMove(Gomoku gomoku, int row, int col) {
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
}
