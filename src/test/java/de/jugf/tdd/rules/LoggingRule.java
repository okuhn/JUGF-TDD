package de.jugf.tdd.rules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class LoggingRule implements TestRule {
	private static final Log LOG = LogFactory.getLog(LoggingStatement.class);

	@Override
	public Statement apply(Statement base, Description description) {
		return new LoggingStatement(base, description);
	}
	
	private class LoggingStatement extends Statement {

		private final Statement targetStatement;
		private final Description description;

		public LoggingStatement(final Statement targetStatement, final Description description) {
			super();
			this.targetStatement = targetStatement;
			this.description = description;
		}

		@Override
		public void evaluate() throws Throwable {
			final boolean logMe = description.getAnnotation(LogMe.class) != null;
			if (logMe) {
				LOG.debug("before call of " + description.getDisplayName());
			}
			targetStatement.evaluate();
			if (logMe) {
				LOG.debug("after call of " + description.getDisplayName());
			}
		}
	}
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface LogMe {
	}
}