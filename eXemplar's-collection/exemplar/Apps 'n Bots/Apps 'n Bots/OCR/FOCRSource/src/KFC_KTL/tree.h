#ifndef tree_h
#define tree_h

#include <limits.h>
#include "kfc_ktl_api.h"
#include "basic_types.h"

// -----------------------
// Tree preservation mode
// -----------------------
enum TTreePreservationMode
{
	TPM_NONE		= 0,
	TPM_SELF		= 1,
	TPM_CHILDREN	= 2,
	TPM_ALL			= 3,
	TPM_FORCE_UINT	= UINT_MAX,
};

// ----------
// Tree item
// ----------
struct TTreeItem
{
	TTreeItem*	m_pParent;
	TTreeItem*	m_pPrevSibling;
	TTreeItem*	m_pNextSibling;
	TTreeItem*	m_pFirstChild;
	TTreeItem*	m_pLastChild;
	size_t		m_szNChildren;
	size_t		m_szDepth;


	TTreeItem(	TTreeItem*	pSParent,
				TTreeItem*	pSPrevSibling,
				TTreeItem*	pSNextSibling,
				size_t		szSDepth) :	m_pParent		(pSParent),
										m_pPrevSibling	(pSPrevSibling),
										m_pNextSibling	(pSNextSibling),
										m_pFirstChild	(NULL),
										m_pLastChild	(NULL),
										m_szNChildren	(0),
										m_szDepth		(szSDepth) {}
};

// -------------------
// Free tree iterator
// -------------------
class TFreeTreeIterator
{
private:
	TTreeItem* m_pItem;

public:
	TFreeTreeIterator()									: m_pItem(NULL)				{}
	TFreeTreeIterator(const TFreeTreeIterator&	SIter)	: m_pItem(SIter.m_pItem)	{}
	TFreeTreeIterator(TTreeItem*				pSItem)	: m_pItem(pSItem)			{}

	static TFreeTreeIterator FromPVoid(void* pData)
		{ return (TTreeItem*)pData; }

	void Invalidate() { m_pItem = NULL; }
			
	TFreeTreeIterator& operator = (const TFreeTreeIterator& SIter)
		{ m_pItem = SIter.m_pItem; return *this; }
	
	bool IsValid() const { return m_pItem != NULL; }

	TFreeTreeIterator GetParent() const { return m_pItem->m_pParent; }

	TFreeTreeIterator GetPrevSibling() const { return m_pItem->m_pPrevSibling; }
	TFreeTreeIterator GetNextSibling() const { return m_pItem->m_pNextSibling; }

	TFreeTreeIterator GetFirstChild	() const { return m_pItem->m_pFirstChild;	}
	TFreeTreeIterator GetLastChild	() const { return m_pItem->m_pLastChild;	}

	TFreeTreeIterator& ToParent() { m_pItem = m_pItem->m_pParent; return *this; }

	TFreeTreeIterator& ToPrevSibling() { m_pItem = m_pItem->m_pPrevSibling; return *this; }
	TFreeTreeIterator& ToNextSibling() { m_pItem = m_pItem->m_pNextSibling; return *this; }

	TFreeTreeIterator& ToFirstChild	() { m_pItem = m_pItem->m_pFirstChild;	return *this; }
	TFreeTreeIterator& ToLastChild	() { m_pItem = m_pItem->m_pLastChild;	return *this; }

	size_t	GetNChildren() const { return m_pItem->m_szNChildren;	}
	size_t	GetDepth	() const { return m_pItem->m_szDepth;		}
	bool	IsLeaf		() const { return GetNChildren() == 0;		}
	
	bool operator == (const TFreeTreeIterator& SIter) const
		{ return m_pItem == SIter.m_pItem; }

	bool operator != (const TFreeTreeIterator& SIter) const
		{ return m_pItem != SIter.m_pItem; }

	void* AsPVoid() const { return (void*)m_pItem; }
};

