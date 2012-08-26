package de.jugf.tdd.basic;

import java.util.ArrayList;
import java.util.List;

public class ListProvider {
		
	public List<String> list(final int n) {
		final List<String> list = new ArrayList<>(n);
		for(int i=0; i<n; i++) {
			list.add(new String(new char[] {(char)((int)'a'+i)}));
		}
		return list;
	}

	
}
