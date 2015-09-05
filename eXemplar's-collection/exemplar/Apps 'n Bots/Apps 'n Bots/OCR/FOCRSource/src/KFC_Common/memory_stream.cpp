#include "kfc_common_pch.h"
#include "memory_stream.h"

// --------------
// Memory stream
// --------------
TMemoryStream::TMemoryStream(const TArrayAllocation& Allocation)
{
	m_Data.Allocate(Allocation);

	m_szOffset = 0;
}

void TMemoryStream::StreamRead(void* pRData, size_t szLength)
{
	DEBUG_VERIFY(m_szOffset + szLength <= m_Data.GetN());

	memcpy(pRData, m_Data.GetDataPtr(m_szOffset), szLength);

	m_szOffset += szLength;
}

void TMemoryStream::StreamWrite(const void* pData, size_t szLength)
{
	memcpy(&m_Data.Add(szLength), pData, szLength);
}

void TMemoryStream::Clear()
{
	m_Data.Clear(), Rewind();
}

void TMemoryStream::Rewind()
{
	m_szOffset = 0;
}