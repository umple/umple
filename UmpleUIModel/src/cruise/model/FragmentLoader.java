package cruise.model;

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
import cruise.model.fragments.AttributteFragmentProvider;

/**
 * 
 * @author Julian
 */
public class FragmentLoader extends DefaultHandler {

	private Map<String, AttributteFragmentProvider> attfragmentProviderMap;
	private Map<String, IGenerator> classCache;
	private String fragmentSetPckg = "";
	private String fragmentGetPckg = "";
	private String fragmentDeclarationPckg = "";
	private String fragmentAsignationPckg = "";
	private String fragmentCopyPckg = "";
	private String fragmentPreConstructorPckg = "";
	private String fragmentReverseCopyPckg="";
	
	private UmpleProject uProject;
	
	/** Creates a new instance of XMLRulesLoader */
	public FragmentLoader(
			Map<String, AttributteFragmentProvider> attfragmentProviderMap) {
		this.attfragmentProviderMap = attfragmentProviderMap;
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
		if (localName.equalsIgnoreCase("FragmentProvider")) {
			int length = atts.getLength();

			for (int i = 0; i < length; i++) {
				if (atts.getQName(i).equalsIgnoreCase("fragmentSetPckg")) {
					fragmentSetPckg = atts.getValue(i);
				} else if (atts.getQName(i).equalsIgnoreCase("fragmentGetPckg")) {
					fragmentGetPckg = atts.getValue(i);
				} else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentDeclarationPckg")) {
					fragmentDeclarationPckg = atts.getValue(i);
				} else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentAsignationPckg")) {
					fragmentAsignationPckg = atts.getValue(i);
				} else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentCopyPckg")) {
					fragmentCopyPckg = atts.getValue(i);
				} else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentPreConstructorPckg")) {
					fragmentPreConstructorPckg = atts.getValue(i);
				} else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentReverseCopyPckg")) {
					fragmentReverseCopyPckg = atts.getValue(i);
				}
			}
		}
	}

	private void fragmengTag(String localName, Attributes atts) {
		if (localName.equalsIgnoreCase("Fragment")) {

			int length = atts.getLength();
		
			String modifier = "";
			String type = "";
			IGenerator fragmentSet = null;
			IGenerator fragmentGet = null;
			IGenerator fragmentDeclaration = null;
			IGenerator fragmentAsignation = null;
			IGenerator fragmentCopy = null;
			IGenerator fragmentPreConstructor = null;
			IGenerator fragmentReverseCopy = null;
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
				if (atts.getQName(i).equalsIgnoreCase("fragmentSetter")) {
					
					if (classCache.get(fragmentSetPckg + "." +atts.getValue(i)) != null) {
						fragmentSet = classCache.get(fragmentSetPckg
								+"." + atts.getValue(i));
					} else {
						fragmentSet = instatiate(fragmentSetPckg+"."
								+ atts.getValue(i));
						//classCache.put(fragmentSetPckg+"." + atts.getValue(i), fragmentSet);
					}
				} else if (atts.getQName(i).equalsIgnoreCase("fragmentGetter")) {
					if (classCache.get(fragmentSetPckg + "." +atts.getValue(i)) != null) {
						fragmentGet = classCache.get(fragmentGetPckg
								+ "." + atts.getValue(i));
					} else {
						fragmentGet = instatiate(fragmentGetPckg+"."
								+ atts.getValue(i));
					//	classCache.put(fragmentGetPckg+"." + atts.getValue(i), fragmentGet);
					}
				} else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentDeclaration")) {
					if (classCache.get(fragmentDeclarationPckg
							+ "." + atts.getValue(i)) != null) {
						fragmentDeclaration = classCache
								.get(fragmentDeclarationPckg + "." + atts.getValue(i));
					} else {
						fragmentDeclaration = instatiate(fragmentDeclarationPckg+"."
								+ atts.getValue(i));
						//classCache.put(fragmentDeclarationPckg+"." + atts.getValue(i), fragmentDeclaration);
					}
				} else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentAsignation")) {
					if (classCache.get(fragmentAsignationPckg
							+ "." + atts.getValue(i)) != null) {
						fragmentAsignation = classCache
								.get(fragmentAsignationPckg + "." +atts.getValue(i));
					} else {
						fragmentAsignation = instatiate(fragmentAsignationPckg+"."
								+ atts.getValue(i));
					//	classCache.put(fragmentAsignationPckg+"." + atts.getValue(i), fragmentAsignation);
					}
				}else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentCopy")) {
					if (classCache.get(fragmentCopyPckg
							+ "." + atts.getValue(i)) != null) {
						fragmentCopy = classCache
								.get(fragmentCopyPckg + "." +atts.getValue(i));
					} else {
						fragmentCopy = instatiate(fragmentCopyPckg+"."
								+ atts.getValue(i));
					//	classCache.put(fragmentCopyPckg+"." + atts.getValue(i), fragmentCopy);
					}
				}else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentPreConstructor")) {
					if (classCache.get(fragmentCopyPckg
							+ "." +  atts.getValue(i)) != null) {
						fragmentPreConstructor = classCache
								.get(fragmentPreConstructorPckg+"." + atts.getValue(i));
					} else {
						fragmentPreConstructor = instatiate(fragmentPreConstructorPckg+"."
								+ atts.getValue(i));
					//	classCache.put(fragmentPreConstructorPckg+"." + atts.getValue(i), fragmentPreConstructor);
					}
				}else if (atts.getQName(i).equalsIgnoreCase(
						"fragmentReverseCopy")) {
					if (classCache.get(fragmentReverseCopyPckg
							+ "." +  atts.getValue(i)) != null) {
						fragmentReverseCopy = classCache
								.get(fragmentReverseCopyPckg+"." + atts.getValue(i));
					} else {
						fragmentReverseCopy = instatiate(fragmentReverseCopyPckg+"."
								+ atts.getValue(i));
					//	classCache.put(fragmentReverseCopyPckg+"." + atts.getValue(i), fragmentReverseCopy);
					}
				}
			}
			AttributteFragmentProvider attFP = new AttributteFragmentProvider(
					fragmentSet, fragmentGet, fragmentDeclaration,
					fragmentAsignation, fragmentCopy, fragmentPreConstructor, fragmentReverseCopy);
			attfragmentProviderMap.put(modifier + " || " + type, attFP);
		}
	}

	private IGenerator instatiate(String className) {
		try {
			//Class cl = Class.forName(className);
			Class cl =Class.forName(className, true, cruise.writer.UmpleProjectWriter.classLoader);
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
