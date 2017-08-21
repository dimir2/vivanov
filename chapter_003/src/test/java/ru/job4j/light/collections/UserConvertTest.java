package ru.job4j.light.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserConvertTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 21.08.2017
 */
public class UserConvertTest {
    /**
     * Convert User List to HashMap.
     */
    @Test
    public void whenConvertUserListThenGetHashMap() {
        List<User> list = new ArrayList<>(Arrays.asList(
                new User(1, "sergey", "nn"),
                new User(2, "maxim", "msk"),
                new User(3, "olga", "omsk"))
        );
        HashMap<Integer, User> result = new UserConvert().process(list);

        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, new User(1, "sergey", "nn"));
        expected.put(2, new User(2, "maxim", "msk"));
        expected.put(3, new User(3, "olga", "omsk"));

        assertThat(result, is(expected));
    }

}