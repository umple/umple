package xmi.umple.model;

import java.util.ArrayList;
import java.util.List;

import xmi.umple.helper.UmpleConstants;

public class UmpleModel {

	private List<Umple> components;
	private StringBuilder umpleBuilder;
	private String currentPackageName="";
	
	public UmpleModel(){
		components = new ArrayList<>();
	}

	public void addComponet(Umple component){
		components.add(component);
		if (isPackage(component)) {
			currentPackageName = component.getName();
		}
	}

	public String getCurrentPackageName(){
		return this.currentPackageName;
	}
	
	public String generateUmple()
	{
		umpleBuilder = new StringBuilder();
		for (Umple component : components) {
			umpleBuilder.append(component.generateUmple());
		}
		return umpleBuilder.toString();
	}

	
	private static boolean isPackage(Umple component){
		return component.getId().equals(UmpleConstants.ECOREPACKAGE);
	}
	 
	
}
