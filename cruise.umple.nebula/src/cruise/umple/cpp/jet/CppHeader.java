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

package cruise.umple.cpp.jet;

import cruise.umple.core.*;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.cpp.CppGenerationTemplate;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.cpp.ICppDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppHandlerDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppMethods;

import cruise.umple.modeling.*;

@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppHeader extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppHeader create(String lineSeparator)
  {
    nl = lineSeparator;
    CppHeader result = new CppHeader();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#ifndef ";
  protected final String TEXT_2 = "_H" + NL + "#define ";
  protected final String TEXT_3 = "_H" + NL + "" + NL + "#ifdef PRAGMA" + NL + "#pragma once" + NL + "#ifndef _MSC_VER" + NL + "#pragma interface \"";
  protected final String TEXT_4 = ".h\"" + NL + "#endif" + NL + "#endif";
  protected final String TEXT_5 = " {" + NL + "\t";
  protected final String TEXT_6 = NL + "};";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + NL + "//------------------------" + NL + "// GNU HASH FUNCTION USE" + NL + "//------------------------" + NL + "#ifdef __GNUC__" + NL + "#include <ext/hash_map>" + NL + "namespace __gnu_cxx{" + NL + "template<> struct hash<";
  protected final String TEXT_9 = "*>{" + NL + "    size_t operator()(";
  protected final String TEXT_10 = "* ptr ) const {" + NL + "        return ptr->hashCode();" + NL + "    }" + NL + "};" + NL + "}" + NL + "#endif" + NL + "" + NL + "#endif";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "//------------------------" + NL + "// GLOBAL DECLARATIONS" + NL + "//------------------------";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = "#ifndef ";
  protected final String TEXT_17 = NL + "#define ";
  protected final String TEXT_18 = NL + NL + "#if defined(WIN32) || defined(_WIN32) || defined(__WIN32__) || defined(__NT__) || defined(_WIN64)" + NL + "#define WINDOWS_OS" + NL + "// NO PREPROCESSOR DEFINITION FOR PRAGMA" + NL + "#if _MSC_VER" + NL + "#define PRAGMA" + NL + "#pragma warning( disable : 4290 )" + NL + "#endif" + NL + "#elif defined(hpux) || defined(__hpux) || defined(__hpux__)" + NL + "#define HPUX_OS" + NL + "#elif defined(__APPLE__) || defined(macintosh)" + NL + "#define MAC_OS" + NL + "#elif defined(bsdi) || defined(__bsdi__)" + NL + "#define BSD_OS" + NL + "#endif" + NL + "" + NL + "#ifdef PRAGMA" + NL + "#pragma once" + NL + "#ifdef _MSC_VER";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "#else" + NL + "#pragma interface \"";
  protected final String TEXT_21 = ".h\"" + NL + "#endif" + NL + "#endif" + NL + "" + NL + "//------------------------" + NL + "// PACKAGE FILES DECLARATION" + NL + "//------------------------";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL + "#include <vector>" + NL + "#include <algorithm>" + NL + "#include <iostream>" + NL + "#include <string>" + NL + "#include <exception>" + NL + "#include <stdexcept>" + NL + "#include <cassert>" + NL + "" + NL + "#ifdef WINDOWS_OS" + NL + "#include <windows.h>" + NL + "#include <process.h>" + NL + "#else" + NL + "#include <errno.h>" + NL + "#include <pthread.h>" + NL + "#include <unistd.h>" + NL + "#endif" + NL + "" + NL + "#ifdef HPUX_OS" + NL + "#include <sys/pstat.h>" + NL + "#elif  MAC_OS" + NL + "#undef DEBUG" + NL + "#include <CoreServices/CoreServices.h>" + NL + "#elif BSD_OS" + NL + "#include <mach/mach_types.h>" + NL + "#include <sys/systm.h>" + NL + "#include <sys/types.h>" + NL + "#include <sys/sysctl.h>" + NL + "#endif";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "using namespace std;";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "/// is_pointer" + NL + "template <typename T> struct remove_const_type { typedef T type; };" + NL + "template <typename T> struct remove_const_type<const T> { typedef T type; };" + NL + "template <typename T> struct remove_volatile_type { typedef T type; };" + NL + "template <typename T> struct remove_volatile_type<volatile T> { typedef T type; };" + NL + "template <typename T> struct removeType : remove_const_type<typename remove_volatile_type<T>::type> {};" + NL + "template <typename T> struct is_ptr_type { enum { value = false }; };" + NL + "template <typename T> struct is_ptr_type<T*> { enum { value = true }; };" + NL + "template <typename T> struct is_ptr : is_ptr_type<typename removeType<T>::type> {};" + NL + "" + NL + "" + NL + "struct ThreadException : public std::exception{" + NL + "   std::string s;" + NL + "   ThreadException(std::string ss) : s(ss) {}" + NL + "   ~ThreadException() throw() {}" + NL + "   const char* what() const throw() { return s.c_str(); }" + NL + "};" + NL + "" + NL + "template<class T>" + NL + "struct Runnable {" + NL + "\tvirtual void run( void (T::*RunnableCall)() ) = 0;" + NL + "};" + NL + "" + NL + "class AtomicMutex {" + NL + "public:" + NL + "    AtomicMutex() { }" + NL + "    ~AtomicMutex() {  }" + NL + "    void lock() {  }" + NL + "    void unlock() { }" + NL + "};" + NL + "" + NL + "class MutexLock{" + NL + "public:" + NL + "    MutexLock() {}" + NL + "    ~MutexLock() {}" + NL + "" + NL + "    void wait() {}" + NL + "    void wakeUp() {}" + NL + "" + NL + "    void lock() {}" + NL + "" + NL + "    bool isLocked(int set = 0) { return false; }" + NL + "" + NL + "    void unlock() {}" + NL + "};" + NL + "" + NL + "#define synchronized(L)                                               \t\\" + NL + "        if(false){}                                                   \t\\" + NL + "        else {                                                        \t\\" + NL + "\t\tMutexLock mlock(L)                                         \t\t\t\\" + NL + "\t\tmlock.lock()\t\t\t \t\t      \t\t\t\t\t\t\t\\" + NL + "        for(;mlock.isLocked();\t\t\t\t              \t\t\t\t\\" + NL + "              mlock.unlock() )" + NL + "" + NL + "" + NL + "template<class T>" + NL + "class Thread: public Runnable<T> {" + NL + "public:" + NL + "\tThread(std::string name) {}" + NL + "\tThread(Runnable<T> *runnable) {}" + NL + "\tvirtual ~Thread() {}" + NL + "\tvirtual void run( void (T::*RunnableCall)() ) {}" + NL + "\tvirtual void stop() {}" + NL + "\tvirtual void start() throw(ThreadException) {}" + NL + "\tvoid join() throw(ThreadException) {}" + NL + "};";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL + "//------------------------" + NL + "// PREDEFINED TYPES" + NL + "//------------------------";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "#endif";
  protected final String TEXT_32 = "//------------------------" + NL + "// PREDEFINED OPERATORS" + NL + "//------------------------" + NL + "friend bool operator== (";
  protected final String TEXT_33 = " &Right, ";
  protected final String TEXT_34 = " &Left);" + NL + "" + NL + "friend bool operator!= (";
  protected final String TEXT_35 = " &Right, ";
  protected final String TEXT_36 = " &Left) {" + NL + "\treturn !( Right == Left);" + NL + "}" + NL + "" + NL + "bool operator == (const ";
  protected final String TEXT_37 = " &Right) const {" + NL + "\treturn this == &Right; " + NL + "}" + NL + "" + NL + "bool operator != (const ";
  protected final String TEXT_38 = " &Right) const {" + NL + "\treturn this != &Right;" + NL + "}" + NL;
  protected final String TEXT_39 = NL + "#define ";
  protected final String TEXT_40 = "_BODY" + NL + "" + NL + "#if defined( PRAGMA ) && ! defined( PRAGMA_IMPLEMENTED )" + NL + "#pragma implementation <";
  protected final String TEXT_41 = ".h>" + NL + "#endif";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = ";";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = NL;
  protected final String TEXT_48 = NL + "int main(int argc,  char *argv[]){" + NL + "\treturn 0;" + NL + "}" + NL;
  protected final String TEXT_49 = NL + "#ifndef TIME_AND_DATE_DEFINITION" + NL + "#define TIME_AND_DATE_DEFINITION" + NL + "namespace { " + NL + "// Ported strptime from BSD" + NL + "#ifdef WINDOWS_OS" + NL + "" + NL + "const char* Days[] = {" + NL + "        \"Sunday\", \"Monday\", \"Tuesday\", \"Wednesday\"," + NL + "        \"Thursday\", \"Friday\", \"Saturday\"" + NL + "};" + NL + "" + NL + "const char* DaySymbols[] = {\"Sun\", \"Mon\", \"Tue\", \"Wed\",\"Thu\", \"Fri\", \"Sat\"};" + NL + "" + NL + "const char* Monthes[] = {\"January\", \"February\", \"March\", \"April\", \"May\", \"June\"," + NL + "\t\t\t\t\t\"July\", \"August\", \"September\", \"October\", \"November\", \"December\" };" + NL + "" + NL + "const char* MonthSymbols[] = { \"Jan\", \"Feb\", \"Mar\", \"Apr\", \"May\", \"Jun\"," + NL + "\t\t\t\t\t\t\t\t   \"Jul\", \"Aug\", \"Sep\", \"Oct\", \"Nov\", \"Dec\" };" + NL + "" + NL + "const char* parseNumber(const char* s, int low, int high, int* value) {" + NL + "        const char* p = s;" + NL + "        for (*value = 0; *p != NULL && isdigit(*p); ++p) {" + NL + "                *value = (*value) * 10 + static_cast<int>(*p) - static_cast<int>('0');" + NL + "        }" + NL + "        if (p == s || *value < low || *value > high) return NULL;" + NL + "        return p;" + NL + "}" + NL + "" + NL + "char* strptime(const char *s, const char *format, struct tm *tm) {" + NL + "        while (*format != NULL && *s != NULL) {" + NL + "                if (*format != '%') {" + NL + "                        if (*s != *format) return NULL;" + NL + "                        ++format;" + NL + "                        ++s;" + NL + "                        continue;" + NL + "                }" + NL + "                ++format;" + NL + "                int len = 0;" + NL + "                switch (*format) {" + NL + "          case 'a':" + NL + "          case 'A':" + NL + "                  tm->tm_wday = -1;" + NL + "                  for (int i = 0; i < 7; ++i) {" + NL + "                          len = static_cast<int>(strlen(DaySymbols[i]));" + NL + "                          if (_strnicmp(DaySymbols[i], s, len) == 0) {" + NL + "                                  tm->tm_wday = i;" + NL + "                                  break;" + NL + "                          }" + NL + "                          len = static_cast<int>(strlen(Days[i]));" + NL + "                          if (_strnicmp(Days[i], s, len) == 0) {" + NL + "                                  tm->tm_wday = i;" + NL + "                                  break;" + NL + "                          }" + NL + "                  }" + NL + "                  if (tm->tm_wday == -1) return NULL;" + NL + "                  s += len;" + NL + "                  break;" + NL + "          case 'b':" + NL + "          case 'B':" + NL + "          case 'h':" + NL + "                  tm->tm_mon = -1;" + NL + "                  for (int i = 0; i < 12; ++i) {" + NL + "                          len = static_cast<int>(strlen(MonthSymbols[i]));" + NL + "                          if (_strnicmp(MonthSymbols[i], s, len) == 0) {" + NL + "                                  tm->tm_mon = i;" + NL + "                                  break;" + NL + "                          }" + NL + "                          len = static_cast<int>(strlen(Monthes[i]));" + NL + "                          if (_strnicmp(Monthes[i], s, len) == 0) {" + NL + "                                  tm->tm_mon = i;" + NL + "                                  break;" + NL + "                          }" + NL + "                  }" + NL + "                  if (tm->tm_mon == -1) return NULL;" + NL + "                  s += len;" + NL + "                  break;" + NL + "          case 'm':" + NL + "                  s = parseNumber(s, 1, 12, &tm->tm_mon);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  --tm->tm_mon;" + NL + "                  break;" + NL + "          case 'd':" + NL + "          case 'e':" + NL + "                  s = parseNumber(s, 1, 31, &tm->tm_mday);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  break;" + NL + "          case 'H':" + NL + "                  s = parseNumber(s, 0, 23, &tm->tm_hour);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  break;" + NL + "          case 'M':" + NL + "                  s = parseNumber(s, 0, 59, &tm->tm_min);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  break;" + NL + "          case 'S':" + NL + "                  s = parseNumber(s, 0, 60, &tm->tm_sec);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  break;" + NL + "          case 'Y':" + NL + "                  s = parseNumber(s, 1900, 9999, &tm->tm_year);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  tm->tm_year -= 1900;" + NL + "                  break;" + NL + "          case 'y':" + NL + "                  s = parseNumber(s, 0, 99, &tm->tm_year);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  if (tm->tm_year <= 68) {" + NL + "                          tm->tm_year += 100;" + NL + "                  }" + NL + "                  break;" + NL + "          case 't':" + NL + "          case 'n':" + NL + "                  while (isspace(*s)) ++s;" + NL + "                  break;" + NL + "          case '%':" + NL + "                  if (*s != '%') return NULL;" + NL + "                  ++s;" + NL + "                  break;" + NL + "          default:" + NL + "                  return NULL;" + NL + "                }" + NL + "                ++format;" + NL + "        }" + NL + "" + NL + "        if (*format != NULL) {return NULL;} " + NL + "\t\telse {return const_cast<char*>(s);}" + NL + "}" + NL + "#endif" + NL + "" + NL + "tm* ParseDate(string buf) {" + NL + "\ttime_t t(time(NULL)); \t" + NL + "\ttm* pDate = new tm(*localtime(&t));" + NL + "\tchar* ret = strptime(buf.c_str(), \"%d-%m-%Y\", pDate);" + NL + "\tassert(ret != NULL);" + NL + "\treturn pDate;" + NL + "};" + NL + "" + NL + "time_t* ParseTime(string buf) {" + NL + "\ttm tm;" + NL + "\ttime_t* pTime;" + NL + "\tchar* ret = strptime(buf.c_str(), \"%H:%M:%S\", &tm);" + NL + "\tassert(ret != NULL);\t" + NL + "\tpTime = new time_t(mktime(&tm));" + NL + "\treturn pTime;" + NL + "};" + NL + "}" + NL + "#endif" + NL;
  protected final String TEXT_50 = "#include <time.h>" + NL + "#include <ctype.h>";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppDefinitions.HEADER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationProcedureParameter(id = ICppDefinitions.NAMESPACE_OPENING) String namespaceOpening;
	@GenerationProcedureParameter(id = ICppDefinitions.NAMESPACE_CLOSING) String namespaceClosing;	
	@GenerationProcedureParameter(id = IModelingConstants.COPY_RIGHT) String copyRight;
	@GenerationProcedureParameter(id = ICppHandlerDefinitions.PRE_PROCESSING_DEFINITION_NAME) String definitionFullPath;
	@GenerationProcedureParameter(id = IModelingConstants.FULL_PATH) String fullPath;
	@GenerationProcedureParameter(id = ICppHandlerDefinitions.CLASS_DECLARATIONS) String classDeclarations;
	@GenerationProcedureParameter(id = ICppHandlerDefinitions.INCLUDES) String includes;
	@GenerationProcedureParameter(id = ICppMethods.CLASS_INLINE_DECLARATIONS) String inlineDeclarations;
	@GenerationProcedureParameter(id = ICppDefinitions.INCOMPLETE_TYPES_DEFNITION) String incompleteTypes;
	@GenerationProcedureParameter(id = ICppDefinitions.CLASS_GLOBAL) String global;
	@GenerationProcedureParameter(id = ICppDefinitions.VISIBILITY_BASED_CONTENTS) String visibilityBasedContents;
	@GenerationProcedureParameter(id = ICppDefinitions.PACKAGE_VISIBILITY_CONTENTS) String packageContents;
	@GenerationProcedureParameter(id = IModelingConstants.MULTILINE_COMMENTS_STRING) String elementComments;
	@GenerationProcedureParameter(id = ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS) String preProcessorDefnitionUse;
	@GenerationProcedureParameter(id = ICppDefinitions.FULL_QUALIFIED_NAME) String fullQualifiedName;
			
@Override
public void execute() {


    stringBuffer.append(copyRight);
    stringBuffer.append(TEXT_1);
    stringBuffer.append( definitionFullPath );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( definitionFullPath );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(fullPath);
    stringBuffer.append(TEXT_4);
    safeSet(includes);
    safeSet(preProcessorDefnitionUse);
    safeSet(inlineDeclarations);
    stringBuffer.append(namespaceOpening);
    stringBuffer.append(incompleteTypes);
    safeSet(elementComments);
    stringBuffer.append(classDeclarations);
    stringBuffer.append(TEXT_5);
    setGlobal();
    stringBuffer.append(indent(visibilityBasedContents, 1));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(packageContents);
    stringBuffer.append(namespaceClosing);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(fullQualifiedName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fullQualifiedName);
    stringBuffer.append(TEXT_10);
    

}

private void safeSet(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_12);
    

}

