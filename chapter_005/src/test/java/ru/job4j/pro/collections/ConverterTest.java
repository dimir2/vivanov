package ru.job4j.pro.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConverterTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 25.08.2017
 */
public class ConverterTest {
    /**
     * Test get all elements.
     */
    @Test
    public void whenGetAllElementsThenGetThemAll() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Arrays.asList(1, 2).iterator(),
                Arrays.asList(3, 4).iterator(),
                Arrays.asList(5, 6, 7).iterator()
        ).iterator();

        Iterator<Integer> convert = new Converter().convert(it);
        List<Integer> result = new ArrayList<>();
        while (convert.hasNext()) {
            result.add(convert.next());
        }

        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThat(result, is(expected));
    }

    /**
     * Test get all elements.
     */
    @Test
    public void whenGetAllElementsFromTaskThenGetThemAll() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator(),
                Arrays.asList(0, 9, 8, 7, 5).iterator(),
                Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator()
        ).iterator();

        Iterator<Integer> convert = new Converter().convert(it);
        List<Integer> result = new ArrayList<>();
        while (convert.hasNext()) {
            result.add(convert.next());
        }

        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4));
        assertThat(result, is(expected));
    }

    /**
     * Test second element of [[1],[2]].
     */
    @Test
    public void whenItHasTwoAsSecondElementThenGetTwo() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator()
        ).iterator();

        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();

        int result = convert.next();
        assertThat(result, is(2));
    }

    /**
     * Test out of last element of [[1],[2]].
     */
    @Test
    public void whenTryGetNextElementAfterLastThenGetNoSuchElementException() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);

        Exception result = null;
        try {
            convert.next();
            convert.next();
            convert.next();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(NoSuchElementException.class));
    }

    /**
     * Test get all elements when one List is empty.
     */
    @Test
    public void whenGetAllElementsWhenOneListIsEmptyThenGetThemAll() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Arrays.asList(1, 2).iterator(),
                new ArrayList<Integer>().iterator(),
                Arrays.asList(5, 6, 7).iterator()
        ).iterator();

        Iterator<Integer> convert = new Converter().convert(it);
        List<Integer> result = new ArrayList<>();
        while (convert.hasNext()) {
            result.add(convert.next());
        }

        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 5, 6, 7));
        assertThat(result, is(expected));
    }

}