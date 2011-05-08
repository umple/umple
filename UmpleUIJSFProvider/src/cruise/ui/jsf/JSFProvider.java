package cruise.ui.jsf;

import cruise.generator.AbstractProvider;
import cruise.model.abstractObjects.BackingObject;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocMandatoryToSingletonFormFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocManyToOneFormFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocManyToOnePanelFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocManyToOneSingletonFormFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocManyToOneSingletonePanelFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocNManyToOptionalFormFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocNManyToOptionalPanelFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocOptionalToSingletonFormFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocZeroManyToOptionalFormFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocZeroManyToOptionalPanelFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocZeroOrOneFormFragment;
import cruise.ui.jsf.templates.impl.GUI.associations.AssocZeroOrOnePanelFragment;

public class JSFProvider extends AbstractProvider {


	private static int idSequence=0;

	private AssocZeroOrOnePanelFragment assocZeroOrOnePanelFragment=new AssocZeroOrOnePanelFragment();

	private AssocZeroOrOneFormFragment assocZeroOrOneFormFragment=new AssocZeroOrOneFormFragment();
	
	private AssocZeroManyToOptionalPanelFragment assocZeroManyToOptionalPanelFragment=new AssocZeroManyToOptionalPanelFragment();

	private AssocZeroManyToOptionalFormFragment assocZeroManyToOptionalFormFragment=new AssocZeroManyToOptionalFormFragment();
	
	private AssocNManyToOptionalPanelFragment assocNManyToOptionalPanelFragment=new AssocNManyToOptionalPanelFragment();

	private AssocNManyToOptionalFormFragment assocNManyToOptionalFormFragment=new AssocNManyToOptionalFormFragment();
	
	private AssocManyToOneFormFragment assocManyToOneFormFragment=new AssocManyToOneFormFragment();
	
	private AssocManyToOnePanelFragment assocManyToOnePanelFragment=new AssocManyToOnePanelFragment();
	
	private AssocMandatoryToSingletonFormFragment assocMandatorylToSingletonFormFragment=new AssocMandatoryToSingletonFormFragment();

	private AssocOptionalToSingletonFormFragment assocOptionalToSingletonFormFragment=new AssocOptionalToSingletonFormFragment();

	private AssocManyToOneSingletonFormFragment assocManyToOneSingletonFormFragment =new AssocManyToOneSingletonFormFragment();
	
	private AssocManyToOneSingletonePanelFragment assocManyToOneSingletonePanelFragment=new AssocManyToOneSingletonePanelFragment();

	
	public String getAssocManyToOneSingletonPanelFragment(BackingObject bckObj) {
		return assocManyToOneSingletonePanelFragment.generate(bckObj);
	}
	
	public String getAssocManyToOneSingletonFormFragment(BackingObject bckObj) {
		return assocManyToOneSingletonFormFragment.generate(bckObj);
	}
		
	public String getAssocOptionalToSingletonFormFragment(BackingObject bckObj) {
		return assocOptionalToSingletonFormFragment.generate(bckObj);
	}
	
	public String getAssocMandatorylToSingletonFormFragment(BackingObject bckObj) {
		return assocMandatorylToSingletonFormFragment.generate(bckObj);
	}
	
	public String getAssocManyToOnePanelFragment(BackingObject bckObj) {
		return assocManyToOnePanelFragment.generate(bckObj);
	}
	public String getAssocManyToOneFormFragment(BackingObject bckObj) {
		return assocManyToOneFormFragment.generate(bckObj);
	}
	
	public String getAssocNManyToOptionalPanelFragment(BackingObject bckObj) {
		return assocNManyToOptionalPanelFragment.generate(bckObj);
	}
	public String getAssocNManyToOptionalFormFragment(BackingObject bckObj) {
		return assocNManyToOptionalFormFragment.generate(bckObj);
	}
	
	public String getAssocZeroOrOnePanelFragment(BackingObject bckObj) {
		return assocZeroOrOnePanelFragment.generate(bckObj);
	}
	public String getAssocZeroOrOneFormFragment(BackingObject bckObj) {
		return assocZeroOrOneFormFragment.generate(bckObj);
	}

	public String getAssocZeroManyToOptionalPanelFragment(BackingObject bckObj) {
		return assocZeroManyToOptionalPanelFragment.generate(bckObj);
	}
	public String getAssocZeroManyToOptionalFormFragment(BackingObject bckObj) {
		return assocZeroManyToOptionalFormFragment.generate(bckObj);
	}
	public static int getNextId(){
		
		return idSequence++;
	}
	
	public JSFProvider(String attConfig, String guiConfig) {
		super(attConfig, guiConfig);
	}

	
	
}