// -------------------------
// Free tree const iterator
// -------------------------
class TFreeTreeConstIterator
{
private:
	const TTreeItem* m_pItem;

public:
	TFreeTreeConstIterator()										: m_pItem(NULL)							{}
	TFreeTreeConstIterator(const TFreeTreeConstIterator&	SIter)	: m_pItem(SIter.m_pItem)				{}
	TFreeTreeConstIterator(const TFreeTreeIterator&			SIter)	: m_pItem((TTreeItem*)SIter.AsPVoid())	{}
	TFreeTreeConstIterator(const TTreeItem*					pSItem)	: m_pItem(pSItem)						{}

	static TFreeTreeConstIterator FromPVoid(void* pData)
		{ return (const TTreeItem*)pData; }

	void Invalidate() { m_pItem = NULL; }
	
	TFreeTreeConstIterator& operator = (const TFreeTreeConstIterator& SIter)
		{ m_pItem = SIter.m_pItem; return *this; }

	TFreeTreeConstIterator& operator = (const TFreeTreeIterator& SIter)
		{ m_pItem = (TTreeItem*)SIter.AsPVoid(); return *this; }

	bool IsValid() const { return m_pItem != NULL; }

	TFreeTreeConstIterator GetParent() const { return m_pItem->m_pParent; }

	TFreeTreeConstIterator GetPrevSibling() const { return m_pItem->m_pPrevSibling; }
	TFreeTreeConstIterator GetNextSibling() const { return m_pItem->m_pNextSibling; }

	TFreeTreeConstIterator GetFirstChild() const { return m_pItem->m_pFirstChild;	}
	TFreeTreeConstIterator GetLastChild	() const { return m_pItem->m_pLastChild;	}

	TFreeTreeConstIterator& ToParent() { m_pItem = m_pItem->m_pParent; return *this; }

	TFreeTreeConstIterator& ToPrevSibling() { m_pItem = m_pItem->m_pPrevSibling; return *this; }
	TFreeTreeConstIterator& ToNextSibling() { m_pItem = m_pItem->m_pNextSibling; return *this; }

	TFreeTreeConstIterator& ToFirstChild() { m_pItem = m_pItem->m_pFirstChild;	return *this; }
	TFreeTreeConstIterator& ToLastChild	() { m_pItem = m_pItem->m_pLastChild;	return *this; }

	size_t	GetNChildren() const { return m_pItem->m_szNChildren;	}
	size_t	GetDepth	() const { return m_pItem->m_szDepth;		}
	bool	IsLeaf		() const { return GetNChildren() == 0;		}
	
	bool operator == (const TFreeTreeConstIterator& SIter) const
		{ return m_pItem == SIter.m_pItem; }

	bool operator != (const TFreeTreeConstIterator& SIter) const
		{ return m_pItem != SIter.m_pItem; }

	bool IsOwner(const TFreeTreeIterator&		SIter) const;
	bool IsOwner(const TFreeTreeConstIterator&	SIter) const;

	void* AsPVoid() const { return (void*)m_pItem; }
};

// --------------
// Tree iterator
// --------------
template <class ItemType, class ObjectType>
class TTreeIterator
{
private:
	ItemType* m_pItem;

public:
	TTreeIterator()								: m_pItem(NULL)				{}
	TTreeIterator(const TTreeIterator&	SIter)	: m_pItem(SIter.m_pItem)	{}
	TTreeIterator(ItemType*				pSItem)	: m_pItem(pSItem)			{}

	static TTreeIterator<ItemType, ObjectType> FromFreeIterator(const TFreeTreeIterator& SIter)
		{ return (ItemType*)SIter.AsPVoid(); }

	static TTreeIterator<ItemType, ObjectType> FromPVoid(void* pData)
		{ return (ItemType*)pData; }

	void Invalidate() { m_pItem = NULL; }

	TTreeIterator<ItemType, ObjectType>& operator = (const TTreeIterator<ItemType, ObjectType>& SIter)
		{ m_pItem = SIter.m_pItem; return *this; }

