package cruise.umple.ui.eclipse.editors;

import java.util.ArrayList;

public class AttributeDefinition extends ArrayList<AttributeDefinition>{
	private static final long serialVersionUID = -4283756705759837600L;
	private String name;
	private int begin;
	private int end;
	public AttributeDefinition(String name, int begin, int end){
		super();
		this.name = name;
		this.begin= begin;
		this.end = end;
	}
	public String getName() {
		return name;
	}
	public Integer getBegin() {
		return begin;
	}
	public Integer getEnd() {
		return end;
	}
}