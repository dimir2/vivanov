package ru.job4j.light;

/**
 * Class User.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 21.08.2017
 */
public class User {

    /**
     * User id.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final int id;
    /**
     * User name.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final String name;
    /**
     * User city.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final String city;

    /**
     * Construct a user.
     *
     * @param id   User id.
     * @param name User name.
     * @param city User city.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Auto generated equals.
     *
     * @param o Object to compare
     * @return Equality test result
     */
    @Override
    public boolean equals(Object o) {
        boolean result = true;
        if (this != o) {
            if (o == null || getClass() != o.getClass()) {
                result = false;
            } else {
                User user = (User) o;
                if (id != user.id) {
                    result = false;
                } else if ((name != null) ? !name.equals(user.name) : user.name != null) {
                    result = false;
                } else {
                    result = (city != null) ? city.equals(user.city) : user.city == null;
                }
            }
        }
        return result;
    }

    /**
     * Auto generated hashCode.
     *
     * @return hashCode calculated.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + ((name != null) ? name.hashCode() : 0);
        result = 31 * result + ((city != null) ? city.hashCode() : 0);
        return result;
    }
}
