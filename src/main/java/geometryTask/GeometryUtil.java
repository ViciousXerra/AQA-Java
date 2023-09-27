package main.java.geometryTask;

public interface GeometryUtil {
	
	default double calcPerimeter(Circle c) {
		return 2 * Math.PI * c.radius;
	}
	
	default double calcPerimeter(Rectangle r) {
		return r.height*2 + r.width*2;
	}
	
	default double calcPerimeter(Triangle t) {
		return t.side1 + t.side2 + t.side3;
	}
	
	default double calcArea(Circle c) {
		return Math.PI * Math.pow(c.radius, 2);
	}
	
	default double calcArea(Rectangle r) {
		return r.height*r.width;
	}
	
	default double calcArea(Triangle t) {
		double semiPerimeter = (t.side1 + t.side2 + t.side3) / 2;
		return Math.sqrt(semiPerimeter * (semiPerimeter - t.side1) * (semiPerimeter - t.side2) * (semiPerimeter - t.side3));
	}
}
