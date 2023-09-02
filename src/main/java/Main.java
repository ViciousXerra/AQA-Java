package main.java;

import java.util.Arrays;

public class Main {

	static boolean method1(int value1, int value2) {
		int sum = value1 + value2;
		return sum >= 10 && sum <= 20;
	}
	
	static void method2(int value) {
		if(value >= 0) {
			System.out.println("Число положительное");
		}
		else {
			System.out.println("Число отрицательное");
		}
	}
	
	static boolean method3(int value) {
		if(value < 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static void method4(String str, int count) {
		while(count-- > 0) {
			System.out.println(str);
		}
	}
	
	static boolean method5(int year) {
		if(year % 100 == 0 && year % 400 != 0) {
			return false;
		}
		else if(year % 4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static int[] arrayInit(int len, int initialValue) {
		int[] result = new int[len];
		for(int i = 0; i < len; i++)
			result[i] = initialValue;
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(method1(5, 15));
		method2(-1);
		System.out.println(method3(-25));
		method4("CREATE MACHINES", 5);
		System.out.println(method5(800));
		
		//----------------------------------------
		
		int[] array1 = new int[] {0, 1, 1, 0, 0, 1, 1, 1, 0, 1};
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == 0) {
				array1[i] = 1;
			}
			else {
				array1[i] = 0;
			}
		}
		System.out.println(Arrays.toString(array1));
		
		//---------------------------------------
		
		int[] array2 = new int[100];
		for(int i = 0; i < array2.length; i++) {
			array2[i] = i + 1;
		}
		System.out.println(Arrays.toString(array2));
		
		//---------------------------------------
		
		int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		for(int i = 0; i < array3.length; i++) {
			if(array3[i] < 6) {
				array3[i] *= 2;
			}
		}
		System.out.println(Arrays.toString(array3));
		
		//---------------------------------------
		
		int[][] array4 = new int[10][10];
		for(int i = 0; i < array4.length; i++) {
			for(int j = 0; j < array4[i].length; j++) {
				if(i == j || j == array4[i].length - 1 - i) {
					array4[i][j] = 1;
				}
			}
			System.out.println(Arrays.toString(array4[i]));
		}
		
		//---------------------------------------
		
		System.out.println(Arrays.toString(arrayInit(5, 26)));
	}

}
