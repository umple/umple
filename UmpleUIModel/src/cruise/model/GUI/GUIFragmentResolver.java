package cruise.model.GUI;

import java.util.Map;

import cruise.model.fragments.GUIFragmentProvider;
import cruise.umple.compiler.Attribute;

public class GUIFragmentResolver {
	
	private Map<String, GUIFragmentProvider> gUIProviderMap;
	
	public GUIFragmentResolver(Map<String, GUIFragmentProvider> gUIProviderMap){
		this.gUIProviderMap=gUIProviderMap;
		
	}
	
	
	public GUIFragmentProvider getFragmentProvider(Attribute var){
		 
		GUIFragmentProvider attemp= gUIProviderMap.get(var.getModifier() + " || " + var.getType());
		if(attemp==null){
			attemp= gUIProviderMap.get("* || " + var.getType());
			
		}
		if(attemp==null){
			attemp= gUIProviderMap.get(var.getModifier()+ " || *");
			
		}	
		if(attemp==null){
			attemp= gUIProviderMap.get("* || *" );
			
		}
		
		if(attemp==null){
			attemp= new GUIFragmentProvider(null,null, null, null);
			
		}	
		return attemp;
		
	} 

}
