#ifndef interpolator_h
#define interpolator_h

#include <math.h>
#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_bitypes.h>
#include <KFC_KTL\suspendable.h>
#include "kfc_common_api.h"
#include "interpolator_defs.h"
#include "message.h"
#include "timer.h"
#include "common_consts.h"
#include "interpolator_macros.h"
#include "interpolator_defs.h"
#include "interpolator_message_defs.h"
#include "interpolator_message_map.h"

// ---------------------
// Interoolator storage
// ---------------------
class KFC_COMMON_API TInterpolatorStorage : public TStackedStorage<TInterpolator>
{
public:
	TInterpolatorHandle		FindInterpolator(size_t szID);
	TInterpolatorIterator	FindInterpolator(size_t szID) const;

	TInterpolatorHandle		GetInterpolator(size_t szID);
	TInterpolatorIterator	GetInterpolator(size_t szID) const;
};

// -------------
// Interpolator
// -------------
class KFC_COMMON_API TInterpolator : public TSuspendable
{
private:
	bool m_bAllocated;
	
	size_t m_szID;

	bool m_bActive;

protected:
	virtual void OnActivate		();
	virtual void OnActivate		(const float& fSTargetSrcValue);
	virtual void OnDeactivate	();

	virtual float	OnGetSpeedCoef();
	virtual void	OnSetSpeedCoef(float fSSpeedCoef);
	
	virtual bool OnUpdate();

	virtual bool OnGetSrcValueLimits(FSEGMENT& RLimits);

	virtual void OnSetCurrentSrcValue(const float& fSCurrentSrcValue);

public:
	union
	{
		size_t	m_szUserData;
		void*	m_pUserData;
	};


	TInterpolator(size_t szSID = INTERPOLATOR_ID_NONE);

	virtual ~TInterpolator() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate();

	void Activate	();
	void Activate	(const float& fSTargetSrcValue);
	void Deactivate	();

	float	GetSpeedCoef();
	void	SetSpeedCoef(float fSSpeedCoef);
	
	bool Update(TMessageProcessor*	pMessageProcessor	= NULL,
				TInterpolatorHandle	Handle				= NULL);

	bool GetSrcValueLimits(FSEGMENT& RLimits);

	FSEGMENT GetSrcValueLimits(bool* pRValid = NULL);

	void SetCurrentSrcValue(const float& fSCurrentSrcValue);

	void* operator new(size_t szSize) { return kfc_malloc(szSize); }

	void operator delete(void* pPtr) { if(pPtr) kfc_free(pPtr); }

	void* operator new (size_t					szSize,
						TInterpolatorStorage&	Storage)

		{ return Storage.AllocateData(szSize); }

	void operator delete(void*, TInterpolatorStorage&) {}

	// ---------------- TRIVIALS ----------------
	size_t GetID() const { return m_szID; }

	bool IsActive() const { return m_bActive; }
};

// -----------------------
// Reference interpolator
// -----------------------
class KFC_COMMON_API TReferenceInterpolator : public TInterpolator
{
private:
	bool m_bAllocated;

	TInterpolator* m_pInterpolator;


	void OnActivate		();
	void OnActivate		(const float& fSTargetSrcValue);
	void OnDeactivate	();

	float	OnGetSpeedCoef();
	void	OnSetSpeedCoef(float fSSpeedCoef);

	bool OnSuspend	();
	bool OnResume	();

	bool OnUpdate();

	bool OnGetSrcValueLimits(FSEGMENT& RLimits);

	void OnSetCurrentSrcValue(const float& fSCurrentSrcValue);

public:
	TReferenceInterpolator(size_t szSID = INTERPOLATOR_ID_NONE);

	~TReferenceInterpolator() { Release(); }

	bool IsEmpty() const
		{ return TInterpolator::IsEmpty() || !m_bAllocated; }

	void Release(bool fFromAllocatorException = false);

	void Allocate(TInterpolator* pSInterpolator);

	// ---------------- TRIVIALS ----------------
	const TInterpolator* GetInterpolator() const { return m_pInterpolator; }
};

// ----------------------
// Compound interpolator
// ----------------------
class KFC_COMMON_API TCompoundInterpolator :
	public TInterpolator,
	public TInterpolatorStorage

