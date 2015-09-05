#include "kfc_common_pch.h"
#include "obscure.h"

#include "random_globals.h"

// ----------------
// Global routines
// ----------------
static void RandomScanStep(KRegistryKey& Key, size_t& szTimes)
{
	SAFE_BLOCK_BEGIN

	DEBUG_VERIFY(!Key.IsEmpty());

	DEBUG_VERIFY(Key.IsOpen());

	for(;;)
	{
		if(szTimes == 0)
			return;

		KStrings Keys;
		Key.EnlistKeys(Keys);

		KStrings Values;
		Key.EnlistValues(Values);

		if(--szTimes == 0)
			break;

		if(Keys.GetN() > 0 && g_RandomGlobals.GenerateRandomBool(0.5f)) // random key entry
		{
			SAFE_BLOCK_BEGIN

			KRegistryKey Key2(	Key,
								*Keys.GetIndexed(	g_RandomGlobals.
														GenerateRandomUINT(SZSEGMENT(	0,
																						Keys.GetN()))));

			Key2.Open(KEY_READ);

			RandomScanStep(Key2, szTimes);

			SAFE_BLOCK_END
		}
		else if(Values.GetN() > 0) // random value access
		{
			SAFE_BLOCK_BEGIN

			const KString& Value = *Values.GetIndexed(	g_RandomGlobals.
															GenerateRandomUINT(SZSEGMENT(	0,
																							Values.GetN())));

			if(Key.GetValueType(Value) == REG_SZ)
				Key.ReadString(Value);
			else if(Key.GetValueType(Value) == REG_DWORD)
				Key.ReadUINT(Value);

			SAFE_BLOCK_END
		}

		if(g_RandomGlobals.GenerateRandomBool())
			break;
	}

	SAFE_BLOCK_END
}

void RandomRegistryScan(KRegistryKey& Key, size_t szTimes)
{
	DEBUG_VERIFY(!Key.IsEmpty());

	DEBUG_VERIFY(Key.IsOpen());

	SAFE_BLOCK_BEGIN

	while(szTimes > 0)
		RandomScanStep(Key, szTimes);

	SAFE_BLOCK_END
}

DWORD GetVolumeSerialNumber()
{
	DWORD dwSerial;
	GetVolumeInformation(TEXT("c:\\"), NULL, NULL, &dwSerial, NULL, NULL, NULL, NULL);

	return dwSerial;
}

DWORD MultiplyBits(DWORD dwValue, const DWORD Matrix[32])
{
	DWORD dwResult = 0;

	for(size_t i = 0 ; i < 32 ; i++)
	{
		DWORD dwRow = dwValue & Matrix[i];

		DWORD dwBit = 0;
		for(size_t j = 0 ; j < 32 ; j++)
			dwBit += (dwRow & 1), dwRow >>= 1;

		dwResult <<= 1, dwResult |= dwBit & 1;
	}

	return dwResult;
}