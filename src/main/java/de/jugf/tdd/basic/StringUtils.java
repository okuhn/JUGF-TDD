package de.jugf.tdd.basic;

public class StringUtils {

	public static String filterUmlaut(final String input) {
		String output = input.replaceAll("Ä", "Ae");
		output = output.replaceAll("Ö", "Oe");
		output = output.replaceAll("Ü", "Ue");
		output = output.replaceAll("ä", "ae");
		output = output.replaceAll("ö", "oe");
		output = output.replaceAll("ü", "ue");
		output = output.replaceAll("ß", "ss");
		return output;
	}

}
