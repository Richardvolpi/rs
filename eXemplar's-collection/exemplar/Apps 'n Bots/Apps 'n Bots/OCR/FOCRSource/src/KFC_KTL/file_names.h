#ifndef file_names_h
#define file_names_h

#include "kfc_ktl_api.h"
#include "kstring.h"

// ----------------
// Global routines
// ----------------
KFC_KTL_API bool IsSlash(TCHAR a);

KFC_KTL_API KString SlashedFolderName	(const KString& FolderName);
KFC_KTL_API KString UnslashedFolderName	(const KString& FolderName);

KFC_KTL_API bool IsAbsolutePath		(const KString& s);
KFC_KTL_API bool IsNetworkPath		(const KString& s);
KFC_KTL_API bool IsLocalDrivePath	(const KString& s);

KFC_KTL_API KString	GetFilePath			(const KString& name);
KFC_KTL_API KString	GetFileName			(const KString& name);
KFC_KTL_API KString	GetFileNameName		(const KString& name);
KFC_KTL_API KString	GetFileExtension	(const KString& name);
KFC_KTL_API KString	GetRelativePath		(const KString& src, const KString& dst);
KFC_KTL_API KString	Get83FileName		(const KString& FileName);
KFC_KTL_API KString	GetLastFolderName	(const KString& name);

KFC_KTL_API bool IsValidFileName(const KString& s);

KFC_KTL_API KString& FixSlashes(KString& s, TCHAR cSlash);

KFC_KTL_API void CreateFoldersSequence(	KString		Path, // altered inside
										KStrings&	RFolders,
										bool		bClearFirst = true);

KFC_KTL_API bool IsFolder(const KString& Name);

#endif // file_names_h
