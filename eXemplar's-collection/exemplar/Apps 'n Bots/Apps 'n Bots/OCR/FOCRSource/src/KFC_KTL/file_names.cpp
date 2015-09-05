#include "kfc_ktl_pch.h"
#include "file_names.h"

// ----------------
// Global routines
// ----------------
bool IsSlash(TCHAR a)
{
	return	a==TEXT('\\') ||
			a==TEXT('/');
}

KString SlashedFolderName(const KString& FolderName)
{
	size_t szLength = FolderName.GetLength();
	return szLength && IsSlash(FolderName[szLength-1]) ? FolderName : (FolderName + TEXT('\\'));
}

KString UnslashedFolderName(const KString& FolderName)
{
	size_t szLength = FolderName.GetLength();
	return szLength && IsSlash(FolderName[szLength-1]) ? FolderName.Left(szLength-1) : FolderName;
}

bool IsAbsolutePath(const KString& s)
{
	if(s.IsEmpty())
		return false;

	size_t szLength = s.GetLength();

	if(szLength>=2 && IsSlash(s[0u]) && IsSlash(s[1u]))
		return true;

	if(szLength>=3 && _istalpha(s[0u]) && s[1u]==TEXT(':') && IsSlash(s[2u]))
		return true;

	return false;
}

bool IsNetworkPath(const KString& s)
{
	return s.GetLength()>=2 && s[1u]==TEXT('\\');
}

bool IsLocalDrivePath(const KString& s)
{
	return s.GetLength()>=3 && s[1u]==TEXT(':') && s[2u]==TEXT('\\');
}

KString GetFilePath(const KString& name)
{
	size_t i;
	for(i=name.GetLength()-1 ; i!=UINT_MAX && !IsSlash(name[i]) && name[i]!=TEXT(':') ; i--);

	return i==UINT_MAX ? KString(TEXT("")) : name.Left(i+1);
}

KString GetFileName(const KString& name)
{
	size_t szLength = name.GetLength();

	size_t i;
	for(i=szLength-1 ; i!=UINT_MAX && !IsSlash(name[i]) ; i--);

	return i==UINT_MAX ? name : name.Right(szLength-i-1);
}

KString GetFileNameName(const KString& name)
{
	KString str = GetFileName(name);

	size_t i;
	for(i=str.GetLength()-1 ; i!=UINT_MAX && str[i]!=TEXT('.') ; i--);

	return i==UINT_MAX ? str : str.Left(i);
}

KString GetFileExtension(const KString& name)
{
	KString str = GetFileName(name);

	size_t szLength = str.GetLength();

	size_t i;
	for(i=szLength-1 ; i!=UINT_MAX && str[i]!=TEXT('.') ; i--);

	return i==UINT_MAX ? KString(TEXT("")) : str.Right(szLength - i - 1);
}

KString GetLastFolderName(const KString& name)
{	
	return GetFileName(UnslashedFolderName(name));
}

KString GetRelativePath(const KString& src,const KString& dst)
{
	size_t i;

	if(!src[0u] || src[0u]!=dst[0u]) // empty source or different drives
		return dst;

	size_t lsp = 2; // last slash pos

	for(i=2 ; src[i] && dst[i] && (TCHAR)CharUpper((PTSTR)src[i])==(TCHAR)CharUpper((PTSTR)dst[i]) ; i++)
		if(IsSlash(src[i]))
			lsp = i;

	// Answer
	KString ans;

	// Way back
	for(i = lsp+1 ; src[i] ; i++)
		if(IsSlash(src[i]))
			ans += "..\\";

	// Way forth
	ans += dst.Mid(lsp + 1);

	return ans;
}

KString Get83FileName(const KString& FileName)
{
	return GetFileNameName(FileName).Left(8) + TEXT(".") + GetFileExtension(FileName).Left(3);
}

bool IsValidFileName(const KString& s)
{
	size_t szLength = s.GetLength();
	if(szLength == 0)
		return false;

	for(size_t i=0 ; i<szLength ; i++)
	{
		switch(s[i])
		{
		case TEXT('\\'):
		case TEXT('/'):
		case TEXT(':'):
		case TEXT('*'):
		case TEXT('?'):
		case TEXT('\"'):
		case TEXT('<'):
		case TEXT('>'):
		case TEXT('|'):
			return false;
		}
	}

	return true;
}

KString& FixSlashes(KString& s, TCHAR cSlash)
{
	size_t i;

	DEBUG_VERIFY(IsSlash(cSlash));

	for(i = 0 ; i < s.GetLength() ; i++)
	{
		if(IsSlash(s[i]))
			s.SetChar(i, cSlash);
	}

	return s;
}

void CreateFoldersSequence(	KString		Path,
							KStrings&	RFolders,
							bool		bClearFirst)
{
	if(bClearFirst)
		RFolders.Clear();

	for(;;)
	{
		Path = SlashedFolderName(Path);

		if(Path.GetLength() == 1 && IsSlash(Path[0]))
			break;

		*RFolders.AddFirst() = Path;
		
		size_t i;
		for(i = Path.GetLength() - 2 ; i != UINT_MAX ; i--)
		{
			if(IsSlash(Path[i]))
				break;
		}

		if(i == UINT_MAX)
			break;

		Path = Path.Left(i + 1);
	}
}

bool IsFolder(const KString& Name)
{
	return !Name.IsEmpty() && IsSlash(Name[Name.GetLength() - 1]);
}