	TTreeIterator<ItemType, ObjectType>& operator = (const TFreeTreeIterator& SIter)
		{ m_pItem = (ItemType*)SIter.AsPVoid(); return *this; }

	bool IsValid() const { return m_pItem != NULL; }

	TTreeIterator<ItemType, ObjectType> GetParent() const { return (ItemType*)m_pItem->m_pParent; }

	TTreeIterator<ItemType, ObjectType> GetPrevSibling() const { return (ItemType*)m_pItem->m_pPrevSibling; }
	TTreeIterator<ItemType, ObjectType> GetNextSibling() const { return (ItemType*)m_pItem->m_pNextSibling; }

	TTreeIterator<ItemType, ObjectType> GetFirstChild	() const { return (ItemType*)m_pItem->m_pFirstChild;	}
	TTreeIterator<ItemType, ObjectType> GetLastChild	() const { return (ItemType*)m_pItem->m_pLastChild;		}

	TTreeIterator<ItemType, ObjectType>& ToParent() { m_pItem = (ItemType*)m_pItem->m_pParent; return *this; }

	TTreeIterator<ItemType, ObjectType>& ToPrevSibling() { m_pItem = (ItemType*)m_pItem->m_pPrevSibling; return *this; }
	TTreeIterator<ItemType, ObjectType>& ToNextSibling() { m_pItem = (ItemType*)m_pItem->m_pNextSibling; return *this; }

	TTreeIterator<ItemType, ObjectType>& ToFirstChild	() { m_pItem = (ItemType*)m_pItem->m_pFirstChild;	return *this; }
	TTreeIterator<ItemType, ObjectType>& ToLastChild	() { m_pItem = (ItemType*)m_pItem->m_pLastChild;	return *this; }

	bool IsFirstChild	() const { return !GetPrevSibling().IsValid(); }
	bool IsLastChild	() const { return !GetNextSibling().IsValid(); }

	size_t	GetNChildren() const { return m_pItem->m_szNChildren;	}
	size_t	GetDepth	() const { return m_pItem->m_szDepth;		}
	bool	IsLeaf		() const { return GetNChildren() == 0;		}
	
	bool operator == (const TTreeIterator<ItemType, ObjectType>& SIter) const
		{ return m_pItem == SIter.m_pItem; }

	bool operator != (const TTreeIterator<ItemType, ObjectType>& SIter) const
		{ return m_pItem != SIter.m_pItem; }

	ObjectType* GetDataPtr() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("tree iterator"));

		return m_pItem->GetDataPtr();
	}

	ObjectType& GetDataRef() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("tree iterator"));

		return m_pItem->GetDataRef();
	}

	ObjectType* operator ->	() const { return GetDataPtr(); }
	ObjectType& operator *	() const { return GetDataRef(); }

	operator TFreeTreeIterator		() const { return m_pItem; }
	operator TFreeTreeConstIterator	() const { return m_pItem; }

	void* AsPVoid() const { return (void*)m_pItem; }

	TTreeIterator GetPrev() const;
	TTreeIterator GetNext() const;

	TTreeIterator& ToPrev() { return *this = GetPrev(); }
	TTreeIterator& ToNext() { return *this = GetNext(); }

	TTreeIterator& operator -- () { return ToPrev(); }
	TTreeIterator& operator ++ () { return ToNext(); }
};

template <class ItemType, class ObjectType>
TTreeIterator<ItemType, ObjectType> TTreeIterator<ItemType, ObjectType>::GetPrev() const
{
	DEBUG_VERIFY_VALIDNESS(TEXT("tree iterator"));

	TTreeIterator<ItemType, ObjectType> Iter = *this;

	if(Iter.IsFirstChild())
	{
		return GetParent();
	}
	else
	{
		TTreeIterator Iter = GetPrevSibling();

		while(!Iter.IsLeaf())
			Iter.ToLastChild();

		return Iter;
	}
}

