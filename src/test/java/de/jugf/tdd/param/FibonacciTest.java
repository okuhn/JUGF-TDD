package de.jugf.tdd.param;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.jugf.tdd.basic.FibonacciService;
import de.jugf.tdd.basic.SimpleFibonacciService;
import de.jugf.tdd.runner.JugfParameterized;
import de.jugf.tdd.runner.JugfParameterized.Parameters;

@RunWith(JugfParameterized.class)
public class FibonacciTest {
	
	private static final Log LOG = LogFactory.getLog(FibonacciTest.class);

	@Parameters
	public static List<Long[]> params() {
		return Arrays.asList(new Long[][] {
				{0L, 0L},
				{1L, 1L},
				{2L, 1L},
				{3L, 2L},
				{4L, 3L},
				{5L, 5L},
				{19L, 4181L},
				{26L, 121393L},
//				{40L, 102334155L },
//				{45L, 1134903170L },
//				{49L, 7778742049L },
//				{50L, 12586269025L },
				{-10L, null}
		});
	}

	private final Long arg; 
	private final Long expectedResult;
	
	private FibonacciService service = new SimpleFibonacciService();
	
	public FibonacciTest(Long arg, Long expectedResult) {
		this.arg = arg;
		this.expectedResult = expectedResult;
	}

	@Test(timeout=200L)
	public void testPositive() {
		Assume.assumeThat(arg, Matchers.greaterThanOrEqualTo(0L));
		LOG.debug("Check that fib(" + arg+ ") = " + expectedResult);
		final long result = service.fib(arg);
		Assert.assertThat(result, IsEqual.<Long>equalTo(expectedResult));
	}

	@Test(timeout=200L, expected=IllegalArgumentException.class)
	public void testNegative() {
		assumeThat(arg, lessThan(0L));
		LOG.debug("Check that fib(" + arg+ ")  is undefined");
		service.fib(arg);
	}
	
}
