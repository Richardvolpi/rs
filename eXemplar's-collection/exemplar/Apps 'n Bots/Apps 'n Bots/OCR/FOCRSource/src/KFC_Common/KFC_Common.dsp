# Microsoft Developer Studio Project File - Name="KFC_Common" - Package Owner=<4>
# Microsoft Developer Studio Generated Build File, Format Version 6.00
# ** DO NOT EDIT **

# TARGTYPE "Win32 (x86) Static Library" 0x0104

CFG=KFC_Common - Win32 Release
!MESSAGE This is not a valid makefile. To build this project using NMAKE,
!MESSAGE use the Export Makefile command and run
!MESSAGE 
!MESSAGE NMAKE /f "KFC_Common.mak".
!MESSAGE 
!MESSAGE You can specify a configuration when running NMAKE
!MESSAGE by defining the macro CFG on the command line. For example:
!MESSAGE 
!MESSAGE NMAKE /f "KFC_Common.mak" CFG="KFC_Common - Win32 Release"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "KFC_Common - Win32 Release" (based on "Win32 (x86) Static Library")
!MESSAGE "KFC_Common - Win32 Debug" (based on "Win32 (x86) Static Library")
!MESSAGE 

# Begin Project
# PROP AllowPerConfigDependencies 0
# PROP Scc_ProjName ""
# PROP Scc_LocalPath ""
CPP=cl.exe
RSC=rc.exe

!IF  "$(CFG)" == "KFC_Common - Win32 Release"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 0
# PROP BASE Output_Dir "Release"
# PROP BASE Intermediate_Dir "Release"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 0
# PROP Output_Dir ".."
# PROP Intermediate_Dir "Release"
# PROP Target_Dir ""
# ADD BASE CPP /nologo /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_MBCS" /D "_LIB" /YX /FD /c
# ADD CPP /nologo /MD /W3 /GR /GX /O2 /I ".." /D "WIN32" /D "NDEBUG" /D "_MBCS" /D "_LIB" /Yu"kfc_common_pch.h" /FD /c
# ADD BASE RSC /l 0x409 /d "NDEBUG"
# ADD RSC /l 0x409 /d "NDEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
LIB32=link.exe -lib
# ADD BASE LIB32 /nologo
# ADD LIB32 /nologo

!ELSEIF  "$(CFG)" == "KFC_Common - Win32 Debug"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 1
# PROP BASE Output_Dir "Debug"
# PROP BASE Intermediate_Dir "Debug"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 1
# PROP Output_Dir ".."
# PROP Intermediate_Dir "Debug"
# PROP Target_Dir ""
# ADD BASE CPP /nologo /W3 /Gm /GX /ZI /Od /D "WIN32" /D "_DEBUG" /D "_MBCS" /D "_LIB" /YX /FD /GZ /c
# ADD CPP /nologo /MDd /W3 /Gm /GR /GX /ZI /Od /I ".." /D "WIN32" /D "_DEBUG" /D "_MBCS" /D "_LIB" /Yu"kfc_common_pch.h" /FD /GZ /c
# ADD BASE RSC /l 0x409 /d "_DEBUG"
# ADD RSC /l 0x409 /d "_DEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
LIB32=link.exe -lib
# ADD BASE LIB32 /nologo
# ADD LIB32 /nologo

!ENDIF 

# Begin Target

# Name "KFC_Common - Win32 Release"
# Name "KFC_Common - Win32 Debug"
# Begin Group "Source Files"

# PROP Default_Filter "cpp;c;cxx;rc;def;r;odl;idl;hpj;bat"
# Begin Source File

SOURCE=.\2d_math.cpp
# End Source File
# Begin Source File

SOURCE=.\assignments.cpp
# End Source File
# Begin Source File

SOURCE=.\bmp.cpp
# End Source File
# Begin Source File

SOURCE=.\clipboard.cpp
# End Source File
# Begin Source File

SOURCE=.\cmd_line.cpp
# End Source File
# Begin Source File

SOURCE=.\com.cpp
# End Source File
# Begin Source File

SOURCE=.\common_cfg.cpp
# End Source File
# Begin Source File

SOURCE=.\common_consts.cpp
# End Source File
# Begin Source File

SOURCE=.\common_device_globals.cpp
# End Source File
# Begin Source File

