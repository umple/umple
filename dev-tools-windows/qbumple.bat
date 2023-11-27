cd %~dp0..\build
echo Doing quick build of Umple at %cd% ( codegen umpleParser rtcpp umpleSelf compile packageMainJar )
echo This should take 10-20 seconds. Do not interrupt
echo This only builds the main command line jar, not umplesync.jar, for that use qfbumple
echo You should always have done 'git pull' before running this and have resolved conflicts
ant -Dmyenv=wlocal -f build.umple.xml codegen umpleParser rtcpp umpleSelf compile packageMainJar
