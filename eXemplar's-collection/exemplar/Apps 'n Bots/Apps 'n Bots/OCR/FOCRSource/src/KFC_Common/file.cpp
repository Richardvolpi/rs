#include "kfc_common_pch.h"
#include "file.h"

#include <KFC_KTL\varray.h>
#include <KFC_KTL\file_names.h>
#include "common_consts.h"

// --------------
// File position
// --------------
TFilePos::TFilePos(const KString& SFileName)
{
	m_FileName		= SFileName;
	m_szOffset		= 0;
	m_szLength		= GetFileLength(m_FileName);
	m_bPlainFile	= true;
}

TFilePos::TFilePos(	const KString&	SFileName,
					size_t			szSOffset,
					size_t			szSLength)
{
	m_FileName		= SFileName;
	m_szOffset		= szSOffset;
	m_szLength		= szSLength;
	m_bPlainFile	= false;
}

// -----
// File
// -----
TFile::TFile()
{
	m_bAllocated = false;
}

TFile::TFile(const KString& FileName)
{
	m_bAllocated = false;

	Allocate(TFilePos(FileName));
}

TFile::TFile(const KString& FileName, flags_t flSOpenFlags)
{
	m_bAllocated = false;

	Allocate(TFilePos(FileName)), Open(flSOpenFlags);
}

TFile::TFile(const TFilePos& SFilePos)
{
	m_bAllocated = false;

	Allocate(SFilePos);
}

TFile::TFile(const TFilePos& SFilePos, flags_t flSOpenFlags)
{
	m_bAllocated = false;

	Allocate(SFilePos), Open(flSOpenFlags);
}

void TFile::Release()
{
	try { InternalClose(); } catch(... ) {}

	if(!IsEmpty() && m_bRemoveOnRelease)
	{
		try { InternalRemove(); } catch(...) {}
	}

	m_bAllocated = false;
}

