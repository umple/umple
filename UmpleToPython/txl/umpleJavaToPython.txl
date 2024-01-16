%The main TXL file. Imports all other files and runs the main function

include "Python.Grm"
include "ImportProcessing.txl"
include "ListTranslation.txl"
include "MethodTranslation.txl"
include "StatementTranslation.txl"
include "ClassTranslation.txl"
include "CommentTranslation.txl"
%--------------------%
%     Top level      %
%--------------------%
%Main function runs the functions to translate every type of class/interface
%Note that the TXL currently makes the assumption that 1 file = 1 class/interface
function main
    replace [program]
    Jcomment1 [repeat comment_NL]
	 _[repeat package_statement]
    Jcomment2 [repeat comment_NL]
     Imports [repeat import_statement]
    Jcomment3 [repeat comment_NL]
     classes [repeat class_declaration]

    export Imports
    by
    Jcomment1[pycomments]
    Jcomment2[pycomments]
    Jcomment3[pycomments]
	classes
        [replaceInnerClasses]
        [replaceConcreteClasses]
        [replaceInterfaces]
        [replaceAbstractClass]
        [pycomments]
end function