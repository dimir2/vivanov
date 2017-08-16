package ru.job4j.chessboard;

/**
 * Class Board.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 19.08.2017
 */
public class Board {

    /**
     * Board getRow count.
     */
    static final int ROW_COUNT = 8;
    /**
     * Board getColumn count.
     */
    static final int COLUMN_COUNT = 8;

    /**
     * Max count of figures on the board.
     */
    static final int FIGURE_MAX_COUNT = COLUMN_COUNT * 4;

    /**
     * Chessboard cells.
     */
    private Cell[][] cells = new Cell[ROW_COUNT][COLUMN_COUNT];

    /**
     * Figures on chessboard.
     */
    private Figure[] figures = new Figure[FIGURE_MAX_COUNT];

    /**
     * Counter for figures on chessboard.
     */
    private int counter = 0;

    /**
     * Constructs Board object. Fill it with cells.
     */
    public Board() {
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COLUMN_COUNT; column++) {
                this.cells[row][column] = new Cell(row, column);
            }
        }
    }

    /**
     * Converts cell position in array to cell name, e.g. "e2".
     *
     * @param row Cell getRow position
     * @param col Cell getColumn position
     * @return Cell name
     */
    public String rowColumnToCellName(int row, int col) {
        return String.format("%s%s", (char) ('a' + col), ROW_COUNT - row);
    }

    /**
     * Return Cell object by cell name.
     *
     * @param name Cell name
     * @return Corresponding Cell object
     */
    public Cell getCellByCellName(String name) {
        name = name.toLowerCase();
        int row = ROW_COUNT - Integer.valueOf(name.substring(1));
        int col = name.charAt(0) - 'a';
        return this.cells[row][col];
    }

    /**
     * Return Cell object by cell position.
     *
     * @param row Cell getRow
     * @param col Cell getColumn
     * @return Corresponding Cell object
     */
    public Cell getCellByRowColumn(int row, int col) {
        return this.cells[row][col];
    }

    /**
     * Move figure from from to destination cell.
     *
     * @param from Current position
     * @param to   Destination position.
     * @return Movement result.
     * @throws ImpossibleMoveException Move is impossible.
     * @throws OccupiedWayException    There is at least one occupied cell on the way to destination.
     * @throws FigureNotFoundException No figure found on the position.
     */
    public boolean move(Cell from, Cell to) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = true;
        Figure figure = this.getFigureOnCell(from);

        if (figure == null) {
            throw new FigureNotFoundException("Figure not found on cell: " + this.getCellName(from));
        }

        Cell[] way = figure.way(to);

        for (int index = 1; index < way.length; index++) {
            if (this.getFigureOnCell(way[index]) != null) {
                throw new OccupiedWayException("Occupied cell on the figure way: " + this.getCellName(way[index]));
            }
        }

        this.figures[this.getFigureIndex(figure)] = figure.move(to);
        return result;
    }

    /**
     * Place one figure on the chessboard.
     *
     * @param figure Figure to place
     * @return Result
     */
    public boolean placeFigure(Figure figure) {
        boolean result = false;
        if (this.getFigureIndex(figure) == -1 && this.getFigureOnCell(figure.cell) == null) {
            this.figures[this.counter++] = figure;
            result = true;
        }
        return result;
    }

    /**
     * Arrange a set of figures on the chessboard.
     *
     * @param figures Array of figures.
     * @return Result of arrangement.
     */
    public boolean arrangeFigures(Figure figures) {
        boolean result = true;
        //TODO implement if needed
        return result;
    }

    /**
     * Produce cell name.
     *
     * @param cell Cell object
     * @return Cell name
     */
    public String getCellName(Cell cell) {
        return this.rowColumnToCellName(cell.row, cell.column);
    }

    /**
     * Get figure on the cell specified.
     *
     * @param cell Cell object.
     * @return Figure object.
     */
    public Figure getFigureOnCell(Cell cell) {
        Figure result = null;
        for (int index = 0; index < this.counter; index++) {
            if (this.figures[index] != null && cell.equals(this.figures[index].cell)) {
                result = this.figures[index];
                break;
            }
        }
        return result;
    }

    /**
     * Get figure index.
     *
     * @param figure Figure.
     * @return Index if found and -1 if not.
     */
    private int getFigureIndex(Figure figure) {
        int result = -1;
        for (int index = 0; index < this.counter; index++) {
            if (this.figures[index] != null && figure.equals(this.figures[index])) {
                result = index;
                break;
            }
        }
        return result;
    }
}