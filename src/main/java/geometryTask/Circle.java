package main.java.geometryTask;

public class Circle extends Figure {

	private double radius;
	
	public Circle(double radius, Color bodyColor, Color borderColor) {
		super(bodyColor, borderColor);
		this.radius = radius;
	}
	
	@Override
	public double calcPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public String toString() {
		return String.format("%s\nPerimeter: %.10f\nArea: %.10f\n\n", getColorStat(), calcPerimeter(), calcArea());
	}

	@Override
	public double[] getSides() {
		return new double[] {radius};
	}
	
}
