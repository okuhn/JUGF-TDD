package de.jugf.tdd.theories;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.jugf.tdd.basic.DemoService;
import de.jugf.tdd.runner.LongRunningTheories;
import de.jugf.tdd.runner.LongRunningTheories.LongRunning;

@RunWith(LongRunningTheories.class)
public class SquareTheory {
	
	private static final Log LOG = LogFactory.getLog(SquareTheory.class);	

	@DataPoint
	public static final double x1 = 2.456;
	
	@DataPoint
	public static final double x2 = 29372.456;
	
	@DataPoint
	public static final double x3 = 0.0;
	
	@DataPoint
	public static final double x4 = -2.456;
	
	private DemoService service;
	
	@Before
	public void init() {
		service = new DemoService();
	}
		
	@Theory
	public void squareRoot(final double x) {
		LOG.debug("validating theory for " + x);
		
		assumeThat(x, greaterThanOrEqualTo(0.0));
		
		LOG.debug("assumption valid for " + x);
		
		final double mySqr = service.mySqr(x);
		final double result = service.mySqrt(mySqr);	
		assertThat(result, equalTo(x));
		
		LOG.debug("theory succeeds for " + x);
	}
	
	@Theory
	@LongRunning
	public void longRunningTheory(final double x) throws InterruptedException {
		LOG.debug("checking longRunningTheory for value " + x);
		doSomething();
		LOG.debug("finished checking longRunningTheory for value " + x);
	}

	private void doSomething() throws InterruptedException {
		Thread.sleep(1000);
	}
}
