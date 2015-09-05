#include "kfc_ktl_pch.h"
#include "globals_collector.h"

TGlobalsCollector g_GlobalsCollector;

// ------------------
// Globals collector
// ------------------
TGlobalsCollector::TGlobalsCollector()
{
	m_GlobalsList.Allocate(TArrayAllocation(64, 64));
};

TGlobalsCollector::~TGlobalsCollector()
{
	m_GlobalsList.Release();
}

bool TGlobalsCollector::OnSuspend()
{
	if(!TSuspendable::OnSuspend())
		return false;

	size_t i;
	
	for(i = 0 ; i < m_GlobalsList.GetN() ; i++)
		m_GlobalsList[i]->Suspend();

	return true;
}

bool TGlobalsCollector::OnResume()
{
	if(!TSuspendable::OnResume())
		return false;

	size_t i;
	
	for(i = m_GlobalsList.GetN() - 1 ; i != UINT_MAX ; i--)
		m_GlobalsList[i]->Resume();

	return true;
}

bool TGlobalsCollector::PreUpdate()
{
	size_t i;

	for(i = 0 ; i < m_GlobalsList.GetN() ; i++)
	{
		if(!m_GlobalsList[i]->PreUpdate())
			break;
	}

	if(i < m_GlobalsList.GetN())
	{
		PostUpdate(i - 1, true);
		return false;
	}

	return true;
}

void TGlobalsCollector::PostUpdate(	size_t	szStartIndex,
									bool	bFailureRollBack)
{
	size_t i;

	for(i = szStartIndex ; i != UINT_MAX ; i--)
		m_GlobalsList[i]->PostUpdate(bFailureRollBack);
}

bool TGlobalsCollector::PreRender() const
{
	size_t i;

	for(i = 0 ; i < m_GlobalsList.GetN() ; i++)
	{
		if(!m_GlobalsList[i]->PreRender())
			break;
	}

	if(i < m_GlobalsList.GetN())
	{
		PostRender(i - 1, true);
		return false;
	}

	return true;
}

void TGlobalsCollector::PostRender(	size_t	szStartIndex,
									bool	bFailureRollBack) const
{
	size_t i;

	for(i = szStartIndex ; i != UINT_MAX ; i--)
		m_GlobalsList[i]->PostRender(bFailureRollBack);
}

bool TGlobalsCollector::Update()
{
	size_t i;

	if(PreUpdate())
	{
		for(i = 0 ; i < m_GlobalsList.GetN() ; i++)
			m_GlobalsList[i]->Update();

		PostUpdate(m_GlobalsList.GetN() - 1, true);

		return true;
	}

	return false;
}

bool TGlobalsCollector::Render() const
{
	size_t i;

	if(PreRender())
	{
		for(i = 0 ; i < m_GlobalsList.GetN() ; i++)
			m_GlobalsList[i]->Render();

		PostRender(m_GlobalsList.GetN() - 1, false);

		return true;
	}

	return false;
}

void TGlobalsCollector::ChangeMode()
{
	size_t i;

	for(i = 0 ; i < m_GlobalsList.GetN() ; i++)
		m_GlobalsList[i]->ChangeMode();
}

void TGlobalsCollector::Terminate()
{
	size_t i;

	for(i = m_GlobalsList.GetN() - 1 ; i != UINT_MAX ; i--)
		m_GlobalsList[i]->Terminate();
}

void TGlobalsCollector::RegisterGlobals(TGlobals* pGlobals)
{
#ifdef _DEBUG

	size_t i;
	for(i = 0 ; i < m_GlobalsList.GetN() ; i++)
	{
		if(m_GlobalsList[i] == pGlobals)
			INITIATE_DEFINED_FAILURE((KString)TEXT("\"") + pGlobals->GetName() + TEXT("\" attempted to register more than once."));
	}

#endif // _DEBUG

	m_GlobalsList.Add() = pGlobals;
}

void TGlobalsCollector::UnregisterGlobals(TGlobals* pGlobals)
{
#ifdef _DEBUG

	if(!m_GlobalsList.IsLast(pGlobals))
	{
		SHOW_FAILURE_MESSAGE((KString)TEXT("\"") + pGlobals->GetName() + TEXT("\" attempted to unregister not being at top."));
		exit(0);
	}

#endif _DEBUG

	if(m_GlobalsList.IsLast(pGlobals))
		m_GlobalsList.DelLast();
}
