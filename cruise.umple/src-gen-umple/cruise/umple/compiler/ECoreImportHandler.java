/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Parse ECore by extend SAX handler callbacks
 * @umplesource UmpleImport.ump 21
 * @umplesource UmpleImport_CodeHandlers.ump 13
 */
// line 21 "../../../../src/UmpleImport.ump"
// line 13 "../../../../src/UmpleImport_CodeHandlers.ump"
public class ECoreImportHandler extends DefaultHandler
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ECoreImportHandler Attributes
  private UmpleImportModel model;
  private String currentElement;
  private UmpleImportClass currentClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ECoreImportHandler()
  {
    super();
    model = new UmpleImportModel("");
    currentElement = "";
    currentClass = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  @umplesourcefile(line={143},file={"UmpleImport_CodeHandlers.ump"},javaline={57},length={12})
   private String parseRawTypes(String rawType){
    String type = "";
		if (rawType.contains("#//"))
			type = rawType.split("#//")[1];
		else if (rawType.contains("/0/"))
			type = rawType.split("/0/")[1];
		else if (rawType.contains("/1/"))
			type = rawType.split("/1/")[1];
		else
			type = rawType;
		return type;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={19},file={"UmpleImport_CodeHandlers.ump"},javaline={80},length={139})
  @umplesourcefile(line={20},file={"UmpleImport_CodeHandlers.ump"},javaline={81},length={12})
  public UmpleImportModel readDataFromXML (String filename) throws IOException, ParserConfigurationException 
  {
    SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(new File(filename), this);
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		}
		return model;
  }

//  @umplesourcefile(line={31},file={"UmpleImport_CodeHandlers.ump"},javaline={95},length={125})
  @umplesourcefile(line={32},file={"UmpleImport_CodeHandlers.ump"},javaline={96},length={4})
  public void startDocument () throws SAXException 
  {
    model = new UmpleImportModel("");
  }

//  @umplesourcefile(line={35},file={"UmpleImport_CodeHandlers.ump"},javaline={102},length={119})
  @umplesourcefile(line={36},file={"UmpleImport_CodeHandlers.ump"},javaline={103},length={4})
  public void endDocument () throws SAXException 
  {
    // System.out.println("end document");
  }

