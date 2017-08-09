package ru.job4j.profession;

/**
 * Class Engineer.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class Engineer extends Profession {

    /**
     * Constructor.
     *
     * @param name Engineer name
     */
    public Engineer(String name) {
        super(name);
        setProfession("Engineer");
    }

    /**
     * Common activity of Engineer.
     *
     * @param customer {@link Customer} to serve
     * @return String with engineer's activity description
     */
    public String fix(Profession customer) {
        return String.format("%s %s fixing bugs for %s %s well!", getProfession(), getName(), customer.getProfession(), customer.getName());
    }
}
