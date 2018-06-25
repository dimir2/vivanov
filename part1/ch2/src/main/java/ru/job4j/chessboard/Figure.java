package ru.job4j.chessboard;

/**
 * Class Figure.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 19.08.2017
 */
abstract class Figure {

    /**
     * Board cell where the figure is placed.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    final Cell cell;

    /**
     * Move getStrategy implementation.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    MoveStrategy strategy;

    /**
     * Construct new Figure with the specified cell.
     *
     * @param cell     Position on the board
     * @param strategy movement getStrategy
     */
    Figure(Cell cell, MoveStrategy strategy) {
        this.cell = cell;
        this.strategy = strategy;
    }

    /**
     * Find out all cells, figure must step on on it's way to destination cell.
     *
     * @param destination Destination cell.
     * @return Array with cells on figure way to destination.
     */
    Cell[] way(Cell destination) {
        return this.strategy.way(this.cell, destination);
    }

    /**
     * Move a figure from current cell onto the destination cell.
     *
     * @param dest Destination cell
     * @return Figure on destination cell
     */
    abstract Figure move(Cell dest);
}
