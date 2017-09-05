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

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface LoopProcessorAnnotation {
	String[] processPath() default {};
	int[] aspect() default LoopAspectConstants.DEFAULT;
	int aspectGroup() default GenerationGroupDefinition.DEFAULT_PRIORITY;
	int priority() default GenerationPolicyRegistryPriorities.MEDIUM;
	String[] ifConditionIds() default {};
	String[] ifNotConditionIds() default {};
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD })
	public @interface LoopProcessorAnnotations {
		int[] aspect() default LoopAspectConstants.DEFAULT;
		int aspectGroup() default GenerationGroupDefinition.DEFAULT_PRIORITY;
		LoopProcessorAnnotation[] loopProcessorAnnotations();
		int priority() default GenerationPolicyRegistryPriorities.MEDIUM;
		String[] ifConditionIds() default {};
		String[] ifNotConditionIds() default {};
	}
	
	public interface LoopAspectConstants{
		public static final int INITIAL= -100;
		public static final int BEFORE= -50;
		public static final int DEFAULT= 0;
		public static final int PRE= 10;
		public static final int POST= 20;
		public static final int AFTER= 30;
		public static final int FINALIZE= 40;
		public static final int TERMINATE= 50;
	}
}