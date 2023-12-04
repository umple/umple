cd %~dp0..\build
echo Building Umple User manual at %cd%
ant -Dmyenv=wlocal -f build.umple.xml packageDocs