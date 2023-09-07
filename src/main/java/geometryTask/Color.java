package main.java.geometryTask;

public enum Color {
	BLACK("#000000"), 
	WHITE("#FFFFFF"), 
	RED("#FF0000"), 
	GREEN("#00FF00"), 
	BLUE("#0000FF");
	
	private String hex;
		
	Color(String hex) {
		this.hex = hex;
	}

	String getHex() {
		return hex;
	}
}
