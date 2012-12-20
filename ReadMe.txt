This is the main directory for various Umple subprojects

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

    examples
         Examples of Umple that the Umple team itself is managing
    externalexamples
         Products that use Umple that we have allowed to be managed here
         The idea is that they serve as extra tests

    dist ***
       Main products to be distributed after a build
       cruise.umple/reference - the user manual (needs also some umplewww pages)
       qa - test reports 
       umple.jar - main command line compiler - the latest also stored in releases
       umpledocs.jar - generates the user manual
       umplestats.jar - generates statistics
       umplesync.jar - used by UmpleOnline to synchronize graphical form
       vml.jar - an extension for variability modeling

    lib
       Elements the Umple build depends on

    releases
       Historical and current versions of the Umple compiler
    
    sandbox

    testbed -> Major testing examples
    testbed_php
    testbed_ruby

    UmpleToJava -> Code generation for Java
    UmpleToPhp  -> Code generation for Php
    UmpleToRuby -> Code generation for Ruby
    UmpleTCpp   -> Code generation for C++ - not yet ready / initialized with Java gen
    UmpleToTemplate -> Template for creating new code generation subprojects
        
    umpleonline -> The UmpleOnline web application, which allows generation of code
        from Umple directly in a web browser, and also editing of Umple both graphically
        and textually. This is online at http://try.umple.org

    umpleUI*
        Projects for the UIGU tools for generating a UI from Umple
        These need work to incorporate them into UmpleOnline
        
    umplewww -> Core files from the Umple.org web pages, such as the user manual
        these are moved at build time into their appropriate places
 
     Umplificator
        Software being created to reverse engineer code to Umple