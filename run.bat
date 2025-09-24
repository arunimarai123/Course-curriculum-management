@echo off
REM === Compile and Run CCRM Project ===

REM Change to project root (this script assumes it's placed in CCRMProject_Full folder)
cd /d %~dp0

REM Create bin directory if not exists
if not exist bin mkdir bin

echo Compiling Java sources...
javac -d bin ^
src\edu\ccrm\cli\*.java ^
src\edu\ccrm\domain\*.java ^
src\edu\ccrm\service\*.java ^
src\edu\ccrm\io\*.java ^
src\edu\ccrm\util\*.java ^
src\edu\ccrm\config\*.java ^
src\edu\ccrm\exception\*.java

if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b %errorlevel%
)

echo.
echo Running CCRM...
echo.

java -cp bin edu.ccrm.cli.MainCLI

pause
