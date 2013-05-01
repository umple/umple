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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgumentsRetrieval{
		
		private Map<String, Map<String, List<Object>>> data= new HashMap<String, Map<String, List<Object>>>();
		
		public List<Object> getById(String id){
			Map<String, List<Object>> map = this.data.get(id);
			if(map== null){
				return new ArrayList<Object>();
			}
			List<Object> all= new ArrayList<Object>();
			for(Object key: map.keySet()){
				all.addAll(map.get(key));
			}
			return all;
		}
		
		public List<Object> getAllValues(String id, Object... elements){
			return getValue(id, true, asListArguments(elements));
		}
		
		public List<Object> getValue(String id, Object... elements){
			return getValue(id, false, asListArguments(elements));
		}
		
		private List<Object> getValue(String id, boolean all, List<Object> elements) {
			Map<String, List<Object>> map = this.data.get(id);
			if(map== null){
				return new ArrayList<Object>();
			}
			String identifier= identifier(elements);
			List<Object> list;
			if(all){
				list= new ArrayList<Object>();
				for(String key: map.keySet()){
					if(identifier.startsWith(key)){
						list.addAll(map.get(key));
					}
				}
			}else{
				list = map.get(identifier);
			}
			
			if(list== null){
				return new ArrayList<Object>();
			}
			
			return list;
		}
		
		private static List<Object> asListArguments(Object... elements) {
			List<Object> all= new ArrayList<Object>();
			for(Object obj: elements){
				if(obj!= null){
					if(obj instanceof Collection){
						List<Object> asList = Arrays.asList(obj);
						for(Object sub: asList){
							all.add(sub);
						}
						continue;
					}else if(obj.getClass().isArray()){
						Object[] array = (Object[]) obj;
						for(Object sub: array){
							all.add(sub);
						}
						continue;
					}
					
				}
				all.add(obj);
			}
			return all;
		}
		
		public void setValue(String id, Object value, boolean unique, Object... elements){
			List<Object> all = asListArguments(elements);
			setValue(id, unique, value, all);
		}
		
		public void setValue(String id, Object value, boolean unique, List<Object> elements){
			setValue(id, unique, value, elements);
		}
		
		public void setValue(String id, boolean unique, Object value, Object... elements) {
			setValue(id, unique, value, asListArguments(elements));
		}
		
		public void setValue(String id, boolean unique, Object value, List<Object> elements) {
			Map<String, List<Object>> map = this.data.get(id);
			if(map== null){
				map= new HashMap<String, List<Object>>();
				this.data.put(id, map);
			}
			
			String identifier = identifier(elements);
			
			List<Object> list = map.get(identifier);
			if(list== null){
				list= new ArrayList<Object>();
				map.put(identifier, list);
			}
			
			if(unique){
				if(!list.contains(value)){
					list.add(value);
				}
			}else{
				list.add(value);
			}
		}

		private static String identifier(List<Object> elements) {
			String identifier= CommonConstants.BLANK;
			String types= CommonConstants.BLANK;
			for(Object object: elements){
				if(object== null){
					types= types+ object;
				}else{
					types= types+ object.getClass().getName();
				}
				
				if(object instanceof String|| object instanceof Integer|| object instanceof Double|| object instanceof Boolean
						|| object instanceof Float	/*TODO: List */){
					identifier= identifier+ object;
				}else{
					identifier= identifier+ System.identityHashCode(object);
				}
				 
			}
			return identifier+ CommonConstants.UNDERSCORE+ types;
		}
	}