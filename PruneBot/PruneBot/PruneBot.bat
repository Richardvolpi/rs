@echo off
title PruneBot
java -classpath rscd.jar;conf/;conf/rsca/;conf/rscd;scripts;scripts/startup;lib/xpp3.jar;lib/xstream.jar;lib/hex-string.jar; org.rscdaemon.client.mudclient
pause