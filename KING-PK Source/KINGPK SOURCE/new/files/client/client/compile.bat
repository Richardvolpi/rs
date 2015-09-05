@echo off
set PATH=%PATH%;C:\apache-ant-1.7.0\bin
set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_10
ant -buildfile build.xml
cls
ant
pause