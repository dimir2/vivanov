package ru.job4j.chessboard;

import org.junit.Test;

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
     * Move figure test.
     */
    @Test
    public void whenMoveBishopFromD5ToE6ThenItIsMoved() {
        Board board = new Board();
        Cell d5 = board.getCellByCellName("d5");
        Cell e6 = board.getCellByCellName("e6");
        board.placeFigure(new Bishop(d5, new BishopMoveStrategy()));
        boolean result = board.move(d5, e6);
        assertThat(result, is(true));
    }
}