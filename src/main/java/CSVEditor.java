package main.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVEditor {

	static void saveData(AppData save) {
		String representation = null;
		byte[] bytes = null;
		try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("data.csv"))) {
			representation = save.toString();
			bytes = representation.getBytes();
			out.write(bytes);
		}
		catch(IOException | NullPointerException e) {
			System.out.println("Output stream error.\n");
			return;
		}
		System.out.println("Data has been successfully saved. See \"data.csv\" in project directory");
	}
	
	static AppData readData() {
		StringBuilder sb;
		byte[] bytes;
		int count;
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("data.csv"))) {
			sb = new StringBuilder();
			bytes = new byte[4096];
			while((count = in.read(bytes)) != -1) {
				for(int i = 0; i < count; i++) {
					sb.append((char) bytes[i]);
				}
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not founded.\n");
			return new AppData();
		} 
		catch (IOException e) {
			System.out.println("Output stream error.\n");
			return new AppData();
		}
		
		String[] columns;
		
		Scanner sc = new Scanner(sb.toString());
		columns = sc.nextLine().split(";");
		
		AppData res = new AppData();
		res.setHeader(columns);
		
		List<int[]> list = new ArrayList<>();
		count = 0;
		
		while(sc.hasNextLine()) {
			columns = sc.nextLine().split(";");
			list.add(new int[columns.length]);
			for(int i = 0; i < columns.length; i++) {
				list.get(count)[i] = Integer.parseInt(columns[i]);
			}
			count++;
		}
		
		res.setData(list.toArray(new int[list.size()][]));
		return res;
	}
	
	public static void main(String[] args) {
		AppData data = new AppData(new String[] {"Value 1", "Value 2", "Value 3"}, new int[][] {{41564, 27, 7412}, {3675, 8757, 418}});
		saveData(data);
		System.out.println(readData());
	}

}