SOURCE=.\common_globals.cpp
# End Source File
# Begin Source File

SOURCE=.\common_initials.cpp
# End Source File
# Begin Source File

SOURCE=.\common_tokens.cpp
# End Source File
# Begin Source File

SOURCE=.\critical_section.cpp
# End Source File
# Begin Source File

SOURCE=.\dll.cpp
# End Source File
# Begin Source File

SOURCE=.\event.cpp
# End Source File
# Begin Source File

SOURCE=.\file.cpp
# End Source File
# Begin Source File

SOURCE=.\file_validation.cpp
# End Source File
# Begin Source File

SOURCE=.\global_mem.cpp
# End Source File
# Begin Source File

SOURCE=.\handle.cpp
# End Source File
# Begin Source File

SOURCE=.\hooks.cpp
# End Source File
# Begin Source File

SOURCE=.\image.cpp
# End Source File
# Begin Source File

SOURCE=.\install.cpp
# End Source File
# Begin Source File

SOURCE=.\interpolator.cpp
# End Source File
# Begin Source File

SOURCE=.\interpolator_message_defs.cpp
# End Source File
# Begin Source File

SOURCE=.\kfc_common_pch.cpp
# ADD CPP /Yc"kfc_common_pch.h"
# End Source File
# Begin Source File

SOURCE=.\kfc_common_test.cpp
# End Source File
# Begin Source File

SOURCE=.\math_consts.cpp
# End Source File
# Begin Source File

SOURCE=.\matrix.cpp
# End Source File
# Begin Source File

SOURCE=.\memory_stream.cpp
# End Source File
# Begin Source File

SOURCE=.\mesh.cpp
# End Source File
# Begin Source File

SOURCE=.\message.cpp
# End Source File
# Begin Source File

SOURCE=.\message_loop.cpp
# End Source File
# Begin Source File

SOURCE=.\module.cpp
# End Source File
# Begin Source File

SOURCE=.\module_resource.cpp
# End Source File
# Begin Source File

SOURCE=.\msg_box.cpp
# End Source File
# Begin Source File

SOURCE=.\mutex.cpp
# End Source File
# Begin Source File

SOURCE=.\obscure.cpp
# End Source File
# Begin Source File

SOURCE=.\pow2.cpp
# End Source File
# Begin Source File

SOURCE=.\process.cpp
# End Source File
# Begin Source File

SOURCE=.\random_globals.cpp
# End Source File
# Begin Source File

SOURCE=.\registry.cpp
# End Source File
# Begin Source File

SOURCE=.\resource_enumerator.cpp
# End Source File
# Begin Source File

SOURCE=.\resource_updater.cpp
# End Source File
# Begin Source File

SOURCE=.\rgb.cpp
# End Source File
# Begin Source File

SOURCE=.\rpc_message_registerer.cpp
# End Source File
# Begin Source File

SOURCE=.\service.cpp
# End Source File
# Begin Source File

SOURCE=.\shortcut.cpp
# End Source File
# Begin Source File

SOURCE=.\startup_globals.cpp
# End Source File
# Begin Source File

SOURCE=.\structured_info.cpp
# End Source File
# Begin Source File

SOURCE=.\tga.cpp
# End Source File
# Begin Source File

SOURCE=.\time_globals.cpp
# End Source File
# Begin Source File

SOURCE=.\timelimit.cpp
# End Source File
# Begin Source File

SOURCE=.\timer.cpp
# End Source File
# Begin Source File

SOURCE=.\vector.cpp
# End Source File
# Begin Source File

SOURCE=.\version.cpp
# End Source File
# Begin Source File

SOURCE=.\window_timer.cpp
# End Source File
# End Group
# Begin Group "Header Files"

# PROP Default_Filter "h;hpp;hxx;hm;inl"
# Begin Source File

SOURCE=.\2d_math.h
# End Source File
# Begin Source File

SOURCE=.\assignments.h
# End Source File
# Begin Source File

SOURCE=.\bmp.h
# End Source File
# Begin Source File

SOURCE=.\clipboard.h
# End Source File
# Begin Source File

SOURCE=.\cmd_line.h
# End Source File
# Begin Source File

SOURCE=.\com.h
# End Source File
# Begin Source File

