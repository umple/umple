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
package cruise.umple.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;

import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationArguments;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationLoopPath;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationCallback.GenerationStringSegment;
import cruise.umple.core.GenerationCallback.WatchedObjectValue;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.gen.GenPackage;
import cruise.umple.templates.GenerationTemplateDelegator;
import cruise.umple.templates.IGenerationTemplateRegistry;
import cruise.umple.values.GenerationValueGetterDelegator;
import cruise.umple.values.IGenerationValueGetter;


public class GenerationPolicyRegistry implements IGenerationTemplateRegistry, IGenerationValueGetter{
	
	private GenerationTemplateDelegator generationTemplateDelegator;
	private IGenerationValueGetter generationValueGetter;
	
	private static List<Class<?>> parsedClasses= new ArrayList<Class<?>>();
	private static Map<String, List<GenerationPointObject>> _pointsInvocations= new HashMap<String, List<GenerationPointObject>>();
	private static Map<String, Map<String, List<LoopObject>>> _loopInvocations= new HashMap<String, Map<String, List<LoopObject>>>();
	protected static Map<String, GenerationGroupDefinition> groupDefnitions= new HashMap<String, GenerationGroupDefinition>();
	private static Map<String, List<Object>> _parsedClasses= new WeakHashMap<String, List<Object>>();
	
	
	private static Map<String, List<LoopProcessorObject>> _loopProcessorsInocations= new HashMap<String, List<LoopProcessorObject>>();
	
	private Map<Object, Map<String, List<SimpleEntry<Object, Object>>>> fabricatedObjects= new HashMap<Object, Map<String,List<SimpleEntry<Object,Object>>>>();
	private Map<Object, Object> relatedObjects= new HashMap<Object, Object>();
	
	private static Set<String> _loopProcessorsAspects= new TreeSet<String>(new Comparator<String>(){
		
	    @Override
		public int compare(String a, String b){
	    	String[] aSplit = a.split(CommonConstants.UNDERSCORE);
	    	String[] bSplit = b.split(CommonConstants.UNDERSCORE);
	    	
	    	Integer aspect1= Integer.valueOf(aSplit[1]);
	    	Integer aspect2= Integer.valueOf(bSplit[1]);
	    	
	    	int aspectCompareTo = aspect1.compareTo(aspect2);
	    	if(aspectCompareTo!=0){
	    		return aspectCompareTo;
	    	}
	    	
	    	Integer group1= Integer.valueOf(aSplit[0]);
	    	Integer group2= Integer.valueOf(bSplit[0]);
	        return group2.compareTo(group1);
	    }
	});
	
	private static Map<String, List<GenerationPointObject>> _watchingPointsInvocations= new HashMap<String, List<GenerationPointObject>>();
	private static boolean processed= false;

	private Map<Object, TreeMap<String, Object>> objectsPathMap= new HashMap<Object, TreeMap<String, Object>>();
	protected ArgumentsRetrieval generationObjectsRetriever= new ArgumentsRetrieval();
	protected ArgumentsRetrieval decisionObjectsRetriever= new ArgumentsRetrieval();
	private ArgumentsRetrieval interceptedObjectsRetriever= new ArgumentsRetrieval();
	
	public GenerationLogger generationLogger;
	public GenPackage rootModel;
	
	public GenerationPolicyRegistry() {
		super();
		
		this.rootModel= new GenPackage();
		this.rootModel.setLanguage("Cpp");
		
		this.generationLogger= new GenerationLogger();
		
		this.generationValueGetter= new GenerationValueGetterDelegator(this);
		this.generationTemplateDelegator= new GenerationTemplateDelegator(this);
		processGroupDefinitions(GenerationGroupDefinition.class);
	}
	
	public void registerGenerationPolicy(Object policy){
		this.generationValueGetter.register(policy);
	}
	
	public void addRelatedObject(Object object, Object relatedTo){
		this.relatedObjects.put(object, relatedTo);
	}
	
	public void addProcessableObject(Map<String, Object> processableObject, String id, Object parent, Object... delgators){
		Map<String, List<SimpleEntry<Object, Object>>> map = this.fabricatedObjects.get(parent);
		if(map== null){
			map= new HashMap<String, List<SimpleEntry<Object,Object>>>();
			this.fabricatedObjects.put(parent, map);
		}
		
		List<SimpleEntry<Object, Object>> list = map.get(id);
		if(list== null){
			list= new ArrayList<SimpleEntry<Object,Object>>();
			map.put(id, list);
		}
		
		list.add(new SimpleEntry<Object, Object>(processableObject, delgators.length>0? delgators[0]: null));
	}
	
	public void process(Object obj){
		postRegister();
		HashMap<String, Object> values = new HashMap<String, Object>();
		values.put(CommonConstants.BLANK, obj);
		process(obj, Collections.<String> emptyList(), values, CommonConstants.BLANK);
	}
	
	public void process(Object obj, List<String> path, Map<String, Object> values, String key){
		for(String aspect: _loopProcessorsAspects){
			processRoot(obj, aspect);
			process(obj, path, values, key, aspect);
		}
	}

