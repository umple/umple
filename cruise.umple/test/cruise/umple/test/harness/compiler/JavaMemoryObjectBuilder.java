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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

import cruise.umple.test.harness.compiler.interfaces.IMemoryLanguageObjectBuilder;
import junit.framework.Assert;

public class JavaMemoryObjectBuilder implements IMemoryLanguageObjectBuilder<SimpleJavaFileObject> {
	List<SimpleJavaFileObject> objects;

	static URI toURI(String name) {
		try {
			return new URI(name);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public JavaMemoryObjectBuilder() {
		objects = new ArrayList<SimpleJavaFileObject>();
	}

	public static class InternalJavaClassMemoryObject extends SimpleJavaFileObject {
		protected ByteArrayOutputStream byteCode;

		private String code = null;

		InternalJavaClassMemoryObject(final String className, final String source) {
			super(toURI(className + Kind.SOURCE.extension), Kind.SOURCE);
			this.code = source;
		}

		InternalJavaClassMemoryObject(final String name, final Kind kind) {
			super(toURI(name), kind);
			code = null;
		}

		public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException
		{
			return code;
		}

		@Override
		public InputStream openInputStream() {
			return new ByteArrayInputStream(getByteCode());
		}

		@Override
		public OutputStream openOutputStream() {
			byteCode = new ByteArrayOutputStream();
			return byteCode;
		}

		byte[] getByteCode() {
			return byteCode.toByteArray();
		}
	}

	public static final class JavaMemoryObjectLoader extends ClassLoader {
		private final Map<String, JavaFileObject> memoryClasses = new HashMap<String, JavaFileObject>();

		JavaMemoryObjectLoader(final ClassLoader parentClassLoader) {
			super(parentClassLoader);
		}

		Collection<JavaFileObject> classes() {
			return Collections.unmodifiableCollection(memoryClasses.values());
		}

		@Override
		protected Class<?> findClass(final String qualifiedClassName) throws ClassNotFoundException {
			try {  
				JavaFileObject file = memoryClasses.get(qualifiedClassName);
				if (file != null) {
					byte[] bytes = ((InternalJavaClassMemoryObject) file).getByteCode();
					return defineClass(qualifiedClassName, bytes, 0, bytes.length);
				}
				// class is not found in loaded memory classes
				return Class.forName(qualifiedClassName);
			} catch (ClassNotFoundException ex) {
			}
			return super.findClass(qualifiedClassName);
		}

		void addJavaClassMemoryObject(final String qualifiedClassName, final JavaFileObject javaFile) {
			memoryClasses.put(qualifiedClassName, javaFile);
		}
	}



	@Override
	public SimpleJavaFileObject buildMemoryFileObject(String fullyQulifiedClassName, String code) {
		try {
			InternalJavaClassMemoryObject obj = new InternalJavaClassMemoryObject(fullyQulifiedClassName, code);
			objects.add(obj);
			return obj;
		} catch (Exception e) {
			Assert.fail("Failed to create JavaFileObject: " + e.toString());
		}
		return null;
	}

	@Override
	public Iterable<SimpleJavaFileObject> getMemoryFileObjects() {
		return objects;
	}

	@Override
	public void clear() {
		for(SimpleJavaFileObject obj : objects) {
			obj.delete();
		}
		objects.clear();
	}
}
