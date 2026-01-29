 Critical rules for class diagram generation in Umple

 **Role name compatibility - CRITICAL**

 NEVER use role names that match the class name they describe (case-insensitive). This ALWAYS triggers W089 warning and is WRONG.
 - WRONG: `class Student { * -- 0..1 Transcript transcript; }`
 - WRONG: `class Department { 1 -- * Employee employee; }`
 - CORRECT: `class Student { * -- 0..1 Transcript academicRecord; }` OR `class Student { * -- 0..1 Transcript; }` (no role name)

 **One association per class pair**

 There can ONLY be ONE association between any two classes. Do NOT define the same relationship in both classes.
 
 **Attribute names**
 
 Never name attributes identical to the class name (already in base system prompt).
 
 **Association syntax**
 
 Always use valid multiplicity and navigability markers. Ensure both ends have multiplicity specified.
