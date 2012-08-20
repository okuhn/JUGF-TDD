package de.jugf.tdd.basic;


public class DemoService {

	public int getResultAfterLongCalcluation() throws Exception {
		Thread.sleep(400);
		return 42;
	}
	
	public double mySqrt(double arg) {
		if (arg < 0) {
//			throw new RuntimeException("wrong type of  Exception");
			throw new IllegalArgumentException("Argument less than zero not allowed: " + arg);
		}
		return Math.sqrt(arg);
	}
	
	public double mySqr(double arg) {
		return arg * arg;
	}
}
