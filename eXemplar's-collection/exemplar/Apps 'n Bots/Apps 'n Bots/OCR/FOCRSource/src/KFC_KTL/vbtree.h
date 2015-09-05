#ifndef vbtree_h
#define vbtree_h

#include "btree.h"

// -----------------
// Value btree item
// -----------------
template <class ObjectType>
struct TValueBTreeItem : public TBTreeItem
{
	ObjectType m_Data;


	TValueBTreeItem(TBTreeItem* pSParent) : TBTreeItem(pSParent) {}

	ObjectType&			GetDataRef()		{ return m_Data; }
	const ObjectType&	GetDataRef() const	{ return m_Data; }

	ObjectType*			GetDataPtr()		{ return &m_Data; }
	const ObjectType*	GetDataPtr() const	{ return &m_Data; }
};

template <class ObjectType, class RefType>
inline int Compare(const TValueBTreeItem<ObjectType>& Item, RefType RefV)
{
	return Compare(Item.m_Data, RefV);
}

// ------
// BTree
// ------
template <class ObjectType, class RefType = ObjectType&>
class TValueBTree : public TBTree<TValueBTreeItem<ObjectType>, ObjectType, RefType>
{
public:
	TValueBTree() {}

	TBTreeIterator Add(RefType RefV) { return AddItem(RefV); }
};

#endif // vbtree_h
