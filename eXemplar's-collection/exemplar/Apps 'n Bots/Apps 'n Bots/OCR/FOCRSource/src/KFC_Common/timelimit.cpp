#include "kfc_common_pch.h"
#include "timelimit.h"

#include <KFC_KTL\date_time.h>
#include "common_consts.h"
#include "registry.h"

#ifdef _DEBUG
	#define SACRED_TL_VALUE		TEXT("true")
#else _DEBUG
	#define SACRED_TL_VALUE		TEXT("{78F5C597-8CBE-42d1-8EB4-B65C49FB6561}")
#endif // _DEBUG

// ----------------
// Global routines
// ----------------
static void RegisterExpiration(KRegistryKey& Key)
{
	Key.WriteString(g_CommonConsts.m_ExpiredValueName, SACRED_TL_VALUE);
}

static void RegisterHack(KRegistryKey& Key)
{
	Key.WriteString(g_CommonConsts.m_HackedValueName, SACRED_TL_VALUE);

	RegisterExpiration(Key);
}

TTimeLimitResult GetTimeLimitResult(QWORD qwExpirationPeriod)
{
	TEST_BLOCK_BEGIN
	{
		// Getting current time
		const QWORD qwCurrentTime = TDateTime().GetCurrentGlobal();

		// Creating TL key
		KRegistryKey(HKEY_LOCAL_MACHINE, TEXT("Software\\ECCM Corp.")).		Create(KEY_WRITE, 0, false);
		KRegistryKey(HKEY_LOCAL_MACHINE, TEXT("Software\\ECCM Corp.\\TL")).	Create(KEY_WRITE, 0, false);

		// Accessing TL key
		KRegistryKey Key(	HKEY_LOCAL_MACHINE,
							(KString)TEXT("Software\\ECCM Corp.\\TL\\") +
								g_CommonConsts.m_ApplicationGUIDString);

		Key.Create(KEY_WRITE, 0, false);

		KRegistryKeyOpener Opener0(Key, KEY_ALL_ACCESS);

		if(	!Key.HasValue(g_CommonConsts.m_FirstStartValueName)	&& // the very first start
			!Key.HasValue(g_CommonConsts.m_LastStartValueName)	&&
			!Key.HasValue(g_CommonConsts.m_ExpiredValueName)	&&
			!Key.HasValue(g_CommonConsts.m_HackedValueName))
		{
			Key.WriteString(g_CommonConsts.m_FirstStartValueName,	qwCurrentTime);
			Key.WriteString(g_CommonConsts.m_LastStartValueName,	qwCurrentTime);

			return TR_OK;
		}
		else // not the very first start
		{
			// Getting times
			QWORD qwFirstStartTime;
			if(!FromString(	Key.ReadString(g_CommonConsts.m_FirstStartValueName),
							qwFirstStartTime))
			{
				return RegisterHack(Key), TR_POST_HACK;
			}

			QWORD qwLastStartTime;
			if(!FromString(	Key.ReadString(g_CommonConsts.m_LastStartValueName),
							qwLastStartTime))
			{
				return RegisterHack(Key), TR_POST_HACK;
			}

			// Getting hack state
			if(Key.HasValue(g_CommonConsts.m_HackedValueName))
				return RegisterHack(Key), TR_POST_HACK;

			// Checking post date hack
			if(qwCurrentTime < qwFirstStartTime)
				return RegisterHack(Key), TR_POST_HACK;

			if(qwCurrentTime < qwLastStartTime)
				return TR_PRE_HACK;

			// Getting expired state
			if(Key.HasValue(g_CommonConsts.m_ExpiredValueName))
			{
				if(Key.ReadString(g_CommonConsts.m_ExpiredValueName) != SACRED_TL_VALUE)
					return RegisterHack(Key), TR_POST_HACK;

				return RegisterExpiration(Key), TR_EXPIRED;
			}

			// Saving new last start time
			Key.WriteString(g_CommonConsts.m_LastStartValueName, qwCurrentTime);

			// Checking expiration
			if(qwCurrentTime - qwLastStartTime >= qwExpirationPeriod)
				return RegisterExpiration(Key), TR_EXPIRED;

			return TR_OK;
		}
	}
	TEST_BLOCK_EXCEPTION_HANDLER
	{
		return	TR_POST_HACK;
	}
	TEST_BLOCK_END
}