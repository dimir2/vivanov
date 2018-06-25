package ru.job4j.chessboard;

import static java.lang.String.format;

/**
 * Class Cell.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 19.08.2017
 */
class Cell {

    /**
     * Cell row position.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    final int row;
    /**
     * Cell column position.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    final int column;

    /**
     * Construct cell with position.
     *
     * @param row    Cell row position.
     * @param column Cell column position.
     */
    Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Hash code for the cell object.
     *
     * @return HashCode
     */
    @Override
    public int hashCode() {
        return this.row * 10 + this.column;
    }

    /**
     * Equals method, check not only the reference equality but also the equality of row and column.
     *
     * @param obj Object to compare to
     * @return True if the objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = super.equals(obj);
        if (!result) {
            if (obj instanceof Cell) {
                Cell cell = (Cell) obj;
                result = this.row == cell.row && this.column == cell.column;
            }
        }
        return result;
    }

    /**
     * Converts cell object to string.
     *
     * @return String representing the cell.
     */
    @Override
    public String toString() {
        return format("Cell{row=%d, column=%d}", this.row, this.column);
    }
}