SOURCE=.\common_cfg.h
# End Source File
# Begin Source File

SOURCE=.\common_consts.h
# End Source File
# Begin Source File

SOURCE=.\common_device_globals.h
# End Source File
# Begin Source File

SOURCE=.\common_globals.h
# End Source File
# Begin Source File

SOURCE=.\common_initials.h
# End Source File
# Begin Source File

SOURCE=.\common_tokens.h
# End Source File
# Begin Source File

SOURCE=.\const.h
# End Source File
# Begin Source File

SOURCE=.\critical_section.h
# End Source File
# Begin Source File

SOURCE=.\delay_load.h
# End Source File
# Begin Source File

SOURCE=.\dll.h
# End Source File
# Begin Source File

SOURCE=.\event.h
# End Source File
# Begin Source File

SOURCE=.\file.h
# End Source File
# Begin Source File

SOURCE=.\file_validation.h
# End Source File
# Begin Source File

SOURCE=.\global_mem.h
# End Source File
# Begin Source File

SOURCE=.\handle.h
# End Source File
# Begin Source File

SOURCE=.\hooks.h
# End Source File
# Begin Source File

SOURCE=.\image.h
# End Source File
# Begin Source File

SOURCE=.\install.h
# End Source File
# Begin Source File

SOURCE=.\interpolator.h
# End Source File
# Begin Source File

SOURCE=.\interpolator_defs.h
# End Source File
# Begin Source File

SOURCE=.\interpolator_macros.h
# End Source File
# Begin Source File

SOURCE=.\interpolator_message_defs.h
# End Source File
# Begin Source File

SOURCE=.\interpolator_message_map.h
# End Source File
# Begin Source File

SOURCE=.\kfc_common_api.h
# End Source File
# Begin Source File

SOURCE=.\kfc_common_pch.h
# End Source File
# Begin Source File

SOURCE=.\math_consts.h
# End Source File
# Begin Source File

SOURCE=.\matrix.h
# End Source File
# Begin Source File

SOURCE=.\memory_stream.h
# End Source File
# Begin Source File

SOURCE=.\mesh.h
# End Source File
# Begin Source File

SOURCE=.\message.h
# End Source File
# Begin Source File

SOURCE=.\message_loop.h
# End Source File
# Begin Source File

SOURCE=.\module.h
# End Source File
# Begin Source File

SOURCE=.\module_resource.h
# End Source File
# Begin Source File

SOURCE=.\msg_box.h
# End Source File
# Begin Source File

SOURCE=.\mutex.h
# End Source File
# Begin Source File

SOURCE=.\obscure.h
# End Source File
# Begin Source File

SOURCE=.\persistence_factory.h
# End Source File
# Begin Source File

SOURCE=.\pow2.h
# End Source File
# Begin Source File

SOURCE=.\process.h
# End Source File
# Begin Source File

SOURCE=.\random_globals.h
# End Source File
# Begin Source File

SOURCE=.\registry.h
# End Source File
# Begin Source File

SOURCE=.\resource_enumerator.h
# End Source File
# Begin Source File

SOURCE=.\resource_updater.h
# End Source File
# Begin Source File

SOURCE=.\rgb.h
# End Source File
# Begin Source File

SOURCE=.\rpc_message_registerer.h
# End Source File
# Begin Source File

SOURCE=.\service.h
# End Source File
# Begin Source File

SOURCE=.\shortcut.h
# End Source File
# Begin Source File

SOURCE=.\startup_globals.h
# End Source File
# Begin Source File

SOURCE=.\storage.h
# End Source File
# Begin Source File

SOURCE=.\structured_info.h
# End Source File
# Begin Source File

SOURCE=.\synched_value.h
# End Source File
# Begin Source File

SOURCE=.\tga.h
# End Source File
# Begin Source File

SOURCE=.\time_globals.h
# End Source File
# Begin Source File

SOURCE=.\timelimit.h
# End Source File
# Begin Source File

SOURCE=.\timer.h
# End Source File
# Begin Source File

SOURCE=.\vector.h
# End Source File
# Begin Source File

SOURCE=.\version.h
# End Source File
# Begin Source File

SOURCE=.\window_timer.h
# End Source File
# End Group
# End Target
# End Project
