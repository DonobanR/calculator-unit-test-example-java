@ECHO OFF
SETLOCAL

set "BASE_DIR=%~dp0"
set "BASE_DIR=%BASE_DIR:~0,-1%"
set "MAVEN_VERSION=3.9.15"
set "MAVEN_DIR=C:\Users\dopar\Downloads\apache-maven-3.9.15-bin\apache-maven-3.9.15"
set "MAVEN_BIN=%MAVEN_DIR%\bin\mvn.cmd"

if not exist "%MAVEN_BIN%" (
  echo Maven was not found at:
  echo %MAVEN_BIN%
  exit /b 1
)

call "%MAVEN_BIN%" %*
exit /b %ERRORLEVEL%
