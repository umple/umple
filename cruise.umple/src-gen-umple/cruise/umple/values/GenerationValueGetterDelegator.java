/*******************************************************************************
* Copyright (c) 2013 Ahmed M.Orabi, Mahmoud M.Orabi.
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
package cruise.umple.values;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import cruise.umple.core.ArgumentsRetrieval;
import cruise.umple.core.GenerationLogger;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationValueAnnotation;


public class GenerationValueGetterDelegator implements IGenerationValueGetter{
	
	private static ReentrantLock lock= new ReentrantLock();
	
	protected static List<Class<?>> parsedClasses= new ArrayList<Class<?>>();
	protected static Map<String, List<MethodDescriptor>> fieldDescriptorsMap= new HashMap<String, List<MethodDescriptor>>();
	
	private GenerationPolicyRegistry fRegistry;
	
	public GenerationValueGetterDelegator(GenerationPolicyRegistry registry) {
		this.fRegistry= registry;
	}
	
	@Override
	public boolean getBoolean(Object classObject, String fieldName, Object... arguments){
		Boolean value = (Boolean) getValue(classObject, fieldName,  arguments);
		if(value== null){
			return false;
		}
		return value.booleanValue();
	}
	
	@Override
	public Object getObject(Object classObject, String fieldName, Object... arguments){
		return getValue(classObject, fieldName,  arguments);
	}
	
	@Override
	public int getInt(Object classObject, String fieldName, Object... arguments){
		Integer value = (Integer) getValue(classObject, fieldName,  arguments);
		if(value== null){
			return 0;
		}
		return value.intValue();
	}
	
	@Override
	public String getString(Object classObject, String fieldName, Object... arguments){
		Object value = getValue(classObject, fieldName,  arguments);
		if(value instanceof String){
			return (String) value;
		}
		return null;
	}
	
	@Override
	public List<?> getList(Object classObject, String fieldName, Object... arguments){
		List<?> value = (List<?>) getValue(classObject, fieldName,  arguments);
		return value!=null? value: Collections.emptyList();
	}
	
	private ArgumentsRetrieval argumentRetriever= new ArgumentsRetrieval();
	
	private Object getValue(Object classObject, String fieldName, Object... arguments) {
		if(classObject== null){
			return null;
		}
		
		List<Object> value = this.argumentRetriever.getValue(fieldName, classObject, arguments);
		if(!value.isEmpty()){
			return value.get(0);
		}
		
		List<MethodDescriptor> methodDescriptors = fieldDescriptorsMap.get(fieldName);
		
		if(methodDescriptors== null){
			//TODO: Logger Logger
			this.argumentRetriever.setValue(fieldName, true, null, classObject, arguments);
			return null;
		}
		
		try {
			//FIXME
			for(MethodDescriptor methodDescriptor: methodDescriptors){
				Object obtainedValue = methodDescriptor.invoke(classObject, this.fRegistry, arguments);
				if(obtainedValue== null){
					continue;
				}
				
				this.argumentRetriever.setValue(fieldName, true, obtainedValue, classObject, arguments);
				
				return obtainedValue;
			}
		} catch (Exception e) {
			//No need to get an exception value over and over, so cache it regardless
			this.argumentRetriever.setValue(fieldName, true, null, classObject, arguments);
			
			//TODO: Logger Logger
			return null;
		}
		
		//TODO: Logger Logger
		this.argumentRetriever.setValue(fieldName, true, null, classObject, arguments);
		return null;
	}
	
	//TODO: Still not tested well
	//FIXME: There is extra loop in the methods when searching in parent
	synchronized private void locateAnnotation(Object handler) {
		List<Class<?>> visited= new ArrayList<Class<?>>();
		locateAnnotation(handler, visited);
	}

	private void locateAnnotation(Object handler, List<Class<?>> visited) {
		Class<? extends Object> clazz= handler.getClass();
		if(visited.contains(clazz)){
			return;
		}
		visited.add(clazz);
		for (Method method : clazz.getMethods()) {
			GenerationValueAnnotation annotation = null;
			annotation = method.getAnnotation(GenerationValueAnnotation.class);
			if (annotation != null) {
				addAnnotationDetails(method, annotation, handler);
				continue;
			}
			
			String methodName = method.getName();
			Class<?>[] parameterTypes = method.getParameterTypes();
			
			Class<?> superclass = clazz.getSuperclass();
			try {
				if(superclass!= null){
					Method superMethod = superclass.getMethod(methodName,parameterTypes);

					if (superMethod != null) {
						annotation = superMethod.getAnnotation(GenerationValueAnnotation.class);
						if (annotation != null) {
							addAnnotationDetails(method, annotation, handler);
							continue;
						}
					}
				}
			} catch (Exception e) {
				// swallow exception. It is fine that the super class does not have the method
			}
			
			for (Class<?> interfaceClass : clazz.getInterfaces()) {
				try {
					Method interfaceMethod = interfaceClass.getMethod(methodName,parameterTypes);
					annotation = interfaceMethod.getAnnotation(GenerationValueAnnotation.class);
					if (annotation != null) {
						addAnnotationDetails(method, annotation, handler);
						continue;
					}
				} catch (Exception e) {
					// swallow exception. It is also fine that an implemented interface does not have the method
				}
			}
			if(annotation== null&& superclass!= null){
				locateAnnotation(superclass, visited);
			}
		}
	}

	private static void addAnnotationDetails(Method method,
			GenerationValueAnnotation annotation, Object handler) {
		String fieldName = annotation.fieldName();
		MethodDescriptor methodDescriptor = new MethodDescriptor(method, handler);
		List<MethodDescriptor> list = fieldDescriptorsMap.get(fieldName);
		if(list== null){
			list= new ArrayList<MethodDescriptor>();
			fieldDescriptorsMap.put(fieldName, list);
		}
		list.add(methodDescriptor);
	}

	@Override
	public void register(Object handler) {
		Class<? extends Object> clazz = handler.getClass();
		if(parsedClasses.contains(clazz)){
			return;
		}
		
		lock.lock();
		locateAnnotation(handler);
		lock.unlock();
		
		parsedClasses.add(clazz);
	}

	@Override
	public GenerationLogger getGenerationLogger() {
		return this.fRegistry.getGenerationLogger();
	}
	
}