#ifndef stacked_storage_h
#define stacked_storage_h

#include "basic_types.h"
#include "varray.h"
#include "placement_allocation.h"
#include "ktl_consts.h"
#include "kfc_mem.h"

// -------------------------
// Stacked storage iterator
// -------------------------
template <class ObjectType>
struct TStackedStorageIterator
{
private:
	BYTE* m_pData;

public:
	TStackedStorageIterator()													: m_pData(NULL)				{}
	TStackedStorageIterator(const TStackedStorageIterator<ObjectType>&	SIter)	: m_pData(SIter.m_pData)	{}
	TStackedStorageIterator(BYTE*										pSData) : m_pData(pSData)			{}

	static TStackedStorageIterator<ObjectType> FromVPoid(BYTE* pData) { return (BYTE*)pData; }

	void Invalidate() { m_pData = NULL; }

	TStackedStorageIterator<ObjectType> GetNext() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("stacked storage iterator"));

		return TStackedStorageIterator<ObjectType>(*(BYTE**)m_pData);
	}

	TStackedStorageIterator<ObjectType>& ToNext()
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("stacked storage iterator"));

		m_pData = *(BYTE**)m_pData;

		return *this;
	}
	
	TStackedStorageIterator<ObjectType>& operator ++ () { return ToNext(); }

	bool IsValid() const { return m_pData != NULL; }

	TStackedStorageIterator<ObjectType>& operator =
		(const TStackedStorageIterator<ObjectType>& SIter)

		{ m_pData = SIter.m_pData; return *this; }
	
	bool operator == (const TStackedStorageIterator<ObjectType>& SIter) const
		{ return m_pData == SIter.m_pData; }

	bool operator != (const TStackedStorageIterator<ObjectType>& SIter) const
		{ return m_pData != SIter.m_pData; }

	ObjectType* GetDataPtr() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("stacked storage iterator"));

		return (ObjectType*)(m_pData + sizeof(BYTE*));
	}
	
	ObjectType& GetDataRef() const { return *GetDataPtr(); }

	ObjectType* operator ->	() const { return GetDataPtr(); }
	ObjectType& operator *	() const { return GetDataRef(); }

	void* AsPVoid() const { return (void*)m_pData; }
};

// -------------------------------
// Stacked storage const iterator
// -------------------------------
template <class ObjectType>
struct TStackedStorageConstIterator
{
private:
	const BYTE* m_pData;	

public:
	TStackedStorageConstIterator()															: m_pData(NULL)							{}
	TStackedStorageConstIterator(const TStackedStorageConstIterator<ObjectType>&	SIter)	: m_pData(SIter.m_pData)				{}
	TStackedStorageConstIterator(const TStackedStorageIterator<ObjectType>&			SIter)	: m_pData((const BYTE*)SIter.AsPVoid())	{}
	TStackedStorageConstIterator(const BYTE*										pSData) : m_pData(pSData)						{}

	static TStackedStorageConstIterator<ObjectType> FromPVoid(void* pData)
		{ return *(const BYTE* const *)pData; }

	void Invalidate() { m_pData = NULL; }

	TStackedStorageConstIterator<ObjectType> GetNext() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("stacked storage const iterator"));

		return TStackedStorageIterator<ObjectType>(*(const BYTE* const *)pData);
	}

	TStackedStorageConstIterator<ObjectType>& ToNext()
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("stacked storage const iterator"));

		m_pData = *(const BYTE* const *)m_pData;

		return *this;
	}
	
	TStackedStorageConstIterator<ObjectType>& operator ++ () { return ToNext(); }

	bool IsValid() const { return m_pData != NULL; }

	TStackedStorageConstIterator<ObjectType>& operator =
		(const TStackedStorageConstIterator<ObjectType>& SIter)

		{ m_pData = SIter.m_pData; return *this; }

	TStackedStorageConstIterator<ObjectType>& operator =
		(const TStackedStorageIterator<ObjectType>& SIter)

		{ m_pData = (const BYTE*)SIter.AsPVoid(); return *this; }
	
	bool operator == (const TStackedStorageConstIterator<ObjectType>& SIter) const
		{ return m_pData == SIter.m_pData; }

	bool operator != (const TStackedStorageConstIterator<ObjectType>& SIter) const
		{ return m_pData != SIter.m_pData; }

	const ObjectType* GetDataPtr() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("stacked storage const iterator"));

		return (const ObjectType*)(m_pData + sizeof(const BYTE*));
	}
	
	const ObjectType& GetDataRef() const { return *GetDataPtr(); }

	const ObjectType* operator ->	() const { return GetDataPtr(); }
	const ObjectType& operator *	() const { return GetDataRef(); }

	void* AsPVoid() const { return (void*)m_pData; }
};

