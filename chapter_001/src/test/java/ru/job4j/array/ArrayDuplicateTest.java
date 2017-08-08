package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ArrayDuplicateTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 08.08.2017
 */
public class ArrayDuplicateTest {

    /**
     * Test array with duplicates.
     */
    @Test
    public void whenArrayContainsDuplicatesThenItIsTrancated() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] array = {"Hello", "Hello", "world", "world", "!", "!"};
        String[] expected = {"Hello", "world", "!"};
        String[] result = ad.remove(array);
        assertThat(result, is(expected));
    }

    /**
     * Test array with one element.
     */
    @Test
    public void whenArrayContainsOneElementThenNoChanges() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] array = {"Hello"};
        String[] expected = {"Hello"};
        String[] result = ad.remove(array);
        assertThat(result, is(expected));
    }

    /**
     * Test array with the same elements.
     */
    @Test
    public void whenArrayContainsSameElementsThenOneElement() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] array = {"Hello", "Hello", "Hello", "Hello", "Hello"};
        String[] expected = {"Hello"};
        String[] result = ad.remove(array);
        assertThat(result, is(expected));
    }
}