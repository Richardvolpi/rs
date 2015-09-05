# Microsoft Developer Studio Project File - Name="KFC_KTL" - Package Owner=<4>
# Microsoft Developer Studio Generated Build File, Format Version 6.00
# ** DO NOT EDIT **

# TARGTYPE "Win32 (x86) Static Library" 0x0104

CFG=KFC_KTL - Win32 Release
!MESSAGE This is not a valid makefile. To build this project using NMAKE,
!MESSAGE use the Export Makefile command and run
!MESSAGE 
!MESSAGE NMAKE /f "KFC_KTL.mak".
!MESSAGE 
!MESSAGE You can specify a configuration when running NMAKE
!MESSAGE by defining the macro CFG on the command line. For example:
!MESSAGE 
!MESSAGE NMAKE /f "KFC_KTL.mak" CFG="KFC_KTL - Win32 Release"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "KFC_KTL - Win32 Release" (based on "Win32 (x86) Static Library")
!MESSAGE "KFC_KTL - Win32 Debug" (based on "Win32 (x86) Static Library")
!MESSAGE 

# Begin Project
# PROP AllowPerConfigDependencies 0
# PROP Scc_ProjName ""
# PROP Scc_LocalPath ""
CPP=cl.exe
RSC=rc.exe

!IF  "$(CFG)" == "KFC_KTL - Win32 Release"

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
# ADD CPP /nologo /MD /W3 /GR /GX /O2 /I ".." /D "WIN32" /D "NDEBUG" /D "_MBCS" /D "_LIB" /Yu"kfc_ktl_pch.h" /FD /c
# ADD BASE RSC /l 0x409 /d "NDEBUG"
# ADD RSC /l 0x409 /d "NDEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
LIB32=link.exe -lib
# ADD BASE LIB32 /nologo
# ADD LIB32 /nologo

!ELSEIF  "$(CFG)" == "KFC_KTL - Win32 Debug"

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
# ADD CPP /nologo /MDd /W3 /Gm /GR /GX /ZI /Od /I ".." /D "WIN32" /D "_DEBUG" /D "_MBCS" /D "_LIB" /Yu"kfc_ktl_pch.h" /FD /GZ /c
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

# Name "KFC_KTL - Win32 Release"
# Name "KFC_KTL - Win32 Debug"
# Begin Group "Source Files"

# PROP Default_Filter "cpp;c;cxx;rc;def;r;odl;idl;hpj;bat"
# Begin Source File

SOURCE=.\array.cpp
# End Source File
# Begin Source File

SOURCE=.\consts.cpp
# End Source File
# Begin Source File

SOURCE=.\date_time.cpp
# End Source File
# Begin Source File

SOURCE=.\debug.cpp
# End Source File
# Begin Source File

SOURCE=.\debug_file.cpp
# End Source File
# Begin Source File

SOURCE=.\debug_message_box.cpp
# End Source File
# Begin Source File

SOURCE=.\file_names.cpp
# End Source File
# Begin Source File

SOURCE=.\flag_setter.cpp
# End Source File
# Begin Source File

SOURCE=.\globals.cpp
# End Source File
# Begin Source File

SOURCE=.\globals_collector.cpp
# End Source File
# Begin Source File

SOURCE=.\hex.cpp
# End Source File
# Begin Source File

SOURCE=.\kfc_ktl_pch.cpp
# ADD CPP /Yc"kfc_ktl_pch.h"
# End Source File
# Begin Source File

SOURCE=.\kfc_ktl_test.cpp
# End Source File
# Begin Source File

SOURCE=.\kfc_mem.cpp
# End Source File
# Begin Source File

SOURCE=.\kstring.cpp
# End Source File
# Begin Source File

SOURCE=.\kstrings.cpp
# End Source File
# Begin Source File

SOURCE=.\ktl_consts.cpp
# End Source File
# Begin Source File

SOURCE=.\ktl_globals.cpp
# End Source File
# Begin Source File

SOURCE=.\ktl_tokens.cpp
# End Source File
# Begin Source File

SOURCE=.\list.cpp
# End Source File
# Begin Source File

SOURCE=.\module_globals.cpp
# End Source File
# Begin Source File

SOURCE=.\placement_allocation.cpp
# End Source File
# Begin Source File

SOURCE=.\rects.cpp
# End Source File
# Begin Source File

SOURCE=.\string_conv.cpp
# End Source File
# Begin Source File

SOURCE=.\suspendable.cpp
# End Source File
# Begin Source File

SOURCE=.\text_container.cpp
# End Source File
# Begin Source File

