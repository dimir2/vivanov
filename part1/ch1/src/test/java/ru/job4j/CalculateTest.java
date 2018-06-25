package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CalculateTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 06.08.2017
*/
public class CalculateTest {
	/**
	 * Echo test.
	*/
	@Test public void whenEchoOneStringThenGotThree() {
		Calculate calc = new Calculate();
		assertThat(calc.echo("ham"), is("ham ham ham"));
	}

	/**
	 * Test main entry point.
	*/
	@Test public void whenMainThenHellowWorldOnly() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(out.toString(),
			is(String.format("Hello World!%s",
				System.getProperty("line.separator"))));
	}
}

