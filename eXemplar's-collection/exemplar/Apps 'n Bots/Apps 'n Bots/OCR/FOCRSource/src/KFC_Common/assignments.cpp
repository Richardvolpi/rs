#include "kfc_common_pch.h"
#include "assignments.h"

// -----------------
// Assignments list
// -----------------
void TAssignmentsList::Release()
{
}

void TAssignmentsList::Allocate(HWND hWnd)
{
	TAssignmentsList::Release();

	try
	{
	}

	catch(...)
	{
		TAssignmentsList::Release();
		throw 1;
	}
}

void TAssignmentsList::Load(const KString& KeyName)
{
	KRegistryKey Key(HKEY_LOCAL_MACHINE, KeyName);

	Key.Create(KEY_READ, 0, true);

	LoadItems(Key);
}

void TAssignmentsList::Save(const KString& KeyName) const
{
	KRegistryKey Key(HKEY_LOCAL_MACHINE, KeyName);

	Key.Create(KEY_WRITE, 0, true);

	SaveItems(Key);
}
