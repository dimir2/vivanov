package ru.job4j.pro.collections.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleListSet.
 *
 * @param <T> Any object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.08.2017
 */
public class SimpleListSet<T> implements SimpleSet<T> {
    /**
     * Head of the list.
     */
    private Node<T> head;
    /**
     * Tail of the list.
     */
    private Node<T> tail;
    /**
     * Size of container.
     */
    private int size;

    /**
     * Constructs list.
     */
    public SimpleListSet() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Size set.
     *
     * @return Size of set.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Adds element to the set.
     *
     * @param element Element to add.
     */
    @Override
    public void add(T element) {
        if (!alreadyExists(element)) {
            Node<T> node = new Node<>(element);
            if (this.head == null && this.tail == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
            this.size++;
        }
    }

    /**
     * Checks if the element exists.
     *
     * @param element Element to test.
     * @return True if element already exists, false otherwise.
     */
    private boolean alreadyExists(T element) {
        boolean result = false;
        for (T setElement : this) {
            if (setElement.equals(element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * Pointer to the current node.
             */
            private Node<T> pointer = head;

            /**
             * hasNext implementation.
             *
             * @return True, if next element exists.
             */
            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            /**
             * Returns next element.
             *
             * @return Next element.
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No element left");
                }
                T element = pointer.element;
                pointer = pointer.next;
                return element;
            }
        };
    }

    /**
     * Node class.
     *
     * @param <T> Any object.
     * @author Vladimir Ivanov
     * @version 0.1
     * @since 30.08.2017
     */
    private static class Node<T> {
        /**
         * Nex node in the list.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        Node<T> next;
        /**
         * Node element.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        T element;

        /**
         * Construct node.
         *
         * @param element Element to store.
         */
        Node(T element) {
            this.next = null;
            this.element = element;
        }
    }
}
