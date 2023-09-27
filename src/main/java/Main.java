package main.java;

import main.java.animals.Animal;
import main.java.animals.Cat;
import main.java.animals.Dog;

import main.java.geometryTask.Circle;
import main.java.geometryTask.Rectangle;
import main.java.geometryTask.Triangle;
import main.java.geometryTask.Color;
import main.java.geometryTask.GeometryUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Dog bobik = new Dog("Bobik");
		Dog elisa = new Dog("Elisa");
		Dog lora = new Dog("Lora");
		Cat barsik = new Cat("Barsik");
		Cat watson = new Cat("Watson");
		Cat whiskey = new Cat("Whiskey");
		Cat astra = new Cat("Astra");
		Cat luna = new Cat("Luna");
		
		System.out.printf("Animals total amount: %d\nDogs total amount: %d\nCats total amount: %d\n", 
				Animal.getTotalAmount(),
				Dog.getTotalAmount(),
				Cat.getTotalAmount());
		
		Dog[] dogs = {bobik, elisa, lora};
		Cat[] cats = {barsik, watson, whiskey, astra, luna};
		
		List<Animal> animals = new ArrayList<>();
		animals.addAll(Arrays.asList(dogs));
		animals.addAll(Arrays.asList(cats));
		
		for(Cat x : cats) {
			x.eat();
		}
		for(Cat x : cats) {
			if(!x.isAte())
				x.eat();
		}
		
		Random r = new Random();
		for(Animal x : animals) {
			x.run(550 - r.nextInt(501));
		}
		
		for(Animal x : animals) {
			x.swim(15 - r.nextInt(11));
		}
		System.out.println();
		
		//--------------------------------------
		
		Circle circle = new Circle(5.0d, Color.WHITE, Color.BLACK);
		Rectangle rect = new Rectangle(4.2d, 3.1d, Color.RED, Color.BLUE);
		Triangle triangle = new Triangle(2.31d, 2.31d, 2.31d, Color.GREEN, Color.WHITE);
		
		System.out.println(circle);
		System.out.println(rect);
		System.out.println(triangle);
		
		GeometricCalculator calc = new GeometricCalculator();
		
		System.out.printf("Circle perimeter: %.2f;\nCircle area: %.2f;\n", calc.calcPerimeter(circle), calc.calcArea(circle));
		System.out.printf("Rectangle perimeter: %.2f;\nRectangle area: %.2f;\n", calc.calcPerimeter(rect), calc.calcArea(rect));
		System.out.printf("Triangle perimeter: %.2f;\nTriangle area: %.2f;\n", calc.calcPerimeter(triangle), calc.calcArea(triangle));
		
	}

}
