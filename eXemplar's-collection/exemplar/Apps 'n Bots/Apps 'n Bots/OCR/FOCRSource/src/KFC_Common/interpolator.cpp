#include "kfc_common_pch.h"
#include "interpolator.h"

// ---------------------
// Interpolator storage
// ---------------------
TInterpolatorHandle TInterpolatorStorage::FindInterpolator(size_t szID)
{
	DEBUG_VERIFY_ALLOCATION;
	
	DEBUG_VERIFY(szID != INTERPOLATOR_ID_NONE);

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		if(Handle->GetID() == szID)
			return Handle;

	return NULL;
}

TInterpolatorIterator TInterpolatorStorage::FindInterpolator(size_t szID) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(szID != INTERPOLATOR_ID_NONE);

	for(TInterpolatorIterator Iter = GetFirst() ; Iter.IsValid() ; ++Iter)
		if(Iter->GetID() == szID)
			return Iter;

	return NULL;
}

TInterpolatorHandle TInterpolatorStorage::GetInterpolator(size_t szID)
{
	TInterpolatorHandle Handle = FindInterpolator(szID);

	if(!Handle.IsValid())
	{
		INITIATE_DEFINED_FAILURE((KString)TEXT("Interpolator with ID ") + szID + TEXT(" not found."));
	}

	return Handle;
}

TInterpolatorIterator TInterpolatorStorage::GetInterpolator(size_t szID) const
{
	TInterpolatorIterator Iter = FindInterpolator(szID);

	if(!Iter.IsValid())
	{
		INITIATE_DEFINED_FAILURE((KString)TEXT("Interpolator with ID ") + szID + TEXT(" not found."));
	}

	return Iter;
}

// -------------
// Interpolator
// -------------
TInterpolator::TInterpolator(size_t szSID)
{
	m_bAllocated = false;
	
	m_szID = szSID;

	m_szUserData	= 0;
	m_pUserData		= NULL;
}

void TInterpolator::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;
	}
}

void TInterpolator::Allocate()
{
	Release();

	try
	{
		ResetSuspendCount();

		m_bActive = false;

		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TInterpolator::OnActivate()
{
	DEBUG_VERIFY_ALLOCATION;

	m_bActive = true;
}

void TInterpolator::OnActivate(const float& fSTargetSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	m_bActive = true;
}

void TInterpolator::OnDeactivate()
{
	DEBUG_VERIFY_ALLOCATION;

	m_bActive = false;
}

float TInterpolator::OnGetSpeedCoef()
{
	DEBUG_VERIFY_ALLOCATION;

	return 1.0f;
}

void TInterpolator::OnSetSpeedCoef(float fSSpeedCoef)
{
	DEBUG_VERIFY_ALLOCATION;
}

bool TInterpolator::OnUpdate()
{
	DEBUG_VERIFY_ALLOCATION;

	return false;
}

bool TInterpolator::OnGetSrcValueLimits(FSEGMENT& RLimits)
{
	DEBUG_VERIFY_ALLOCATION;

	return true;
}

void TInterpolator::OnSetCurrentSrcValue(const float& fSCurrentSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;
}

void TInterpolator::Activate()
{
	DEBUG_VERIFY_ALLOCATION;

	OnActivate();
}

void TInterpolator::Activate(const float& fSTargetSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	OnActivate(fSTargetSrcValue);
}

void TInterpolator::Deactivate()
{
	DEBUG_VERIFY_ALLOCATION;

	if(m_bActive)
		OnDeactivate();
}

float TInterpolator::GetSpeedCoef()
{
	DEBUG_VERIFY_ALLOCATION;

	return OnGetSpeedCoef();
}

void TInterpolator::SetSpeedCoef(float fSSpeedCoef)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(fSSpeedCoef > 0.0f);

	OnSetSpeedCoef(fSSpeedCoef);
}

bool TInterpolator::Update(	TMessageProcessor*	pMessageProcessor,
							TInterpolatorHandle	Handle)
{
	DEBUG_VERIFY_ALLOCATION;

	if(!IsActive())
		return false;

	if(OnUpdate())
	{
		Deactivate();

		if(pMessageProcessor)
			new(*pMessageProcessor) TInterpolatorFinishedMessage(Handle);

		return true;
	}

	return false;
}

bool TInterpolator::GetSrcValueLimits(FSEGMENT& RLimits)
{
	DEBUG_VERIFY_ALLOCATION;

	return OnGetSrcValueLimits(RLimits);
}

FSEGMENT TInterpolator::GetSrcValueLimits(bool* pRValid)
{
	DEBUG_VERIFY_ALLOCATION;

	FSEGMENT Limits;
	bool bValid = GetSrcValueLimits(Limits);

	DEBUG_VERIFY(bValid);

	if(pRValid)
		*pRValid = bValid;

	return Limits;
}

void TInterpolator::SetCurrentSrcValue(const float& fSCurrentSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	OnSetCurrentSrcValue(fSCurrentSrcValue);
}

// -----------------------
// Reference interpolator
// -----------------------
TReferenceInterpolator::TReferenceInterpolator(size_t szSID) : TInterpolator(szSID)
{
	m_bAllocated = false;
}

void TReferenceInterpolator::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		TInterpolator::Release();
	}
}

