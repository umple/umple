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
	String aspect() default LoopAspectConstants.DEFAULT;
	int priority() default GenerationPolicyRegistryPriorities.MEDIUM;
	String[] ifConditionIds() default {};
	String[] ifNotConditionIds() default {};
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD })
	public @interface LoopProcessorAnnotations {
		String aspect() default LoopAspectConstants.DEFAULT;
		LoopProcessorAnnotation[] loopProcessorAnnotations();
		int priority() default GenerationPolicyRegistryPriorities.MEDIUM;
		String[] ifConditionIds() default {};
		String[] ifNotConditionIds() default {};
	}
	
	public interface LoopAspectConstants{
		public static final String BEFORE= "-1"; //$NON-NLS-1$
		public static final String DEFAULT= "0"; //$NON-NLS-1$
		public static final String PRE= "1"; //$NON-NLS-1$
		public static final String AFTER= "2"; //$NON-NLS-1$
		public static final String FINALIZE= "3"; //$NON-NLS-1$
		public static final String ALL= "*"; //$NON-NLS-1$
	}
}