void TFile::Allocate(const TFilePos &SFilePos)
{
	Release();

	try
	{
		DEBUG_VERIFY(!SFilePos.m_FileName.IsEmpty());

		m_FilePos = SFilePos;

		m_hFile = NULL;
			
		m_bRemoveOnClose	= false;
		m_bRemoveOnRelease	= false;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void TFile::Open(flags_t flSOpenFlags)
{
	DEBUG_VERIFY_ALLOCATION;

	Close();

/*	// Testing for access mode
	if(!(flSOpenFlags & FOF_READ) && !(flSOpenFlags & FOF_WRITE))
		INITIATE_FAILURE;*/
	
	// Testing for new file without creation
	if(!(flSOpenFlags & FOF_CREATE) && (flSOpenFlags & FOF_NEWFILE))
		INITIATE_FAILURE;
	
	// Testing for creation/resizing without writing
	if(	((flSOpenFlags & FOF_CREATE) || (flSOpenFlags & FOF_RESIZE)) &&
		!(flSOpenFlags & FOF_WRITE))
	{
		INITIATE_FAILURE;
	}
	
	// Testing for creation/resizing/text with non-plain file
	if(	!m_FilePos.m_bPlainFile &&
		((flSOpenFlags & FOF_CREATE) || (flSOpenFlags & FOF_RESIZE) || (flSOpenFlags & FOF_TEXT)))
	{
		INITIATE_FAILURE;
	}

	m_flOpenFlags = flSOpenFlags;

	// Processing creation flags	
	if(FileExists(m_FilePos.m_FileName))
	{
		if(m_flOpenFlags & FOF_NEWFILE)
			InternalCreateEmpty();
	}
	else
	{
		if(m_flOpenFlags & FOF_CREATE)
			InternalCreateEmpty();
		else
			INITIATE_DEFINED_FAILURE((KString)TEXT("File not found: \"") + m_FilePos.m_FileName + TEXT("\"."));
	}
	
	// Opening the file
	if(m_flOpenFlags & FOF_TEXT)
	{
		LPCTSTR pAccess;

		if(m_flOpenFlags & FOF_READ)
		{
			if(m_flOpenFlags & FOF_WRITE)
				pAccess = TEXT("r+");
			else
				pAccess = TEXT("r");
		}
		else
		{
			if(m_flOpenFlags & FOF_WRITE)
				pAccess = TEXT("r+");
			else
				INITIATE_FAILURE;
		}

		m_pFile = _tfopen(m_FilePos.m_FileName, pAccess);
		if(m_pFile == NULL)
			INITIATE_DEFINED_FAILURE((KString)TEXT("Error opening file \"") + m_FilePos.m_FileName + TEXT("\"."));
	}
	else
	{
		// Setting CreateFile() flags
		flags_t flAccess	= 0;
		flags_t flSharing	= 0;

		if(m_flOpenFlags & FOF_READ)
		{
			flAccess |= GENERIC_READ;

			if(m_flOpenFlags & FOF_WRITE)
				flAccess |= GENERIC_WRITE;
			else
				flSharing |= FILE_SHARE_READ;
		}
		else
		{
			if(m_flOpenFlags & FOF_WRITE)
				flAccess |= GENERIC_WRITE;
			else
				INITIATE_FAILURE;
		}
		
		// Opening/creating a file
		m_hFile = CreateFile(	m_FilePos.m_FileName,
								flAccess,
								flSharing,
								NULL,
								OPEN_EXISTING,
								FILE_ATTRIBUTE_NORMAL,
								NULL);

		if(m_hFile == NULL)
			INITIATE_DEFINED_FAILURE((KString)TEXT("Error opening file \"") + m_FilePos.m_FileName + TEXT("\"."));
	}

	if(!m_FilePos.m_bPlainFile)
		SetFilePointer(m_hFile, m_FilePos.m_szOffset, NULL, FILE_BEGIN); // ... (no error check-up)
}

void TFile::InternalClose()
{
	if(IsEmpty())
		return;
	
	if(!IsOpen())
		return;

	try
	{
		if(m_flOpenFlags & FOF_TEXT)
		{
			fclose(m_pFile), m_pFile = NULL;
		}
		else
		{
			CloseHandle(m_hFile), m_hFile = NULL;
		}

		if(m_bRemoveOnClose)
			InternalRemove();
	}

	catch(...)
	{
	}
}

void TFile::Close()
{
	DEBUG_VERIFY_ALLOCATION;

	InternalClose();
}

void TFile::SetLength(size_t szNewLength, bool bRetainOldOffset)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_RESIZE))
		INITIATE_FAILURE;

	if(bRetainOldOffset)
	{
		size_t szCurOffset = InternalTell();

		SetFilePointer(m_hFile, szNewLength, NULL, FILE_BEGIN); // ... (no error check-up)
		if(!SetEndOfFile(m_hFile))
			throw 1;

		InternalSeek(szCurOffset);
	}
	else
	{
		if(!(m_flOpenFlags & FOF_SEEK))
			throw 1;

		SetFilePointer(m_hFile, szNewLength, NULL, FILE_BEGIN); // ... (no error check-up)
		if(!SetEndOfFile(m_hFile))
			throw 1;
	}

	m_FilePos.m_szLength = szNewLength;
}

TFile& TFile::Read(void* pData, size_t szSize)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_READ) || (m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	if(Tell() + szSize > m_FilePos.m_szLength)
		INITIATE_FAILURE;

	DWORD dwRealSize;
	if(!ReadFile(m_hFile, pData, szSize, &dwRealSize, NULL) || dwRealSize != szSize)
		INITIATE_FAILURE;

	return *this;
}

TFile& TFile::Write(const void* pData, size_t szSize)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_WRITE) || (m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	size_t szCurrentOffset = Tell();
	if(	(szCurrentOffset + szSize > m_FilePos.m_szLength) &&
		!(m_flOpenFlags & FOF_RESIZE))
	{
		INITIATE_FAILURE;
	}

	DWORD dwRealSize;
	if(!WriteFile(m_hFile, pData, szSize, &dwRealSize, NULL) || dwRealSize != szSize)
		INITIATE_FAILURE;

	size_t szLastOffset = szCurrentOffset + szSize;
	if(szLastOffset > m_FilePos.m_szLength)
		m_FilePos.m_szLength = szLastOffset;

	return *this;
}

