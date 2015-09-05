#ifndef storage_h
#define storage_h

#include <KFC_KTL\registration_manager.h>
#include <KFC_KTL\token.h>
#include "persistence_factory.h"

// --------
// Storage
// --------
template <class ObjectType>
class TStorage
{
private:
	bool m_bAllocated;

	const TTokens* m_pStorageIndexTokens;

protected:
	virtual void LoadByDirectValue(	const KString&				FileName,
									TObjectPointer<ObjectType>&	RObject,
									bool						bOmittable) = 0;

public:
	TPersistenceFactory<ObjectType>		m_Factory;
	TRegistrationManager<ObjectType>	m_RegistrationManager;


	TStorage();

	~TStorage() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(	const TArrayAllocation&	FactoryEntriesAllocation,
					const TTokens&			FactoryTypeTokens,
					const TArrayAllocation&	RegistrationManagerStorageAllocation,
					size_t					szNRegistrationManagerFixedEntries,
					const TTokens&			SStorageIndexTokens);

	void LoadObjectByValue(	const KString&					FileName,
							TObjectPointer	<ObjectType>&	RObject,
							bool							bOmittable);

	void LoadObject(TInfoNodeConstIterator		InfoNode,
					const KString&				Name,
					TObjectPointer<ObjectType>&	RObject,
					bool						bOmittable);

	void LoadObjects(	TInfoNodeConstIterator		InfoNode,
						KString						Name, // altered inside
						LPCTSTR						pMaskAlphabet,
						TObjectPointer<ObjectType>*	pRObjects,
						const size_t*				pLimits,
						const bool*					pOmittables); // NULL means all required

	// ---------------- TRIVIALS ----------------
	const TTokens& GetStorageIndexTokens() const { return *m_pStorageIndexTokens; }
};

template <class ObjectType>
TStorage<ObjectType>::TStorage()
{
	m_bAllocated = false;
}

template <class ObjectType>
void TStorage<ObjectType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		m_RegistrationManager.Release();

		m_Factory.Release();
	}
}

