package ru.job4j.chessboard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * King move test.
 *
 * @author Vladimir
 * @version 0.1
 * @since 23.08.2017
 */
public class KingTest {
    /**
     * King move diagonally f5-e4.
     */
    @Test
    public void whenKingMoveDiagonallyThenItMoved() {
        Board board = new Board();
        Cell f5 = new Cell(3, 5);
        Cell e4 = new Cell(4, 4);
        board.placeFigure(new King(f5));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(f5, e4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("King moved successfully (K f5-e4)", result, is(true));
    }

    /**
     * King move left f5-e5.
     */
    @Test
    public void whenKingMoveLeftThenItMoved() {
        Board board = new Board();
        Cell f5 = new Cell(3, 5);
        Cell e5 = new Cell(3, 4);
        board.placeFigure(new King(f5));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(f5, e5);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("King moved successfully (K f5-e5)", result, is(true));
    }

    /**
     * King move left f5-e5 on occupied position.
     */
    @Test
    public void whenKingMoveLeftThenGotOccupiedWayException() {
        Board board = new Board();
        Cell f5 = new Cell(3, 5);
        Cell e5 = new Cell(3, 4);
        board.placeFigure(new King(f5));
        board.placeFigure(new King(e5));

        Exception exception = null;
        try {
            board.move(f5, e5);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("OccupiedWayException was caught", exception, instanceOf(OccupiedWayException.class));
    }

    /**
     * King tries to move over two cells g1-c3.
     */
    @Test
    public void whenKingMoveOverTwoCellsThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell f5 = new Cell(3, 5);
        Cell h7 = new Cell(1, 7);
        board.placeFigure(new King(f5));

        Exception exception = null;
        try {
            board.move(f5, h7);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }

    /**
     * King tries to move outside the board h7-i8.
     */
    @Test
    public void whenKingMoveOutsideBoardThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell f5 = new Cell(3, 5);
        Cell i8 = new Cell(0, 8);
        board.placeFigure(new King(f5));

        Exception exception = null;
        try {
            board.move(f5, i8);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }
}
