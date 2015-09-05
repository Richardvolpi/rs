#ifndef file_h
#define file_h

#include <stdio.h>
#include <limits.h>
#include "kfc_common_api.h"
#include "common_tokens.h"

// ----------------
// File open flags
// ----------------
#define FOF_READ		(0x01)
#define FOF_WRITE		(0x02)
#define FOF_SEEK		(0x04)
#define FOF_CREATE		(0x08)
#define FOF_NEWFILE		(0x10)
#define FOF_RESIZE		(0x20)
#define FOF_TEXT		(0x40)

#define FOF_BINARYREAD	(FOF_READ | FOF_SEEK)
#define FOF_BINARYWRITE	(FOF_WRITE | FOF_SEEK | FOF_CREATE | FOF_NEWFILE | FOF_RESIZE)

#define FOF_TEXTREAD	(FOF_READ | FOF_SEEK | FOF_TEXT)
#define FOF_TEXTWRITE	(FOF_WRITE | FOF_SEEK | FOF_CREATE | FOF_NEWFILE | FOF_TEXT)

// ---------------
// File seek mode
// ---------------
enum TFileSeekMode
{
	FSM_BEGIN		= 1,
	FSM_CURRENT		= 2,
	FSM_END			= 3,
	FSM_FORCE_UINT	= UINT_MAX,
};

// ----------------------
// File read string mode
// ----------------------
enum TFileReadStringMode
{
	FRSM_ORIGINAL	= 0,
	FRSM_DELCRLF	= 1,
	FRSM_FORCE_UINT	= UINT_MAX,
};

// -----------------------
// File write string mode
// -----------------------
enum TFileWriteStringMode
{
	FWSM_ORIGINAL	= 0,
	FWSM_ADDCRLF	= 1,
	FWSM_FORCE_UINT	= UINT_MAX,
};

// --------------
// File position
// --------------
struct KFC_COMMON_API TFilePos
{
	KString	m_FileName;
	size_t	m_szOffset;
	size_t	m_szLength;
	bool	m_bPlainFile;

	// ------------- CONSTRUCTORS -----------------
	TFilePos() {}

	TFilePos(const KString& SFileName);

	TFilePos(	const KString&	SFileName,
				size_t			szSOffset,
				size_t			szSLength);
};

// -----
// File
// -----
class KFC_COMMON_API TFile : public TStream
{
private:
	bool m_bAllocated;

	union
	{
		HANDLE	m_hFile;
		FILE*	m_pFile;
	};

	TFilePos	m_FilePos;
	flags_t		m_flOpenFlags;

	void	InternalClose		();
	void	InternalCreateEmpty	();
	bool	InternalRemove		();
	void	InternalSeek		(int iOffset, TFileSeekMode Mode = FSM_BEGIN);
	size_t	InternalTell		() const;

public:
	bool m_bRemoveOnClose;
	bool m_bRemoveOnRelease;


	TFile();

	TFile(const KString& FileName);
	TFile(const KString& FileName, flags_t flSOpenFlags);

	TFile(const TFilePos& SFilePos);
	TFile(const TFilePos& SFilePos, flags_t flSOpenFlags);

	~TFile() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release();

	void Allocate(const TFilePos& SFilePos);

	bool IsOpen() const { return m_hFile ? true : false; }

	size_t GetLength() const
	{
		DEBUG_VERIFY_ALLOCATION;

		return m_FilePos.m_szLength;
	}

	void Open	(flags_t flSOpenFlags); // reopens if opened
	void Close	(); // safe for closed

	void SetLength(size_t szNewLength, bool bRetainOldOffset);

	TFile& Read	(void*			pData, size_t szSize);
	TFile& Write(const void*	pData, size_t szSize);

	TFile& ReadString	(KString&	RString, TFileReadStringMode	Mode = FRSM_DELCRLF);
	TFile& WriteString	(LPCTSTR	pString, TFileWriteStringMode	Mode = FWSM_ADDCRLF);

	TFile& ReadStrings	(KStrings&			RStrings, bool bClearFirst = true);
	TFile& WriteStrings	(const KStrings&	Strings);

