package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Item item = new Item("name", "desc", "Added");
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    /**
     * Update item test.
     */
    @Test
    public void whenUpdateItemThenItIsUpdated() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desc", "Added");
        tracker.add(item);
        item.addComment("Updated.");
        tracker.update(item);
        List<String> expected = new ArrayList<>();
        expected.add("Added");
        expected.add("Updated.");
        assertThat(tracker.findAll().get(0).getComments(), is(expected));
    }

    /**
     * Delete item test.
     */
    @Test
    public void whenDeleteItemThenTrackerLostIt() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desc", "Added");
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
        List<Item> items = new ArrayList<>(Arrays.asList(new Item("name1", "desc1"), new Item("name2", "desc2")));
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        assertThat(tracker.findAll(), is(items));
    }

    /**
     * Find by name item test.
     */
    @Test
    public void whenFindByNameThenGetItemsArray() {
        Tracker tracker = new Tracker();
        List<Item> items = new ArrayList<>(Arrays.asList(new Item("name", "desc1"), new Item("name", "desc2")));
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        assertThat(tracker.findByName("name"), is(items));
    }

    /**
     * Find by ID item test.
     */
    @Test
    public void whenFindByIdThenGetOneItem() {
        Tracker tracker = new Tracker();
        List<Item> items = new ArrayList<>(Arrays.asList(new Item("name1", "desc1"), new Item("name2", "desc2")));
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        assertThat(tracker.findById(items.get(0).getId()), is(items.get(0)));
    }

}