template <class ObjectType>
void TStorage<ObjectType>::Allocate(const TArrayAllocation&	FactoryEntriesAllocation,
									const TTokens&			FactoryTypeTokens,
									const TArrayAllocation&	RegistrationManagerStorageAllocation,
									size_t					szNRegistrationManagerFixedEntries,
									const TTokens&			SStorageIndexTokens)
{
	Release();

	try
	{
		m_Factory.Allocate(	FactoryEntriesAllocation,
							FactoryTypeTokens);

		m_RegistrationManager.Allocate(	RegistrationManagerStorageAllocation,
										szNRegistrationManagerFixedEntries);

		m_pStorageIndexTokens = &SStorageIndexTokens;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class ObjectType>
void TStorage<ObjectType>::LoadObjectByValue(	const KString&					FileName,
												TObjectPointer	<ObjectType>&	RObject,
												bool							bOmittable)
{
	DEBUG_VERIFY_ALLOCATION;

	if(FileName.IsEmpty())
	{
		RObject.Release();
		return;
	}

	if(FileName[0] == TEXT('#'))
	{
		size_t szIndex;
		ReadUINT(	m_pStorageIndexTokens->Process(FileName.Mid(1)),
					szIndex,
					TEXT("storage object index"));

		if(m_RegistrationManager.IsValidIndex(szIndex))
		{
			RObject.Allocate(m_RegistrationManager[szIndex], true);
		}					
		else if(!bOmittable)
		{
			INITIATE_DEFINED_FAILURE(TEXT("Invalid storage object index"));
		}
	}
	else
	{
		LoadByDirectValue(FileName, RObject, bOmittable);
	}
}

template <class ObjectType>
void TStorage<ObjectType>::LoadObject(	TInfoNodeConstIterator		InfoNode,
										const KString&				Name,
										TObjectPointer<ObjectType>&	RObject,
										bool						bOmittable)
{
	DEBUG_VERIFY_ALLOCATION;

	TInfoNodeConstIterator		NIter;
	TInfoParameterConstIterator	PIter;

	NIter = TStructuredInfo::FindNode(InfoNode, Name);
	PIter = InfoNode->FindParameter(Name);

	if(NIter.IsValid() && PIter.IsValid())
		INITIATE_DEFINED_FAILURE(TEXT("Ambiguity: both simple and expanded definitions of an object provided."));

	if(NIter.IsValid()) // expanded
	{
		RObject.Allocate(m_Factory.Load(NIter), false);
	}
	else if(PIter.IsValid()) // simple
	{
		LoadObjectByValue(PIter->m_Value, RObject, false);
	}
	else // no definition
	{
		if(!bOmittable)
			INITIATE_DEFINED_FAILURE((KString)TEXT("Object \"") + Name + TEXT("\" definition not found."));
	}
}

template <class ObjectType>
void TStorage<ObjectType>::LoadObjects(	TInfoNodeConstIterator		InfoNode,
										KString						Name,
										LPCTSTR						pMaskAlphabet,
										TObjectPointer<ObjectType>*	pRObjects,
										const size_t*				pLimits,
										const bool*					pOmittables)
{
	DEBUG_VERIFY_ALLOCATION;

	TInfoParameterConstIterator PIter;

	size_t i;

	const size_t szNDimensions = _tcslen(pMaskAlphabet);

	DEBUG_VERIFY(szNDimensions < MAX_SET_LOADING_DIMENSIONS);

#ifdef _DEBUG
	for(i = 0 ; i < szNDimensions ; i++)
		DEBUG_VERIFY(pLimits[i] < MAX_ALPHABET_RADIX);
#endif // _DEBUG

	TObjectPointer<ObjectType>*	pCurObject;
	const bool*					pCurOmittable;

	size_t szCurValues[MAX_SET_LOADING_DIMENSIONS];
	memset(szCurValues, 0, sizeof(szCurValues));

	size_t szCurPos;

	// ---- Preparing ----

	// Fetching name mask alphabet positions
	size_t szMaskAlphabetNamePos[MAX_SET_LOADING_DIMENSIONS];

	for(i = 0 ; i < szNDimensions ; i++)
	{
		szMaskAlphabetNamePos[i] = Name.Find(pMaskAlphabet[i]);

		DEBUG_VERIFY(szMaskAlphabetNamePos[i] != UINT_MAX);
	}

	// ---- Loading ----
	if((PIter = InfoNode->FindParameter(Name)).IsValid()) // set loading
	{
		KString Value = PIter->m_Value;

		// Fetching value mask alphabet positions
		size_t szMaskAlphabetValuePos[MAX_SET_LOADING_DIMENSIONS];

		for(i = 0 ; i < szNDimensions ; i++)
		{
			szMaskAlphabetValuePos[i] = Value.Find(pMaskAlphabet[i]);

			if(szMaskAlphabetValuePos[i] == UINT_MAX)
			{
				INITIATE_DEFINED_FAILURE(	(KString)TEXT("Mutliple objects loading value does not contain required mask alphabet character '") +
												pMaskAlphabet[i] +
												TEXT("'\"."));
			}
		}

		// Settting initial value mask values
		for(i = 0 ; i < szNDimensions ; i++)
		{
			Value.SetChar(	szMaskAlphabetValuePos[i],
							KString::ValueToAlphabet(szCurValues[i]));
		}
		
		// Loading
		for(pCurObject = pRObjects, pCurOmittable = pOmittables ; ;
			pCurObject++, pCurOmittable += pCurOmittable ? 1 : 0)
		{
			// Operation
			LoadObjectByValue(	Value,
								*pCurObject,
								pCurOmittable ? *pCurOmittable : false);

			// Iteration
			for(szCurPos = szNDimensions - 1 ; szCurPos != UINT_MAX ; szCurPos--)
			{
				if(++szCurValues[szCurPos] == pLimits[szCurPos])
					szCurValues[szCurPos] = 0;

				Value.SetChar(	szMaskAlphabetValuePos[szCurPos],
								KString::ValueToAlphabet(szCurValues[szCurPos]));

				if(szCurValues[szCurPos] > 0) // no recursion here
					break;
			}

			if(szCurPos == UINT_MAX)
				break;
		}
	}
	else // per-value loading
	{
		// Setting initial name mask values
		for(i = 0 ; i < szNDimensions ; i++)
		{
			Name.SetChar(	szMaskAlphabetNamePos[i],
							KString::ValueToAlphabet(szCurValues[i]));
		}

		// Loading
		for(pCurObject = pRObjects, pCurOmittable = pOmittables ; ;
			pCurObject++, pCurOmittable += pCurOmittable ? 1 : 0)
		{
			// Operation
			LoadObject(	InfoNode,
						Name,
						*pCurObject,
						pCurOmittable ? *pCurOmittable : false);

			// Iteration
			for(szCurPos = szNDimensions - 1 ; szCurPos != UINT_MAX ; szCurPos--)
			{
				if(++szCurValues[szCurPos] == pLimits[szCurPos])
					szCurValues[szCurPos] = 0;

				Name.SetChar(	szMaskAlphabetNamePos[szCurPos],
								KString::ValueToAlphabet(szCurValues[szCurPos]));

				if(szCurValues[szCurPos] > 0) // no recursion here
					break;
			}

			if(szCurPos == UINT_MAX)
				break;
		}
	}
}

#endif // storage_h