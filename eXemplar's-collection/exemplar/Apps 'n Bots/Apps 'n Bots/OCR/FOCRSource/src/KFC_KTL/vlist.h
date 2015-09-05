#ifndef vlist_h
#define vlist_h

#include "list.h"

// ----------------
// Value list item
// ----------------
template <class t>
struct TValueListItem : public TListItem
{
	t m_Data;


	TValueListItem(TListItem* pSPrev, TListItem* pSNext) :
		TListItem(pSPrev, pSNext) {}
	
	t&			GetDataRef()		{ return m_Data; }
	const t&	GetDataRef() const	{ return m_Data; }

	t*			GetDataPtr()		{ return &m_Data; }
	const t*	GetDataPtr() const	{ return &m_Data; }

	void CopyData(const t& SData) { m_Data = SData; }
};

// -----------
// Value list
// -----------
template <class t>
class TValueList : public TList<TValueListItem<t>, t>
{
public:
	// Construction
	TValueList() : TList<TValueListItem<t>, t> () {}

	TValueList(const TValueList<t>& SList) : TList<TValueListItem<t>, t>(SList) {}

	// Deletion
	void Del(TIterator& Iter) { DelItem(TFreeListIterator(Iter)), Iter.Invalidate(); }
	
	// Addition
	TIterator AddBefore(TIterator Iter)
		{ return AddItemBefore(Iter); }

	TIterator AddAfter(TIterator Iter)
		{ return AddItemAfter(Iter); }
	
	TIterator AddFirst	()	{ return AddItemFirst	(); }
	TIterator AddLast	()	{ return AddItemLast	(); }

	// Accessing
	TIterator GetFirst	() { return GetFirstItem(); }
	TIterator GetLast	() { return GetLastItem	(); }

	TConstIterator GetFirst	() const { return GetFirstItem	(); }
	TConstIterator GetLast	() const { return GetLastItem	(); }	

	TIterator GetIndexed(size_t szIndex, bool bFromTail = false)
		{ return GetIndexedItem(szIndex, bFromTail); }

	TConstIterator GetIndexed(size_t szIndex, bool bFromTail = false) const
		{ return GetIndexedItem(szIndex, bFromTail); }

	size_t GetIndexOf(TConstIterator Iter) const
		{ return GetIndexOfItem(Iter.GetItem()); }

	// Other
	void SwapContainers(TIterator Iter1, TIterator Iter2)
		{ SwapContainerItems(Iter1.GetItem(), Iter2.GetItem()); }

	TValueList<t>& operator = (const TValueList<t>& SList);

	TValueList<t>& operator += (const TValueList<t>& SList);
};

template <class t>
TValueList<t>& TValueList<t>::operator = (const TValueList<t>& SList)
{
	Clear();

	return *this += SList;	
}

template <class t>
TValueList<t>& TValueList<t>::operator += (const TValueList<t>& SList)
{
	for(TConstIterator Iter = SList.GetFirst() ; Iter.IsValid() ; ++Iter)
		*AddLast() = *Iter;

	return *this;
}

#endif // vlist_h