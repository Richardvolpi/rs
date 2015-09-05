#ifndef msg_box_h
#define msg_box_h

#include "kfc_common_api.h"

// ---------------
// Msg box params
// ---------------
struct KFC_COMMON_API TMsgBoxParams
{
	HWND	m_hWnd;
	KString	m_Text;
	KString	m_Caption;
	type_t	m_tpType;


	TMsgBoxParams(	HWND	hSWnd,
					LPCTSTR	pSText,
					LPCTSTR	pSCaption,
					type_t	tpSType) :	m_hWnd		(hSWnd),
										m_Text		(pSText),
										m_Caption	(pSCaption),
										m_tpType	(tpSType) {}

	int Spawn() const;
};

// ----------------
// Global routines
// ----------------
KFC_COMMON_API void ThreadedMessageBox(const TMsgBoxParams& Params);

#endif // msg_box_h