package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class DoctorTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class DoctorTest {

    /**
     * Heal Test.
     */
    @Test
    public void whenDoctorHealsThenHeHealsWell() {
        Profession doctor = new Doctor("Sergio");
        Profession patient = new Patient("Maria");
        String result = ((Doctor) doctor).heal(patient);
        String expected = "Doctor Sergio heals patient Maria well!";
        assertThat(result, is(expected));
    }
}
