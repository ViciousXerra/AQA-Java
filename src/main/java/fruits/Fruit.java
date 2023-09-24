package main.java.fruits;

abstract public class Fruit {
	final private double weight;
	
	public Fruit(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
}
