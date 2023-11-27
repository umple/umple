cd %~dp0..\build
echo Building Umple User manual at %cd%
ant -Dmyenv=local -f build.umple.xml packageDocs