pushd %~dp0..\build
echo Doing FULL build of Umple at \build using ant -Dmyenv=wlocal
echo Building repo at %cd%
echo This should take 9-12 minutes. Do not interrupt.
echo You should always have done 'git pull' before running this and resolved conflicts
ant -Dmyenv=wlocal
popd