package ru.job4j.pro.collections.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class UserStoreTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public class UserStoreTest {
    /**
     * Test add user.
     */
    @Test
    public void whenAddUserToUserStoreThenItIsAdded() {
        Store<User> store = new UserStore(5);
        store.add(new User("id_001"));

        User expected = new User("id_001");
        assertThat(store.asList().get(0), is(expected));
    }

    /**
     * Test update user.
     */
    @Test
    public void whenUpdateUserThenItIsUpdated() {
        UserStore store = new UserStore(5);
        store.add(new User("id_001"));
        store.add(new User("id_002"));

        User expected = new User("id_002");
        store.update(expected);
        User result = store.asList().get(1);
        assertTrue(result == expected);
    }

    /**
     * Test remove user.
     */
    @Test
    public void whenRemoveUserThenItIsRemoved() {
        UserStore store = new UserStore(5);
        store.add(new User("id_001"));
        store.add(new User("id_002"));

        User user = new User("id_002");
        store.remove(user);
        int result = store.asList().size();
        assertThat(result, is(1));
    }
}