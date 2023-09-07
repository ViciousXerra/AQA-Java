package main.java.animals;

class CatFeeder {
	private int quantity;
	
	protected CatFeeder(int quantity) {
		this.quantity = quantity;
	}
	
	protected boolean isWorkedOut(int reqAmount) {
		if(quantity - reqAmount < 0) {
			System.out.printf("Food quantity: %d\nIt needs to be refilled\n", quantity);
			refill(80);
			return false;
		}
		else {
			quantity -= reqAmount;
			System.out.printf("Food quantity: %d\n", quantity);
			return true;
		}
	}
	
	private void refill(int amount) {
		quantity += amount;
	}
}
