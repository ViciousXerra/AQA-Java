package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		//-----------------------------------------
		List<Integer> nums = new ArrayList<>();
		Random rand = new Random();
		int amount = 10;
		while(amount-- > 0) {
			nums.add(rand.nextInt(50));
		}	
		System.out.println(nums);
		Predicate<Integer> countEven = n -> n % 2 == 0;
		System.out.println(counter(nums, countEven));
		//-----------------------------------------
		List<String> str1 = Arrays.asList("Highload", "Load", "High", "Load", "High", "Highload", "Load", "Highload", "High");
		List<String> str2 = new ArrayList<>();
		System.out.println(counter(str1, s -> s.equals("High")));
		
		BinaryOperator<String> findFirst = (first, second) -> first;
		BinaryOperator<String> findLast = (first, second) -> second;
		find(str1, findFirst);
		find(str1, findLast);
		find(str2, findFirst);
		find(str2, findFirst);
		//-----------------------------------------
		Collection<String> elems = Arrays.asList("f10", "f15", "f2", "f4", "f4");
		Comparator<String> compare = (s1, s2) -> {
			String[] tokens1 = s1.split("\\D+");
	        String[] tokens2 = s2.split("\\D+");
	        int i = 0;
	        while (i < tokens1.length && i < tokens2.length) {
	            if (tokens1[i].length() != tokens2[i].length()) {
	                return tokens1[i].length() - tokens2[i].length();
	            }
	            if (!tokens1[i].equals(tokens2[i])) {
	                return tokens1[i].compareTo(tokens2[i]);
	            }
	            i++;
	        }
	        return tokens1.length - tokens2.length;
		};
		String[] orderedElems = 
		elems.stream().sorted(compare).toArray(String[]::new);
		System.out.println(Arrays.toString(orderedElems));
		//-----------------------------------------
		StudentsInfoContainer info = new StudentsInfoContainer();
		System.out.println(info.getAvgAge());
		info.display();
		//-----------------------------------------
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<String> logins = new ArrayList<>();
		String input = "";
		while(true) {
			try {
				input = reader.readLine();
			} catch (IOException e) {
				System.out.println("Input error");
			}
			if(input.isEmpty())
				break;
			logins.add(input);
		}
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println("Input error");
		}
		logins.stream().filter(s -> s.charAt(0) == 'f').forEach(System.out::println);
	}
	
	static <T> long counter(Collection<T> collection, Predicate<T> predicate) {
		return collection.stream().filter(predicate).count();
	}
	
	static <T> void find(List<T> collection, BinaryOperator<T> operator) {
		Function<Collection<T>, Optional<T>> func = c -> c.stream().reduce(operator);
		Optional<T> op = func.apply(collection);
		op.ifPresentOrElse(System.out::println, () -> System.out.println(0));
	}

}
