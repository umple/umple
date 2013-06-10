/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/
package cruise.umple.compiler;
import java.util.*;

public interface TraceItem
{
  public String getTracerType();
  public Boolean getIsPre();
  public Boolean getIsPost();
  public String trace(CodeTranslator gen, Object o, String template, UmpleClass uClass, String... args);//old
  public String getPeriodClause();
  public String getExtremities(CodeTranslator gen, String name);
}