package de.tu_bs.cs.isf.cbc.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import de.tu_bs.cs.isf.cbc.util.HashTable;

class HashTableTest {

	@Test
	void testNoFile() {
		String filename = HashTable.getFileNameFromHashTable("ads", "asd");
		assertEquals(null, filename);
	}
	
	@Test
	void testFileWithUnknownHash() {
		String filename = HashTable.getFileNameFromHashTable("./fixtures", "bf68b68c7c68bb7818367");	
		assertEquals(null, filename);
	}
	
	@Test
	void testFileWithKnownHash() {
		String filename = HashTable.getFileNameFromHashTable("./fixtures", "af68b68c7c68bb7818367");	
		assertEquals("prove0pre_impl.key", filename);
	}
	
	@Test
	void testCreateNewFile() {
		String dir = "./fixtures/create";
		String hash = "abc";
		String fileName = "jajaja";
		refreshDir(new File(dir));
		HashTable.saveHashInTmpTable(dir, hash,fileName);
		File overviewFile = new File(dir + "/" + HashTable.OVERVIEW_TMP_FILENAME);
		assertTrue(isContentInFile(overviewFile, 1, hash, fileName));
	}
	
	@Test
	void testFileExistsInTable() {
		String dir = "./fixtures/create";
		String hash = "abc";
		String fileName = "jajaja";
		refreshDir(new File(dir));
		HashTable.saveHashInTmpTable(dir, hash,fileName);
		assertTrue( HashTable.fileExistsInOverview(dir, fileName));
	}
	
	@Test
	void testAppendToFile() throws FileNotFoundException {
		String dir = "./fixtures/create";
		String hash1 = "abc";
		String hash2 = "def";
		String fileName1 = "jajaja";
		String fileName2 = "jajaja2";
		refreshDir(new File(dir));
		HashTable.saveHashInTmpTable(dir, hash1,fileName1);
		HashTable.saveHashInTmpTable(dir, hash2,fileName2);
		File overviewFile = new File(dir + "/" + HashTable.OVERVIEW_TMP_FILENAME);
		assertTrue(isContentInFile(overviewFile, 1, hash1, fileName1));
		assertTrue(isContentInFile(overviewFile, 2, hash2, fileName2));
	}
	
	
	@Test
	void testOverrideOldOverviewDeleteOldOverview() {
		String dir = "./fixtures/override";
		File newFile = new File(dir + "/new");
		File oldFile = new File(dir + "/old");
		File oldOverview= new File(dir +  "/" + HashTable.OVERVIEW_FILENAME);
		FileWriter fw;
		try {
			newFile.createNewFile();
			oldFile.createNewFile();
			oldOverview.createNewFile();
			fw = new FileWriter(dir +  "/" + HashTable.OVERVIEW_FILENAME);
			fw.write("old,old_content\n");
			fw.close();
			fw = new FileWriter(dir + "/new");
			fw.write("blablabla");
			fw.close();
			fw = new FileWriter(dir + "/old");
			fw.write("blablabla");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HashTable.saveHashInTmpTable(dir, "new_content", "new");
		HashTable.overrideOldOverview(dir);
		assertFalse(new File(dir + "/old").exists());
		
		File overviewFile = new File(dir + "/" + HashTable.OVERVIEW_FILENAME);
		assertTrue(isContentInFile(overviewFile, 1, "new_content", "new"));
	}
	
	
	boolean isContentInFile(File overviewFile, int lineNumber, String hash, String filename) {
		System.out.println("iscontentin file " + (overviewFile.exists() && overviewFile.canRead()));
		if (overviewFile.exists() && overviewFile.canRead()) {
			Scanner fileReader;
			try {
				fileReader = new Scanner(overviewFile);
			} catch (FileNotFoundException e) {
				return false;
			}
			int i = 0;
			while (fileReader.hasNextLine()) {
				i++;
				String[] line = fileReader.nextLine().split(",");
				if (line.length != 2) {
					continue;
				}
				System.out.println("line is " + line[0] + "," + line[1]);
				if (lineNumber == i) {
					String fileName = line[0];
					String fileHash = line[1];
					if (fileHash.equals(hash) && filename.equals(fileName)) {
						fileReader.close();
						return true;
					}
				}
			}
			fileReader.close();
		} 
		return false;
	}
	
	boolean refreshDir(File directory) {
		return deleteDirectory(directory) && createDirectory(directory);
	}
	
	boolean deleteDirectory(File directoryToBeDeleted) {
	    File[] allContents = directoryToBeDeleted.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
	            deleteDirectory(file);
	        }
	    }
	    return directoryToBeDeleted.delete();
	}
	
	boolean createDirectory(File directoryToBeCreated) {
		File theDir = new File("/path/directory");
		if (!theDir.exists()){
		    return theDir.mkdirs();
		}
		return false;
	}

}
