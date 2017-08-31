package ru.job4j.pro.collections.map;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


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
     * <p>
     * Should be vise versa, so Ignore this case in future.
     */
    @Test
    public void whenTestTwoUsersWithTheSameNameAndBirthdayTheGetFalse() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(1001, 12, 21);
        User john = new User("John Snow", birthday);
        User snow = new User("John Snow", (Calendar) birthday.clone());

        assertFalse(john.equals(snow));
    }

}