package cruise.umple.ui.eclipse.editors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Scope extends ArrayList<AttributeDefinition>{
	private static final long serialVersionUID = 2990982455069383561L;
	Scope parent;
	List<Scope> children;
	List<AttributeDefinition> floating = new ArrayList<AttributeDefinition>();
	boolean canContain = true;
	private Integer end;
	private Integer begin;
	public Scope(){
		children = new ArrayList<Scope>();
		floating = new ArrayList<AttributeDefinition>();
		begin = 0;
		end = Integer.MAX_VALUE;
	}
	public Scope(Scope parent){
		this.parent = parent;
		this.parent.children.add(this);
		this.children = new ArrayList<Scope>();
		this.floating = new ArrayList<AttributeDefinition>();
	}
	public AttributeDefinition getAttribute(String name) {
		for(AttributeDefinition ad:this){
			//System.out.println(ad.getName()+"  "+name);
			if(ad.getName().equals(name)){
				return ad;
			}
		}
		if(parent!=null)
		{
			return parent.getAttribute(name);
		}
		else {
			return null;
		}
	}
	public boolean addFloatingDefinition(AttributeDefinition add) {
		return floating.add(add);			
	}
	
	public void setCanContain(boolean bool){
		canContain = bool;
	}
	@Override
	public boolean contains(Object obj){
		if(parent!=null){
			return super.contains(obj)||parent.contains(obj);
		}
		else {
			//if(name==null){
				return super.contains(obj);
			//}
			//else if(attributes.get(name)!=null&&canContain){
			/*for(Scope scope:attributes.get(name).values()){
					scope.setCanContain(false);
				}
				boolean contains = false;
				for(Scope scope:attributes.get(name).values()){
					if(scope.contains(obj)){
						contains=true;
						break;
					}
				}
				for(Scope scope:attributes.get(name).values()){
					scope.setCanContain(true);
				}
				if(contains==true){
					return true;
				}*/
			//return super.contains(obj);
			/*}
			else {
				return super.contains(obj);
			}*/
		}
	}
	@Override
	public void clear(){
		for(Scope child:children){
			child.clear();
		}
		children.clear();
		super.clear();
	}
	public void begin(int begin){
		this.begin = begin;
	}
	public Integer getBegin() {
		return begin;
	}
	public void end(int end){
		//if(parent.name!=null){
		//	parent.end=end;
		//}
		this.end = end;
	}
	public Integer getEnd() {
		return end;
	}
	public Scope getChildWithin(int begin, int end){
		Scope child = null;
		for(Scope scope:children){
			if(scope.getBegin()<=begin&&scope.getEnd()==null){
				child = scope.getChildWithin(begin,end);
			}
			else if(scope.getBegin()<=begin&&scope.getEnd()>=end){
				child = scope.getChildWithin(begin,end);
			}
		}
		if(child==null){
			return this;
		}
		return child;
	}
	public void adjust(int offset, Integer difference) {
		for(Scope scope:children){
			scope.adjust(offset, difference);
		}
		if(begin!=null)
		if(begin>offset){
			begin+=difference;
		}
		if(end!=null)
		if(end>offset){
			end+=difference;
		}
	}
}
