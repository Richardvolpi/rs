@echo off
echo ===== Unobfuscating with Zelix =====
java -jar zelix\ZKM.jar zelix\rs2.txt
del /q ZKM_log.txt
del /q ChangeLog.txt
del *.BACKUP
echo ===== Extracting with 7zip =====
7zip\7za e -r rs.jar
del /q rs.jar
echo ===== Dissasembling with KJC =====
java -cp KJC/kjc-suite-2.1B-bin.jar at.dms.dis.Main *.class
del /q *.class
echo ===== Definalizing and Publicizing =====
java -cp prepare prepare . ksm
echo ===== Assembling with KJC =====
java -cp ./KJC/kjc-suite-2.1B-bin.jar at.dms.ksm.Main *.ksm
del /q *.ksm
echo ===== Adding Files to RS.Jar =====
7zip\7za a rs.jar *.class sign/*.class
del /q *.class
del /q *.MF
rmdir /s /q sign
echo Finished Preparing RS.Jar!
pause