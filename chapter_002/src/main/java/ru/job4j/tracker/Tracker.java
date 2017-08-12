package ru.job4j.tracker;

import java.util.Arrays;
import java.util.UUID;

/**
 * Class Tracker.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 12.08.2017
 */
public class Tracker {

    /**
     * Items Storage (hardcoded capacity is 100).
     */
    private Item[] items = new Item[100];

    /**
     * Internal counter (updated during add/delete ops).
     */
    private int counter = 0;

    /**
     * Add item.
     *
     * @param item Item to add
     * @return item object
     */
    public Item add(Item item) {
        item.setId(UUID.randomUUID().toString());
        this.items[this.counter++] = item;
        return item;
    }

    /**
     * Update item.
     *
     * @param item Updated item
     */
    public void update(Item item) {
        int index = this.findIndexById(item.getId());
        this.items[index] = item;

    }

    /**
     * Delete item.
     *
     * @param item Item to be deleted
     */
    public void delete(Item item) {
        int index = this.findIndexById(item.getId());
        for (int i = index + 1; i < this.counter; i++) {
            this.items[i - 1] = this.items[i];
        }
        this.items[--this.counter] = null;
    }

    /**
     * Find all items.
     *
     * @return Array with all items
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.counter);
    }

    /**
     * Find items by name.
     *
     * @param name Name for search items
     * @return Array with items with the given name.
     */
    public Item[] findByName(String name) {
        int[] indexes = new int[this.counter];
        int count = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.items[i].getName().equals(name)) {
                indexes[count++] = i;
            }
        }
        Item[] result = new Item[count];
        for (int i = 0; i < count; i++) {
            result[i] = this.items[indexes[i]];
        }
        return result;
    }

    /**
     * Find item by ID.
     *
     * @param id Item ID
     * @return Item with the given ID
     */
    public Item findById(String id) {
        Item result = null;
        int index = this.findIndexById(id);
        if (index >= 0) {
            result = this.items[index];
        }
        return result;
    }

    /**
     * Utility method to find item index by ID.
     *
     * @param id Item ID
     * @return Item index
     */
    private int findIndexById(String id) {
        int result = -1;
        for (int i = 0; i < this.counter; i++) {
            if (this.items[i].getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
