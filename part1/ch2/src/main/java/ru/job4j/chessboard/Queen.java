package ru.job4j.chessboard;

/**
 * Class Queen.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class Queen extends Figure {
    /**
     * Construct Queen figure.
     *
     * @param position Figure position
     * @param strategy Bishop move strategy.
     */
    Queen(Cell position, MoveStrategy strategy) {
        super(position, strategy);
    }

    /**
     * Construct Queen figure with default move strategy.
     *
     * @param position Figure position.
     */
    Queen(Cell position) {
        this(position, new QueenMoveStrategy());
    }

    /**
     * Move the figure on destination cell.
     *
     * @param dest Destination cell
     * @return Figure on destination cell
     */
    @Override
    Figure move(Cell dest) {
        return new Queen(dest, this.strategy);
    }
}
