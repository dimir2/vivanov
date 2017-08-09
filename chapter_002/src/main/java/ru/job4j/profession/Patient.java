package ru.job4j.profession;

/**
 * Class Patient.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class Patient extends Profession {

    /**
     * Constructor.
     * @param name Patient name
     */
    public Patient(String name) {
        super(name);
        setProfession("patient");
    }
}