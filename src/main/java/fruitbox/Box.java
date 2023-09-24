package main.java.fruitbox;

import java.util.ArrayList;
import java.util.List;

import main.java.fruits.Fruit;

public class Box<T extends Fruit> {
	
	private List<T> container;
	
	{
		container = new ArrayList<>();
	}
	
	public double getWeight() {
		if(container.size() != 0) {
			return 
					container
					.stream()
					.mapToDouble(T::getWeight)
					.sum();
		}
		else {
			return 0;
		}
	}
	
	public boolean compare(Box<?> anotherBox) {
		return this.getWeight() == anotherBox.getWeight();
	}
	
	public void putAll(Box<? extends T> box) {
		container.addAll(box.container);
		box.container.clear();
	}
	
	public void add(T obj) {
		container.add(obj);
	}
}
