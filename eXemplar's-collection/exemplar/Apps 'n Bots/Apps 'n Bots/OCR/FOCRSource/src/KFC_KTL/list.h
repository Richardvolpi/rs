#ifndef list_h
#define list_h

#include "kfc_ktl_api.h"
#include "basic_types.h"
#include "debug.h"

class Stream;

// ----------
// List item
// ----------
struct TListItem
{
	TListItem* m_pPrev;
	TListItem* m_pNext;

	
	TListItem(TListItem* pSPrev, TListItem* pSNext) :
		m_pPrev(pSPrev), m_pNext(pSNext) {}
};

// -------------------
// Free list iterator
// -------------------
class TFreeListIterator
{
private:
	TListItem* m_pItem;

public:
	TFreeListIterator()									: m_pItem(NULL)				{}
	TFreeListIterator(const TFreeListIterator&	SIter)	: m_pItem(SIter.m_pItem)	{}
	TFreeListIterator(TListItem*				pSItem)	: m_pItem(pSItem)			{}

	static TFreeListIterator FromPVoid(void* pData)
		{ return (TListItem*)pData; }
	
	void Invalidate() { m_pItem = NULL; }
		
	TFreeListIterator& operator = (const TFreeListIterator& SIter)
		{ m_pItem = SIter.m_pItem; return *this; }

	bool IsValid() const { return m_pItem != NULL; }

	TFreeListIterator GetPrev() const { return m_pItem->m_pPrev; }
	TFreeListIterator GetNext() const { return m_pItem->m_pNext; }

	TFreeListIterator& ToPrev() { m_pItem = m_pItem->m_pPrev; return *this; }
	TFreeListIterator& ToNext() { m_pItem = m_pItem->m_pNext; return *this; }

	TFreeListIterator& operator -- () { return ToPrev(); }
	TFreeListIterator& operator ++ () { return ToNext(); }
	
	bool operator == (const TFreeListIterator& SIter) const
		{ return m_pItem == SIter.m_pItem; }

	bool operator != (const TFreeListIterator& SIter) const
		{ return m_pItem != SIter.m_pItem; }

	void* AsPVoid() const { return (void*)m_pItem; }
};

// -------------------------
// Free list const iterator
// -------------------------
class TFreeListConstIterator
{
private:
	const TListItem* m_pItem;

public:
	TFreeListConstIterator()										: m_pItem(NULL)							{}
	TFreeListConstIterator(const TFreeListConstIterator&	SIter)	: m_pItem(SIter.m_pItem)				{}
	TFreeListConstIterator(const TFreeListIterator&			SIter)	: m_pItem((TListItem*)SIter.AsPVoid())	{}
	TFreeListConstIterator(const TListItem*					pSItem)	: m_pItem(pSItem)						{}

	static TFreeListConstIterator FromPVoid(void* pData)
		{ return (const TListItem*)pData; }

	void Invalidate() { m_pItem = NULL; }

	TFreeListConstIterator& operator = (const TFreeListConstIterator& SIter)
		{ m_pItem = SIter.m_pItem; return *this; }

	TFreeListConstIterator& operator = (const TFreeListIterator& SIter)
		{ m_pItem = (TListItem*)SIter.AsPVoid(); return *this; }

	bool IsValid() const { return m_pItem != NULL; }

	TFreeListConstIterator GetPrev() const { return m_pItem->m_pPrev; }
	TFreeListConstIterator GetNext() const { return m_pItem->m_pNext; }

	TFreeListConstIterator& ToPrev() { m_pItem = m_pItem->m_pPrev; return *this; }
	TFreeListConstIterator& ToNext() { m_pItem = m_pItem->m_pNext; return *this; }

	TFreeListConstIterator& operator -- () { return ToPrev(); }
	TFreeListConstIterator& operator ++ () { return ToNext(); }
	
	bool operator == (const TFreeListConstIterator& SIter) const
		{ return m_pItem == SIter.m_pItem; }

	bool operator != (const TFreeListConstIterator& SIter) const
		{ return m_pItem != SIter.m_pItem; }

