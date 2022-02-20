package learn.gomoku.game;

import learn.gomoku.players.RandomPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    RandomPlayer rp1 = new RandomPlayer();
    RandomPlayer rp2 = new RandomPlayer();
    Gomoku gomoku = new Gomoku(rp1,rp2);

    @Test
    void testLegalMoves(){
        GameController gc = new GameController();
        assertTrue(gc.validMove(gomoku,3,4));
        assertFalse(gc.validMove(gomoku,17,16));
        assertFalse(gc.validMove(gomoku,-1,3));
        Stone testStone = new Stone(3,5,true);
        gomoku.place(testStone);
        assertFalse(gc.validMove(gomoku,3,5));


    }


}