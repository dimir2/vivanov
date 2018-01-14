package ru.job4j.multithreading.monitor;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserStorageTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 14.01.2018
 */
public class UserStorageTest {

    @Test
    public void whenTransferTenThenItIsTransfered() {
        UserStorage storage = new UserStorage();
        User from = new User(1, 100);
        User to = new User(2, 100);
        storage.add(from);
        storage.add(to);
        storage.transfer(1, 2, 50);
        assertThat(from.amount, is(50));
        assertThat(to.amount, is(150));
    }
}