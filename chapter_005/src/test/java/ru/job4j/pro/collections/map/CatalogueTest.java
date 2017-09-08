package ru.job4j.pro.collections.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class CatalogueTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 01.09.2017
 */
public class CatalogueTest {
    /**
     * Test insertion into Catalogue.
     */
    @Test
    public void whenInsertOnePairThenInsertReturTrue() {
        Catalogue<Object, String> cat = new Catalogue<>();

        boolean result = cat.insert(new Object(), "first");

        assertTrue(result);
    }

    /**
     * Test insertion into Catalogue.
     */
    @Test
    public void whenInsertOnePairThenCanGetIt() {
        Catalogue<String, String> cat = new Catalogue<>();
        cat.insert("key1", "first");

        String result = cat.get("key1");

        assertThat(result, is("first"));
    }

    /**
     * Test insertion into Catalogue.
     */
    @Test
    public void whenInsertOnePairThenCanDeleteIt() {
        Catalogue<String, String> cat = new Catalogue<>();
        cat.insert("key1", "first");

        boolean result = cat.delete("key1");

        assertTrue(result);
    }

    /**
     * Test iteration on Catalogue.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void whenIterateOnCatalogThenItHasAllEntries() {
        Catalogue<Integer, String> cat = new Catalogue<>();
        cat.insert(1, "first");
        cat.insert(2, "second");
        cat.insert(3, "third");

        Iterator<Catalogue.Entry<Integer, String>> it = cat.iterator();

        Catalogue.Entry<Integer, String>[] result = (Catalogue.Entry<Integer, String>[]) new Catalogue.Entry<?, ?>[]{
                it.next(), it.next(), it.next()};

        Catalogue.Entry<Integer, String>[] expected = (Catalogue.Entry<Integer, String>[]) new Catalogue.Entry<?, ?>[]{
                new Catalogue.Entry(1, 1, "first"),
                new Catalogue.Entry(2, 2, "second"),
                new Catalogue.Entry(3, 3, "third")};

        assertThat(result, is(expected));
    }
}