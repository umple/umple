package xmi.umple.model;

public class UmplePackage extends Umple{
	public UmplePackage(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Package "+this.name;
	}

	@Override
	String generateUmple() {
		this.umpleBuilder.append("namespace "+this.name+";");
		return umpleBuilder.toString();
	}


}
