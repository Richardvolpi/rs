#include "kfc_common_pch.h"
#include "structured_info.h"

#include "common_consts.h"

// ----------------
// Structured info
// ----------------

// Node
TStructuredInfo::TNode::TParameters::TConstIterator
	TStructuredInfo::TNode::FindParameter(	const KString&				Name,
											TParameters::TConstIterator	After) const
{
	for(TParameters::TConstIterator Iter =	After.IsValid() ?
												After.GetNext() :
												m_Parameters.GetFirst() ;
		Iter.IsValid() ;
		++Iter)
	{
		if(Iter->m_Name == Name)
			return Iter;
	}

	return TParameters::TConstIterator();
}

TStructuredInfo::TNode::TParameters::TConstIterator
	TStructuredInfo::TNode::GetParameter(	const KString&				Name,
											TParameters::TConstIterator	After) const
{
	const TParameters::TConstIterator Iter = FindParameter(Name, After);

	if(!Iter.IsValid())
		INITIATE_DEFINED_FAILURE((KString)TEXT("Parameter \"") + Name + TEXT("\" not found."));

	return Iter;
}

const KString& TStructuredInfo::TNode::GetParameterValue(const KString&					Name,
														 TParameters::TConstIterator	After) const
{
	return GetParameter(Name, After)->m_Value;
}

const KString TStructuredInfo::TNode::GetParameterValue(const KString&				Name,
														const KString&				DefaultValue,
														TParameters::TConstIterator	After) const
{
	const TParameters::TConstIterator PIter = FindParameter(Name, After);

	return PIter.IsValid() ? PIter->m_Value : DefaultValue;
}

bool TStructuredInfo::TNode::HasParameter(	const KString&				Name,
											TParameters::TConstIterator	After) const
{
	return FindParameter(Name, After).IsValid();
}

bool TStructuredInfo::TNode::HasTrueParameter(	const KString&				Name,
												TParameters::TConstIterator	After) const
{
	const TParameters::TConstIterator PIter = FindParameter(Name, After);

	bool bValue;

	return PIter.IsValid() && FromString(PIter->m_Value, bValue) && bValue;
}

TStructuredInfo::TNode::TParameters::TIterator
	TStructuredInfo::TNode::AddParameter(	const KString& Name,
											const KString& Value)
{
	const TParameters::TIterator PIter = m_Parameters.AddLast();

	PIter->Set(Name, Value);

	return PIter;
}

// Structured info
TStructuredInfo::TStructuredInfo()
{
	m_bAllocated = false;
}

TStructuredInfo::TStructuredInfo(const KString& FileName)
{
	m_bAllocated = false;

	Load(FileName);
}

void TStructuredInfo::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		m_Nodes.Clear();
	}
}

