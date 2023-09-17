package main.java;

class MyArrayDataException extends Exception {

	private static final long serialVersionUID = 1380379742245834205L;
	
	private int cell1, cell2;
	
	public MyArrayDataException(int cell1, int cell2) {
		this.cell1 = cell1;
		this.cell2 = cell2;
	}
	
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb
			.append("Не удалось преобразовать в целочисленное значение элемент, находящийся на позиции:")
			.append(" [")
			.append(cell1)
			.append(']')
			.append('[')
			.append(cell2)
			.append("]\n");
		return sb.toString();
	}

}
