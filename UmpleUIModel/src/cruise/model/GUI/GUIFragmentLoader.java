package cruise.model.GUI;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import cruise.exception.GeneratorException;
import cruise.jaxb.UmpleProject;
import cruise.model.abstractObjects.IGenerator;
import cruise.model.fragments.GUIFragmentProvider;

/**
 * 
 * @author Julian
 */
public class GUIFragmentLoader extends DefaultHandler {

	private Map<String, GUIFragmentProvider> guiFragmentProviderMap;
	private Map<String, IGenerator> classCache;
	private String fragmentPckg = "";
	private UmpleProject uProject;
	
	
	
	
	/** Creates a new instance of XMLRulesLoader */
	public GUIFragmentLoader(
			Map<String, GUIFragmentProvider> guiFragmentProviderMap) {
		this.guiFragmentProviderMap = guiFragmentProviderMap;
		classCache=new HashMap<String, IGenerator>();
	
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) {
		fragmentProviderTag(localName, atts);
		fragmengTag(localName, atts);
	}

	public void endElement(String uri, String localName, String qName) {
	}

	public void characters(char[] chars, int start, int length) {
	}

	private void fragmentProviderTag(String localName, Attributes atts) {
		if (localName.equalsIgnoreCase("GUIFragmentProvider")) {
			int length = atts.getLength();

			for (int i = 0; i < length; i++) {
				if (atts.getQName(i).equalsIgnoreCase("fragmentPckg")) {
					fragmentPckg = atts.getValue(i);
				} 
			}
		}
	}

	private void fragmengTag(String localName, Attributes atts) {
		if (localName.equalsIgnoreCase("Fragment")) {

			int length = atts.getLength();
		
			String modifier = "";
			String type = "";
			IGenerator fragmentCreate = null;
			IGenerator fragmentEdit = null;
			IGenerator fragmentGrid = null;
			IGenerator fragmentGridHeader=null;
			for (int i = 0; i < length; i++) {
				if (atts.getQName(i).equalsIgnoreCase("modifier")) {
					modifier = atts.getValue(i);
					continue;
				}

				if (atts.getQName(i).equalsIgnoreCase("type")) {
					type = atts.getValue(i);
					continue;
				}

				if (atts.getValue(i).length() == 0)
					continue;
				if(atts.getValue(i) == null || atts.getValue(i).length()==0)
					continue;
				if (atts.getQName(i).equalsIgnoreCase("fragmentCreate")) {
					
					if (classCache.get(fragmentPckg + "." +atts.getValue(i)) != null) {
						fragmentCreate = classCache.get(fragmentPckg
								+"." + atts.getValue(i));
					} else {
						fragmentCreate = instatiate(fragmentPckg+"."
								+ atts.getValue(i));
					//	classCache.put(fragmentPckg+"." + atts.getValue(i), fragmentCreate);
					}
				} else if (atts.getQName(i).equalsIgnoreCase("fragmentEdit")) {
					
					if (classCache.get(fragmentPckg + "." +atts.getValue(i)) != null) {
						fragmentEdit = classCache.get(fragmentPckg
								+"." + atts.getValue(i));
					} else {
						fragmentEdit = instatiate(fragmentPckg+"."
								+ atts.getValue(i));
					//	classCache.put(fragmentPckg+"." + atts.getValue(i), fragmentEdit);
					}
				} else if (atts.getQName(i).equalsIgnoreCase("fragmentGrid")) {
					
					if (classCache.get(fragmentPckg + "." +atts.getValue(i)) != null) {
						fragmentGrid = classCache.get(fragmentPckg
								+"." + atts.getValue(i));
					} else {
						fragmentGrid = instatiate(fragmentPckg+"."
								+ atts.getValue(i));
					//	classCache.put(fragmentPckg+"." + atts.getValue(i), fragmentGrid);
					}
				} else if (atts.getQName(i).equalsIgnoreCase("fragmentGridHeader")) {
					
					if (classCache.get(fragmentPckg + "." +atts.getValue(i)) != null) {
						fragmentGridHeader = classCache.get(fragmentPckg
								+"." + atts.getValue(i));
					} else {
						fragmentGridHeader = instatiate(fragmentPckg+"."
								+ atts.getValue(i));
				//		classCache.put(fragmentPckg+"." + atts.getValue(i), fragmentGridHeader);
					}
				}
			}
			GUIFragmentProvider guiFP = new GUIFragmentProvider(
					fragmentCreate, fragmentEdit, fragmentGrid, fragmentGridHeader);
			guiFragmentProviderMap.put(modifier + " || " + type, guiFP);
		}
	}

	private IGenerator instatiate(String className) {
		try {
			Class cl =Class.forName(className, true, cruise.writer.UmpleProjectWriter.classLoader);
			//Class cl = Class.forName(className);
			java.lang.reflect.Constructor co;
			co = cl.getConstructor(new Class[0]);
			IGenerator clazz = (IGenerator) co.newInstance(null);
			classCache.put(className, clazz);
			return clazz;
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneratorException("Class not found! [" + className + "]");
		}
	}
}
