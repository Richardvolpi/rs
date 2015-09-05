#ifndef interface_h
#define interface_h

// ------------
// Error codes
// ------------
#define CLNT_ERR_OK								(+0)
#define CLNT_ERR_INVALID_ARG					(-1)
#define CLNT_ERR_FILE_NOT_FOUND					(-2)
#define CLNT_ERR_RESOLVE_HOST_FAILED			(-3)
#define CLNT_ERR_UNABLE_TO_CONNECT				(-4)
#define CLNT_ERR_INVALID_SERVER_CERTIFICATE		(-5)
#define CLNT_ERR_OTHER							(-6)

// ----------------
// Global routines
// ----------------
void InitializeTransfer(HINSTANCE	hCertResInst,
						int			iCertResID);

void ReleaseTransfer();

int QueryImageServer(	LPCTSTR	pServerAddress,
						DWORD	dwServerPort,
						LPCTSTR	pLogin,
						LPCTSTR	pPassword,
						LPCTSTR	pImageFileName,
						LPTSTR	pReplyBuffer,
						DWORD	dwReplyBufferLength,
						BOOL	bSilent = TRUE);

#endif // interface_h