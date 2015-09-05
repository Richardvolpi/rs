#ifndef ptree_h
#define ptree_h

#include "tree.h"

// ------------------
// Pointer tree item
// ------------------
template <class t>
struct TPtrTreeItem : public TTreeItem
{
	t* m_pData;


	TPtrTreeItem(	TTreeItem*	pSParent,
					TTreeItem*	pSPrevSibling,
					TTreeItem*	pSNextSibling,
					size_t		szSDepth) : TTreeItem(	pSParent,
														pSPrevSibling,
														pSNextSibling,
														szSDepth) {}

	~TPtrTreeItem() { delete m_pData; }
	
	t&			GetDataRef()		{ return *m_pData; }
	const t&	GetDataRef() const	{ return *m_pData; }

	t*			GetDataPtr()		{ return m_pData; }
	const t*	GetDataPtr() const	{ return m_pData; }

	void CopyData(const t& SData) { m_pData = SData.CreateCopy(); }

	void PreserveData() { m_pData = NULL; }
};

// -------------
// Pointer tree
// -------------
template <class t>
class TPtrTree : public TTree<TPtrTreeItem<t>, t>
{
public:
	// Iterator
	typedef TTreeIterator<		TPtrTreeItem<t>, t> TIterator;
	typedef TTreeConstIterator<	TPtrTreeItem<t>, t> TConstIterator;

	// Construction
	TPtrTree() : TTree<TPtrTreeItem<t>, t> () {}

	TPtrTree(const TPtrTree<t>& STree) : TTree<TPtrTreeItem<t>, t>(STree) {}

	// Deletion
	void Del(	TIterator&				Iter,
				TTreePreservationMode	PreservationMode = TPM_NONE)
	{
		DelItem(TFreeTreeIterator(Iter), PreservationMode), Iter.Invalidate();
	}
	
	// Addition
	TIterator AddRoot(t* pSData)
	{
		TPtrTreeItem<t>* pItem = AddRootItem();
		pItem->m_pData = pSData;
		return pItem;
	}

	static TIterator AddChildBefore(t* pSData, TIterator ParentIter, TIterator Iter)
	{
		TPtrTreeItem<t>* pItem = AddChildItemBefore(ParentIter, Iter);
		pItem->m_pData = pSData;
		return pItem;
	}

	static TIterator AddChildAfter(t* pSData, TIterator ParentIter, TIterator Iter)
	{
		TPtrTreeItem<t>* pItem = AddChildItemAfter(ParentIter, Iter);
		pItem->m_pData = pSData;
		return pItem;
	}

	static TIterator AddFirstChild(t* pSData, TIterator ParentIter)
	{
		TPtrTreeItem<t>* pItem = AddFirstChildItem(ParentIter);
		pItem->m_pData = pSData;
		return pItem;
	}

	static TIterator AddLastChild(t* pSData, TIterator ParentIter)
	{
		TPtrTreeItem<t>* pItem = AddLastChildItem(ParentIter);
		pItem->m_pData = pSData;
		return pItem;
	}

	static TIterator AddSiblingBefore(t* pSData, TIterator Iter)
	{
		TPtrTreeItem<t>* pItem = AddSiblingItemBefore(Iter);
		pItem->m_pData = pSData;
		return pItem;
	}

	static TIterator AddSiblingAfter(t* pSData, TIterator Iter)
	{
		TPtrTreeItem<t>* pItem = AddSiblingItemAfter(Iter);
		pItem->m_pData = pSData;
		return pItem;
	}
	
	static TIterator AddFirstSibling(t* pSData, TIterator Iter)
	{
		TPtrTreeItem<t>* pItem = AddFirstSiblingItem(Iter);
		pItem->m_pData = pSData;
		return pItem;
	}

	static TIterator AddLastSibling(t* pSData, TIterator Iter)
	{
		TPtrTreeItem<t>* pItem = AddLastSiblingItem(Iter);
		pItem->m_pData = pSData;
		return pItem;
	}

	// Iterators
	TIterator GetRoot()
		{ return GetRootItem(); }

	TIterator GetFirst()
		{ return GetFirstItem(); }

	TIterator GetLast()
		{ return GetLastItem(); }

	TConstIterator GetRoot() const
		{ return GetRootItem(); }

	TConstIterator GetFirst() const
		{ return GetFirstItem(); }

	TConstIterator GetLast() const
		{ return GetLastItem(); }
};

#endif // vtree_h
