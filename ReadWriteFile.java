
import java.io.*;
import acm.util.*;

public class ReadWriteFile {
	
	private BufferedReader rd;
	private BufferedWriter wr;
	private RandomGenerator rgen;
	
	public ReadWriteFile() {
		rd = null;
		wr = null;
		rgen = RandomGenerator.getInstance();
		rgen.setSeed(1);
		}
	
	public void readFileFromDisk(String fileName) {

		try {
			rd = new BufferedReader(new FileReader("/Users/bhawanishankarsharma/Desktop/Bhawani.txt"));
			wr = new BufferedWriter(new FileWriter("/Users/bhawanishankarsharma/Desktop/Bhawani_copy.txt"));
			while(true) {
				String line = rd.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
				wr.write(line);
				wr.newLine();
			}
			rd.close();
			wr.close();
		}
		catch (IOException ex){
			System.out.println("There is something wrong. Please figure it out. " + ex.getMessage());
		}
		
	}
	
	public void GenerateRawData(int[] arr, int range) {
		try {
			wr = new BufferedWriter(new FileWriter("/Users/bhawanishankarsharma/Desktop/ArrayList.txt"));
			for(int i = 0;i<arr.length;i++) {
				arr[i] = rgen.nextInt(range);
				String line = Integer.toString(arr[i]);
				wr.write(line);
				wr.newLine();
			}
			wr.close();
		}
		catch (IOException ex){
			System.out.println("There is something wrong. Please figure it out. " + ex.getMessage());
		}
	}
	
	public void saveOutputData(int[] arr) {
		try {
			wr = new BufferedWriter(new FileWriter("/Users/bhawanishankarsharma/Desktop/SortedArrayList.txt"));
			for(int i = 0;i<arr.length;i++) {
				String line = Integer.toString(arr[i]);
				wr.write(line);
				wr.newLine();
			}
			wr.close();
		}
		catch (IOException ex){
			System.out.println("There is something wrong. Please figure it out. " + ex.getMessage());
		}
		
	}
	
	

}
