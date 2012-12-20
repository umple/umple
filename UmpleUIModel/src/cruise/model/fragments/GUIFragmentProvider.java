package cruise.model.fragments;


import cruise.model.abstractObjects.IGenerator;
import cruise.umple.compiler.Attribute;

public class GUIFragmentProvider {

	private IGenerator fragmentCreate;
	private IGenerator fragmentEdit;
	private IGenerator fragmentGrid;
	private IGenerator fragmentHeaderGrid;
	
	

	public GUIFragmentProvider(IGenerator fragmentCreate,
			IGenerator fragmentEdit, IGenerator fragmentGrid,IGenerator fragmentHeaderGrid) {
		this.fragmentCreate = fragmentCreate;
		this.fragmentEdit = fragmentEdit;
		this.fragmentGrid = fragmentGrid;
		this.fragmentHeaderGrid=fragmentHeaderGrid;
	}


	public String getCreateFragment(Attribute var){
		return fragmentCreate!=null?fragmentCreate.generate(var):"";
	}


	public String getEditFragment(Attribute var){
		return fragmentEdit!=null?fragmentEdit.generate(var):"";
	}


	public String getGridFragment(Attribute var){
		return fragmentGrid!=null?fragmentGrid.generate(var):"";
	}

	public String getGridHeaderFragment(Attribute var){
		return fragmentHeaderGrid!=null?fragmentHeaderGrid.generate(var):"";
	}
		
}