TFile& TFile::ReadString(KString& RString, TFileReadStringMode Mode)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_READ) || !(m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	TCHAR ts[1024];

	ts[0] = 0, _fgetts(ts, 1000, m_pFile);

	if(Mode == FRSM_ORIGINAL)
	{
	}
	else if(Mode == FRSM_DELCRLF)
	{
		size_t l = _tcslen(ts);
		if(l && ts[l-1] == TEXT('\n'))
			ts[--l] = 0;
		if(l && ts[l-1] == TEXT('\r'))
			ts[--l] = 0;
	}

	RString = ts;

	return *this;
}

TFile& TFile::WriteString(LPCTSTR pString, TFileWriteStringMode Mode)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_WRITE) || !(m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	if(Mode == FWSM_ORIGINAL)
	{
		_ftprintf(m_pFile, TEXT("%s"), pString);
	}
	else if(Mode == FWSM_ADDCRLF)
	{
		_ftprintf(m_pFile, TEXT("%s\n"), pString);
	}

	return *this;
}

TFile& TFile::ReadStrings(KStrings& RStrings, bool bClearFirst)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_READ) || !(m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	if(bClearFirst)
		RStrings.Clear();
	
	while(!IsEndOfFile())
		ReadString(*RStrings.AddLast());

	return *this;
}

TFile& TFile::WriteStrings(const KStrings& Strings)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_WRITE) || !(m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	for(KStrings::TConstIterator Iter = Strings.GetFirst() ; Iter.IsValid() ; ++Iter)
		WriteString(*Iter);

	return *this;
}

KString TFile::ReadString(TFileReadStringMode Mode)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_READ) || !(m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	KString String;
	ReadString(String, Mode);

	return String;
}

void TFile::IndentString(size_t szAmt, TCHAR cChar)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_WRITE) || !(m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	for( ; szAmt ; szAmt--)
		_fputtc(cChar, m_pFile);
}

void TFile::WriteEOL()
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_WRITE) || !(m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	_ftprintf(m_pFile, TEXT("\n"));
}

void TFile::InternalSeek(int iOffset, TFileSeekMode Mode)
{
	DEBUG_VERIFY(IsOpen());

	if(m_flOpenFlags & FOF_TEXT)
	{
		if(Mode == FSM_BEGIN)
		{
			if(fseek(m_pFile, iOffset, SEEK_SET))
				throw 1;
		}
		else if(Mode == FSM_CURRENT)
		{
			if(fseek(m_pFile, iOffset, SEEK_CUR))
				throw 1;
		}
		else if(Mode == FSM_END)
		{
			if(fseek(m_pFile, iOffset, SEEK_END))
				throw 1;
		}
		else
		{
			INITIATE_FAILURE;
		}
	}
	else
	{
		if(Mode == FSM_BEGIN)
		{
			if(iOffset < 0 || (size_t)iOffset > m_FilePos.m_szLength)
				INITIATE_FAILURE;

			SetFilePointer(m_hFile, m_FilePos.m_szOffset + iOffset, NULL, FILE_BEGIN); // ... (no error check-up)
		}
		else if(Mode == FSM_CURRENT)
		{
			int iDstOffset = (int)Tell() + iOffset;
			if(iDstOffset < 0 || (size_t)iOffset > m_FilePos.m_szLength)
				INITIATE_FAILURE;

			SetFilePointer(m_hFile, m_FilePos.m_szOffset + iDstOffset, NULL, FILE_BEGIN); // ... (no error check-up)
		}
		else if(Mode == FSM_END)
		{
			int iDstOffset = (int)Tell() + iOffset;
			if(iDstOffset < 0 || (size_t)iOffset > m_FilePos.m_szLength)
				INITIATE_FAILURE;

			SetFilePointer(m_hFile, m_FilePos.m_szOffset + iDstOffset, NULL, FILE_BEGIN); // ... (no error check-up)
		}
		else
		{
			INITIATE_FAILURE;
		}
	}
}

