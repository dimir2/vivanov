package ru.job4j.chessboard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Pawn move test.
 *
 * @author Vladimir
 * @version 0.1
 * @since 23.08.2017
 */
public class PawnTest {
    /**
     * White pawn move up one cell f2-f3.
     */
    @Test
    public void whenWhitePawnMoveUpOneCellThenItMoved() {
        Board board = new Board();
        Cell f2 = new Cell(6, 5);
        Cell f3 = new Cell(5, 5);
        board.placeFigure(new Pawn(f2, new WhitePawnMoveStrategy()));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(f2, f3);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("White pawn moved successfully (P f2-f3)", result, is(true));
    }

    /**
     * White pawn move up two cells from home row e2-e4.
     */
    @Test
    public void whenWhitePawnMoveUpTwoCellsFromHomeRowThenItMoved() {
        Board board = new Board();
        Cell e2 = new Cell(6, 4);
        Cell e4 = new Cell(4, 4);
        board.placeFigure(new Pawn(e2, new WhitePawnMoveStrategy()));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(e2, e4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("White pawn moved successfully (P e2-e4)", result, is(true));
    }

    /**
     * Black pawn move down one cell f7-f6.
     */
    @Test
    public void whenBlackPawnMoveDownOneCellThenItMoved() {
        Board board = new Board();
        Cell f7 = new Cell(1, 5);
        Cell f6 = new Cell(2, 5);
        board.placeFigure(new Pawn(f7, new BlackPawnMoveStrategy()));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(f7, f6);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("Black pawn moved successfully (P f7-f6)", result, is(true));
    }


    /**
     * Black pawn move down two cells from home row d7-d5.
     */
    @Test
    public void whenBlackPawnMoveDownTwoCellsFromHomeRowThenItMoved() {
        Board board = new Board();
        Cell d7 = new Cell(1, 3);
        Cell d5 = new Cell(3, 3);
        board.placeFigure(new Pawn(d7, new BlackPawnMoveStrategy()));

        boolean result = false;
        Exception exception = null;
        try {
            result = board.move(d7, d5);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("No exception should be caught", exception, is(nullValue()));
        assertThat("Black pawn moved successfully (P d7-d5)", result, is(true));
    }

    /**
     * White pawn move up on occupied position e2-e3.
     */
    @Test
    public void whenWhitePawnMoveUpThenGotOccupiedWayException() {
        Board board = new Board();
        Cell e2 = new Cell(6, 4);
        Cell e3 = new Cell(5, 4);
        board.placeFigure(new Pawn(e2, new WhitePawnMoveStrategy()));
        board.placeFigure(new Pawn(e3, new BlackPawnMoveStrategy()));

        Exception exception = null;
        try {
            board.move(e2, e3);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("OccupiedWayException was caught", exception, instanceOf(OccupiedWayException.class));
    }

    /**
     * White pawn tries to move up four cells e2-e6.
     */
    @Test
    public void whenWhitePawnMoveUpFourCellsThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell e2 = new Cell(6, 4);
        Cell e6 = new Cell(2, 4);
        board.placeFigure(new Pawn(e2, new WhitePawnMoveStrategy()));

        Exception exception = null;
        try {
            board.move(e2, e6);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }

    /**
     * Black pawn tries to move outside the board h1-h0.
     */
    @Test
    public void whenBlackPawnMoveOutsideBoardThenGotImpossibleMoveException() {
        Board board = new Board();
        Cell h1 = new Cell(7, 7);
        Cell h0 = new Cell(8, 7);
        board.placeFigure(new Pawn(h1, new BlackPawnMoveStrategy()));

        Exception exception = null;
        try {
            board.move(h1, h0);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("ImpossibleMoveException was caught", exception, instanceOf(ImpossibleMoveException.class));
    }
}