	void* AsPVoid() const { return (void*)m_pItem; }
};

// --------------
// List iterator
// --------------
template <class ItemType, class ObjectType>
class TListIterator
{
private:
	ItemType* m_pItem;

public:
	TListIterator()														: m_pItem(NULL)							{}
	TListIterator(const TListIterator<ItemType, ObjectType>&	SIter)	: m_pItem(SIter.m_pItem)				{}
	TListIterator(ItemType*										pSItem)	: m_pItem(pSItem)						{}

	static TListIterator<ItemType, ObjectType> FromFreeIterator(const TFreeListIterator& SIter)
		{ return (ItemType*)SIter.AsPVoid(); }

	static TListIterator<ItemType, ObjectType> FromPVoid(void* pData)
		{ return (ItemType*)pData; }

	void Invalidate() { m_pItem = NULL; }

	TListIterator<ItemType, ObjectType>& operator = (const TListIterator<ItemType, ObjectType>& SIter)
		{ m_pItem = SIter.m_pItem; return *this; }
		
	TListIterator<ItemType, ObjectType>& operator = (const TFreeListIterator& SIter)
		{ m_pItem = (ItemType*)SIter.AsPVoid(); return *this; }

	bool IsValid() const { return m_pItem != NULL; }

	TListIterator<ItemType, ObjectType> GetPrev() const { return (ItemType*)m_pItem->m_pPrev; }
	TListIterator<ItemType, ObjectType> GetNext() const { return (ItemType*)m_pItem->m_pNext; }

	TListIterator<ItemType, ObjectType>& ToPrev() { m_pItem = (ItemType*)m_pItem->m_pPrev; return *this; }
	TListIterator<ItemType, ObjectType>& ToNext() { m_pItem = (ItemType*)m_pItem->m_pNext; return *this; }

	TListIterator<ItemType, ObjectType>& operator -- () { return ToPrev(); }
	TListIterator<ItemType, ObjectType>& operator ++ () { return ToNext(); }
	
	bool operator == (const TListIterator<ItemType, ObjectType>& SIter) const
		{ return m_pItem == SIter.m_pItem; }

	bool operator != (const TListIterator<ItemType, ObjectType>& SIter) const
		{ return m_pItem != SIter.m_pItem; }

	ObjectType* GetDataPtr() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("list iterator"));

		return m_pItem->GetDataPtr();
	}

	ObjectType& GetDataRef() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("list iterator"));
		
		return m_pItem->GetDataRef();
	}

	ObjectType* operator ->	() const { return GetDataPtr(); }
	ObjectType& operator *	() const { return GetDataRef(); }

	operator TFreeListIterator		() const { return (TListItem*)m_pItem; }
	operator TFreeListConstIterator	() const { return (TListItem*)m_pItem; }

	void* AsPVoid() const { return m_pItem; }

	ItemType* GetItem() { return m_pItem; }
};

// --------------------
// List const iterator
// --------------------
template <class ItemType, class ObjectType>
class TListConstIterator
{
private:
	const ItemType* m_pItem;

public:
	TListConstIterator()														: m_pItem(NULL)								{}
	TListConstIterator(const TListConstIterator<ItemType, ObjectType>&	SIter)	: m_pItem(SIter.m_pItem)					{}
	TListConstIterator(const TListIterator<ItemType, ObjectType>&		SIter)	: m_pItem((ItemType*)SIter.AsPVoid())		{}
	TListConstIterator(const ItemType*									pSItem)	: m_pItem(pSItem)							{}

	static TListConstIterator<ItemType, ObjectType> FromFreeIterator(const TFreeListConstIterator& SIter)
		{ return (const ItemType*)SIter.AsPVoid(); }

	static TListConstIterator<ItemType, ObjectType> FromFreeIterator(const TFreeListIterator& SIter)
		{ return (ItemType*)SIter.AsPVoid(); }

	static TListConstIterator<ItemType, ObjectType> FromPVoid(void* pData)
		{ return (const ItemType*)pData; }

	void Invalidate() { m_pItem = NULL; }
	
