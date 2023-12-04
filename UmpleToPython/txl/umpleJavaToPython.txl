%The main TXL file. Imports all other files and runs the main function

include "Python.Grm"
include "ImportProcessing.txl"
include "ListTranslation.txl"
include "MethodTranslation.txl"
include "StatementTranslation.txl"
include "ClassTranslation.txl"

%--------------------%
%     Top level      %
%--------------------%
%Main function runs the functions to translate every type of class/interface
%Note that the TXL currently makes the assumption that 1 file = 1 class/interface
function main
    replace [program]
	 _[repeat package_statement]
     Imports [repeat import_statement]
     classes [repeat class_declaration]
    export Imports
    by
	classes
        [replaceInnerClasses]
        [replaceConcreteClasses]
        [replaceInterfaces]
        [replaceAbstractClass]
end function
