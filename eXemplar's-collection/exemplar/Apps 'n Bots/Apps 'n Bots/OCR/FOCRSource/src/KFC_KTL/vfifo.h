#ifndef vfifo_h
#define vfifo_h

#include "basic_types.h"
#include "placement_allocation.h"

// -----------
// Value FIFO
// -----------
template <class t, bool bBasicType = false>
class TValueFIFO
{
private:
	bool m_bAllocated;

	t*		m_pData;
	size_t	m_szMaxItems;
	size_t	m_szNItems;
	
	size_t m_szHeadIndex;
	size_t m_szTailIndex;

	bool m_bAutoRemoveHead;

public:
	TValueFIFO();
	
	~TValueFIFO() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release();

	void Allocate(size_t szSMaxItems, bool bSAutoRemoveHead);

	void Clear();

	t&	Put();
	t&	Put(const t& SData);
	t	Get();

	t&			GetHead();
	const t&	GetHead() const;

	t&			GetTail();
	const t&	GetTail() const;

	void RemoveHead();
	void RemoveTail();

	t&			operator [] (size_t szIndex);
	const t&	operator [] (size_t szIndex) const;

	// ---------------- TRIVIALS ----------------
	size_t GetMaxItems	() const { return m_szMaxItems;	}
	size_t GetNItems	() const { return m_szNItems;	}

	bool IsAutoRemoveHead() const { return m_bAutoRemoveHead; }

	bool HasItems	() const { return m_szNItems ? true : false;	}
	bool IsFull		() const { return m_szNItems == m_szMaxItems;	}
};

template <class t, bool bBasicType>
TValueFIFO<t, bBasicType>::TValueFIFO()
{
	m_bAllocated = false;

	m_pData = NULL;
}

template <class t, bool bBasicType>
void TValueFIFO<t, bBasicType>::Release()
{
	if(!IsEmpty())
	{
		Clear();
		
		m_bAllocated = false;

		if(m_pData)
			kfc_free(m_pData), m_pData = NULL;
	}
}

template <class t, bool bBasicType>
void TValueFIFO<t, bBasicType>::Allocate(size_t szSMaxItems, bool bSAutoRemoveHead)
{
	Release();

	try
	{
		if(szSMaxItems == 0)
			throw 1;

		m_szMaxItems = szSMaxItems;

		m_bAutoRemoveHead = bSAutoRemoveHead;
		
		m_pData = (t*)kfc_malloc(m_szMaxItems * sizeof(t));

		m_szNItems = 0;

		m_szHeadIndex = m_szTailIndex = 0;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

template <class t, bool bBasicType>
void TValueFIFO<t, bBasicType>::Clear()
{
	if(IsEmpty())
		throw 1;

	if(!bBasicType && HasItems())
	{
		size_t i;
		
		if(m_szHeadIndex < m_szTailIndex)
		{
			for(i = m_szHeadIndex ; i < m_szTailIndex ; ++i)
				m_pData[i].~t();
		}
		else
		{
			for(i = m_szHeadIndex ; i < m_szMaxItems ; ++i)
				m_pData[i].~t();

			for(i = 0 ; i < m_szTailIndex ; ++i)
				m_pData[i].~t();
		}
	}

	m_szNItems = 0;
	
	m_szHeadIndex = m_szTailIndex = 0;
}

template <class t, bool bBasicType>
t& TValueFIFO<t, bBasicType>::Put()
{
	if(IsEmpty())
		throw 1;

	if(IsFull())
	{
		if(m_bAutoRemoveHead)
			RemoveHead();
		else
			throw 1;
	}

	if(!bBasicType)
		new(m_pData + m_szTailIndex) t();

	if(++m_szTailIndex == m_szMaxItems)
		m_szTailIndex = 0;

	m_szNItems++;

	return GetTail();
}

template <class t, bool bBasicType>
t& TValueFIFO<t, bBasicType>::Put(const t& SData)
{
	if(IsEmpty())
		throw 1;

	if(IsFull())
	{
		if(m_bAutoRemoveHead)
			RemoveHead();
		else
			throw 1;
	}

	if(bBasicType)
		m_pData[m_szTailIndex] = SData;
	else
		new(m_pData + m_szTailIndex) t(SData);

	if(++m_szTailIndex == m_szMaxItems)
		m_szTailIndex = 0;

	m_szNItems++;

	return GetTail();
}

template <class t, bool bBasicType>
t TValueFIFO<t, bBasicType>::Get()
{
	if(IsEmpty())
		throw 1;

	if(!HasItems())
		throw 1;

	t RetVal = GetHead();

	RemoveHead();

	return RetVal;
}

template <class t, bool bBasicType>
t& TValueFIFO<t, bBasicType>::GetHead()
{
	if(IsEmpty())
		throw 1;

	if(!HasItems())
		throw 1;

	return m_pData[m_szHeadIndex];
}

template <class t, bool bBasicType>
const t& TValueFIFO<t, bBasicType>::GetHead() const
{
	if(IsEmpty())
		throw 1;

	if(!HasItems())
		throw 1;

	return m_pData[m_szHeadIndex];
}

template <class t, bool bBasicType>
t& TValueFIFO<t, bBasicType>::GetTail()
{
	if(IsEmpty())
		throw 1;

	if(!HasItems())
		throw 1;

	return m_pData[m_szTailIndex ? (m_szTailIndex - 1) : (m_szMaxItems - 1)];
}

template <class t, bool bBasicType>
const t& TValueFIFO<t, bBasicType>::GetTail() const
{
	if(IsEmpty())
		throw 1;

	if(!HasItems())
		throw 1;

	return m_pData[m_szTailIndex ? (m_szTailIndex - 1) : (m_szMaxItems - 1)];
}

template <class t, bool bBasicType>
void TValueFIFO<t, bBasicType>::RemoveHead()
{
	if(IsEmpty())
		throw 1;

	if(!HasItems())
		throw 1;

	if(!bBasicType)
		m_pData[m_szHeadIndex].~t();

	if(++m_szHeadIndex == m_szMaxItems)
		m_szHeadIndex = 0;
	
	m_szNItems--;
}

template <class t, bool bBasicType>
void TValueFIFO<t, bBasicType>::RemoveTail()
{
	if(IsEmpty())
		throw 1;

	if(!HasItems())
		throw 1;

	if(--m_szTailIndex == UINT_MAX)
		m_szTailIndex = m_szMaxItems - 1;

	m_szNItems--;

	if(!bBasicType)
		m_pData[m_szTailIndex].~t();
}

template <class t, bool bBasicType>
t& TValueFIFO<t, bBasicType>::operator [] (size_t szIndex)
{
	if(IsEmpty())
		throw 1;

	if(szIndex >= m_szNItems)
		throw 1;

	const size_t szDstIndex = m_szHeadIndex + szIndex;

	return m_pData[szDstIndex < m_szMaxItems ? szDstIndex : szDstIndex - m_szMaxItems];
}

template <class t, bool bBasicType>
const t& TValueFIFO<t, bBasicType>::operator [] (size_t szIndex) const
{
	if(IsEmpty())
		throw 1;

	if(szIndex >= m_szNItems)
		throw 1;

	const size_t szDstIndex = m_szHeadIndex + szIndex;

	return m_pData[szDstIndex < m_szMaxItems ? szDstIndex : szDstIndex - m_szMaxItems];
}

#endif // vfifo_h
