package main.java;

public class Main {

	static void printThreeWords() {
		System.out.println("Orange");
		System.out.println("Banana");
		System.out.println("Apple");
	}
	
	static void checkSumSign() {
		int a = -8, b = 1;
		if(a + b >= 0) {
			System.out.println("Сумма положительная");
		}
		else {
			System.out.println("Сумма отрицательная");
		}
	}
	
	static void printColor() {
		int value = 101;
		String ans = value <= 0 ? "Красный" : value > 0 && value <= 100 ? "Желтый" : "Зеленый";
		System.out.println(ans);
	}
	
	static void compareNumbers() {
		int a = 255, b = 256;
		if(a >= b) {
			System.out.println("a >= b");
		}
		else {
			System.out.println("a < b");
		}
	}
	
	public static void main(String[] args) {
		printThreeWords();
		checkSumSign();
		printColor();
		compareNumbers();
	}

}
