package main.java.fruits;

public class Orange extends Fruit {

	public Orange() {
		this(1.5f);
	}
	
	protected Orange(double weight) {
		super(weight);
	}

	@Override
	public double getWeight() {
		return super.getWeight();
	}
	
}