package ru.job4j.chessboard;

/**
 * Class Rook.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class Rook extends Figure {
    /**
     * Constructs Rook figure.
     *
     * @param cell     Figure position.
     * @param strategy Knight move strategy.
     */
    Rook(Cell cell, MoveStrategy strategy) {
        super(cell, strategy);
    }

    /**
     * Constructs Rook figure with default move strategy.
     *
     * @param cell Figure position.
     */
    Rook(Cell cell) {
        this(cell, new RookMoveStrategy());
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
