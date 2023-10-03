package main.java;

import java.util.ArrayList;
import java.util.List;

class Phonebook {
	private List<Person> list;
	
	{
		list = new ArrayList<>();
	}
	
	protected void add(String secondName, String tel) {
		list.add(new Person(secondName, tel));
	}
	
	protected String get(String secondName) {
		StringBuilder sb = new StringBuilder();
		list
		.stream()
		.filter(p -> p.getSecondName().equals(secondName))
		.forEach(p -> {
			sb.append(secondName);
			sb.append(": ");
			sb.append(p.getTel());
			sb.append("\n");
		});
		return sb.toString();
	}
	
}
