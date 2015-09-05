#ifndef object_pointer_h
#define object_pointer_h

#include "basic_types.h"
#include "placement_allocation.h"

// ---------------
// Object pointer
// ---------------
template <class ObjectType>
class TObjectPointer
{
private:
	bool m_bAllocated;

	ObjectType*	m_pObject;

	bool m_bExternal;

public:
	TObjectPointer();

	TObjectPointer(ObjectType* pSObject, bool bSExternal);

	~TObjectPointer() { Release(); }
	
	bool IsEmpty() const { return !m_bAllocated; }

	void Release();

	ObjectType* Allocate(ObjectType* pSObject, bool bSExternal);

	ObjectType* ReOwn(TObjectPointer<ObjectType>& SPointer);

	ObjectType* MakeInternal();
	ObjectType* MakeExternal();

	ObjectType*			GetDataPtr()		{ return m_pObject; }
	const ObjectType*	GetDataPtr() const	{ return m_pObject; }

	ObjectType&			GetDataRef()		{ return *GetDataPtr(); }
	const ObjectType&	GetDataRef() const	{ return *GetDataPtr(); }

	ObjectType* operator -> ()
	{
		DEBUG_VERIFY_ALLOCATION;

		return GetDataPtr();
	}

	const ObjectType* operator -> () const
	{
		DEBUG_VERIFY_ALLOCATION;

		return GetDataPtr();
	}

	ObjectType& operator * ()
	{
		DEBUG_VERIFY_ALLOCATION;

		return GetDataRef();
	}

	const ObjectType& operator * () const
	{
		DEBUG_VERIFY_ALLOCATION;

		return GetDataRef();
	}

	// -------------------- TRIVIALS -----------------------
	bool IsInternal() const { return !m_bExternal;	}
	bool IsExternal() const { return m_bExternal;	}
};

template <class ObjectType>
TObjectPointer<ObjectType>::TObjectPointer()
{
	m_bAllocated = false;

	m_pObject = NULL;

	m_bExternal = true;
}

template <class ObjectType>
TObjectPointer<ObjectType>::TObjectPointer(ObjectType* pSObject, bool bSExternal)
{
	m_bAllocated = false;

	m_pObject = NULL;

	m_bExternal = true;

	Allocate(pSObject, bSExternal);
}

template <class ObjectType>
void TObjectPointer<ObjectType>::Release()
{
	if(m_bAllocated)
	{
		m_bAllocated = false;

		if(IsInternal())
			delete m_pObject;

		m_pObject = NULL;

		m_bExternal = true;		
	}
}

template <class ObjectType>
ObjectType* TObjectPointer<ObjectType>::Allocate(ObjectType* pSObject, bool bSExternal)
{
	Release();

	if(pSObject == NULL)
		return GetDataPtr();

	m_pObject = pSObject;

	m_bExternal = bSExternal;

	m_bAllocated = true;

	return GetDataPtr();
}

template <class ObjectType>
ObjectType* TObjectPointer<ObjectType>::ReOwn(TObjectPointer<ObjectType>& SPointer)
{
	Release();

	if(SPointer.IsEmpty())
		return GetDataPtr();

	if(SPointer.IsInternal())
		Allocate(SPointer.GetDataPtr(), false), SPointer.MakeExternal();
	else
		Allocate(SPointer.GetDataPtr(), true);

	return GetDataPtr();
}

template <class ObjectType>
ObjectType* TObjectPointer<ObjectType>::MakeInternal()
{
	DEBUG_VERIFY_ALLOCATION;

	m_bExternal = false;

	return GetDataPtr();
}

template <class ObjectType>
ObjectType* TObjectPointer<ObjectType>::MakeExternal()
{
	DEBUG_VERIFY_ALLOCATION;

	m_bExternal = true;

	return GetDataPtr();
}

#endif // object_pointer_h
