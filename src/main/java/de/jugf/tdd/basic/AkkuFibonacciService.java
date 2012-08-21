package de.jugf.tdd.basic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AkkuFibonacciService implements FibonacciService {

	private static final Log LOG = LogFactory.getLog(AkkuFibonacciService.class);
	
	@Override
	public long fib(long n) {
		if (n < 0) {
			throw new IllegalArgumentException("Argument less than zero not allowed: " + n);
		}
		
		if (n <= 1) {
			return n;
		}
		
		return fib(n, 2L, 1L, 0L);
	}

	private long fib(long arg, long n, long i, long j) {
		LOG.debug("fib(" + n + ") = " + i + " + " + j + " = " + i+j);
		
		if (arg == n) {
			return i + j;
		}
		
		return fib(arg, n+1, i+j, i);
	}

}
