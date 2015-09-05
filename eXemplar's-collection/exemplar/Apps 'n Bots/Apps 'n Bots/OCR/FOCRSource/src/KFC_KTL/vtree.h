#ifndef vtree_h
#define vtree_h

#include "tree.h"

// ----------------
// Value tree item
// ----------------
template <class t>
struct TValueTreeItem : public TTreeItem
{
	t m_Data;


	TValueTreeItem(	TTreeItem*	pSParent,
					TTreeItem*	pSPrevSibling,
					TTreeItem*	pSNextSibling,
					size_t		szSDepth) : TTreeItem(	pSParent,
														pSPrevSibling,
														pSNextSibling,
														szSDepth) {}
	
	t&			GetDataRef()		{ return m_Data; }
	const t&	GetDataRef() const	{ return m_Data; }

	t*			GetDataPtr()		{ return &m_Data; }
	const t*	GetDataPtr() const	{ return &m_Data; }

	void CopyData(const t& SData) { m_Data = SData; }

	void PreserveData() { INITIATE_FAILURE; }
};

// -----------
// Value tree
// -----------
template <class t>
class TValueTree : public TTree<TValueTreeItem<t>, t>
{
public:
	// Iterators
	typedef TTreeIterator<		TValueTreeItem<t>, t> TIterator;
	typedef TTreeConstIterator<	TValueTreeItem<t>, t> TConstIterator;

	// Construction
	TValueTree() : TTree<TValueTreeItem<t>, t> () {}

	TValueTree(const TValueTree<t>& STree) : TTree<TValueTreeItem<t>, t>(STree) {}

	// Deletion
	void Del(TIterator& Iter) { DelItem(TFreeTreeIterator(Iter)), Iter.Invalidate(); }
	
	// Addition
	TIterator AddRoot() { return AddRootItem(); }

	static TIterator AddChildBefore(TIterator ParentIter, TIterator Iter)
		{ return AddChildItemBefore(ParentIter, Iter); }

	static TIterator AddChildAfter(TIterator ParentIter, TIterator Iter)
		{ return AddChildItemAfter(ParentIter, Iter); }

	static TIterator AddFirstChild(TIterator ParentIter)
		{ return AddFirstChildItem(ParentIter); }

	static TIterator AddLastChild(TIterator ParentIter)
		{ return AddLastChildItem(ParentIter); }

	static TIterator AddSiblingBefore(TIterator Iter)
		{ return AddSiblingItemBefore(Iter); }

	static TIterator AddSiblingAfter(TIterator Iter)
		{ return AddSiblingItemAfter(Iter); }
	
	static TIterator AddFirstSibling(TIterator Iter)
		{ return AddFirstSiblingItem(Iter); }

	static TIterator AddLastSibling(TIterator Iter)
		{ return AddLastSiblingItem(Iter); }

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
