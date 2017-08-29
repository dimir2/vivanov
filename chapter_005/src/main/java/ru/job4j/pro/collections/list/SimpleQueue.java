package ru.job4j.pro.collections.list;

/**
 * SimpleQueue class.
 *
 * @param <T> Any object type.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 29.08.2017
 */
public class SimpleQueue<T> {
    /**
     * List container.
     */
    private ListContainer<T> list = new ListContainer<>();

    /**
     * Stack poll removes and return element added most recently.
     *
     * @return Element added most recently.
     * @throws EmptyQueueException Queue is empty
     */
    public T poll() throws EmptyQueueException {
        T element = null;
        try {
            element = list.remove(0);
        } catch (Exception e) {
            throw new EmptyQueueException();
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
