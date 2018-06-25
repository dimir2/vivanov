package ru.job4j.chessboard;

/**
 * Class KnightMoveStrategy.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class KnightMoveStrategy extends MoveStrategy {
    /**
     * Calculate all cells, figure must step on its way to destination.
     *
     * @param from Current position.
     * @param to   Destination.
     * @return Array of cells, representing figure way to destination.
     * @throws ImpossibleMoveException Move is impossible.
     */
    @Override
    Cell[] way(Cell from, Cell to) throws ImpossibleMoveException {
        Cell[] way = null;
        int rowBias = Math.abs(to.row - from.row);
        int columnBias = Math.abs(to.column - from.column);
        if ((rowBias == 2 && columnBias == 1) || (rowBias == 1 && columnBias == 2)) {
            way = new Cell[]{from, to};
        } else {
            throw new ImpossibleMoveException("Destination cell is not on Knight way");
        }
        return way;
    }
}
