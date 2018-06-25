package ru.job4j.chessboard;

/**
 * Class WhitePawnMoveStrategy.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class WhitePawnMoveStrategy extends PawnMoveStrategy {
    /**
     * Get white pawn bias allowed.
     */
    @Override
    int getBias() {
        return -1;
    }

    /**
     * Get white pawn home row.
     *
     * @return White pawn home row.
     */
    @Override
    int getHomeRow() {
        return 6;
    }
}
