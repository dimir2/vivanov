package ru.job4j.chessboard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Board Test.
 *
 * @author Vladimir
 * @version 0.1
 * @since 18.08.2017
 */
public class BoardTest {
    /**
     * Row and column to cell name test.
     */
    @Test
    public void whenRowIs6AndColumnIs4ThenNameIsE2() {
        Board board = new Board();
        String expected = "e2";
        String result = board.rowColumnToCellName(6, 4);
        assertThat(result, is(expected));
    }

    /**
     * Cell name to Cell object test.
     */
    @Test
    public void whenRow2Column11ThenGetCellB6() {
        Board board = new Board();
        Cell expected = board.getCellByCellName("b6");
        Cell result = board.getCellByRowColumn(2, 1);
        assertThat(result, is(expected));
    }

    /**
     * Get cell by its position in array.
     */
    @Test
    public void whenRow3Column3ThenGetCellD5() {
        Board board = new Board();
        Cell expected = board.getCellByCellName("d5");
        Cell result = board.getCellByRowColumn(3, 3);
        assertThat(result, is(expected));
    }

    /**
     * Get cell by its name test.
     */
    @Test
    public void whenCellIsE4ThenRow4Col4() {
        Board board = new Board();
        Cell cell = board.getCellByCellName("e4");
        assertThat(cell.row == 4 && cell.column == 4, is(true));
    }

    /**
     * Place figure test.
     */
    @Test
    public void whenPlaceFigureOnBoardThenItIsOnBoard() {
        Board board = new Board();
        Cell cell = board.getCellByCellName("d5");
        Figure bishop = new Bishop(cell, new BishopMoveStrategy());
        board.placeFigure(bishop);
        assertThat(board.getFigureOnCell(cell), is(bishop));
    }

    /**
     * No figure on cell to move.
     */
    @Test
    public void whenNoFigureOnCellToMoveThenGotFigureNotFoundException() {
        Board board = new Board();
        Cell f1 = new Cell(7, 5);
        Cell c1 = new Cell(7, 2);
        Cell f4 = new Cell(4, 5);
        board.placeFigure(new Bishop(f1));

        Exception exception = null;
        try {
            board.move(c1, f4);
        } catch (Exception e) {
            exception = e;
        }
        assertThat("FigureNotFoundException was caught", exception, instanceOf(FigureNotFoundException.class));
    }
}