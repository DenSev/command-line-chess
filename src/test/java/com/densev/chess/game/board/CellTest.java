package com.densev.chess.game.board;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created on: 10/23/18
 */
public class CellTest {

    @Test
    public void testNotOpposing() {
        Cell x = Cell.with(Piece.BISHOP, Color.BLACK);
        Cell y = Cell.empty();

        assertTrue(y.isNotOpposing(x));
        assertTrue(x.isNotOpposing(y));
    }

    @Test
    public void testOpposing() {
        Cell x = Cell.with(Piece.BISHOP, Color.BLACK);
        Cell y = Cell.empty();

        assertFalse(y.isOpposing(x));
        assertFalse(x.isOpposing(y));
    }
}
