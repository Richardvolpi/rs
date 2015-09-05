#ifndef varray_h
#define varray_h

#include <stdlib.h>
#include "basic_types.h"
#include "array.h"
#include "placement_allocation.h"
#include "qsort.h"

class TStream;

// ------------
// Value array
// ------------
template <class t, bool bBasicType = false>
class TValueArray
{
private:
	t* m_pData;

	TArrayAllocation m_Allocation;

	size_t m_szNAllocated;

	size_t m_szN;

	// Copying
	void Copy(const TValueArray<t, bBasicType>& SArray);

public:
	TValueArray();
	
	TValueArray(const TArrayAllocation& SAllocation);

	TValueArray(const TValueArray<t, bBasicType>& SArray);

	~TValueArray() { Release(); }

	void Release(bool bFromAllocatorException = false);

	void Allocate(const TArrayAllocation& SAllocation);

	t& AllocateAdd(size_t szAmt);

	void Clear(bool bResetAllocation = true);
		
	t& Add(size_t szAmt = 1);

	t GetData(size_t szIndex) const { return m_pData[szIndex];	}

	void Del(size_t szIndex);
	void Del(size_t szFirst, size_t szLast);

	t& GetDataRef(size_t szIndex = 0)
		{ return m_pData[szIndex]; }

	const t& GetDataRef(size_t szIndex = 0) const
		{ return m_pData[szIndex]; }

	t* GetDataPtr(size_t szIndex = 0)
		{ return m_pData + szIndex; }

	const t *GetDataPtr(size_t szIndex = 0) const
		{ return m_pData + szIndex; }

	void ZeroData();
	void ZeroData(size_t szIndex);
	void ZeroData(size_t szFirst, size_t szLast);
	
	void Sort(TQSortFunction* pQSortFunction);

	t&			operator[] (size_t szIndex)			{ return GetDataRef(szIndex); }
	const t&	operator[] (size_t szIndex) const	{ return GetDataRef(szIndex); }
	
	TValueArray<t, bBasicType>& operator = (const TValueArray<t, bBasicType>& SArray)
		{ Copy(SArray); return *this; }

	bool IsLast(const t& Data) const
		{ return !IsEmpty() && GetDataRef(GetN() - 1) == Data; }

	size_t GetFirst		() const { return 0; }
	size_t GetPostFirst	() const { return 1; }

	size_t GetPreLast	() const { return GetN() - 2; }
	size_t GetLast		() const { return GetN() - 1; }

	t&			GetLastItem()		{ return GetDataRef(GetLast()); }
	const t&	GetLastItem() const	{ return GetDataRef(GetLast()); }

	t&			GetPreLastItem()		{ return GetDataRef(GetPreLast()); }
	const t&	GetPreLastItem() const	{ return GetDataRef(GetPreLast()); }

	void DelLast() { Del(GetLast()); }

	void ReadItems	(TStream& Stream);
	void WriteItems	(TStream& Stream) const;

	// ---------------- TRIVIALS ----------------
	const TArrayAllocation& GetAllocation() const { return m_Allocation; }

	size_t GetNAllocated() const { return m_szNAllocated;	}
	size_t GetN			() const { return m_szN;			}

	bool IsEmpty() const { return m_szN == 0; }
	bool IsFull	() const { return m_szN == m_szNAllocated && m_Allocation.m_szDelta == 0; }
};

template <class t, bool bBasicType>
TValueArray<t, bBasicType>::TValueArray()
{
	m_pData = NULL;

	m_Allocation.Invalidate(), m_szN = m_szNAllocated = 0;
}

template <class t, bool bBasicType>
TValueArray<t, bBasicType>::TValueArray(const TValueArray<t, bBasicType>& SArray)
{
	m_pData = NULL;

	m_Allocation.Invalidate(), m_szN = m_szNAllocated = 0;

	Copy(SArray);
}

