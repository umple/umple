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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public interface GenerationCallback {
	
	public interface IGenerationArgumentsObject{
		public IGenerationArgumentsObjectDescriptor[] getArguments();
	}
	
	public interface IGenerationArgumentsObjectDescriptor{
		public IGenerationArgumentsObject get(String handlerId);
		public List<IGenerationArgumentsObject> get();
	}
	
	public interface IGenerationArguments{
		public String id();
		public Object[] arguments();
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE })
	public @interface StubPoint{
		public String id();
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD})
	public @interface InvokePoint{
		public String id();
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD })
	public @interface GenerationCallbackCondition {
		String conditionId();
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD})
	public @interface GenerationCallbackProcedure {
		String id() default CommonConstants.BLANK;
		String ifConditionId() default CommonConstants.BLANK;
		String ifNotConditionId() default CommonConstants.BLANK;
		String[] loops() default{};
		int priority() default 0;
		boolean unique() default false;
	}
	
	public @interface GenerationCallbackProcedures {
		GenerationCallbackProcedure[] procedures();
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.LOCAL_VARIABLE, ElementType.FIELD})
	public @interface GenerationCallbackVariable {
		String id();
		String[] conditions() default {};
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE })
	public @interface GenerationElementParameter {
		String id();
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE })
	public @interface GenerationStringSegment {
		/*Empty */
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE })
	public @interface GenerationBaseElement {
		/*Empty */
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER})
	public @interface GenerationLoopElement {
		String[] id() default {};	//Means that we are looking for the root object
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER})
	public @interface GenerationLoopPath {
		/*Empty */
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE })
	public @interface GenerationArgument {
		boolean adjust() default true;
		boolean wrapped() default false;
		String id() default CommonConstants.BLANK;
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE })
	public @interface GenerationArguments {
		/*Empty */
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE })
	public @interface WatchedObjectValue {
		/*Empty */
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE })
	public @interface GenerationRegistry {
		/*Empty */
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE })
	public @interface GenerationProcedureParameter {
		String id();
	}

}