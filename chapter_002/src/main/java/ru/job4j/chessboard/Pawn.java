package ru.job4j.chessboard;

/**
 * Class Pawn.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 22.08.2017
 */
public class Pawn extends Figure {

    /**
     * Construct Pawn figure.
     *
     * @param position Position on the board
     * @param strategy Pawn Movement getStrategy implementation.
     */
    Pawn(Cell position, MoveStrategy strategy) {
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
        return new Pawn(dest, this.strategy);
    }
}
