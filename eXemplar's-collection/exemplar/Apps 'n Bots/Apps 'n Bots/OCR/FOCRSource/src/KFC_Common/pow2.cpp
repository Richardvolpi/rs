#include "kfc_common_pch.h"
#include "pow2.h"

size_t HighestBit1(UINT uiValue)
{
	if(uiValue == 0)
		return UINT_MAX;

	const size_t	szUINTHighestBit		= (sizeof(UINT) << 3) - 1;
	const UINT		uiUINTHighestBitValue	= 1 << szUINTHighestBit;

	for(size_t szRet = szUINTHighestBit ; ; szRet--)
	{
		if(uiValue & uiUINTHighestBitValue)
			return szRet;

		uiValue <<= 1;
	}
}

size_t LowestBit1(UINT uiValue)
{
	if(uiValue == 0)
		return UINT_MAX;

	for(size_t szRet = 0 ; ; szRet++)
	{
		if(uiValue & 1)
			return szRet;

		uiValue >>= 1;
	}
}

bool IsPow2(UINT uiValue)
{
	if(uiValue == 0)
		return false;

	for( ; (uiValue & 1) == 0 ; uiValue >>= 1);

	return (uiValue >> 1) == 0;
}

UINT MaxPow2LessEq(UINT uiValue)
{
	if(uiValue == 0)
		return UINT_MAX;

	UINT uiRet;
	for(uiRet = 1 << ((sizeof(UINT) << 3) - 1) ;
		uiRet > uiValue ;
		uiRet >>= 1);

	return uiRet;
}

UINT MinPow2GreaterEq(UINT uiValue)
{
	if(uiValue == 0)
		return UINT_MAX;

	UINT uiRet;
	for(uiRet = 1 ; uiRet < uiValue ; uiRet <<= 1);

	return uiRet;
}