	TListConstIterator<ItemType, ObjectType>& operator = (const TListConstIterator<ItemType, ObjectType>& SIter)
		{ m_pItem = SIter.m_pItem; return *this; }

	TListConstIterator<ItemType, ObjectType>& operator = (const TListIterator<ItemType, ObjectType>& SIter)
		{ m_pItem = (ItemType*)SIter.AsPVoid(); return *this; }

	TListConstIterator<ItemType, ObjectType>& operator = (const TFreeListConstIterator& SIter)
		{ m_pItem = (const ItemType*)SIter.AsPVoid(); return *this; }
		
	TListConstIterator<ItemType, ObjectType>& operator = (const TFreeListIterator& SIter)
		{ m_pItem = (ItemType*)SIter.AsPVoid(); return *this; }

	bool IsValid() const { return m_pItem != NULL; }

	TListConstIterator<ItemType, ObjectType> GetPrev() const { return (ItemType*)m_pItem->m_pPrev; }
	TListConstIterator<ItemType, ObjectType> GetNext() const { return (ItemType*)m_pItem->m_pNext; }

	TListConstIterator<ItemType, ObjectType>& ToPrev() { m_pItem = (ItemType*)m_pItem->m_pPrev; return *this; }
	TListConstIterator<ItemType, ObjectType>& ToNext() { m_pItem = (ItemType*)m_pItem->m_pNext; return *this; }

	TListConstIterator<ItemType, ObjectType>& operator -- () { return ToPrev(); }
	TListConstIterator<ItemType, ObjectType>& operator ++ () { return ToNext(); }
	
	bool operator == (const TListConstIterator<ItemType, ObjectType>& SIter) const
		{ return m_pItem == SIter.m_pItem; }

	bool operator != (const TListConstIterator<ItemType, ObjectType>& SIter) const
		{ return m_pItem != SIter.m_pItem; }

	const ObjectType* GetDataPtr() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("list const iterator"));

		return m_pItem->GetDataPtr();
	}

	const ObjectType& GetDataRef() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("list const iterator"));

		return m_pItem->GetDataRef();
	}

	const ObjectType* operator ->	() const { return GetDataPtr(); }
	const ObjectType& operator *	() const { return GetDataRef(); }

	operator TFreeListConstIterator () const { return (TListItem*)m_pItem; }

	void* AsPVoid() const { return (void*)m_pItem; }

	const ItemType* GetItem() const { return m_pItem; }
};

// -----
// List
// -----
template <class t, class ot>
class TList
{
private:
	t* m_pFirst;
	t* m_pLast;

	size_t m_szN;


	// Copying
	void Copy(const TList<t, ot>& SList);

protected:
	// Deletion
	void DelItem(TFreeListIterator& Iter);

	// Addition
	t* AddItemBefore(TFreeListIterator Iter);
	t* AddItemAfter	(TFreeListIterator Iter);

	t* AddItemFirst	() { return AddItemBefore	(GetFirstItem	()); }
	t* AddItemLast	() { return AddItemAfter	(GetLastItem	()); }

	// Accessing
	t* GetFirstItem	() { return m_pFirst;	}
	t* GetLastItem	() { return m_pLast;	}

	const t* GetFirstItem	() const { return m_pFirst;	}
	const t* GetLastItem	() const { return m_pLast;	}

	t*			GetIndexedItem(size_t szIndex, bool bFromTail = false);
	const t*	GetIndexedItem(size_t szIndex, bool bFromTail = false) const;

	size_t GetIndexOfItem(const TListItem* pItem) const;

	void SwapContainerItems(t* p1, t* p2);

	TList();

	TList(const TList<t, ot>& SList);

	~TList() { Clear(); }

public:
	// Iterators
	typedef TListIterator<t, ot>		TIterator;
	typedef TListConstIterator<t, ot>	TConstIterator;

	// Info
	bool IsEmpty() const { return m_szN == 0; }
	
	// Clearing
	void Clear();
			
	// Operators
	TList<t, ot>& operator = (const TList<t, ot>& SList)
		{ Copy(SList); return *this; }

