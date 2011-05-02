package cruise.model;

import java.util.Map;

import cruise.model.fragments.AttributteFragmentProvider;
import cruise.umple.compiler.Attribute;

public class FragmentResolver {
	
	private Map<String, AttributteFragmentProvider> attfragmentProviderMap;
	
	public FragmentResolver(Map<String, AttributteFragmentProvider> attfragmentProviderMap){
		this.attfragmentProviderMap=attfragmentProviderMap;
		
	}
	
	
	public AttributteFragmentProvider getFragmentProvider(Attribute var){
		
		AttributteFragmentProvider attemp= attfragmentProviderMap.get(var.getModifier() + " || " + var.getType());
		
		if(attemp==null){
			attemp= attfragmentProviderMap.get("* || " + var.getType());
			
		}
		if(attemp==null){
			attemp= attfragmentProviderMap.get(var.getModifier()+ " || *");
			
		}	
		if(attemp==null){
			attemp= attfragmentProviderMap.get("* || *" );
			
		}
		
		if(attemp==null){
			attemp= new AttributteFragmentProvider(null,null, null, null, null, null, null);
			
		}	
		return attemp;
		
	} 

}
