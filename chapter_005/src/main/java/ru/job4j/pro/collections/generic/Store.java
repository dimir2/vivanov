package ru.job4j.pro.collections.generic;

import java.util.List;

/**
 * Class Store.
 *
 * @param <T> A successor of Base type.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public interface Store<T extends Base> {
    /**
     * Add element to store.
     *
     * @param element Element to store.
     */
    void add(T element);

    /**
     * Update element in store.
     *
     * @param element Element to update.
     */
    void update(T element);

    /**
     * Remove element from store.
     *
     * @param element Element to remove.
     */
    void remove(T element);

    /**
     * Return all elements from the store as list.
     *
     * @return Elements list.
     */
    List asList();
}
