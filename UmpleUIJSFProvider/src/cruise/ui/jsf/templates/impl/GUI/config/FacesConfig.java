package cruise.ui.jsf.templates.impl.GUI.config;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.ui.jsf.*;
import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.UmpleClass;
import cruise.model.abstractObjects.BackingObject;;

public class FacesConfig implements IGenerator {

  protected static String nl;
  public static synchronized FacesConfig create(String lineSeparator)
  {
    nl = lineSeparator;
    FacesConfig result = new FacesConfig();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<faces-config version=\"1.2\" xmlns=\"http://java.sun.com/xml/ns/javaee\"" + NL + " xmlns:xi=\"http://www.w3.org/2001/XInclude\"" + NL + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-facesconfig_1_2.xsd\">";
  protected final String TEXT_2 = NL + " <managed-bean>" + NL + "\t<managed-bean-name>a";
  protected final String TEXT_3 = "Bean</managed-bean-name>" + NL + "\t<managed-bean-class>";
  protected final String TEXT_4 = "Bean</managed-bean-class>" + NL + "\t<managed-bean-scope>request</managed-bean-scope>" + NL + " </managed-bean>";
  protected final String TEXT_5 = NL + " <managed-bean>" + NL + "  <managed-bean-name>timeBean</managed-bean-name>" + NL + "  <managed-bean-class>";
  protected final String TEXT_6 = ".components.bean.TimeBean</managed-bean-class>" + NL + "  <managed-bean-scope>application</managed-bean-scope>" + NL + " </managed-bean>" + NL + " <managed-bean>" + NL + "  <managed-bean-name>skinBean</managed-bean-name>" + NL + "  <managed-bean-class>";
  protected final String TEXT_7 = ".components.bean.SkinBean</managed-bean-class>" + NL + "  <managed-bean-scope>session</managed-bean-scope>" + NL + "  <managed-property>" + NL + "   <property-name>skin</property-name>" + NL + "   <value>wine</value>" + NL + "  </managed-property>" + NL + "</managed-bean>" + NL + " <managed-bean>" + NL + "  <managed-bean-name>mainBean</managed-bean-name>" + NL + "  <managed-bean-class> ";
  protected final String TEXT_8 = ".control.MainBean</managed-bean-class>" + NL + "  <managed-bean-scope>session</managed-bean-scope>" + NL + " </managed-bean>";
  protected final String TEXT_9 = NL + " <navigation-rule>" + NL + "  <display-name>to";
  protected final String TEXT_10 = "Main</display-name>" + NL + "  <navigation-case>" + NL + "   <from-outcome>to";
  protected final String TEXT_11 = "Main</from-outcome>" + NL + "   <to-view-id>/pages/";
  protected final String TEXT_12 = "/";
  protected final String TEXT_13 = "/";
  protected final String TEXT_14 = "Main.xhtml</to-view-id>" + NL + "  </navigation-case>" + NL + " </navigation-rule>";
  protected final String TEXT_15 = NL + "  <navigation-rule>" + NL + "  <display-name>home</display-name>" + NL + "  <navigation-case>" + NL + "   <from-outcome>home</from-outcome>" + NL + "   <to-view-id>/pages/home.xhtml</to-view-id>" + NL + "  </navigation-case>" + NL + " </navigation-rule>" + NL + " <application>" + NL + "  <view-handler>com.sun.facelets.FaceletViewHandler</view-handler>" + NL + "      <locale-config>            " + NL + "          <default-locale>en</default-locale>            " + NL + "          <supported-locale>en</supported-locale>" + NL + "      </locale-config>";
  protected final String TEXT_16 = NL + "\t<resource-bundle>" + NL + "   <base-name>bundles.";
  protected final String TEXT_17 = "</base-name>" + NL + "   <var>a";
  protected final String TEXT_18 = "Bundle</var>" + NL + "  </resource-bundle>";
  protected final String TEXT_19 = "\t" + NL + "      \t" + NL + " </application>" + NL + "</faces-config>";
  protected final String TEXT_20 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List<BackingObject> clazzez=(List<BackingObject>)argument;
 String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX); 
    stringBuffer.append(TEXT_1);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  	UmpleClass clazz= iterClazzez.next().getUClazz(); 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(clazz.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(preffix + "." + clazz.getPackageName()+"." + clazz.getName());
    stringBuffer.append(TEXT_4);
     } 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_8);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  	UmpleClass clazz= iterClazzez.next().getUClazz(); 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(clazz.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(clazz.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(clazz.getPackageName().replace('.', '/'));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(clazz.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(clazz.getName());
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
	BackingObject bckObject= iterClazzez.next(); 
    stringBuffer.append(TEXT_16);
    stringBuffer.append((bckObject.getPackageName()!=null?(bckObject.getPackageName()+"."):"" )+bckObject.getClassName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_18);
     } 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}