template <class ItemType, class ObjectType>
TTreeIterator<ItemType, ObjectType> TTreeIterator<ItemType, ObjectType>::GetNext() const
{
	DEBUG_VERIFY_VALIDNESS(TEXT("tree iterator"));

	if(IsLeaf())
	{
		for(TTreeIterator Iter = *this ;
			Iter.IsValid() ;
			Iter.ToParent())
		{
			if(!Iter.IsLastChild())
				return Iter.GetNextSibling();
		}

		return TTreeIterator();
	}
	else
	{
		return GetFirstChild();
	}	
}

// --------------------
// Tree const iterator
// --------------------
template <class ItemType, class ObjectType>
class TTreeConstIterator
{
private:
	const ItemType* m_pItem;

public:
	TTreeConstIterator()														: m_pItem(NULL)							{}
	TTreeConstIterator(const TTreeConstIterator<ItemType, ObjectType>&	SIter)	: m_pItem(SIter.m_pItem)				{}
	TTreeConstIterator(const TTreeIterator<ItemType, ObjectType>&		SIter)	: m_pItem((ItemType*)SIter.AsPVoid())	{}
	TTreeConstIterator(const ItemType*									pSItem)	: m_pItem(pSItem)						{}

	static TTreeConstIterator<ItemType, ObjectType> FromFreeIterator(const TFreeTreeConstIterator& SIter)
		{ return (const ItemType*)SIter.AsPVoid(); }

	static TTreeConstIterator<ItemType, ObjectType> FromFreeIterator(const TFreeTreeIterator& SIter)
		{ return (const ItemType*)SIter.AsPVoid(); }

	static TTreeConstIterator<ItemType, ObjectType> FromPVoid(void* pData)
		{ return (const ItemType*)pData); }

	void Invalidate() { m_pItem = NULL; }
			
	TTreeConstIterator<ItemType, ObjectType>& operator = (const TTreeConstIterator<ItemType, ObjectType>& SIter)
		{ m_pItem = SIter.m_pItem; return *this; }

	TTreeConstIterator<ItemType, ObjectType>& operator = (const TTreeIterator<ItemType, ObjectType>& SIter)
		{ m_pItem = (ItemType*)SIter.AsPVoid(); return *this; }

	TTreeConstIterator<ItemType, ObjectType>& operator = (const TFreeTreeConstIterator& SIter)
		{ m_pItem = (const ItemType*)SIter.AsPVoid(); return *this; }

	TTreeConstIterator<ItemType, ObjectType>& operator = (const TFreeTreeIterator& SIter)
		{ m_pItem = (ItemType*)SIter.AsPVoid(); return *this; }

	bool IsValid() const { return m_pItem != NULL; }

	TTreeConstIterator<ItemType, ObjectType> GetParent() const { return (const ItemType*)m_pItem->m_pParent; }

	TTreeConstIterator<ItemType, ObjectType> GetPrevSibling() const { return (const ItemType*)m_pItem->m_pPrevSibling; }
	TTreeConstIterator<ItemType, ObjectType> GetNextSibling() const { return (const ItemType*)m_pItem->m_pNextSibling; }

	TTreeConstIterator<ItemType, ObjectType> GetFirstChild	() const { return (const ItemType*)m_pItem->m_pFirstChild;	}
	TTreeConstIterator<ItemType, ObjectType> GetLastChild	() const { return (const ItemType*)m_pItem->m_pLastChild;	}

	TTreeConstIterator<ItemType, ObjectType>& ToParent() { m_pItem = (const ItemType*)m_pItem->m_pParent; return *this; }

	TTreeConstIterator<ItemType, ObjectType>& ToPrevSibling() { m_pItem = (const ItemType*)m_pItem->m_pPrevSibling; return *this; }
	TTreeConstIterator<ItemType, ObjectType>& ToNextSibling() { m_pItem = (const ItemType*)m_pItem->m_pNextSibling; return *this; }

	TTreeConstIterator<ItemType, ObjectType>& ToFirstChild	() { m_pItem = (const ItemType*)m_pItem->m_pFirstChild;	return *this; }
	TTreeConstIterator<ItemType, ObjectType>& ToLastChild	() { m_pItem = (const ItemType*)m_pItem->m_pLastChild;	return *this; }

	bool IsFirstChild	() const { return !GetPrevSibling().IsValid(); }
	bool IsLastChild	() const { return !GetNextSibling().IsValid(); }

	size_t	GetNChildren() const { return m_pItem->m_szNChildren;	}
	size_t	GetDepth	() const { return m_pItem->m_szDepth;		}
	bool	IsLeaf		() const { return GetNChildren() == 0;		}
	
	bool operator == (const TTreeConstIterator<ItemType, ObjectType>& SIter) const
		{ return m_pItem == SIter.m_pItem; }

	bool operator != (const TTreeConstIterator<ItemType, ObjectType>& SIter) const
		{ return m_pItem != SIter.m_pItem; }

	const ObjectType* GetDataPtr() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("tree const iterator"));

		return m_pItem->GetDataPtr();
	}

	const ObjectType& GetDataRef() const
	{
		DEBUG_VERIFY_VALIDNESS(TEXT("tree const iterator"));

		return m_pItem->GetDataRef();
	}

	const ObjectType* operator ->	() const { return GetDataPtr(); }
	const ObjectType& operator *	() const { return GetDataRef(); }

	operator TFreeTreeConstIterator () const { return m_pItem; }

	void* AsPVoid() const { return (void*)m_pItem; }

	TTreeConstIterator GetPrev() const;
	TTreeConstIterator GetNext() const;

	TTreeConstIterator& ToPrev() { return *this = GetPrev(); }
	TTreeConstIterator& ToNext() { return *this = GetNext(); }

	TTreeConstIterator& operator -- () { return ToPrev(); }
	TTreeConstIterator& operator ++ () { return ToNext(); }
};

