package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeingDataFromCSV {

	public static void main(String[] args) {
	
		String filename="file1.csv";
		File file = new File(filename);
		FileReader fr; // 16-bit / text / character
		BufferedReader br = null;
		String[] employee = null;
		try {
	

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
		//	List<String[]> lines = new ArrayList<String[]>();
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
			    	 employee =(line.split(","));
				}
				for(int i=0;i<employee.length;i++)
					System.out.println(employee[i]);
			}
		
			
			}catch (IOException e) {
				e.printStackTrace();
			}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
