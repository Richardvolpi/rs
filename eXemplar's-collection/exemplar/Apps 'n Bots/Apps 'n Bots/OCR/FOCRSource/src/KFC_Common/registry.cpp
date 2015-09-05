#include "kfc_common_pch.h"
#include "registry.h"

#include <KFC_KTL\varray.h>
#include <KFC_KTL\file_names.h>
#include "common_consts.h"

// -------------
// Registry key
// -------------
KRegistryKey::KRegistryKey()
{
	m_hParentKey = NULL;

	m_hKey = NULL;
}

KRegistryKey::KRegistryKey(	HKEY			hSParentKey,
							const KString&	SName)
{
	m_hParentKey = NULL;

	m_hKey = NULL;

	Allocate(hSParentKey, SName);
}

void KRegistryKey::Release()
{
	if(!IsEmpty())
		Close();
	
	m_hParentKey = NULL;

	m_Name.Empty();

	m_hKey = NULL;
}

void KRegistryKey::Allocate(HKEY			hSParentKey,
							const KString&	SName)
{
	Release();

	try
	{
		DEBUG_VERIFY(hSParentKey != NULL);
	
		m_hParentKey = hSParentKey;

		m_Name = SlashedFolderName(SName);
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void KRegistryKey::Close()
{
	DEBUG_VERIFY_ALLOCATION;
	
	if(!IsOpen())
		return;
	
	RegCloseKey(m_hKey), m_hKey = NULL;
}

KRegistryKey& KRegistryKey::Open(REGSAM rsAccess)
{
	DEBUG_VERIFY_ALLOCATION;

	if(IsOpen())
		Close();

	size_t szStartTime = GetTickCount();
	
	LONG r;
	while(r = RegOpenKeyEx(m_hParentKey, UnslashedFolderName(m_Name), 0, rsAccess, &m_hKey))
	{
		if(r == ERROR_FILE_NOT_FOUND)
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error opening registry key \"") +
												m_Name +
												TEXT("\""),
											r);
		}

		if(GetTickCount() - szStartTime >= g_CommonConsts.m_szRegistryKeyTimeout)
		{
			m_hKey = NULL;

			INITIATE_DEFINED_FAILURE(	(KString)TEXT("Registry key \"") +
										m_Name +
										TEXT("\" opening time out."));
		}
	}

	return *this;
}

bool KRegistryKey::Create(	REGSAM	rsAccess,
							flags_t	flOptions,
							bool	bAutoOpen)
{
	DEBUG_VERIFY_ALLOCATION;

	if(IsOpen())
		return false;

	DWORD dwDisposition;

	size_t szStartTime = GetTickCount();
	while(RegCreateKeyEx(	m_hParentKey,
							UnslashedFolderName(m_Name),
							0,
							NULL,
							flOptions,
							rsAccess,
							NULL,
							&m_hKey,
							&dwDisposition))
	{
		const size_t r = GetLastError();

		if(GetTickCount() - szStartTime >= g_CommonConsts.m_szRegistryKeyTimeout)
		{
			m_hKey = NULL;
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error creating registry key: \"") +
												m_Name +
												TEXT("\""),
											r);
		}
	}

	if(!bAutoOpen)
		Close();

	return dwDisposition != REG_OPENED_EXISTING_KEY;
}

HKEY KRegistryKey::GetKey() const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	return m_hKey;
}

void KRegistryKey::ReadInt64(const KString& ValueName, __int64& iRValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	DWORD dwType;
	DWORD dwSize = sizeof(iRValue);
	if(	RegQueryValueEx(m_hKey, ValueName, NULL, &dwType, (BYTE*)&iRValue, &dwSize) ||
		dwType != REG_BINARY || dwSize != sizeof(iRValue))
	{
		throw 1;
	}
}

void KRegistryKey::ReadUINT64(const KString& ValueName, UINT64& uiRValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	DWORD dwType;
	DWORD dwSize = sizeof(uiRValue);
	if(	RegQueryValueEx(m_hKey, ValueName, NULL, &dwType, (BYTE*)&uiRValue, &dwSize) ||
		dwType != REG_BINARY || dwSize != sizeof(uiRValue))
	{
		throw 1;
	}
}

void KRegistryKey::ReadInt(const KString& ValueName, int& iRValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	DWORD dwType;
	DWORD dwSize = sizeof(iRValue);
	if(	RegQueryValueEx(m_hKey, ValueName, NULL, &dwType, (BYTE*)&iRValue, &dwSize) ||
		dwType != REG_DWORD || dwSize != sizeof(iRValue))
	{
		throw 1;
	}
}

