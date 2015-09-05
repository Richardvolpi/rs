#ifndef install_h
#define install_h

// ----------------
// Global routines
// ----------------

// Installation
KFC_COMMON_API bool IsInstallationRegistered(LPCTSTR pName);

KFC_COMMON_API void UnregisterInstallation(LPCTSTR pName);

KFC_COMMON_API void RegisterInstallation(	LPCTSTR			pName,
											LPCTSTR			pUninstallerFileName,
											const KStrings*	pCustomNames	= NULL,
											const KStrings* pCustomValues	= NULL);

KFC_COMMON_API KString GetInstallationCustomValue(LPCTSTR pName, LPCTSTR pCustomName);

// Start-up
KFC_COMMON_API bool IsRegisteredAllUsersStartUp(LPCTSTR pName, KString* pRDestination = NULL);

KFC_COMMON_API void UnregisterAllUsersStartUp(LPCTSTR pName);

KFC_COMMON_API void RegisterAllUsersStartUp(LPCTSTR pName, LPCTSTR pFileName);

// Doc type
KFC_COMMON_API void RegisterDocType(LPCTSTR pDocType,
									LPCTSTR pIconFileName,
									LPCTSTR pOpenCommand);

KFC_COMMON_API void UnregisterDocType(LPCTSTR pDocType);

// File extension doc type
KFC_COMMON_API void RegisterFileExtensionDocType(	LPCTSTR pFileExtension,
													LPCTSTR pDocType);

KFC_COMMON_API void UnregisterFileExtensionDocType(LPCTSTR pFileExtension);

#endif // install_h