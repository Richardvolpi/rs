@echo off
javac -classpath .;../rscd.jar *.java
cd startup
javac -classpath .;../../rscd.jar *.java
pause