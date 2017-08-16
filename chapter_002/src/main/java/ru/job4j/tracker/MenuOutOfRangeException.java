package ru.job4j.tracker;

/**
 * Menu out of range exception.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 16.08.2017
 */
public class MenuOutOfRangeException extends RuntimeException {

    /**
     * Constructor.
     *
     * @param message Message to display
     */
    public MenuOutOfRangeException(String message) {
        super(message);
    }
}
