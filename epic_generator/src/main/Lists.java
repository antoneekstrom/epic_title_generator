package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lists {
	
	//public static File list = new File("list.txt");
	
	public static String readLine(String file) {   /* read first line of text file */
		
		String line = null;
		File list = new File(file); /* creates file object */
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(list)); /* reader object for list file */
			line = reader.readLine(); /* puts first line of file into string */
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return line;
	}
	
	public static void printSaved() {
		String l = readLine("saved.txt");
		String ls[] = l.split(",");
		for (int i = 0; i < ls.length; i++) {
			if (ls[i] != " ") {
				System.out.println(">>> " + ls[i] + " <<<");
			} else {}
		}
	}
	
	public static String[] readList(String filename) throws IOException {
		
		List<String> wholeList = Files.readAllLines(Paths.get(filename)); /* reads all lines into a list. */
		String[] arrayList = wholeList.toArray(new String[0]); /* puts list into array */
		for (int i = 0; i < arrayList.length; i++) {
			System.out.println(arrayList[i]);
		}
			return arrayList;
	}
	
	public static void main(String[] args) throws IOException {
		String[] list = readList("list.txt");
		System.out.println(list);
	}

}
