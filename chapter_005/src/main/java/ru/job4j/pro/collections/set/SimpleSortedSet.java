package ru.job4j.pro.collections.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleSortedSet.
 *
 * @param <T> Any object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.08.2017
 */
public class SimpleSortedSet<T extends Comparable<T>> implements SimpleSet<T> {
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
    public SimpleSortedSet() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs set.
     *
     * @param capacity Initial capacity.
     */
    public SimpleSortedSet(int capacity) {
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
     * Adds element into the sorted set.
     *
     * @param element Element to add.
     */
    @Override
    public void add(T element) {
        this.ensureCapacity();
        int index = Arrays.binarySearch(this.storage, 0, this.position, element);
        if (index < 0) {
            index = -1 - index;
            System.arraycopy(this.storage, index, this.storage, index + 1, this.size() - index);
            this.storage[index] = element;
            this.position++;
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
             * Next element index.
             */
            private int pointer = 0;

            /**
             * hasNext implementation.
             *
             * @return True, if next element exists.
             */
            @Override
            public boolean hasNext() {
                return pointer < size();
            }

            /**
             * Returns next element.
             *
             * @return Next element.
             * @throws NoSuchElementException no such element.
             */
            @Override
            public T next() throws NoSuchElementException {
                if (pointer == size()) {
                    throw new NoSuchElementException("No element left");
                }
                return (T) (storage[pointer++]);
            }
        };
    }
}
