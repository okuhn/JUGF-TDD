package de.jugf.tdd.basic;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;

public class ResultExampleTest {

	private static final Log LOG = LogFactory.getLog(ResultExampleTest.class);

	@Test
	public void test() {
		LOG.debug("success");
	}
	
	@Test
	@Ignore
	public void ignoredTest() {
		LOG.debug("ignored");
	}	

	@Test
	//@Ignore
	public void failureTest() {
		LOG.debug("Before failure");
		fail("Forced failure");
		LOG.debug("After failure");
	}	
	
	@Test
	//@Ignore
	public void uncheckedExceptionTest() {
		LOG.debug("before uncheckedException");
		throw new RuntimeException("Forced error");
	}	

	@Test
	//@Ignore
	public void checkedExceptionTest() throws Exception {
		LOG.debug("before checkedException");
		throw new Exception("Forced error");
	}	

}
