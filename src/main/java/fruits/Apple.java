package main.java.fruits;

public class Apple extends Fruit {

	public Apple() {
		this(1.0f);
	}
	
	protected Apple(double weight) {
		super(weight);
	}

	@Override
	public double getWeight() {
		return super.getWeight();
	}
	
}
