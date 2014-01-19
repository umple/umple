/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_Html.ump 64
 */
// line 64 "../../../../src/Generator_Html.ump"
public class AttributeElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AttributeElement Attributes
  private String name;
  private String value;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AttributeElement(String aName, String aValue)
  {
    name = aName;
    value = aValue;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setValue(String aValue)
  {
    boolean wasSet = false;
    value = aValue;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getValue()
  {
    return value;
  }

  public void delete()
  {}

  @umplesourcefile(line={70},file={"Generator_Html.ump"},javaline={68},length={8})
  public String toString(){
    StringBuffer stringBuffer = new StringBuffer(" "); //$NON-NLS-1$
		stringBuffer.append(getName());
		if(getValue() == null){
			return stringBuffer.toString();
		}
		return stringBuffer.append("=\"").append(getValue()).append("\"").toString(); //$NON-NLS-1$ //$NON-NLS-2$
  }

}