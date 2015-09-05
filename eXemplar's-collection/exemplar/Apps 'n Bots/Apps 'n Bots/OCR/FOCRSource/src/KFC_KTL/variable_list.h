#ifndef variable_list_h
#define variable_list_h

#include "kstring.h"
#include "vlist.h"
#include "stream.h"
#include "kfc_ktl_api.h"

// Variable reading macro
#define READ_VARIABLE(List, Name, DefaultValue, LocalNamePrefix)	\
	do																\
	{																\
		if(!FromString(	(List).GetValue(#Name,						\
										(KString)(DefaultValue)),	\
						LocalNamePrefix##Name))						\
																	\
		{															\
			LocalNamePrefix##Name = DefaultValue;					\
		}															\
																	\
	}while(false)													\

// Variable writing macro
#define WRITE_VARIABLE(List, Name, CNamePrefix)								\
	do { (List).Add(#Name, (KString)(CNamePrefix##Name)); } while(false)	\

// ---------
// Variable
// ---------
struct KFC_KTL_API TVariable
{
	KString m_Name;
	KString m_Value;


	TVariable() {}

	TVariable(	const KString& SName,
				const KString& SValue) :	m_Name(SName),
											m_Value(SValue) {}

	TVariable& Set(	const KString& SName,
					const KString& SValue)
	{
		m_Name = SName, m_Value = SValue;

		return *this;
	}
};

DECLARE_API_STREAMING(KFC_KTL_API, TVariable);

// --------------
// Variable list
// --------------
class KFC_KTL_API TVariableList : public TValueList<TVariable>
{
public:
	KString GetValue(const KString& Name) const;

	KString GetValue(	const KString& Name,
						const KString& DefaultValue) const;

	void Add(	const KString& Name,
				const KString& Value);
};

DECLARE_LIST_STREAMING(TVariableList);

#endif // variable_list_h