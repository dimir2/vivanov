package ru.job4j.chessboard;

/**
 * Class OccupiedWayException.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 16.08.2017
 */
public class OccupiedWayException extends RuntimeException {

    /**
     * Construct new occupied way exception with the specified detail message.
     *
     * @param message The detailed message.
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}
