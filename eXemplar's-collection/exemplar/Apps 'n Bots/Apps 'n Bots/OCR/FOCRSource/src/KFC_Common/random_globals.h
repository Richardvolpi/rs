#ifndef random_globals_h
#define random_globals_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_bitypes.h>
#include <KFC_KTL\globals.h>
#include "kfc_common_api.h"

// ---------------
// Random globals
// ---------------
class KFC_COMMON_API TRandomGlobals : public TGlobals
{
private:
	void OnInitialize	();
	void OnUninitialize	();

public:
	TRandomGlobals();

	int GenerateRandomInt(const ISEGMENT& Segment);

	size_t GenerateRandomUINT(const SZSEGMENT& Segment);

	size_t GenerateRandomUINT(size_t szMax)
		{ return GenerateRandomUINT(SZSEGMENT(0, szMax)); }

	float GenerateRandomFloat(	const FSEGMENT&	Segment,
								size_t			szAccuracy = 16384);

	bool GenerateRandomBool(float fProbability = 0.5f);
};

extern KFC_COMMON_API TRandomGlobals g_RandomGlobals;

#endif // random_globals_h
