package ru.job4j.pro.collections.list;

/**
 * EmptyQueueException class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 29.08.2017
 */
public class EmptyQueueException extends RuntimeException {
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public EmptyQueueException() {
        super();
    }
}
