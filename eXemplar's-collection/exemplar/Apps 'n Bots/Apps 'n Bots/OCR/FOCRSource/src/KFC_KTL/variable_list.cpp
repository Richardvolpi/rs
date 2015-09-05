#include "kfc_ktl_pch.h"
#include "variable_list.h"

// ---------
// Variable
// ---------
TStream& operator >> (TStream& Stream, TVariable& RVariable)
{
	return Stream >>
		RVariable.m_Name >>
		RVariable.m_Value;	
}

TStream& operator << (TStream& Stream, const TVariable& Variable)
{
	return Stream <<
		Variable.m_Name <<
		Variable.m_Value;
}

// --------------
// Variable list
// --------------
KString TVariableList::GetValue(const KString& Name) const
{
	for(TConstIterator Iter = GetFirst() ; Iter.IsValid() ; ++Iter)
	{
		if(Iter->m_Name == Name)
			return Iter->m_Value;
	}

	INITIATE_DEFINED_FAILURE(	(KString)TEXT("Variable not found: \"") +
									Name +
									TEXT("\"."));
}

KString TVariableList::GetValue(const KString& Name,
								const KString& DefaultValue) const
{
	for(TConstIterator Iter = GetFirst() ;
		Iter.IsValid() ;
		++Iter)
	{
		if(Iter->m_Name == Name)
			return Iter->m_Value;
	}

	return DefaultValue;
}

void TVariableList::Add(const KString& Name,
						const KString& Value)
{
	AddLast()->Set(Name, Value);
}