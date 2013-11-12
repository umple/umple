package xmi.umple.model;

import java.util.ArrayList;

public class UmpleClass extends Umple{
	
	private String packageName="";
	private boolean isAbstract=false;
	private boolean isInterface=false;
	private ArrayList<String> superTypes;
	
	public UmpleClass(String id, String packageName) {
		super(id);
		this.packageName = packageName;
		superTypes = new ArrayList<String>();
	}
	
	public UmpleClass(String id, String packageName, boolean isAbstract, boolean isInterface) {
		super(id);
		this.packageName = packageName;
		this.isAbstract = isAbstract;
		this.isInterface = isInterface;
		superTypes = new ArrayList<String>();
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public boolean isInterface() {
		return isInterface;
	}

	public void addSuperType(String superType){
		if(superType!=null && !superType.isEmpty()){
			superTypes.add(superType);
		}
	}
	
	public String toString(){
		return "Class "+this.packageName+"::"+this.name;
	}
	@Override
	String generateUmple() {
		this.umpleBuilder.append("\n\n");
		if(isInterface){
			this.umpleBuilder.append("interface "+this.name+"\n{");
		}else{
			this.umpleBuilder.append("class "+this.name+"\n{");
			if(superTypes.size()!=0){
				for (String superType : superTypes) {
					this.umpleBuilder.append("\n  isA "+ superType+";");
				}
			}
		}
		this.umpleBuilder.append("\n}");
		return umpleBuilder.toString();
	}
}
