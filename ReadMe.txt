This is the main directory for various Umple subprojects and components.

Umple is a model-oriented programming technology. It allows developers to embed modelling concepts (e.g. associations, state machines), patterns and other abstractions in traditional code, and vice versa. It generates high quality code for Java, C++ and PhP (and can be embedded in or embed these), as well as diagrams, metrics and many other artifacts.

Umple is developed in itself, guaranteeing robustness, hence the Umple compiler has to be distributed with the source (in the releases directory).

Development follows a model-driven, test-driven, agile, continuous-integration process. Umple is hosted currently on Google Code at http://code.umple.org. It is mirrored on Github at https://github.com/umple/Umple and at SourceForge at https://sourceforge.net/projects/umple/ 

Umple has been largely developed as a research project at the University of Ottawa, Canada, by numerous PhD and masters students, Many undergraduates from across Canada have also contributed. See the license file for the list of contributors.

More details can be found as follows
  * Umple home page: http://www.umple.org
  * Umple user manual: http://manual.umple.org
  * Download page: http://dl.umple.org
  * Live diagram of the metamodel: http://metamodel.umple.org
  * Architecture: http://architecture.umple.org

Umple is continuously tested and build on Travis CI (https://travis-ci.org/). 

Current build status: ![](https://travis-ci.org/Nava2/Umple.svg?branch=master)

The items below are in alphabetical order.

Items marked *** are created by the build process only and are not version controlled.
They are referenced here so that people can better understand the hierarchy of files whether or not they have built the system.

    build
      Ant build scripts and related information
      reference
          The user manual source oages, used to create the user manual
 
    cruise.umple -> The main Umple compiler
       See its own ReadMe.txt for further details
         See also UmpleTo* below for additional compiler components
       
    cruise.umple.eclipse
    cruise.umple.xtext.ui
       Code for the Eciipse plugins

    cruise.umplificator* - Tool for connverting code to Umple
    cruise.umple.validator - tool for validating umple when umplifying

    cruise.umple.nebula
       New code generation infrastructure used for real-timeC++

    dev-tools
       Scripts and other tools used to help developers of Umple itself
       
    dist ***
       Main products to be distributed after a build
       cruise.umple/reference - the user manual (needs also some umplewww pages)
       qa - test reports 
       umple.jar - main command line compiler - the latest also stored in releases
       umpledocs.jar - generates the user manual
       umplestats.jar - generates statistics
       umplesync.jar - used by UmpleOnline to synchronize graphical form
       vml.jar - an extension for variability modeling

    examples
         Examples of Umple that the Umple team itself is managing
    externalexamples
         Products that use Umple that we have allowed to be managed here
         The idea is that they serve as extra tests

    ExternalTextEditrPlugins
       plugins to text editing tools to allow them to do syntax highlighting with Umple or other more sophisticated Umple operations

    jopt-simple
       Fork of one of the very few packages (MIT-licensed) where we have borrowed code from others
       See http://pholser.github.io/jopt-simple/
    
    lib
       Elements the Umple build depends on
       The file umple.jar is used to bootstrap the build
          - It should be updated with major releases, and also preiodically
             in between

    releases
       Historical and current versions of the Umple compiler
    
    sandbox

    testbed -> Testing of generated code
    testbed_php
    testbed_ruby

    UmpleToJava -> Code generation for Java
    UmpleToPhp  -> Code generation for Php
    UmpleToRuby -> Code generation for Ruby
    UmpleToRTCpp -> Code generation for C++
    UmpleTCpp   -> Code generation for alternative C++ - historical; to be deleted
    UmpleToSDL -> Code generation to convert Umple to SDL
    UmpleToSql -> Code generation SQL from Umple models
    UmpleToTemplate -> Template for creating new code generation subprojects
        
    umpleonline -> The UmpleOnline web application, which allows generation of code
        from Umple directly in a web browser, and also editing of Umple both graphically
        and textually. This is online at http://try.umple.org

    umplificatoronline -> Online tool for converting code to Umple

    umpleUI*
        Projects for the UIGU tools for generating a UI from Umple
        These need work to incorporate them into UmpleOnline
        
    umplewww -> Core files from the Umple.org web pages, such as the user manual
        these are moved at build time into their appropriate places
 
     Umplificator
        Software being created to reverse engineer code to Umple