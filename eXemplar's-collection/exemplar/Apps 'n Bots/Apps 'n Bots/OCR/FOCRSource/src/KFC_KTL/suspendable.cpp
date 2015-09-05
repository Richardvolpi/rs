#include "kfc_ktl_pch.h"
#include "suspendable.h"

// ------------
// Suspendable
// ------------
TSuspendable::TSuspendable()
{
	ResetSuspendCount();
}

bool TSuspendable::OnSuspend()
{
	return true;
}

bool TSuspendable::OnResume()
{
	return true;
}

void TSuspendable::ResetSuspendCount(size_t szSSuspendCount)
{
	m_szSuspendCount = szSSuspendCount;
}

bool TSuspendable::SetSuspendCount(size_t szSSuspendCount)
{
	if(IsSuspended())
	{
		if(szSSuspendCount > 0)
		{
			m_szSuspendCount = szSSuspendCount;
			return true;
		}
		else
		{
			if(OnResume())
			{
				m_szSuspendCount = 0;
				return true;
			}

			return false;
		}
	}
	else
	{
		if(szSSuspendCount > 0)
		{
			if(OnSuspend())
			{
				m_szSuspendCount = szSSuspendCount;
				return true;
			}

			return false;
		}
		else
		{
			return true;
		}
	}
}

bool TSuspendable::Suspend()
{
	return SetSuspendCount(m_szSuspendCount + 1);
}

bool TSuspendable::Resume()
{
	return m_szSuspendCount > 0 && SetSuspendCount(m_szSuspendCount - 1);
}

// ----------
// Suspender
// ----------
TSuspender::TSuspender(TSuspendable& SSuspendable)
{
	m_pSuspendable = SSuspendable.Suspend() ? &SSuspendable : NULL;
}

TSuspender::~TSuspender()
{
	if(HasSucceeded())
		m_pSuspendable->Resume();
}
