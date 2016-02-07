/*******************************************************************************
* Copyright (c) 2016 Ahmed M.Orabi, Mahmoud M.Orabi.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Ahmed M.Orabi
*     Mahmoud M.Orabi
*
* Please refer to the code authors before making any changes. 
* For any code reuse or copy, contact the authors and it is a MUST 
* to refer author names.
*
* @author -Ahmed M.Orabi {@link ahmedvc@hotmail.com}
* @author Mahmoud M.Orabi {@link mahmoud_3rabi@hotmail.com}
*******************************************************************************/
package cruise.umple.test.harness.compiler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import cruise.umple.test.harness.compiler.JavaMemoryObjectBuilder.InternalJavaClassMemoryObject;
import cruise.umple.test.harness.compiler.JavaMemoryObjectBuilder.JavaMemoryObjectLoader;
import cruise.umple.test.harness.compiler.interfaces.ICompiler;
import cruise.umple.test.harness.compiler.interfaces.IMemoryLanguageObjectBuilder;
import junit.framework.Assert;

public class JavaInternalCompiler implements ICompiler {
	private String tempClassFiles;
	private JavaCompiler compiler;
	private CompilationErrorListener errTracer;
	private ClassFileManager fileManager; 
	private JavaMemoryObjectLoader classLoader;
	private IMemoryLanguageObjectBuilder<SimpleJavaFileObject> javaObjectBuilder;
	private boolean compilerToolsFound = false;

	class ClassFileManager extends ForwardingJavaFileManager<JavaFileManager> {
		private JavaMemoryObjectLoader javaMemoryClassObjectLoader;
		private Map<URI, JavaFileObject> memoryClasses = new HashMap<URI, JavaFileObject>();

		public ClassFileManager(JavaFileManager fileManager, JavaMemoryObjectLoader classLoader) {
			super(fileManager);
			this.javaMemoryClassObjectLoader = classLoader;
		}

		private URI buildURI(Location loc, String pkgName, String relName) {
			return JavaMemoryObjectBuilder.toURI(loc.getName() + '/' + pkgName + '/' + relName);
		}

		@Override
		public FileObject getFileForInput(Location loc, String pkgName, String relName) throws IOException {
			FileObject memObj = memoryClasses.get(buildURI(loc, pkgName, relName));
			if (memObj != null)
				return memObj;
			return super.getFileForInput(loc, pkgName, relName);
		}

		@Override
		public JavaFileObject getJavaFileForOutput(Location loc, String qName, Kind kind, FileObject outputFile) throws IOException {
			JavaFileObject memObj = new InternalJavaClassMemoryObject(qName, kind);
			javaMemoryClassObjectLoader.addJavaClassMemoryObject(qName, memObj);
			return memObj;
		}

		public ClassLoader getClassLoader() {
			return javaMemoryClassObjectLoader;
		}

		public Class<?> loadClass(String className) throws ClassNotFoundException {
			return getClassLoader().loadClass(className);
		}

		@Override
		public ClassLoader getClassLoader(Location loc) {
			return getClassLoader();
		}

		@Override
		public String inferBinaryName(Location loc, JavaFileObject file) {
			if (file instanceof InternalJavaClassMemoryObject)
				return file.getName();
			else
				return super.inferBinaryName(loc, file);
		}

		@Override
		public Iterable<JavaFileObject> list(Location loc, String pkgName, Set<Kind> kinds, boolean recurse) throws IOException {
			Iterable<JavaFileObject> result = super.list(loc, pkgName, kinds,recurse);
			ArrayList<JavaFileObject> fileObjects = new ArrayList<JavaFileObject>();
			if (loc == StandardLocation.CLASS_PATH && kinds.contains(JavaFileObject.Kind.CLASS)) {
				for (JavaFileObject file : memoryClasses.values()) {
					if (file.getKind() == Kind.CLASS && file.getName().startsWith(pkgName))
						fileObjects.add(file);
				}
				fileObjects.addAll(javaMemoryClassObjectLoader.classes());
			} else if (loc == StandardLocation.SOURCE_PATH && kinds.contains(JavaFileObject.Kind.SOURCE)) {
				for (JavaFileObject file : memoryClasses.values()) {
					if (file.getKind() == Kind.SOURCE && file.getName().startsWith(pkgName))
						fileObjects.add(file);
				}
			}
			for (JavaFileObject file : result) {
				fileObjects.add(file);
			}
			return fileObjects;
		}
	}


