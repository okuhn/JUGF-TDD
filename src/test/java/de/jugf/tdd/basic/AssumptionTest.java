package de.jugf.tdd.basic;

import static org.junit.Assert.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.IsEqual;
import org.junit.Assume;
import org.junit.Test;

public class AssumptionTest {

	private static final Log LOG = LogFactory.getLog(ResultExampleTest.class);
	
	@Test
	public void test() {
		LOG.debug("test with invalid assumption");
		Assume.assumeThat(1, IsEqual.<Integer>equalTo(2));
		fail("this should not happen");
	}

}
