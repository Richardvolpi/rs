#include "kfc_ktl_pch.h"
#include "hex.h"

// ----------------
// Global routines
// ----------------
TCHAR HexToChar(size_t szValue)
{
	if(szValue < 10)
		return (TCHAR)(TEXT('0') + szValue); 

	if(szValue < 16)
		return (TCHAR)(TEXT('A') + szValue - 10);

	return TEXT('0');
}

size_t CharToHex(TCHAR cChar)
{
	if(_istdigit(cChar))
		return cChar - TEXT('0');

	cChar = _totupper(cChar);

	if(cChar >= TEXT('A') && cChar <= TEXT('F'))
		return cChar - TEXT('A') + 10;

	return 0;
}