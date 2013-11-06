/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * @umplesource Generator_Html.ump 78
 */
// line 78 "../../../../src/Generator_Html.ump"
public class Element
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Element Attributes
  private String tagName;
  private Element parent;
  private List<AttributeElement> attributes;

  //Element Associations
  private List<Element> children;
  private Element element;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={89},file={"Generator_Html.ump"},javaline={43},length={4})
  public Element(String aTagName, Element aParent)
  {
    tagName = aTagName;
    parent = aParent;
    attributes = new ArrayList<AttributeElement>();
    children = new ArrayList<Element>();
    // line 89 "../../../../src/Generator_Html.ump"
    if(aParent != null) {
    			setParentInternally(aParent);
    			aParent.addChild(this);
    		}
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTagName(String aTagName)
  {
    boolean wasSet = false;
    tagName = aTagName;
    wasSet = true;
    return wasSet;
  }

  public boolean setParent(Element aParent)
  {
    boolean wasSet = false;
    parent = aParent;
    wasSet = true;
    return wasSet;
  }

  public boolean addAttribute(AttributeElement aAttribute)
  {
    boolean wasAdded = false;
    wasAdded = attributes.add(aAttribute);
    return wasAdded;
  }

  public boolean removeAttribute(AttributeElement aAttribute)
  {
    boolean wasRemoved = false;
    wasRemoved = attributes.remove(aAttribute);
    return wasRemoved;
  }

  public String getTagName()
  {
    return tagName;
  }

  public Element getParent()
  {
    return parent;
  }

  public AttributeElement getAttribute(int index)
  {
    AttributeElement aAttribute = attributes.get(index);
    return aAttribute;
  }

  public AttributeElement[] getAttributes()
  {
    AttributeElement[] newAttributes = attributes.toArray(new AttributeElement[attributes.size()]);
    return newAttributes;
  }

  public int numberOfAttributes()
  {
    int number = attributes.size();
    return number;
  }

  public boolean hasAttributes()
  {
    boolean has = attributes.size() > 0;
    return has;
  }

  public int indexOfAttribute(AttributeElement aAttribute)
  {
    int index = attributes.indexOf(aAttribute);
    return index;
  }

  public Element getChild(int index)
  {
    Element aChild = children.get(index);
    return aChild;
  }

  public List<Element> getChildren()
  {
    List<Element> newChildren = Collections.unmodifiableList(children);
    return newChildren;
  }

  public int numberOfChildren()
  {
    int number = children.size();
    return number;
  }

  public boolean hasChildren()
  {
    boolean has = children.size() > 0;
    return has;
  }

  public int indexOfChild(Element aChild)
  {
    int index = children.indexOf(aChild);
    return index;
  }

  public Element getElement()
  {
    return element;
  }

  public static int minimumNumberOfChildren()
  {
    return 0;
  }

  @umplesourcefile(line={96},file={"Generator_Html.ump"},javaline={186},length={4})
  public boolean addChild(Element aChild)
  {
    boolean wasAdded = false;
    if (children.contains(aChild)) { return false; }
    Element existingElement = aChild.getElement();
    if (existingElement == null)
    {
      aChild.setElement(this);
    }
    else if (!this.equals(existingElement))
    {
      existingElement.removeChild(aChild);
      addChild(aChild);
    }
    else
    {
      children.add(aChild);
    }
    wasAdded = true;
    // line 96 "../../../../src/Generator_Html.ump"
    if(aChild== null|| aChild.equals(this)){
    			return false;
    		}
    		aChild.setParentInternally(this);
    return wasAdded;
  }

  @umplesourcefile(line={96},file={"Generator_Html.ump"},javaline={186},length={4})
  public boolean removeChild(Element aChild)
  {
    boolean wasRemoved = false;
    if (children.contains(aChild))
    {
      children.remove(aChild);
      aChild.setElement(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  @umplesourcefile(line={96},file={"Generator_Html.ump"},javaline={186},length={4})
  public boolean addChildAt(Element aChild, int index)
  {  
    boolean wasAdded = false;
    if(addChild(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChildren()) { index = numberOfChildren() - 1; }
      children.remove(aChild);
      children.add(index, aChild);
      wasAdded = true;
    }
    return wasAdded;
  }

  @umplesourcefile(line={96},file={"Generator_Html.ump"},javaline={186},length={4})
  public boolean addOrMoveChildAt(Element aChild, int index)
  {
    boolean wasAdded = false;
    if(children.contains(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChildren()) { index = numberOfChildren() - 1; }
      children.remove(aChild);
      children.add(index, aChild);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addChildAt(aChild, index);
    }
    return wasAdded;
  }

  public boolean setElement(Element aElement)
  {
    boolean wasSet = false;
    Element existingElement = element;
    element = aElement;
    if (existingElement != null && !existingElement.equals(aElement))
    {
      existingElement.removeChild(this);
    }
    if (aElement != null)
    {
      aElement.addChild(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(Element aChild : children)
    {
      aChild.setElement(null);
    }
    if (element != null)
    {
      Element placeholderElement = element;
      this.element = null;
      placeholderElement.removeChild(this);
    }
  }

  @umplesourcefile(line={104},file={"Generator_Html.ump"},javaline={271},length={9})
   private void setParentInternally(Element parent){
    if(parent== null|| parent.equals(getParent())){
			return;
		}
		if(getParent() != null){
			getParent().removeChild(this);
		}
		setParent(parent);
  }

  @umplesourcefile(line={115},file={"Generator_Html.ump"},javaline={282},length={8})
  public AttributeElement getAttributeElement(String name){
    for(AttributeElement attribute: getAttributes()){
			if(attribute.getName().equals(name)){
				return attribute;
			}
		}
		return null;
  }

  @umplesourcefile(line={124},file={"Generator_Html.ump"},javaline={292},length={4})
  public String getAttribute(String name){
    AttributeElement attributeElement = getAttributeElement(name);
		return attributeElement!= null?attributeElement.getValue(): null;
  }

  @umplesourcefile(line={129},file={"Generator_Html.ump"},javaline={298},length={3})
  public Element appendText(String... texts){
    return appendTextContents(false, texts);
  }

  @umplesourcefile(line={133},file={"Generator_Html.ump"},javaline={303},length={9})
  public Element appendTextContents(boolean newLine, String... texts){
    for(String text: texts){
			addChild(new TextContents(text, null));
			if(newLine){
				addChild(new TextContents("\n", null)); //$NON-NLS-1$
			}
		}
		return this;
  }

  @umplesourcefile(line={143},file={"Generator_Html.ump"},javaline={314},length={5})
  public Element appendText(String text){
    Element child = new TextContents(text, null);
	  	addChild(child);
	  	return child;
  }

  @umplesourcefile(line={149},file={"Generator_Html.ump"},javaline={321},length={4})
  public Element getChildByPath(String... path){
    List<Element> childrenByPath = getChildrenByPath(path);
		return childrenByPath.isEmpty()? null: childrenByPath.get(0);
  }

  @umplesourcefile(line={154},file={"Generator_Html.ump"},javaline={327},length={4})
  public Element getChildByPath(List<String> attributesObjects, String... path){
    List<Element> childByPath = getChildrenByPath(attributesObjects, path);
		return childByPath.isEmpty()? null: childByPath.get(0);
  }

  @umplesourcefile(line={159},file={"Generator_Html.ump"},javaline={333},length={19})
  public List<Element> getChildrenByPath(List<String> attributesObjects, String... path){
    List<String> asArray= new ArrayList<String>();
		for(int index=0; index<path.length; index++){
			asArray.add(path[index]);
		}	
		List<Element> filteredList= new ArrayList<Element>();
		for(Element element: getChildrenByPath(asArray)){
			for(int index=0; index<attributesObjects.size(); index= index+2){
				String name= attributesObjects.get(index);
				String value= index+1>=attributesObjects.size()?null: attributesObjects.get(index+1);
				String attribute = element.getAttribute(name);
				if(attribute== null? value!= null: !attribute.equals(value)){
					continue;
				}
				filteredList.add(element);
			}
		}
		return filteredList;
  }

  @umplesourcefile(line={179},file={"Generator_Html.ump"},javaline={354},length={7})
  public List<Element> getChildrenByPath(String... path){
    List<String> asArray= new ArrayList<String>();
		for(int index=0; index<path.length; index++){
			asArray.add(path[index]);
		}
		return getChildrenByPath(asArray);
  }

  @umplesourcefile(line={187},file={"Generator_Html.ump"},javaline={363},length={5})
  public List<Element> getChildrenByPath(List<String> path){
    ArrayList<Element> elements = new ArrayList<Element>();
		getChildrenByPath(path, elements);
		return elements;
  }

  @umplesourcefile(line={193},file={"Generator_Html.ump"},javaline={370},length={20})
   private void getChildrenByPath(List<String> path, List<Element> retrieved){
    List<Element> elements= new ArrayList<Element>();
		if(path.isEmpty()){
			return;
		}
		String segment= path.get(0);
		for(Element element: getChildren()){
			if(!element.getTagName().equals(segment)){
				continue;
			}
			elements.add(element);
		}
		if(path.size()==1){
			retrieved.addAll(elements);
		}else{
			for(Element element: elements){
				element.getChildrenByPath(path.subList(1, path.size()), retrieved);
			}
		}
  }

  @umplesourcefile(line={214},file={"Generator_Html.ump"},javaline={392},length={3})
  public String toString(){
    return this.htmlString();
  }

  @umplesourcefile(line={218},file={"Generator_Html.ump"},javaline={397},length={10})
   protected String htmlString(){
    StringBuffer b = new StringBuffer(openStatement());
		if(getChildren() != null && getChildren().size() > 0){
			for(Element child: getChildren()){
				b.append(child.htmlString());
			}
		}
		b.append(closeStatement());
		return b.toString();
  }

  @umplesourcefile(line={229},file={"Generator_Html.ump"},javaline={409},length={7})
   private String openStatement(){
    StringBuffer b = new StringBuffer("<").append(getTagName()); //$NON-NLS-1$
		for(AttributeElement attr: getAttributes()){
			b.append(attr.toString());
		}
		return b.append(">").toString(); //$NON-NLS-1$
  }

  @umplesourcefile(line={237},file={"Generator_Html.ump"},javaline={418},length={3})
   private String closeStatement(){
    return new StringBuffer("</").append(getTagName()).append(">").toString(); //$NON-NLS-1$ //$NON-NLS-2$
  }

}