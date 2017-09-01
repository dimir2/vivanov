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
     * User hashCode implementation.
     *
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    /**
     * User equals implementation.
     *
     * @param other Object to test on equality.
     * @return Result of equality test.
     */
    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (this != other) {
            result = true;
        } else {
            if (other != null && getClass() == other.getClass()) {
                User user = (User) other;
                if (name != null ? name.equals(user.name) : user.name == null) {
                    result = birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
                }
            }
        }
        return result;
    }

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
