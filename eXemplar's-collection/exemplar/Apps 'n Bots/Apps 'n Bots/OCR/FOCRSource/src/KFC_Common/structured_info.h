#ifndef structured_info_h
#define structured_info_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_bitypes.h>
#include <KFC_KTL\kstring.h>
#include <KFC_KTL\vtree.h>
#include <KFC_KTL\vlist.h>
#include <KFC_KTL\string_conv.h>
#include "file.h"

#define MAX_SET_LOADING_DIMENSIONS	(4)

// ----------------
// Structured info
// ----------------
class KFC_COMMON_API TStructuredInfo
{
public:
	// Node
	struct KFC_COMMON_API TNode
	{
		// Parameter
		struct KFC_COMMON_API TParameter
		{
			KString m_Name;
			KString m_Value;


			TParameter& Set(const KString& SName	= TEXT(""),
							const KString& SValue	= TEXT(""))
			{
				m_Name	= SName;
				m_Value	= SValue;

				return *this;
			}
		};

		// Parameters
		typedef TValueList<TParameter> TParameters;


		KString		m_Name;
		TParameters	m_Parameters;


		TNode& Set(const KString& SName = TEXT(""))
		{
			m_Name = SName;

			return *this;
		}

		TParameters::TConstIterator FindParameter(	const KString&				Name,
													TParameters::TConstIterator	After = TParameters::TConstIterator()) const;

		TParameters::TConstIterator GetParameter(	const KString&				Name,
													TParameters::TConstIterator	After = TParameters::TConstIterator()) const;

		const KString& GetParameterValue(	const KString&				Name,
											TParameters::TConstIterator	After = TParameters::TConstIterator()) const;

		const KString GetParameterValue(const KString&				Name,
										const KString&				DefaultValue,
										TParameters::TConstIterator	After = TParameters::TConstIterator()) const;

		bool HasParameter(	const KString&				Name,
							TParameters::TConstIterator	After = TParameters::TConstIterator()) const;

		bool HasTrueParameter(	const KString&				Name,
								TParameters::TConstIterator	After = TParameters::TConstIterator()) const;

		TParameters::TIterator AddParameter(const KString& Name		= TEXT(""),
											const KString& Value	= TEXT(""));
	};

	// Nodes
	typedef TValueTree<TNode> TNodes;

private:
	bool m_bAllocated;

	TNodes m_Nodes;


	void LoadNode(TNodes::TIterator			Handle,	TFile& File, size_t szDepth);
	void SaveNode(TNodes::TConstIterator	Iter,	TFile& File, size_t szDepth) const;

	static void SkipNode(TFile& File);

public:
	TStructuredInfo();

	TStructuredInfo(const KString& FileName);

	~TStructuredInfo() { Release(); }
	
	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate();

	void Load(const KString& FileName);
	void Save(const KString& FileName) const;

	TNodes::TIterator		GetRootNode();
	TNodes::TConstIterator	GetRootNode() const;


	static TNodes::TConstIterator FindNode(	TNodes::TConstIterator	Parent,
											const KString&			Name,
											TNodes::TConstIterator	After = TNodes::TConstIterator());

	static TNodes::TConstIterator FindNodeSafe(	TNodes::TConstIterator	Parent,
												const KString&			Name,
												TNodes::TConstIterator	After = TNodes::TConstIterator());


	static TNodes::TConstIterator GetNode(	TNodes::TConstIterator	Parent,
											const KString&			Name,
											TNodes::TConstIterator	After = TNodes::TConstIterator());

	static const KString& GetSubNodeParameterValue(	TNodes::TConstIterator	Parent,
													const KString&			SubNodeName,
													const KString&			ParameterName,
													TNodes::TConstIterator	SubNodeAfter = TNodes::TConstIterator());

	static KString GetSubNodeParameterValue(TNodes::TConstIterator	Parent,
											const KString&			SubNodeName,
											const KString&			ParameterName,
											const KString&			DefaultValue,
											TNodes::TConstIterator	SubNodeAfter = TNodes::TConstIterator());

	static TNodes::TIterator AddNode(	TNodes::TIterator	Parent,
										const KString&		Name = TEXT(""));

	static TNode::TParameters::TIterator AddSubNodeParameter(	TNodes::TIterator	Parent,
																const KString&		SubNodeName		= TEXT(""),
																const KString&		ParameterName	= TEXT(""),
																const KString&		ParameterValue	= TEXT(""));
};

// ----------------
// Global typedefs
// ----------------
typedef TStructuredInfo::TNodes::TIterator		TInfoNodeIterator;
typedef TStructuredInfo::TNodes::TConstIterator	TInfoNodeConstIterator;

typedef TStructuredInfo::TNode::TParameters::TIterator		TInfoParameterIterator;
typedef TStructuredInfo::TNode::TParameters::TConstIterator	TInfoParameterConstIterator;

// ----------------
// Global routines
// ----------------
KFC_COMMON_API KString CutSingleStringComments(const KString& SingleString);

KFC_COMMON_API KString EncodeToSingleString(const KString&	String,
											TCHAR			cTerminator = 0);

KFC_COMMON_API KString DecodeFromSingleString(	const KString&	SingleString,
												TCHAR			cTerminator		= 0,
												size_t*			pRLengthDecoded	= NULL);

KFC_COMMON_API int& ReadInt(const KString&	String,
							int&			iRValue,
							LPCTSTR			pValueName);

KFC_COMMON_API int& ReadNormalizedInt(	const KString&	String,
										int&			iRValue,
										LPCTSTR			pValueName,
										const ISEGMENT&	Limits);

KFC_COMMON_API UINT& ReadUINT(	const KString&	String,
								UINT&			uiRValue,
								LPCTSTR			pValueName);

KFC_COMMON_API UINT& ReadNormalizedUINT(	const KString&		String,
										UINT&				uiRValue,
										LPCTSTR				pValueName,
										const SZSEGMENT&	Limits);

KFC_COMMON_API float& ReadFloat(const KString&	String,
								float&			fRValue,
								LPCTSTR			pValueName);

KFC_COMMON_API float& ReadNormalizedFloat(	const KString&	String,
											float&			fRValue,
											LPCTSTR			pValueName,
											const FSEGMENT&	Limits = FSEGMENT(0.0f, 1.0f));

KFC_COMMON_API bool& ReadBool(	const KString&	String,
								bool&			bRValue,
								LPCTSTR			pValueName);

template <class t>
t& ReadBiTypeValue(	const KString&	String,
					t&				RValue,
					LPCTSTR			pValueName)
{
	if(!FromString(String, RValue))
		REPORT_INCORRECT_VALUE_FORMAT;

	if(!RValue.IsValid())
		REPORT_INVALID_VALUE;

	return RValue;
}

KFC_COMMON_API KString& ReadText(	TInfoNodeConstIterator	InfoNode,
									LPCTSTR					pParameterName,
									KString&				RText);

#endif // structured_info_h