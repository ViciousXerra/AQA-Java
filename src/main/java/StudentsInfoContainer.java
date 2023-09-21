package main.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

class StudentsInfoContainer {
	Collection<Student> students = Arrays.asList(
			new Student("Дмитрий", 17, Gender.MAN),
			new Student("Максим", 20, Gender.MAN),
			new Student("Екатерина", 20, Gender.WOMAN),
			new Student("Михаил", 28, Gender.MAN));
	
	private enum Gender {
		MAN, WOMAN
	}
	
	private static class Student {
		private final String name;
		private final Integer age;
		private final Gender gender;
		
		public Student(String name, Integer age, Gender gender) {
			this.name = name;
			this.age = age;
			this.gender = gender;
		}
		
		public String getName() {
			return name;
		}
		
		public Integer getAge() {
			return age;
		}
		
		public Gender getGender() {
			return gender;
		}
		
		@Override
		public String toString() {
			return "{name='" + name + '\'' + ", age=" + age + ", gender=" + gender + '}';
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(name, age, gender);
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o)
				return true;
			if(!(o instanceof Student))
				return false;
			Student student = (Student) o;
			return Objects.equals(name, student.name) && 
					Objects.equals(age, student.age) && 
					Objects.equals(gender, student.gender);
		}
	}
	
	protected double getAvgAge() {
		int amount = 0;
		double sumOfAge = 0;
		Iterator<Student> iterator = students.stream().filter(student -> student.getGender().compareTo(Gender.MAN) == 0).iterator();
		
		while(iterator.hasNext()) {
			amount++;
			sumOfAge += iterator.next().getAge();
		}
		return amount != 0 ? sumOfAge / amount : 0;
	}
	
	protected void display() {
		students
		.stream()
		.filter(student -> student.getGender().compareTo(Gender.MAN) == 0)
		.filter(student -> student.getAge() >= 18 && student.getAge() < 27)
		.forEach(System.out::println);
	}
	
}