void TReferenceInterpolator::Allocate(TInterpolator* pSInterpolator)
{
	Release();

	try
	{
		DEBUG_VERIFY(pSInterpolator != NULL);

		TInterpolator::Allocate();

		m_pInterpolator = pSInterpolator;

		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TReferenceInterpolator::OnActivate()
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnActivate();

	m_pInterpolator->Activate();
}

void TReferenceInterpolator::OnActivate(const float& fSTargetSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnActivate(fSTargetSrcValue);

	m_pInterpolator->Activate(fSTargetSrcValue);
}

void TReferenceInterpolator::OnDeactivate()
{
	DEBUG_VERIFY_ALLOCATION;

	m_pInterpolator->Deactivate();

	TInterpolator::OnDeactivate();
}

float TReferenceInterpolator::OnGetSpeedCoef()
{
	DEBUG_VERIFY_ALLOCATION;

	return	TInterpolator::OnGetSpeedCoef() *
			m_pInterpolator->GetSpeedCoef();
}

void TReferenceInterpolator::OnSetSpeedCoef(float fSSpeedCoef)
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnSetSpeedCoef(fSSpeedCoef);

	m_pInterpolator->SetSpeedCoef(fSSpeedCoef);
}

bool TReferenceInterpolator::OnSuspend()
{
	if(IsEmpty())
		return false;

	if(!TInterpolator::OnSuspend())
		return false;

	m_pInterpolator->Suspend();
	
	return true;
}

bool TReferenceInterpolator::OnResume()
{
	if(IsEmpty())
		return false;

	if(!TInterpolator::OnResume())
		return false;

	m_pInterpolator->Resume();

	return true;
}

bool TReferenceInterpolator::OnUpdate()
{
	DEBUG_VERIFY_ALLOCATION;

	if(TInterpolator::OnUpdate())
		return true;

	return m_pInterpolator->Update();
}

bool TReferenceInterpolator::OnGetSrcValueLimits(FSEGMENT& RLimits)
{
	DEBUG_VERIFY_ALLOCATION;

	if(!TInterpolator::OnGetSrcValueLimits(RLimits))
		return false;

	return m_pInterpolator->GetSrcValueLimits(RLimits);
}

void TReferenceInterpolator::OnSetCurrentSrcValue(const float& fSCurrentSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnSetCurrentSrcValue(fSCurrentSrcValue);

	m_pInterpolator->SetCurrentSrcValue(fSCurrentSrcValue);
}

// ----------------------
// Compound interpolator
// ----------------------
TCompoundInterpolator::TCompoundInterpolator(size_t szSID) : TInterpolator(szSID)
{
	m_bAllocated = false;
}

void TCompoundInterpolator::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;
		
		TInterpolatorStorage::Release();

		TInterpolator::Release();
	}
}

