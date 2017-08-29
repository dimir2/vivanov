package ru.job4j.pro.collections.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayContainer class.
 *
 * @param <E> Any object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 28.08.2017
 */
public class ArrayContainer<E> implements SimpleContainer<E> {
    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 8;
    /**
     * Container.
     */
    private Object[] container = {};
    /**
     * Pointer.
     */
    private int pointer = 0;
    /**
     * Capacity.
     */
    private int capacity;

    /**
     * Constructs container with the default capacity.
     */
    public ArrayContainer() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs container with the given capacity.
     *
     * @param capacity Initial capacity.
     */
    public ArrayContainer(int capacity) {
        this.capacity = (capacity > DEFAULT_CAPACITY) ? capacity : DEFAULT_CAPACITY;
        this.container = new Object[capacity];
    }

    /**
     * Ensure capacity. Enlarge the array if needed.
     */
    private void ensureCapacity() {
        if (this.pointer == this.capacity) {
            int newCapacity = this.capacity + (this.capacity >> 1);
            Object[] arr = Arrays.copyOf(this.container, newCapacity);
            this.capacity = newCapacity;
            this.container = arr;
        }
    }

    /**
     * Return size of container.
     *
     * @return Size.
     */
    @Override
    public int size() {
        return this.pointer;
    }

    /**
     * Add element to container.
     *
     * @param element Element to add.
     */
    @Override
    public void add(E element) {
        this.ensureCapacity();
        this.container[this.pointer++] = element;
    }

    /**
     * Get the element by index.
     *
     * @param index Element index.
     * @return Element.
     * @throws ArrayIndexOutOfBoundsException out of bounds.
     */
    @Override
    public E get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= this.pointer) {
            throw new ArrayIndexOutOfBoundsException("Out of bound.");
        }
        return (E) (this.container[index]);
    }

    /**
     * Remove the element by index.
     *
     * @param index Element index.
     * @return Element.
     * @throws ArrayIndexOutOfBoundsException out of bounds.
     */
    @Override
    public E remove(int index) throws ArrayIndexOutOfBoundsException {
        E result = this.get(index);
        if (index < this.size() - 1) {
            System.arraycopy(this.container, index + 1, this.container, index, this.size() - (index + 1));
        }
        this.container[--this.pointer] = null;
        return result;
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
             * Next element index.
             */
            private int next = 0;

            /**
             * hasNext implementation.
             *
             * @return True, if next element exists.
             */
            @Override
            public boolean hasNext() {
                return next < size();
            }

            /**
             * Returns next element.
             *
             * @return Next element.
             * @throws NoSuchElementException no such element.
             */
            @Override
            public E next() throws NoSuchElementException {
                if (next == size()) {
                    throw new NoSuchElementException("No element left");
                }
                return (E) (container[next++]);
            }
        };
    }
}
