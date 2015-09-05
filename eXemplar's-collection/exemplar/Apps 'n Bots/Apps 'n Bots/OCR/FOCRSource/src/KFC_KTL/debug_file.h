#ifndef debug_file_h
#define debug_file_h

#include "kfc_ktl_api.h"

// -------------------------
// Debug file control chars
// -------------------------
enum TDebugFileControlChar
{
	DFCC_CLEAR		= 1,
	DFCC_EOL		= 2,
	DFCC_FORCE_UINT	= UINT_MAX,
};

// -----------
// Debug file
// -----------
class KFC_KTL_API TDebugFile
{
private:
	bool m_bAllocated;

	KString m_FileName;

	CRITICAL_SECTION m_AccessCriticalSection;


	void Clear();

public:
	TDebugFile();

	~TDebugFile();

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(const KString& SFileName, bool bClear = true);

	void UnLock	();
	void Lock	();

	TDebugFile& operator << (LPCTSTR pString);

	TDebugFile& operator << (TCHAR cChar)
		{ return *this << KString(cChar); }

	TDebugFile& operator << (LPTSTR pString)
		{ return *this << (LPCTSTR)pString; }

	TDebugFile& operator << (const KString& String)
		{ return *this << (LPCTSTR)String; }

	TDebugFile& operator << (__int64	iValue)		{ return *this << KString(iValue);	}
	TDebugFile& operator << (int		iValue)		{ return *this << KString(iValue);	}
	TDebugFile& operator << (QWORD		qwValue)	{ return *this << KString(qwValue);	}
	TDebugFile& operator << (UINT		uiValue)	{ return *this << KString(uiValue); }

	TDebugFile& operator << (float			fValue)		{ return *this << KString(fValue);		}
	TDebugFile& operator << (double			dValue)		{ return *this << KString(dValue);		}
	TDebugFile& operator << (bool			bValue)		{ return *this << KString(bValue);		}
	TDebugFile& operator << (const void*	pPtr)		{ return *this << KString(pPtr);		}
	TDebugFile& operator << (TAlignment		Alignment)	{ return *this << KString(Alignment);	}

	TDebugFile& operator << (TDebugFileControlChar ControlChar);

	// ---------------- TRIVIALS ----------------
	const KString& GetFileName() const { return m_FileName; }
};

extern KFC_KTL_API TDebugFile g_DebugFile;

// ------------------
// Debug file locker
// ------------------
class KFC_KTL_API TDebugFileLocker
{
public:
	TDebugFileLocker() { g_DebugFile.Lock(); }

	~TDebugFileLocker() { g_DebugFile.UnLock(); }
};

// --------------------
// Basic bitypes debug
// --------------------
template <class t>
inline TDebugFile& operator << (TDebugFile& DebugFile, const TPoint<t>& Point)
{
	return DebugFile << (KString)Point;
}

template <class t>
inline TDebugFile& operator << (TDebugFile& DebugFile, const TRect<t>& Rect)
{
	return DebugFile << (KString)Rect;
}

template <class t>
inline TDebugFile& operator << (TDebugFile& DebugFile, const TSize<t>& Size)
{
	return DebugFile << (KString)Size;
}

template <class t>
inline TDebugFile& operator << (TDebugFile& DebugFile, const TSegment<t>& Segment)
{
	return DebugFile << (KString)Segment;
}

#endif // debug_file_h
