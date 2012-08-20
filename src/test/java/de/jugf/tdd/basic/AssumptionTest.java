package de.jugf.tdd.basic;

import static org.junit.Assert.fail;

import org.hamcrest.core.IsEqual;
import org.junit.Assume;
import org.junit.Test;

public class AssumptionTest {

	@Test
	public void test() {
		Assume.assumeThat(1, IsEqual.<Integer>equalTo(2));
		fail("Not yet implemented");
	}

}