private void setGlobal(){
	StringBuffer response= globalContents();
	if(response== null){
		return;
	}
	
	
    stringBuffer.append(indent(response.toString(), 1));
    
}

private StringBuffer globalContents(){

if(this.global.isEmpty()){
		return null;
}

return CodeProcedure.generate(new CodeProcedure(this.getGenerationProcedure()) {

@Override
public void execute() {


    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(global);
    stringBuffer.append(TEXT_15);
    
	
}});
}});

}

});

getRegistry().define(ICppDefinitions.PACKAGE_HEADER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationProcedureParameter(id = PACKAGE_INCLUDES) String packageIncludes;
	@GenerationProcedureParameter(id = PREDEFINED_PACKAGE_CONTENTS) String predefinedPackageContents;
	@GenerationProcedureParameter(id = PRE_PROCESSING_DEFINITION_NAME) String fullName;
	@GenerationProcedureParameter(id = CPPCommonConstants.PACKAGE_SUFFIX) String rootName;
	@GenerationProcedureParameter(id = ICppHandlerDefinitions.GLOBAL_DEFINITIONS) String globalDefinitions;
	@GenerationProcedureParameter(id = ICppDefinitions.DEFNIED_NAMESPACES_MACROS) String definedMacros;
	@GenerationProcedureParameter(id = ICppDefinitions.HELPER_CODES) String helperCodes;
	@GenerationProcedureParameter(id = ICppDefinitions.HELPER_INCLUDES) String helperIncludes;
	@GenerationProcedureParameter(id = ICppDefinitions.ALIASES) String aliases;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_16);
    stringBuffer.append( fullName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( fullName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(rootName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(packageIncludes);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(helperIncludes);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(definedMacros);
    stringBuffer.append(globalDefinitions);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(helperCodes);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(predefinedPackageContents);
    stringBuffer.append(TEXT_31);
    
}});

}});