void TFile::Seek(int iOffset, TFileSeekMode Mode)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_SEEK))
		INITIATE_FAILURE;

	InternalSeek(iOffset, Mode);
}

size_t TFile::InternalTell() const
{
	DEBUG_VERIFY(IsOpen());

	if(m_flOpenFlags & FOF_TEXT)
	{
		return ftell(m_pFile) - m_FilePos.m_szOffset;
	}
	else
	{
		return SetFilePointer(m_hFile, 0, NULL, FILE_CURRENT) - m_FilePos.m_szOffset;
	}
}

size_t TFile::Tell() const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	return InternalTell();
}

bool TFile::IsEndOfFile() const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	return InternalTell() == m_FilePos.m_szLength;
}

void TFile::InternalCreateEmpty()
{
	if(IsOpen())
		INITIATE_FAILURE;

	if(!m_FilePos.m_bPlainFile)
		INITIATE_FAILURE;

	if(!CreateEmptyFile(m_FilePos.m_FileName))
		INITIATE_FAILURE;
}

void TFile::CreateEmpty()
{
	DEBUG_VERIFY_ALLOCATION;

	InternalCreateEmpty();
}

bool TFile::InternalRemove()
{
	if(IsOpen())
		return false;

	if(!m_FilePos.m_bPlainFile)
		return false;

	return DeleteFile(m_FilePos.m_FileName) ? true : false;
}

void TFile::Rename(const KString& FileName)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(!IsOpen());

	DEBUG_VERIFY(m_FilePos.m_bPlainFile);

	if(_trename(m_FilePos.m_FileName, FileName))
		INITIATE_FAILURE;

	m_FilePos.m_FileName = FileName;
}

void TFile::Remove()
{
	DEBUG_VERIFY_ALLOCATION;

	if(!InternalRemove())
	{
		INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error deleteing file \"")	+
											m_FilePos.m_FileName					+
											TEXT("\""),
										GetLastError());
	}
}

bool TFile::DoesExists() const
{
	DEBUG_VERIFY_ALLOCATION;

	if(IsOpen())
		return true;
	
	return FileExists(m_FilePos.m_FileName);
}

void TFile::Copy(const TFilePos& SrcFilePos, const TFilePos& DstFilePos)
{
	TFile SrcFile(SrcFilePos);
	TFile DstFile(DstFilePos);

	if(SrcFilePos.m_bPlainFile)
		SrcFile.Open(FOF_BINARYREAD);
	else
		SrcFile.Open(FOF_READ);

	if(DstFilePos.m_bPlainFile)
		DstFile.Open(FOF_BINARYWRITE);
	else
	{
		if(SrcFilePos.m_szLength > DstFilePos.m_szLength)
			INITIATE_FAILURE;

		DstFile.Open(FOF_WRITE);
	}

	const size_t szBufferSize = g_CommonConsts.m_szFileCopyBufferSize;

	TValueArray<BYTE, true> Buf;
	Buf.Allocate(szBufferSize), Buf.Add(szBufferSize);
	
	size_t szNRemaining = SrcFilePos.m_szLength;
	while(szNRemaining)
	{
		size_t szNTransfer = Min(szNRemaining, szBufferSize);
		SrcFile.Read	(Buf.GetDataPtr(), szNTransfer);
		DstFile.Write	(Buf.GetDataPtr(), szNTransfer);

		szNRemaining -= szNTransfer;
	}
}

void TFile::GetProcessedFilePos(TFilePos& RFilePos) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	RFilePos.m_FileName		= m_FilePos.m_FileName;
	RFilePos.m_szOffset		= m_FilePos.m_szOffset;
	RFilePos.m_szLength		= Tell();
	RFilePos.m_bPlainFile	= false;
}

void TFile::GetRemainingFilePos(TFilePos& RFilePos) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	size_t szCurOffset = Tell();

	RFilePos.m_FileName		= m_FilePos.m_FileName;
	RFilePos.m_szOffset		= m_FilePos.m_szOffset + szCurOffset;
	RFilePos.m_szLength		= m_FilePos.m_szLength - szCurOffset;
	RFilePos.m_bPlainFile	= false;
}

