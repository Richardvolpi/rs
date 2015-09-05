#ifndef plist_h
#define plist_h

#include "list.h"

// ------------------
// Pointer list item
// ------------------
template <class t>
struct TPtrListItem : public TListItem
{
	t* m_pData;


	TPtrListItem(TListItem* pSPrev, TListItem* pSNext) :
		TListItem(pSPrev, pSNext) {}

	~TPtrListItem() { delete m_pData; }
	
	t&			GetDataRef()		{ return *m_pData; }
	const t&	GetDataRef() const	{ return *m_pData; }

	t*			GetDataPtr()		{ return m_pData; }
	const t*	GetDataPtr() const	{ return m_pData; }

	void CopyData(const t& SData) { m_pData = SData.CreateCopy(); }
};

// -------------
// Pointer list
// -------------
template <class t>
class TPtrList : public TList<TPtrListItem<t>, t>
{
public:
	// Construction
	TPtrList() : TList<TPtrListItem<t>, t> () {}

	TPtrList(const TPtrList<t>& SList) : TList<TPtrListItem<t>, t>(SList) {}

	// Deletion
	void Del(TIterator& Iter) { DelItem(TFreeListIterator(Iter)), Iter.Invalidate(); }
	
	// Addition
	TIterator AddBefore(t* pSData, TIterator Iter)
	{
		TPtrListItem<t>* pItem = AddItemBefore(Iter);
		pItem->m_pData = pSData;
		return pItem;
	} 

	TIterator AddAfter(t* pSData, TIterator Iter)
	{
		TPtrListItem<t>* pItem = AddItemAfter(Iter);
		pItem->m_pData = pSData;
		return pItem;
	} 
	
	TIterator AddFirst(t* pSData)
	{
		TPtrListItem<t>* pItem = AddItemFirst();
		pItem->m_pData = pSData;
		return pItem;
	}

	TIterator AddLast(t* pSData)
	{
		TPtrListItem<t>* pItem = AddItemLast();
		pItem->m_pData = pSData;
		return pItem;
	}

	// Accessing
	TIterator GetFirst	() { return GetFirstItem(); }
	TIterator GetLast	() { return GetLastItem	(); }

	TConstIterator GetFirst	() const { return GetFirstItem(); }
	TConstIterator GetLast	() const { return GetLastItem	(); }

	TIterator GetIndexed(size_t szIndex, bool bFromTail = false)
		{ return GetIndexedItem(szIndex, bFromTail); }

	TConstIterator GetIndexed(size_t szIndex, bool bFromTail = false) const
		{ return GetFirstItem(szIndex, bFromTail); }

	size_t GetIndexOf(TConstIterator Iter) const
		{ return GetIndexOfItem(Iter.GetItem()); }
};

#endif // plist_h
