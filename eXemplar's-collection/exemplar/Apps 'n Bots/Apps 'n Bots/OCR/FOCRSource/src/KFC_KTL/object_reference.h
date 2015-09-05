#ifndef object_reference_h
#define object_reference_h

#include "basic_types.h"
#include "placement_allocation.h"

// -----------------
// Object reference
// -----------------
template <class ObjectType>
class TObjectReference
{
private:
	bool m_bAllocated;

	BYTE m_Data[sizeof(ObjectType)];

	ObjectType*	m_pObject;

public:
	TObjectReference();

	~TObjectReference() { Release(); }
	
	bool IsEmpty() const { return !m_bAllocated; }

	void Release();

	ObjectType& CreateInternal();
	ObjectType& CreateInternal(const ObjectType& SObject);

	ObjectType& CreateReference(ObjectType& SObject);

	ObjectType* GetDataPtr()
		{ return IsEmpty() ? NULL : m_pObject; }

	const ObjectType* GetDataPtr() const
		{ return IsEmpty() ? NULL : m_pObject; }

	ObjectType& GetDataRef()
	{
		DEBUG_VERIFY_ALLOCATION;

		return *GetDataPtr();
	}

	const ObjectType& GetDataRef() const
	{
		DEBUG_VERIFY_ALLOCATION;

		return *GetDataPtr();
	}

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
	bool IsInternal() const { return m_pObject == (ObjectType*)m_Data; }
	bool IsExternal() const { return m_pObject != (ObjectType*)m_Data; }
};

template <class ObjectType>
TObjectReference<ObjectType>::TObjectReference()
{
	m_bAllocated = false;
}

template <class ObjectType>
void TObjectReference<ObjectType>::Release()
{
	if(m_bAllocated)
	{
		if(IsInternal())
			((ObjectType*)m_Data)->~ObjectType();

		m_bAllocated = false;
	}
}

template <class ObjectType>
ObjectType& TObjectReference<ObjectType>::CreateInternal()
{
	Release();

	try
	{
		new(m_Data) ObjectType();

		m_pObject = (ObjectType*)m_Data;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}

	return *m_pObject;
}

template <class ObjectType>
ObjectType& TObjectReference<ObjectType>::CreateInternal(const ObjectType& SObject)
{
	Release();

	try
	{
		m_pObject = new((void*)m_Data) ObjectType(SObject);

		m_bAllocated = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}

	return *m_pObject;
}

template <class ObjectType>
ObjectType& TObjectReference<ObjectType>::CreateReference(ObjectType& SObject)
{
	Release();

	try
	{
		DEBUG_VERIFY(&SObject != (ObjectType*)m_Data);

		m_pObject = &SObject;

		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release();
		throw 1;
	}

	return *m_pObject;
}

#endif // object_reference_h
