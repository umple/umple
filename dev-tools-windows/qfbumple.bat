cd %~dp0..\build
echo Doing quick build of Umple and its jars at %cd% ( codegen umpleParser rtcpp umpleSelf compile packageJars )
echo This should take 12-25 seconds. Do not interrupt
echo You should always have done 'git pull' before running this and have resolved conflicts
ant -Dmyenv=wlocal -f build.umple.xml codegen umpleParser rtcpp umpleSelf compile packageJars
