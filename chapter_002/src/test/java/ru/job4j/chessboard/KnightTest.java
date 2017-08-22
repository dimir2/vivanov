package ru.job4j.chessboard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Knight move test.
 *
 * @author Vladimir
 * @version 0.1
 * @since 23.08.2017
 */
public class KnightTest {
    /**
     * Knight move L-way b1-c3.
     */
    @Test
    public void whenKnightMoveLWayThenItMoved() {
        Board board = new Board();
        Cell b1 = new Cell(7, 1);
        Cell c3 = new Cell(5, 2);
        board.placeFigure(new Knight(b1));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(b1, c3);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("Knight moved successfully (Kn b1-c3)", result, is(true));
    }

    /**
     * * Knight move L-way on occupied cell b1-c3.
     */
    @Test
    public void whenKnightMoveLWayThenGotOccupiedWayException() {
        Board board = new Board();
        Cell b1 = new Cell(7, 1);
        Cell c3 = new Cell(5, 2);
        board.placeFigure(new Knight(b1));
        board.placeFigure(new Knight(c3));

        Exception exception = null;
        try {
            board.move(b1, c3);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("OccupiedWayException was caught", exception, instanceOf(OccupiedWayException.class));
    }

    /**
     * Knight tries to move not L-way g1-c3.
     */
    @Test
    public void whenKnightMoveNotLWayThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell g1 = new Cell(7, 6);
        Cell c3 = new Cell(5, 2);
        board.placeFigure(new Knight(g1));

        Exception exception = null;
        try {
            board.move(g1, c3);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }

    /**
     * Knight tries to move outside the board g1-i2.
     */
    @Test
    public void whenKnightMoveOutsideBoardThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell g1 = new Cell(7, 6);
        Cell i2 = new Cell(6, 8);
        board.placeFigure(new Knight(g1));

        Exception exception = null;
        try {
            board.move(g1, i2);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }
}
