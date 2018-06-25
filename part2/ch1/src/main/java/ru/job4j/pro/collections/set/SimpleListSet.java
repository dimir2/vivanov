package ru.job4j.pro.collections.set;

import ru.job4j.pro.collections.list.ListContainer;

import java.util.Iterator;

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
     * Internal list.
     */
    private ListContainer<T> list;

    /**
     * Constructs list.
     */
    public SimpleListSet() {
        this.list = new ListContainer<>();
    }

    /**
     * Size set.
     *
     * @return Size of set.
     */
    @Override
    public int size() {
        return this.list.size();
    }

    /**
     * Adds element to the set.
     *
     * @param element Element to add.
     */
    @Override
    public void add(T element) {
        boolean exists = false;
        for (T elem : this.list) {
            if (elem.equals(element)) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            list.add(element);
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
