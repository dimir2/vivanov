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
     * @param position Position on the board
     * @param strategy Bishop Movement getStrategy implementation.
     */
    Bishop(Cell position, MoveStrategy strategy) {
        super(position, strategy);
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
