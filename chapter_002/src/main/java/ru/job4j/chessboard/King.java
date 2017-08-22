package ru.job4j.chessboard;

/**
 * Class King.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class King extends Figure {
    /**
     * Construct King figure.
     *
     * @param position Figure position
     * @param strategy Bishop move strategy.
     */
    King(Cell position, MoveStrategy strategy) {
        super(position, strategy);
    }

    /**
     * Construct King figure with default move strategy.
     *
     * @param position Figure position.
     */
    King(Cell position) {
        this(position, new KingMoveStrategy());
    }

    /**
     * Move the figure on destination cell.
     *
     * @param dest Destination cell
     * @return Figure on destination cell
     */
    @Override
    Figure move(Cell dest) {
        return new King(dest, this.strategy);
    }
}
