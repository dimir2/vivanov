package ru.job4j.light.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortUserTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 22.08.2017
 */
public class SortUserTest {
    /**
     * List of users to set of users.
     */
    @Test
    public void whenSortUserListThenGetUserSet() {
        List<User> list = new LinkedList<>(Arrays.asList(
                new User("marina", 18),
                new User("oleg", 25),
                new User("kiril", 20),
                new User("alex", 32),
                new User("olga", 23),
                new User("alex", 32))
        );
        Set<User> result = new SortUser().sort(list);
        Set<User> expected = new TreeSet<>(Arrays.asList(
                new User("marina", 18),
                new User("oleg", 25),
                new User("kiril", 20),
                new User("olga", 23),
                new User("alex", 32)));
        assertThat(result, is(expected));
    }
}