package ru.job4j.pro.collections.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * NodeList class.
 *
 * @param <T> Any type.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.08.2017
 */
public class NodeList<T> {
    /**
     * Head node.
     */
    private final Node<T> head;

    /**
     * Creates node list.
     *
     * @param head First element of the list.
     */
    public NodeList(Node<T> head) {
        this.head = head;
    }

    /**
     * Returns iteratorOneStep with one step.
     *
     * @return Iterator.
     */
    private Iterator<Node<T>> iteratorOneStep() {
        return new Iterator<Node<T>>() {
            /**
             * Pointer to the current node.
             */
            private Node<T> pointer = head;

            /**
             * hasNext implementation.
             *
             * @return True, if next element exists.
             */
            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            /**
             * Returns next element.
             *
             * @return Next element.
             * @throws NoSuchElementException
             */
            @Override
            public Node<T> next() throws NoSuchElementException {
                if (pointer == null) {
                    throw new NoSuchElementException();
                }
                Node<T> node = pointer;
                pointer = pointer.next;
                return node;
            }
        };
    }

    /**
     * Returns iteratorOneStep with step two.
     *
     * @return Iterator.
     */
    private Iterator<Node<T>> iteratorTwoStep() {
        return new Iterator<Node<T>>() {
            /**
             * Original iteratorOneStep.
             */
            private Iterator<Node<T>> it = iteratorOneStep();

            /**
             * hasNext implementation.
             *
             * @return Does next element exist.
             */
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            /**
             * Return next-next element.
             *
             * @return Next-next element.
             * @throws NoSuchElementException
             */
            @Override
            public Node<T> next() throws NoSuchElementException {
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> result = it.next();
                if (it.hasNext()) {
                    it.next();
                }
                return result;
            }
        };
    }

    /**
     * Checks if there is a cycle in the list.
     *
     * @return True if there is a cycle, false if cannot find it.
     */
    public boolean hasCycle() {
        Iterator<Node<T>> itOne = this.iteratorOneStep();
        Iterator<Node<T>> itTwo = this.iteratorTwoStep();
        int counter = 0;
        while (counter < 2 && itOne.hasNext() && itTwo.hasNext()) {
            Node<T> nodeOne = itOne.next();
            Node<T> nodeTwo = itTwo.next();
            if (nodeOne.equals(nodeTwo)) {
                counter++;
            }
        }
        return counter == 2;
    }
}
