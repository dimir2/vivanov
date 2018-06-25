package ru.job4j.profession;

/**
 * Class Student.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class Student extends Profession {

    /**
     * Constructor.
     * @param name Student name
     */
    public Student(String name) {
        super(name);
        setProfession("student");
    }
}
