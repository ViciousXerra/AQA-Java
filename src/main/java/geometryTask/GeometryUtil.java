package main.java.geometryTask;

public interface GeometryUtil {
	/*
	 * Если честно, не понял последний пункт. Если прописывать дефолтные методы, то будет три интерфейса на каждую из фигур.
	 * Но можно написать в одном интерфейсе статический метод, ни про какое API, конечно же, тут речи и не идёт.
	 */
	static double calcPerimeter(double... sides) {
		switch(sides.length) {
			case 1:
				return 2 * Math.PI * sides[0];
			case 2:
				return sides[0]*2 + sides[1]*2;
			case 3:
				return sides[0] + sides[1] + sides[2];
			default:
				throw new UnsupportedOperationException();
		}
	}
	
	static double calcArea(double... sides) {
		switch(sides.length) {
			case 1:
				return Math.PI * Math.pow(sides[0], 2);
			case 2:
				return sides[0]*sides[1];
			case 3:
				double semiPerimeter = (sides[0] + sides[1] + sides[2]) / 2;
				return Math.sqrt(semiPerimeter * (semiPerimeter - sides[0]) * (semiPerimeter - sides[1]) * (semiPerimeter - sides[2]));
			default:
				throw new UnsupportedOperationException();
		}
	}
}
