package test;

import Checkers.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(null);
        board.initializeBoard();

    }

    @Test
    public void testBoardInitialization() {
        int[][] expectedBoardState = {
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 2, 0, 2, 0, 2, 0},
                {0, 2, 0, 2, 0, 2, 0, 2},
                {2, 0, 2, 0, 2, 0, 2, 0}
        };

        for (int row = 0; row < expectedBoardState.length; row++) {
            for (int col = 0; col < expectedBoardState[row].length; col++) {
                assertEquals(expectedBoardState[row][col], board.getCellState(row, col),
                        "Incorrect initial state at position (" + row + ", " + col + ")");
            }
        }
    }

    @Test
    public void testValidMove() {
        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        assertEquals(0, board.getCellState(2, 1), "Starting position should be empty after the move");
        assertEquals(1, board.getCellState(3, 2), "White piece should be in the new position");
    }
    @Test
    public void testInvalidMove() {
        board.handleMouseClick(2, 1);
        board.handleMouseClick(2, 2);

        assertEquals(1, board.getCellState(2, 1), "White piece should remain in the starting position");
        assertEquals(0, board.getCellState(2, 2), "End position should remain empty after an invalid move");
    }
    @Test
    public void testEndGameWhenNoMovesLeft() {
        board.handleMouseClick(2, 3);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 2);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(4, 1);

        board.handleMouseClick(5, 0);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(2, 5);
        board.handleMouseClick(3, 4);

        board.handleMouseClick(4, 3);
        board.handleMouseClick(2, 5);

        board.handleMouseClick(1, 6);
        board.handleMouseClick(3, 4);

        board.handleMouseClick(5, 4);
        board.handleMouseClick(4, 5);

        board.handleMouseClick(3, 4);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(5, 4);

        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 4);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(5, 4);

        board.handleMouseClick(4, 5);
        board.handleMouseClick(3, 6);
        board.handleMouseClick(2, 7);
        board.handleMouseClick(4, 5);

        board.handleMouseClick(5, 6);
        board.handleMouseClick(3, 4);

        board.handleMouseClick(1, 4);
        board.handleMouseClick(2, 3);

        board.handleMouseClick(3, 4);
        board.handleMouseClick(2, 5);

        board.handleMouseClick(0, 5);
        board.handleMouseClick(1, 4);

        board.handleMouseClick(6, 5);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(1, 4);
        board.handleMouseClick(3, 6);

        board.handleMouseClick(4, 3);
        board.handleMouseClick(3, 4);

        board.handleMouseClick(2, 3);
        board.handleMouseClick(4, 5);

        board.handleMouseClick(6, 3);
        board.handleMouseClick(5, 4);

        board.handleMouseClick(4, 5);
        board.handleMouseClick(6, 3);

        board.handleMouseClick(7, 2);
        board.handleMouseClick(5, 4);

        board.handleMouseClick(3, 6);
        board.handleMouseClick(4, 5);

        board.handleMouseClick(5, 4);
        board.handleMouseClick(3, 6);

        board.handleMouseClick(1, 2);
        board.handleMouseClick(2, 3);

        board.handleMouseClick(6, 7);
        board.handleMouseClick(5, 6);

        board.handleMouseClick(2, 3);
        board.handleMouseClick(3, 4);

        board.handleMouseClick(5, 6);
        board.handleMouseClick(4, 5);

        board.handleMouseClick(3, 4);
        board.handleMouseClick(5, 6);

        board.handleMouseClick(7, 6);
        board.handleMouseClick(6, 5);

        board.handleMouseClick(0, 3);
        board.handleMouseClick(1, 4);

        board.handleMouseClick(6, 5);
        board.handleMouseClick(4, 7);

        board.handleMouseClick(1, 4);
        board.handleMouseClick(2, 5);

        board.handleMouseClick(3, 6);
        board.handleMouseClick(1, 4);

        board.handleMouseClick(0, 7);
        board.handleMouseClick(1, 6);

        board.handleMouseClick(4, 7);
        board.handleMouseClick(3, 6);

        board.handleMouseClick(1, 6);
        board.handleMouseClick(2, 5);

        board.handleMouseClick(1, 4);
        board.handleMouseClick(0, 3);

        board.handleMouseClick(2, 5);
        board.handleMouseClick(4, 7);

        board.handleMouseClick(7, 4);
        board.handleMouseClick(6, 5);

        board.handleMouseClick(4, 7);
        board.handleMouseClick(5, 6);

        board.handleMouseClick(6, 5);
        board.handleMouseClick(4, 7);

        board.handleMouseClick(1, 0);
        board.handleMouseClick(2, 1);

        board.handleMouseClick(6, 1);
        board.handleMouseClick(5, 2);

        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 2);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(4, 1);

        board.handleMouseClick(7, 0);
        board.handleMouseClick(6, 1);

        board.handleMouseClick(0, 1);
        board.handleMouseClick(1, 2);

        board.handleMouseClick(0, 3);
        board.handleMouseClick(2, 1);

        board.handleMouseClick(4, 1);
        board.handleMouseClick(5, 2);

        board.handleMouseClick(4, 3);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 2);
        board.handleMouseClick(6, 3);

        board.handleMouseClick(6, 1);
        board.handleMouseClick(5, 2);

        board.handleMouseClick(6, 3);
        board.handleMouseClick(4, 1);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(5, 0);

        boolean isGameOver = board.checkTheEndOfGame();
        assertTrue(isGameOver, "Game Over!");

    }
    @Test
    public void testCannotMoveBackwards() {
        board.handleMouseClick(2, 3);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 0);
        board.handleMouseClick(4, 1);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(2, 3);

        assertEquals(1, board.getCellState(3, 2), "White piece should remain in position (3, 2)");
        assertEquals(0, board.getCellState(2, 3), "End position should remain empty after an invalid move");
    }
    @Test
    public void testMoveOutOfBounds() {
        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 0);

        board.handleMouseClick(5, 0);
        board.handleMouseClick(4, 1);

        board.handleMouseClick(3, 0);
        board.handleMouseClick(4, -1);

        assertEquals(1, board.getCellState(3, 0), "Piece should remain in its initial position when trying to move out of bounds");
    }
    @Test
    public void testValidCaptureForward() {
        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 2);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(5, 4);

        assertEquals(1, board.getCellState(5, 4), "White piece should capture black piece and move to position (5, 4)");
        assertEquals(0, board.getCellState(4, 3), "Captured black piece should be removed from position (4, 3)");
    }
    @Test
    public void testInvalidCaptureAndMoveForward() {
        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 4);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(4, 1);

        board.handleMouseClick(4, 3);
        board.handleMouseClick(2, 1);

        assertEquals(2, board.getCellState(4, 3), "Black piece should remain at position (4, 3) after an invalid capture attempt");
        assertEquals(0, board.getCellState(2, 1), "Target position should remain empty after an invalid capture attempt");
    }

    @Test
    public void testValidCaptureBackward() {
        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 4);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(5, 4);

        board.handleMouseClick(5, 2);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(5, 4);
        board.handleMouseClick(3, 2);

        assertEquals(1, board.getCellState(3, 2), "White piece should capture black piece and move to position (3, 2)");
        assertEquals(0, board.getCellState(4, 3), "Captured white piece should be removed from position (4, 3)");
    }

    @Test
    public void testInvalidCaptureBackward() {
        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 4);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(4, 1);

        board.handleMouseClick(4, 3);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(2, 5);
        board.handleMouseClick(3, 4);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(5, 4);

        assertEquals(2, board.getCellState(3, 2), "Black piece should remain at position (3, 2) after an invalid capture attempt");
        assertEquals(0, board.getCellState(5, 4), "Target position should remain empty after an invalid capture attempt");
    }

    @Test
    public void testScoreIncrease() {
        int initialScoreWhite = board.getWhiteScore();
        int initialScoreBlack = board.getBlackScore();

        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(5, 4);
        board.handleMouseClick(4, 3);

        board.handleMouseClick(3, 2);
        board.handleMouseClick(5, 4);

        assertEquals(initialScoreWhite + 1, board.getWhiteScore(), "White score should increase after a capture");
        assertEquals(initialScoreBlack, board.getBlackScore(), "Black score should remain the same");
    }

    @Test
    public void testWhiteTurn() {
        board.handleMouseClick(5, 0);
        board.handleMouseClick(4, 1);

        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        assertEquals(2, board.getCellState(5, 0), "Black piece should remain in its initial position, as it is White's turn");
        assertEquals(0, board.getCellState(4, 1), "Target position should remain empty after an invalid move attempt");
        assertEquals(1, board.getCellState(3, 2), "White piece should be moved to (3,2)");
        assertEquals(0, board.getCellState(2, 1), "Previous position should be empty");

    }

    @Test
    public void testBlackTurn() {
        board.handleMouseClick(2, 1);
        board.handleMouseClick(3, 2);

        board.handleMouseClick(2, 3);
        board.handleMouseClick(4, 5);

        board.handleMouseClick(5, 0);
        board.handleMouseClick(4, 1);

        assertEquals(1, board.getCellState(2, 3), "White piece should remain in its initial position, as it is Black's turn");
        assertEquals(0, board.getCellState(4, 5), "Target position should remain empty after an invalid move attempt");
        assertEquals(2, board.getCellState(4, 1), "Black piece should be moved to (4,1) ");
        assertEquals(0, board.getCellState(5, 0), "Previous position should be empty");

    }


}