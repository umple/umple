/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

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
 * @umplesource UmpleImport.ump 15
 * @umplesource UmpleImport_CodeHandlers.ump 13
 */
// line 15 "../../../../src/UmpleImport.ump"
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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={19},file={"UmpleImport_CodeHandlers.ump"},javaline={65},length={126})
  @umplesourcefile(line={20},file={"UmpleImport_CodeHandlers.ump"},javaline={66},length={12})
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

//  @umplesourcefile(line={31},file={"UmpleImport_CodeHandlers.ump"},javaline={80},length={112})
  @umplesourcefile(line={32},file={"UmpleImport_CodeHandlers.ump"},javaline={81},length={4})
  public void startDocument () throws SAXException 
  {
    model = new UmpleImportModel("");
  }

//  @umplesourcefile(line={35},file={"UmpleImport_CodeHandlers.ump"},javaline={87},length={106})
  @umplesourcefile(line={36},file={"UmpleImport_CodeHandlers.ump"},javaline={88},length={4})
  public void endDocument () throws SAXException 
  {
    // System.out.println("end document");
  }

//  @umplesourcefile(line={39},file={"UmpleImport_CodeHandlers.ump"},javaline={94},length={100})
  @umplesourcefile(line={40},file={"UmpleImport_CodeHandlers.ump"},javaline={95},length={65})
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
				if (superType != null) {
					String delims = "#//";
					String[] tokens = superType.split(delims);
					for (String string : tokens) {
						if (string != null) {
							umpleClass.addSuperType(string);
						}
					}
				}
				model.addUmpleImportElement(umpleClass);
			}
		} 
		//load class attributes
		else if (currentElement.equals("eStructuralFeatures")) {
			String attrType = attributes.getValue(UmpleImportConstants.XMI_TYPE);
			boolean checkIsAttribute = attrType.equals(UmpleImportConstants.ECORE_ATTRIBUTE);
			if(checkIsAttribute)
			{
				String attrName = attributes.getValue(UmpleImportConstants.XMI_NAME);
				String classAttrTypeRaw = attributes.getValue(UmpleImportConstants.ECORE_TYPE);
				String classAttrType = classAttrTypeRaw.split("#//")[1];
				String currentClassName = currentClass.getName();
				UmpleImportAttribute umpleAttribute = new UmpleImportAttribute(UmpleImportConstants.ECORE_ATTRIBUTE, attrName, currentClassName, classAttrType);
				String attrUpper = attributes.getValue(UmpleImportConstants.XMI_UPPER);
				if(attrUpper!=null)
					umpleAttribute.setUpperBound(Integer.parseInt(attrUpper));
				currentClass.addUmpleImportAttribute(umpleAttribute);
			}
		}
  }

//  @umplesourcefile(line={104},file={"UmpleImport_CodeHandlers.ump"},javaline={162},length={33})
  @umplesourcefile(line={105},file={"UmpleImport_CodeHandlers.ump"},javaline={163},length={8})
  public void endElement (String uri, String localName, String qName) throws SAXException 
  {
    // reset internal values for next round of parsing
	    boolean checkIsClassifiers = currentElement.equals(currentElement.equals("eClassifiers"));
		if (checkIsClassifiers && currentClass != null)
			currentClass = null;
		currentElement = "";
  }

//  @umplesourcefile(line={112},file={"UmpleImport_CodeHandlers.ump"},javaline={173},length={23})
  @umplesourcefile(line={113},file={"UmpleImport_CodeHandlers.ump"},javaline={174},length={4})
  public void characters (char[] ch, int start, int length) throws SAXException 
  {
    // System.out.println("characters");
  }

//  @umplesourcefile(line={116},file={"UmpleImport_CodeHandlers.ump"},javaline={180},length={17})
  @umplesourcefile(line={117},file={"UmpleImport_CodeHandlers.ump"},javaline={181},length={4})
  public void warning (SAXParseException e) throws SAXException 
  {
    System.out.println("Warning");
  }

//  @umplesourcefile(line={120},file={"UmpleImport_CodeHandlers.ump"},javaline={187},length={11})
  @umplesourcefile(line={121},file={"UmpleImport_CodeHandlers.ump"},javaline={188},length={4})
  public void error (SAXParseException e) throws SAXException 
  {
    System.out.println("Error");
  }

//  @umplesourcefile(line={124},file={"UmpleImport_CodeHandlers.ump"},javaline={194},length={5})
  @umplesourcefile(line={125},file={"UmpleImport_CodeHandlers.ump"},javaline={195},length={4})
  public void fatalError (SAXParseException e) throws SAXException 
  {
    System.out.println("Fatal Error");
  }

  
}