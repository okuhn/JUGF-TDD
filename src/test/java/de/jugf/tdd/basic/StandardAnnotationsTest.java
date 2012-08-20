package de.jugf.tdd.basic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StandardAnnotationsTest {

	private static final Log LOG = LogFactory.getLog(StandardAnnotationsTest.class);

	@BeforeClass
	public static void beforeClass() {
		LOG.debug("Before first test.");		
	}
	
	@AfterClass
	public static void afterClass() {
		LOG.debug("After last test.");		
	}
	
	@Before
	public void before() {
		LOG.debug("Before each test.");		
	}
	
	@After
	public void after() {
		LOG.debug("After each test.");		
	}
	
	@Test
	public void test1() {
		LOG.debug("This is test1.");
	}
	
	@Test
	public void test2() {
		LOG.debug("This is test2.");
	}
	
}