getRegistry().define(ICppDefinitions.PRE_CLASS_DEFINED_OPERATORS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = NAME) String name;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_32);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_38);
    
}});

}});


getRegistry().define(ICppDefinitions.CLASS_BODY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationProcedureParameter(id = IModelingConstants.COPY_RIGHT) String copyRight;
	@GenerationProcedureParameter(id = ICppHandlerDefinitions.BODY_INCLUDES) String bodyIncludes;
	@GenerationProcedureParameter(id = ICppDefinitions.PUBLIC_IMPLEMENTATION) String publicImplementation;
	@GenerationProcedureParameter(id = ICppDefinitions.ATTRIBUTES_IMPLEMENTATION) String attributes;
	@GenerationProcedureParameter(id = PRE_PROCESSING_DEFINITION_NAME) String fullName;
	@GenerationProcedureParameter(id = IModelingConstants.FULL_PATH) String fullPath;
	@GenerationProcedureParameter(id = ICppDefinitions.NAMESPACE_OPENING) String namespaceOpening;
	@GenerationProcedureParameter(id = ICppDefinitions.NAMESPACE_CLOSING) String namespaceClosing;
	@GenerationProcedureParameter(id = ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS) String preProcessorDefnitionUse;
	
@Override
public void execute() {

    stringBuffer.append(copyRight);
    stringBuffer.append(TEXT_39);
    stringBuffer.append( fullName );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(fullPath);
    stringBuffer.append(TEXT_41);
    safeSet(bodyIncludes);
    safeSet(preProcessorDefnitionUse);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(namespaceOpening);
    safeSet(attributes);
    safeSet(publicImplementation);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(namespaceClosing);
    

}

private void safeSet(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_45);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_46);
    

}

});

}});

getRegistry().define(ICppDefinitions.MAIN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationProcedureParameter(id = IModelingConstants.COPY_RIGHT) String copyRight;
	@GenerationArgument String includes;
	
@Override
public void execute() {

    stringBuffer.append(copyRight);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(includes);
    stringBuffer.append(TEXT_48);
    

}

});

}});

getRegistry().define(ICppDefinitions.TIME_HELPER_CODE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_49);
    

}});

}});

getRegistry().define(ICppDefinitions.TIME_HELPER_CODE_INCLUDES, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_50);
    

}});

}});


    return stringBuffer.toString();
  }
}