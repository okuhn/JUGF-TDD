package de.jugf.tdd.matcher;

import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CollectionSizeRangeMatcher extends TypeSafeMatcher<Collection<String>>
		implements Matcher<Collection<String>> {

	private final int lowerBound;
	private final int upperBound;
	
	public static CollectionSizeRangeMatcher collectionWithinSizeRange(final int lower, final int upper) {
		return new CollectionSizeRangeMatcher(lower, upper);
	}

	public CollectionSizeRangeMatcher(int lowerBound, int upperBound) {
		super();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public void describeTo(final Description desc) {
		desc.appendText("a collection containing at least " + lowerBound
				+ " and at most " + upperBound + " elements");
	}

	@Override
	protected boolean matchesSafely(final Collection<String> collection) {
		return collection.size() >= lowerBound
				&& collection.size() <= upperBound;
	}

}
