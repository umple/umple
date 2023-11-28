cd %~dp0..\build
echo Doing FIRST build of Umple at %cd% using ant -Dmyenv=$buildenv
echo This resets dependencies and is needed only after installing a fresh repo or
echo or to clean up.
echo This should take 1-2 minutes and does not run tests. Do not interrupt. Then do full build
echo You should always have done 'git pull' before running this and resolved conflicts
ant -Dmyenv=wlocal first-build