	private void process(Object obj, List<String> path, Map<String, Object> values, String key, String aspect) {
		Map<String, List<LoopObject>> map = _loopInvocations.get(key);
		if(map== null){
			return;
		}
		for(String item: map.keySet()){
			List<LoopObject> list = map.get(item);
			for(LoopObject loopObject: list){
				String id = loopObject.fGenerationLoopAnnotation.id();
				List<String> newPath= new ArrayList<String>(path);
				newPath.add(id);
				
				try {
					List<LoopProcessorObject> processors = _loopProcessorsInocations.get(newPath.toString()+ aspect);
					
					Object invoke = loopObject.fMethod.invoke(loopObject.fInstance, getParameters(obj, this, loopObject.fMethod));
					if(invoke instanceof List<?>){
						@SuppressWarnings("unchecked")
						List<Object> sub= new ArrayList<Object>((List<Object>) invoke);
						
						Map<String, List<SimpleEntry<Object, Object>>> fabricatedMap = this.fabricatedObjects.get(obj);
						if(fabricatedMap!= null){
							List<SimpleEntry<Object, Object>> listOfExtraObjects = fabricatedMap.get(id);
							if(listOfExtraObjects!= null){
								sub.addAll(listOfExtraObjects);
							}
						}
						
						if(processors!= null&& !processors.isEmpty()){
							for(Object subObject: sub){
								TreeMap<String, Object> newMap = new TreeMap<String, Object>(values);
								newMap.put(id, subObject);
								this.objectsPathMap.put(subObject, newMap);
								 
								process(subObject, processors);
								process(subObject, newPath, newMap, id, aspect);
							}
						}else{
							for(Object subObject: sub){
								HashMap<String, Object> newMap = new HashMap<String, Object>(values);
								newMap.put(id, subObject);
								process(subObject, newPath, newMap, id, aspect);
							}
						}
					}
				} catch (Exception e) {
					this.generationLogger.addError(e);
				}
			}
		}
	}
	
