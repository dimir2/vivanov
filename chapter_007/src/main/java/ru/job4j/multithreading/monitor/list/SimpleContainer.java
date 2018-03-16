package ru.job4j.multithreading.monitor.list;

/**
 * SimpleContainer class.
 *
 * @param <E> Any object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 28.08.2017
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Return size of container.
     *
     * @return Size.
     */
    int size();

    /**
     * Add element to container.
     *
     * @param element Element to add.
     */
    void add(E element);

    /**
     * Get the element by index.
     *
     * @param index Element index.
     * @return Element.
     */
    E get(int index);

    /**
     * Remove the element by index.
     *
     * @param index Element index.
     * @return Element.
     */
    E remove(int index);
}
