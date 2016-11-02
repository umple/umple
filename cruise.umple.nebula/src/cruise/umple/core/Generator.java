package cruise.umple.core;

import cruise.umple.cpp.gen.Header;

public class Generator {
	
	public static final String HEADER_CMAKE= "Header#cMake";
	public static final String HEADER_CMAKE_FOLDER= "Header#cMakeFolder";
	
	Header header;
	
	public Generator(GenerationPolicyRegistry generationPolicyRegistry) {
		header= new Header(generationPolicyRegistry);
	}

	public String generate(String id, Object element, Object... args){
		switch (id) {
		case Generator.HEADER_CMAKE:
			return header.cMake(element);
		case Generator.HEADER_CMAKE_FOLDER:
			return header.cMakeFolders();
		default:
			break;
		}
		
		return null;
	}

}
