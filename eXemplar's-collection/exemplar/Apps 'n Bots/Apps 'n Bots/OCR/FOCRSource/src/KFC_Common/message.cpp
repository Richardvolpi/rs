#include "kfc_common_pch.h"
#include "message.h"

// ------------------
// Message processor
// ------------------
TMessageProcessor::TMessageProcessor()
{
	m_bAllocated = false;
}

void TMessageProcessor::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		TMessageStorage::Release();
	}
}

void TMessageProcessor::Allocate(size_t szMinPortionSize)
{
	Release();

	try
	{
		TMessageStorage::Allocate(szMinPortionSize);

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}