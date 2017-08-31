package ru.job4j.pro.collections.map;

import java.util.Calendar;

/**
 * Class User.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 31.08.2017
 */
public class User {
    /**
     * User name.
     */
    private final String name;
    /**
     * User birthday.
     */
    private final Calendar birthday;
    /**
     * User children number.
     */
    private int children;

    /**
     * Constructs user.
     *
     * @param name     Name.
     * @param birthday Birthday.
     */
    public User(String name, Calendar birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    /**
     * Get user children number.
     *
     * @return Number of user children.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Set user children number.
     *
     * @param children Children number.
     */
    public void setChildren(int children) {
        this.children = children;
    }
}