template <class ItemType, class ObjectType>
TTreeConstIterator<ItemType, ObjectType> TTreeConstIterator<ItemType, ObjectType>::GetPrev() const
{
	DEBUG_VERIFY_VALIDNESS(TEXT("tree const iterator"));

	TTreeConstIterator Iter = *this;

	if(Iter.IsFirstChild())
	{
		return GetParent();
	}
	else
	{
		TTreeConstIterator Iter = GetPrevSibling();

		while(!Iter.IsLeaf())
			Iter.ToLastChild();

		return Iter;
	}
}

template <class ItemType, class ObjectType>
TTreeConstIterator<ItemType, ObjectType> TTreeConstIterator<ItemType, ObjectType>::GetNext() const
{
	DEBUG_VERIFY_VALIDNESS(TEXT("tree const iterator"));

	if(IsLeaf())
	{
		for(TTreeConstIterator Iter = *this ;
			Iter.IsValid() ;
			Iter.ToParent())
		{
			if(!Iter.IsLastChild())
				return Iter.GetNextSibling();
		}

		return TTreeConstIterator();
	}
	else
	{
		return GetFirstChild();
	}	
}

// -----
// Tree
// -----
template <class t, class ot>
class TTree
{
private:
	t* m_pRoot;


	// Deletion
	static void DelBranch(	TFreeTreeIterator&		Iter,
							TTreePreservationMode	PreservationMode);

	// Copying
	void Copy(const TTree<t, ot>& STree);
	static void CopyItem(TFreeTreeConstIterator SrcIter, TFreeTreeIterator DstIter);

protected:
	// Deletion
	void DelItem(	TFreeTreeIterator&		Iter,
					TTreePreservationMode	PreservationMode = TPM_NONE);

	// Addition
	t* AddRootItem();

	static t* AddChildItemBefore(TFreeTreeIterator ParentIter, TFreeTreeIterator Iter);
	static t* AddChildItemAfter	(TFreeTreeIterator ParentIter, TFreeTreeIterator Iter);

