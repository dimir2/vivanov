package ru.job4j.multithreading.monitor.list;

/**
 * Node class.
 *
 * @param <T> Any type.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.08.2017
 */
public class Node<T> {
    /**
     * Node value.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    T value;
    /**
     * Next node in the list.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    Node<T> next;

    /**
     * Constructs a node.
     *
     * @param value Node value.
     */
    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}
