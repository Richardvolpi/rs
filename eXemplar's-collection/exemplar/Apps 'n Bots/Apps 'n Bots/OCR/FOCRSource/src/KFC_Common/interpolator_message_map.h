#ifndef interpolator_message_map_h
#define interpolator_message_map_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_bitypes.h>
#include "interpolator_message_defs.h"
#include "common_consts.h"
// #include "interpolator.h" // cross-inclusion

// -------------------------
// Interpolator message map
// -------------------------
template <class ClassType>
class TInterpolatorMessageMap
{
private:
	bool m_bAllocated;

public:
	typedef void (ClassType::*TFinishedHandler)(TInterpolatorHandle Handle);

private:
	ClassType*						m_pObject;
	const TInterpolatorProcessor*	m_pInterpolatorProcessor;

	struct TFinishedEntry
	{
		TFinishedHandler	m_Handler;
		SZSEGMENT			m_IDs;


		void Set(	TFinishedHandler	SHandler,
					size_t				szFirstID,
					size_t				szAmt = 1)
		{
			m_Handler = SHandler;
			m_IDs.Set(szFirstID, szFirstID + szAmt);
		}
	};

	TValueArray<TFinishedEntry, true> m_FinishedEntries;

public:
	TInterpolatorMessageMap();
	
	~TInterpolatorMessageMap() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(	ClassType&						SObject,
					const TInterpolatorProcessor&	SInterpolatorProcessor,
					const TArrayAllocation&			FinisnedAllocation =
						g_CommonConsts.m_DefaultInterpolatorFinishedMessageMapAllocation);

	void AddFinishedEntry(	TFinishedHandler	Handler,
							size_t				szFirstID,
							size_t				szAmt = 1);

	void ProcessMessages() const;
};

template <class ClassType>
TInterpolatorMessageMap<ClassType>::TInterpolatorMessageMap()
{
	m_bAllocated = false;

	m_pObject					= NULL;
	m_pInterpolatorProcessor	= NULL;
}

template <class ClassType>
void TInterpolatorMessageMap<ClassType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;
		
		m_FinishedEntries.Release();

		m_pObject					= NULL;
		m_pInterpolatorProcessor	= NULL;
	}
}

template <class ClassType>
void TInterpolatorMessageMap<ClassType>::Allocate(	ClassType&						SObject,
													const TInterpolatorProcessor&	SInterpolatorProcessor,
													const TArrayAllocation&			FinisnedAllocation)
{
	Release();

	try
	{
		m_pObject					= &SObject;
		m_pInterpolatorProcessor	= &SInterpolatorProcessor;

		m_FinishedEntries.Allocate(FinisnedAllocation);

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class ClassType>
void TInterpolatorMessageMap<ClassType>::AddFinishedEntry(	TFinishedHandler	Handler,
															size_t				szFirstID,
															size_t				szAmt)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(szFirstID != INTERPOLATOR_ID_NONE);
	DEBUG_VERIFY(szAmt > 0);	

	m_FinishedEntries.Add().Set(Handler, szFirstID, szAmt);
}

template <class ClassType>
void TInterpolatorMessageMap<ClassType>::ProcessMessages() const
{
	DEBUG_VERIFY_ALLOCATION;

	size_t i;

	for(TMessageIterator Iter = m_pInterpolatorProcessor->GetFirstMessage() ;
		Iter.IsValid() ;
		++Iter)
	{
		// Interpolator finished message
		{
			const TInterpolatorFinishedMessage* pMessage;

			if(pMessage = dynamic_cast<const TInterpolatorFinishedMessage*>(Iter.GetDataPtr()))
			{
				const TInterpolatorHandle Handle = pMessage->m_InterpolatorHandle;
				
				if(	Handle->GetID() != INTERPOLATOR_ID_NONE &&
					!Handle->IsActive())
				{
					for(i = 0 ; i < m_FinishedEntries.GetN() ; i++)
					{
						if(HitsSegment(	Handle->GetID(),
										m_FinishedEntries[i].m_IDs))
						{
							(m_pObject->*m_FinishedEntries[i].m_Handler)
								(Handle);
						}
					}
				}
			}
		}
	}
}

#endif // interpolator_message_map_h
