package ru.job4j.multithreading.monitor.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ListContainer.
 *
 * @param <E> Any object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 28.08.2017
 */
@ThreadSafe
public class ListContainer<E> implements SimpleContainer<E> {
    /**
     * Head of the list.
     */
    private Node<E> head;
    /**
     * tail of the list.
     */
    private Node<E> tail;
    /**
     * Size of container.
     */
    @GuardedBy("this")
    private int size;

    /**
     * Constructs ListContainer.
     */
    public ListContainer() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Return size of container.
     *
     * @return Size.
     */
    @Override
    public synchronized int size() {
        return this.size;
    }

    /**
     * Add element to container.
     *
     * @param element Element to add.
     */
    @Override
    public synchronized void add(E element) {
        Node<E> node = new Node<>(element);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.prev = this.tail;
            node.prev.next = node;
            this.tail = node;
        }
        this.size++;
    }

    /**
     * Get the element by index.
     *
     * @param index Element index.
     * @return Element.
     */
    @Override
    @SuppressWarnings("unchecked")
    public synchronized E get(int index) {
        return this.getNode(index).element;
    }

    /**
     * Remove the element by index.
     *
     * @param index Element index.
     * @return Element.
     */
    @Override
    @SuppressWarnings("unchecked")
    public synchronized E remove(int index) {
        Node<E> node = this.getNode(index);
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        this.size--;
        return node.element;
    }

    /**
     * Get list node by index.
     *
     * @param index Node index.
     * @return Node
     */
    private Node<E> getNode(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Out of bound.");
        }
        Node<E> node = head;
        int position = 0;
        int step = 1;
        if (index > this.size() / 2) {
            node = tail;
            position = this.size() - 1;
            step = -1;
        }
        while (position != index) {
            node = (step < 0) ? node.prev : node.next;
            position += step;
        }
        return node;
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator.
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Pointer to the current node.
             */
            private Node<E> pointer = head;

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
            @SuppressWarnings("unchecked")
            public E next() {
                if (pointer == null) {
                    throw new NoSuchElementException();
                }
                E element = pointer.element;
                pointer = pointer.next;
                return element;
            }
        };
    }

    /**
     * Node class.
     *
     * @param <E> Any object.
     * @author Vladimir Ivanov
     * @version 0.1
     * @since 28.08.2017
     */
    private static class Node<E> {
        /**
         * Previous node in the list.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        Node<E> prev;
        /**
         * Nex node in the list.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        Node<E> next;
        /**
         * Node element.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        E element;

        /**
         * Construct node.
         *
         * @param element Element to store.
         */
        Node(E element) {
            this.prev = null;
            this.next = null;
            this.element = element;
        }
    }
}
