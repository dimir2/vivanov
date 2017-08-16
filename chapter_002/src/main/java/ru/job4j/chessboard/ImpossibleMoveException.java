package ru.job4j.chessboard;

/**
 * Class ImpossibleMoveException.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 16.08.2017
 */
public class ImpossibleMoveException extends RuntimeException {

    /**
     * Construct new impossible way exception with the specified detail message.
     *
     * @param message The detailed message.
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