//  @umplesourcefile(line={39},file={"UmpleImport_CodeHandlers.ump"},javaline={109},length={113})
  @umplesourcefile(line={40},file={"UmpleImport_CodeHandlers.ump"},javaline={110},length={78})
  public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException 
  {
    currentElement = localName;		
		//load package object
		if (currentElement.equals("EPackage")) {
			UmpleImportPackage umplePackage = new UmpleImportPackage(UmpleImportConstants.ECORE_PACKAGE, "");
			String nameSpace = attributes.getValue(UmpleImportConstants.XMI_PACKAGENAME);
			if (nameSpace != null && !nameSpace.isEmpty()) {
				umplePackage.setName(nameSpace);
				model.addUmpleImportElement(umplePackage);
			}
		} 
		//load class/interface/dataType object
		else if (currentElement.equals("eClassifiers")) {
			String attrType = attributes.getValue(UmpleImportConstants.XMI_TYPE);
			boolean checkIsClass = attrType.equals(UmpleImportConstants.ECORE_CLASS);
			boolean checkIsDataType = attrType.equals(UmpleImportConstants.ECORE_DATATYPE);
			boolean checkDataTypeIsExtraClass = false;
			if (checkIsDataType){
				String dataTypeName = attributes.getValue(UmpleImportConstants.XMI_NAME);
				//exclude umple default date and time dataType
				boolean checkIsDate = dataTypeName.equals("Date");
				boolean checkIsTime = dataTypeName.equals("Time");
				checkDataTypeIsExtraClass = !(checkIsDate||checkIsTime);
			}
			if (checkIsClass || checkDataTypeIsExtraClass) {
				boolean isInterface = Boolean.parseBoolean(attributes.getValue(UmpleImportConstants.XMI_INTERFACE));
				boolean isAbstract = Boolean.parseBoolean(attributes.getValue(UmpleImportConstants.XMI_ABSTRACT));
				String currentPackageName = model.getCurrentPackageName();
				String className = attributes.getValue(UmpleImportConstants.XMI_NAME);
				UmpleImportClass umpleClass = new UmpleImportClass(UmpleImportConstants.ECORE_CLASS, className, currentPackageName, isAbstract, isInterface);
	            currentClass = umpleClass;
	            
				// note that it's possible that a class can have multiple interfaces
				String superType = attributes.getValue(UmpleImportConstants.XMI_SUPERTYPE);
				if (superType != null) 
					umpleClass.addSuperType(parseRawTypes(superType));
				model.addUmpleImportElement(umpleClass);
			}
		} 
		//load class attributes and associations
		else if (currentElement.equals("eStructuralFeatures")) {
			String attrType = attributes.getValue(UmpleImportConstants.XMI_TYPE);
			boolean checkIsAttribute = attrType.equals(UmpleImportConstants.ECORE_ATTRIBUTE);
			boolean checkIsReference = attrType.equals(UmpleImportConstants.ECORE_REFERENCE);
			String attrName = attributes.getValue(UmpleImportConstants.XMI_NAME);
			String classAttrTypeRaw = attributes.getValue(UmpleImportConstants.ECORE_TYPE);
			String classAttrType=parseRawTypes(classAttrTypeRaw);
			String currentClassName = currentClass.getName();
			if(checkIsAttribute)
			{				
				UmpleImportAttribute umpleAttribute = new UmpleImportAttribute(UmpleImportConstants.ECORE_ATTRIBUTE, attrName, currentClassName, classAttrType);
				String attrUpper = attributes.getValue(UmpleImportConstants.XMI_UPPER);
				if(attrUpper!=null)
					umpleAttribute.setUpperBound(Integer.parseInt(attrUpper));
				currentClass.addUmpleImportAttribute(umpleAttribute);
			}
			if(checkIsReference)
			{
				String endClassName = null;
				String endClassNameRaw = attributes.getValue("eOpposite");
				
				String lower = attributes.getValue("lowerBound");
				String upper = attributes.getValue("upperBound");
				int lowerBound = (lower != null)? Integer.parseInt(lower):0;
				int upperBound = (upper != null)? Integer.parseInt(upper):-1;
				
				if(endClassNameRaw!=null)
					endClassName = endClassNameRaw.split(classAttrTypeRaw+"/")[1];
				UmpleImportAssociation umpleAssociation = new UmpleImportAssociation(UmpleImportConstants.ECORE_REFERENCE, attrName, currentClassName, classAttrType, endClassName);
				umpleAssociation.setLowerBound(lowerBound);
				umpleAssociation.setUpperBound(upperBound);
				UmpleImportAssociation oppoEnd = model.checkIfOppositeExist(umpleAssociation);
				if(oppoEnd==null)
					currentClass.addUmpleImportAssociation(umpleAssociation);
			}
		}
  }

//  @umplesourcefile(line={117},file={"UmpleImport_CodeHandlers.ump"},javaline={190},length={33})
  @umplesourcefile(line={118},file={"UmpleImport_CodeHandlers.ump"},javaline={191},length={8})
  public void endElement (String uri, String localName, String qName) throws SAXException 
  {
    // reset internal values for next round of parsing
	    boolean checkIsClassifiers = currentElement.equals(currentElement.equals("eClassifiers"));
		if (checkIsClassifiers && currentClass != null)
			currentClass = null;
		currentElement = "";
  }

//  @umplesourcefile(line={125},file={"UmpleImport_CodeHandlers.ump"},javaline={201},length={23})
  @umplesourcefile(line={126},file={"UmpleImport_CodeHandlers.ump"},javaline={202},length={4})
  public void characters (char[] ch, int start, int length) throws SAXException 
  {
    // System.out.println("characters");
  }

//  @umplesourcefile(line={129},file={"UmpleImport_CodeHandlers.ump"},javaline={208},length={17})
  @umplesourcefile(line={130},file={"UmpleImport_CodeHandlers.ump"},javaline={209},length={4})
  public void warning (SAXParseException e) throws SAXException 
  {
    System.out.println("Warning: " + e.getMessage());
  }

//  @umplesourcefile(line={133},file={"UmpleImport_CodeHandlers.ump"},javaline={215},length={11})
  @umplesourcefile(line={134},file={"UmpleImport_CodeHandlers.ump"},javaline={216},length={4})
  public void error (SAXParseException e) throws SAXException 
  {
    System.out.println("Error: " + e.getMessage());
  }

//  @umplesourcefile(line={137},file={"UmpleImport_CodeHandlers.ump"},javaline={222},length={5})
  @umplesourcefile(line={138},file={"UmpleImport_CodeHandlers.ump"},javaline={223},length={4})
  public void fatalError (SAXParseException e) throws SAXException 
  {
    System.out.println("Fatal Error: " + e.getMessage());
  }

  
}