void TFile::GetTimes(	FILETIME* pCreationTime,
						FILETIME* pLastAccessTime,
						FILETIME* pLastWriteTime) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_READ))
		INITIATE_FAILURE;

	if(!GetFileTime(m_hFile, pCreationTime, pLastAccessTime, pLastWriteTime))
		INITIATE_FAILURE;
}

void TFile::SetTimes(	const FILETIME* pCreationTime,
						const FILETIME* pLastAccessTime,
						const FILETIME* pLastWriteTime) 
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_WRITE))
		INITIATE_FAILURE;

	if(!SetFileTime(m_hFile, pCreationTime, pLastAccessTime, pLastWriteTime))
		INITIATE_FAILURE;
}

HANDLE TFile::GetHandle()
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(m_flOpenFlags & FOF_TEXT)
		INITIATE_FAILURE;

	return m_hFile;
}

FILE* TFile::GetStream()
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsOpen());

	if(!(m_flOpenFlags & FOF_TEXT))
		INITIATE_FAILURE;

	return m_pFile;
}

// ------------
// File opener
// ------------
TFileOpener::TFileOpener(TFile& SFile, flags_t flOpenFlags) : m_File(SFile)
{
	m_File.Open(flOpenFlags);
}

TFileOpener::~TFileOpener()
{
	m_File.Close();
}

// ----------------
// Global routines
// ----------------
void EnlistFiles(const KString& Mask, KStrings& Files, bool bFullPaths, bool bClearFirst)
{
	if(bClearFirst)
		Files.Clear();

	KString FolderName = GetFilePath(Mask);

	_tfinddata_t FileInfo;
	
	int iHandle = _tfindfirst(Mask, &FileInfo);

	if(iHandle>=0)
	{
		for(;;)
		{
			if(!(FileInfo.attrib & _A_SUBDIR))
				*Files.AddLast() = bFullPaths ? FolderName + FileInfo.name : FileInfo.name;

			// To the next file
			if(_tfindnext(iHandle, &FileInfo)==-1)
				break;
		}
		
		_findclose(iHandle);
	}
}

void EnlistFolders(const KString& Mask, KStrings& Folders, bool bFullPaths, bool bClearFirst)
{
	if(bClearFirst)
		Folders.Clear();

	KString FolderName = GetFilePath(Mask);

	_tfinddata_t FileInfo;
	
	int iHandle = _tfindfirst(Mask, &FileInfo);
	if(iHandle>=0)
	{
		for(;;)
		{
			if(	(FileInfo.attrib & _A_SUBDIR)		&&
				_tcscmp(FileInfo.name, TEXT("."))	&&
				_tcscmp(FileInfo.name, TEXT("..")))
			{
				*Folders.AddLast() = (bFullPaths ? FolderName + FileInfo.name : FileInfo.name) + TEXT("\\");
			}
			
			// To the next file
			if(_tfindnext(iHandle, &FileInfo)==-1)
				break;
		}
		
		_findclose(iHandle);
	}
}

void EnlistDrives(	KStrings&	Drives,
					bool		bEnlistFloppy,
					bool		bFullPaths)
{
	Drives.Clear();

	DWORD dwDrives = GetLogicalDrives();

	for(size_t i = 0 ; i < 32 ; i++, dwDrives >>= 1)
	{
		if((dwDrives & 1) && (i >= 2 || bEnlistFloppy))
		{
			Drives.AddLast()->Format(	bFullPaths ?
											TEXT("%c:\\") :
											TEXT("%c:"),
										(TCHAR)(TEXT('A') + i));
		}
	}
}

bool FileExists(const KString& FileName)
{
	if(FileName.IsEmpty())
		return false;

	FILE *file = _tfopen(FileName,TEXT("rb"));

	if(file)
	{
		fclose(file);
		return true;
	}

	return false;
}

bool FolderExists(const KString& FolderName)
{
	if(FolderName.IsEmpty())
		return false;

	TCHAR CurDir[1024];
	_tgetcwd(CurDir, sizeof(CurDir) - 1);

	const bool bResult = _tchdir(UnslashedFolderName(FolderName)) ? false : true;

	_tchdir(CurDir);

	return bResult;
}

