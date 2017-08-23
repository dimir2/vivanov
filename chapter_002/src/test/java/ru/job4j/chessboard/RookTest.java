package ru.job4j.chessboard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Rook move test.
 *
 * @author Vladimir
 * @version 0.1
 * @since 23.08.2017
 */
public class RookTest {
    /**
     * Rook move up a1-a4.
     */
    @Test
    public void whenRookMoveUpThenItMoved() {
        Board board = new Board();
        Cell a1 = new Cell(7, 0);
        Cell a4 = new Cell(4, 0);
        board.placeFigure(new Rook(a1));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(a1, a4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("Rook moved successfully (R a1-a4)", result, is(true));
    }

    /**
     * Rook move right a1-d1.
     */
    @Test
    public void whenRookMoveRightThenItMoved() {
        Board board = new Board();
        Cell a1 = new Cell(7, 0);
        Cell d1 = new Cell(7, 3);
        board.placeFigure(new Rook(a1));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(a1, d1);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("Rook moved successfully (R a1-d1)", result, is(true));
    }

    /**
     * Rook move right a1-d1 on occupied cell.
     */
    @Test
    public void whenRookMoveRightThenGotOccupiedWayException() {
        Board board = new Board();
        Cell a1 = new Cell(7, 0);
        Cell d1 = new Cell(7, 3);
        board.placeFigure(new Rook(a1));
        board.placeFigure(new Rook(d1));

        Exception exception = null;
        try {
            board.move(a1, d1);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("OccupiedWayException was caught", exception, instanceOf(OccupiedWayException.class));
    }

    /**
     * Rook tries to move diagonally a1-d4.
     */
    @Test
    public void whenKingMoveOverTwoCellsThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell a1 = new Cell(7, 0);
        Cell d4 = new Cell(4, 3);
        board.placeFigure(new Rook(a1));

        Exception exception = null;
        try {
            board.move(a1, d4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }

    /**
     * Rook tries to move outside the board a1-k1.
     */
    @Test
    public void whenRookMoveOutsideBoardThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell a1 = new Cell(7, 0);
        Cell k1 = new Cell(7, 10);
        board.placeFigure(new Rook(a1));

        Exception exception = null;
        try {
            board.move(a1, k1);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }
}
