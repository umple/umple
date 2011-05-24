package cruise.umple.validation;

import org.eclipse.xtext.validation.Check;

import cruise.umple.umple.Namespace;
import cruise.umple.umple.TraceDirective;
import cruise.umple.umple.UmpleClass;
import cruise.umple.umple.UmpleInterface;
import cruise.umple.umple.UmplePackage;


public class UmpleJavaValidator extends AbstractUmpleJavaValidator {

	public static final String INVALID_NAMESPACE_NAME = "InvalidNamespaceName";
	@Check  
	public void checkNamespaceStartsWithLowerCase(Namespace namespace) {
		if (!Character.isLowerCase(namespace.getValue().charAt(0))) {
			warning("Namespaces should start with a lowercase letter",
					UmplePackage.NAMESPACE__VALUE,
					INVALID_NAMESPACE_NAME,
					namespace.getValue()
			);
		}
	}

	public static final String INVALID_CLASS_NAME = "InvalidClassName";
	@Check  
	public void checkUClassStartsWithCapital(UmpleClass uClass) {
		if (!Character.isUpperCase(uClass.getName().charAt(0))) {
			warning("Umple Classes should start with a uppercase letter",
					UmplePackage.UMPLE_CLASS__NAME,
					INVALID_CLASS_NAME,
					uClass.getName()
			);
		}
	}

	public static final String INVALID_INTERFACE_NAME = "InvalidInterfaceName";
	@Check  
	public void checkUInterfaceStartsWithCapital(UmpleInterface uInterface) {
		if (!Character.isUpperCase(uInterface.getName().charAt(0))) {
			warning("Umple Interfaces should start with a uppercase letter",
					UmplePackage.UMPLE_INTERFACE__NAME,
					INVALID_INTERFACE_NAME,
					uInterface.getName()
			);
		}
	}
	
	public static final String TRACEDIRECTIVE_START = "InvalidTraceDirective";
	@Check  
	public void checkTraceDirectiveStartsWithLower(TraceDirective trace) {
		if (!Character.isLowerCase(trace.getTraceStart().charAt(0))) {
			warning("@deprecated  As of release 1.1. Use 'trace' instead.",
					UmplePackage.TRACE_DIRECTIVE__TRACE_START,
					TRACEDIRECTIVE_START,
					trace.getTraceStart()
			);
		}
	}

}