KString GetCurrentFolder()
{
	TCHAR Buffer[1024];
	_tgetcwd(Buffer, sizeof(Buffer));

	return SlashedFolderName(Buffer);
}

size_t GetFileLength(const KString& FileName)
{
	size_t ret;

	FILE* file = _tfopen(FileName, TEXT("rb"));
	if(file)
	{
		fseek(file, 0, SEEK_END);
		ret = ftell(file);
		fclose(file);
	}
	else
	{
		ret = 0;
	}

	return ret;
}

bool CreateEmptyFile(const KString& FileName)
{
	FILE* file = _tfopen(FileName, TEXT("wb"));
	if(file==NULL)
		return false;

	fclose(file);

	return true;
}

void CreateFolder(const KString& FolderName)
{
	if(_tmkdir(UnslashedFolderName(FolderName)) != 0 && errno != EEXIST)
	{
		INITIATE_DEFINED_FAILURE(	(KString)TEXT("Error creating folder \"") +
										FolderName +
										TEXT("\"."));
	}
}

bool CleanFolder(KString FolderName, bool bRecursive, bool bSafe)
{
	FolderName = SlashedFolderName(FolderName);

	bool bSuccess = true;

	// Files
	TEST_BLOCK_BEGIN
	{
		KStrings Files;
		EnlistFiles(FolderName + TEXT("*.*"), Files, false);

		for(KStrings::TConstIterator Iter = Files.GetFirst() ; Iter.IsValid() ; ++Iter)
		{
			TEST_BLOCK_BEGIN
			{
				TFile(FolderName + *Iter).Remove();
			}
			TEST_BLOCK_EXCEPTION_HANDLER
			{
				if(!bSafe)
					throw 1;

				EMPTY_DEBUG_FAILURE_MESSAGE;

				bSuccess = false;
			}
			TEST_BLOCK_END
		}
	}
	TEST_BLOCK_EXCEPTION_HANDLER
	{
		if(!bSafe)
			throw 1;

		EMPTY_DEBUG_FAILURE_MESSAGE;

		bSuccess = false;
	}
	TEST_BLOCK_END

	// Folders
	TEST_BLOCK_BEGIN
	{
		KStrings Folders;
		EnlistFolders(FolderName + TEXT("*.*"), Folders, false);

		if(!Folders.IsEmpty())
		{
			if(!bRecursive)
				return false;

			for(KStrings::TConstIterator Iter = Folders.GetFirst() ; Iter.IsValid() ; ++Iter)
			{
				if(!DeleteFolder(FolderName + *Iter, bRecursive, bSafe))
					bSuccess = false;
			}
		}
	}
	TEST_BLOCK_EXCEPTION_HANDLER
	{
		if(!bSafe)
			throw 1;

		EMPTY_DEBUG_FAILURE_MESSAGE;

		bSuccess = false;
	}
	TEST_BLOCK_END

	return bSuccess;
}

bool DeleteFolder(const KString& FolderName, bool bRecursive, bool bSafe)
{
	if(!CleanFolder(FolderName, bRecursive, bSafe))
		return false;

	if(!GetCurrentFolder().CollateNoCase(SlashedFolderName(FolderName)))
		_tchdir(TEXT(".."));

	if(_trmdir(UnslashedFolderName(FolderName)))
	{
		if(!bSafe)
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error deleteing folder \"") +
												FolderName +
												TEXT("\""),
											errno);
		}

		return false;
	}

	return true;
}

