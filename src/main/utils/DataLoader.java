package main.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataLoader {
	
	public static int load(String filename, int svalue) throws IOException{
		
		try {
			Scanner scanner = new Scanner(new File(filename));
			while(scanner.hasNextInt()) {
				int value = scanner.nextInt();
				scanner.close();
				return value;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			save(filename, svalue);
			return svalue;
		}
		
		return 0;
	}
	
	public static Integer[] loadRandomEvents(String filename) {
		try {
			Scanner scanner = new Scanner(new File(filename));
			List<Integer> lines = new ArrayList<Integer>();
			while(scanner.hasNextLine()) {
				lines.add(scanner.nextInt());
			}
			Integer[] array = lines.toArray(new Integer[0]);
			scanner.close();
			return array;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void save(String filename, int value) throws IOException{
		FileWriter writer;
		File file = new File(filename);
		file.getParentFile().mkdirs();
		String svalue = Integer.toString(value);
		
		try {
			writer = new FileWriter(file);
			writer.write(svalue);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void saveErrorLog(String filename, String text) throws IOException{
		FileWriter writer;
		File file = new File(filename);
		
		try {
			writer = new FileWriter(file);
			writer.write(text);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
