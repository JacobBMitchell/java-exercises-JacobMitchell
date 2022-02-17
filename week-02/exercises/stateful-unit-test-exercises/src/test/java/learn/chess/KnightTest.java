package learn.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    Knight knight = new Knight();

    @Test
    void knightStaysInBounds() {
        assertTrue(knight.move(2,1));
        assertEquals(2, knight.getRow());
        assertEquals(1, knight.getColumn());

        assertTrue(knight.move(1,3));
        assertEquals(1, knight.getRow());
        assertEquals(3, knight.getColumn());

        assertFalse(knight.move(-1,2));
        assertEquals(1, knight.getRow());
        assertEquals(3, knight.getColumn());

        assertFalse(knight.move(3,5));
        assertEquals(1, knight.getRow());
        assertEquals(3, knight.getColumn());

    }
}