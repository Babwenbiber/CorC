package de.tu_bs.cs.isf.cbc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HashTable {
	public static String OVERVIEW_FILENAME = "overview.csv";
	public static String OVERVIEW_TMP_FILENAME = "tmp_overview.csv";
	
	public static String getFileNameFromHashTable(String location, String hash) {
		File overviewFile = new File(location + "/" + OVERVIEW_FILENAME);
		if (overviewFile.exists() && overviewFile.canRead()) {
			Scanner fileReader;
			try {
				fileReader = new Scanner(overviewFile);
			} catch (FileNotFoundException e) {
				return null;
			}
			while (fileReader.hasNextLine()) {
				String[] line = fileReader.nextLine().split(",");
				if (line.length != 2) {
					continue;
				}
				String fileName = line[0];
				String fileHash = line[1];
				if (fileHash.equals(hash)) {
					fileReader.close();
					return fileName;
				}
			}
			fileReader.close();
		}
		return null;
	}
	
	public static boolean fileExistsInOverview(String location, String filename) {
		System.out.println("check if exists " + filename);
		File overviewFile = new File(location + "/" + OVERVIEW_TMP_FILENAME);
		if (overviewFile.exists() && overviewFile.canRead()) {
			Scanner fileReader;
			try {
				fileReader = new Scanner(overviewFile);
			} catch (FileNotFoundException e) {
				return false;
			}
			while (fileReader.hasNextLine()) {
				String[] line = fileReader.nextLine().split(",");
				if (line.length != 2) {
					continue;
				}
				String fileName = line[0];
				String fileHash = line[1];
//				System.out.println("checking filename " + fileName + " and " + filename);
				if (fileName.equals(filename) || (fileName.contains(".java") && (fileName.split("\\.")[0] + ".class").equals(filename))) {
					fileReader.close();
					return true;
				}
			}
			fileReader.close();
		}
		System.out.println("false ");
		return false;
	}
	
	public static void saveHashInTmpTable(String location, String hash, String filename) {
	    System.out.println("saving " + location + "/"+ filename);
		FileWriter fw;
		try {
			File file = new File(location + "/" + OVERVIEW_TMP_FILENAME);
			file.getParentFile().mkdirs();
			file.createNewFile();
			fw = new FileWriter(location + "/" + OVERVIEW_TMP_FILENAME, true);//the true will append the new data
			fw.write(filename + "," + hash + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void overrideOldOverview(String location) {
		File dir = new File(location);
		File[] allContents = dir.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
//	    	    System.out.println("override " + location + "/" + file.getName());
	            if (!fileExistsInOverview(location, file.getName()) && 
	            		!file.getName().equals(OVERVIEW_FILENAME) &&
	            		!file.getName().equals(OVERVIEW_TMP_FILENAME) &&
	            		!file.getName().equals("helper.key") &&
	            		!file.getName().equals("GlobalJavaVariables.java") &&
	            		!file.getName().equals("GlobalJavaVariables.class")
	            		) {
		    	    System.out.println("delete" + file.getName());
	            	file.delete();
	            }
	        }
	    }
	    File oldOverview = new File(location + "/" + OVERVIEW_FILENAME);
	    oldOverview.delete();
	 
	    File newOverview = new File(location + "/" + OVERVIEW_TMP_FILENAME);
	    
	    newOverview.renameTo(oldOverview);
	}
}