	static t* AddFirstChildItem(TFreeTreeIterator ParentIter)
		{ return AddChildItemBefore(ParentIter, ParentIter.GetFirstChild()); }

	static t* AddLastChildItem(TFreeTreeIterator ParentIter)
		{ return AddChildItemAfter(ParentIter, ParentIter.GetLastChild()); }

	static t* AddSiblingItemBefore(TFreeTreeIterator Iter)
		{ return AddChildItemBefore(Iter.GetParent(), Iter); }

	static t* AddSiblingItemAfter(TFreeTreeIterator Iter)
		{ return AddChildItemAfter(Iter.GetParent(), Iter); }

	static t* AddFirstSiblingItem(TFreeTreeIterator Iter)
		{ return AddFirstChildItem(Iter.GetParent()); }

	static t* AddLastSiblingItem(TFreeTreeIterator Iter)
		{ return AddLastChildItem(Iter.GetParent()); }

	// Iterators
	t*			GetRootItem()		{ return m_pRoot; }
	const t*	GetRootItem() const	{ return m_pRoot; }

	t*			GetFirstItem()			{ return GetRootItem(); }
	const t*	GetFirstItem() const	{ return GetRootItem(); }

	t*			GetLastItem();
	const t*	GetLastItem() const;

	// Construction
	TTree();

	TTree(const TTree<t, ot>& STree);

	~TTree() { Clear(); }

	// Operators
	TTree<t, ot>& operator = (const TTree<t, ot>& STree)
		{ Copy(STree); return *this; }

public:
	// Info
	bool IsEmpty() const { return m_pRoot == NULL; }

	// Clearing
	void Clear()
		{ if(!IsEmpty()) DelItem(TFreeTreeIterator(GetRootItem())); }
};

// Construction
template <class t, class ot>
TTree<t, ot>::TTree()
{
	m_pRoot = NULL;
}

template <class t, class ot>
TTree<t, ot>::TTree(const TTree<t, ot>& STree)
{
	m_pRoot = NULL;

	Copy(STree);
}

// Copying
template <class t, class ot>
void TTree<t, ot>::CopyItem(TFreeTreeConstIterator SrcIter, TFreeTreeIterator DstIter)
{
	((t*)DstIter.AsPVoid())->CopyData(((const t*)SrcIter.AsPVoid())->GetDataRef());
	
	for(SrcIter.ToFirstChild() ; SrcIter.IsValid() ; SrcIter.ToNextSibling())
		CopyItem(SrcIter, AddLastChildItem(DstIter));
}

template <class t, class ot>
void TTree<t, ot>::Copy(const TTree<t, ot>& STree)
{
	if(&STree == this)
		return;

	Clear();

	if(STree.IsEmpty())
		return;

	CopyItem(STree.GetRootItem(), AddRootItem());
}

// Addition
template <class t, class ot>
t* TTree<t, ot>::AddRootItem()
{
	Clear();

	return m_pRoot = new t(NULL, NULL, NULL, 0);
}

template <class t, class ot>
t* TTree<t, ot>::AddChildItemBefore(TFreeTreeIterator ParentIter, TFreeTreeIterator Iter)
{
	t* pNewItem;

	TTreeItem* pParent = (TTreeItem*)ParentIter.AsPVoid();

	if(pParent->m_szNChildren) // has children
	{
		TTreeItem* pItem = (TTreeItem*)Iter.AsPVoid();

		pNewItem = new t(pParent, pItem->m_pPrevSibling, pItem, pParent->m_szDepth + 1);

		if(pItem->m_pPrevSibling)
			pItem->m_pPrevSibling->m_pNextSibling = pNewItem;

		pItem->m_pPrevSibling = pNewItem;

		if(pItem == pParent->m_pFirstChild)
			pParent->m_pFirstChild = pNewItem;
	}
	else // first child
	{
		pNewItem = new t(pParent, NULL, NULL, pParent->m_szDepth + 1);

		pParent->m_pFirstChild = pParent->m_pLastChild = pNewItem;
	}
	
	pParent->m_szNChildren++;

	return pNewItem;
}

