pushd %~dp0..\build
echo Minifying Umple scripts also done as part of pumple
ant  -f build.umple.xml compressAllScripts
popd