template <class t, bool bBasicType>
TValueArray<t, bBasicType>::TValueArray(const TArrayAllocation& SAllocation)
{	
	m_pData = NULL;

	m_Allocation.Invalidate(), m_szN = m_szNAllocated = 0;

	Allocate(SAllocation);
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::Release(bool bFromAllocatorException)
{
	if(!bFromAllocatorException)
	{
		try
		{
			Clear(false);
		}

		catch(...)
		{
			MessageBox(	NULL,
						TEXT("VArray clearing failed."),
						TEXT("FATAL ERROR"),
						MB_OK | MB_ICONSTOP | MB_SYSTEMMODAL);
		}
	}

	kfc_free(m_pData), m_pData = NULL;

	m_Allocation.Invalidate(), m_szN = m_szNAllocated = 0;
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::Allocate(const TArrayAllocation& SAllocation)
{
	Release();

	try
	{
		if(!SAllocation.IsValid())
			throw 1;

		if(m_szNAllocated = (m_Allocation = SAllocation).m_szStart)
		{
			m_pData = (t*)kfc_malloc(m_szNAllocated * sizeof(t));
		}
		else
		{
			m_pData = NULL;
		}

		m_szN = 0;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class t, bool bBasicType>
t& TValueArray<t, bBasicType>::AllocateAdd(size_t szAmt)
{
	return Allocate(szAmt), Add(szAmt);
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::Clear(bool bResetAllocation)
{
	Del(0, m_szN);

	if(	bResetAllocation &&
		m_szNAllocated != m_Allocation.m_szStart)
	{
		if(m_szNAllocated = m_Allocation.m_szStart)
		{
			m_pData = (t*)kfc_realloc(m_pData, m_szNAllocated * sizeof(t));
		}
		else if(m_pData)
		{
			kfc_free(m_pData), m_pData = NULL;
		}
	}
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::Copy(const TValueArray<t, bBasicType>& SArray)
{
	if(this == &SArray)
		return;

	Release();
	
	try
	{
		// Allocating
		Allocate(TArrayAllocation(SArray.GetNAllocated(), SArray.GetAllocation().m_szDelta));
		Add(SArray.GetN());

		if(bBasicType)
		{
			if(m_szN)
				memcpy(GetDataPtr(), SArray.GetDataPtr(), m_szN * sizeof(t));
		}
		else
		{
			for(size_t i = 0 ; i < m_szN ; i++)
				m_pData[i] = SArray[i];
		}
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class t, bool bBasicType>
t& TValueArray<t, bBasicType>::Add(size_t szAmt)
{
	if(!m_Allocation.IsValid())
		throw 1;

	size_t szNewN = m_szN + szAmt;

	if(szNewN > m_szNAllocated)
	{
		if(m_Allocation.m_szDelta == 0) // fixed size array
			throw 1;

		// Reallocating
		m_szNAllocated +=	(szNewN - m_szNAllocated + m_Allocation.m_szDelta - 1) /
								m_Allocation.m_szDelta *
									m_Allocation.m_szDelta;

		if(m_pData)
			m_pData = (t*)kfc_realloc(m_pData, m_szNAllocated * sizeof(t));
		else
			m_pData = (t*)kfc_malloc(m_szNAllocated * sizeof(t));
	}

	if(!bBasicType)
	{
		for( ; m_szN < szNewN ; m_szN++)
			new((void*)(m_pData + m_szN)) t();
	}
	else
	{
		m_szN = szNewN;
	}

	return m_pData[m_szN - szAmt];
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::Del(size_t szIndex)
{
	if(!bBasicType)
		m_pData[szIndex].~t();

	const size_t szLast = szIndex + 1;

	if(szLast < m_szN)
	{
		memmove(m_pData	+ szIndex,
				m_pData	+ szLast,
				(m_szN	- szLast) * sizeof(t));
	}
	
	m_szN--;
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::Del(size_t szFirst, size_t szLast)
{
	if(!bBasicType)
	{
		for(size_t i = szLast - 1 ; i != szFirst - 1 ; i--)
			m_pData[i].~t();
	}

	if(szFirst < szLast && szLast < m_szN)
	{
		memmove(m_pData	+ szFirst,
				m_pData	+ szLast,
				(m_szN	- szLast) * sizeof(t));
	}

	m_szN -= szLast - szFirst;
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::ZeroData()
{
	if(!bBasicType)
		throw 1;

	memset(m_pData, 0, m_szN * sizeof(t));
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::ZeroData(size_t szIndex)
{
	if(!bBasicType)
		throw 1;

	memset(m_pData + szIndex, 0, sizeof(t));
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::ZeroData(size_t szFirst, size_t szLast)
{
	if(!bBasicType)
		throw 1;
	
	memset(m_pData + szFirst, 0, (szLast - szFirst) * sizeof(t));
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::Sort(TQSortFunction* pQSortFunction)
{
	qsort(m_pData, m_szN, sizeof(t), pQSortFunction);
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::ReadItems(TStream& Stream)
{
	if(bBasicType)
	{
		STREAM_READ_ARR(Stream, m_pData, m_szN, t);
	}
	else
	{
		for(size_t i = 0 ; i < m_szN ; i++)
			Stream >> m_pData[i];
	}
}

template <class t, bool bBasicType>
void TValueArray<t, bBasicType>::WriteItems(TStream& Stream) const
{
	if(bBasicType)
	{
		STREAM_WRITE_ARR(Stream, m_pData, m_szN, t);
	}
	else
	{
		for(size_t i = 0 ; i < m_szN ; i++)
			Stream << m_pData[i];
	}
}

#endif // varray_h
