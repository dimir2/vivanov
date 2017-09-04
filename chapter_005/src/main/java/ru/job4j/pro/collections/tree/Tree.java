package ru.job4j.pro.collections.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class Tree.
 *
 * @param <E> Any comparable object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 04.09.2017
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Root of the tree.
     */
    private Node<E> root;

    /**
     * Add element to parent. Parent can hold any number of children.
     *
     * @param parent Parent.
     * @param child  Child.
     * @return Result of adding.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Node<E> par = null;
        if (this.root == null) {
            this.root = new Node(parent);
        }
        par = this.traverse(this.root, new Node<>(parent));
        if (par != null) {
            par.children.add(new Node(child));
            result = true;
        }
        return result;
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
     * Traverse the tree, collecting all values into the list.
     *
     * @param root Root node.
     * @param list List to accumulate found values.
     */
    private void traverse(Node<E> root, List<E> list) {
        if (root != null) {
            list.add(root.value);
            for (Node<E> node : root.children) {
                traverse(node, list);
            }
        }
    }

    /**
     * Traverse the tree, searching the value.
     *
     * @param root  Root node.
     * @param value Node with value to search.
     * @return Node, containing the value.
     */
    private Node<E> traverse(Node<E> root, Node<E> value) {
        Node<E> result = null;
        if (root != null) {
            if (root.compareTo(value) == 0) {
                result = root;
            } else {
                for (Node<E> node : root.children) {
                    result = traverse(node, value);
                    if (result != null) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Class Node.
     *
     * @param <E> Any comparable object.
     */
    class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
        /**
         * Children.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        List<Node<E>> children;
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
            this.children = new LinkedList<>();
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
