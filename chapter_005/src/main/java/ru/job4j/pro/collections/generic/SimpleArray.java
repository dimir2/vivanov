package ru.job4j.pro.collections.generic;

import static java.lang.String.format;

/**
 * Class SimpleArray.
 *
 * @param <T> Any class
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 26.08.2017
 */
public class SimpleArray<T> {
    /**
     * Internal storage.
     */
    private Object[] array;

    /**
     * Internal position.
     */
    private int position;

    /**
     * Constructs Simple array.
     *
     * @param capacity Array capacity.
     */
    public SimpleArray(int capacity) {
        this.array = new Object[capacity];
        this.position = 0;
    }

    /**
     * Add element to array.
     *
     * @param element Element of type T to be added.
     * @throws ArrayIndexOutOfBoundsException When array is empty
     */
    public void add(T element) throws ArrayIndexOutOfBoundsException {
        if (this.position < array.length) {
            this.array[this.position++] = element;
        } else {
            throw new ArrayIndexOutOfBoundsException(format("Array is full: %d elements allowed", this.position));
        }
    }

    /**
     * Get element on index.
     *
     * @param index Index in array.
     * @return Element.
     * @throws ArrayIndexOutOfBoundsException When index is out of bound.
     */
    public T get(int index) {
        if (index < 0 || index >= this.array.length) {
            throw new ArrayIndexOutOfBoundsException(format("Index %d is out of bound [0,%d]", index, this.array.length));
        }
        return (T) ((index < this.position) ? this.array[index] : null);
    }

    /**
     * Update element on index.
     *
     * @param index   Index to update.
     * @param element Element to update with.
     * @throws ArrayIndexOutOfBoundsException When index is out of bound.
     */
    public void update(int index, T element) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= this.position) {
            throw new ArrayIndexOutOfBoundsException(format("Index %d is out of bound [0,%d]", index, this.position));
        }
        this.array[index] = element;
    }

    /**
     * Delete element on index.
     *
     * @param index Index of element to delete.
     * @throws ArrayIndexOutOfBoundsException When index is out of bound.
     */
    public void delete(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= this.position) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (this.position > 0) {
            System.arraycopy(this.array, index, this.array, index + 1, this.position - (index + 1));
            this.position--;
        }
    }
}
