package cruise.model.fragments;


import cruise.model.abstractObjects.IGenerator;
import cruise.umple.compiler.Attribute;

public class AttributteFragmentProvider {

	private IGenerator fragmentSetter;
	private IGenerator fragmentGetter;
	private IGenerator fragmentDeclaration;
	private IGenerator fragmentAsignation;
	private IGenerator fragmentCopy;
	private IGenerator fragmentPreConstructor;
	private IGenerator fragmentReverseCopy;
	

	public AttributteFragmentProvider(IGenerator fragmentSetter,
			IGenerator fragmentGetter, IGenerator fragmentDeclaration,
			IGenerator fragmentAsignation, IGenerator fragmentCopy,
			IGenerator fragmentPreConstructor,IGenerator fragmentReverseCopy) {
		
		this.fragmentSetter = fragmentSetter;
		this.fragmentGetter = fragmentGetter;
		this.fragmentDeclaration = fragmentDeclaration;
		this.fragmentAsignation = fragmentAsignation;
		this.fragmentCopy = fragmentCopy;
		this.fragmentPreConstructor = fragmentPreConstructor;
		this.fragmentReverseCopy = fragmentReverseCopy;
	}


	public String getSetFragment(Attribute var){
		return fragmentSetter!=null?fragmentSetter.generate(var):"";
	}


	public String getGetFragment(Attribute var){
		return fragmentGetter!=null?fragmentGetter.generate(var):"";
	}


	public String getDeclarationFragment(Attribute var){
		return fragmentDeclaration!=null?fragmentDeclaration.generate(var):"";
	}

	
	public String getAsignationFragment(Attribute var){
		return fragmentAsignation!=null?fragmentAsignation.generate(var):"";
	}

	public String getCopyFragment(Attribute var) {
		return fragmentCopy!=null?fragmentCopy.generate(var):"";
	}



	public String getPreConstructorFragment(Attribute var) {
		return fragmentPreConstructor!=null?fragmentPreConstructor.generate(var):"";
	}
	
	public String getReverseCopyFragment(Attribute var) {
		return fragmentReverseCopy!=null?fragmentReverseCopy.generate(var):"";
	}
		
}