	KString ReadString(TFileReadStringMode Mode = FRSM_DELCRLF);

	void IndentString	(size_t szAmt, TCHAR cChar = TEXT('\t'));
	void WriteEOL		();

	void	Seek(int iOffset, TFileSeekMode Mode = FSM_BEGIN);
	size_t	Tell() const;

	bool IsEndOfFile() const;

	void CreateEmpty();

	void Rename(const KString& FileName);

	void Remove();

	bool DoesExists() const;

	static void Copy(const TFilePos& SrcFilePos, const TFilePos& DstFilePos);

	void GetProcessedFilePos(TFilePos& RFilePos) const;
	void GetRemainingFilePos(TFilePos& RFilePos) const;

	void GetTimes(	FILETIME* pCreationTime,
					FILETIME* pLastAccessTime,
					FILETIME* pLastWriteTime) const;

	void SetTimes(	const FILETIME* pCreationTime,
					const FILETIME* pLastAccessTime,
					const FILETIME* pLastWriteTime);

	HANDLE	GetHandle();
	FILE*	GetStream();

	void StreamRead(void* pRData, size_t szLength)
		{ Read(pRData, szLength); }

	void StreamWrite(const void* pData, size_t szLength)
		{ Write(pData, szLength); }
	
	// ---------------- TRIVIALS ----------------
	flags_t GetOpenFlags() const { return m_flOpenFlags; }

	const TFilePos &GetFilePos() const { return m_FilePos; }
};

// ------------
// File opener
// ------------
class KFC_COMMON_API TFileOpener
{
private:
	TFile& m_File;

public:
	TFileOpener(TFile& SFile, flags_t flOpenFlags);

	~TFileOpener();

	// ---------------- TRIVIALS ----------------
	TFile&			GetFile()		{ return m_File; }
	const TFile&	GetFile() const	{ return m_File; }
};

// ------------
// File filter
// ------------
typedef bool TFileFilter(const KString& Name, bool bFile, void* pParam);

// -----------------------
// File system entry type
// -----------------------
enum TFileSystemEntryType
{
	FSET_NONE		= 0,
	FSET_FILE		= 1,
	FSET_FOLDER		= 2,
	FSET_FORCE_UINT	= UINT_MAX,
};

DECLARE_BASIC_STREAMING(TFileSystemEntryType);

// ----------------
// Global routines
// ----------------
KFC_COMMON_API void EnlistFiles		(const KString& Mask, KStrings& Files,		bool bFullPaths = true, bool bClearFirst = true);
KFC_COMMON_API void EnlistFolders	(const KString& Mask, KStrings& Folders,	bool bFullPaths = true, bool bClearFirst = true);

KFC_COMMON_API void EnlistDrives(	KStrings&	Drives,
									bool		bEnlistFloppy	= true,
									bool		bFullPaths		= true);

KFC_COMMON_API bool FileExists	(const KString& FileName);
KFC_COMMON_API bool FolderExists(const KString& FolderName);

KFC_COMMON_API KString GetCurrentFolder();

KFC_COMMON_API void CreateFolder(const KString& FolderName);

KFC_COMMON_API bool CleanFolder(KString FolderName, bool bRecursive, bool bSafe);

KFC_COMMON_API bool DeleteFolder(const KString& FolderName, bool bRecursive, bool bSafe);

KFC_COMMON_API void CopyFolder(	const KString&	SrcFolderName,
								const KString&	DstFolderName,
								TFileFilter*	pFilter				= NULL,
								void*			pFilterParam		= NULL,
								bool			bExceptionOnFail	= true);

KFC_COMMON_API void CreateFoldersTree(KString CompletePath);

KFC_COMMON_API size_t GetFileLength(const KString& FileName);

KFC_COMMON_API bool CreateEmptyFile(const KString& FileName);

KFC_COMMON_API TStream& StreamReadFile	(TStream& Stream, const KString& FileName, size_t szPortionSize);
KFC_COMMON_API TStream& StreamWriteFile	(TStream& Stream, const KString& FileName, size_t szPortionSize);

#endif // file_h