void TCompoundInterpolator::Allocate(size_t szMinPortionSize)
{
	Release();

	try
	{
		TInterpolator::Allocate();

		TInterpolatorStorage::Allocate(szMinPortionSize);

		m_szNActive = 0;

		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TCompoundInterpolator::OnActivate()
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnActivate();

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		Handle->Activate();

	m_szNActive = GetN();
}

void TCompoundInterpolator::OnActivate(const float& fSTargetSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnActivate(fSTargetSrcValue);

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		Handle->Activate(fSTargetSrcValue);

	m_szNActive = TInterpolatorStorage::GetN();
}

void TCompoundInterpolator::OnDeactivate()
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnDeactivate();

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		Handle->Deactivate();
}

float TCompoundInterpolator::OnGetSpeedCoef()
{
	DEBUG_VERIFY_ALLOCATION;

	float fSpeedCoef = TInterpolator::OnGetSpeedCoef();
	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		fSpeedCoef *= Handle->GetSpeedCoef();

	return fSpeedCoef;
}

void TCompoundInterpolator::OnSetSpeedCoef(float fSSpeedCoef)
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnSetSpeedCoef(fSSpeedCoef);

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		Handle->SetSpeedCoef(fSSpeedCoef);
}

bool TCompoundInterpolator::OnSuspend()
{
	if(IsEmpty())
		return false;

	if(!TInterpolator::OnSuspend())
		return false;

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid(); ++Handle)
		Handle->Suspend();

	return true;
}

bool TCompoundInterpolator::OnResume()
{
	if(IsEmpty())
		return false;

	if(!TInterpolator::OnResume())
		return false;

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		Handle->Resume();

	return true;
}

bool TCompoundInterpolator::OnUpdate()
{
	DEBUG_VERIFY_ALLOCATION;

	if(TInterpolator::OnUpdate())
		return true;

	if(m_szNActive == 0)
		return false;

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		if(Handle->Update())
			m_szNActive--;

	return m_szNActive == 0;
}

bool TCompoundInterpolator::OnGetSrcValueLimits(FSEGMENT& RLimits)
{
	DEBUG_VERIFY_ALLOCATION;

	if(!TInterpolator::OnGetSrcValueLimits(RLimits))
		return false;

	bool bFirst = true;
	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
	{
		FSEGMENT CurLimits;
		if(Handle->GetSrcValueLimits(CurLimits))
		{
			if(bFirst)
			{
				RLimits = CurLimits;

				bFirst = false;
			}
			else
			{
				if(CurLimits.m_First < RLimits.m_First)
					RLimits.m_First = CurLimits.m_First;

				if(CurLimits.m_Last > RLimits.m_Last)
					RLimits.m_Last = CurLimits.m_Last;
			}
		}
	}

	return !bFirst;
}

void TCompoundInterpolator::OnSetCurrentSrcValue(const float& fSCurrentSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnSetCurrentSrcValue(fSCurrentSrcValue);

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		Handle->SetCurrentSrcValue(fSCurrentSrcValue);
}

// ----------------------------
// Linear segment value mapper
// ----------------------------
void TLinearSegmentValueMapper::MapSegmentValue(float&			SrcValue,
												const FSEGMENT&	Segment)
{
}

// ----------------------------
// Square segment value mapper
// ----------------------------
void TSquareSegmentValueMapper::MapSegmentValue(float&			SrcValue,
												const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(0.0f, 1.0f), SrcValue, fValue);

	fValue *= fValue;

	ResizeValue(FSEGMENT(0.0f, 1.0f), Segment, fValue, SrcValue);
}

// -------------------------------------
// Inversed square segment value mapper
// -------------------------------------
void TInversedSquareSegmentValueMapper::MapSegmentValue(float&			SrcValue,
														const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(0.0f, 1.0f), SrcValue, fValue);

	fValue =	1.0f - fValue;
	fValue *=	fValue;
	fValue =	1.0f - fValue;

	ResizeValue(FSEGMENT(0.0f, 1.0f), Segment, fValue, SrcValue);
}

