package learn.gomoku.game;

import learn.gomoku.players.Player;

public class GameController {


    /**
     * The basic game loop takes the game and runs it displaying the board, checking whose move it is
     * and sees if the game is over, once the game finishes displays whose won and shows the winning board
     * @param gomoku
     */
    public void gameLoop(Gomoku gomoku) {
//        boolean playing = true;
        System.out.println(gomoku.getCurrent().getName() + "'s turn is first!");
        while (!gomoku.isOver()){
            Hud.displayBoard(gomoku.getStones());

            Player player = gomoku.getCurrent();
            if (!gomoku.isOver()) {
                System.out.println(player.getName() + " its your turn!");
            }
            //

            //asks whoever turn it is to automatically generate a move if possible
            Stone nextMove = player.generateMove(gomoku.getStones());

            //if it is a human player the HumanPlayer class returns null, so we would then need to generate a move
            if (nextMove == null && !gomoku.isOver()){
                nextMove = Hud.getNextMove(gomoku);
            }
            Result result = gomoku.place(nextMove);
            System.out.println((result.getMessage() != null)?result.getMessage():"");
//            playing = result.isSuccess(); //fails when an error msg is introduced like duplicate move
        }
        Hud.displayBoard(gomoku.getStones());
        if (gomoku.getWinner() == null){
            System.out.println("Its a draw! ");
        }
        else {
            System.out.println(gomoku.getWinner().getName() + " wins!!!");
        }
        Hud.playAgain();
    }

}
