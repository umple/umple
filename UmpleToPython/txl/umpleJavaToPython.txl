include "Python.Grm"
include "BooleanTranslation.txl"
include "ImportProcessing.txl"
include "ListTranslation.txl"
include "MethodTranslation.txl"
include "StatementTranslation.txl"
include "EnumTranslation.txl"
include "ClassTranslation.txl"

%--------------------%
%     Top level      %
%--------------------%

function main
    replace [program] 
	 _[repeat package_statement] 
     Imports [repeat import_statement]
     classes [repeat class_declaration]
    export Imports
    by
	classes
        [replaceConcreteClassesWithInheritance] 
        [replaceInterfacesWithInheritance]
end function

