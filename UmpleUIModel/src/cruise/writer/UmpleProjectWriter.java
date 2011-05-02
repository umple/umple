package cruise.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import cruise.exception.GeneratorException;
import cruise.jaxb.Directory;
import cruise.jaxb.GenerationUnit;
import cruise.jaxb.Property;
import cruise.jaxb.UmpleProject;
import cruise.model.Constants;
import cruise.model.abstractObjects.BackingObject;
import cruise.model.abstractObjects.IGenerator;
import cruise.ui.interfaces.UIGenerator;
import cruise.umple.compiler.UmpleClass;


public class UmpleProjectWriter {

	private Map<String, IGenerator> classCache = new HashMap<String, IGenerator>();
	private ArrayList<BackingObject> allClasses;
	private ArrayList<BackingObject> singletons;
	private ArrayList<BackingObject> classes;
	private HashMap<String, BackingObject> classMap;
	private String outputFolder;
	private boolean initialized;
	private UmpleProject uProject;
	
	public static ClassLoader classLoader ;
	

	FilenameFilter filenameFilter = new FilenameFilter() {
		public boolean accept(File fDir, String strName) {
			return (!strName.equals(".settings") && !strName.equals(".project")
					&& !strName.equals(".classpath") && !strName.equals("ant"));
		}
	};

