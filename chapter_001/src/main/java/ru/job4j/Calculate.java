package ru.job4j;

public class Calculate {
	public String echo(String value) {
		return String.format("%s %s %s", value, value, value);
	}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Calculate calc = new Calculate();
		System.out.println(calc.echo("ahh"));
	}
}
