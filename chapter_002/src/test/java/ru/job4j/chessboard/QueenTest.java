package ru.job4j.chessboard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Queen move test.
 *
 * @author Vladimir
 * @version 0.1
 * @since 23.08.2017
 */
public class QueenTest {
    /**
     * Queen move diagonally d4-g7.
     */
    @Test
    public void whenQueenMoveDiagonallyThenItMoved() {
        Board board = new Board();
        Cell d4 = new Cell(4, 3);
        Cell g7 = new Cell(1, 6);
        board.placeFigure(new Queen(d4));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(d4, g7);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("Queen moved successfully (Q d4-g7)", result, is(true));
    }

    /**
     * Queen move right d4-g4.
     */
    @Test
    public void whenQueenMoveRightThenItMoved() {
        Board board = new Board();
        Cell d4 = new Cell(4, 3);
        Cell g4 = new Cell(4, 6);
        board.placeFigure(new Queen(d4));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(d4, g4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("Queen moved successfully (Q d4-g4)", result, is(true));
    }

    /**
     * Queen move right d4-g4 on occupied position.
     */
    @Test
    public void whenQueenMoveRightThenGotOccupiedWayException() {
        Board board = new Board();
        Cell d4 = new Cell(4, 3);
        Cell g4 = new Cell(4, 6);
        board.placeFigure(new Queen(d4));
        board.placeFigure(new Queen(g4));

        Exception exception = null;
        try {
            board.move(d4, g4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("OccupiedWayException was caught", exception, instanceOf(OccupiedWayException.class));
    }

    /**
     * Queen tries to move like Knight d4-e6.
     */
    @Test
    public void whenQueenMoveLikeKnightThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell d4 = new Cell(4, 3);
        Cell e6 = new Cell(2, 4);
        board.placeFigure(new Queen(d4));

        Exception exception = null;
        try {
            board.move(d4, e6);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }

    /**
     * Queen tries to move outside the board e6-j1.
     */
    @Test
    public void whenQueenMoveOutsideBoardThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell e6 = new Cell(2, 4);
        Cell j1 = new Cell(7, 9);
        board.placeFigure(new Queen(e6));

        Exception exception = null;
        try {
            board.move(e6, j1);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }
}
