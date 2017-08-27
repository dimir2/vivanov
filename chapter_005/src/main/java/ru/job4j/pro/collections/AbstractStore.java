package ru.job4j.pro.collections;

import java.util.ArrayList;

/**
 * Class AbstractStore.
 *
 * @param <T> A successor of type Base.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
     * SimpleArray storage.
     */
    private final SimpleArray<T> array;
    /**
     * SimpleArray capacity.
     */
    private final int capacity;

    /**
     * Construct Store.
     *
     * @param capacity Storage capacity.
     */
    public AbstractStore(int capacity) {
        this.capacity = capacity;
        this.array = new SimpleArray<>(capacity);
    }

    /**
     * Add element to store.
     *
     * @param element Element to store.
     */
    @Override
    public void add(T element) {
        if (element != null) {
            this.array.add(element);
        }
    }

    /**
     * Get elements from store.
     *
     * @return List of elements.
     */
    @Override
    public ArrayList<T> asList() {
        ArrayList<T> list = new ArrayList<>(capacity);
        for (int i = 0; i < this.capacity; i++) {
            T element = this.array.get(i);
            if (element == null) {
                break;
            } else {
                list.add(element);
            }
        }
        return (ArrayList<T>) list;

    }

    /**
     * Update element in store.
     *
     * @param element Element to update.
     */
    @Override
    public void update(T element) {
        int index = this.findIndex(element);
        if (index != -1) {
            this.array.update(index, element);
        }
    }

    /**
     * Remove element from store.
     *
     * @param element Element to remove.
     */
    @Override
    public void remove(T element) {
        int index = this.findIndex(element);
        if (index != -1) {
            this.array.delete(index);
        }
    }

    /**
     * Find element index.
     *
     * @param element Element to find.
     * @return Index in SimpleArray.
     */
    private int findIndex(T element) {
        ArrayList<T> list = this.asList();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(element)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
