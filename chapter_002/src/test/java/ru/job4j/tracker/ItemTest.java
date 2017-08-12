package ru.job4j.tracker;

import org.junit.Test;

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
        Item item = new Item("name", "desc", new String[]{"comment"});
        String[] expected = new String[]{"comment"};
        assertThat(item.getComments(), is(expected));
    }

    /**
     * Set item comments test.
     */
    @Test
    public void whenSetItemCommetsThenItemHasSameComments() {
        Item item = new Item("name", "desc", new String[]{"comment"});
        String[] expected = new String[]{"TestItemCOmments"};
        item.setComments(expected);
        assertThat(item.getComments(), is(expected));
    }

}