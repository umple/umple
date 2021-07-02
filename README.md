# Umple Modelling Language

### Build Status

OS         | Linux  | OSX    | Linux Jenkins | Windows Appveyor |  
:--------- | ------ | ------ | ------------- | ---------------- |
**Status** | [![Travis-CI Build Status](https://travis-ci.com/umple/umple.svg?branch=master)](https://travis-ci.com/umple/umple) | [![Travis-CI Build Status](https://travis-ci.com/umple/umple.svg?branch=master)](https://travis-ci.com/umple/umple) | [![Jenkins Linux Build status](https://jenkins.umple.org/job/Umple/lastSuccessfulBuild/badge/icon?subject=Jenkins%2FLinux&build=lastCompleted:${params.BRANCH=master})](https://jenkins.umple.org/job/Umple/lastSuccessfulBuild?subject=Jenkins%2FLinux&build=lastCompleted:${params.BRANCH=master}) | [![Windows Build status](https://ci.appveyor.com/api/projects/status/1yetvadynui7r8y6?svg=true)](https://ci.appveyor.com/project/vahdat-ab/umple/branch/master) 


## Description

This is the main project for various Umple subprojects and components.

Umple is a model-oriented programming technology, allowing developers to embed modelling concepts (e.g. UML associations, state machines), patterns, generation templates, and other abstractions in traditional code, and vice versa. It generates high quality code for Java, C++ and PhP, as well as diagrams, metrics and many other artifacts. It can be embeded in the above languages as well as embed them.

The project homepage is located at http://umple.org/

There are a large number of scientific papers about Umple listed at: http://publications.umple.org

Cite the overall project as: Timothy C. Lethbridge, Andrew Forward, Omar Badreddin, Dusan Brestovansky, Miguel Garzon, Hamoud Aljamaan, Sultan Eid, Ahmed Husseini Orabi, Mahmoud Husseini Orabi, Vahdat Abdelzad, Opeyemi Adesina, Aliaa Alghamdi, Abdulaziz Algablan, Amid Zakariapour,
"Umple: Model-Driven Development for Open Source and Education", _Science of Computer Programming_, 2021, https://doi.org/10.1016/j.scico.2021.102665.

Cite latest software release as: University of Ottawa, Umple, http://releases.umple.org  https://doi.org/10.5281/zenodo.4677562   [![DOI](https://zenodo.org/badge/41397174.svg)](https://zenodo.org/badge/latestdoi/41397174)

## Development Process
Umple is developed in itself, guaranteeing robustness; the most recent version of the compiler must be used to compile itself. See the wiki for development setup: http://devsetup.umple.org

Development follows a model-driven, test-driven, agile, continuous-integration process. Umple is hosted currently on Github at http://code.umple.org. It was first released in 2007. The master was on Google Code from 2011 to mid 2015 and moved to Github in 2015.

Umple has been largely developed as a research project at the University of Ottawa, Canada, by numerous PhD and masters students. Many undergraduates from across Canada and the USA have also contributed through the UCOSP program. See the license file for the list of contributors. http://license.umple.org

## Installation and Downloading

Umple does not need necessarily to be downloaded, the following allow you to run it directly in any web browser:

  * UmpleOnline: http://try.umple.org - Website for the GUI version of Umple 
  * Docker: http://docker.umple.org - Install a docker image to run the GUI directly

You can download the java jar for command-line use, or the Eclipse plugin:

  * Download page: http://dl.umple.org    - Links to the latest official release and continuous builds (command-line, Eclipse, Docker)
  
To run locally on your machine, Umple needs Java (versions 8-13) installed. It runs on Mac, Linux and Windows.
  
## Usage

Umple is a programming and modeling language with a rich syntax. Full documentation with many examples can be found at 

  * Umple user manual: http://manual.umple.org 

## Other Key links

  * Umple home page: http://www.umple.org  - The master Umple page with a more comprehensive set of links
  *  - Full documentation of all Umple features
  * Live diagram of the metamodel: http://metamodel.umple.org
  * Architecture: http://architecture.umple.org

Umple is continuously tested and built at the University of Ottawa using CruiseControl; see http://cc.umple.org . It is also built on Travis CI (http://travis.umple.org/) and Appveyor (https://appveyor.com/).

## Contributing

  * Please report any bugs or improvement requests at: http://bugs.umple.org
  * To set up your development environment please see: http://devsetup.umple.org
  * For more details on contributing, please see: https://github.com/umple/umple/blob/master/CONTRIBUTING.md

## License

Umple is licensed under the MIT license. See http://license.umple.org

## Credits

All developers of Umple are listed in the license file at http://license.umple.org

Financial support has been received from NSERC and the Ontario Research Fund. IBM supported early development of Umple. Google and Facebook supported student travel during Umple's development. 

## Contents of the directories

The umple project is split into many smaller subprojects; the folder hierarchy is explained below to better describe the structure.

* build/
  * Ant build scripts and related information including user manual raw data

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
  * umple.jar and umple.VERSION.jar  *Current command-line Compiler* 
  * umpledocs.VERSION.jar *User manual generator*
  * umplestats.VERSION.jar *Statistics generation*
  * umplesync.VERSION.jar *UmpleOnline tool to to synchronize graphical form*
  * umplerun.VERSION.jar *tool to drive input to an umple program*
  * vml.VERSION.jar * Extension for variability modeling*
  * umple.unit-test.jar *Test Language Compiler*
  * umple.mutation.jar *Umple Mutant Generator*

* examples/ *Developer curated examples*
* externalexamples/ *External projects that are used for testing*

* ExternalTextEditorPlugins *Plugins for external editors, Notepad++, etc*

* sandbox *Small test done before a build to make sure testing and compiling works*

* testbed/, testbed_php/, testbed_ruby/ *Test suites for Java, Php and Ruby respectively*
* UmpleToJava/ *Code generation for Java*
* UmpleToPhp/ *Code generation for Php*
* UmpleToRuby/ *Code generation for Ruby*
* UmpleToRTCpp/ *Code generation for C++ *
* UmpleToSDL/ *Code generation to convert Umple to SDL* (in early development)
* UmpleToSql/ *Code generation SQL from Umple models*
* UmpleToTest/ *Code generation for abstract tests*
* UmpleToTemplate/ *Location for templates that could be common to subprojects*
* UmpleTToJunit/ *Code Generation for JUnit5 - used by MTL compiler*
* UmpleTToPhpunit/ *Code Generation for PhpUnit - used by MTL compiler*
* UmpleTToRubyunit/ *Code Generation for RubyUnit - used by MTL compiler*
* umpleonline/ *The UmpleOnline web application*
  * UmpleOnline allows generation of code from Umple directly in a web browser, and also editing of Umple both graphically and textually. Available at http://try.umple.org

 
* Umplificator/ *Reverse engineer code to Umple*
* umplificatoronline/ *Online tool for converting code to Umple*

* umpleUI/ *Projects for the UIGU tooling*
  * Projects for generating a UI through UIGU from Umple. These need work to incorporate them into UmpleOnline
        
* umplewww/ *Core files from the Umple.org web pages*
  * Includes items such as the user manual that are moved at build time into the appropriate place
