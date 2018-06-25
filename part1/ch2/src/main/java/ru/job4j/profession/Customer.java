package ru.job4j.profession;

/**
 * Class Customer.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class Customer extends Profession {

    /**
     * Constructor.
     * @param name Customer name
     */
    public Customer(String name) {
        super(name);
        setProfession("customer");
    }
}
