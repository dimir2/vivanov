package ru.job4j.pro.collections.tree;

/**
 * Interface SimpleTree.
 *
 * @param <E>
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
