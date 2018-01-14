package ru.job4j.multithreading.monitor;

/**
 * Class User.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 14.01.2018
 */
public class User {
    public int id;
    public int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (this == other) {
            result = true;
        } else {
            if (other != null && getClass() == other.getClass()) {
                User user = (User) other;
                result = id == user.id;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
