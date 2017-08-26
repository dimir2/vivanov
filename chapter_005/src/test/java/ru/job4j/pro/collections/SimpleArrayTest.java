package ru.job4j.pro.collections;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleArrayTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 26.08.2017
 */
public class SimpleArrayTest {
    /**
     * Test add element into array.
     */
    @Test
    public void whenAddOneElementThenArrayHasOneElement() {
        SimpleArray<String> arr = new SimpleArray<>(5);
        arr.add("first");

        String result = arr.get(0);
        assertThat(result, is("first"));
    }

    /**
     * Test add element into array, more than its capacity.
     */
    @Test
    public void whenElementsMoreThanCapacityThenGetArrayIndexOutOfBoundsException() {
        SimpleArray<String> arr = new SimpleArray<>(2);

        Exception result = null;
        try {
            arr.add("first");
            arr.add("second");
            arr.add("third");
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(ArrayIndexOutOfBoundsException.class));
    }

    /**
     * Test get element on valid index.
     */
    @Test
    public void whenArrayHasElementThenWeCanGetItByIndex() {
        SimpleArray<String> arr = new SimpleArray<>(5);
        arr.add("first");
        arr.add("second");

        String result = arr.get(1);
        assertThat(result, is("second"));
    }

    /**
     * Test get element with wrong index.
     */
    @Test
    public void whenTryToGetElementWithWrongIndexThenGetArrayIndexOutOfBoundsException() {
        SimpleArray<String> arr = new SimpleArray<>(2);
        arr.add("first");
        arr.add("second");

        Exception result = null;
        try {
            arr.get(3);
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(ArrayIndexOutOfBoundsException.class));
    }

    /**
     * Test update element on valid index.
     */
    @Test
    public void whenArrayHasElementThenWeCanUpdateIt() {
        SimpleArray<String> arr = new SimpleArray<>(5);
        arr.add("first");
        arr.add("second");
        arr.update(1, "Second");

        String result = arr.get(1);
        assertThat(result, is("Second"));
    }

    /**
     * Delete existing element.
     */
    @Test
    public void whenArrayHasElementThenWeCanDeleteIt() {
        SimpleArray<String> arr = new SimpleArray<>(5);
        arr.add("first");
        arr.add("second");
        arr.delete(1);

        String result = arr.get(1);
        assertThat(result, is(nullValue()));
    }
}