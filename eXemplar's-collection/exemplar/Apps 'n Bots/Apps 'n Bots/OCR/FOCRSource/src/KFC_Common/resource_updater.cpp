#include "kfc_common_pch.h"
#include "resource_updater.h"

#include <KFC_Common\file.h>

// -----------------
// Resource updater
// -----------------
TResourceUpdater::TResourceUpdater()
{
	m_hHandle = NULL;
}

TResourceUpdater::TResourceUpdater(	LPCTSTR	pFileName,
									bool	bDeleteExisting)
{
	m_hHandle = NULL;

	Allocate(pFileName, bDeleteExisting);
}

void TResourceUpdater::Release(bool bCommit)
{
	if(m_hHandle)
		EndUpdateResource(m_hHandle, bCommit ? FALSE : TRUE), m_hHandle = NULL;
}

void TResourceUpdater::Allocate(LPCTSTR	pFileName,
								bool	bDeleteExisting)
{
	Release();

	try
	{
		DEBUG_VERIFY(pFileName);

		m_hHandle = BeginUpdateResource(pFileName, bDeleteExisting);

		if(m_hHandle == NULL)
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error begining updating file \"") +
												pFileName +
												TEXT("\" resources"),
											GetLastError());
		}
	}

	catch(...)
	{
		Release(false);
		throw 1;
	}
}

void TResourceUpdater::Update(	LPCTSTR		pType,
								size_t		szID,
								const void*	pData,
								size_t		szLength,
								WORD		wLanguage)
{
	DEBUG_VERIFY_ALLOCATION;
	
	DEBUG_VERIFY(pType);

	DEBUG_VERIFY(pData && szLength > 0);

	if(!UpdateResource(*this, pType, MAKEINTRESOURCE(szID), wLanguage, (void*)pData, szLength))
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error updating resource"),
										GetLastError());
	}
}

void TResourceUpdater::UpdateFile(	LPCTSTR	pType,
									size_t	szID,
									LPCTSTR	pFileName,
									WORD	wLanguage)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(pType);

	DEBUG_VERIFY(pFileName);

	TFile File(pFileName, FOF_BINARYREAD);

	TValueArray<BYTE, true> Buffer(File.GetLength());

	Buffer.AllocateAdd(File.GetLength());

	File.Read(Buffer.GetDataPtr(), Buffer.GetN());

	Update(pType, szID, Buffer.GetDataPtr(), Buffer.GetN(), wLanguage);
}

HANDLE TResourceUpdater::GetHandle() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_hHandle;
}
