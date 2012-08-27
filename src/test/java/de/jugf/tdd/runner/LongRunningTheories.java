package de.jugf.tdd.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.experimental.theories.Theories;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;


public class LongRunningTheories extends Theories {

	public LongRunningTheories(final Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected void runChild(final FrameworkMethod method, final RunNotifier notifier) {
		if (!isLongRunning(method) || isLongRunningTestSupported()) {
			super.runChild(method, notifier);
		} else {
			notifier.fireTestIgnored(describeChild(method));			
		}
	}

	private boolean isLongRunning(final FrameworkMethod method) {
		final LongRunning annotation = method.getAnnotation(LongRunning.class);
		return annotation != null;
	}

	private boolean isLongRunningTestSupported() {
		return "true".equals(System.getProperty("LongRunning"));
	}
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface LongRunning {
	}

}
