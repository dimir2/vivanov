package ru.job4j.chessboard;

/**
 * Class Bishop.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 19.08.2017
 */
public class Bishop extends Figure {
    /**
     * Construct Bishop figure.
     *
     * @param position Figure position
     * @param strategy Bishop move strategy.
     */
    Bishop(Cell position, MoveStrategy strategy) {
        super(position, strategy);
    }

    /**
     * Construct Bishop figure with default move strategy.
     *
     * @param position Figure position.
     */
    Bishop(Cell position) {
        this(position, new BishopMoveStrategy());
    }

    /**
     * Move the figure on destination cell.
     *
     * @param dest Destination cell
     * @return Figure on destination cell
     */
    @Override
    Figure move(Cell dest) {
        return new Bishop(dest, this.strategy);
    }
}
