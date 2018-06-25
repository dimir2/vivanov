package ru.job4j.pro.collections.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class BinaryTree.
 *
 * @param <E> Any comparable object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 05.09.2017
 */
public class BinaryTree<E extends Comparable<E>> implements SimpleBinaryTree<E> {
    /**
     * Root of the tree.
     */
    private Node<E> root;

    /**
     * Add element to parent. Parent can hold any number of children.
     *
     * @param value Value to add.
     * @return Result of adding.
     */
    @Override
    public boolean add(E value) {
        boolean result = false;
        if (this.root == null) {
            this.root = new Node<>(value);
            result = true;
        } else {
            result = traverse(this.root, new Node<>(value));
        }
        return result;
    }

    /**
     * Traverse the tree, searching the plase to insert the value.
     *
     * @param root  Root node.
     * @param value Node with value to insert.
     * @return Result of insertion.
     */
    private boolean traverse(Node<E> root, Node<E> value) {
        boolean result = false;
        if (root != null) {
            if (root.compareTo(value) >= 0) {
                if (root.left != null) {
                    result = this.traverse(root.left, value);
                } else {
                    root.left = value;
                    result = true;
                }
            } else {
                if (root.right != null) {
                    result = this.traverse(root.right, value);
                } else {
                    root.right = value;
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Traverse the tree, collecting all values into the list.
     *
     * @param root Root node.
     * @param list List to accumulate found values.
     */
    private void traverse(Node<E> root, List<E> list) {
        if (root != null) {
            traverse(root.left, list);
            list.add(root.value);
            traverse(root.right, list);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * List iterator.
             */
            private Iterator<E> it;
            /**
             * List of all values.
             */
            private List<E> list = null;

            /**
             * hasNext implementation.
             *
             * @return True if tree has next element.
             */
            @Override
            public boolean hasNext() {
                if (list == null) {
                    list = new LinkedList<>();
                    traverse(root, list);
                    it = list.iterator();
                }
                return it.hasNext();
            }

            /**
             * Returns next element of the tree.
             *
             * @return Next element.
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return it.next();
            }
        };
    }

    /**
     * Class Node.
     *
     * @param <E> Any comparable object.
     */
    class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
        /**
         * Left node (less that or equal to parent).
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        Node<E> left;
        /**
         * Right node (grater than parent).
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        Node<E> right;
        /**
         * Value.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        E value;

        /**
         * Constructs the node.
         *
         * @param value Value.
         */
        Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        /**
         * Comparable interface implementation method.
         *
         * @param node Node to compare.
         * @return Result less than, equals to or grater than 0.
         */
        @Override
        public int compareTo(Node<E> node) {
            return this.value.compareTo(node.value);
        }
    }
}

