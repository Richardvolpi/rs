#include "kfc_ktl_pch.h"
#include "kfc_mem.h"

// ----------------
// Global routines
// ----------------
void* kfc_malloc(size_t szSize)
{
	void* const pData = malloc(szSize);

	if(szSize > 0 && pData == NULL)
	{
		INITIATE_DEFINED_FAILURE(KString::Formatted(TEXT("Error allocating %u bytes."),
														szSize));
	}

	return pData;
}

void* kfc_calloc(size_t szNum, size_t szSize)
{
	void* const pData = calloc(szNum, szSize);

	if(szSize > 0 && pData == NULL)
	{
		INITIATE_DEFINED_FAILURE(KString::Formatted(TEXT("Error allocating %u bytes."),
														szSize));
	}

	return pData;
}

void* kfc_realloc(void* pData, size_t szSize)
{
	pData = realloc(pData, szSize);

	if(szSize > 0 && pData == NULL)
	{
		INITIATE_DEFINED_FAILURE(KString::Formatted(TEXT("Error reallocating %u bytes."),
														szSize));
	}

	return pData;
}

void kfc_free(void* pData)
{
	if(pData)
		free(pData);
}