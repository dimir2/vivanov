package ru.job4j.pro.collections.tree;

/**
 * Interface SimpleTree.
 *
 * @param <E> Any comparable object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 04.09.2017
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add element to parent. Parent can hold a lot of children.
     *
     * @param parent Parent.
     * @param child  Child.
     * @return Result of adding.
     */
    boolean add(E parent, E child);
}
