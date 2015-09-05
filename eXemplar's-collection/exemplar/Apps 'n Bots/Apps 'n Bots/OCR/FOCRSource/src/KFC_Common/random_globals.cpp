#include "kfc_common_pch.h"
#include "random_globals.h"

#include <stdlib.h>
#include <time.h>
#include "time_globals.h"

TRandomGlobals g_RandomGlobals;

// ---------------
// Random globals
// ---------------
TRandomGlobals::TRandomGlobals() : TGlobals(TEXT("Random globals"), 1)
{
	AddSubGlobals(g_TimeGlobals);
}

void TRandomGlobals::OnUninitialize()
{
}

void TRandomGlobals::OnInitialize()
{
	srand(time(NULL));
}

int TRandomGlobals::GenerateRandomInt(const ISEGMENT& Segment)
{
	DEBUG_VERIFY(IsInitialized());

	DEBUG_VERIFY(!Segment.IsFlat());

	return Segment.m_First + rand() % Segment.GetLength();
}

size_t TRandomGlobals::GenerateRandomUINT(const SZSEGMENT& Segment)
{
	DEBUG_VERIFY(IsInitialized());

	DEBUG_VERIFY(!Segment.IsFlat());

	return Segment.m_First + (size_t)rand() % Segment.GetLength();
}

float TRandomGlobals::GenerateRandomFloat(	const FSEGMENT&	Segment,
											size_t			szAccuracy)
{
	DEBUG_VERIFY(IsInitialized());

	float fValue = (float)GenerateRandomUINT(SZSEGMENT(0, szAccuracy));
	
	ResizeValue(FSEGMENT(0, (float)szAccuracy),
				Segment,
				fValue);

	return fValue;
}

bool TRandomGlobals::GenerateRandomBool(float fProbability)
{
	DEBUG_VERIFY(IsInitialized());

	DEBUG_VERIFY(HitsSegmentBounds(fProbability, FSEGMENT(0.0f, 1.0f)));

	return Compare(GenerateRandomFloat(FSEGMENT(0.0f, 1.0f)), fProbability) < 0;
}