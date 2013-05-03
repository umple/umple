/*
Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

Model for generating documentation such as the Umple user manual
See Documenter_Code.ump for the methods injected into these classes
*/

package cruise.umple.cpp.jet;

import cruise.umple.cpp.CppGenerationTemplate;

import cruise.umple.core.*;
import cruise.umple.cpp.utils.*;
import cruise.umple.core.GenerationCallback.*;
import cruise.umple.modeling.handlers.*;
import cruise.umple.modeling.handlers.cpp.*;

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
  protected final String TEXT_16 = NL + "#ifndef ";
  protected final String TEXT_17 = NL + "#define ";
  protected final String TEXT_18 = NL + NL + "#if defined(WIN32) || defined(_WIN32) || defined(__WIN32__) || defined(__NT__) || defined(_WIN64)" + NL + "#define WINDOWS_OS" + NL + "// NO PREPROCESSOR DEFINITION FOR PRAGMA" + NL + "#if _MSC_VER" + NL + "#define PRAGMA" + NL + "#pragma warning( disable : 4290 )" + NL + "#endif" + NL + "#elif defined(hpux) || defined(__hpux) || defined(__hpux__)" + NL + "#define HPUX_OS" + NL + "#elif defined(__APPLE__) || defined(macintosh)" + NL + "#define MAC_OS" + NL + "#elif defined(bsdi) || defined(__bsdi__)" + NL + "#define BSD_OS" + NL + "#endif" + NL + "" + NL + "#ifdef PRAGMA" + NL + "#pragma once" + NL + "#ifdef _MSC_VER";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "#else" + NL + "#pragma interface \"";
  protected final String TEXT_21 = ".h\"" + NL + "#endif" + NL + "#endif" + NL + "" + NL + "//------------------------" + NL + "// PACKAGE FILES DECLARATION" + NL + "//------------------------" + NL + "#ifdef WINDOWS_OS" + NL + "#include <windows.h>" + NL + "#include <process.h>" + NL + "#else" + NL + "#include <errno.h>" + NL + "#include <pthread.h>" + NL + "#include <unistd.h>" + NL + "#endif" + NL + "" + NL + "#ifdef HPUX_OS" + NL + "#include <sys/pstat.h>" + NL + "#elif  MAC_OS" + NL + "#undef DEBUG" + NL + "#include <CoreServices/CoreServices.h>" + NL + "#elif BSD_OS" + NL + "#include <mach/mach_types.h>" + NL + "#include <sys/systm.h>" + NL + "#include <sys/types.h>" + NL + "#include <sys/sysctl.h>" + NL + "#endif";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL + "/// is_pointer" + NL + "template <typename T> struct remove_const_type { typedef T type; };" + NL + "template <typename T> struct remove_const_type<const T> { typedef T type; };" + NL + "template <typename T> struct remove_volatile_type { typedef T type; };" + NL + "template <typename T> struct remove_volatile_type<volatile T> { typedef T type; };" + NL + "template <typename T> struct removeType : remove_const_type<typename remove_volatile_type<T>::type> {};" + NL + "template <typename T> struct is_ptr_type { enum { value = false }; };" + NL + "template <typename T> struct is_ptr_type<T*> { enum { value = true }; };" + NL + "template <typename T> struct is_ptr : is_ptr_type<typename removeType<T>::type> {};" + NL;
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "//------------------------" + NL + "// PREDEFINED TYPES" + NL + "//------------------------";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL + "#endif";
  protected final String TEXT_30 = "//------------------------" + NL + "// PREDEFINED OPERATORS" + NL + "//------------------------" + NL + "friend bool operator== (";
  protected final String TEXT_31 = " &Right, ";
  protected final String TEXT_32 = " &Left);" + NL + "" + NL + "friend bool operator!= (";
  protected final String TEXT_33 = " &Right, ";
  protected final String TEXT_34 = " &Left) {" + NL + "\treturn !( Right == Left);" + NL + "}" + NL + "" + NL + "bool operator == (const ";
  protected final String TEXT_35 = " &Right) const {" + NL + "\treturn this == &Right; " + NL + "}" + NL + "" + NL + "bool operator != (const ";
  protected final String TEXT_36 = " &Right) const {" + NL + "\treturn this != &Right;" + NL + "}" + NL;
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = "& operator= (";
  protected final String TEXT_39 = " &other);" + NL;
  protected final String TEXT_40 = "& ";
  protected final String TEXT_41 = "::operator= (";
  protected final String TEXT_42 = " &other){" + NL + "    deepCopy(other);" + NL + "    return *this;" + NL + "}";
  protected final String TEXT_43 = "& ";
  protected final String TEXT_44 = "::operator= (";
  protected final String TEXT_45 = " &other){" + NL + "    deepCopy(other);" + NL + "    return *this;" + NL + "}";
  protected final String TEXT_46 = "void ";
  protected final String TEXT_47 = "::deepCopy(";
  protected final String TEXT_48 = "& other){";
  protected final String TEXT_49 = NL + "}";
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL;
  protected final String TEXT_52 = "void deepCopy(";
  protected final String TEXT_53 = "& other);";
  protected final String TEXT_54 = NL + "#define ";
  protected final String TEXT_55 = "_BODY" + NL + "" + NL + "#if defined( PRAGMA ) && ! defined( PRAGMA_IMPLEMENTED )" + NL + "#pragma implementation <";
  protected final String TEXT_56 = ".h>" + NL + "#endif";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = ";";
  protected final String TEXT_59 = NL;
  protected final String TEXT_60 = NL;
  protected final String TEXT_61 = NL;
  protected final String TEXT_62 = NL;
  protected final String TEXT_63 = NL + "int main(int argc,  char *argv[]){" + NL + "\treturn 0;" + NL + "}" + NL;
  protected final String TEXT_64 = "#define PLACE_HOLDER\t\t\tint" + NL + "#define USECS_PER_MSEC\t\t\t1000" + NL + "#define MUSECS_PER_SEC\t\t\t1000" + NL + "#define USECS_PER_SEC\t\t\t1000000" + NL + "" + NL + "#ifdef WINDOWS_OS" + NL + "" + NL + "#define EVENT_TYPE\t\t\t\t\t\tHANDLE" + NL + "#define CONDITION_TYPE\t\t\t\t\tPLACE_HOLDER" + NL + "#define THREAD_TYPE\t\t\t \t\t\tHANDLE" + NL + "#define THREAD_RETURN_TYPE\t\t\t\tunsigned WINAPI" + NL + "#define THREAD_ERROR_INSTANCE(returnValue)\t((returnValue) == NULL)" + NL + "#define THREAD_ERROR_CODE(value)\t\t\tGetLastError()" + NL + "" + NL + "#define MUTEX_CRITICAL_SECTION\t\t\tCRITICAL_SECTION" + NL + "#define START_MUTEX_FUNCTION(arg) \\" + NL + "\tInitializeCriticalSection((arg))" + NL + "" + NL + "#define TERMINATE_MUTEX_FUNCTION(arg) \\" + NL + "\tDeleteCriticalSection((arg))" + NL + "" + NL + "#define LOCK_MUTEX_FUNCTION(arg) \\" + NL + "\tEnterCriticalSection((arg))" + NL + "" + NL + "#define UNLOCK_MUTEX_FUNCTION(arg) \\" + NL + "\tLeaveCriticalSection((arg))" + NL + "" + NL + "#define START_EVENT_TYPE_FUNCTION(mutex, cond) \\" + NL + "\tmutex = CreateEvent(0, FALSE, FALSE, 0)" + NL + "" + NL + "#define TERMINATE_EVENT_FUNCTION(mutex, cond) \\" + NL + "\tCloseHandle(mutex)" + NL + "" + NL + "#define WAIT_EVENT_FUNCTION(mutex, cond, wakeup) \\" + NL + "\tWaitForSingleObject(mutex, INFINITE)" + NL + "" + NL + "#define WAKEUP_EVENT_FUNCTION(mutex, cond, wakeup) \\" + NL + "\tSetEvent(mutex)" + NL + "" + NL + "#define THREAD_JOIN_FUNCTION(hdl)\t\t\t\tWaitForSingleObject(hdl, INFINITE)" + NL + "#define THREAD_SLEEP_FUNCTION(ms)\t\t\t\tSleep((ms))" + NL + "" + NL + "#define THREAD_CREATE_FUNCTION(id, funPtr, callPtr)\tid =(HANDLE)CreateThread(NULL,0,(LPTHREAD_START_ROUTINE)funPtr,callPtr,0L,NULL)" + NL + "" + NL + "#define THREAD_TERMINATE_FUNCTION(hdl)\tTerminateThread(hdl, 0)" + NL + "" + NL + "#define THREAD_CANCEL_FUNCTION(hdl)\tTerminateThread(hdl, 0)" + NL + "" + NL + "#define IS_THREAD_ALIVE_FUNCTION(hdl, isRunning)\t\\" + NL + "\tDWORD exitCode = 0;\t\t\t\t\t\t\t\t\\" + NL + "\tif(GetExitCodeThread(hdl, &exitCode)) \t\t\t\\" + NL + "\t\tisRunning = (exitCode == STILL_ACTIVE)" + NL + "" + NL + "#else" + NL + "" + NL + "#define EVENT_TYPE\t\t\t\t\t\t\tpthread_mutex_t" + NL + "#define CONDITION_TYPE\t\t\t\t\t\tpthread_cond_t cond" + NL + "" + NL + "#define THREAD_TYPE\t\t\t\t\t\t\tpthread_t" + NL + "#define THREAD_RETURN_TYPE\t\t\t\t\tvoid *" + NL + "" + NL + "#define THREAD_ERROR_INSTANCE(returnValue)\t((returnValue) == NULL)" + NL + "#define THREAD_ERROR_CODE(value)\t\t\tGetLastError()" + NL + "" + NL + "#define THREAD_ERROR_INSTANCE(returnValue)\t\t((returnValue) != 0)" + NL + "#define THREAD_ERROR_CODE(value)\t\t\t\t(value)" + NL + "" + NL + "#define MUTEX_CRITICAL_SECTION\t\t\t\t\tpthread_mutex_t;" + NL + "#define START_MUTEX_FUNCTION(arg)\t\\" + NL + "\targ = PTHREAD_MUTEX_INITIALIZER" + NL + "" + NL + "#define TERMINATE_MUTEX_FUNCTION(arg) \\" + NL + "\tpthread_mutex_destroy((arg))" + NL + "" + NL + "#define LOCK_MUTEX_FUNCTION(arg)\t\\" + NL + "\tpthread_mutex_lock((arg))" + NL + "" + NL + "#define UNLOCK_MUTEX_FUNCTION(arg) \\" + NL + "\tpthread_mutex_unlock((arg))" + NL + "" + NL + "#define START_EVENT_TYPE_FUNCTION(mutex, cond) \\" + NL + "\t pthread_mutex_init(&mutex, NULL) \\" + NL + "\t pthread_cond_init(&cond, NULL)" + NL + "" + NL + "#define TERMINATE_EVENT_FUNCTION(mutex, cond) \\" + NL + "\tpthread_cond_destroy(&cond) \\" + NL + "\tpthread_mutex_destroy(&mutex)" + NL + "" + NL + "#define WAIT_EVENT_FUNCTION(mutex, cond, wakeup)\t\\" + NL + "\tpthread_mutex_lock(&mutex)\t\t\t\t\t\t\\" + NL + "\tint err = 0\t\t\t\t\t\t\t\t\t\t\\" + NL + "\twhile (!wakeup) {\t\t\t\t\t            \\" + NL + "\t\terr = pthread_cond_wait(&cond, &mutex)\t\t\\" + NL + "\t\tif (err) {\t\t\t\t\t\t\t\t\t\\" + NL + "\t\t\tthrow ThreadException(get_error(err))   \\" + NL + "\t\t}\t\t\t\t\t\t\t\t\t\t\t\\" + NL + "\t}\t\t\t\t\t\t\t\t\t\t\t\t\\" + NL + "\twakeup = FALSE\t\t\t\t\t\t\t\t\t\\" + NL + "\tpthread_mutex_unlock(&mutex)" + NL + "" + NL + "#define WAKEUP_EVENT_FUNCTION(mutex, cond, wakeup)  \\" + NL + "\tpthread_mutex_lock(&mutex)\t\t\t\t\t\t\\" + NL + "\twakeup = TRUE\t\t\t\t\t\t\t\t\t\\" + NL + "\tpthread_cond_signal(&cond)\t\t\t\t\t\t\\" + NL + "\tpthread_mutex_unlock(&mutex)" + NL + "" + NL + "#define THREAD_JOIN_FUNCTION(id)\tpthread_join(id, NULL)" + NL + "#define THREAD_SLEEP_FUNCTION(ms) \\" + NL + "\tstruct timeval tv \\" + NL + "    tv.tv_usec = (ms % MUSECS_PER_SEC) * USECS_PER_MSEC \\" + NL + "    tv.tv_sec = ms / MUSECS_PER_SEC \\" + NL + "    select(0, NULL, NULL, NULL, &tv)" + NL + "" + NL + "#define THREAD_CREATE_FUNCTION(id, funPtr, callPtr)\t\t\t\t\\" + NL + "\tpthread_attr_t attr\t\t\t\t\t\t\t\t\t\t\t\\" + NL + "\tpthread_attr_init(&attr)\t\t\t\t\t\t\t\t\t\\" + NL + "\tpthread_attr_setdetachstate(&attr,PTHREAD_CREATE_DETACHED)\t\\" + NL + "\tpthread_attr_setinheritsched(&attr, PTHREAD_INHERIT_SCHED)\t\\" + NL + "\thdl = pthread_create(&id, &attr, funPtr, callPtr)\t\t\t\\" + NL + "\tpthread_attr_destroy(&attr)" + NL + "" + NL + "#define THREAD_TERMINATE_FUNCTION(arg)\tpthread_exit(arg)" + NL + "#define THREAD_CANCEL_FUNCTION(Id)\t\t\t\t\t\\" + NL + "\tif (pthread_cancel(Id))\t\t\t\t\t\t\t\\" + NL + "\t\tthrow ThreadException(ErrorMessage(code));" + NL + "#define IS_THREAD_ALIVE_FUNCTION(hdl, isRunning)\t\\" + NL + "\tisRunning = (phtread_kill(hdl, 0) == 0)" + NL + "" + NL + "#endif" + NL + "" + NL + "#define CREATE_THREAD(id, funPtr, callPtr)\t\t\t\t\t\t\t\t\\" + NL + "\tTHREAD_CREATE_FUNCTION(id, funPtr, callPtr);\t\t\t\t\t\t\\" + NL + "\tif(THREAD_ERROR_INSTANCE(id))\t\t\t\t\t\t\t\t\t\t\\" + NL + "\t\tthrow ThreadException(ErrorMessage(THREAD_ERROR_CODE(id)))" + NL + "" + NL + "static std::string ErrorMessage(int errorCode){" + NL + "\tstring str = \"\";" + NL + "\tif (errorCode == 0) {" + NL + "\t\treturn str;" + NL + "\t}" + NL + "" + NL + "\tchar* what = \"Error Numer\";" + NL + "\tint whlen = strlen(what);" + NL + "\tint ncode = errorCode, dlen = 1;" + NL + "\twhile (ncode !=0) {dlen++; ncode/=10;}" + NL + "\tchar *buffer = (char *) malloc(sizeof(char) * (whlen + dlen + 1));" + NL + "    sprintf(buffer, \"%s = %d\", what, errorCode);" + NL + "\tstr = buffer;" + NL + "\treturn str;" + NL + "}" + NL + "" + NL + "struct ThreadException : public std::exception{" + NL + "   std::string s;" + NL + "   ThreadException(std::string ss) : s(ss) {}" + NL + "   ~ThreadException() throw() {}" + NL + "   const char* what() const throw() { return s.c_str(); }" + NL + "};" + NL + "" + NL + "template <typename T>" + NL + "void* ConvertToFunctionPointer(T x) {" + NL + "  return *reinterpret_cast<void**>(&x);" + NL + "}" + NL + "" + NL + "struct Runnable {" + NL + "\tvirtual void run() = 0;" + NL + "};" + NL + "" + NL + "class AtomicMutex{" + NL + "  public:" + NL + "\tAtomicMutex() { START_MUTEX_FUNCTION(&section); }" + NL + "\t~AtomicMutex() { TERMINATE_MUTEX_FUNCTION(&section); }" + NL + "    void lock() { LOCK_MUTEX_FUNCTION(&section); }" + NL + "    void unlock() { UNLOCK_MUTEX_FUNCTION(&section); }" + NL + "" + NL + "  private:" + NL + "\tMUTEX_CRITICAL_SECTION section;" + NL + "};" + NL + "" + NL + "static AtomicMutex atomicMutex;" + NL + "" + NL + "class MutexLock{" + NL + "public:" + NL + "" + NL + "    MutexLock() : m_value(0){" + NL + "\t\twakeup = FALSE;" + NL + "\t\tSTART_EVENT_TYPE_FUNCTION(mutex, cond);" + NL + "\t\tif (!mutex)" + NL + "\t\t\tthrow ThreadException(\"Cannot create lock\");" + NL + "\t}" + NL + "" + NL + "\tMutexLock(const MutexLock& m) {" + NL + "\t\tthis->m_value = m.m_value;" + NL + "\t\tthis->wakeup = m.wakeup;" + NL + "\t\tthis->mutex = m.mutex;" + NL + "\t\tthis->cond = m.cond;" + NL + "\t}" + NL + "" + NL + "    ~MutexLock(){" + NL + "\t\tTERMINATE_EVENT_FUNCTION(mutex, cond);" + NL + "\t}" + NL + "" + NL + "\tvoid wait() {" + NL + "\t\tWAIT_EVENT_FUNCTION(mutex, cond, wakeup);" + NL + "\t}" + NL + "" + NL + "    void wakeUp() {" + NL + "\t\tWAKEUP_EVENT_FUNCTION(mutex, cond, wakeup);" + NL + "\t}" + NL + "" + NL + "    void lock() {" + NL + "\t\tbool canBeAccessed= this->verifyLock();" + NL + "\t\tif (canBeAccessed){" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "" + NL + "\t\tatomicMutex.lock();" + NL + "\t\tcanBeAccessed = m_value==0;" + NL + "\t\tm_value += 1;" + NL + "\t\tatomicMutex.unlock();" + NL + "" + NL + "\t\tif (!canBeAccessed){" + NL + "\t\t\twait();" + NL + "\t\t\tatomicMutex.lock();" + NL + "\t\t\tm_value -= 1;" + NL + "\t\t\tatomicMutex.unlock();" + NL + "\t\t}" + NL + "" + NL + "\t}" + NL + "" + NL + "\tbool isLocked() {" + NL + "\t\tatomicMutex.lock();" + NL + "\t\tbool canBeAccessed = m_value == 0;" + NL + "\t\tatomicMutex.unlock();" + NL + "\t\treturn !canBeAccessed;" + NL + "\t}" + NL + "" + NL + "\tbool verifyLock(int set = 0) {" + NL + "\t\tatomicMutex.lock();" + NL + "\t\tbool canBeAccessed = m_value == 0;" + NL + "\t\tif( m_value == set) {" + NL + "\t\t\tm_value = !set;" + NL + "\t\t\tcanBeAccessed = true;" + NL + "\t\t}" + NL + "\t\tatomicMutex.unlock();" + NL + "\t\treturn canBeAccessed;" + NL + "\t}" + NL + "" + NL + "    void unlock() {" + NL + "\t\tif (!verifyLock(1)){" + NL + "\t\t\twakeUp();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "private:" + NL + "\tvolatile int m_value;" + NL + "\tvolatile bool wakeup;" + NL + "" + NL + "\tEVENT_TYPE mutex;" + NL + "    CONDITION_TYPE  cond;" + NL + "};" + NL + "" + NL + "#define synchronized(L)                                               \\" + NL + "        for(L.lock();L.isLocked();\t\t\t\t\t\t\t\t\t  \\" + NL + "\t\t\tL.unlock() )" + NL + "" + NL + "struct ThreadParameters" + NL + "{" + NL + "    void* runCall;" + NL + "    void* context;" + NL + "    ThreadParameters(void* ctx, void* callPtr) : context(ctx), runCall(callPtr) {}" + NL + "};" + NL + "" + NL + "class Thread: public Runnable {" + NL + "" + NL + "\tpublic:" + NL + "\t\tThread(string threadName = \"\") : name(threadName), thrParams(this,ConvertToFunctionPointer(&Thread::run))" + NL + "\t\t\t, _threadHdl(0),_isRunning(false),_isTerminated(false) {}" + NL + "\t\tThread(Runnable *target, string threadName = \"\") :  name(threadName),thrParams(this,ConvertToFunctionPointer(&Thread::run)) , runnableObject(target) {}" + NL + "\t\tThread(void* funcPtr, void* ctx = 0 ,string threadName = \"\") : name(threadName), thrParams(ctx,funcPtr) {}" + NL + "\t\tThread(void (*funcPtr)(void*), void* ctx = 0, string threadName = \"\") : name(threadName), thrParams(ctx,ConvertToFunctionPointer(funcPtr)) {}" + NL + "\t\tThread(void (*funcPtr)(), string threadName = \"\") : name(threadName), thrParams(this,ConvertToFunctionPointer(funcPtr)) {}" + NL + "\t\ttemplate<class T>" + NL + "\t\tThread(void (T::*RunnableCall)(), string threadName = \"\") : name(threadName), thrParams(this,ConvertToFunctionPointer(RunnableCall)) {}" + NL + "\t\ttemplate<class T>" + NL + "\t\tThread(void (T::*RunnableCall)(void*), void* ctx = 0, string threadName = \"\") : name(threadName), thrParams(ctx,ConvertToFunctionPointer(RunnableCall)) {}" + NL + "\t\tvirtual ~Thread() {" + NL + "\t\t\tTHREAD_TERMINATE_FUNCTION(0);" + NL + "\t\t}" + NL + "" + NL + "\t\tstatic void sleep(long ms) throw(ThreadException) {" + NL + "\t\t\tTHREAD_SLEEP_FUNCTION(ms);" + NL + "\t\t}" + NL + "" + NL + "\t\tTHREAD_TYPE getId() const {" + NL + "\t\t\treturn this->_threadHdl;" + NL + "\t\t}" + NL + "" + NL + "\t\tstatic THREAD_RETURN_TYPE threadFunctionPointer(void* ptr) {" + NL + "\t\t\tThreadParameters* threadParameters = (ThreadParameters*)ptr;" + NL + "\t\t\tif(threadParameters->context != NULL) {" + NL + "                ((void (*)(void*)) threadParameters->runCall)(threadParameters->context);" + NL + "\t\t\t} else {" + NL + "\t\t\t    ((void (*)(void)) threadParameters->runCall)();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\treturn 0;" + NL + "\t\t}" + NL + "" + NL + "\t\tbool isFinished() {" + NL + "\t\t\treturn !this->isRunning();" + NL + "\t\t}" + NL + "" + NL + "\t\tbool isTerminated() {" + NL + "\t\t\tsynchronized(lock) {" + NL + "\t\t\t\treturn this->_isTerminated;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tbool isRunning() {" + NL + "\t\t\tsynchronized(lock) {" + NL + "\t\t\t\tif(this->_isRunning) {" + NL + "\t\t\t\t\tIS_THREAD_ALIVE_FUNCTION(_threadHdl,_isRunning);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn this->_isRunning;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tvirtual void run() {" + NL + "\t\t\tif(this->runnableObject != NULL) {" + NL + "\t\t\t\trunnableObject->run();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tvirtual void stop() {" + NL + "\t\t\tsynchronized(lock) {" + NL + "\t\t\t\tTHREAD_CANCEL_FUNCTION(_threadHdl);" + NL + "\t\t\t\t_isTerminated = true;" + NL + "\t\t\t\t_isRunning = false;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tstring getName() const {" + NL + "\t\t\treturn name;" + NL + "\t\t}" + NL + "" + NL + "\t\tvoid setName(string name) {" + NL + "\t\t\tthis->name = name;" + NL + "\t\t}" + NL + "" + NL + "" + NL + "\t\tvirtual void start() throw(ThreadException) {" + NL + "\t\t\tsynchronized(lock) {" + NL + "\t\t\t\treset();" + NL + "\t\t\t\tCREATE_THREAD(_threadHdl,Thread::threadFunctionPointer, &thrParams);" + NL + "\t\t\t\t_isRunning = true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tvoid join() throw(ThreadException) {" + NL + "\t\t\tTHREAD_JOIN_FUNCTION(_threadHdl);" + NL + "\t\t}" + NL + "" + NL + "\tprivate:" + NL + "\t\tmutable MutexLock lock;" + NL + "\t\tTHREAD_TYPE _threadHdl;" + NL + "\t\tstring name;" + NL + "" + NL + "\t\tThreadParameters thrParams;" + NL + "\t\tRunnable* runnableObject;" + NL + "" + NL + "\t\tbool _isRunning;" + NL + "\t\tbool _isTerminated;" + NL + "" + NL + "\t\tvoid reset() {" + NL + "\t\t\t_threadHdl = 0;" + NL + "\t\t\t_isRunning = false;" + NL + "\t\t\t_isTerminated = false;" + NL + "\t\t}" + NL + "" + NL + "};";
  protected final String TEXT_65 = NL + "#ifndef TIME_AND_DATE_DEFINITION" + NL + "#define TIME_AND_DATE_DEFINITION" + NL + "namespace { " + NL + "// Ported strptime from BSD" + NL + "#ifdef WINDOWS_OS" + NL + "" + NL + "const char* Days[] = {" + NL + "        \"Sunday\", \"Monday\", \"Tuesday\", \"Wednesday\"," + NL + "        \"Thursday\", \"Friday\", \"Saturday\"" + NL + "};" + NL + "" + NL + "const char* DaySymbols[] = {\"Sun\", \"Mon\", \"Tue\", \"Wed\",\"Thu\", \"Fri\", \"Sat\"};" + NL + "" + NL + "const char* Monthes[] = {\"January\", \"February\", \"March\", \"April\", \"May\", \"June\"," + NL + "\t\t\t\t\t\"July\", \"August\", \"September\", \"October\", \"November\", \"December\" };" + NL + "" + NL + "const char* MonthSymbols[] = { \"Jan\", \"Feb\", \"Mar\", \"Apr\", \"May\", \"Jun\"," + NL + "\t\t\t\t\t\t\t\t   \"Jul\", \"Aug\", \"Sep\", \"Oct\", \"Nov\", \"Dec\" };" + NL + "" + NL + "const char* parseNumber(const char* s, int low, int high, int* value) {" + NL + "        const char* p = s;" + NL + "        for (*value = 0; *p != NULL && isdigit(*p); ++p) {" + NL + "                *value = (*value) * 10 + static_cast<int>(*p) - static_cast<int>('0');" + NL + "        }" + NL + "        if (p == s || *value < low || *value > high) return NULL;" + NL + "        return p;" + NL + "}" + NL + "" + NL + "char* strptime(const char *s, const char *format, struct tm *tm) {" + NL + "        while (*format != NULL && *s != NULL) {" + NL + "                if (*format != '%') {" + NL + "                        if (*s != *format) return NULL;" + NL + "                        ++format;" + NL + "                        ++s;" + NL + "                        continue;" + NL + "                }" + NL + "                ++format;" + NL + "                int len = 0;" + NL + "                switch (*format) {" + NL + "          case 'a':" + NL + "          case 'A':" + NL + "                  tm->tm_wday = -1;" + NL + "                  for (int i = 0; i < 7; ++i) {" + NL + "                          len = static_cast<int>(strlen(DaySymbols[i]));" + NL + "                          if (_strnicmp(DaySymbols[i], s, len) == 0) {" + NL + "                                  tm->tm_wday = i;" + NL + "                                  break;" + NL + "                          }" + NL + "                          len = static_cast<int>(strlen(Days[i]));" + NL + "                          if (_strnicmp(Days[i], s, len) == 0) {" + NL + "                                  tm->tm_wday = i;" + NL + "                                  break;" + NL + "                          }" + NL + "                  }" + NL + "                  if (tm->tm_wday == -1) return NULL;" + NL + "                  s += len;" + NL + "                  break;" + NL + "          case 'b':" + NL + "          case 'B':" + NL + "          case 'h':" + NL + "                  tm->tm_mon = -1;" + NL + "                  for (int i = 0; i < 12; ++i) {" + NL + "                          len = static_cast<int>(strlen(MonthSymbols[i]));" + NL + "                          if (_strnicmp(MonthSymbols[i], s, len) == 0) {" + NL + "                                  tm->tm_mon = i;" + NL + "                                  break;" + NL + "                          }" + NL + "                          len = static_cast<int>(strlen(Monthes[i]));" + NL + "                          if (_strnicmp(Monthes[i], s, len) == 0) {" + NL + "                                  tm->tm_mon = i;" + NL + "                                  break;" + NL + "                          }" + NL + "                  }" + NL + "                  if (tm->tm_mon == -1) return NULL;" + NL + "                  s += len;" + NL + "                  break;" + NL + "          case 'm':" + NL + "                  s = parseNumber(s, 1, 12, &tm->tm_mon);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  --tm->tm_mon;" + NL + "                  break;" + NL + "          case 'd':" + NL + "          case 'e':" + NL + "                  s = parseNumber(s, 1, 31, &tm->tm_mday);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  break;" + NL + "          case 'H':" + NL + "                  s = parseNumber(s, 0, 23, &tm->tm_hour);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  break;" + NL + "          case 'M':" + NL + "                  s = parseNumber(s, 0, 59, &tm->tm_min);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  break;" + NL + "          case 'S':" + NL + "                  s = parseNumber(s, 0, 60, &tm->tm_sec);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  break;" + NL + "          case 'Y':" + NL + "                  s = parseNumber(s, 1900, 9999, &tm->tm_year);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  tm->tm_year -= 1900;" + NL + "                  break;" + NL + "          case 'y':" + NL + "                  s = parseNumber(s, 0, 99, &tm->tm_year);" + NL + "                  if (s == NULL) return NULL;" + NL + "                  if (tm->tm_year <= 68) {" + NL + "                          tm->tm_year += 100;" + NL + "                  }" + NL + "                  break;" + NL + "          case 't':" + NL + "          case 'n':" + NL + "                  while (isspace(*s)) ++s;" + NL + "                  break;" + NL + "          case '%':" + NL + "                  if (*s != '%') return NULL;" + NL + "                  ++s;" + NL + "                  break;" + NL + "          default:" + NL + "                  return NULL;" + NL + "                }" + NL + "                ++format;" + NL + "        }" + NL + "" + NL + "        if (*format != NULL) {return NULL;} " + NL + "\t\telse {return const_cast<char*>(s);}" + NL + "}" + NL + "#endif" + NL + "" + NL + "tm* ParseDate(string buf) {" + NL + "\ttime_t t(time(NULL)); \t" + NL + "\ttm* pDate = new tm(*localtime(&t));" + NL + "\tchar* ret = strptime(buf.c_str(), \"%d-%m-%Y\", pDate);" + NL + "\tassert(ret != NULL);" + NL + "\treturn pDate;" + NL + "};" + NL + "" + NL + "time_t* ParseTime(string buf) {" + NL + "\ttm tm;" + NL + "\ttime_t* pTime;" + NL + "\tchar* ret = strptime(buf.c_str(), \"%H:%M:%S\", &tm);" + NL + "\tassert(ret != NULL);\t" + NL + "\tpTime = new time_t(mktime(&tm));" + NL + "\treturn pTime;" + NL + "};" + NL + "}" + NL + "#endif" + NL;

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
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
	@GenerationProcedureParameter(id = ICppDefinitions.INCOMPLETE_DECLARATIONS) String inlineDeclarations;
	@GenerationProcedureParameter(id = ICppDefinitions.INCOMPLETE_TYPES_DEFNITION) String incompleteTypes;
	@GenerationProcedureParameter(id = ICppDefinitions.CLASS_GLOBAL) String global;
	@GenerationProcedureParameter(id = ICppDefinitions.VISIBILITY_BASED_CONTENTS) String visibilityBasedContents;
	@GenerationProcedureParameter(id = ICppDefinitions.PACKAGE_VISIBILITY_CONTENTS) String packageContents;
	@GenerationProcedureParameter(id = IModelingConstants.MULTILINE_COMMENTS_STRING) String elementComments;
	@GenerationProcedureParameter(id = ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS) String preProcessorDefnitionUse;
	@GenerationProcedureParameter(id = ICppDefinitions.FULL_QUALIFIED_NAME) String fullQualifiedName;
	@GenerationProcedureParameter(id = ICppDefinitions.FUNCTION_OPERATORS) String functionOperators;
			
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
    stringBuffer.append(functionOperators);
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
	
	@GenerationProcedureParameter(id = IModelingConstants.COPY_RIGHT) String copyRight;
	@GenerationProcedureParameter(id = PACKAGE_INCLUDES) String packageIncludes;
	@GenerationProcedureParameter(id = PREDEFINED_PACKAGE_CONTENTS) String predefinedPackageContents;
	@GenerationProcedureParameter(id = PRE_PROCESSING_DEFINITION_NAME) String fullName;
	@GenerationProcedureParameter(id = CPPCommonConstants.PACKAGE_SUFFIX) String rootName;
	@GenerationProcedureParameter(id = ICppHandlerDefinitions.GLOBAL_DEFINITIONS) String globalDefinitions;
	@GenerationProcedureParameter(id = ICppDefinitions.DEFNIED_NAMESPACES_MACROS) String definedMacros;
	@GenerationProcedureParameter(id = ICppDefinitions.HELPER_CODES) String helperCodes;
	@GenerationProcedureParameter(id = ICppDefinitions.HELPER_INCLUDES) String helperIncludes;
	@GenerationProcedureParameter(id = ICppDefinitions.ALIASES) String aliases;
	
	String templateDefinitions;
	