	public Properties initialize(String... params) {
		try {
			JAXBContext ctx;
			ctx = JAXBContext.newInstance("cruise.jaxb");
			Unmarshaller u = ctx.createUnmarshaller();
			uProject = (UmpleProject) u.unmarshal(new File(params[0]));
			ArrayList<Property> props = new ArrayList<Property>(uProject
					.getProperties().getProperty());
			Properties properties = new Properties();
			for (Property property : props) {
				properties.put(property.getName(), property.getValue());
			}
			String projectName="";
			File umpleFile = null;
			if (params.length==4){
				umpleFile=new File(params[1]);
				outputFolder=params[2];
				projectName=params[3];
			}else{
				umpleFile=new File(uProject.getUmpleFile());
				projectName=uProject.getName();
				outputFolder = uProject.getOutputFolder();
				
			}
			properties.put(Constants.UI_FACTORY, uProject.getUIFactory());
			properties.put(Constants.PROJECT_NAME, projectName);
			
			ClassWriter.clearFolder(new File(outputFolder), this.filenameFilter);
			String umpleFolder = properties.getProperty(Constants.UMPLE_FOLDER);
			String completeOutputFolder = outputFolder;
			if (umpleFolder != null) {
				completeOutputFolder = completeOutputFolder + File.separator
						+ umpleFolder;
			}
			//File umpleFile = new File(uProject.getUmpleFile());
			File outFile = new File(completeOutputFolder);
			outFile.mkdirs();
			outFile = new File(completeOutputFolder + File.separator
					+ umpleFile.getName());
			ClassWriter.copyFile(umpleFile, outFile);
			if (properties.getProperty(Constants.PROVIDER_JAR)!=null){
				URL url = new URL("jar:file:/"+ properties.getProperty(Constants.PROVIDER_JAR).trim()+"!/");
				this.classLoader =  new URLClassLoader(new URL[] { url });
				System.out.println("Loading JAR: " + properties.getProperty(Constants.PROVIDER_JAR) );
			}else{
				this.classLoader =this.getClass().getClassLoader();
			}
			properties.put(Constants.UMPLE_FILE, outFile.getAbsolutePath());
			
			initialized = true;
			return properties;
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new GeneratorException("Error: " + e.getMessage());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new GeneratorException("Cannot load Provider's JAR");
		} catch (IOException e) {
			e.printStackTrace();
			throw new GeneratorException("Error: Copying the Umple file");
		}
	}


	 
	public void generateUmpleProject(UIGenerator generator) {
		if (!initialized)
			throw new GeneratorException("UmpleProjectWriter not initialized");
		allClasses = new ArrayList<BackingObject>(generator.getAllClasses());
		singletons = new ArrayList<BackingObject>(generator.getSingletons());
		classes = new ArrayList<BackingObject>(generator.getClasses());
		classMap = new HashMap<String, BackingObject>(generator.getClassMap());

		try {

			ArrayList<GenerationUnit> classByClassGU = new ArrayList<GenerationUnit>();
			ArrayList<GenerationUnit> allNormalClassesNoneGU = new ArrayList<GenerationUnit>();
			ArrayList<GenerationUnit> allClassesGU = new ArrayList<GenerationUnit>();
			ArrayList<GenerationUnit> allSingletonsGU = new ArrayList<GenerationUnit>();
			System.out.println("Generation process started");
			for (GenerationUnit gUnit : uProject.getGenerationUnits()
					.getGenerationUnit()) {
				if (gUnit.getParameterType().equals(
						Constants.NORMAL_CLASS_BY_CLASS)) {
					classByClassGU.add(gUnit);

				} else if (gUnit.getParameterType().equals(
						Constants.ALL_NORMAL_CLASSES)
						|| gUnit.getParameterType().equals(Constants.NONE)) {
					allNormalClassesNoneGU.add(gUnit);

				} else if (gUnit.getParameterType().equals(
						Constants.ALL_CLASSES)) {
					allClassesGU.add(gUnit);
				} else if (gUnit.getParameterType().equals(
						Constants.SINGLETON_CLASS_BY_CLASS)) {
					allSingletonsGU.add(gUnit);
				}

			}
			this.processClassByClassGU(classByClassGU, classes, generator);
			this.processClassByClassGU(allSingletonsGU, singletons, generator);
			this.processNonClassByClassGU(allNormalClassesNoneGU);
			this.processNonClassByClassGU(allClassesGU);
			processDirectories();
			processFiles();
			System.out.println("Generation SUCCESS");
		} catch (IOException e) {
			e.printStackTrace();
			throw new GeneratorException("Error: " + e.getMessage());
		}

	}
	private void processFiles() {
		if (uProject.getFiles() != null) {
			ArrayList<cruise.jaxb.File> files = new ArrayList<cruise.jaxb.File>(uProject.getFiles().getFile());
			for (cruise.jaxb.File file:files){
				String completeOutputFolder = outputFolder;
				if (file.getOutputSubFolder() != null) {
					completeOutputFolder = completeOutputFolder + File.separator
							+ file.getOutputSubFolder();
				}
				String completeFilePath="";
				if (file.getInputFolder()!=null){
					completeFilePath=file.getInputFolder()+ File.separator+file.getName();
				}
				
				File inFile = new File(completeFilePath);
				File outFile = new File(completeOutputFolder);
				outFile.mkdirs();
				outFile = new File(completeOutputFolder + File.separator
						+ file.getName());
				try {
					ClassWriter.copyFile(inFile, outFile);
				} catch (IOException e) {
					throw new GeneratorException("Error: Copying the file "+inFile.getAbsolutePath(), e);
				
				}	
			}
		
		}	
	}

	private void processDirectories() {
		if (uProject.getFiles() != null) {
			ArrayList<Directory> dirs = new ArrayList<Directory>(uProject
					.getFiles().getDirectory());
			for (Directory dir : dirs) {
				String completeOutputFolder = outputFolder;
				if (dir.getOutputSubFolder() != null) {
					completeOutputFolder = completeOutputFolder
							+ File.separator + dir.getOutputSubFolder();
				}
				File inFile = new File(dir.getInputFolder());
				File outFile = new File(completeOutputFolder);
				ClassWriter.copyDirectory(inFile, outFile);
			}
		}
	}