template <class t, class ot>
t* TTree<t, ot>::AddChildItemAfter(TFreeTreeIterator ParentIter, TFreeTreeIterator Iter)
{
	t* pNewItem;

	TTreeItem* pParent = (TTreeItem*)ParentIter.AsPVoid();

	if(pParent->m_szNChildren) // has children
	{
		TTreeItem* pItem = (TTreeItem*)Iter.AsPVoid();

		pNewItem = new t(pParent, pItem, pItem->m_pNextSibling, pParent->m_szDepth + 1);

		if(pItem->m_pNextSibling)
			pItem->m_pNextSibling->m_pPrevSibling = pNewItem;

		pItem->m_pNextSibling = pNewItem;

		if(pItem == pParent->m_pLastChild)
			pParent->m_pLastChild = pNewItem;
	}
	else // first child
	{
		pNewItem = new t(pParent, NULL, NULL, pParent->m_szDepth + 1);

		pParent->m_pFirstChild = pParent->m_pLastChild = pNewItem;
	}
	
	pParent->m_szNChildren++;

	return pNewItem;
}

// Deletion
template <class t, class ot>
void TTree<t, ot>::DelBranch(TFreeTreeIterator&		Iter,
							 TTreePreservationMode	PreservationMode)
{
	TTreePreservationMode PreservationMode2;

	if(PreservationMode == TPM_NONE || PreservationMode == TPM_SELF)
		PreservationMode2 = TPM_NONE;
	else if(PreservationMode == TPM_CHILDREN || PreservationMode == TPM_ALL)
		PreservationMode2 = TPM_ALL;
	else
		INITIATE_FAILURE;

	for(TFreeTreeIterator Iter2 = Iter.GetLastChild() ; Iter2.IsValid() ; )
	{
		TFreeTreeIterator PIter = Iter2.GetPrevSibling();

		DelBranch(Iter2, PreservationMode2);

		Iter2 = PIter;
	}

	if(PreservationMode == TPM_SELF || PreservationMode == TPM_ALL)
		((t*)Iter.AsPVoid())->PreserveData();

	delete (t*)Iter.AsPVoid();
	
	Iter.Invalidate();
}

template <class t, class ot>
void TTree<t, ot>::DelItem(	TFreeTreeIterator&		Iter,
							TTreePreservationMode	PreservationMode)
{
	DEBUG_VERIFY(Iter.IsValid());

	TTreeItem* pItem	= (t*)Iter.AsPVoid();
	TTreeItem* pParent	= pItem->m_pParent;

	if(pParent) // not root
	{
		if(pItem->m_pPrevSibling)
			pItem->m_pPrevSibling->m_pNextSibling = pItem->m_pNextSibling;
		else
			pParent->m_pFirstChild = pItem->m_pNextSibling;

		if(pItem->m_pNextSibling)
			pItem->m_pNextSibling->m_pPrevSibling = pItem->m_pPrevSibling;
		else
			pParent->m_pLastChild = pItem->m_pPrevSibling;

		pParent->m_szNChildren--;
	}
	else // root
	{
		m_pRoot = NULL;
	}
	
	DelBranch(Iter, PreservationMode);
}

// Iterators
template <class t, class ot>
t* TTree<t, ot>::GetLastItem()
{
	if(IsEmpty())
		return NULL;

	TTreeItem* pItem = GetRootItem();
	for(;;)
	{
		if(pItem->m_pLastChild == NULL)
			return (t*)pItem;

		pItem = pItem->m_pLastChild;
	}
}

template <class t, class ot>
const t* TTree<t, ot>::GetLastItem() const
{
	if(IsEmpty())
		return NULL;

	const TTreeItem* pItem = GetRootItem();
	for(;;)
	{
		if(pItem->m_pLastChild == NULL)
			return (t*)pItem;

		pItem = pItem->m_pLastChild;
	}
}

#endif // tree_h
