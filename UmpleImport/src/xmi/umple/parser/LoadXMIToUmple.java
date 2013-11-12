package xmi.umple.parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import xmi.umple.helper.*;
import xmi.umple.model.*;

public class LoadXMIToUmple {
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		String filename = UmpleConstants.DATADIR + "InterfaceWithNamespace.ecore";
		
		UmpleXMIHandler handler = new UmpleXMIHandler();
		UmpleModel data = handler.readDataFromXML(filename);
	    System.out.println(data.generateUmple());

	}

}