// ----------------
// Stacked storage
// ----------------
template <class ObjectType>
class TStackedStorage
{
private:
	bool m_bAllocated;

	TValueArray<BYTE*, true>	m_Portions;
	size_t						m_szMinPortionSize;

	size_t	m_szLastPortionSize;
	BYTE**	m_pLastNextPointer;

	size_t m_szN;


	void ResetState();

public:
	TStackedStorage();

	~TStackedStorage() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release();

	void Allocate(	size_t					szSMinPortionSize,
					const TArrayAllocation&	PortionsAllocation =
						g_KTLConsts.m_DefaultStackedStoragePortionsAllocation);

	void Clear();

	void* AllocateData(size_t szSize);

	TStackedStorageIterator<ObjectType>			GetFirst();
	TStackedStorageConstIterator<ObjectType>	GetFirst() const;

	// ---------------- TRIVIALS ----------------
	size_t GetN() const { return m_szN; }
};

template <class ObjectType>
TStackedStorage<ObjectType>::TStackedStorage()
{
	m_bAllocated = false;
}

template <class ObjectType>
void TStackedStorage<ObjectType>::ResetState()
{
	m_szLastPortionSize = 0;

	m_pLastNextPointer = NULL;

	m_szN = 0;
}

template <class ObjectType>
void TStackedStorage<ObjectType>::Release()
{
	if(!IsEmpty())
		Clear();

	m_Portions.Release();

	ResetState();

	m_bAllocated = false;
}

template <class ObjectType>
void TStackedStorage<ObjectType>::Allocate(	size_t					szSMinPortionSize,
											const TArrayAllocation&	PortionsAllocation)
{
	Release();

	try
	{
		m_Portions.Allocate(PortionsAllocation);

		m_szMinPortionSize = szSMinPortionSize;

		ResetState();
	
		m_bAllocated = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

template <class ObjectType>
void TStackedStorage<ObjectType>::Clear()
{
	DEBUG_VERIFY_ALLOCATION;

	size_t i;

	// Destroying objects
	for(TStackedStorageIterator<ObjectType> Iter = GetFirst() ; Iter.IsValid() ; ++Iter)
		Iter->~ObjectType();

	// Freeing portion blocks memory
	for(i = 0 ; i < m_Portions.GetN() ; i++)
		kfc_free(m_Portions[i]);

	// Clearing portions
	m_Portions.Clear(true);

	// Reseting state
	ResetState();
}

template <class ObjectType>
void* TStackedStorage<ObjectType>::AllocateData(size_t szSize)
{
	DEBUG_VERIFY_ALLOCATION;

	// Increasing and aligning size required
	ALIGN_DATA_SIZE(szSize += sizeof(BYTE*));

	// Getting new data pointer
	if(	m_szN == 0 ||
		m_szLastPortionSize + szSize > m_szMinPortionSize) // new portion required
	{
		m_Portions.Add() = (BYTE*)kfc_malloc(Max(m_szMinPortionSize, szSize));

		m_szLastPortionSize = 0;
	}

	BYTE* const pData = m_Portions.GetLastItem() + m_szLastPortionSize;

	m_szLastPortionSize += szSize;

	// Updating previous next link
	if(m_pLastNextPointer)
		*m_pLastNextPointer = pData;

	// Setting and updating current next link
	*(m_pLastNextPointer = (BYTE**)pData) = NULL;

	// Updating amount
	m_szN++;

	// Returning data contaiment pointer
	return pData + sizeof(BYTE*);
}

template <class ObjectType>
TStackedStorageIterator<ObjectType> TStackedStorage<ObjectType>::GetFirst()
{
	DEBUG_VERIFY_ALLOCATION;

	return	m_szN == 0 ?
				TStackedStorageIterator<ObjectType>() :
				TStackedStorageIterator<ObjectType>(m_Portions[0]);
}

template <class ObjectType>
TStackedStorageConstIterator<ObjectType> TStackedStorage<ObjectType>::GetFirst() const
{
	DEBUG_VERIFY_ALLOCATION;

	return	m_szN == 0 ?
				TStackedStorageIterator<ObjectType>() :
				TStackedStorageIterator<ObjectType>(m_Portions[0]);
}

#endif // stacked_storage_h