// ---------------------------
// Cubic segment value mapper
// ---------------------------
void TCubicSegmentValueMapper::MapSegmentValue(	float&			SrcValue,
												const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(0.0f, 1.0f), SrcValue, fValue);

	fValue = fValue * fValue * fValue;

	ResizeValue(FSEGMENT(0.0f, 1.0f), Segment, fValue, SrcValue);
}

// ------------------------------------
// Inversed cubic segment value mapper
// ------------------------------------
void TInversedCubicSegmentValueMapper::MapSegmentValue(	float&			SrcValue,
														const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(0.0f, 1.0f), SrcValue, fValue);

	fValue =	1.0f - fValue;
	fValue *=	fValue * fValue;
	fValue =	1.0f - fValue;

	ResizeValue(FSEGMENT(0.0f, 1.0f), Segment, fValue, SrcValue);
}

// -----------------------------
// Quadric segment value mapper
// -----------------------------
void TQuadricSegmentValueMapper::MapSegmentValue(	float&			SrcValue,
													const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(0.0f, 1.0f), SrcValue, fValue);

	fValue *= fValue;
	fValue *= fValue;

	ResizeValue(FSEGMENT(0.0f, 1.0f), Segment, fValue, SrcValue);
}

// --------------------------------------
// Inversed quadric segment value mapper
// --------------------------------------
void TInversedQuadricSegmentValueMapper::MapSegmentValue(float&			SrcValue,
														const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(0.0f, 1.0f), SrcValue, fValue);

	fValue =	1.0f - fValue;
	fValue *=	fValue;
	fValue *=	fValue;
	fValue =	1.0f - fValue;

	ResizeValue(FSEGMENT(0.0f, 1.0f), Segment, fValue, SrcValue);
}

// --------------------------------
// Rough zero segment value mapper
// --------------------------------
void TRoughZeroSegmentValueMapper::MapSegmentValue(	float&			SrcValue,
													const FSEGMENT&	Segment)
{
	SrcValue = Compare(SrcValue, Segment.m_First) == 0 ? Segment.m_First : Segment.m_Last;
}

// -------------------------------
// Rough one segment value mapper
// -------------------------------
void TRoughOneSegmentValueMapper::MapSegmentValue(	float&			SrcValue,
													const FSEGMENT&	Segment)
{
	SrcValue = Compare(SrcValue, Segment.m_Last) == 0 ? Segment.m_Last : Segment.m_First;
}

// -----------------------
// Interpolator processor
// -----------------------
TInterpolatorProcessor::TInterpolatorProcessor()
{
	m_bAllocated = false;
}

void TInterpolatorProcessor::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		m_MessageProcessor.Release();

		TInterpolatorStorage::Release();
	}
}

void TInterpolatorProcessor::Allocate(	size_t szMinPortionSize,
										size_t szMessageProcessorMinPortionSize)
{
	Release();

	try
	{
		TInterpolatorStorage::Allocate(szMinPortionSize);

		m_MessageProcessor.Allocate(szMessageProcessorMinPortionSize);

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

bool TInterpolatorProcessor::OnSuspend()
{
	if(IsEmpty())
		return false;

	if(!TSuspendable::OnSuspend())
		return false;
	
	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		Handle->Suspend();

	return true;
}

bool TInterpolatorProcessor::OnResume()
{
	if(IsEmpty())
		return false;

	if(!TSuspendable::OnResume())
		return false;

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		Handle->Resume();

	return true;
}

void TInterpolatorProcessor::Update()
{
	DEBUG_VERIFY_ALLOCATION;

	m_MessageProcessor.Clear();

	for(TInterpolatorHandle Handle = GetFirst() ; Handle.IsValid() ; ++Handle)
		Handle->Update(&m_MessageProcessor, Handle);
}

TMessageIterator TInterpolatorProcessor::GetFirstMessage() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_MessageProcessor.GetFirst();
}
