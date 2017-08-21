package ru.job4j.light;

import org.junit.Test;

import java.util.ArrayList;
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
        List<User> list = new ArrayList<>();
        list.add(new User(1, "sergey", "nn"));
        list.add(new User(2, "maxim", "msk"));
        list.add(new User(3, "olga", "omsk"));
        HashMap<Integer, User> result = new UserConvert().process(list);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(Integer.valueOf(1), new User(1, "sergey", "nn"));
        expected.put(Integer.valueOf(2), new User(2, "maxim", "msk"));
        expected.put(Integer.valueOf(3), new User(3, "olga", "omsk"));
        assertThat(result, is(expected));
    }

}