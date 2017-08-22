package ru.job4j.chessboard;

/**
 * Class BlackPawnMoveStrategy.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class BlackPawnMoveStrategy extends PawnMoveStrategy {
    /**
     * Get black pawn bias allowed.
     */
    @Override
    int getBias() {
        return 1;
    }

    /**
     * Get black pawn home row.
     *
     * @return Black pawn home row.
     */
    @Override
    int getHomeRow() {
        return 1;
    }
}
