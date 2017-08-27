package ru.job4j.pro.collections;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class RoleStoreTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 28.08.2017
 */
public class RoleStoreTest {
    /**
     * Test add role.
     */
    @Test
    public void whenAddRoleToRoleStoreThenItIsAdded() {
        Store<Role> store = new RoleStore(5);
        store.add(new Role("id_001"));

        Role expected = new Role("id_001");
        assertThat(store.asList().get(0), is(expected));
    }

    /**
     * Test update role.
     */
    @Test
    public void whenUpdateRoleThenItIsUpdated() {
        RoleStore store = new RoleStore(5);
        store.add(new Role("id_001"));
        store.add(new Role("id_002"));

        Role expected = new Role("id_002");
        store.update(expected);
        Role result = store.asList().get(1);
        assertTrue(result == expected);
    }

    /**
     * Test remove role.
     */
    @Test
    public void whenRemoveRoleThenItIsRemoved() {
        RoleStore store = new RoleStore(5);
        store.add(new Role("id_001"));
        store.add(new Role("id_002"));

        Role role = new Role("id_002");
        store.remove(role);
        int result = store.asList().size();
        assertThat(result, is(1));
    }
}