{
private:
	bool m_bAllocated;

	size_t m_szNActive;


	void OnActivate		();
	void OnActivate		(const float& fSTargetSrcValue);
	void OnDeactivate	();

	float	OnGetSpeedCoef();
	void	OnSetSpeedCoef(float fSSpeedCoef);

	bool OnSuspend	();
	bool OnResume	();

	bool OnUpdate();

	bool OnGetSrcValueLimits(FSEGMENT& RLimits);

	void OnSetCurrentSrcValue(const float& fSCurrentSrcValue);
	
public:
	TCompoundInterpolator(size_t szSID = INTERPOLATOR_ID_NONE);

	~TCompoundInterpolator() { Release(); }

	bool IsEmpty() const
		{ return	TInterpolator::			IsEmpty() ||
					TInterpolatorStorage::	IsEmpty() ||
					!m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(	size_t szMinPortionSize =
						g_CommonConsts.m_szDefaultCompoundInterpolatorMinPortionSize);

	// ---------------- TRIVIALS ----------------
	size_t GetNActive() const { return m_szNActive; }
};

// --------------------------
// Value mapper interpolator
// --------------------------
template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

class TValueMapperInterpolator :
	public TInterpolator,
	public SrcValueGetterType,
	public DstValueSetterType,
	public ValueMapperType
{
private:
	bool m_bAllocated;

private:
	void OnActivate		();
	void OnActivate		(const SrcValueType& STargetSrcValue);
	void OnDeactivate	();

	float	OnGetSpeedCoef();
	void	OnSetSpeedCoef(float fSSpeedCoef);

	bool OnSuspend	();
	bool OnResume	();

	bool OnUpdate();

	bool OnGetSrcValueLimits(FSEGMENT& RLimits);

	void OnSetCurrentSrcValue(const SrcValueType& SCurrentSrcValue);
	
public:
	TValueMapperInterpolator(size_t szSID = INTERPOLATOR_ID_NONE);

	~TValueMapperInterpolator() { Release(); }

	bool IsEmpty() const
	{
		return	TInterpolator::IsEmpty()			||
				GetSrcValueGetter	().IsEmpty()	||
				GetDstValueSetter	().IsEmpty()	||
				GetValueMapper		().IsEmpty()	||
				!m_bAllocated;
	}

	void Release(bool bFromAllocatorException = false);

	void Allocate();

	// ---------------- TRIVIALS ----------------
	SrcValueGetterType&	GetSrcValueGetter	() { return *static_cast<SrcValueGetterType*>	(this); }
	DstValueSetterType&	GetDstValueSetter	() { return *static_cast<DstValueSetterType*>	(this); }
	ValueMapperType&	GetValueMapper		() { return *static_cast<ValueMapperType*>		(this); }

	const SrcValueGetterType&	GetSrcValueGetter	() const { return *static_cast<const SrcValueGetterType*>	(this); }
	const DstValueSetterType&	GetDstValueSetter	() const { return *static_cast<const DstValueSetterType*>	(this); }
	const ValueMapperType&		GetValueMapper		() const { return *static_cast<const ValueMapperType*>		(this); }
};

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

TValueMapperInterpolator<	SrcValueType,
							DstValueType,
							SrcValueGetterType,
							DstValueSetterType,
							ValueMapperType>::TValueMapperInterpolator(size_t szSID) :

	TInterpolator(szSID)
		
{
	m_bAllocated = false;
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

void TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		GetValueMapper		().Release();
		GetDstValueSetter	().Release();
		GetSrcValueGetter	().Release();

		TInterpolator::Release();
	}
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

void TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::Allocate()
{
	Release();

	try
	{
		TInterpolator::Allocate();

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

void TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnActivate()
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnActivate();

	GetSrcValueGetter	().OnActivate();
	GetDstValueSetter	().OnActivate();
	GetValueMapper		().OnActivate();
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

void TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnActivate(const SrcValueType& STargetSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnActivate(STargetSrcValue);
	
	GetSrcValueGetter	().OnActivate(STargetSrcValue);
	GetDstValueSetter	().OnActivate();
	GetValueMapper		().OnActivate(STargetSrcValue);
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

void TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnDeactivate()
{
	DEBUG_VERIFY_ALLOCATION;

	GetSrcValueGetter	().OnDeactivate();
	GetDstValueSetter	().OnDeactivate();
	GetValueMapper		().OnDeactivate();

	TInterpolator::OnDeactivate();
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

float TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnGetSpeedCoef()
{
	DEBUG_VERIFY_ALLOCATION;

	return	TInterpolator::OnGetSpeedCoef() *
			GetSrcValueGetter().OnGetSpeedCoef();
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

void TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnSetSpeedCoef(float fSSpeedCoef)
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnSetSpeedCoef(fSSpeedCoef);

	GetSrcValueGetter().OnSetSpeedCoef(fSSpeedCoef);
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

bool TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnSuspend()
{
	if(IsEmpty())
		return false;

	if(!TInterpolator::OnSuspend())
		return false;

	GetSrcValueGetter	().OnSuspend();
	GetDstValueSetter	().OnSuspend();
	GetValueMapper		().OnSuspend();

	return true;
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

bool TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnResume()
{
	if(IsEmpty())
		return false;

	if(!TInterpolator::OnResume())
		return false;

	GetSrcValueGetter	().OnResume();
	GetDstValueSetter	().OnResume();
	GetValueMapper		().OnResume();

	return true;
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

bool TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnUpdate()
{
	DEBUG_VERIFY_ALLOCATION;

	if(TInterpolator::OnUpdate())
		return true;

	bool bFinished = false;

	SrcValueType SrcValue;
	DstValueType DstValue;

	GetSrcValueGetter	().GetSrcValue	(SrcValue, bFinished);
	GetValueMapper		().MapValue		(SrcValue, DstValue);
	GetDstValueSetter	().SetDstValue	(DstValue);

	return bFinished;
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

bool TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnGetSrcValueLimits(FSEGMENT& RLimits)
{
	DEBUG_VERIFY_ALLOCATION;
	
	if(!TInterpolator::OnGetSrcValueLimits(RLimits))
		return false;

	RLimits = GetSrcValueGetter().GetLimits();

	return true;
}

template <	class SrcValueType,
			class DstValueType,
			class SrcValueGetterType,
			class DstValueSetterType,
			class ValueMapperType>

void TValueMapperInterpolator<	SrcValueType,
								DstValueType,
								SrcValueGetterType,
								DstValueSetterType,
								ValueMapperType>::OnSetCurrentSrcValue(const SrcValueType& SCurrentSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TInterpolator::OnSetCurrentSrcValue(SCurrentSrcValue);

	GetSrcValueGetter().OnSetCurrentSrcValue(SCurrentSrcValue);
}

// -----------------
// Src value getter
// -----------------
template <class SrcValueType>
class TSrcValueGetter
{
private:
	bool m_bAllocated;

	TSegment<SrcValueType> m_Limits;
	
public:
	TSrcValueGetter();

	~TSrcValueGetter() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(const TSegment<SrcValueType>& SLimits);

	void OnActivate		() { DEBUG_VERIFY_ALLOCATION; }
	void OnActivate		(const SrcValueType& STargetSrcValue) { DEBUG_VERIFY_ALLOCATION; }
	void OnDeactivate	() { DEBUG_VERIFY_ALLOCATION; }

	void OnSuspend	() {}
	void OnResume	() {}

	void GetSrcValue(	SrcValueType&	RSrcValue,
						bool&			bRFinished);

	void OnSetCurrentSrcValue(SrcValueType& SCurrentSrcValue);

	// ---------------- TRIVIALS ----------------
	const TSegment<SrcValueType>& GetLimits() const { return m_Limits; }
};

template <class SrcValueType>
TSrcValueGetter<SrcValueType>::TSrcValueGetter()
{
	m_bAllocated = false;
}

template <class SrcValueType>
void TSrcValueGetter<SrcValueType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;
	}
}

template <class SrcValueType>
void TSrcValueGetter<SrcValueType>::Allocate(const TSegment<SrcValueType>& SLimits)
{
	Release();

	try
	{
		DEBUG_VERIFY(SLimits.IsValid());

		m_Limits = SLimits;

		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class SrcValueType>
void TSrcValueGetter<SrcValueType>::GetSrcValue(SrcValueType&	RSrcValue,
												bool&			bRFinished)
{
	DEBUG_VERIFY_ALLOCATION;

	BoundValue(RSrcValue, m_Limits);
}

template <class SrcValueType>
void TSrcValueGetter<SrcValueType>::OnSetCurrentSrcValue(SrcValueType& SCurrentSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	BoundValue(SCurrentSrcValue, m_Limits);
}

// -----------------
// Dst value setter
// -----------------
template <class DstValueType>
class TDstValueSetter
{
private:
	bool m_bAllocated;

public:
	TDstValueSetter();

	~TDstValueSetter() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate();

	void OnActivate		() { DEBUG_VERIFY_ALLOCATION; }
	void OnDeactivate	() { DEBUG_VERIFY_ALLOCATION; }
	
	void OnSuspend	() {}
	void OnResume	() {}

	void SetDstValue(const DstValueType& DstValue) { DEBUG_VERIFY_ALLOCATION; }
};

template <class DstValueType>
TDstValueSetter<DstValueType>::TDstValueSetter()
{
	m_bAllocated = false;
}

template <class DstValueType>
void TDstValueSetter<DstValueType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;
	}
}

template <class DstValueType>
void TDstValueSetter<DstValueType>::Allocate()
{
	Release();

	try
	{
		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

// -------------
// Value mapper
// -------------
template <class SrcValueType, class DstValueType>
class TValueMapper
{
private:
	bool m_bAllocated;

public:
	TValueMapper();

	~TValueMapper() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate();

	void OnActivate		() { DEBUG_VERIFY_ALLOCATION; }
	void OnActivate		(const SrcValueType& STargetSrcValue) { DEBUG_VERIFY_ALLOCATION; }
	void OnDeactivate	() { DEBUG_VERIFY_ALLOCATION; }

	void OnSuspend	() {}
	void OnResume	() {}
	
	void MapValue(	SrcValueType& SrcValue,
					DstValueType& RDstValue)
		{ DEBUG_VERIFY_ALLOCATION; }
};

template <class SrcValueType, class DstValueType>
TValueMapper<SrcValueType, DstValueType>::TValueMapper()
{
	m_bAllocated = false;
}

template <class SrcValueType, class DstValueType>
void TValueMapper<SrcValueType, DstValueType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;
	}
}

template <class SrcValueType, class DstValueType>
void TValueMapper<SrcValueType, DstValueType>::Allocate()
{
	Release();

	try
	{
		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

// ----------------------------
// Persistent src value getter
// ----------------------------
template <class SrcValueType>
class TPersistentSrcValueGetter : public TSrcValueGetter<SrcValueType>
{
private:
	bool m_bAllocated;

	SrcValueType m_StartSrcValue;
	SrcValueType m_TargetSrcValue;
	SrcValueType m_CurrentSrcValue;

public:
	TPersistentSrcValueGetter();

	~TPersistentSrcValueGetter() { Release(); }

	bool IsEmpty() const
		{ return TSrcValueGetter<SrcValueType>::IsEmpty() || !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(	const TSegment<SrcValueType>&	SLimits,
					const SrcValueType&				SCurrentSrcValue);

	void OnActivate();
	void OnActivate(const SrcValueType& STargetSrcValue);
	
	void GetSrcValue(	SrcValueType&	RSrcValue,
						bool&			bRFinished);

	void OnSetCurrentSrcValue(const SrcValueType& SCurrentSrcValue);

	// ---------------- TRIVIALS ----------------
	const SrcValueType& GetStartSrcValue	() const { return m_StartSrcValue;		}
	const SrcValueType& GetTargetSrcValue	() const { return m_TargetSrcValue;		}
	const SrcValueType& GetCurrentSrcValue	() const { return m_CurrentSrcValue;	}

	int GetDirection() const { return Compare(m_TargetSrcValue, m_StartSrcValue); }
};

template <class SrcValueType>
TPersistentSrcValueGetter<SrcValueType>::TPersistentSrcValueGetter()
{
	m_bAllocated = false;
}

template <class SrcValueType>
void TPersistentSrcValueGetter<SrcValueType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		TSrcValueGetter<SrcValueType>::Release();
	}
}

template <class SrcValueType>
void TPersistentSrcValueGetter<SrcValueType>::Allocate(	const TSegment<SrcValueType>&	SLimits,
														const SrcValueType&				SCurrentSrcValue)
{
	Release();

	try
	{
		TSrcValueGetter<SrcValueType>::Allocate(SLimits);

		BoundValue(m_CurrentSrcValue = SCurrentSrcValue, GetLimits());

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class SrcValueType>
void TPersistentSrcValueGetter<SrcValueType>::OnActivate()
{
	DEBUG_VERIFY_ALLOCATION;

	TSrcValueGetter<SrcValueType>::OnActivate();

	m_StartSrcValue		= m_CurrentSrcValue;
	m_TargetSrcValue	= m_StartSrcValue;
}

template <class SrcValueType>
void TPersistentSrcValueGetter<SrcValueType>::OnActivate(const SrcValueType& STargetSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TSrcValueGetter<SrcValueType>::OnActivate(STargetSrcValue);

	m_StartSrcValue = m_CurrentSrcValue;
	BoundValue(m_TargetSrcValue = STargetSrcValue, GetLimits());
}

template <class SrcValueType>
void TPersistentSrcValueGetter<SrcValueType>::GetSrcValue(	SrcValueType&	RSrcValue,
															bool&			bRFinished)
{
	DEBUG_VERIFY_ALLOCATION;
	
	const int iDirection = GetDirection();

	if(iDirection < 0)
	{
		if(RSrcValue < m_TargetSrcValue)
			RSrcValue = m_TargetSrcValue;
	}
	else if(iDirection > 0)
	{
		if(RSrcValue > m_TargetSrcValue)
			RSrcValue = m_TargetSrcValue;
	}

	TSrcValueGetter<SrcValueType>::GetSrcValue(RSrcValue, bRFinished);

	if((m_CurrentSrcValue = RSrcValue) == m_TargetSrcValue)
		bRFinished = true;
}

template <class SrcValueType>
void TPersistentSrcValueGetter<SrcValueType>::OnSetCurrentSrcValue(const SrcValueType& SCurrentSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TSrcValueGetter<SrcValueType>::OnSetCurrentSrcValue(m_CurrentSrcValue = SCurrentSrcValue);
}

// ----------------------------
// Persistent dst value setter
// ----------------------------
template <class DstValueType>
class TPersistentDstValueSetter : public TDstValueSetter<DstValueType>
{
private:
	bool m_bAllocated;

	DstValueType m_CurrentDstValue;

public:
	TPersistentDstValueSetter();

	~TPersistentDstValueSetter() { Release(); }

	bool IsEmpty() const
		{ return TDstValueSetter<DstValueType>::IsEmpty() || !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(const DstValueType& SCurrentDstValue);

	void SetDstValue(const DstValueType& DstValue);

	// ---------------- TRIVIALS ----------------
	const DstValueType& GetCurrentDstValue() const { return m_CurrentDstValue; }
};

template <class DstValueType>
TPersistentDstValueSetter<DstValueType>::TPersistentDstValueSetter()
{
	m_bAllocated = false;
}

template <class DstValueType>
void TPersistentDstValueSetter<DstValueType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		TDstValueSetter<DstValueType>::Release();
	}
}

template <class DstValueType>
void TPersistentDstValueSetter<DstValueType>::Allocate(const DstValueType& SCurrentDstValue)
{
	Release();

	try
	{
		TDstValueSetter<DstValueType>::Allocate();

		m_CurrentDstValue = SCurrentDstValue;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class DstValueType>
void TPersistentDstValueSetter<DstValueType>::SetDstValue(const DstValueType& DstValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TDstValueSetter<DstValueType>::SetDstValue(DstValue);

	m_CurrentDstValue = DstValue;
}

// ----------------------
// Time src value getter
// ----------------------
template <class SrcValueType>
class TTimeSrcValueGetter : public TPersistentSrcValueGetter<SrcValueType>
{
private:
	bool m_bAllocated;

	TTimer m_Timer;

public:
	TTimeSrcValueGetter();

	~TTimeSrcValueGetter() { Release(); }

	bool IsEmpty() const
	{
		return TPersistentSrcValueGetter<SrcValueType>::IsEmpty() ||
		!m_bAllocated;
	}

	void Release(bool bFromAllocatorException = false);

	void Allocate(	const TSegment<SrcValueType>&	SLimits,
					const SrcValueType&				SCurrentSrcValue);

	void OnActivate();
	void OnActivate(const SrcValueType& STargetSrcValue);

	float	OnGetSpeedCoef();
	void	OnSetSpeedCoef(float fSSpeedCoef);

	void OnSuspend	();
	void OnResume	();

	void GetSrcValue(	SrcValueType&	RSrcValue,
						bool&			bRFinished);
};

template <class SrcValueType>
TTimeSrcValueGetter<SrcValueType>::TTimeSrcValueGetter()
{
	m_bAllocated = false;
}

template <class SrcValueType>
void TTimeSrcValueGetter<SrcValueType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		m_Timer.Release();

		TPersistentSrcValueGetter<SrcValueType>::Release();
	}
}

template <class SrcValueType>
void TTimeSrcValueGetter<SrcValueType>::Allocate(	const TSegment<SrcValueType>&	SLimits,
													const SrcValueType&				SCurrentSrcValue)
{
	Release();

	try
	{
		TPersistentSrcValueGetter<SrcValueType>::Allocate(SLimits, SCurrentSrcValue);

		m_Timer.Allocate();

		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class SrcValueType>
void TTimeSrcValueGetter<SrcValueType>::OnActivate()
{
	DEBUG_VERIFY_ALLOCATION;

	TPersistentSrcValueGetter<SrcValueType>::OnActivate();

	m_Timer.Reset();
}

template <class SrcValueType>
void TTimeSrcValueGetter<SrcValueType>::OnActivate(const SrcValueType& STargetSrcValue)
{
	DEBUG_VERIFY_ALLOCATION;

	TPersistentSrcValueGetter<SrcValueType>::OnActivate(STargetSrcValue);

	m_Timer.Reset();
}

template <class SrcValueType>
float TTimeSrcValueGetter<SrcValueType>::OnGetSpeedCoef()
{
	DEBUG_VERIFY_ALLOCATION;

	return m_Timer.GetSpeedCoef();
}

template <class SrcValueType>
void TTimeSrcValueGetter<SrcValueType>::OnSetSpeedCoef(float fSSpeedCoef)
{
	DEBUG_VERIFY_ALLOCATION;

	m_Timer.SetSpeedCoef(fSSpeedCoef);
}

template <class SrcValueType>
void TTimeSrcValueGetter<SrcValueType>::OnSuspend()
{
	if(IsEmpty())
		return;
	
	TPersistentSrcValueGetter<SrcValueType>::OnSuspend();

	m_Timer.Suspend();
}

template <class SrcValueType>
void TTimeSrcValueGetter<SrcValueType>::OnResume()
{
	if(IsEmpty())
		return;

	TPersistentSrcValueGetter<SrcValueType>::OnResume();

	m_Timer.Resume();
}

template <class SrcValueType>
void TTimeSrcValueGetter<SrcValueType>::GetSrcValue(SrcValueType&	RSrcValue,
													bool&			bRFinished)
{
	DEBUG_VERIFY_ALLOCATION;

	RSrcValue = GetStartSrcValue();
	RSrcValue += (SrcValueType)((__int64)m_Timer.GetElapsedTime() * GetDirection());

	TPersistentSrcValueGetter<SrcValueType>::GetSrcValue(RSrcValue, bRFinished);
}

// ----------------------------
// Linear segment value mapper
// ----------------------------
class KFC_COMMON_API TLinearSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

// ----------------------------
// Square segment value mapper
// ----------------------------
class KFC_COMMON_API TSquareSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

// -------------------------------------
// Inversed square segment value mapper
// -------------------------------------
class KFC_COMMON_API TInversedSquareSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

// ---------------------------
// Cubic segment value mapper
// ---------------------------
class KFC_COMMON_API TCubicSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

// ------------------------------------
// Inversed cubic segment value mapper
// ------------------------------------
class KFC_COMMON_API TInversedCubicSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

// -----------------------------
// Quadric segment value mapper
// -----------------------------
class KFC_COMMON_API TQuadricSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

// --------------------------------------
// Inversed quadric segment value mapper
// --------------------------------------
class KFC_COMMON_API TInversedQuadricSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

// ---------------------------
// Power segment value mapper
// ---------------------------
template <float fPower>
class TPowerSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

template <float fPower>
void TPowerSegmentValueMapper<fPower>::MapSegmentValue(	float&			SrcValue,
														const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(0.0f, 1.0f), SrcValue, fValue);

	fValue = powf(fValue, fPower);

	ResizeValue(FSEGMENT(0.0f, 1.0f), Segment, fValue, SrcValue);
}

// ------------------------------------
// Inversed power segment value mapper
// ------------------------------------
template <float fPower>
class TInversedPowerSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

template <float fPower>
void TInversedPowerSegmentValueMapper<fPower>::MapSegmentValue(	float&			SrcValue,
																const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(0.0f, 1.0f), SrcValue, fValue);

	fValue = 1.0f - powf(1.0f - fValue, fPower);

	ResizeValue(FSEGMENT(0.0f, 1.0f), Segment, fValue, SrcValue);
}

// --------------------------
// Sine segment value mapper
// --------------------------
template <	float fFirstAngle,
			float fLastAngle,
			float fFirstValue,
			float fLastValue>

class TSineSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

template <	float fFirstAngle,
			float fLastAngle,
			float fFirstValue,
			float fLastValue>

void TSineSegmentValueMapper<	fFirstAngle,
								fLastAngle,
								fFirstValue,
								fLastValue>::MapSegmentValue(	float&			SrcValue,
																const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(fFirstAngle, fLastAngle), SrcValue, fValue);

	fValue = sinf(fValue);

	ResizeValue(FSEGMENT(fFirstValue, fLastValue), Segment, fValue, SrcValue);
}

// ----------------------------
// Cosine segment value mapper
// ----------------------------
template <	float fFirstAngle,
			float fLastAngle,
			float fFirstValue,
			float fLastValue>

class TCosineSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

template <	float fFirstAngle,
			float fLastAngle,
			float fFirstValue,
			float fLastValue>

void TCosineSegmentValueMapper<	fFirstAngle,
								fLastAngle,
								fFirstValue,
								fLastValue>::MapSegmentValue(	float&			SrcValue,
																const FSEGMENT&	Segment)
{
	float fValue;
	ResizeValue(Segment, FSEGMENT(fFirstAngle, fLastAngle), SrcValue, fValue);

	fValue = cosf(fValue);

	ResizeValue(FSEGMENT(fFirstValue, fLastValue), Segment, fValue, SrcValue);
}

// --------------------------------
// Rough zero segment value mapper
// --------------------------------
class KFC_COMMON_API TRoughZeroSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

// -------------------------------
// Rough one segment value mapper
// -------------------------------
class KFC_COMMON_API TRoughOneSegmentValueMapper
{
protected:
	static void MapSegmentValue(float&			SrcValue,
								const FSEGMENT&	Segment);
};

// -----------------------
// Segmented value mapper
// -----------------------
template <	class	SrcValueType,
			class	DstValueType,
			class	SegmentValueMapperType,
			size_t	szNValues>
			
class TSegmentedValueMapper :

	public TValueMapper<SrcValueType, DstValueType>,
	public SegmentValueMapperType

{
private:
	bool m_bAllocated;
	
	SrcValueType m_SrcValues[szNValues];
	DstValueType m_DstValues[szNValues];
	
public:
	TSegmentedValueMapper();

	virtual ~TSegmentedValueMapper() { Release(); }

	bool IsEmpty() const
		{ return TValueMapper<SrcValueType, DstValueType>::IsEmpty() || !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(	const SrcValueType*	pSSrcValues,
					const DstValueType*	pSDstValues);

	void MapValue(	SrcValueType& SrcValue,
					DstValueType& RDstValue);

	// ---------------- TRIVIALS ----------------
	SrcValueType* GetSrcValues() { return m_SrcValues; }
	DstValueType* GetDstValues() { return m_DstValues; }

	const SrcValueType* GetSrcValues() const { return m_SrcValues; }
	const DstValueType* GetDstValues() const { return m_DstValues; }
};

template <	class	SrcValueType,
			class	DstValueType,
			class	SegmentValueMapperType,
			size_t	szNValues>

TSegmentedValueMapper<	SrcValueType,
						DstValueType,
						SegmentValueMapperType,
						szNValues>::TSegmentedValueMapper()
{
	m_bAllocated = false;
}

template <	class	SrcValueType,
			class	DstValueType,
			class	SegmentValueMapperType,
			size_t	szNValues>

void TSegmentedValueMapper<	SrcValueType,
							DstValueType,
							SegmentValueMapperType,
							szNValues>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		TValueMapper<SrcValueType, DstValueType>::Release();
	}
}

template <	class	SrcValueType,
			class	DstValueType,
			class	SegmentValueMapperType,
			size_t	szNValues>

void TSegmentedValueMapper<	SrcValueType,
							DstValueType,
							SegmentValueMapperType,
							szNValues>::Allocate(	const SrcValueType* pSSrcValues,
													const DstValueType* pSDstValues)
{
	Release();

	try
	{
		TValueMapper<SrcValueType, DstValueType>::Allocate();

		size_t i;

#ifdef _DEBUG

		DEBUG_VERIFY(szNValues >= 2);
			
		for(i = 1 ; i < szNValues ; i++)
			DEBUG_VERIFY(pSSrcValues[i] > pSSrcValues[i - 1]);

#endif // _DEBUG

		for(i=0 ; i < szNValues ; i++)
			m_SrcValues[i] = pSSrcValues[i];

		for(i=0 ; i < szNValues ; i++)
			m_DstValues[i] = pSDstValues[i];

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <	class	SrcValueType,
			class	DstValueType,
			class	SegmentValueMapperType,
			size_t	szNValues>

void TSegmentedValueMapper<	SrcValueType,
							DstValueType,
							SegmentValueMapperType,
							szNValues>::MapValue(	SrcValueType& SrcValue,
													DstValueType& RDstValue)
{
	DEBUG_VERIFY_ALLOCATION;
	
	TValueMapper<SrcValueType, DstValueType>::MapValue(SrcValue, RDstValue);

	size_t szSegment;

	for(szSegment = 1 ; szSegment < szNValues  ; szSegment++)
		if(	SrcValue >= m_SrcValues[szSegment - 1] &&
			SrcValue <= m_SrcValues[szSegment])
		{
			break;
		}

	DEBUG_VERIFY(szSegment < szNValues);

	// Mapping segment src value
	const TSegment<SrcValueType> Segment(	m_SrcValues[szSegment - 1],
											m_SrcValues[szSegment]);

	MapSegmentValue(SrcValue, Segment);

	DEBUG_VERIFY(HitsSegmentBounds(SrcValue, Segment));

	// Evaluating dst value
	GenerateLinearTransition(	m_DstValues[szSegment - 1],
								m_DstValues[szSegment],
								(SrcValue - Segment.m_First) /
									Segment.GetLength(),
								RDstValue);
}

// -----------------------
// Interpolator processor
// -----------------------
class KFC_COMMON_API TInterpolatorProcessor :

	public TInterpolatorStorage,
	public TSuspendable
{
private:
	TMessageProcessor m_MessageProcessor;

	bool m_bAllocated;

	bool OnSuspend	();
	bool OnResume	();

public:
	TInterpolatorProcessor();

	~TInterpolatorProcessor() { Release(); }

	bool IsEmpty() const
		{ return TInterpolatorStorage::IsEmpty() || !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(	size_t szMinPortionSize =
						g_CommonConsts.m_szDefaultInterpolatorProcessorMinPortionSize,
					size_t szMessageProcessorMinPortionSize =
						g_CommonConsts.m_szDefaultMessageProcessorMinPortionSize);

	void Update();

	TMessageIterator GetFirstMessage() const;
};

#endif // interpolator_h
