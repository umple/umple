pushd %~dp0..\build
echo Running basic tests in %cd% using template.test
echo This does not run the testbed tests. Do a full build for those.
ant -Dmyenv=wlocal -f build.umple.xml template.test
echo If the word FAILED or ERROR was found in the above. Build was NOT SUCCESSFUL.
echo Test log can be opened in a web browser at %~dp0..\dist\qa\index.php
popd