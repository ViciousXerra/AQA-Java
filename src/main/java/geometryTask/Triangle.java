package main.java.geometryTask;

public class Triangle extends Figure {

	protected double side1, side2, side3;
	
	public Triangle(double side1, double side2, double side3, Color bodyColor, Color borderColor) {
		super(bodyColor, borderColor);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	@Override
	public double calcPerimeter() {
		return side1 + side2 + side3;
	}

	@Override
	public double calcArea() {
		//Heron's formula
		double semiPerimeter = (side1 + side2 + side3) / 2;
		return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
	}
	
	@Override
	public String toString() {
		return String.format("%s\nPerimeter: %.10f\nArea: %.10f\n\n", getColorStat(), calcPerimeter(), calcArea());
	}

	@Override
	public double[] getSides() {
		return new double[] {side1, side2, side3};
	}

}
