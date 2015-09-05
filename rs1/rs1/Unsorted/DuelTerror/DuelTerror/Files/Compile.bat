@echo off
cd Files
javac mudclient.java
jar -c *.class > Terror.jar
pause