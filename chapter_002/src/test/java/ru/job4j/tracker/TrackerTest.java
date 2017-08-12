package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Tracker Test.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 12.08.2017
 */
public class TrackerTest {

    /**
     * Add item test.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desc", new String[]{"Added"});
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Update item test.
     */
    @Test
    public void whenUpdateItemThenItIsUpdated() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desc", new String[]{"Added"});
        tracker.add(item);
        item.setComments(new String[]{"Added", "Updated."});
        tracker.update(item);
        assertThat(tracker.findAll()[0].getComments(), is(new String[]{"Added", "Updated."}));
    }

    /**
     * Delete item test.
     */
    @Test
    public void whenDeleteItemThenTrackerLostIt() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desc", new String[]{"Added"});
        tracker.add(item);
        String id = item.getId();
        tracker.delete(item);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    /**
     * Find all items test.
     */
    @Test
    public void whenFindAllThenGetAllItems() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[]{new Item("name1", "desc1"), new Item("name2", "desc2")};
        tracker.add(items[0]);
        tracker.add(items[1]);
        assertThat(tracker.findAll(), is(items));
    }

    /**
     * Find by name item test.
     */
    @Test
    public void whenFindByNameThenGetItemsArray() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[]{new Item("name", "desc1"), new Item("name", "desc2")};
        tracker.add(items[0]);
        tracker.add(items[1]);
        assertThat(tracker.findByName("name"), is(items));
    }

    /**
     * Find by ID item test.
     */
    @Test
    public void whenFindByIdThenGetOneItem() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[]{new Item("name1", "desc1"), new Item("name2", "desc2")};
        tracker.add(items[0]);
        tracker.add(items[1]);
        assertThat(tracker.findById(items[0].getId()), is(items[0]));
    }

}