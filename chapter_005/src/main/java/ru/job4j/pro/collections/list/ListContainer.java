package ru.job4j.pro.collections.list;

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
public class ListContainer<E> implements SimpleContainer<E> {
    /**
     * Head of the list.
     */
    private Node head;
    /**
     * tail of the list.
     */
    private Node tail;
    /**
     * Size of container.
     */
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
    public int size() {
        return this.size;
    }

    /**
     * Add element to container.
     *
     * @param element Element to add.
     */
    @Override
    public void add(E element) {
        Node node = new Node(element);
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
    public E get(int index) {
        return (E) (this.getNode(index).element);
    }

    /**
     * Remove the element by index.
     *
     * @param index Element index.
     * @return Element.
     */
    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        Node node = this.getNode(index);
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
        return (E) node.element;
    }

    /**
     * Get list node by index.
     *
     * @param index Node index.
     * @return Node
     */
    private Node getNode(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Out of bound.");
        }
        Node node = head;
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
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Pointer to the current node.
             */
            private Node pointer = head;

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
                    throw new NoSuchElementException("No element left");
                }
                Object element = pointer.element;
                pointer = pointer.next;
                return (E) element;
            }
        };
    }

    /**
     * Node class.
     *
     * @author Vladimir Ivanov
     * @version 0.1
     * @since 28.08.2017
     */
    private static class Node {
        /**
         * Previous node in the list.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        Node prev;
        /**
         * Nex node in the list.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        Node next;
        /**
         * Node element.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        Object element;

        /**
         * Construct node.
         *
         * @param element Element to store.
         */
        Node(Object element) {
            this.prev = null;
            this.next = null;
            this.element = element;
        }
    }
}
