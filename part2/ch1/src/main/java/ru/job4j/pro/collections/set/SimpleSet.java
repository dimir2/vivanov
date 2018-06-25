package ru.job4j.pro.collections.set;

/**
 * Interface SimpleSet.
 *
 * @param <T> Any object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.082017
 */
public interface SimpleSet<T> extends Iterable<T> {
    /**
     * Size set.
     *
     * @return Size of set.
     */
    int size();

    /**
     * Adds element to the set.
     *
     * @param element Element to add.
     */
    void add(T element);
}
