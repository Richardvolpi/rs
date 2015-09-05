#ifndef registry_h
#define registry_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\kstring.h>
#include "kfc_common_api.h"

// -------------
// Registry key
// -------------
class KFC_COMMON_API KRegistryKey
{
private:
	HKEY m_hParentKey;

	KString	m_Name;

	HKEY m_hKey;

public:
	KRegistryKey();

	KRegistryKey(	HKEY			hSParentKey,
					const KString&	SName);

	~KRegistryKey() { Release(); }

	bool IsEmpty() const { return m_hParentKey == NULL; }

	void Release();

	void Allocate(	HKEY			hSParentKey,
					const KString&	SName);

	bool IsOpen() const { return m_hKey ? true : false; }

	void Close();

	KRegistryKey& Open(REGSAM rsAccess);	
	
	bool Create(REGSAM rsAccess, flags_t flOptions, bool bAutoOpen); // returns 'true' if new key was created, 'false' otherwise

	HKEY GetKey() const;

	operator HKEY() const { return GetKey(); }

	__int64 ReadInt64(const KString& ValueName) const
	{
		__int64 iValue;
		return ReadInt64(ValueName, iValue), iValue;
	}

	UINT64 ReadUINT64(const KString& ValueName) const
	{
		UINT64 uiValue;
		return ReadUINT64(ValueName, uiValue), uiValue;
	}

	int ReadInt(const KString& ValueName) const
	{
		int iValue;
		return ReadInt(ValueName, iValue), iValue;
	}

	UINT ReadUINT(const KString& ValueName) const
	{
		UINT uiValue;
		return ReadUINT(ValueName, uiValue), uiValue;
	}

	KString ReadString(const KString& ValueName) const
	{
		KString Value;
		return ReadString(ValueName, Value), Value;
	}

	bool ReadBool(const KString& ValueName) const
	{
		bool bValue;
		return ReadBool(ValueName, bValue), bValue;
	}

	GUID ReadGUID(const KString& ValueName) const
	{
		GUID Value;
		return ReadGUID(ValueName, Value), Value;
	}
	
	void ReadInt64	(const KString& ValueName, __int64&	iRValue)	const;
	void ReadUINT64	(const KString& ValueName, UINT64&	uiRValue)	const;
	void ReadInt	(const KString& ValueName, int&		iRValue)	const;
	void ReadUINT	(const KString& ValueName, UINT&	uiRValue)	const;
	void ReadString	(const KString& ValueName, KString&	RValue)		const;
	void ReadBool	(const KString& ValueName, bool&	bRValue)	const;
	void ReadGUID	(const KString& ValueName, GUID&	RValue)		const;

	void ReadInt64	(const KString& ValueName, __int64&	iRValue,	const __int64	iDefaultValue)	const;
	void ReadUINT64	(const KString& ValueName, UINT64&	uiRValue,	const UINT64	uiDefaultValue)	const;
	void ReadInt	(const KString& ValueName, int&		iRValue,	const int		iDefaultValue)	const;
	void ReadUINT	(const KString& ValueName, UINT&	uiRValue,	const UINT		uiDefaultValue)	const;
	void ReadString	(const KString& ValueName, KString&	RValue,		const KString&	DefaultValue)	const;
	void ReadBool	(const KString& ValueName, bool&	bRValue,	const bool		bDefaultValue)	const;
	void ReadGUID	(const KString& ValueName, GUID&	RValue,		const GUID&		DefaultValue)	const;

	void WriteInt64	(const KString& ValueName, const __int64	iValue);
	void WriteUINT64(const KString& ValueName, const UINT64		iValue);
	void WriteInt	(const KString& ValueName, const int		iValue);
	void WriteUINT	(const KString& ValueName, const UINT		uiValue);
	void WriteString(const KString& ValueName, const KString&	Value);
	void WriteBool	(const KString& ValueName, const bool		bValue);
	void WriteGUID	(const KString& ValueName, const GUID&		Value);
	
	DWORD GetValueType(const KString& ValueName) const;

	bool HasKey		(const KString& KeyName)	const;
	bool HasValue	(const KString& ValueName)	const;

	void EnlistKeys		(KStrings& RKeys)	const;
	void EnlistValues	(KStrings& RValues)	const;
	
	bool DeleteValue(const KString& ValueName, bool bSafe);

	bool Delete(bool bRecursive, bool bSafe);
};

template <class t>
void ReadViaString(KRegistryKey& Key, const KString& ValueName, t& RValue)
{
	KString String;

	Key.ReadString(ValueName, String);

	if(!FromString(String, RValue))
	{
		INITIATE_DEFINED_FAILURE(	(KString)TEXT("Registry value \"") +
										ValueName +
										TEXT("\" has wrong format."));
	}
}

template <class t>
void ReadViaString(KRegistryKey& Key, const KString& ValueName, t& RValue, const t& DefaultValue)
{
	try
	{
		ReadViaString(Key, ValueName, RValue);
	}

	catch(...)
	{
		RValue = DefaultValue;
	}
}

template <class t>
void WriteViaString(KRegistryKey& Key, const KString& ValueName, const t& Value)
{
	Key.WriteString(ValueName, ToString(Value));
}

// --------------------
// Registry key opener
// --------------------
class KFC_COMMON_API KRegistryKeyOpener
{
private:
	KRegistryKey& m_Key;

public:
	KRegistryKeyOpener(	KRegistryKey&	SKey,
						REGSAM			rsAccess);

	~KRegistryKeyOpener();

	// --------------- TRIVIALS ------------------
	KRegistryKey&		GetKey()		{ return m_Key; }
	const KRegistryKey&	GetKey() const	{ return m_Key; }
};

#endif // registry_h
