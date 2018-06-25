package ru.job4j.pro.collections.tree;

/**
 * Interface SimpleBinaryTree.
 *
 * @param <E> Any comparable object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 04.09.2017
 */
public interface SimpleBinaryTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add element to tree.
     *
     * @param value Value to add.
     * @return Result of adding.
     */
    boolean add(E value);
}
