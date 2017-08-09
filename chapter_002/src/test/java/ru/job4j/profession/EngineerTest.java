package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class EngineerTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class EngineerTest {

    /**
     * Fixing Test.
     */
    @Test
    public void whenDoctorHealsThenHeHealsWell() {
        Profession engineer = new Engineer("Maxim");
        Profession customer = new Customer("Anastasia");
        String result = ((Engineer) engineer).fix(customer);
        String expected = "Engineer Maxim fixing bugs for customer Anastasia well!";
        assertThat(result, is(expected));
    }
}
