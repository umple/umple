package xmi.umple.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xmi.umple.model.*;
import xmi.umple.helper.UmpleConstants;

public class UmpleXMIHandler extends DefaultHandler {

	private UmpleModel model;
	private String currentElement = "";

	public UmpleModel readDataFromXML(String filename) throws SAXException,
			IOException, ParserConfigurationException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File(filename), this);
		return model;
	}

	@Override
	public void startDocument() throws SAXException {
		model = new UmpleModel();
	}

	@Override
	public void endDocument() throws SAXException {
		// System.out.println("end document");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currentElement = localName;
		switch (currentElement) {

		case "EPackage":
			UmplePackage umplePackage = new UmplePackage(
					UmpleConstants.ECOREPACKAGE);
			String nameSpace = attributes
					.getValue(UmpleConstants.XMI_PACKAGENAME);
			if (nameSpace != null && !nameSpace.isEmpty()) {
				umplePackage.setName(nameSpace);
				model.addComponet(umplePackage);
			}
			break;

		case "eClassifiers":
			String attrType = attributes.getValue(UmpleConstants.XMI_TYPE);
			boolean checkIsClass = attrType.equals(UmpleConstants.ECORECLASS);
			if (checkIsClass) {
				boolean isInterface = Boolean.parseBoolean(attributes
						.getValue(UmpleConstants.XMI_INTERFACE));
				boolean isAbstract = Boolean.parseBoolean(attributes
						.getValue(UmpleConstants.XMI_ABSTRACT));
				String currentPackageName = model.getCurrentPackageName();
				UmpleClass umpleClass = new UmpleClass(
						UmpleConstants.ECORECLASS, currentPackageName,
						isAbstract, isInterface);
				umpleClass
						.setName(attributes.getValue(UmpleConstants.XMI_NAME));

				// note that it's possible that a class can have multiple
				// interfaces
				String superType = attributes
						.getValue(UmpleConstants.XMI_SUPERTYPE);
				if (superType != null) {
					String delims = "#//";
					String[] tokens = superType.split(delims);
					for (String string : tokens) {
						if (string != null) {
							umpleClass.addSuperType(string);
						}
					}
				}
				model.addComponet(umpleClass);
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// System.out.println("end element");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// System.out.println("characters");
	}

}
