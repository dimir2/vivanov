package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Item Test.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 12.08.2017
 */
public class ItemTest {

    /**
     * Get/Set item ID test.
     */
    @Test
    public void whenSetItemIdThenGetSameId() {
        Item item = new Item("name", "desc");
        String expected = "TestItemId";
        item.setId(expected);
        assertThat(item.getId(), is(expected));
    }

    /**
     * Get item name test.
     */
    @Test
    public void whenCreateItemWithNameThenItemHasThisName() {
        Item item = new Item("name", "desc");
        String expected = "name";
        assertThat(item.getName(), is(expected));
    }

    /**
     * Set item name test.
     */
    @Test
    public void whenSetItemNameThenItemHaseSameName() {
        Item item = new Item("name", "desc");
        String expected = "TestItemName";
        item.setName(expected);
        assertThat(item.getName(), is(expected));
    }

    /**
     * Get item description test.
     */
    @Test
    public void whenCreateItemWithDescThenItemHasThisDesc() {
        Item item = new Item("name", "desc");
        String expected = "desc";
        assertThat(item.getDesc(), is(expected));
    }

    /**
     * Set item description test.
     */
    @Test
    public void whenSetItemDesdThenItemHaseSameDesc() {
        Item item = new Item("name", "desc");
        String expected = "TestItemDesc";
        item.setDesc(expected);
        assertThat(item.getDesc(), is(expected));
    }

    /**
     * Get item comments test.
     */
    @Test
    public void whenCreateItemWithCommentsThenItemHasSameComments() {
        Item item = new Item("name", "desc", "comment");
        List<String> expected = new ArrayList<>(Arrays.asList("comment"));
        assertThat(item.getComments(), is(expected));
    }

    /**
     * Add item comments test.
     */
    @Test
    public void whenAddItemCommetsThenItemHasBothComments() {
        Item item = new Item("name", "desc", "comment");
        List<String> expected = new ArrayList<>(Arrays.asList("comment", "added comment"));
        item.addComment("added comment");
        assertThat(item.getComments(), is(expected));
    }

}