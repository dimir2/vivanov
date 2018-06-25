package ru.job4j.chessboard;

/**
 * Class Knight.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class Knight extends Figure {
    /**
     * Constructs Knight figure.
     *
     * @param cell     Figure position.
     * @param strategy Knight move strategy.
     */
    Knight(Cell cell, MoveStrategy strategy) {
        super(cell, strategy);
    }

    /**
     * Constructs Knight figure with default move strategy.
     *
     * @param cell Figure position.
     */
    Knight(Cell cell) {
        this(cell, new KnightMoveStrategy());
    }

    /**
     * Move the figure on destination cell.
     *
     * @param dest Destination cell
     * @return Figure on destination cell
     */
    @Override
    Figure move(Cell dest) {
        return new Knight(dest, this.strategy);
    }
}
