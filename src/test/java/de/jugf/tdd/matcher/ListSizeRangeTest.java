package de.jugf.tdd.matcher;

import static de.jugf.tdd.matcher.CollectionSizeRangeMatcher.collectionWithinSizeRange;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.jugf.tdd.basic.ListProvider;

public class ListSizeRangeTest {

	private ListProvider lp = new ListProvider();
	
	@Test
	public void test() {
		assertThat(lp.list(2), collectionWithinSizeRange(2,4));
	}

}
