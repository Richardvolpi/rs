#ifndef parray_h
#define parray_h

#include <stdlib.h>
#include "basic_types.h"
#include "array.h"
#include "qsort.h"

// --------------
// Pointer array
// --------------
template <class t>
class TPtrArray
{
private:
	typedef t*			TItemPtr;
	typedef const t*	TConstItemPtr;
	
	TItemPtr* m_ppData;

	TArrayAllocation m_Allocation;

	size_t m_szNAllocated;
	size_t m_szN;
	

	void Copy(const TPtrArray<t> &SArray);

	void Shrink(size_t szAmt);

	t*			InternalGetTopStackItem()		{ return m_ppData[m_szN - 1]; }
	const t*	InternalGetTopStackItem() const	{ return m_ppData[m_szN - 1]; }

public:
	TPtrArray();

	~TPtrArray() { Release(); }

	void Release(bool bFromAllocatorException = false);

	void Allocate(const TArrayAllocation& SAllocation);

	void Clear(	bool bResetAllocation	= true,
				bool bPreserveData		= false);

	void Del(size_t	szIndex, bool bPreserveData = false);
	void Del(const SZSEGMENT& Segment, bool bPreserveData = false);

	void Add(t* pSData);

	t &GetDataRef(size_t szIndex = 0)
		{ return *m_ppData[szIndex]; }

	const t &GetDataRef(size_t szIndex = 0) const
		{ return *m_ppData[szIndex]; }

	TItemPtr GetDataPtr(size_t szIndex = 0)
		{ return m_ppData[szIndex]; }

	TConstItemPtr GetDataPtr(size_t szIndex = 0) const
		{ return m_ppData[szIndex]; }

	const TItemPtr* GetDataPtrPtr(size_t szIndex = 0) const
		{ return m_ppData + szIndex; }

	const TConstItemPtr* GetDataPtrPtr(size_t szIndex = 0)
		{ return m_ppData + szIndex; }

	t*			GetTopStackItem();
	const t*	GetTopStackItem() const;

	void	Push(t* pSData);
	t*		Pop	();

	// Sorting
	void Sort(TQSortFunction* pQSortFunction);

	// Indexation
	t*			operator[] (size_t szIndex)			{ return GetDataPtr(szIndex); }
	const t*	operator[] (size_t szIndex) const	{ return GetDataPtr(szIndex); }

	// {{{ t** operators (proper const modifiers)

	// Operators
	TPtrArray<t>& operator = (const TPtrArray<t>& SArray) { Copy(SArray); return *this; }

	bool IsLast(const t* pData) const
		{ return !IsEmpty() && GetDataPtr(GetN() - 1) == Data; }

	size_t GetLast() const { return GetN() - 1; }

	t*			GetLastItem()		{ return GetDataPtr(GetLast()); }
	const t*	GetLastItem() const	{ return GetDataPtr(GetLast()); }

	void DelLast() { Del(GetLast()); }

	// ---------------- TRIVIALS ----------------
	const TArrayAllocation& GetAllocation() const { return m_Allocation; }

	size_t GetNAllocated() const { return m_szNAllocated;	}
	size_t GetN			() const { return m_szN;			}

	bool IsEmpty() const { return m_szN == 0; }
	bool IsFull	() const { return m_szN == m_szNAllocated && m_Allocation.m_szDelta == 0; }
};

template <class t>
TPtrArray<t>::TPtrArray()
{	
	m_ppData = NULL;

	m_Allocation.Invalidate(), m_szN = m_szNAllocated = 0;
}

template <class t>
void TPtrArray<t>::Release(bool bFromAllocatorException)
{
	if(!bFromAllocatorException)
	{
		SAFE_BLOCK_BEGIN { Clear(false); } SAFE_BLOCK_END
	}

	kfc_free(m_ppData), m_ppData = NULL;

	m_Allocation.Invalidate(), m_szN = m_szNAllocated = 0;
}

