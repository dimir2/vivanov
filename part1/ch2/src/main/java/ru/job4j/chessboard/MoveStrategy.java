package ru.job4j.chessboard;

/**
 * Class MoveStrategy.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 19.08.2017
 */
abstract class MoveStrategy {

    /**
     * Calculate all cells, figure must step on its way to destination.
     *
     * @param from Current position.
     * @param to   Destination.
     * @return Array of cells, representing figure way to destination.
     * @throws ImpossibleMoveException Move is impossible
     */
    abstract Cell[] way(Cell from, Cell to) throws ImpossibleMoveException;

    /**
     * Class Movement. Not supposed to be called outside Movement getStrategy hierarchy.
     * <p>
     * Provides common functions in the way calculation.
     *
     * @author Vladimir Ivanov
     * @version 0.1
     * @since 18.08.2017
     */
    static class Movement {
        /**
         * If possible, creates the array of cells, representing the diagonal.
         *
         * @param begin Start cell
         * @param end   End cell
         * @return Array of cells, null if cells are not belong the same diagonal.
         */
        public static Cell[] getDiagonalCells(Cell begin, Cell end) {
            Cell[] cells = null;
            int rowBias = end.row - begin.row;
            int columnBias = end.column - begin.column;
            if (Math.abs(columnBias) == Math.abs(rowBias)) {
                int rowStep = rowBias / Math.abs(rowBias);
                int columnStep = columnBias / Math.abs(columnBias);
                int length = Math.abs(rowBias) + 1;
                cells = new Cell[length];
                for (int index = 0; index < length; index++) {
                    cells[index] = new Cell(begin.row + rowStep * index, begin.column + columnStep * index);
                }
            }
            return cells;
        }

        /**
         * If possible, creates the array of cells, representing the axis move.
         *
         * @param begin Start cell
         * @param end   End cell
         * @return Array of cells, null if cells are not belong any axis.
         */
        public static Cell[] getAxisCells(Cell begin, Cell end) {
            Cell[] cells = null;
            int rowBias = end.row - begin.row;
            int columnBias = end.column - begin.column;
            if (rowBias == 0 || columnBias == 0) {
                int rowStep = (rowBias == 0) ? 0 : rowBias / Math.abs(rowBias);
                int columnStep = (columnBias == 0) ? 0 : columnBias / Math.abs(columnBias);
                int length = Math.abs(rowBias) + Math.abs(columnBias) + 1;
                cells = new Cell[length];
                for (int index = 0; index < length; index++) {
                    cells[index] = new Cell(begin.row + rowStep * index, begin.column + columnStep * index);
                }
            }
            return cells;
        }
    }


}
