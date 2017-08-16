package ru.job4j.chessboard;

/**
 * Class FigureNotFoundException.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 16.08.2017
 */
public class FigureNotFoundException extends RuntimeException {

    /**
     * Construct new figure not found exception with the specified detail message.
     *
     * @param message The detailed message.
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}
