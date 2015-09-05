#ifndef method_ptr_h
#define method_ptr_h

// ---------------
// Method pointer
// ---------------
template <class ClassType, class MethodType>
struct TMethodPtr
{
private:
	void Copy(const TMethodPtr<ClassType, MethodType>& SMethodPtr)
		{ m_pObject = SMethodPtr.m_pObject, m_pMethod = SMethodPtr.m_pMethod; }

public:
	ClassType*	m_pObject;
	MethodType	m_pMethod;

	
	TMethodPtr() :	m_pObject(NULL),
					m_pMethod(NULL) {}

	TMethodPtr(const TMethodPtr<ClassType, MethodType>& SMethodPtr)
		{ Copy(SMethodPtr); }

	TMethodPtr(	ClassType* pSObject,
				MethodType pSMethod) :	m_pObject(pSObject),
										m_pMethod(pSMethod) {}

	bool IsValid() const { return m_pObject && m_pMethod; }

	TMethodPtr& operator = (const TMethodPtr& SMethodPtr)
		{ Copy(SMethodPtr); return *this; }

	bool operator == (const TMethodPtr& SMethodPtr) const
		{ return m_pObject == SMethodPtr.m_pObject && m_pMethod == SMethodPtr.m_pMethod; }

	bool operator != (const TMethodPtr& SMethodPtr) const
		{ return m_pObject != SMethodPtr.m_pObject || m_pMethod != SMethodPtr.m_pMethod; }
};

#endif // method_ptr_h
