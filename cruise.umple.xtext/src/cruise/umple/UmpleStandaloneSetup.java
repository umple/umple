
package cruise.umple;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UmpleStandaloneSetup extends UmpleStandaloneSetupGenerated{

	public static void doSetup() {
		new UmpleStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

