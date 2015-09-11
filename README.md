#Umple Modelling Language

[![Build Status](https://travis-ci.org/umple-ucosp/umple.svg?branch=master)](https://travis-ci.org/umple-ucosp/umple)

##Introduction

This is the main project for various Umple subprojects and components.

Umple is a model-oriented programming technology. It allows developers to embed modelling concepts (e.g. associations, state machines), patterns and other abstractions in traditional code, and vice versa. It generates high quality code for Java, C++ and PhP (and can be embedded in or embed these), as well as diagrams, metrics and many other artifacts.

The project homepage is located at http://umple.org/

##Development
Umple is developed in itself, guaranteeing robustness, the most recent version of the compiler must be used to compile itself. See the wiki for development setup.

Development follows a model-driven, test-driven, agile, continuous-integration process. Umple is hosted currently on Github at http://code.umple.org. It was first released in 2007, and the master was on Google Code from 2011 to 2015.

Umple has been largely developed as a research project at the University of Ottawa, Canada, by numerous PhD and masters students, Many undergraduates from across Canada and the USA have also contributed. See the license file for the list of contributors.

More details can be found as follows

  * Umple home page: http://www.umple.org
  * Umple user manual: http://manual.umple.org
  * Download page: http://dl.umple.org
  * Live diagram of the metamodel: http://metamodel.umple.org
  * Architecture: http://architecture.umple.org

Umple is continuously tested and build on Travis CI (https://travis-ci.org/). (This is under review: See http://cc.umple.org for a movable link to the CI server)
 
###Project setup

The umple project is split into many smaller subproject, the folder hierarchy is explained below to better describe the structure.

* build/
  * Ant build scripts and related information

* cruise.umple/ *Umple compiler*
  * See its own ReadMe.txt for further details
  * See also UmpleTo* below for additional compiler components
       
* cruise.umple.eclipse/, cruise.umple.xtext.ui/ *Eclipse plugins*

* cruise.umplificator *Converting outside code to Umple*
  * cruise.umple.validator *Validates umple when umplifying*

* cruise.umple.nebula *Infrastructure used for real-time C++*

* dev-tools *Tooling for Umple developers*
       
* dist *Build produced items, only available after building*
  * libs/ *Managed build dependencies that umple*.jar require to run* 
  * cruise.umple/reference *User manual* 
  * qa/ *Test reports* 
  * umple.jar *Command-line Compiler* 
  * umpledocs.jar *User manual generator*
  * umplestats.jar *Statistics generation*
  * umplesync.jar *UmpleOnline tool to to synchronize graphical form*
  * vml.jar * Extension for variability modeling*

* examples/ *Developer curated examples*
* externalexamples/ *External projects that are used for testing*

* ExternalTextEditorPlugins *Plugins for external editors, Notepad++, etc*

* sandbox *What is this?*

* testbed/, testbed_php/, testbed_ruby/ *Test suites for Java, Php and Ruby respectively*
* UmpleToJava/ *Code generation for Java*
* UmpleToPhp/ *Code generation for Php*
* UmpleToRuby/ *Code generation for Ruby*
* UmpleToRTCpp/ *Code generation for Real-time C++ *
* ~~UmpleToCpp/~~ *Code generation for alternative C++ - historical; to be deleted
* UmpleToSDL/ *Code generation to convert Umple to SDL*
* UmpleToSql/ *Code generation SQL from Umple models*
* UmpleToTemplate/ *Template for creating new code generation subprojects*

* umpleonline/ *The UmpleOnline web application*
  * UmpleOnline allows generation of code from Umple directly in a web browser, and also editing of Umple both graphically and textually. Available at http://try.umple.org

 
* Umplificator/ *Reverse engineer code to Umple*
* umplificatoronline/ *Online tool for converting code to Umple*

* umpleUI/ *Projects for the UIGU tooling*
  * Projects for generating a UI through UIGU from Umple. These need work to incorporate them into UmpleOnline
        
* umplewww/ *Core files from the Umple.org web pages*
  * Includes items such as the user manual that are moved at build time into the appropriate place
