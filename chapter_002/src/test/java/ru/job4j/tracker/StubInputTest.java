package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StubInput Test.
 *
 * @author vivanov
 * @version 0.1
 * @since 14.08.2017
 */
public class StubInputTest {

    /**
     * Item add Test.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input stub = new StubInput(new String[]{"1", "name", "desc", "comment", "0"});
        new StartUI(tracker, stub).init();
        assertThat(tracker.findAll()[0].getName(), is("name"));
    }

    /**
     * Edit Item Test.
     */
    @Test
    public void whenEditThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desc", new String[]{"comment"});
        tracker.add(item);
        Input stub = new StubInput(new String[]{"3", item.getId(), "updated name", "upd desc", "", "0"});
        new StartUI(tracker, stub).init();
        assertThat(tracker.findById(item.getId()).getName(), is("updated name"));
    }

    /**
     * Delete Item Test.
     */
    @Test
    public void whenDeleteItemThenTrackerHasNoSuchItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desc", new String[]{"comment"});
        tracker.add(item);
        Input stub = new StubInput(new String[]{"4", item.getId(), "0"});
        new StartUI(tracker, stub).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

}