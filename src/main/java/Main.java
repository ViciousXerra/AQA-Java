package main.java;

import main.java.fruitbox.Box;
import main.java.fruits.Apple;
import main.java.fruits.Orange;

public class Main {

	public static void main(String[] args) {
		Box<Apple> boxOfApple = new Box<>();
		Box<Orange> boxOfOrange = new Box<>();
		
		for(int i = 0; i < 5; i++) {
			boxOfApple.add(new Apple());
		}
		for(int i = 0; i < 8; i++) {
			boxOfOrange.add(new Orange());
		}
		System.out.printf("Weight of box filled with apples №1: %.1f\n", boxOfApple.getWeight());
		System.out.printf("Weight of box filled with oranges: %.1f\n", boxOfOrange.getWeight());
		
		System.out.printf("Equality of weights of box with apples and box with oranges: %b\n", boxOfApple.compare(boxOfOrange));
		
		Box<Apple> anotherBoxOfApple = new Box<>();
		for(int i = 0; i < 7; i++) {
			anotherBoxOfApple.add(new Apple());
		}
		System.out.printf("Weight of box filled with apples №2: %.1f\n", anotherBoxOfApple.getWeight());
		boxOfApple.putAll(anotherBoxOfApple);
		System.out.printf("Weight of box filled with apples №1: %.1f\n", boxOfApple.getWeight());
		System.out.printf("Weight of box filled with apples №2: %.1f\n", anotherBoxOfApple.getWeight());
		System.out.printf("Equality of weights of box with apples and box with oranges: %b\n", boxOfApple.compare(boxOfOrange));
	}

}