	// Streaming
	void ReadItems	(TStream& Stream);
	void WriteItems	(TStream& Stream) const;
	
	// ---------------- TRIVIALS ----------------
	size_t GetN() const { return m_szN; }
};

// Construction
template <class t, class ot>
TList<t, ot>::TList()
{
	m_pFirst	= NULL;
	m_pLast		= NULL;

	m_szN = 0;
}

template <class t, class ot>
TList<t, ot>::TList(const TList<t, ot>& SList)
{
	m_pFirst	= NULL;
	m_pLast		= NULL;

	m_szN = 0;

	Copy(SList);
}

// Clearing
template <class t, class ot>
void TList<t, ot>::Clear()
{
	for(TFreeListIterator Iter = GetLastItem() ; Iter.IsValid() ; )
	{
		TFreeListIterator PIter = Iter.GetPrev();

		DelItem(Iter);

		Iter = PIter;
	}

	m_pFirst	= NULL;
	m_pLast		= NULL;

	m_szN = 0;
}

// Copying
template <class t, class ot>
void TList<t, ot>::Copy(const TList<t, ot>& SList)
{
	if(&SList == this)
		return;

	Clear();

	for(TFreeListConstIterator Iter = SList.GetFirstItem() ; Iter.IsValid() ; ++Iter)
		AddItemLast()->CopyData(((const t*)Iter.AsPVoid())->GetDataRef());
}

// Addition
template <class t, class ot>
t* TList<t, ot>::AddItemBefore(TFreeListIterator Iter)
{
	t* pNewItem = NULL;
	
	if(IsEmpty())
	{
		pNewItem = new t(NULL, NULL);
		
		m_pFirst	= pNewItem;
		m_pLast		= pNewItem;
	}
	else
	{
		t* pCurItem = (t*)Iter.AsPVoid();
		
		pNewItem = new t(pCurItem->m_pPrev, pCurItem);
		
		if(pCurItem->m_pPrev)
			pCurItem->m_pPrev->m_pNext = pNewItem;
		
		pCurItem->m_pPrev = pNewItem;
		
		if(pCurItem == m_pFirst)
			m_pFirst = pNewItem;
	}
	
	m_szN++;
	
	return pNewItem;
}

template <class t, class ot>
t* TList<t, ot>::AddItemAfter(TFreeListIterator Iter)
{
	t* pNewItem = NULL;
	
	if(IsEmpty())
	{
		pNewItem = new t(NULL, NULL);
		
		m_pFirst	= pNewItem;
		m_pLast		= pNewItem;
	}
	else
	{	
		t* pCurItem = (t*)Iter.AsPVoid();
		
		pNewItem = new t(pCurItem, pCurItem->m_pNext);
		
		if(pCurItem->m_pNext)
			pCurItem->m_pNext->m_pPrev = pNewItem;
		
		pCurItem->m_pNext = pNewItem;
		
		if(pCurItem == m_pLast)
			m_pLast = pNewItem;
	}
	
	m_szN++;
	
	return pNewItem;
}

// Deletion
template <class t, class ot>
void TList<t, ot>::DelItem(TFreeListIterator& Iter)
{
	TListItem* pItem = (TListItem*)Iter.AsPVoid();

	if(pItem->m_pPrev)
		pItem->m_pPrev->m_pNext = pItem->m_pNext;
	else
		m_pFirst = (t*)pItem->m_pNext;

	if(pItem->m_pNext)
		pItem->m_pNext->m_pPrev = pItem->m_pPrev;
	else
		m_pLast = (t*)pItem->m_pPrev;

	delete (t*)pItem, m_szN--;

	Iter.Invalidate();
}

// Accessing
template <class t, class ot>
t* TList<t, ot>::GetIndexedItem(size_t szIndex, bool bFromTail)
{
	DEBUG_VERIFY(szIndex < m_szN);

	t* pCur = NULL;
	
	if(bFromTail)
	{
		pCur = m_pLast;

		for( ; szIndex ; szIndex--)
			pCur = (t*)pCur->m_pPrev;
	}
	else
	{
		pCur = m_pFirst;

		for( ; szIndex ; szIndex--)
			pCur = (t*)pCur->m_pNext;		
	}

	return pCur;
}

