package ru.job4j.chessboard;

/**
 * Class RookMoveStrategy.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class RookMoveStrategy extends MoveStrategy {
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
        Cell[] way = Movement.getAxisCells(from, to);
        if (way == null) {
            throw new ImpossibleMoveException("Destination cell is not on Rook way");
        }
        return way;
    }
}
