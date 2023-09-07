package main.java.animals;

import java.util.Random;

public class Cat extends Animal {
	private static int totalAmount = 0;
	private static CatFeeder feeder = new CatFeeder(80);
	
	final private static int RUN_LIMIT = 200;
	
	private boolean satiety;
	
	public Cat(String name) {
		super(name);
		satiety = false;
		totalAmount++;
	}

	@Override
	public void run(int distance) {
		if(distance <= RUN_LIMIT) {
			System.out.printf("%s ran %d m.\n", getName(), distance);
		}
		else {
			System.out.printf("%s didn't run\n", getName());
		}
	}

	@Override
	public void swim(int distance) {
		System.out.printf("%s can't swim\n", getName());
	}
	
	public void eat() {
		Random r = new Random();
		int req = 20 - r.nextInt(6);
		satiety = feeder.isWorkedOut(req);
		if(satiety) {
			System.out.printf("%s ate\n", getName());
		}
		else {
			System.out.printf("%s couldn't eat\n", getName());
		}
	}
	
	public boolean isAte() {
		return satiety;
	}
	
	public static int getTotalAmount() {
		return totalAmount;
	}
	
	
}
