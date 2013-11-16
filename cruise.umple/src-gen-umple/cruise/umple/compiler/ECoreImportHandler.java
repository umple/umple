/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ECoreImportHandler()
  {
    super();
    model = new UmpleImportModel("");
    currentElement = "";
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
  //  @umplesourcefile(line={18},file={"UmpleImport_CodeHandlers.ump"},javaline={63},length={77})
  @umplesourcefile(line={19},file={"UmpleImport_CodeHandlers.ump"},javaline={64},length={9})
  public UmpleImportModel readDataFromXML (String filename) throws SAXException,
			IOException, ParserConfigurationException 
  {
    SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File(filename), this);
		return model;
  }

//  @umplesourcefile(line={27},file={"UmpleImport_CodeHandlers.ump"},javaline={75},length={66})
  @umplesourcefile(line={28},file={"UmpleImport_CodeHandlers.ump"},javaline={76},length={4})
  public void startDocument () throws SAXException 
  {
    model = new UmpleImportModel("");
  }

//  @umplesourcefile(line={31},file={"UmpleImport_CodeHandlers.ump"},javaline={82},length={60})
  @umplesourcefile(line={32},file={"UmpleImport_CodeHandlers.ump"},javaline={83},length={4})
  public void endDocument () throws SAXException 
  {
    // System.out.println("end document");
  }

//  @umplesourcefile(line={35},file={"UmpleImport_CodeHandlers.ump"},javaline={89},length={54})
  public void startElement (String uri, String localName, String qName,
			Attributes attributes) throws SAXException 
  {
    currentElement = localName;
		if (currentElement.equals("EPackage")) {
			UmpleImportPackage umplePackage = new UmpleImportPackage(UmpleImportConstants.ECOREPACKAGE, "");
			String nameSpace = attributes.getValue(UmpleImportConstants.XMI_PACKAGENAME);
			if (nameSpace != null && !nameSpace.isEmpty()) {
				umplePackage.setName(nameSpace);
				model.addComponet(umplePackage);
			}
		} else if (currentElement.equals("eClassifiers")) {
			String attrType = attributes.getValue(UmpleImportConstants.XMI_TYPE);
			boolean checkIsClass = attrType.equals(UmpleImportConstants.ECORECLASS);
			if (checkIsClass) {
				boolean isInterface = Boolean.parseBoolean(attributes.getValue(UmpleImportConstants.XMI_INTERFACE));
				boolean isAbstract = Boolean.parseBoolean(attributes.getValue(UmpleImportConstants.XMI_ABSTRACT));
				String currentPackageName = model.getCurrentPackageName();
				String className = attributes.getValue(UmpleImportConstants.XMI_NAME);
				UmpleImportClass umpleClass = new UmpleImportClass(
						UmpleImportConstants.ECORECLASS, className,
						currentPackageName, isAbstract, isInterface, new ArrayList<String>());

				// note that it's possible that a class can have multiple
				// interfaces
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
				model.addComponet(umpleClass);
			}
		}
  }

//  @umplesourcefile(line={74},file={"UmpleImport_CodeHandlers.ump"},javaline={130},length={13})
  @umplesourcefile(line={75},file={"UmpleImport_CodeHandlers.ump"},javaline={131},length={5})
  public void endElement (String uri, String localName, String qName)
			throws SAXException 
  {
    // System.out.println("end element");
  }

//  @umplesourcefile(line={79},file={"UmpleImport_CodeHandlers.ump"},javaline={138},length={6})
  @umplesourcefile(line={80},file={"UmpleImport_CodeHandlers.ump"},javaline={139},length={5})
  public void characters (char[] ch, int start, int length)
			throws SAXException 
  {
    // System.out.println("characters");
  }

  
}