@Override
public void execute() {

    stringBuffer.append(copyRight);
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
    stringBuffer.append(helperIncludes);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(definedMacros);
    stringBuffer.append(globalDefinitions);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(templateDefinitions);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(helperCodes);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(predefinedPackageContents);
    stringBuffer.append(TEXT_29);
    
}

@Override
public void preExecute(){
	this.templateDefinitions= getRegistry().use(ICppDefinitions.THREAD_IMPLEMENTATION);
}


});

}});

getRegistry().define(ICppDefinitions.PRE_CLASS_DEFINED_OPERATORS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = NAME) String name;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_30);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_39);
    
}});

}});

getRegistry().define(ICppDefinitions.ASSIGNMENT_OPERATOR_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = NAME) String name;
			
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_42);
    
}});

}});

getRegistry().define(ICppDefinitions.ASSIGNMENT_OPERATOR_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = NAME) String name;
			
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_45);
    
}});

}});

getRegistry().define(ICppDefinitions.DEEP_COPY_METHOD_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = NAME) String name;
	@GenerationArgument String contents;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_46);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_48);
    setContents();
    stringBuffer.append(TEXT_49);
    
}

private void setContents(){
if(!contents.isEmpty()){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(contents);
    
return;		
}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(StringUtil.indent("//Empty Block", 1));
    
}

});

}});

getRegistry().define(ICppDefinitions.DEEP_COPY_METHOD_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = NAME) String name;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_52);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_53);
    

}

});

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
    stringBuffer.append(TEXT_54);
    stringBuffer.append( fullName );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(fullPath);
    stringBuffer.append(TEXT_56);
    safeSet(bodyIncludes);
    safeSet(preProcessorDefnitionUse);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(namespaceOpening);
    safeSet(attributes);
    safeSet(publicImplementation);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(namespaceClosing);
    

}

private void safeSet(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_61);
    

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
    stringBuffer.append(TEXT_62);
    stringBuffer.append(includes);
    stringBuffer.append(TEXT_63);
    

}

});

}});

getRegistry().define(ICppDefinitions.THREAD_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {

    stringBuffer.append(TEXT_64);
    

}

});

}});


getRegistry().define(ICppDefinitions.TIME_HELPER_CODE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_65);
    

}});

}});


    return stringBuffer.toString();
  }
}