void KRegistryKey::ReadUINT(const KString& ValueName, UINT& uiRValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	DWORD dwType;
	DWORD dwSize = sizeof(uiRValue);
	if(	RegQueryValueEx(m_hKey, ValueName, NULL, &dwType, (BYTE*)&uiRValue, &dwSize) ||
		dwType != REG_DWORD || dwSize != sizeof(uiRValue))
	{
		throw 1;
	}
}

void KRegistryKey::ReadString(const KString& ValueName, KString& RValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	DWORD dwType;
	DWORD dwSize;
	if(	RegQueryValueEx(m_hKey, ValueName, NULL, &dwType, NULL, &dwSize) ||
		dwType != REG_SZ)
	{
		throw 1;
	}

	TValueArray<TCHAR, true> Buf;
	Buf.Allocate(dwSize+1), Buf.Add(dwSize+1);

	if(RegQueryValueEx(m_hKey, ValueName, NULL, NULL, (BYTE*)Buf.GetDataPtr(), &dwSize))
		throw 1;

	Buf[dwSize / sizeof(TCHAR)] = 0;

	RValue = Buf.GetDataPtr();
}

void KRegistryKey::ReadBool(const KString& ValueName, bool& bRValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());
	
	UINT uiValue;
	ReadUINT(ValueName, uiValue);

	if(uiValue==0)
		bRValue = false;
	else if(uiValue==1)
		bRValue = true;
	else
		throw 1;
}

void KRegistryKey::ReadGUID(const KString& ValueName, GUID& RValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	DWORD dwType;
	DWORD dwSize = sizeof(RValue);
	if(	RegQueryValueEx(m_hKey, ValueName, NULL, &dwType, (BYTE*)&RValue, &dwSize) ||
		dwType != REG_BINARY || dwSize != sizeof(RValue))
	{
		throw 1;
	}
}

void KRegistryKey::ReadInt64(const KString& ValueName, __int64& iRValue, __int64 iDefaultValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	try
	{
		ReadInt64(ValueName, iRValue);
	}

	catch(...)
	{
		iRValue = iDefaultValue;
	}
}

void KRegistryKey::ReadUINT64(const KString& ValueName, UINT64& uiRValue, UINT64 uiDefaultValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	try
	{
		ReadUINT64(ValueName, uiRValue);
	}

	catch(...)
	{
		uiRValue = uiDefaultValue;
	}
}

void KRegistryKey::ReadInt(const KString& ValueName, int& iRValue, const int iDefaultValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	try
	{
		ReadInt(ValueName, iRValue);
	}

	catch(...)
	{
		iRValue = iDefaultValue;
	}
}

void KRegistryKey::ReadUINT(const KString& ValueName, UINT& uiRValue, const UINT uiDefaultValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	try
	{
		ReadUINT(ValueName, uiRValue);
	}

	catch(...)
	{
		uiRValue = uiDefaultValue;
	}
}

void KRegistryKey::ReadString(const KString& ValueName, KString& RValue, const KString& DefaultValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	try
	{
		ReadString(ValueName, RValue);
	}

	catch(...)
	{
		RValue = DefaultValue;
	}
}

void KRegistryKey::ReadBool(const KString& ValueName, bool& bRValue, const bool bDefaultValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	try
	{
		ReadBool(ValueName, bRValue);
	}

	catch(...)
	{
		bRValue = bDefaultValue;
	}
}

void KRegistryKey::ReadGUID(const KString& ValueName, GUID& RValue, const GUID& DefaultValue) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	try
	{
		ReadGUID(ValueName, RValue);
	}

	catch(...)
	{
		RValue = DefaultValue;
	}
}

void KRegistryKey::WriteInt64(const KString& ValueName, const __int64 iValue)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(RegSetValueEx(m_hKey, ValueName, NULL, REG_BINARY, (BYTE*)&iValue, sizeof(iValue)))
		INITIATE_FAILURE;
}

void KRegistryKey::WriteUINT64(const KString& ValueName, const UINT64 uiValue)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(RegSetValueEx(m_hKey, ValueName, NULL, REG_BINARY, (BYTE*)&uiValue, sizeof(uiValue)))
		INITIATE_FAILURE;
}

void KRegistryKey::WriteInt(const KString& ValueName, const int iValue)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(RegSetValueEx(m_hKey, ValueName, NULL, REG_DWORD, (BYTE*)&iValue, sizeof(iValue)))
		INITIATE_FAILURE;
}

void KRegistryKey::WriteUINT(const KString& ValueName, const UINT uiValue)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(RegSetValueEx(m_hKey, ValueName, NULL, REG_DWORD, (BYTE*)&uiValue, sizeof(uiValue)))
		INITIATE_FAILURE;
}