	private IGenerator instatiate(String className) {
		try {
			if (classCache.get(className) != null) {
				return classCache.get(className);
			}

			Class cl =Class.forName(className, true, classLoader);
			//Class cl = Class.forName(className);
			java.lang.reflect.Constructor co;
			co = cl.getConstructor(new Class[0]);
			IGenerator clazz = (IGenerator) co.newInstance(null);
			classCache.put(className, clazz);
			return clazz;
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneratorException("Error: Class not found! ["
					+ className + "]");
		}
	}

	private void processNonClassByClassGU(ArrayList<GenerationUnit> classesGU)
			throws IOException {

		for (GenerationUnit gUnit : classesGU) {
			String templateClass = gUnit.getTemplateClass();
			String templatePackage = gUnit.getTemplatePackage();
			if (templatePackage != null && templatePackage.trim().length() > 0) {
				templateClass = templatePackage + "." + templateClass;
			}
			String filePackage = (gUnit.getPackagePreffix() != null ? gUnit
					.getPackagePreffix() : "");
			String fileName = gUnit.getOutputName();
			if (gUnit.getClassSuffix() != null) {
				fileName = fileName + gUnit.getClassSuffix();
			}
			if (gUnit.getOutputExtension() != null) {
				fileName = fileName + "." + gUnit.getOutputExtension();
			}
			IGenerator templeate = instatiate(templateClass);
			String completeOutputFolder = outputFolder
					+ (gUnit.getOutputSubFolder() != null ? (File.separator + gUnit
							.getOutputSubFolder())
							: "");
			String result = "";
			if (gUnit.getParameterType().equals(Constants.NONE))
				result = templeate.generate(null);
			else if (gUnit.getParameterType().equals(
					Constants.ALL_NORMAL_CLASSES))
				result = templeate.generate(classes);
			else if (gUnit.getParameterType().equals(Constants.ALL_CLASSES))
				result = templeate.generate(allClasses);

			ClassWriter.writeFile(completeOutputFolder, filePackage, fileName,
					result);
		}

	}

	private void processClassByClassGU(ArrayList<GenerationUnit> classesGU,
			ArrayList<BackingObject> classesToProcess, UIGenerator generator)
			throws IOException {
		Iterator<BackingObject> bckObjIterator = classesToProcess.iterator();
		while (bckObjIterator.hasNext()) {
			BackingObject bckObj = bckObjIterator.next();
			for (GenerationUnit gUnit : classesGU) {
				bckObj.initialize(generator.getUIProvider());
				UmpleClass clazz = bckObj.getUClazz();
				String templateClass = gUnit.getTemplateClass();
				String templatePackage = gUnit.getTemplatePackage();
				if (templatePackage != null
						&& templatePackage.trim().length() > 0) {
					templateClass = templatePackage + "." + templateClass;
				}
				String filePackage = (gUnit.getPackagePreffix() != null ? gUnit
						.getPackagePreffix() : "");
				if (filePackage.trim().length() > 0) {
					filePackage = filePackage + "." + clazz.getPackageName();
				} else {
					filePackage = clazz.getPackageName();
				}
				if ("YES".equalsIgnoreCase(gUnit.getAddClassNameToRoute())) {
					filePackage = (filePackage.trim().length() > 0 ? (filePackage
							+ "." + clazz.getName())
							: clazz.getName());
				}
				String fileName = "";
				if (gUnit.getOutputName() == null) {
					fileName = clazz.getName();
				} else {
					fileName = gUnit.getOutputName();
				}
				if (gUnit.getClassSuffix() != null) {
					fileName = fileName + gUnit.getClassSuffix();
				}
				if (gUnit.getOutputExtension() != null) {
					fileName = fileName + "." + gUnit.getOutputExtension();
				}
				IGenerator templeate = instatiate(templateClass);
				String completeOutputFolder = outputFolder
						+ (gUnit.getOutputSubFolder() != null ? (File.separator + gUnit
								.getOutputSubFolder())
								: "");
				ClassWriter.writeFile(completeOutputFolder, filePackage,
						fileName, templeate.generate(bckObj));
			}
		}

	}

	
}
