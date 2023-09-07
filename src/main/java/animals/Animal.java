package main.java.animals;

abstract public class Animal {
	private static int totalAmount = 0;
	
	private String name;
	
	protected Animal(String name) {
		totalAmount++;
		this.name = name;
	}
	
	public abstract void run(int distance);
	
	public abstract void swim(int distance);
	
	protected String getName() {
		return name;
	}
	
	public static int getTotalAmount() {
		return totalAmount;
	}
}