void KRegistryKey::WriteString(const KString& ValueName, const KString& Value)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	size_t szLength = Value.GetLength();
	TValueArray<TCHAR, true> Buf;
	Buf.Allocate(szLength + 2), Buf.Add(szLength + 2);
	memcpy(Buf.GetDataPtr(), (LPCTSTR)Value, (szLength + 1)*sizeof(TCHAR)), Buf[szLength + 1] = 0;

	if(RegSetValueEx(m_hKey, ValueName, NULL, REG_SZ, (BYTE*)Buf.GetDataPtr(), (szLength + 1) * sizeof(TCHAR)))
		INITIATE_FAILURE;
}

void KRegistryKey::WriteBool(const KString& ValueName, const bool bValue)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	WriteUINT(ValueName, bValue ? 1 : 0);
}

void KRegistryKey::WriteGUID(const KString& ValueName, const GUID& Value)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(RegSetValueEx(m_hKey, ValueName, NULL, REG_BINARY, (BYTE*)&Value, sizeof(Value)))
		INITIATE_FAILURE;
}

DWORD KRegistryKey::GetValueType(const KString& ValueName) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	DWORD dwType;
	LONG r;
	if(r = RegQueryValueEx(m_hKey, ValueName, NULL, &dwType, NULL, NULL))
	{
		if(r==ERROR_FILE_NOT_FOUND)
			return REG_NONE;

		INITIATE_FAILURE;
	}
		
	return dwType;
}

bool KRegistryKey::HasKey(const KString& KeyName) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	TEST_BLOCK_BEGIN
	{
		KRegistryKey(*this, KeyName).Open(KEY_READ);
	}
	TEST_BLOCK_EXCEPTION_HANDLER
	{
		EMPTY_DEBUG_FAILURE_MESSAGE;

		return false;
	}
	TEST_BLOCK_END

	return true;
}

bool KRegistryKey::HasValue(const KString& ValueName) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	return GetValueType(ValueName) != REG_NONE;
}

void KRegistryKey::EnlistKeys(KStrings& RKeys) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	RKeys.Clear();

	for(size_t i = 0 ; ; i++)
	{
		TCHAR Name[16384];
		DWORD dwNameLength = sizeof(Name) - 1;

		LONG res = RegEnumKeyEx(*this, i, Name, &dwNameLength, NULL, NULL, NULL, NULL);

		if(res && res != ERROR_MORE_DATA)
			break;

		Name[dwNameLength] = 0;

		if(Name[0])
			(*RKeys.AddLast() = Name) += TEXT("\\");
	}
}

void KRegistryKey::EnlistValues(KStrings& RValues) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	RValues.Clear();

	for(size_t i = 0 ; ; i++)
	{
		TCHAR Name[16384];
		DWORD dwNameLength = sizeof(Name) - 1;

		LONG res = RegEnumValue(*this, i, Name, &dwNameLength, NULL, NULL, NULL, NULL);

		if(res && res != ERROR_MORE_DATA)
			break;

		Name[dwNameLength] = 0;

		if(Name[0])
			*RValues.AddLast() = Name;
	}
}

bool KRegistryKey::DeleteValue(const KString& ValueName, bool bSafe)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(RegDeleteValue(*this, ValueName))
	{
		if(bSafe)
			return false;

		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error deleteting registry key value"),
										GetLastError());
	}

	return true;
}

bool KRegistryKey::Delete(bool bRecursive, bool bSafe)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(!IsOpen());

	bool bSuccess = false;

	// Deleteing sub-keys
	TEST_BLOCK_BEGIN
	{
		KRegistryKeyOpener Opener0(*this, KEY_ALL_ACCESS);

		KStrings Keys;
		EnlistKeys(Keys);

		if(!Keys.IsEmpty())
		{	
			if(!bRecursive)
				return false;

			// Deleteing sub-keys
			for(KStrings::TConstIterator Iter = Keys.GetFirst() ; Iter.IsValid() ; ++Iter)
			{
				if(!KRegistryKey(*this, *Iter).Delete(bRecursive, bSafe))
					bSuccess = false;
			}
		}
	}
	TEST_BLOCK_EXCEPTION_HANDLER
	{
		if(!bSafe)
			throw 1;

		EMPTY_DEBUG_FAILURE_MESSAGE;
	}
	TEST_BLOCK_END

	// Deleteing the key
	if(RegDeleteKey(m_hParentKey, m_Name))
	{
		if(!bSafe)
		{		
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error deleteing registry key \"") +
												m_Name +
												TEXT("\""),
											GetLastError());
		}
		
		bSuccess = false;
	}

	return bSuccess;
}

// --------------------
// Registry key opener
// --------------------
KRegistryKeyOpener::KRegistryKeyOpener(	KRegistryKey&	SKey,
										REGSAM			rsAccess) : m_Key(SKey)
{
	m_Key.Open(rsAccess);
}

KRegistryKeyOpener::~KRegistryKeyOpener()
{
	m_Key.Close();
}