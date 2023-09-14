package main.java;

class AppData {
	private String[] header;
	private int[][] data;
	
	protected AppData() {
		
	}
	
	protected AppData(String[] header, int[][] data) {
		this.header = header;
		this.data = data;
	}
	
	protected String[] getHeader() {
		return header;
	}
	
	protected int[][] getData() {
		return data;
	}
	
	protected void setHeader(String[] header) {
		this.header = header;
	}
	
	protected void setData(int[][] data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		if(header == null || data == null) {
			return "Unable to convert to String representation.";
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < header.length; i++) {
			sb.append(header[i]);
			if(i != header.length - 1) {
				sb.append(';');
			}
		}
		sb.append('\n');
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				sb.append(data[i][j]);
				if(j != data[i].length - 1) {
					sb.append(';');
				}
			}
			if(i != data.length - 1) {
				sb.append('\n');
			}
		}
		return sb.toString();
	}
}
