package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
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
    private List<Item> items = new ArrayList<>();

    /**
     * Add item.
     *
     * @param item Item to add
     * @return item object
     */
    public Item add(Item item) {
        item.setId(UUID.randomUUID().toString().substring(0, 8));
        this.items.add(item);
        return item;
    }

    /**
     * Update item.
     *
     * @param item Updated item
     */
    public void update(Item item) {
        int index = this.findIndexById(item.getId());
        this.items.set(index, item);

    }

    /**
     * Delete item.
     *
     * @param item Item to be deleted
     */
    public void delete(Item item) {
        int index = this.findIndexById(item.getId());
        this.items.remove(index);
    }

    /**
     * Find all items.
     *
     * @return Array with all items
     */
    public List<Item> findAll() {
        return new ArrayList<Item>(this.items);
    }

    /**
     * Find items by name.
     *
     * @param name Name for search items
     * @return Array with items with the given name.
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
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
            result = this.items.get(index);
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
        for (int index = 0; index < this.items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }
}
