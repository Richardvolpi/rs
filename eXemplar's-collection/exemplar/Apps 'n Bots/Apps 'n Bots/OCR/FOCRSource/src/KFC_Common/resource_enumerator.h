#ifndef resource_enumerator_h
#define resource_enumerator_h

// --------------------
// Resource enumerator
// --------------------
class KFC_COMMON_API TResourceEnumerator
{
private:
	TValueArray<size_t, true> m_IDs;

	size_t m_szPos;

	static BOOL CALLBACK StaticEnumProc(HMODULE	hModule,
										LPCTSTR	pType,
										LPTSTR	pName,
										LPARAM	lParam);

public:
	TResourceEnumerator(HMODULE hModule,
						LPCTSTR pType);

	operator bool () const;

	TResourceEnumerator& operator ++ ();	

	size_t GetID() const;
};

#endif // resource_enumerator_h