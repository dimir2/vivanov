package ru.job4j.chessboard;

/**
 * Class PawnMoveStrategy.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 22.08.2017
 */
abstract class PawnMoveStrategy extends MoveStrategy {
    /**
     * Get pawn bias allowed.
     *
     * @return Pawn allowed vertical bias.
     */
    abstract int getBias();

    /**
     * Get pawn home row.
     *
     * @return Pawn home row.
     */
    abstract int getHomeRow();

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

        if (to.column == from.column) {
            if (from.row == getHomeRow()) {
                if (to.row == from.row + 2 * this.getBias()) {
                    way = new Cell[]{from, new Cell(from.row + this.getBias(), from.column), to};
                }
            }
            if (to.row == from.row + this.getBias()) {
                way = new Cell[]{from, to};
            }
        }
        if (way == null) {
            throw new ImpossibleMoveException("Destination cell is not on Pawn way");
        }
        return way;
    }
}

