package ru.job4j.multithreading.monitor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;

/**
 * Class UserStorage.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 14.01.2018
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    final private HashSet<User> store = new HashSet<>();

    public synchronized boolean add(User user) {
        return this.store.add(user);
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        if (this.store.remove(user)) {
            result = this.store.add(user);
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        return store.remove(user);
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;

        User fromUser = new User(fromId, 0);
        User toUser = new User(toId, 0);
        if (this.store.contains(fromUser) && this.store.contains(toUser)) {
            for (User user : this.store) {
                if (user.id == fromId) {
                    fromUser = user;
                }
                if (user.id == toId) {
                    toUser = user;
                }
            }
            if (fromId == toId) {
                result = true;
            } else {
                if (fromUser.amount >= amount) {
                    toUser.amount = toUser.amount + amount;
                    fromUser.amount = fromUser.amount - amount;
                    result = true;
                }
            }
        }
        return result;
    }
}
