@echo off
set PATH=%PATH%;C:\ant
set JAVA_HOME=C:\Program Files\java\jdk1.6.0_33
ant -buildfile build.xml
pause