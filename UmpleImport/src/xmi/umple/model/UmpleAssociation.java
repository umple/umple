package xmi.umple.model;

public class UmpleAssociation extends Umple{

	public UmpleAssociation(String id) {
		super(id);
	}

	@Override
	String generateUmple() {
		umpleBuilder.append("association "+this.name+"\n{\n}");
		return umpleBuilder.toString();
	}

}
