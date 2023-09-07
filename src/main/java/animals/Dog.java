package main.java.animals;

public class Dog extends Animal {
	private static int totalAmount = 0;
	
	final private static int RUN_LIMIT = 500;
	final private static int SWIM_LIMIT = 10;
		
	public Dog(String name) {
		super(name);
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
		if(distance <= SWIM_LIMIT) {
			System.out.printf("%s swam %d m.\n", getName(), distance);
		}
		else {
			System.out.printf("%s didn't swim\n", getName());
		}
	}
	
	public static int getTotalAmount() {
		return totalAmount;
	}
}
