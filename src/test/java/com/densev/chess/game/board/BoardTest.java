package com.densev.chess.game.board;

import com.densev.chess.game.moves.Position;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created on: 10/24/18
 */
public class BoardTest {

    Board board = new Board();

    @BeforeMethod
    public void setup() {
        board.fillTheBoard();
    }

    @Test
    public void testBoardIsPopulatedCorrectly() {
        int pawnCount = 0,
            rookCount = 0,
            knightCount = 0,
            bishopCount = 0,
            queenCount = 0,
            kingCount = 0,
            emptyCount = 0,
            expectedEmptyCount = 32,
            expectedPawnCount = 16,
            expectedRookCount = 4,
            expectedKnightCount = 4,
            expectedBishopCount = 4,
            expectedQueenCount = 2,
            expectedKingCount = 2;


        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                Cell cellAtPosition = board.cellAt(i, j);

                if (cellAtPosition.isNotEmpty()) {
                    switch (cellAtPosition.getPiece()) {
                        case PAWN:
                            pawnCount++;
                            break;
                        case ROOK:
                            rookCount++;
                            break;
                        case KNIGHT:
                            knightCount++;
                            break;
                        case BISHOP:
                            bishopCount++;
                            break;
                        case QUEEN:
                            queenCount++;
                            break;
                        case KING:
                            kingCount++;
                            break;
                    }
                } else {
                    emptyCount++;
                }
            }
        }

        assertEquals(emptyCount, expectedEmptyCount);
        assertEquals(pawnCount, expectedPawnCount);
        assertEquals(rookCount, expectedRookCount);
        assertEquals(knightCount, expectedKnightCount);
        assertEquals(bishopCount, expectedBishopCount);
        assertEquals(queenCount, expectedQueenCount);
        assertEquals(kingCount, expectedKingCount);
    }

    @Test
    public void testSetCellAt() {
        //given
        Cell cell = Cell.with(Piece.PAWN, Color.BLACK);

        int positionX = 0, positionY = 0;

        assertEquals(board.getCells()[positionX][positionY], Cell.with(Piece.ROOK, Color.WHITE));

        //when
        board.setCellAt(cell, positionX, positionY);

        //then
        assertEquals(board.getCells()[0][0], cell);
    }

    @Test
    public void testCellAt() {
        //given
        int positionX = 0, positionY = 0;
        Cell expectedCell = Cell.with(Piece.PAWN, Color.BLACK);

        board.getCells()[positionX][positionY] = expectedCell;
        //when
        Cell actualCell = board.cellAt(positionX, positionY);
        //then
        assertEquals(actualCell, expectedCell);
    }

    @Test
    public void testGetPositionOfPiece() {
        //given
        Position whiteQueenPosition = new Position(0, 3);

        //when
        Position foundPosition = board.getPositionOfPiece(Piece.QUEEN, Color.WHITE);

        //then
        assertEquals(whiteQueenPosition, foundPosition);
    }
}
