package ru.job4j.pro.collections.list;

import java.util.EmptyStackException;

/**
 * SimpleStack class.
 *
 * @param <T> Any object type.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 29.08.2017
 */
public class SimpleStack<T> {
    /**
     * List container.
     */
    private ListContainer<T> list = new ListContainer<>();

    /**
     * Stack poll removes and return element added most recently.
     *
     * @return Element added most recently.
     * @throws EmptyStackException stack is empty.
     */
    public T poll() throws EmptyStackException {
        T element = null;
        try {
            element = list.remove(list.size() - 1);
        } catch (Exception e) {
            throw new EmptyStackException();
        }

        return element;
    }

    /**
     * Stack push adds element.
     *
     * @param value Element to add.
     */
    public void push(T value) {
        this.list.add(value);
    }
}