	public static class CompilationErrorListener implements DiagnosticListener<JavaFileObject> {
		public void report(Diagnostic<? extends JavaFileObject> err) {
			String newLine = System.getProperty("line.separator");
			StringBuilder sb = new StringBuilder();
			sb.append("at line "+err.getLineNumber());
			sb.append(newLine);
			sb.append(", "+err.getMessage(Locale.ENGLISH));
			sb.append(newLine);
			sb.append(", "+err.getSource());

			Assert.fail("Compilation Failed : " + sb.toString());
		}
	}

	public JavaInternalCompiler() {
		compiler = ToolProvider.getSystemJavaCompiler();
		if(compiler != null) {
			compilerToolsFound = true;
			errTracer = new CompilationErrorListener();
			javaObjectBuilder = new JavaMemoryObjectBuilder();
		}
	}

	@Override
	public String getlanguage() {
		return "Java";
	}

	@Override
	public void compile() {
		if(this.isEnabled()) {
			if(tempClassFiles != null && tempClassFiles.length() > 0) {
				ClassLoader parent = getClass().getClassLoader();
				classLoader = new JavaMemoryObjectLoader(parent);				
				Iterable options = Arrays.asList("-d", tempClassFiles);
				StandardJavaFileManager compiletStandardFileManager = compiler.getStandardFileManager(errTracer,Locale.ENGLISH, null);
				fileManager =  new ClassFileManager(compiletStandardFileManager, classLoader);
				JavaCompiler.CompilationTask compile = compiler.getTask(null, fileManager,
						errTracer, options, null,javaObjectBuilder.getMemoryFileObjects());
				Boolean compilationResult = compile.call();
				Assert.assertTrue(compilationResult);
			} else {
				Assert.fail("Temporary Class Path is not given");
			}
		}
	}

	@Override
	public String run(String mainClass, int timeout) {
		if(this.isEnabled()) {
			PrintStream stdout = System.out;
			ByteArrayOutputStream recordedOutput = new ByteArrayOutputStream();
			PrintStream recordPrinter = new PrintStream(recordedOutput);
			System.setOut(recordPrinter);
			Runnable mainClassRun = new Runnable() {
				@Override
				public void run() {
					try {
						fileManager.loadClass(mainClass).getDeclaredMethod("main", new Class[] { String[].class }).invoke(null, new Object[] { null });
					} catch (Exception e) {
						Assert.fail("Run Failed : " + e);
					} 
				}
			};
			try {
				ExecutorService runService = Executors.newSingleThreadExecutor();
				Future<?> run = runService.submit(mainClassRun);
				run.get(timeout, TimeUnit.MILLISECONDS);	
			}
			catch (Exception ex)
			{
				Assert.fail("Run Failed : " + ex);
			}
			// reset
			System.setOut(stdout);
			String consoleOutput = new String( recordedOutput.toByteArray(), Charset.defaultCharset() ); 
			return consoleOutput;
		}
		return "";
	}

	@Override
	public void addFile(String fullyQualifiedName, String code) {
		javaObjectBuilder.buildMemoryFileObject(fullyQualifiedName, code);
	}

	@Override
	public IMemoryLanguageObjectBuilder<SimpleJavaFileObject> getObjectBuiler() {
		return javaObjectBuilder;
	}

	@Override
	public void clean() {
		javaObjectBuilder.clear();
		ResourceBundle.clearCache(ClassLoader.getSystemClassLoader()); // <--useless
	}

	@Override
	public void setTempPath(String path) {
		this.tempClassFiles = path;
		this.clean();
	}

	@Override
	public boolean isEnabled() {
		return compilerToolsFound;
	}

	@Override
	public void close() {
		clean();
		try {
			fileManager.close();
		} catch (IOException e) {
		}
	}

}