template <class t>
void TPtrArray<t>::Clear(	bool bResetAllocation,
							bool bPreserveData)
{
	Del(SZSEGMENT(0, m_szN), bPreserveData);

	if(bResetAllocation && m_szNAllocated != m_Allocation.m_szStart)
	{
		if(m_szNAllocated = m_Allocation.m_szStart)
			m_ppData = (t**)kfc_realloc(m_ppData, m_szNAllocated * sizeof(t*));
		else if(m_ppData)
			kfc_free(m_ppData), m_ppData = NULL;
	}
}

template <class t>
void TPtrArray<t>::Allocate(const TArrayAllocation& SAllocation)
{
	Release();

	try
	{
		m_szNAllocated = (m_Allocation = SAllocation).m_szStart;
		
		if(m_szNAllocated)
		{
			m_ppData = (t**)kfc_malloc(m_szNAllocated * sizeof(t*));
		}
		else
		{
			m_ppData = NULL;
		}

		m_szN = 0;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class t>
void TPtrArray<t>::Copy(const TPtrArray<t>& SArray)
{
	if(SArray == &this)
		return;

	Release();
	
	try
	{		
		// Allocating
		Allocate(TArrayAllocation(SArray.GetNAllocated(), SArray.GetAllocation().m_szDelta));
						
		// Copying data
		for(size_t i=0 ; i<m_szN ; i++)
			Add(SArray[i]->CreateCopy());
	}
	
	catch(...)
	{
		Release();	
		throw 1;
	}
}

template <class t>
void TPtrArray<t>::Add(t* pSData)
{
	if(m_szN == m_szNAllocated)
	{
		if(m_Allocation.m_szDelta == 0)
			throw 1;

		m_szNAllocated += m_Allocation.m_szDelta;

		m_ppData = (t**)kfc_realloc(m_ppData, m_szNAllocated * sizeof(t*));
	}

	m_ppData[m_szN++] = pSData;
}

template <class t>
void TPtrArray<t>::Del(size_t szIndex, bool bPreserveData)
{
	DEBUG_VERIFY(szIndex < m_szN);

	if(!bPreserveData)
		delete m_ppData[szIndex];

	const size_t szLast = szIndex + 1;

	if(szLast < m_szN)
	{
		memmove(m_ppData	+ szIndex,
				m_ppData	+ szLast,
				(m_szN		- szLast) * sizeof(t*));
	}

	Shrink(1);
}

template <class t>
void TPtrArray<t>::Del(const SZSEGMENT& Segment, bool bPreserveData)
{
	DEBUG_VERIFY(Segment.m_Last < m_szN);

	if(!bPreserveData)
	{
		for(size_t i = Segment.m_Last - 1 ; i != Segment.m_First ; i--)
			delete m_ppData[i];
	}

	if(Segment.IsValid() && Segment.m_Last < m_szN)
	{
		memmove(m_ppData	+ Segment.m_First,
				m_ppData	+ Segment.m_Last,
				(m_szN		- Segment.m_Last) * sizeof(t*));
	}

	Shrink(Segment.GetLength());
}

template <class t>
void TPtrArray<t>::Shrink(size_t szAmt)
{
	m_szN -= szAmt;

	// {{{ reallocation
}

template <class t>
t* TPtrArray<t>::GetTopStackItem()
{
	DEBUG_VERIFY(!IsEmpty());

	return InternalGetTopStackItem();
}

template <class t>
const t* TPtrArray<t>::GetTopStackItem() const
{
	DEBUG_VERIFY(!IsEmpty());

	return InternalGetTopStackItem();
}

template <class t>
void TPtrArray<t>::Push(t* pSData)
{
	Add(pSData);
}

template <class t>
t* TPtrArray<t>::Pop()
{
	DEBUG_VERIFY(!IsEmpty());

	if(m_szN == 0)
		throw 1;

	t* pRet = InternalGetTopStackItem();

	Del(m_szN - 1, true);

	return pRet;
}

template <class t>
void TPtrArray<t>::Sort(TQSortFunction* pQSortFunction)
{
	if(m_szN > 0)
		qsort(m_ppData, m_szN, sizeof(t*), pQSortFunction);
}

#endif // parray_h
