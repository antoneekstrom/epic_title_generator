package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

	public static BufferedWriter writer = null;
	public static File saveFile = new File("saved.txt");
	
	public static void writeSave(String word) {
		try {
			//create a temporary file
			
			//output the full path to where the file will be written
//			System.out.println(saveFile.getCanonicalPath());
			
			//writes to file
			writer = new BufferedWriter(new FileWriter(saveFile, true));
			writer.write(word);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//close the writer regardless of what happens
				writer.close();
			} catch (Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