void CopyFolder(const KString&	SrcFolderName,
				const KString&	DstFolderName,
				TFileFilter*	pFilter,
				void*			pFilterParam,
				bool			bExceptionOnFail)
{
	// Getting complete folder names
	const KString SrcName = SlashedFolderName(SrcFolderName);
	const KString DstName = SlashedFolderName(DstFolderName);
	
	// Creating destination folder
	TEST_BLOCK_BEGIN
	{
		CreateFolder(DstName);
	}
	TEST_BLOCK_EXCEPTION_HANDLER
	{
		if(bExceptionOnFail)
			throw 1;

		return;
	}
	TEST_BLOCK_END

	// Copying
	KStrings::TConstIterator Iter;
	
	// Copying folders
	KStrings Folders;
	EnlistFolders(SrcName + TEXT("*.*"), Folders, false);	

	for(Iter = Folders.GetFirst() ; Iter.IsValid() ; ++Iter)
	{
		if(pFilter == NULL || pFilter(SrcName + *Iter, false, pFilterParam))
		{
			TEST_BLOCK_BEGIN
			{
				CopyFolder(	SrcName + *Iter,
							DstName + *Iter,
							pFilter,
							pFilterParam,
							bExceptionOnFail);
			}
			TEST_BLOCK_EXCEPTION_HANDLER
			{
				if(bExceptionOnFail)
					throw 1;
			}
			TEST_BLOCK_END
		}
	}

	Folders.Clear();

	// Copying files
	KStrings Files;
	EnlistFiles(SrcName + TEXT("*.*"), Files, false);
	
	for(Iter = Files.GetFirst() ; Iter.IsValid() ; ++Iter)
	{
		if(pFilter == NULL || pFilter(SrcName + *Iter, true, pFilterParam))
		{
			TEST_BLOCK_BEGIN
			{
				TFile::Copy(SrcName + *Iter, DstName + *Iter);
			}
			TEST_BLOCK_EXCEPTION_HANDLER
			{
				if(bExceptionOnFail)
					throw 1;
			}
			TEST_BLOCK_END
		}
	}

	Files.Clear();
}

void CreateFoldersTree(KString CompletePath)
{
	DEBUG_VERIFY(IsAbsolutePath(SlashedFolderName(CompletePath)));

	KStrings Folders;

	CompletePath = UnslashedFolderName(CompletePath);

	while(CompletePath.GetLength() > 2)
	{
		*Folders.AddLast() = CompletePath;

		CompletePath = UnslashedFolderName(GetFilePath(CompletePath));
	}

	// For "\\pc\share\xxx" deleting '\\pc' and '\\pc\share'
	if(	!Folders.IsEmpty() &&
		Folders.GetLast()->GetLength() >= 2 && Folders.GetLast()->Left(2) == TEXT("\\\\"))
	{
		Folders.Del(Folders.GetLast());

		if(!Folders.IsEmpty())
			Folders.Del(Folders.GetLast());
	}

	for(KStrings::TConstIterator Iter = Folders.GetLast() ; Iter.IsValid() ; --Iter)
		CreateFolder(*Iter);
}

TStream& StreamReadFile(TStream& Stream, const KString& FileName, size_t szPortionSize)
{
	DEBUG_VERIFY(szPortionSize > 0);

	TFile File(FileName, FOF_WRITE | FOF_CREATE | FOF_NEWFILE | FOF_RESIZE);

	size_t szLength;
	Stream >> szLength;

	TValueArray<BYTE, true> Buf;

	Buf.Allocate(szPortionSize);
	Buf.Add		(szPortionSize);

	while(szLength > 0)
	{
		size_t szToTransfer = szPortionSize;
		if(szToTransfer > szLength)
			szToTransfer = szLength;

		Stream.StreamRead(Buf.GetDataPtr(), szToTransfer);

		File.Write(Buf.GetDataPtr(), szToTransfer);

		szLength -= szToTransfer;
	}

	return Stream;
}

TStream& StreamWriteFile(TStream& Stream, const KString& FileName, size_t szPortionSize)
{
	TFile File(FileName, FOF_READ);

	Stream << File.GetFilePos().m_szLength;

	TValueArray<BYTE, true> Buf;

	Buf.Allocate(szPortionSize);
	Buf.Add		(szPortionSize);

	for(size_t szLength = File.GetLength() ; szLength > 0 ; )
	{
		size_t szToTransfer = szPortionSize;
		if(szToTransfer > szLength)
			szToTransfer = szLength;

		File.Read(Buf.GetDataPtr(), szToTransfer);

		Stream.StreamWrite(Buf.GetDataPtr(), szToTransfer);

		szLength -= szToTransfer;
	}

	return Stream;
}
