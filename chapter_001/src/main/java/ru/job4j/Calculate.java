package ru.job4j;

/** 
 * Class Calculate 
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 05.08.2017
*/
public class Calculate {
	/**
	 * Echos given values tree times 
	 * @param value Value to be echoed
	 * @return Echo string
	*/
	public String echo(String value) {
		return String.format("%s %s %s", value, value, value);
	}

	/**
	 * Entry point of the Calculate class
	*/
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Calculate calc = new Calculate();
		String echo = calc.echo("ahh");
	}
}
