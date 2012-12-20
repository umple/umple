package cruise.model;


public class ParameterManager {

	
	public static String replace(String fragment, String... args){
		String ret=fragment;
		int i=1;
		for (String arg: args){
			ret=ret.replaceAll("#"+ (i++)+"#", arg);
		}
		return ret;
	}
}