	private void processRoot(Object obj, String aspect) {
		TreeMap<String, Object> hashMap = getPathMap(obj);
		if(hashMap== null){
			hashMap= new TreeMap<String, Object>();
			hashMap.put(CommonConstants.BLANK, obj);
			this.objectsPathMap.put(obj, hashMap);
		}
		
		List<LoopProcessorObject> processors = _loopProcessorsInocations.get(Collections.<String> emptyList().toString()+ aspect);
		
		if(processors!= null){
			try {
				process(obj, processors);
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
		
		
	}

	private void process(Object obj, List<LoopProcessorObject> pre)
			throws IllegalAccessException, InvocationTargetException {
		for(LoopProcessorObject loopProcessorObject: pre){
			loopProcessorObject.fMethod.invoke(loopProcessorObject.fInstance,
					getParameters(obj, this, loopProcessorObject.fMethod));
			
			//System.gc();
			//Runtime.getRuntime().freeMemory();
		}
	}

	public List<?> generationPoint(Object element, String generationPoint, Object... arguments){
		if(element instanceof Map){
			Object object = ((Map<?, ?>)element).get(generationPoint);
			if(object== null){
				return new ArrayList<Object>();
			}
			if(object instanceof List){
				return (List<?>) object;
			}
			
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(object);
			return arrayList;
		}
		
		if(element instanceof SimpleEntry){
			@SuppressWarnings("unchecked")
			SimpleEntry<Object, Object> simpleEntry= (SimpleEntry<Object, Object>) element;
			Object object = ((Map<?, ?>)simpleEntry.getKey()).get(generationPoint);
			if(object instanceof List){
				return (List<?>) object;
			}
			
			Object value = simpleEntry.getValue();
			if(value!= null){
				return generationPoint(value, generationPoint, arguments);
			}
			
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(object);
			return arrayList;
		}
		
		List<Object> value = this.interceptedObjectsRetriever.getValue(generationPoint, element, arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof List){
				return (List<?>) object;
			}
			return new ArrayList<Object>();
		}
		
		List<GenerationPointObject> list = _pointsInvocations.get(generationPoint);
		if(list== null){
			return new ArrayList<Object>();
		}
		
		List<Object> responses= new ArrayList<Object>(list.size());
		
		for(GenerationPointObject generationPointObject: list){
			try {
				if(generationPointObject.fGenerationPoint.defaulted()){
					continue;
				}
				
				Object invoke= generationPointObject.invoke(element, this, null, null, arguments);
				
				if(generationPointObject.unique()&& invoke instanceof Boolean&& (((Boolean)invoke)).booleanValue()){
					this.interceptedObjectsRetriever.setValue(generationPoint, responses, true, element, arguments);
					return responses;
				}
				
				responses.add(invoke);
				
				if(generationPointObject.unique()){
					this.interceptedObjectsRetriever.setValue(generationPoint, invoke, true, element, arguments);
					return Arrays.asList(new Object[]{invoke});
				}
				
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
		this.interceptedObjectsRetriever.setValue(generationPoint, responses, true, element, arguments);
		return responses;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> generationPointList(Object element, String generationPoint, Object... arguments){
		if(element instanceof Map){
			Object object = ((Map<?, ?>)element).get(generationPoint);
			if(object== null){
				return new ArrayList<Object>();
			}
			if(object instanceof List){
				return (List<Object>) object;
			}
			
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(object);
			return arrayList;
		}
		
		if(element instanceof SimpleEntry){
			SimpleEntry<Object, Object> simpleEntry= (SimpleEntry<Object, Object>) element;
			Object object = ((Map<?, ?>)simpleEntry.getKey()).get(generationPoint);
			if(object instanceof List){
				return (List<Object>) object;
			}
			
			Object value = simpleEntry.getValue();
			if(value!= null){
				return generationPointList(value, generationPoint, arguments);
			}
			
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(object);
			return arrayList;
		}
		
		List<Object> value = this.interceptedObjectsRetriever.getValue(generationPoint, element, arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof ArrayList){
				return (List<Object>) object;
			}
			return new ArrayList<Object>();
		}
		
		List<Object> all= new ArrayList<Object>();

		List<GenerationPointObject> list = _pointsInvocations.get(generationPoint);
		if(list== null){
			return all;
		}
		
		for(GenerationPointObject generationPointObject: list){
			try {
				Object invoke= generationPointObject.invoke(element, this, null, null, arguments);
				
				if(invoke instanceof Collection== false){
					continue;
				}
				
				Collection<?> newCollection= (Collection<?>) invoke;
				all.addAll(newCollection);
				
				if(generationPointObject.unique()){
					this.interceptedObjectsRetriever.setValue(generationPoint, all, true, element, arguments);
					return all;
				}
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
		this.interceptedObjectsRetriever.setValue(generationPoint, all, true, element, arguments);
		return all;
	}
	
	public String generationPointString(Object element, String generationPoint, Object... arguments){
		if(element instanceof Map){
			Object object = ((Map<?, ?>)element).get(generationPoint);
			if(object instanceof String){
				return (String) object;
			}
		}
		
		if(element instanceof SimpleEntry){
			@SuppressWarnings("unchecked")
			SimpleEntry<Object, Object> simpleEntry= (SimpleEntry<Object, Object>) element;
			Object object = ((Map<?, ?>)simpleEntry.getKey()).get(generationPoint);
			if(object instanceof String){
				return (String) object;
			}
			
			Object value = simpleEntry.getValue();
			if(value!= null){
				return generationPointString(value, generationPoint, arguments);
			}
			
			return CommonConstants.BLANK;
		}
		
		List<Object> value = this.interceptedObjectsRetriever.getValue(generationPoint, element, arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof String){
				return (String) object;
			}
			return CommonConstants.BLANK;
		}
		
		String all= CommonConstants.BLANK;

		List<GenerationPointObject> list = _pointsInvocations.get(generationPoint);
		if(list== null){
			return CommonConstants.BLANK;
		}
		
		for(GenerationPointObject generationPointObject: list){
			try {
				if(generationPointObject.fGenerationPoint.defaulted()&& !all.isEmpty()){
					continue;
				}
				
				Object invoke= generationPointObject.invoke(element, this, all, null, arguments);
				
				if(generationPointObject.unique()&& invoke instanceof Boolean&& (((Boolean)invoke)).booleanValue()){
					this.interceptedObjectsRetriever.setValue(generationPoint, all, true, element, arguments);
					return all;
				}
				
				if(invoke instanceof String== false){
					continue;
				}
				
				all= all+ invoke;
				
				if(generationPointObject.unique()){
					this.interceptedObjectsRetriever.setValue(generationPoint, invoke, true, element, arguments);
					return (String) invoke;
				}
				
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
		this.interceptedObjectsRetriever.setValue(generationPoint, all, true, element, arguments);
		return all;
	}

	public Integer generationPointInteger(Object element, String generationPoint, Object... arguments){
		if(element instanceof SimpleEntry){
			@SuppressWarnings("unchecked")
			SimpleEntry<Object, Object> simpleEntry= (SimpleEntry<Object, Object>) element;
			Object object = ((Map<?, ?>)simpleEntry.getKey()).get(generationPoint);
			if(object instanceof Integer){
				return (Integer) object;
			}
			
			Object value = simpleEntry.getValue();
			if(value!= null){
				return generationPointInteger(value, generationPoint, arguments);
			}
			
			return Integer.valueOf(0);
		}
		
		List<Object> value = this.interceptedObjectsRetriever.getValue(generationPoint, element, arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof Integer){
				return (Integer) object;
			}
			return Integer.valueOf(0);
		}
		
		Integer returnValue = null;
		int currentPriority = 0;
		List<GenerationPointObject> list = _pointsInvocations.get(generationPoint);
		if(list== null){
			this.interceptedObjectsRetriever.setValue(generationPoint, Integer.valueOf(0), true, element, arguments);
			return Integer.valueOf(0);
		}
		
		for(GenerationPointObject generationPointObject: list){
			try {
				Object invoke= generationPointObject.invoke(element, this, null, null, arguments);
				
				if(invoke!= null){
					if(invoke instanceof Integer== false){
						continue;
					}
					
					int currentValue = ((Integer) invoke).intValue();
					
					if(generationPointObject.unique()){
						this.interceptedObjectsRetriever.setValue(generationPoint, Integer.valueOf(currentValue), true, element, arguments);
						return Integer.valueOf(currentValue);
					}
					
					if(invoke instanceof Integer){
						int priority = generationPointObject.fGenerationPoint.priority();
						if(priority>currentPriority){
							returnValue= Integer.valueOf(currentValue);
							currentPriority= priority;
						}
					}
				}
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
		this.interceptedObjectsRetriever.setValue(generationPoint, returnValue, true, element, arguments);
		return returnValue;
	}

	
	@Override
	public synchronized void register(Object handler) {
		if(handler instanceof Class<?>){
			if(parsedClasses.contains(handler)){
				return;
			}
			Class<?> clazz = (Class<?>) handler;
			
			processGroupDefinitions(clazz);
			parsedClasses.add(clazz);
			return;
		}
		
		Class<? extends Object> clazz= handler.getClass();
		if(parsedClasses.contains(clazz)){
			return;
		}
		parsedClasses.add(clazz);
		
		processGroupDefinitions(clazz);
		
		Set<String> toBeSorted= new HashSet<String>();
		
		for (Method method : clazz.getMethods()) {
			GenerationLoopAnnotation generationLoopAnnotation = method.getAnnotation(GenerationLoopAnnotation.class);
			if(generationLoopAnnotation!= null){
				String id = generationLoopAnnotation.id();
				String[] processes = generationLoopAnnotation.processes();
				
				Map<String, List<LoopObject>> map= null;
				
				if(processes.length==0){
					processes= new String[]{CommonConstants.BLANK};
				}
				
				for(String process: processes){
					map = _loopInvocations.get(process);
					if(map== null){
						map= new HashMap<String, List<LoopObject>>();
						if(_loopInvocations.get(process)== null){
							_loopInvocations.put(process, map);
						}
					}
					
					List<LoopObject> list = map.get(id);
					if(list== null){
						list= new ArrayList<LoopObject>();
						map.put(id, list);
					}
					list.add(new LoopObject(method, handler, generationLoopAnnotation));
				}
				continue;
			}
			
			LoopProcessorAnnotation loopProcessorAnnotation = method.getAnnotation(LoopProcessorAnnotation.class);
			if(loopProcessorAnnotation!= null){
				setLoopProcessorAnnotation(handler, method, loopProcessorAnnotation, null);
				continue;
			}
			
			LoopProcessorAnnotations loopProcessorAnnotations = method.getAnnotation(LoopProcessorAnnotations.class);
			if(loopProcessorAnnotations!= null){
				for(LoopProcessorAnnotation loop: loopProcessorAnnotations.loopProcessorAnnotations()){
					setLoopProcessorAnnotation(handler, method, loop, loopProcessorAnnotations);
				}
				continue;
			}
			
			GenerationPoint annotation = method.getAnnotation(GenerationPoint.class);
			if(annotation== null){
				GenerationPoints annotations = method.getAnnotation(GenerationPoints.class);
				if(annotations== null){
					continue;
				}
				
				for(GenerationPoint currentAnnotation: annotations.value()){
					processAnnotationDetails(currentAnnotation, method, clazz, toBeSorted);
				}
			}
			
			processAnnotationDetails(annotation, method, clazz, toBeSorted);
		}
		
		for(String generationPoint: toBeSorted){
			Collections.sort(_pointsInvocations.get(generationPoint), new GenerationPointObjectsComparator());
		}
	}

	private void processGroupDefinitions(Class<?> clazz) {
		for(Field field: clazz.getDeclaredFields()){
			GenerationGroupDefinition annotation = field.getAnnotation(GenerationGroupDefinition.class);
			if(annotation!= null){
				try {
					Object object = field.get(clazz);
					if(object instanceof String== false){
						continue;
					}
					
					groupDefnitions.put((String) object, annotation);
				} catch (Exception e) {
					this.generationLogger.addError(e);
				}
			}
		}
	}
	
	private synchronized static void postRegister(){
		if(processed){
			return;
		}
		
		for(Object key: _loopProcessorsInocations.keySet()){
			List<LoopProcessorObject> processors = _loopProcessorsInocations.get(key);
			
			Collections.sort(processors, new Comparator<LoopProcessorObject>() {

				@Override
				public int compare(LoopProcessorObject o1, LoopProcessorObject o2) {
					int priority1 = o1.fLoopProcessorAnnotation.priority();
					int priority2 = o2.fLoopProcessorAnnotation.priority();
					
					LoopProcessorAnnotations loopProcessorAnnotations1 = o1.fLoopProcessorAnnotations;
					if(loopProcessorAnnotations1!= null){
						priority1 = loopProcessorAnnotations1.priority();
					}
					
					LoopProcessorAnnotations loopProcessorAnnotations2 = o2.fLoopProcessorAnnotations;
					if(loopProcessorAnnotations2!= null){
						priority2 = loopProcessorAnnotations2.priority();
					}
					
					if(priority1== priority2){
						return 0;
					}
					
					return priority1> priority2? -1: 1;
				}
			});
		}
		
		for(Object key: _watchingPointsInvocations.keySet()){
			Collections.sort(_watchingPointsInvocations.get(key), new GenerationPointObjectsComparator());
		}
		
		processed= true;
	}

	private void setLoopProcessorAnnotation(Object handler, Method method, LoopProcessorAnnotation loopProcessorAnnotation, 
			LoopProcessorAnnotations loopProcessorAnnotations) {
		int[] aspects= loopProcessorAnnotations!= null? loopProcessorAnnotations.aspect(): loopProcessorAnnotation.aspect();
		int group= loopProcessorAnnotations!= null? loopProcessorAnnotations.aspectGroup(): loopProcessorAnnotation.aspectGroup();
		
		for(int aspect: aspects){
			String groupAspect = String.valueOf(group)+ CommonConstants.UNDERSCORE+ String.valueOf(aspect);
			_loopProcessorsAspects.add(groupAspect);
			String[] processPath = loopProcessorAnnotation.processPath();
			List<String> asList = Arrays.asList(processPath);
			String identifier = asList.toString()+ groupAspect;
			List<LoopProcessorObject> list = _loopProcessorsInocations.get(identifier);
			if(list== null){
				list= new ArrayList<GenerationPolicyRegistry.LoopProcessorObject>();
				_loopProcessorsInocations.put(identifier, list);
			}
			list.add(new LoopProcessorObject(method, handler, loopProcessorAnnotation, loopProcessorAnnotations));
		}
	}

	private void processAnnotationDetails(GenerationPoint annotation, Method method, Object instance, Set<String> toBeSorted){
		if(annotation== null){
			return;
		}
		String[] generationPoints = annotation.generationPoint();
		
		for(String generationPoint: generationPoints){
			List<Object> list = _parsedClasses.get(generationPoint);
			if(list== null){
				list= new ArrayList<Object>();
			}
			
			Class<? extends Object> clazz = instance.getClass();
			if(!list.contains(clazz)){
				list.add(clazz);
				_parsedClasses.put(generationPoint, list);
			}
			
			List<GenerationPointObject> pointInvocations = _pointsInvocations.get(generationPoint);
			if(pointInvocations== null){
				pointInvocations= new ArrayList<GenerationPointObject>();
				_pointsInvocations.put(generationPoint, pointInvocations);
			}
			
			toBeSorted.add(generationPoint);
			GenerationPointObject generationPointObject = new GenerationPointObject(method, annotation, instance);
			pointInvocations.add(generationPointObject);
		}
	}
	
	public void setFieldsParameters(Object instance, Object element, Field[] fields, Object... args){
		setFieldsParameters(instance, element, fields, false, args);
	}
	
	public void setFieldsParameters(Object instance, Object element, Field[] fields, boolean typeCheck, Object... args){
		List<FieldDescriptor> fieldsDescriptors = getFieldsParameters(element, fields, typeCheck, args);
		for(FieldDescriptor fieldDescriptor: fieldsDescriptors){
			fieldDescriptor.fField.setAccessible(true);
			try {
				fieldDescriptor.fField.set(instance, fieldDescriptor.fValue);
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
	}
	
	public List<FieldDescriptor> getFieldsParameters(Object element, Field[] fields, Object... args) {
		return getFieldsParameters(element, fields, false, args);
	}
	
	public List<FieldDescriptor> getFieldsParameters(Object element, Field[] fields, boolean typeCheck, Object... args) {
		Map<String, Object> descriptorMap= new HashMap<String, Object>();
		List<Object> arguments= new ArrayList<Object>();
		Map<String, GenerationArgumentDescriptor> descriptors= new HashMap<String, GenerationArgumentDescriptor>();
		prepareArguments(descriptorMap, descriptors, arguments, args);
		
		List<Annotation> annotationsList= new ArrayList<Annotation>();
		List<Class<?>> parameterTypesList = new ArrayList<Class<?>>();
		List<Field> retrievedFields= new ArrayList<Field>();
		
		for(int index=0; index<fields.length; index++){
			Field field= fields[index];
			Annotation[] fieldAnnotation = field.getAnnotations();
			if(fieldAnnotation.length==0){
				continue;
			}
			retrievedFields.add(field);
			annotationsList.add(fieldAnnotation[0]);
			parameterTypesList.add(field.getType());
		}
		
		Annotation[] annotations= new Annotation[annotationsList.size()];
		Class<?>[] parameterTypes= new Class<?>[parameterTypesList.size()];
		for(int index=0; index<annotations.length; index++){
			annotations[index]= annotationsList.get(index);
			parameterTypes[index]= parameterTypesList.get(index);
		}
		
		List<FieldDescriptor> fieldsDescriptors= new ArrayList<FieldDescriptor>();
		
		Object[] parameters = getParameters(element, null, typeCheck, annotations, parameterTypes, descriptorMap, descriptors, arguments, null, args);
		for(int index=0; index<parameters.length; index++){
			fieldsDescriptors.add(new FieldDescriptor(retrievedFields.get(index), parameters[index]));
		}
		return fieldsDescriptors;
	}

	protected static void prepareArguments(Map<String, Object> descriptorMap,
			Map<String, GenerationArgumentDescriptor> descriptors, List<Object> arguments, Object... args) {
		for(Object object: ArgumentsRetrieval.asListArguments(false, args)){
			if(object instanceof GenerationArgumentDescriptor){
				GenerationArgumentDescriptor descriptor= (GenerationArgumentDescriptor) object;
				String id = descriptor.id();
				descriptorMap.put(id, descriptor.value());
				descriptors.put(id, descriptor);
			}else{
				arguments.add(object);
			}
		}
	}
	
	public class FieldDescriptor{
		public Field fField;
		public Object fValue;
		
		public FieldDescriptor(Field field, Object value) {
			this.fField= field;
			this.fValue= value;
		}
	}
	
	public static Object[] getParameters(Object element, GenerationPolicyRegistry registry, Method fMethod, Object... args) {
		return getParametersValues(element, registry, null, fMethod, false, null, args);
	}
	
	public static Object[] getParametersValues(Object element, GenerationPolicyRegistry registry, String currentString, Method method, boolean typeCheck, Object watchingObject, Object... args) {
		Map<String, Object> descriptorMap= new HashMap<String, Object>();
		Map<String, GenerationArgumentDescriptor> descriptors= new HashMap<String, GenerationArgumentDescriptor>();
		List<Object> arguments= new ArrayList<Object>();
		GenerationPolicyRegistry.prepareArguments(descriptorMap, descriptors, arguments, args);
		
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		
		Annotation[] annotations= new Annotation[parameterAnnotations.length];
		for(int index=0; index<parameterAnnotations.length; index++){
			Annotation[] annotation= parameterAnnotations[index];
			annotations[index]= annotation.length==0?null: annotation[0];
		}
		
		Class<?>[] parameterTypes = method.getParameterTypes();
		
		return registry.getParameters(element, currentString, typeCheck, annotations, parameterTypes, descriptorMap, descriptors, arguments,watchingObject, args);
	}

	private Object[] getParameters(Object element, String currentString, boolean typeCheck, Annotation[] annotations,
			Class<?>[] parameterTypes, Map<String, Object> descriptorMap, Map<String, GenerationArgumentDescriptor> descriptors, 
			List<Object> arguments, Object watchingObject, Object... args) {
		TreeMap<String, Object> values = getPathMap(element);
		
		int length = annotations.length;
		Object[] parameters= new Object[length];
		
		int objectsSetArguments=0;
		
		int argsIndex=0;
		boolean checkArgumentIndex= false;
		for(int index=0; index< annotations.length; index++){
			
			Annotation annotation = annotations[index];
			
			Class<?> classType = parameterTypes[index];
			
			if(annotation==null && !arguments.isEmpty()){
				Object object = arguments.get(argsIndex);
				
				if(typeCheck){
					if(object== null){
						if(isTheSamePrimitiveType(classType, "boolean", Boolean.class.getCanonicalName())){
							object= Boolean.FALSE;
						}else if(isTheSamePrimitiveType(classType, "int", Integer.class.getCanonicalName())){
							object= Integer.valueOf(0);
						}else if(isTheSamePrimitiveType(classType, "float", Float.class.getCanonicalName())){
							object= Float.valueOf(0);
						}else if(isTheSamePrimitiveType(classType, "double", Double.class.getCanonicalName())){
							object= Double.valueOf(0);
						}
						parameters[index]= object;
					}else{
						Class<?> objectType = object.getClass();
						if(classType.isInstance(object)|| isTheSamePrimitiveType(objectType, "boolean", Boolean.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "int", Integer.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "float", Float.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "double", Double.class.getCanonicalName())){
							parameters[index]= object;
						}else{
							return null;
						}
					}
					
				}
				
				argsIndex++;
				continue;
			}
			
			if(annotation instanceof GenerationBaseElement){
				if(typeCheck&& !classType.isInstance(element)){
					return null;
				}
				parameters[index]= element;
			}else if(annotation instanceof WatchedObjectValue){
				parameters[index]= watchingObject;
			}else if(annotation instanceof GenerationProcedureParameter){
				String canonicalName = classType.getCanonicalName();
				if("int".equals(canonicalName)||Integer.class.getCanonicalName().equals(canonicalName)){
					parameters[index]= this.generationPointInteger(element, ((GenerationProcedureParameter)annotation).id(), args);
				}else if(List.class.getCanonicalName().equals(canonicalName)){
					parameters[index]= this.generationPointList(element, ((GenerationProcedureParameter)annotation).id(), args);
				}else{
					parameters[index]= this.generationPointString(element, ((GenerationProcedureParameter)annotation).id(), args);
				}
			}else if(annotation instanceof GenerationLoopElement){
				if(values== null){
					parameters[index]= null;
				}else{
					GenerationLoopElement generationLoopElement= (GenerationLoopElement) annotation;
					find: {
						String[] ids = generationLoopElement.id();
						if(ids.length==0){
							parameters[index]= values.get(CommonConstants.BLANK);
							break find;
						}
						for(String id:ids){
							Object object = values.get(id);
							if(object!= null){
								parameters[index]= object;
								break;
							}
						}
					}
				}
			}else if(annotation instanceof GenerationLoopPath){
				if(values== null){
					parameters[index]= new TreeMap<String, Object>();
				}else{
					parameters[index]= values;
				}
			}else if(annotation instanceof GenerationArguments){
				parameters[index]= args;
			}else if(annotation instanceof GenerationElementParameter){
				GenerationElementParameter generationElementParameter = (GenerationElementParameter)annotation;
				
				String canonicalName = classType.getCanonicalName();
				if(canonicalName.equals("boolean")){
					parameters[index]= Boolean.valueOf(this.getBoolean(element, generationElementParameter.id(), args));
				}else if(canonicalName.equals("int")){
					parameters[index]= Integer.valueOf(this.getInt(element, generationElementParameter.id(), args));
				}else{
					parameters[index]= this.getObject(element, generationElementParameter.id(), args);
				}
			}else if(annotation instanceof GenerationRegistry){
				parameters[index]= this;
			}else if(annotation instanceof GenerationStringSegment){
				parameters[index]= currentString;
			}else if(annotation instanceof GenerationArgument){
				GenerationArgument generationArgument= (GenerationArgument) annotation;
				String id = generationArgument.id();
				if(!id.isEmpty()){
					Object object = generationArgument.wrapped()? descriptors.get(id): descriptorMap.get(id);
					Object reply = object;
					
					String canonicalName = classType.getCanonicalName();
					if("boolean".equals(canonicalName)|| Boolean.class.getClass().equals(canonicalName)){
						parameters[index]= reply instanceof Boolean? reply: Boolean.FALSE;
					}else if("int".equals(canonicalName)|| Integer.class.getClass().equals(canonicalName)){
						parameters[index]= reply instanceof Boolean? reply: Integer.valueOf(0);
					}else if(canonicalName.equals(String.class.getCanonicalName())){
						parameters[index]= reply!=null? String.valueOf(reply): null;
					}else{
						parameters[index]= reply;
					}
				}else{
					Object object = arguments.size()>objectsSetArguments?arguments.get(objectsSetArguments): null;
					if(object!= null){
						Class<?> objectType = object.getClass();
						if(classType.isInstance(object)|| isTheSamePrimitiveType(objectType, "boolean", Boolean.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "int", Integer.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "float", Float.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "double", Double.class.getCanonicalName())){
							
							parameters[index]= object;
							objectsSetArguments++;
						}
					}
					checkArgumentIndex= true;
				}
			}
			
			Object object = parameters[index];
			if(object== null){
				String canonicalName = classType.getCanonicalName();
				if("boolean".equals(canonicalName)|| Boolean.class.getClass().equals(canonicalName)){
					parameters[index]= Boolean.FALSE;
				}else if("int".equals(canonicalName)|| Integer.class.getClass().equals(canonicalName)){
					parameters[index]= Integer.valueOf(0);
				}else if(canonicalName.equals(String.class.getCanonicalName())){
					Annotation current = annotations[index];
					if(current instanceof GenerationArgument&& ((GenerationArgument)current).adjust()){
						parameters[index]= CommonConstants.BLANK;
					}
				}
				
				if(checkArgumentIndex){
					objectsSetArguments++;
					checkArgumentIndex= false;
				}
			}
		}
		
		return parameters;
	}

	public TreeMap<String, Object> getPathMap(Object element) {
		TreeMap<String, Object> treeMap = this.objectsPathMap.get(element);
		if(treeMap!= null){
			return treeMap;
		}
		
		Object object = this.relatedObjects.get(element);
		if(object== null){
			return null;
		}
		
		return this.objectsPathMap.get(object);
	}
	
	public Object loopElement(Object element, String[] ids){
		TreeMap<String, Object> values = getPathMap(element);
		for(String id:ids){
			Object object = values.get(id);
			if(object!= null){
				return object;
			}
		}
		
		return null;
	}

	private static boolean isTheSamePrimitiveType(Class<?> classType, String type, String perspectiveCanonicalName) {
		return classType.getCanonicalName().equals(type)|| classType.getCanonicalName().equals(perspectiveCanonicalName);
	}
	
	
	
	private class LoopObject{
		protected Method fMethod;
		protected Object fInstance;
		protected GenerationLoopAnnotation fGenerationLoopAnnotation;
		
		public LoopObject(Method method, Object instance, GenerationLoopAnnotation generationLoopAnnotation) {
			this.fMethod= method;
			this.fInstance= instance;
			this.fGenerationLoopAnnotation= generationLoopAnnotation;
		}
	}
	
	private class LoopProcessorObject{
		protected Method fMethod;
		protected Object fInstance;
		protected LoopProcessorAnnotation fLoopProcessorAnnotation;
		protected LoopProcessorAnnotations fLoopProcessorAnnotations;
		
		public LoopProcessorObject(Method method, Object instance, LoopProcessorAnnotation loopProcessorAnnotation, LoopProcessorAnnotations loopProcessorAnnotations) {
			this.fMethod= method;
			this.fInstance= instance;
			this.fLoopProcessorAnnotation= loopProcessorAnnotation;
			this.fLoopProcessorAnnotations= loopProcessorAnnotations;
		}
	}
	
	public void addUniqueValue(String id, Object values, Object... element){
		addValue(id, values, true, element);
	}
	
	private ArgumentsRetrieval argumentRetriever= new ArgumentsRetrieval();
	public Generator generator;
	public Object rootElement;
	
	public void addList(String id, Object values, boolean unique, Object... element){
		if(values instanceof Collection<?> == false){
			return;
		}
		for(Object value: (Collection<?>)values){
			this.addValue(id, value, unique, element);
		}
	}
	
	public void addValue(String id, Object values, Object... element){
		this.addValue(id, values, false, element);
	}
	
	public void removeValue(String id, Object values, Object... element) {
		this.argumentRetriever.removeValue(id, values, element);
	}

	private void addValue(String id, Object values, boolean unique, Object... element) {
		this.argumentRetriever.setValue(id, unique, values, element);
	}
	
	public Object getValue(String id, Object... element){
		List<Object> value = this.argumentRetriever.getValue(id, element);
		if(value.isEmpty()){
			return null;
		}
		return value.get(0);
	}
	
	public List<Object> getValues(String id, Object... element){
		return this.argumentRetriever.getValue(id, element);
	}
	
	public List<Object> getAllValues(String id, Object... element){
		return this.argumentRetriever.getAllValues(id, element);
	}
	
	public List<Object> getById(String id){
		return this.argumentRetriever.getById(id);
	}
	
	/******************Delegations****************************************/
	@Override
	public String generate(String id, Object element, Object... arguments) {
		return this.generationTemplateDelegator.generate(id, element, arguments);
	}
	
	@Override
	public boolean getBoolean(Object classObject, String fieldName, Object... arguments) {
		if(classObject instanceof Map){
			Object object = this.relatedObjects.get(classObject);
			if(object!= null){
				return getBoolean(object, fieldName, arguments);
			}
			
			object = ((Map<?, ?>)classObject).get(fieldName);
			if(object!= null){
				if(object instanceof Boolean){
					return ((Boolean)object).booleanValue();
				}
				return false;
			}
		}
		
		boolean value = this.generationValueGetter.getBoolean(classObject, fieldName, arguments);
		return value;
	}

	@Override
	public Object getObject(Object classObject, String fieldName, Object... arguments) {
		List<Object> value = this.interceptedObjectsRetriever.getValue(fieldName, classObject, arguments);
		if(!value.isEmpty()){
			return value.get(0);
		}
		
		Object object = this.generationValueGetter.getObject(classObject, fieldName, arguments);
		
		this.interceptedObjectsRetriever.setValue(fieldName, object, true, classObject, arguments);
		return object;
	}

	@Override
	public int getInt(Object classObject, String fieldName, Object... arguments) {
		List<Object> value = this.interceptedObjectsRetriever.getValue(fieldName, classObject, arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof Integer){
				return ((Integer)object).intValue();
			}
			return 0;
		}
		
		if(classObject instanceof Map){
			Object object = this.relatedObjects.get(classObject);
			if(object!= null){
				return getInt(object, fieldName, arguments);
			}
			
			object = ((Map<?, ?>)classObject).get(fieldName);
			if(object!= null){
				if(object instanceof Integer){
					return ((Integer)object).intValue();
				}
				return 0;
			}
		}
		
		int intValue = this.generationValueGetter.getInt(classObject, fieldName, arguments);
		
		this.interceptedObjectsRetriever.setValue(fieldName, Integer.valueOf(intValue), true, classObject, arguments);
		return intValue;
	}

	@Override
	public String getString(Object classObject, String fieldName, Object... arguments) {
		return getString(classObject, false, fieldName, arguments);
	}
	
	public String getString(Object classObject, boolean ignoreInterception, String fieldName, Object... arguments) {
		List<Object> value = this.interceptedObjectsRetriever.getValue(fieldName, classObject, Boolean.valueOf(ignoreInterception), arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof String){
				return (String) object;
			}
			return null;
		}
		
		Object relatedObject = this.relatedObjects.get(classObject);
		
		if(classObject instanceof Map){
			
			if(relatedObject!= null){
				return getString(relatedObject, fieldName, arguments);
			}
			
			Object object = ((Map<?, ?>)classObject).get(fieldName);
			if(object!= null){
				return object.toString();
			}
		}
		
		String stringValue = this.generationValueGetter.getString(classObject, fieldName, arguments);
		
		if(stringValue== null&& relatedObject!= null){
			stringValue= getString(relatedObject, fieldName, arguments);
		}
		
		this.interceptedObjectsRetriever.setValue(fieldName, stringValue, true, classObject, Boolean.valueOf(ignoreInterception), arguments);
		return stringValue;
	}

	@Override
	public List<?> getList(Object classObject, String fieldName,
			Object... arguments) {
		return this.generationValueGetter.getList(classObject, fieldName, arguments);
	}
	
	private class GenerationPointObject{
		protected Method fMethod;
		protected GenerationPoint fGenerationPoint;
		protected Object fInstance;
		
		public GenerationPointObject(Method method, GenerationPoint generationPoint, Object instance) {
			this.fMethod= method;
			this.fGenerationPoint= generationPoint;
			this.fInstance= instance;
		}
		
		public Object invoke(Object element, GenerationPolicyRegistry registry, String currentString, Object watchingObject, Object... arguments){
			try {
				String[] generationPoints = this.fGenerationPoint.generationPoint();
				
				List<Object> invokes= new ArrayList<Object>();
				
				for(String generationPoint: generationPoints){
					List<Object> value = registry.generationObjectsRetriever.getValue(generationPoint, 
							element, this.fMethod, arguments, watchingObject);
					if(!value.isEmpty()){
						return value.get(0);
					}
					
					//TODO: caching
					Object[] parameters = GenerationPolicyRegistry.getParametersValues(element, registry, currentString, this.fMethod, false, watchingObject, arguments);
					Object invoke = this.fMethod.invoke(this.fInstance, parameters);
					registry.generationObjectsRetriever.setValue(generationPoint, invoke, true, element, this.fMethod, arguments, watchingObject);
					
					invokes.add(invoke);
				}
				
				return invokes.size()==1? invokes.get(0): invokes;
			} catch (Exception e) {
				registry.generationLogger.addError(e);
				return null;
			}
		}

		public boolean unique(){
			return this.fGenerationPoint.unique();
		}
	}

	@Override
	public GenerationLogger getGenerationLogger() {
		return this.generationLogger;
	}
	
	private static class GenerationPointObjectsComparator implements Comparator<GenerationPointObject> {
		
		Map<String, List<String>> fPathMap= new HashMap<String, List<String>>();
		
		public GenerationPointObjectsComparator() {
			for(String group: groupDefnitions.keySet()){
				List<String> path= new ArrayList<String>();
				GenerationGroupDefinition generationGroupDefinition = groupDefnitions.get(group);
				
				String after= generationGroupDefinition.after();
				while(!after.isEmpty()){
					path.add(after);
					after= groupDefnitions.get(after).after();
				}
				Collections.reverse(path);
				this.fPathMap.put(group, path);
				//orderGroups.addGroup(group, generationGroupDefinition);
			}
		}

		@Override
		public int compare(GenerationPointObject point1, GenerationPointObject point2) {
			Map<String, List<String>> temp= this.fPathMap;
			GenerationPoint annotation1= point1.fGenerationPoint;
			GenerationPoint annotation2 = point2.fGenerationPoint;
			
			String group1 = annotation1.group();
			List<String> group1Path = temp.get(group1);
			String group2 = annotation2.group();
			List<String> group2Path = temp.get(group2);
			
			checkGroup: {
				if(group1Path!=null&& group1Path.equals(group2Path)&& group1.equals(group2)){
					break checkGroup; 
				}
				int group1Priority = GenerationPolicyRegistry.groupDefnitions.get(group1).priority();
				int group2Priority = GenerationPolicyRegistry.groupDefnitions.get(group2).priority();
				
				for(String segment: group1Path){
					int priority = GenerationPolicyRegistry.groupDefnitions.get(segment).priority();
					if(priority<group1Priority){
						group1Priority= priority;
					}
				}
				
				for(String segment: group2Path){
					int priority = GenerationPolicyRegistry.groupDefnitions.get(segment).priority();
					if(priority<group2Priority){
						group2Priority= priority;
					}
				}
				
				int size1 = group1Path.size();
				int size2 = group2Path.size();
				if(group1Priority== group2Priority&& size1!= size2){
					if(size1>size2){
						return 1;
					}
					return -1;
				}
				
				int comparePriorities = comparePriorities(group1Priority, group2Priority);
				if(comparePriorities!=0){
					return comparePriorities;
				}
			}
			
			
			
			int priority1 = annotation1.priority();
			int priority2 = annotation2.priority();
			
			
			return comparePriorities(priority1, priority2);
		}

		private static int comparePriorities(int priority1, int priority2) {
			if(priority1== priority2){
				return 0;
			}
			
			return priority1< priority2? 1:-1;
		}
	}

	
}