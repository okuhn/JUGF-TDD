package de.jugf.tdd.matcher;

import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CollectionSizeRangeMatcher<T> extends TypeSafeMatcher<Collection<? extends T>>
		implements Matcher<Collection<? extends T>> {

	private final int lowerBound;
	private final int upperBound;
	
	public static <X> CollectionSizeRangeMatcher<X> collectionWithinSizeRange(final int lower, final int upper) {
		return new CollectionSizeRangeMatcher<X>(lower, upper);
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
	protected boolean matchesSafely(final Collection<? extends T> collection) {
		return collection.size() >= lowerBound
				&& collection.size() <= upperBound;
	}
}