template <class t, class ot>
const t* TList<t, ot>::GetIndexedItem(size_t szIndex, bool bFromTail) const
{
	DEBUG_VERIFY(szIndex < m_szN);

	const t* pCur = NULL;
	
	if(bFromTail)
	{
		pCur = m_pLast;

		for( ; szIndex ; szIndex--)
			pCur = (const t*)pCur->m_pPrev;
	}
	else
	{
		pCur = m_pFirst;

		for( ; szIndex ; szIndex--)
			pCur = (const t*)pCur->m_pNext;		
	}

	return pCur;
}

template <class t, class ot>
size_t TList<t, ot>::GetIndexOfItem(const TListItem* pItem) const
{
	DEBUG_VERIFY(pItem);

	TListItem*	pCur;
	size_t		i;

	for(pCur = m_pFirst, i = 0 ; pCur ; pCur = pCur->m_pNext, i++)
	{
		if(pCur == pItem)
			return i;
	}

	INITIATE_DEFINED_FAILURE(TEXT("Unable to find list iterator."));
}

// Streaming
template <class t, class ot>
void TList<t, ot>::ReadItems(TStream& Stream)
{
	Clear();

	size_t szN;
	for(Stream >> szN ; szN ; szN--)
		Stream >> AddItemLast()->GetDataRef();
}

template <class t, class ot>
void TList<t, ot>::WriteItems(TStream& Stream) const
{
	Stream << GetN();

	for(TFreeListConstIterator Iter = GetFirstItem() ;
		Iter.IsValid() ;
		++Iter)
	{
		Stream << ((const t*)Iter.AsPVoid())->GetDataRef();
	}
}

// Other
template <class t, class ot>
void TList<t, ot>::SwapContainerItems(t* p1, t* p2)
{
	if(p1==p2)
		return;

	if(p1->m_pNext == p2) // close case 1->2
	{
		// Outer links
		p1->m_pNext = p2->m_pNext;
		p2->m_pPrev = p1->m_pPrev;

		// Inner links
		p1->m_pPrev = p2;
		p2->m_pNext = p1;
	}
	else if(p2->m_pNext == p1) // close case 2->1
	{
		// Outer links
		p1->m_pPrev = p2->m_pPrev;
		p2->m_pNext = p1->m_pNext;

		// Inner links
		p1->m_pNext = p2;
		p2->m_pPrev = p1;
	}
	else // common case
	{
		// Prefetching
		TListItem* pPrev1 = p1->m_pPrev;
		TListItem* pNext1 = p1->m_pNext;

		TListItem* pPrev2 = p2->m_pPrev;
		TListItem* pNext2 = p2->m_pNext;	

		// 1
		if(p1->m_pPrev = pPrev2)
			pPrev2->m_pNext = p1;

		if(p1->m_pNext = pNext2)
			pNext2->m_pPrev = p1;

		// 2
		if(p2->m_pPrev = pPrev1)
			pPrev1->m_pNext = p2;

		if(p2->m_pNext = pNext1)
			pNext1->m_pPrev = p2;
	}

	// First/last
	if(m_pFirst == p1)
		m_pFirst = p2;
	else if(m_pFirst == p2)
		m_pFirst = p1;

	if(m_pLast == p1)
		m_pLast = p2;
	else if(m_pLast == p2)
		m_pLast = p1;
}

// ---------------
// List streaming
// ---------------
#define DECLARE_LIST_STREAMING(Type)								\
	inline TStream& operator >> (TStream& Stream, Type& List)		\
	{																\
		List.ReadItems(Stream);										\
																	\
		return Stream;												\
	}																\
																	\
	inline TStream& operator << (TStream& Stream, const Type& List)	\
	{																\
		List.WriteItems(Stream);									\
																	\
		return Stream;												\
	}																\

#endif // list_h
