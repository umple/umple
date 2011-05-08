package cruise.ui.jsf;

import cruise.factory.UIFactory;
import cruise.ui.interfaces.UIGenerator;

public class JSFFactory extends UIFactory{
	
	private JSFGenerator uiGenerator=new JSFGenerator();

	public UIGenerator getUIGenerator() {
		return uiGenerator;
	}

}
