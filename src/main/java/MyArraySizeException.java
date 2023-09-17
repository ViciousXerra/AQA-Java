package main.java;

class MyArraySizeException extends Exception {

	private static final long serialVersionUID = 620435183251863390L;
	
	@Override
	public String getMessage() {
		return "Передан массив длиной не 4 х 4\n";
	}
	
}
