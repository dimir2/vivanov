package ru.job4j.pro.collections.map;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Class UserTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 31.08.2017
 */
public class UserTest {
    /**
     * Test get/set User children.
     */
    @Test
    public void whenSetChildrenNumberThenCanGetIt() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(1001, 12, 21);
        User user = new User("John Snow", birthday);

        user.setChildren(21);
        int result = user.getChildren();

        assertThat(result, is(21));
    }

    /**
     * Test user default equality (not equal actually).
     * Should be vise versa, so Ignore this case in future.
     */
    @Ignore
    @Test
    public void whenTestTwoUsersWithTheSameNameAndBirthdayTheGetFalse() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(1001, 12, 21);
        User john = new User("John Snow", birthday);
        User snow = new User("John Snow", (Calendar) birthday.clone());

        assertFalse(john.equals(snow));
    }

    /**
     * Test user overridden equality.
     */
    @Test
    public void whenTestTwoUsersWithTheSameNameAndBirthdayTheGetTrue() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(1001, 12, 21);
        User john = new User("John Snow", birthday);
        User snow = new User("John Snow", (Calendar) birthday.clone());

        assertTrue(john.equals(snow));
    }

    /**
     * Test user default equality via HashMap(not equal actually).
     * Should be vise versa, so Ignore this case in future.
     */
    @Ignore
    @Test
    public void whenAddTwoUsersWithTheSameNameAndBirthdayToHashMapThenGetTwoElementsAdded() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(1001, 12, 21);
        User john = new User("John Snow", birthday);
        User snow = new User("John Snow", birthday);

        Map<User, String> map = new HashMap<>();
        map.put(john, "John Snow");
        map.put(snow, "John Snow");
        System.out.println(map);

        assertThat("Map has two values.", map.size(), is(2));
    }

    /**
     * Test user overridden equality via HashMap.
     */
    @Test
    public void whenAddTwoUsersWithTheSameNameAndBirthdayToHashMapThenGetOneElementAdded() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(1001, 12, 21);
        User john = new User("John Snow", birthday);
        User snow = new User("John Snow", birthday);

        Map<User, String> map = new HashMap<>();
        map.put(john, "John Snow 1");
        map.put(snow, "John Snow 2");
        System.out.println(map);

        assertThat("Map has two values.", map.size(), is(1));
    }
}