@echo off
title RscaBot
java -classpath client.jar;rscd.jar;conf/;conf/rsca/;conf/rscd;scripts;scripts/startup;lib/xpp3.jar;lib/xstream.jar;lib/hex-string.jar; org.rscdaemon.client.mudclient
pause