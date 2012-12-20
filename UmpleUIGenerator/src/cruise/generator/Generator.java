package cruise.generator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

import cruise.exception.GeneratorException;
import cruise.factory.UIFactory;
import cruise.model.Constants;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import cruise.writer.UmpleProjectWriter;

public class Generator {

	//public static final String UMPLE_FILE = "UmpleFile";
	public static final String OUTPUT_FOLDER = "OutputFolder";
	public static final String GUI_OUTPUT_FOLDER = "GUIOutputFolder";
	
	
	private UIFactory uiFactory;

	public Properties getProperties() {
		return properties;
	}

	public UmpleProjectWriter umpleProjectWriter;
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	private Properties properties;

	public Generator(String... params) {
		umpleProjectWriter=new UmpleProjectWriter();
		properties = umpleProjectWriter.initialize(params);
		uiFactory = UIFactory.instance(properties.getProperty(Constants.UI_FACTORY));
	}

	public void generate() throws IOException {
		UmpleFile umpleFile = new UmpleFile(properties.getProperty(Constants.UMPLE_FILE));
		UmpleModel us = new UmpleModel(umpleFile);
		us.run();
		uiFactory.getUIGenerator().initialize(us);
		uiFactory.getUIGenerator().setProperties(properties);
		us.generate();
		umpleProjectWriter.generateUmpleProject(uiFactory.getUIGenerator());

	}


}
