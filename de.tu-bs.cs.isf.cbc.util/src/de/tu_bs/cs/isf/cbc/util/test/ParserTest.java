package de.tu_bs.cs.isf.cbc.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import de.tu_bs.cs.isf.cbc.util.HashTable;
import de.tu_bs.cs.isf.cbc.util.Parser;

class ParserTest {

	@Test
	void testReplaceBlockWithoutBlockContent() {
		String content = "i=5;\n while(j>i)j--;";
		String newContent = Parser.replaceBlockStatementsInString(content);
		assertEquals(content, newContent);
	}
	
	@Test
	void testReplaceBlockWithBlockContent() {
		String content = "i=1; Block Myblock2;";
		String expectedContent = "i=1; {}";
		String newContent = Parser.replaceBlockStatementsInString(content);
		assertEquals(expectedContent, newContent);
	}
	
	@Test
	void testReplaceBlockWithAnnotations() {
		String content = "i=1; /*@requires i==1; @ensures i==3;*/";
		String expectedContent = "i=1; /*@requires i==1;\n@ensures i==3;*/";
		String newContent = Parser.replaceBlockStatementsInString(content);
		assertEquals(expectedContent, newContent);
	}

}
