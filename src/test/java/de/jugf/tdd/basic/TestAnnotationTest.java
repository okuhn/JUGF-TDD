package de.jugf.tdd.basic;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

public class TestAnnotationTest {

	private static final Log LOG = LogFactory.getLog(TestAnnotationTest.class);
	
	private DemoService service;
	
	@Before
	public void init() {
		service = new DemoService();
	}

	@Test(timeout=600)
	public void testSlow() throws Exception {
		LOG.debug("before long running operation");
		final int result = service.getResultAfterLongCalcluation();
		assertThat(result, is(equalTo(42)));
		LOG.debug("after long running operation");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testException() throws Exception {
		double x = service.mySqrt(-1);
		LOG.debug("sqrt of -1 is " + x);
	}

}
