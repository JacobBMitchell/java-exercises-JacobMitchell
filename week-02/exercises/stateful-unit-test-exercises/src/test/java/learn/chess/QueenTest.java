package learn.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    Queen queen = new Queen();

    @Test
    void shouldMoveToFourCorners() {
        assertTrue(queen.move(7, 0)); // top left;
        assertEquals(7, queen.getRow());
        assertEquals(0, queen.getColumn());

        assertTrue(queen.move(7, 7)); // top right;
        assertEquals(7, queen.getRow());
        assertEquals(7, queen.getColumn());

        assertTrue(queen.move(0, 7)); // bottom right;
        assertEquals(0, queen.getRow());
        assertEquals(7, queen.getColumn());

        assertTrue(queen.move(0, 0)); // bottom left;
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());
    }

    @Test
    void queenShouldMoveDiagonally(){
        assertTrue(queen.move(3,3));
        assertEquals(3,queen.getRow());
        assertEquals(3,queen.getColumn());

        assertTrue(queen.move(6,0));
        assertEquals(6,queen.getRow());
        assertEquals(0,queen.getColumn());
        queen.move(0,0);

        assertFalse(queen.move(2,4));
        assertEquals(0,queen.getRow());
        assertEquals(0,queen.getColumn());

    }

    @Test
    void queenShouldStayInbounds(){
        assertFalse(queen.move(8,0));
        assertEquals(0,queen.getRow());
        assertEquals(0,queen.getColumn());

        assertFalse(queen.move(0,9));
        assertEquals(0,queen.getRow());
        assertEquals(0,queen.getColumn());
    }

    // 1. Add tests to validate Queen movement.
    // Required tests:
    // - anything off the board is invalid, should return false and leave field values alone.
    // - requesting the existing location should return false and leave field values alone.
    // - should still be able to move after an invalid move.
    // - can move diagonally in various ways
    // Always confirm that fields have been properly updated using getters.
}