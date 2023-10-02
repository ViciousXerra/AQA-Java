package main.java;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class Phonebook {
	private Map<String, Set<String>> map;
	
	{
		map = new HashMap<>();
	}
	
	protected void add(String secondName, String tel) {
		Set<String> set = map.getOrDefault(secondName, new LinkedHashSet<>());
		set.add(tel);
		if(set.size() == 1)
			map.put(secondName, set);
	}
	
	protected String get(String secondName) {
		StringBuilder sb = new StringBuilder();
		Set<String> set = map.getOrDefault(secondName, new LinkedHashSet<>());
		for(String tel : set) {
			sb
			.append(String.format("%s %s\n", secondName, tel));
		}
		return sb.toString();
	}
	
}
