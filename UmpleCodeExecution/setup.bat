@echo off
setlocal enabledelayedexpansion

set "CURRENT_DIR=%CD%"
for %%I in ("%CURRENT_DIR%\..") do set "BASEDIR=%%~fI"

echo Running setup.bat for code execution in %CURRENT_DIR%

for /f "tokens=1,* delims==" %%a in (config.cfg) do (
    set "%%a=%%b"
)

echo This process will kill and remove any existing my%mainContainerName% container (ignore any error if not already running)
echo Then it will (re)build docker images for executing code from UmpleOnline
echo Then it will start the container on port %portToUse%
echo If docker requires running with sudo, then so will this script
echo Use argument bg to make it work in the background

REM KILL EXISTING CONTAINER
docker container kill my%mainContainerName%
docker container rm my%mainContainerName%
docker rmi -f %mainContainerName%
docker container kill my%tempContainerName%
docker container rm my%tempContainerName%
docker rmi -f %tempContainerName%

REM BUILD DOCKERFILES
docker build -t %mainContainerName% .
docker build -t %tempContainerName% -f javaRunner/Dockerfile .

REM RUN MAIN CONTAINER
set "portmap=-p 0.0.0.0:%portToUse%:4400"
set "netcommand="

if "%portToUse%"=="4409" (
  set "portmap="
  set "netcommand=--network=container:umpleonline_local"
)

echo %BASEDIR%%umplePath%:/usr/src/app/models/ -v %BASEDIR%%tempPath%:/usr/src/app/output/

if "%~1"=="bg" (
  docker run --restart=unless-stopped --name my%mainContainerName% %netcommand% -v /var/run/docker.sock:/var/run/docker.sock -v "%BASEDIR%%umplePath%:/usr/src/app/models/" -v "%CURRENT_DIR%/%tempPath%:/usr/src/app/output/" %portmap% -e BASE_DIR=%BASEDIR%  %mainContainerName% >nul 2>&1
) else (
  docker run --restart=unless-stopped --name my%mainContainerName% %netcommand% -v /var/run/docker.sock:/var/run/docker.sock -v "%BASEDIR%%umplePath%:/usr/src/app/models/" -v "%CURRENT_DIR%/%tempPath%:/usr/src/app/output/" %portmap% -e BASE_DIR=%BASEDIR% %mainContainerName%
)