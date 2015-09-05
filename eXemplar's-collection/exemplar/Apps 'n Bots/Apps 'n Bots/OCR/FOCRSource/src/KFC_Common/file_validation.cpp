#include "kfc_common_pch.h"
#include "file_validation.h"

#include "file.h"

// ----------------
// Global routines
// ----------------
bool IsPEImageFile(const KString& FileName)
{
	try
	{
		TFile File(FileName, FOF_BINARYREAD);

		File.Seek(0x3C);

		size_t szOffset;
		File >> szOffset;
		
		File.Seek(szOffset);

		char Signature[4];
		File.Read(Signature, sizeof(Signature));

		if(memcmp(Signature, "PE\0\0", 4))
			throw 1;

		return true;
	}

	catch(...)
	{
		return false;
	}
}

bool IsJPEGFile(const KString& FileName)
{
	try
	{
		BYTE bValue;
		TFile(FileName, FOF_BINARYREAD) >> bValue;

		if(bValue != 0xFF)
			throw 1;

		return true;
	}
	
	catch(...)
	{
		return false;
	}
}
