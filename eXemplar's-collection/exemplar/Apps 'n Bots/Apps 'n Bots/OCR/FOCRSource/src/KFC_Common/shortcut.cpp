#include "kfc_common_pch.h"
#include "shortcut.h"

#include "com.h"

// ----------------
// Global routines
// ----------------
KString GetShortcutTarget(	const KString&	FileName,
							bool			bResolve,
							flags_t			flFlags)
{	
	HRESULT r = S_OK;

	TCOMInterface<IShellLink> ShellLink(CLSID_ShellLink, IID_IShellLink);

	TCOMInterface<IPersistFile> PersistFile(ShellLink.GetInterface(), IID_IPersistFile);

	// Loading shortcut
	{
		if(r = PersistFile->Load(TWideString(FileName), STGM_READ))
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error loading shortcut \"")	+
												FileName								+
												TEXT("\""),
											r);
		}
	}

	// Resolving shortcut
	if(bResolve)
	{
		if(r = ShellLink->Resolve(NULL, SLR_ANY_MATCH | SLR_NO_UI))
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error resolving shortcut \"")	+ 
												FileName									+
												TEXT("\""),
											r);
		}
	}

	// Getting shortcut path
	{
		TCHAR			Buf[MAX_PATH];
		WIN32_FIND_DATA	FindData;

		if(r = ShellLink->GetPath(	Buf,
									sizeof(Buf) - 1,
									&FindData,
									flFlags))
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error getting shortcut \"")	+
												FileName								+
												TEXT("\" target"),
											r);
		}

		return Buf;
	}
}

void CreateShortcut(const KString& FileName, const KString& Target)
{
	DEBUG_VERIFY(FileName.GetLength() < MAX_PATH);

	DEBUG_VERIFY(Target.GetLength() < MAX_PATH);

	HRESULT r = S_OK;

	TCOMInterface<IShellLink> ShellLink(CLSID_ShellLink, IID_IShellLink);

	TCOMInterface<IPersistFile> PersistFile(ShellLink.GetInterface(), IID_IPersistFile);

	// Preparing shortcut
	{
		if(r = ShellLink->SetPath(Target))
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error preparing shortcut to \"")	+
												Target										+
												TEXT("\""),
											r);
		}
	}

	// Saving shortcut
	{
		if(r = PersistFile->Save(TWideString(FileName), FALSE))
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error saving shortcut \"")	+
												FileName								+
												TEXT("\""),
											r);
		}
	}
}