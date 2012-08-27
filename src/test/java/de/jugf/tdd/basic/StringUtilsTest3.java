package de.jugf.tdd.basic;

import static de.jugf.tdd.basic.StringUtils.filterUmlaut;
import junit.framework.TestCase;

public class StringUtilsTest3 extends TestCase {
	public void testFilterUmlaut() {
		assertEquals("Haeuser,Hoefe,Tueren", 
				filterUmlaut("Häuser,Höfe,Türen"));
	}
}