#include "kfc_ktl_pch.h"
#include "debug_file.h"

TDebugFile g_DebugFile;

// -----------
// Debug file
// -----------
TDebugFile::TDebugFile()
{
	m_bAllocated = false;

	InitializeCriticalSection(&m_AccessCriticalSection);
}

TDebugFile::~TDebugFile()
{
	Release();

	DeleteCriticalSection(&m_AccessCriticalSection);
}

void TDebugFile::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		m_FileName.Empty();
	}
}

void TDebugFile::Allocate(const KString& SFileName, bool bClear)
{
	Release();

	try
	{
		if(SFileName.IsEmpty())
			return;

		m_FileName = SFileName;

		if(bClear)
			Clear();

		m_bAllocated = true; 
	}

	catch(...)
	{
		Release(true);
	}
}

void TDebugFile::UnLock()
{
	LeaveCriticalSection(&m_AccessCriticalSection);
}

void TDebugFile::Lock()
{
	EnterCriticalSection(&m_AccessCriticalSection);
}

void TDebugFile::Clear()
{
	FILE* pFile = _tfopen(m_FileName, TEXT("wt"));
	if(pFile)
		fclose(pFile);
}

TDebugFile& TDebugFile::operator << (LPCTSTR pString)
{
	if(IsEmpty())
		return *this;

	FILE* pFile = _tfopen(m_FileName, TEXT("at"));
	if(pFile)
	{
		_ftprintf(pFile, TEXT("%s"), pString);

		fclose(pFile);
	}

	return *this;
}

TDebugFile& TDebugFile::operator << (TDebugFileControlChar ControlChar)
{
	if(IsEmpty())
		return *this;

	if(ControlChar == DFCC_CLEAR)
		Clear();

	if(ControlChar == DFCC_EOL)
		*this << TEXT("\n");

	return *this;
}