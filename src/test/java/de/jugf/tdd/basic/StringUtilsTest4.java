package de.jugf.tdd.basic;

import static de.jugf.tdd.basic.StringUtils.filterUmlaut;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest4 {
	@Test
	public void testFilterUmlaut() {
		Assert.assertThat(filterUmlaut("Häuser,Höfe,Türen"),
				IsEqual.equalTo("Haeuser,Hoefe,Tueren"));
	}
}