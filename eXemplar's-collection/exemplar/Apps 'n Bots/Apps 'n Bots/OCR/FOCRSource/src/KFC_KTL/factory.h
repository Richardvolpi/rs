#ifndef factory_h
#define factory_h

#include "basic_types.h"
#include "basic_bitypes.h"
#include "varray.h"
#include "object_defs.h"

// --------------
// Factory entry
// --------------
template <class ObjectType>
struct TFactoryEntry
{
	typedef ObjectType* TCreator(type_t tpType);


	TPSEGMENT m_Types;
	TCreator* m_pCreator;


	void Set(	const TPSEGMENT&	STypes,
				TCreator*			pSCreator)
	{
		m_Types		= STypes;
		m_pCreator	= pSCreator;
	}
};

// --------
// Factory
// --------
template <class ObjectType>
class TFactory
{
public:
	typedef TFactoryEntry<ObjectType> TEntry;
	
private:
	typedef TValueArray<TEntry, true> TEntries;


	bool m_bAllocated;

	TEntries m_Entries;

public:
	TFactory();

	~TFactory() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(const TArrayAllocation& EntriesAllocation);

	void Unregister(size_t szN = 1);

	void Register(	TEntry::TCreator*	pCreator,
					type_t				tpType,
					size_t				szAmt = 1);

	ObjectType* Create(type_t tpType) const;
};

template <class ObjectType>
TFactory<ObjectType>::TFactory()
{
	m_bAllocated = false;
}

template <class ObjectType>
void TFactory<ObjectType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		m_Entries.Release();
	}
}

template <class ObjectType>
void TFactory<ObjectType>::Allocate(const TArrayAllocation&	EntriesAllocation)
{
	Release();

	try
	{
		m_Entries.Allocate(EntriesAllocation);

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class ObjectType>
void TFactory<ObjectType>::Unregister(size_t szN)
{
	DEBUG_VERIFY_ALLOCATION;

	if(szN > m_Entries.GetN())
	{
		INITIATE_DEFINED_FAILURE(KString::Formatted(TEXT("Attempt to remove %u records while there exists only %u in the factory."),
														szN,
														m_Entries.GetN()));
	}

	m_Entries.Del(m_Entries.GetN() - szN, m_Entries.GetN());
}

template <class ObjectType>
void TFactory<ObjectType>::Register(TEntry::TCreator*	pCreator,
									type_t				tpType,
									size_t				szAmt)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(pCreator);

	m_Entries.Add().Set(TPSEGMENT(tpType, tpType + szAmt), pCreator);
}

template <class ObjectType>
ObjectType* TFactory<ObjectType>::Create(type_t tpType) const
{
	size_t i;

	DEBUG_VERIFY_ALLOCATION;

	if(tpType == OBJECT_TYPE_BASIC)
		INITIATE_DEFINED_FAILURE(TEXT("Attempt to create basic object type via the factory."));

	for(i = 0 ; i < m_Entries.GetN() ; i++)
	{
		if(HitsSegment(tpType, m_Entries[i].m_Types))
			return m_Entries[i].m_pCreator(tpType);
	}

	INITIATE_DEFINED_FAILURE(	KString::Formatted(	TEXT("Unregistered object type %u in request to the factory."),
														tpType));
}

// -------------------------
// Factory types registerer
// -------------------------
template <class ObjectType>
class TFactoryTypesRegisterer
{
private:
	bool m_bAllocated;

	TFactory<ObjectType>* m_pFactory;

	size_t m_szN;

public:
	TFactoryTypesRegisterer();

	TFactoryTypesRegisterer(TFactory<ObjectType>& SFactory);

	~TFactoryTypesRegisterer() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);
	
	void Allocate(TFactory<ObjectType>& SFactory);

	void Add(	TFactory<ObjectType>::TEntry::TCreator*	pCreator,
				type_t									tpType,
				size_t									szAmt = 1);

	// ---------------- TRIVIALS ----------------
	TFactory<ObjectType>& GetFactory() { return *m_pFactory; }

	const TFactory<ObjectType>& GetFactory() const { return *m_pFactory; }

	size_t GetN() const { return m_szN; }
};

template <class ObjectType>
TFactoryTypesRegisterer<ObjectType>::TFactoryTypesRegisterer()
{
	m_bAllocated = false;

	m_szN = 0;
}

template <class ObjectType>
TFactoryTypesRegisterer<ObjectType>::TFactoryTypesRegisterer(TFactory<ObjectType>& SFactory)
{
	m_bAllocated = false;

	m_szN = 0;

	Allocate(SFactory);
}

template <class ObjectType>
void TFactoryTypesRegisterer<ObjectType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		if(m_pFactory && !m_pFactory->IsEmpty())
			m_pFactory->Unregister(m_szN);
		
		m_pFactory = NULL;

		m_szN = 0;
	}
}

template <class ObjectType>
void TFactoryTypesRegisterer<ObjectType>::Allocate(TFactory<ObjectType>& SFactory)
{
	Release();

	try
	{
		DEBUG_VERIFY(!SFactory.IsEmpty());

		m_pFactory = &SFactory;

		m_szN = 0;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class ObjectType>
void TFactoryTypesRegisterer<ObjectType>::Add(	TFactory<ObjectType>::TEntry::TCreator*	pCreator,
												type_t									tpType,
												size_t									szAmt)
{
	DEBUG_VERIFY_ALLOCATION;

	m_pFactory->Register(pCreator, tpType, szAmt);

	m_szN++;
}

#endif // factory_h