package de.jugf.tdd.matcher;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import de.jugf.tdd.basic.ListProvider;

public class SizeTest {

	private ListProvider lp = new ListProvider();

	@Test
	public void testWithoutHamcrest() {
		assertEquals(buildList().size(), 5);
	}

	@Test
	public void testWithHamcrest() {
		assertThat(buildList(), hasSize(5));
	}

	private List<String> buildList() {
		return lp.list(5);
	}
}
