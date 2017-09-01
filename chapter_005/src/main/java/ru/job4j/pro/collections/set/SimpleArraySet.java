package ru.job4j.pro.collections.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleArraySet class.
 *
 * @param <T> Any object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.08.2017
 */
public class SimpleArraySet<T> implements SimpleSet<T> {
    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 8;
    /**
     * Internal storage.
     */
    private Object[] storage;
    /**
     * Current position in storage array.
     */
    private int position;
    /**
     * Current capacity.
     */
    private int capacity;

    /**
     * Constructs set with the default capacity.
     */
    public SimpleArraySet() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs set.
     *
     * @param capacity Initial capacity.
     */
    public SimpleArraySet(int capacity) {
        this.capacity = capacity;
        this.storage = new Object[capacity];
        this.position = 0;
    }

    /**
     * Ensure capacity. Enlarge the array if needed.
     */
    private void ensureCapacity() {
        if (this.position == this.capacity) {
            int newCapacity = this.capacity + (this.capacity >> 1);
            Object[] arr = Arrays.copyOf(this.storage, newCapacity);
            this.capacity = newCapacity;
            this.storage = arr;
        }
    }

    /**
     * Size set.
     *
     * @return Size of set.
     */
    @Override
    public int size() {
        return this.position;
    }

    /**
     * Adds element to the set.
     *
     * @param element Element to add.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void add(T element) {
        boolean exists = false;
        for (int index = 0; index < this.position; index++) {
            if (((T) this.storage[index]).equals(element)) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            this.ensureCapacity();
            this.storage[this.position++] = element;
        }
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
            @SuppressWarnings("unchecked")
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) storage[current++];
            }
        };
    }
}