void TStructuredInfo::Allocate()
{
	Release();

	try
	{
		m_Nodes.AddRoot();

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TStructuredInfo::SkipNode(TFile& File)
{
	while(!File.IsEndOfFile())
	{
		// Reading the string
		KString String;
		File.ReadString(String);

		// Cutting the comment
		size_t szComPos = String.Find(TEXT("//"));
		if(szComPos != UINT_MAX)
			String = String.Left(szComPos);

		// Trimming the string
		String = String.Trim();

		if(String.IsEmpty())
			continue;

		if(String.GetLength() == 1)
		{
			if(String[0] == TEXT('{'))
				SkipNode(File);
			else if(String[0] == TEXT('}'))
				return;
		}
	}

	INITIATE_DEFINED_FAILURE(TEXT("Upexpected end of structured info file"));
}

void TStructuredInfo::LoadNode(	TNodes::TIterator	Iter,
								TFile&				File,
								size_t				szDepth)
{
	enum
	{
		STATE_START,
		STATE_INSIDE,
		STATE_END

	}State = szDepth == 0 ? STATE_INSIDE : STATE_START;

	while(!File.IsEndOfFile() && State != STATE_END)
	{
		// Reading the string
		KString String;
		File.ReadString(String);

		// Cutting the comment
		String = CutSingleStringComments(String);

		// Trimming the string
		String = String.Trim();

		if(String.IsEmpty())
			continue;

		if(State == STATE_START)
		{
			if(String[0] != TEXT('{') || String.GetLength() > 1)
				INITIATE_DEFINED_FAILURE(TEXT("'{' expected."));

			State = STATE_INSIDE;
		}
		else // SATE_INSIDE
		{
			// Checking for '}'
			if(String.GetLength() == 1 && String[0] == TEXT('}'))
			{
				State = STATE_END;
			}
			else if(String.GetLength() == 1 && String[0] == TEXT('{')) // unnamed node
			{
				SkipNode(File);
			}
			else
			{			
				size_t szNameLength;
				const KString Name = DecodeFromSingleString(String, TEXT('='), &szNameLength);

				if(szNameLength == String.GetLength()) // node
				{
					LoadNode(AddNode(Iter, Name), File, szDepth + 1);
				}
				else // parameter
				{
					Iter->AddParameter(Name, DecodeFromSingleString(String.Mid(szNameLength + 1)));
				}
			}
		}
	}

	if(szDepth > 0 && State != STATE_END)
		INITIATE_DEFINED_FAILURE(TEXT("Upexpected end of structured info file"));
}

void TStructuredInfo::Load(const KString& FileName)
{
	Release();

	try
	{
		Allocate();
		
		TFile File(FileName, FOF_READ | FOF_TEXT);
		
		LoadNode(m_Nodes.GetRoot(), File, 0);
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TStructuredInfo::SaveNode(	TNodes::TConstIterator	Iter,
								TFile&					File,
								size_t					szDepth) const
{
	KStrings::TConstIterator PNIter;
	KStrings::TConstIterator PVIter;

	TNode::TParameters::TConstIterator PIter;

	// Parameters
	KStrings ParameterNames;
	KStrings ParameterValues;

	size_t szMaxNameLength = 0;

	for(PIter = Iter->m_Parameters.GetFirst() ; PIter.IsValid() ; ++PIter)
	{
		*ParameterNames.	AddLast() = EncodeToSingleString(PIter->m_Name, TEXT('='));
		*ParameterValues.	AddLast() = EncodeToSingleString(PIter->m_Value);

		if(ParameterNames.GetLast()->GetLength() > szMaxNameLength)
			szMaxNameLength = ParameterNames.GetLast()->GetLength();
	}

	DEBUG_VERIFY(ParameterNames.GetN() == ParameterValues.GetN());

	bool bSameLength = true;
	for(PNIter = ParameterNames.GetFirst() ; PNIter.IsValid() ; ++PNIter)
	{
		if(PNIter->GetLength() != szMaxNameLength)
		{
			bSameLength = false;
			break;
		}
	}

	if(!bSameLength)
	{
		// Converting to tabs amount
		szMaxNameLength =	(szMaxNameLength + g_CommonConsts.m_szTabSize) /
								g_CommonConsts.m_szTabSize;
	}

	for(PNIter = ParameterNames.GetFirst(), PVIter = ParameterValues.GetFirst() ;
		PNIter.IsValid() && PVIter.IsValid() ;
		++PNIter, ++PVIter)
	{
		File.IndentString(szDepth);

		File.WriteString(*PNIter, FWSM_ORIGINAL);

		if(bSameLength)
			File.WriteString(TEXT(" "), FWSM_ORIGINAL);
		else
			File.IndentString(szMaxNameLength - PNIter->GetLength() / g_CommonConsts.m_szTabSize);

		File.WriteString(TEXT("= "), FWSM_ORIGINAL);

		File.WriteString(*PVIter);
	}

	// Separator
	if(!Iter->m_Parameters.IsEmpty() && !Iter.IsLeaf())
		File.WriteEOL();

	// Sub-nodes
	for(TNodes::TConstIterator Iter2 = Iter.GetFirstChild() ;
		Iter2.IsValid() ;
		Iter2.ToNextSibling())
	{
		File.IndentString(Iter.GetDepth());
		File.WriteString(EncodeToSingleString(Iter2->m_Name, TCHAR('=')));

		File.IndentString(Iter.GetDepth());
		File.WriteString(TEXT("{"));

		SaveNode(Iter2, File, szDepth + 1);

		File.IndentString(Iter.GetDepth());
		File.WriteString(TEXT("}"));

		// Separator
		if(Iter2 != Iter.GetLastChild())
			File.WriteEOL();
	}
}

void TStructuredInfo::Save(const KString& FileName) const
{
	DEBUG_VERIFY_ALLOCATION;

	TFile File(FileName, FOF_WRITE | FOF_CREATE | FOF_NEWFILE | FOF_TEXT);

	SaveNode(m_Nodes.GetRoot(), File, 0);
}

TStructuredInfo::TNodes::TIterator TStructuredInfo::GetRootNode()
{
	DEBUG_VERIFY_ALLOCATION;

	return m_Nodes.GetRoot();
}

TStructuredInfo::TNodes::TConstIterator TStructuredInfo::GetRootNode() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_Nodes.GetRoot();
}

TStructuredInfo::TNodes::TConstIterator
	TStructuredInfo::FindNode(	TNodes::TConstIterator	Parent,
								const KString&			Name,
								TNodes::TConstIterator	After)
{
	DEBUG_VERIFY(Parent.IsValid());

	DEBUG_VERIFY(!After.IsValid() || After.GetParent() == Parent);

	for(TNodes::TConstIterator Iter =	After.IsValid() ?
											After.GetNextSibling() :
											Parent.GetFirstChild() ;
		Iter.IsValid() ;
		Iter.ToNextSibling())
	{
		if(Iter->m_Name == Name)
			return Iter;
	}

	return TNodes::TConstIterator();
}

TStructuredInfo::TNodes::TConstIterator
	TStructuredInfo::FindNodeSafe(	TNodes::TConstIterator	Parent,
									const KString&			Name,
									TNodes::TConstIterator	After)
{
	return Parent.IsValid() ? FindNode(Parent, Name, After) : TNodes::TConstIterator();
}

TStructuredInfo::TNodes::TConstIterator
	TStructuredInfo::GetNode(	TNodes::TConstIterator	Parent,
								const KString&			Name,
								TNodes::TConstIterator	After)
{
	TNodes::TConstIterator Iter = FindNode(Parent, Name, After);

	if(!Iter.IsValid())
		INITIATE_DEFINED_FAILURE((KString)TEXT("Info node \"") + Name + TEXT("\" not found."));

	return Iter;
}

const KString& TStructuredInfo::GetSubNodeParameterValue(	TStructuredInfo::TNodes::TConstIterator	Parent,
															const KString&							SubNodeName,
															const KString&							ParameterName,															
															TStructuredInfo::TNodes::TConstIterator	SubNodeAfter)
{
	return GetNode(Parent, SubNodeName, SubNodeAfter)->GetParameterValue(ParameterName);
}

KString TStructuredInfo::GetSubNodeParameterValue(	TStructuredInfo::TNodes::TConstIterator	Parent,
													const KString&							SubNodeName,
													const KString&							ParameterName,
													const KString&							DefaultValue,													
													TStructuredInfo::TNodes::TConstIterator	SubNodeAfter)
{
	const TStructuredInfo::TNodes::TConstIterator NIter =
		FindNode(Parent, SubNodeName, SubNodeAfter);
	
	return NIter.IsValid() ? NIter->GetParameterValue(ParameterName, DefaultValue) : DefaultValue;
}

TStructuredInfo::TNodes::TIterator
	TStructuredInfo::AddNode(	TStructuredInfo::TNodes::TIterator	Parent,
								const KString&						Name)
{
	DEBUG_VERIFY(Parent.IsValid());

	const TNodes::TIterator NIter = TNodes::AddLastChild(Parent);

	NIter->Set(Name);

	return NIter;
}

TStructuredInfo::TNode::TParameters::TIterator
	TStructuredInfo::AddSubNodeParameter(	TStructuredInfo::TNodes::TIterator	Parent,
											const KString&						SubNodeName,
											const KString&						ParameterName,
											const KString&						ParameterValue)
{
	return AddNode(Parent, SubNodeName)->AddParameter(ParameterName, ParameterValue);
}

// ----------------
// Global routines
// ----------------
KString CutSingleStringComments(const KString& SingleString)
{
	size_t i;

	if(SingleString.GetLength() < 2)
		return SingleString;

	bool bQuoted = false;

	for(i = 0 ; i < SingleString.GetLength() - 1 ; i++)
	{
		if(SingleString[i] == TEXT('"'))
		{
			bQuoted = !bQuoted;
		}
		else
		{
			// checking for unquoted comment prefix
			if(!bQuoted && SingleString[i] == TEXT('/') && SingleString[i+1] == TEXT('/'))
				return SingleString.Left(i);
		}
	}

	return SingleString; // no comment detected
}

KString EncodeToSingleString(	const KString&	String,
								TCHAR			cTerminator)
{
	DEBUG_VERIFY(	cTerminator != TEXT(' ')	&&
					cTerminator != TEXT('\\')	&&
					cTerminator != TEXT('"'));

	size_t i;

	const bool bNeedQuotes =
		String.IsEmpty()							||	// empty
		String[0] == TEXT(' ')						||	// has leading spaces
		String[String.GetLength() - 1] == TEXT(' ') ||	// has trailing spaces
		cTerminator && _tcschr(String, cTerminator)	||	// has terminator character
		String.Find(TEXT("//")) != UINT_MAX			||	// has single line comment start
		String.Find(TEXT("/*")) != UINT_MAX			||	// has long comment start
		String.Find(TEXT("*/")) != UINT_MAX;			// has long commend end

	KString SingleString;
	
	if(bNeedQuotes)
		SingleString += TEXT('"');

	for(i = 0 ; i < String.GetLength() ; i++)
	{
		if(String[i] == TEXT('\t'))
			SingleString += TEXT("\\t");
		else if(String[i] == TEXT('\r'))
			SingleString += TEXT("\\r");
		else if(String[i] == TEXT('\n'))
			SingleString += TEXT("\\n");
		else if(String[i] == TEXT('\\'))
			SingleString += TEXT("\\\\");
		else if(String[i] == TEXT('"'))
			SingleString += TEXT("\\\"");
		else
			SingleString += String[i];
	}

	if(bNeedQuotes)
		SingleString += TEXT('"');

	return SingleString;
}

KString DecodeFromSingleString(	const KString&	SingleString,
								TCHAR			cTerminator,
								size_t*			pRLengthDecoded)
{
	DEBUG_VERIFY(	cTerminator != TEXT(' ')	&&
					cTerminator != TEXT('\\')	&&
					cTerminator != TEXT('"'));

	size_t i;

	KString String;

	bool bQuoted = false;

	size_t szTrailingSpacesStart = 0;
	
	for(i = 0 ; i < SingleString.GetLength() ; i++)
	{
		// Checking for unquoted terminator character
		if(!bQuoted && SingleString[i] == cTerminator)
			break;

		if(SingleString[i] == TEXT('"')) // quote state change
		{
			bQuoted = !bQuoted;
		}
		else
		{
			if(SingleString[i] == TEXT('\\')) // escape sequence
			{
				if(++i == SingleString.GetLength())
					INITIATE_DEFINED_FAILURE(TEXT("Unfinished escape sequence inside encoded single string."));

				if(SingleString[i] == TEXT('t'))
					String += TEXT('\t');
				else if(SingleString[i] == TEXT('r'))
					String += TEXT('\r');
				else if(SingleString[i] == TEXT('n'))
					String += TEXT('\n');
				else
					String += TEXT('\\'), String += SingleString[i];
			}
			else // plain character
			{
				if(bQuoted || !_istspace(SingleString[i])) // non-trimmable character
				{
					szTrailingSpacesStart = String.GetLength() + 1;
				}
				else // trimmable space
				{
					if(szTrailingSpacesStart == 0) // leading space
						continue;
				}

				String += SingleString[i];
			}
		}
	}

	if(bQuoted)
		INITIATE_DEFINED_FAILURE(TEXT("Encoded single string has missing closing \"."));

	// Cutting trailing spaces
	String.SetLeft(szTrailingSpacesStart);

	if(pRLengthDecoded)
		*pRLengthDecoded = i;

	return String;
}

int& ReadInt(	const KString&	String,
				int&			iRValue,
				LPCTSTR			pValueName)
{
	if(!FromString(String, iRValue))
		REPORT_INCORRECT_VALUE_FORMAT;

	return iRValue;
}

int& ReadNormalizedInt(	const KString&	String,
						int&			iRValue,
						LPCTSTR			pValueName,
						const ISEGMENT&	Limits)
{
	ReadInt(String, iRValue, pValueName);

	if(!HitsSegmentBounds(iRValue, Limits))
		REPORT_INVALID_VALUE;

	return iRValue;
}

UINT& ReadUINT(	const KString&	String,
				UINT&			uiRValue,
				LPCTSTR			pValueName)
{
	if(!FromString(String, uiRValue))
		REPORT_INCORRECT_VALUE_FORMAT;

	return uiRValue;
}

UINT& ReadNormalizedUINT(const KString&		String,
						UINT&				uiRValue,
						LPCTSTR				pValueName,
						const SZSEGMENT&	Limits)
{
	ReadUINT(String, uiRValue, pValueName);

	if(!HitsSegmentBounds(uiRValue, Limits))
		REPORT_INVALID_VALUE;

	return uiRValue;
}

float& ReadFloat(	const KString&	String,
				float&			fRValue,
				LPCTSTR			pValueName)
{
	if(!FromString(String, fRValue))
		REPORT_INVALID_VALUE;

	return fRValue;
}

float& ReadNormalizedFloat(	const KString&	String,
							float&			fRValue,
							LPCTSTR			pValueName,
							const FSEGMENT&	Limits)
{
	ReadFloat(String, fRValue, pValueName);

	if(!HitsSegmentBounds(fRValue, Limits))
		REPORT_INVALID_VALUE;

	return fRValue;
}

bool& ReadBool(	const KString&	String,
				bool&			bRValue,
				LPCTSTR			pValueName)
{
	if(!FromString(String, bRValue))
		REPORT_INCORRECT_VALUE_FORMAT;

	return bRValue;
}

KString& ReadText(	TInfoNodeConstIterator	InfoNode,
					LPCTSTR					pParameterName,
					KString&				RText)
{
	TInfoParameterConstIterator PIter;

	bool bFirstRow = true;

	PIter.Invalidate();
	while((PIter = InfoNode->FindParameter(pParameterName, PIter)).IsValid())
	{
		if(bFirstRow)
			bFirstRow = false;
		else
			RText += TEXT('\n');

		RText += PIter->m_Value;
	}

	return RText;
}