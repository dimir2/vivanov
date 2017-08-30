package ru.job4j.pro.collections.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleSet class.
 *
 * @param <T> Any object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.08.2017
 */
public class SimpleSet<T> implements Iterable<T> {
    /**
     * Internal storage.
     */
    private final Object[] storage;
    /**
     * Current position in storage.
     */
    private int position;

    /**
     * Constructs simple set.
     *
     * @param capacity Final capacity of the set.
     */
    public SimpleSet(int capacity) {
        this.storage = new Object[capacity];
        this.position = 0;
    }

    /**
     * Size set.
     *
     * @return Size of set.
     */
    public int size() {
        return this.position;
    }

    /**
     * Adds element to the set.
     *
     * @param element Element to add.
     */
    public void add(T element) {
        if (!this.alreadyExists(element)) {
            this.storage[this.position++] = element;
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
        for (int index = 0; index < this.position; index++) {
            if (((T) this.storage[index]).equals(element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * Current position.
             */
            private int current = 0;

            /**
             * hasNext implementation.
             *
             * @return True if current exists, false otherwise.
             */
            @Override
            public boolean hasNext() {
                return current < position;
            }

            /**
             * Returns next element if exists.
             *
             * @return Next element.
             * @throws NoSuchElementException no next element left.
             */
            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) storage[current++];
            }
        };
    }
}
