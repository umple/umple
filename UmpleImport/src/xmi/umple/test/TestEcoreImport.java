package xmi.umple.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import xmi.umple.helper.UmpleConstants;
import xmi.umple.model.*;
import xmi.umple.parser.UmpleXMIHandler;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEcoreImport {

	public void setUp() {
	}

	@Test
	public void EcoreClassParsingTest() throws Exception {

		String expectedText = loadUmpleFile("ClassWithNamespace.ump");
		String actualText = loadXMIFile("ClassWithNamespace.ecore");

		assertEquals(expectedText, actualText);
	}

	@Test
	public void EcoreInterfaceParsingTest() throws Exception {
		
		String expectedText = loadUmpleFile("InterfaceWithNamespace.ump");
		String actualText = loadXMIFile("InterfaceWithNamespace.ecore");

		assertEquals(expectedText, actualText);
	}

	private static String loadXMIFile(String name) throws Exception {
		String filename = getFullFilePath(name);
		assertEquals(true, (new File(filename)).exists());

		UmpleXMIHandler handler = new UmpleXMIHandler();
		UmpleModel umple = handler.readDataFromXML(filename);
		return umple.generateUmple();
	}

	private static String loadUmpleFile(String name) throws IOException {

		String filename = getFullFilePath(name);
		StringBuilder builder = new StringBuilder();
		FileReader reader = new FileReader(new File(filename));

		int content;
		while ((content = reader.read()) != -1) {
			builder.append((char) content);
		}
		reader.close();

		return builder.toString();
	}

	private static String getFullFilePath(String name) {
		return UmpleConstants.DATADIR + name;
	}
}
