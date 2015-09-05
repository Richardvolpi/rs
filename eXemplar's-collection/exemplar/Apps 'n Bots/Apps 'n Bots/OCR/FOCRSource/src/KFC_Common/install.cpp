#include "kfc_common_pch.h"
#include "install.h"

#include "registry.h"

// ----------------
// Global routines
// ----------------

// Installation
bool IsInstallationRegistered(LPCTSTR pName)
{
	DEBUG_VERIFY(pName);

	KRegistryKey Key(	HKEY_LOCAL_MACHINE,
						(KString)TEXT("Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall"));

	Key.Create(KEY_READ, 0, true);

	return Key.HasKey(pName);
}

void UnregisterInstallation(LPCTSTR pName)
{
	DEBUG_VERIFY(pName);

	KRegistryKey Key(	HKEY_LOCAL_MACHINE,
						(KString)TEXT("Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\") +
							pName);

	Key.Delete(true, true);
}

KFC_COMMON_API void RegisterInstallation(	LPCTSTR			pName,
											LPCTSTR			pUninstallerFileName,
											const KStrings*	pCustomNames,
											const KStrings* pCustomValues)
{
	DEBUG_VERIFY(pName);

	DEBUG_VERIFY(pUninstallerFileName);

	DEBUG_VERIFY(	(pCustomNames	? pCustomNames->	GetN() : 0) ==
					(pCustomValues	? pCustomValues->	GetN() : 0));

	KRegistryKey Key(	HKEY_LOCAL_MACHINE,
						(KString)TEXT("Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\") +
							pName);

	Key.Create(KEY_WRITE, 0, true);

	Key.WriteString(TEXT("DisplayName"), pName);

	Key.WriteString(TEXT("UninstallString"), pUninstallerFileName);

	if(pCustomNames && pCustomValues)
	{
		KStrings::TConstIterator NIter, VIter;

		for(NIter = pCustomNames->GetFirst(), VIter = pCustomValues->GetFirst() ;
			NIter.IsValid() && VIter.IsValid() ;
			++NIter, ++VIter)
		{
			Key.WriteString(*NIter, *VIter);
		}
	}
}

KString GetInstallationCustomValue(LPCTSTR pName, LPCTSTR pCustomName)
{
	DEBUG_VERIFY(pName);

	DEBUG_VERIFY(pCustomName);

	KRegistryKey Key(	HKEY_LOCAL_MACHINE,
						(KString)TEXT("Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\") +
							pName);

	Key.Open(KEY_READ);

	return Key.ReadString(pCustomName);
}

// Start-up
bool IsRegisteredAllUsersStartUp(LPCTSTR pName, KString* pRDestination)
{
	DEBUG_VERIFY(pName);

	KRegistryKey Key(	HKEY_LOCAL_MACHINE,
						TEXT("Software\\Microsoft\\Windows\\CurrentVersion\\Run"));

	Key.Create(KEY_READ, 0, true);

	TEST_BLOCK_BEGIN
	{
		const KString Destination = Key.ReadString(pName);

		if(pRDestination)
			*pRDestination = Destination;

		return true;
	}
	TEST_BLOCK_EXCEPTION_HANDLER
	{
		return false;
	}
	TEST_BLOCK_END
}

void UnregisterAllUsersStartUp(LPCTSTR pName)
{
	DEBUG_VERIFY(pName);

	KRegistryKey Key(	HKEY_LOCAL_MACHINE,
						TEXT("Software\\Microsoft\\Windows\\CurrentVersion\\Run"));

	Key.Create(KEY_WRITE, 0, true);

	Key.DeleteValue(pName, true);
}

void RegisterAllUsersStartUp(LPCTSTR pName, LPCTSTR pFileName)
{
	DEBUG_VERIFY(pName);

	DEBUG_VERIFY(pFileName);

	KRegistryKey Key(	HKEY_LOCAL_MACHINE,
						TEXT("Software\\Microsoft\\Windows\\CurrentVersion\\Run"));

	Key.Create(KEY_WRITE, 0, true);

	Key.WriteString(pName, pFileName);
}

// Doc type
void RegisterDocType(	LPCTSTR pDocType,
						LPCTSTR pIconFileName,
						LPCTSTR pOpenCommand)
{
	KRegistryKey DocKey(HKEY_CLASSES_ROOT, pDocType);

	DocKey.Create(KEY_WRITE, 0, true);

	// Icon
	{
		KRegistryKey Key(DocKey, TEXT("DefaultIcon"));

		Key.Create(KEY_WRITE, 0, true);

		Key.WriteString(TEXT(""), pIconFileName);
	}

	// Open command
	{
		KRegistryKey Key(DocKey, TEXT("shell\\open\\command"));

		Key.Create(KEY_WRITE, 0, true);

		Key.WriteString(TEXT(""), pOpenCommand);
	}
}

void UnregisterDocType(LPCTSTR pDocType)
{
	KRegistryKey DocKey(HKEY_CLASSES_ROOT, pDocType);

	DocKey.Delete(true, true);
}

// File extension doc type
void RegisterFileExtensionDocType(	LPCTSTR pFileExtension,
									LPCTSTR pDocType)
{
	KRegistryKey ExtKey(HKEY_CLASSES_ROOT, (KString)TEXT(".") + pFileExtension);

	ExtKey.Create(KEY_WRITE, 0, true);

	ExtKey.WriteString(TEXT(""), pDocType);
}

void UnregisterFileExtensionDocType(LPCTSTR pFileExtension)
{
	KRegistryKey ExtKey(HKEY_CLASSES_ROOT, (KString)TEXT(".") + pFileExtension);

	ExtKey.Delete(true, true);
}