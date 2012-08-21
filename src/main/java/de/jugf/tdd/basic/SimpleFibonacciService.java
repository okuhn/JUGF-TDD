package de.jugf.tdd.basic;

public class SimpleFibonacciService implements FibonacciService {

	@Override
	public long fib(final long n) {
		if (n < 0) {
			throw new IllegalArgumentException("Argument less than zero not allowed: " + n);
		}
		
		if (n <= 1) {
			return n;
		}
		
		return fib(n-1) + fib (n-2);
	}
}

