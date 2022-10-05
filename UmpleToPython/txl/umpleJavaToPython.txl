include "../Grammers/Python.Grm"
include "BooleanTranslation.txl"
include "ImportProcessing.txl"
include "ListTranslation.txl"
include "MethodTranslation.txl"
include "StatementTranslation.txl"
include "ConstructorTranslation.txl"
include "EnumTranslation.txl"
include "ClassTranslation.txl"

%--------------------%
%     Top level      %
%--------------------%

function main
    replace [program] 
	 _[repeat package_statement] 
     _[repeat import_statement]
     Classes [repeat class_declaration]
    by
	Classes
        [replaceConcreteClassesWithInheritance] 
        [replaceConcreteClassesNoInheritance]
        [replaceInterfacesWithInheritance]
        [replaceInterfacesNoInheritance] 
end function

