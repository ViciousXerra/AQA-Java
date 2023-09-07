package main.java.geometryTask;

abstract class Figure implements GeometricCalc, Colorised {
	private Color bodyColor, borderColor;
	
	protected Figure(Color bodyColor, Color borderColor) {
		this.bodyColor = bodyColor;
		this.borderColor = borderColor;
	}
	
	@Override
	public String getColorStat() {
		return String.format("Body color: %s %s\nBorder color: %s %s", 
				bodyColor, 
				bodyColor.getHex(),
				borderColor,
				borderColor.getHex());
	}
	
	abstract public double[] getSides();
}
