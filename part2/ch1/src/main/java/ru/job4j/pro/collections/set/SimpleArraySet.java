package ru.job4j.pro.collections.set;

import ru.job4j.pro.collections.list.ArrayContainer;

import java.util.Iterator;

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
     * Internal storage.
     */
    private ArrayContainer<T> storage;

    /**
     * Constructs set with the default capacity.
     */
    public SimpleArraySet() {
        this.storage = new ArrayContainer<>();
    }

    /**
     * Constructs set.
     *
     * @param capacity Initial capacity.
     */
    public SimpleArraySet(int capacity) {
        this.storage = new ArrayContainer<>(capacity);
    }

    /**
     * Size set.
     *
     * @return Size of set.
     */
    @Override
    public int size() {
        return this.storage.size();
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
        for (T elem : this.storage) {
            if (elem.equals(element)) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            this.storage.add(element);
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return this.storage.iterator();
    }
}
