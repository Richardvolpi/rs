#ifndef resource_updater_h
#define resource_updater_h

// -----------------
// Resource updater
// -----------------
class KFC_COMMON_API TResourceUpdater
{
private:
	HANDLE m_hHandle;
	
public:
	TResourceUpdater();

	TResourceUpdater(	LPCTSTR	pFileName,
						bool	bDeleteExisting = false);

	~TResourceUpdater() { Release(); }

	bool IsEmpty() const { return m_hHandle == NULL; }

	void Release(bool bCommit = true);

	void Allocate(	LPCTSTR	pFileName,
					bool	bDeleteExisting = false);

	void Update(LPCTSTR		pType,
				size_t		szID,
				const void*	pData,
				size_t		szLength,
				WORD		wLanguage = MAKELANGID(LANG_NEUTRAL, SUBLANG_NEUTRAL));

	void UpdateFile(LPCTSTR	pType,
					size_t	szID,
					LPCTSTR	pFileName,
					WORD	wLanguage = MAKELANGID(LANG_NEUTRAL, SUBLANG_NEUTRAL));

	HANDLE GetHandle() const;

	operator HANDLE () const { return GetHandle(); }
};

#endif // resource_updater_h