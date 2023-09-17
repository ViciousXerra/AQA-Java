package main.java;

public class Main {

	static int sumArrayValues(String[][] arr) throws MyArraySizeException, MyArrayDataException {
		if(arr.length != 4)
			throw new MyArraySizeException();
		boolean valid = true;
		for(int i = 0; i < 4; i++) {
			if(arr[i].length != 4) {
				valid = false;
				break;
			}
		}
		if(!valid) {
			throw new MyArraySizeException();
		}
		int sum = 0;
		int i = 0, j = 0;
		try {
			for(i = 0; i < arr.length; i++) {
				for(j = 0; j < arr[i].length; j++) {
					sum += Integer.parseInt(arr[i][j]);
				}
			}
		}
		catch(NumberFormatException e) {
			throw new MyArrayDataException(i, j);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		String[][] arr1 = 
				{{"1", "3", "7", "9"}, 
				{"75", "25", "15", "45"}, 
				{"33", "99", "81", "7"}, 
				{"45", "732", "378", "4"}};
		String[][] arr2 = 
				{{"7675", "78741", "9875", "2875287"}, 
				{"457587", "abcde", "345727", "3852782"}, 
				{"4175", "2573", "687687", "2578765"}, 
				{"68", "452412", "52454", "234567"}};
		String[][] arr3 = 
			{{"7675", "78741", "9875", "2875287"}, 
			{"457587", "7945", "3852782"}, 
			{"4175", "2573", "687687", "2578765"}, 
			{"68", "452412", "52454", "234567"}};
		String[][][] inputs = {arr1, arr2, arr3};
		
		for(String[][] x : inputs) {
			try {
				System.out.printf("%d\n", sumArrayValues(x));
			} catch(MyArraySizeException | MyArrayDataException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
