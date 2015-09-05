#ifndef service_h
#define service_h

// ----------------
// Service manager
// ----------------
class KFC_COMMON_API TServiceManager
{
private:
	SC_HANDLE m_hManager;
	
public:
	TServiceManager(flags_t flAutoOpenAccess = 0); // 0 avoids auto-allocation

	~TServiceManager() { Release(); }

	bool IsEmpty() const { return m_hManager == NULL; }

	void Release();

	void Allocate(flags_t flAccess);

	SC_HANDLE CreateService(LPCTSTR pServiceName,
							LPCTSTR pDisplayName,
							LPCTSTR pFileName);

	SC_HANDLE OpenService(	LPCTSTR pServiceName,
							flags_t flAccess);

	void DeleteService(SC_HANDLE hService, bool bSafe);

	SC_HANDLE GetManager() const;

	operator SC_HANDLE () const { return GetManager(); }
};

// --------
// Service
// --------
class KFC_COMMON_API TService
{
private:
	SC_HANDLE m_hService;
	
public:
	TService();

	TService(SC_HANDLE hSService);

	~TService() { Release(); }	

	bool IsEmpty() const { return m_hService == NULL; }

	void Invalidate();

	void Release();

	void Allocate(SC_HANDLE hSService);

	void Start();

	void Stop(bool bSafe);

	SC_HANDLE GetService() const;

	operator SC_HANDLE () const { return GetService(); }
};

#endif // service_h