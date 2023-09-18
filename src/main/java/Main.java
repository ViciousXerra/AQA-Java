package main.java;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		String[] fruits = {"Banana", "Watermelon", "Apple", "Orange", "Mango", "Pear", "Grape", "Guava", "Pineapple", "Melon",
				"Lemon", "Melon", "Papaya", "Strawberry", "Apple", "Kiwifruit", "Pear", "Banana"};
		
		Map<String, Integer> map = new HashMap<>();
		
		for(String fruit : fruits) {
			map.put(fruit, map.getOrDefault(fruit, 0) + 1);
		}
		
		System.out.println(map.keySet());
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.printf("%s quantity: %d\n", entry.getKey(), entry.getValue());
		}
		
		Phonebook pb = new Phonebook();
		pb.add("Petrov", "654-24-12");
		pb.add("Petrov", "137-21-80");
		pb.add("Alekseev", "791-46-20");
		pb.add("Andreev", "156-78-46");
		pb.add("Sergeev", "189-76-00");
		System.out.println(pb.get("Petrov"));
		System.out.println(pb.get("Alekseev"));
		System.out.println(pb.get("Andreev"));
		System.out.println(pb.get("Sergeev"));
	}

}