SOURCE=.\token.cpp
# End Source File
# Begin Source File

SOURCE=.\tree.cpp
# End Source File
# Begin Source File

SOURCE=.\variable_list.cpp
# End Source File
# End Group
# Begin Group "Header Files"

# PROP Default_Filter "h;hpp;hxx;hm;inl"
# Begin Source File

SOURCE=.\alignment.h
# End Source File
# Begin Source File

SOURCE=.\array.h
# End Source File
# Begin Source File

SOURCE=.\basic_bitypes.h
# End Source File
# Begin Source File

SOURCE=.\basic_types.h
# End Source File
# Begin Source File

SOURCE=.\basic_wintypes.h
# End Source File
# Begin Source File

SOURCE=.\bounding.h
# End Source File
# Begin Source File

SOURCE=.\consts.h
# End Source File
# Begin Source File

SOURCE=.\data_alignment.h
# End Source File
# Begin Source File

SOURCE=.\date_time.h
# End Source File
# Begin Source File

SOURCE=.\debug.h
# End Source File
# Begin Source File

SOURCE=.\debug_file.h
# End Source File
# Begin Source File

SOURCE=.\debug_message_box.h
# End Source File
# Begin Source File

SOURCE=.\factory.h
# End Source File
# Begin Source File

SOURCE=.\file_names.h
# End Source File
# Begin Source File

SOURCE=.\flag_setter.h
# End Source File
# Begin Source File

SOURCE=.\globals.h
# End Source File
# Begin Source File

SOURCE=.\globals_collector.h
# End Source File
# Begin Source File

SOURCE=.\hex.h
# End Source File
# Begin Source File

SOURCE=.\kfc_ktl_api.h
# End Source File
# Begin Source File

SOURCE=.\kfc_ktl_pch.h
# End Source File
# Begin Source File

SOURCE=.\kfc_mem.h
# End Source File
# Begin Source File

SOURCE=.\kstring.h
# End Source File
# Begin Source File

SOURCE=.\kstrings.h
# End Source File
# Begin Source File

SOURCE=.\ktl_consts.h
# End Source File
# Begin Source File

SOURCE=.\ktl_globals.h
# End Source File
# Begin Source File

SOURCE=.\ktl_tokens.h
# End Source File
# Begin Source File

SOURCE=.\list.h
# End Source File
# Begin Source File

SOURCE=.\method_ptr.h
# End Source File
# Begin Source File

SOURCE=.\module_globals.h
# End Source File
# Begin Source File

SOURCE=.\object_defs.h
# End Source File
# Begin Source File

SOURCE=.\object_pointer.h
# End Source File
# Begin Source File

SOURCE=.\object_reference.h
# End Source File
# Begin Source File

SOURCE=.\parray.h
# End Source File
# Begin Source File

SOURCE=.\placement_allocation.h
# End Source File
# Begin Source File

SOURCE=.\plist.h
# End Source File
# Begin Source File

SOURCE=.\postfixes.h
# End Source File
# Begin Source File

SOURCE=.\ptree.h
# End Source File
# Begin Source File

SOURCE=.\qsort.h
# End Source File
# Begin Source File

SOURCE=.\rects.h
# End Source File
# Begin Source File

SOURCE=.\registration_manager.h
# End Source File
# Begin Source File

SOURCE=.\segments.h
# End Source File
# Begin Source File

SOURCE=.\stacked_storage.h
# End Source File
# Begin Source File

SOURCE=.\stream.h
# End Source File
# Begin Source File

SOURCE=.\string_conv.h
# End Source File
# Begin Source File

SOURCE=.\subobject_lister.h
# End Source File
# Begin Source File

SOURCE=.\suspendable.h
# End Source File
# Begin Source File

SOURCE=.\text_container.h
# End Source File
# Begin Source File

SOURCE=.\token.h
# End Source File
# Begin Source File

SOURCE=.\tree.h
# End Source File
# Begin Source File

SOURCE=.\variable_list.h
# End Source File
# Begin Source File

SOURCE=.\varray.h
# End Source File
# Begin Source File

SOURCE=.\vbtree.h
# End Source File
# Begin Source File

SOURCE=.\vfifo.h
# End Source File
# Begin Source File

SOURCE=.\vlist.h
# End Source File
# Begin Source File

SOURCE=.\vmatrix.h
# End Source File
# Begin Source File

SOURCE=.\vtree.h
# End Source File
# Begin Source File

SOURCE=.\win_inc.h
# End Source File
# End Group
# Begin Source File

SOURCE=.\KFC_KTL.dsp
# End Source File
# End Target
# End Project
