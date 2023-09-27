package main.java.geometryTask;

public class Rectangle extends Figure {

	protected double width, height;
	
	public Rectangle(double width, double height, Color bodyColor, Color borderColor) {
		super(bodyColor, borderColor);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double calcPerimeter() {
		return width*2 + height*2;
	}

	@Override
	public double calcArea() {
		return width*height;
	}

	@Override
	public String toString() {
		return String.format("%s\nPerimeter: %.10f\nArea: %.10f\n\n", getColorStat(), calcPerimeter(), calcArea());
	}

	@Override
	public double[] getSides() {
		return new double[] {width, height};
	}
	
}
