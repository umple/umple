package xmi.umple.model;

public abstract class Umple {
	
	String id;
	String name;
	StringBuilder umpleBuilder;
	
	public Umple(String id){
		this.id = id;
		umpleBuilder = new StringBuilder();
	};
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getId(){
		return this.id;
	}
	
	abstract String generateUmple();
	
}
