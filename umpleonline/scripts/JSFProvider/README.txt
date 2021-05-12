******************************************

UIGU 1.0 User Interface Generator for Umple
2010  Julian Solano

******************************************

The examples were tested with Tomcat 6 anf JBoss 5.0, however JBoss has built in some of the required libraries, to compile and deply the war file
for JBoss, open UmpleProject.xml and comment out the following line:

		<Directory  InputFolder="files/tomcat-libs" OutputSubFolder="WebContent/WEB-INF/lib" />

For other servers, Consult their documentation.


*****************************
To Run UIGU (no compilation)
*****************************
To use the outputFolder, umpleFile and name declared in the UmpleProject.xml file, use:

java -cp GUIModel.jar;JSFProvider.jar;GUIGenerator.jar cruise.generator.UIGU [xmlFile]

Example:

java -cp GUIModel.jar;JSFProvider.jar;GUIGenerator.jar cruise.generator.UIGU UmpleProject.xml


To overwrite these values, use:

java -cp GUIModel.jar;JSFProvider.jar;GUIGenerator.jar cruise.generator.UIGU [xmlFile] [umpleFile] [outputFolder] [projectName]


Example:

java -cp GUIModel.jar;JSFProvider.jar;GUIGenerator.jar cruise.generator.UIGU UmpleProject.xml examples/insurance.ump InsuranceApp Insurance

*****************************
To run and compile UIGU
*****************************

To use the outputFolder, umpleFile and name attributes declared in the UmpleProject.xml file, use:

ant -DxmlFile=[xmlFile]


Examle:
ant -DxmlFile=UmpleProject.xml


To overwrite these values, use:

ant -DxmlFile[xmlFile] -DumpleFile=[umpleFile] -DoutputFolder=[outputFolder] -DprojectName=[projectName]

Example:

ant -DxmlFile=UmpleProject.xml -DumpleFile="examples/school.ump" -DoutputFolder=SchoolApp -DprojectName=School
