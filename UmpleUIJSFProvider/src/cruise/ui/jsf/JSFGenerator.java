package cruise.ui.jsf;

import cruise.generator.AbstractUIGenerator;
import cruise.model.Constants;
import cruise.ui.interfaces.UIProvider;

public class JSFGenerator extends AbstractUIGenerator {

	private JSFProvider controllerObjectsProvider;
	private JSFValidationProvider validationProvider;

	public JSFGenerator() {
		super();

	}


	@Override
	public UIProvider getUIProvider() {
		if (controllerObjectsProvider == null) {
			controllerObjectsProvider = new JSFProvider(this.getProperties()
					.getProperty(Constants.ATTRIBUTE_CONFIGURATOR), this
					.getProperties().getProperty(
							Constants.GUI_ATTRIBUTE_CONFIGURATOR));
			controllerObjectsProvider.initialize(this);

		}
		return controllerObjectsProvider;
	}

}
