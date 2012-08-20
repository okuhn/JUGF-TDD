package de.jugf.tdd.misc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class UsesErrorCollectorTwice {
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void example() {
		collector.addError(new Throwable("first thing went wrong"));
		collector.addError(new Throwable("second thing went wrong"));
		collector.checkThat(getResult(), not(containsString("ERROR!")));
		collector.checkThat(getResult(), not(containsString("Oops")));
		collector.checkThat(getResult(), not(containsString("sorry")));
		// all lines will run, and then a combined failure logged at the end.
	}

	private String getResult() {
//		return "Everything is fine!";
		return "Oops, sorry there's an ERROR!";
	}
}