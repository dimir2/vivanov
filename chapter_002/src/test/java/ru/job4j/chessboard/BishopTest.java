package ru.job4j.chessboard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Bishop move test.
 *
 * @author Vladimir
 * @version 0.1
 * @since 23.08.2017
 */
public class BishopTest {
    /**
     * Bishop move diagonally c1-f4.
     */
    @Test
    public void whenBishopMoveDiagonallyThenItMoved() {
        Board board = new Board();
        Cell c1 = new Cell(7, 2);
        Cell f4 = new Cell(4, 5);
        board.placeFigure(new Bishop(c1));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(c1, f4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("Bishop moved successfully (B c1-f4)", result, is(true));
    }

    /**
     * Bishop move diagonally on occupied cell c1-f4.
     */
    @Test
    public void whenBishopMoveDiagonallyThenGotOccupiedWayException() {
        Board board = new Board();
        Cell c1 = new Cell(7, 2);
        Cell f4 = new Cell(4, 5);
        board.placeFigure(new Bishop(c1));
        board.placeFigure(new Bishop(f4));

        Exception exception = null;
        try {
            board.move(c1, f4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("OccupiedWayException was caught", exception, instanceOf(OccupiedWayException.class));
    }

    /**
     * Bishop tries to move not diagonally f1-f4.
     */
    @Test
    public void whenBishopMoveNotDiagonallyThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell f1 = new Cell(7, 5);
        Cell f4 = new Cell(4, 5);
        board.placeFigure(new Bishop(f1));

        Exception exception = null;
        try {
            board.move(f1, f4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }

    /**
     * Bishop tries to move outside the board f1-k6.
     */
    @Test
    public void whenBishopMoveOutsideBoardThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell f1 = new Cell(7, 5);
        Cell k6 = new Cell(2, 10);
        board.placeFigure(new Bishop(f1));

        Exception exception = null;
        try {
            board.move(f1, k6);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }


}
