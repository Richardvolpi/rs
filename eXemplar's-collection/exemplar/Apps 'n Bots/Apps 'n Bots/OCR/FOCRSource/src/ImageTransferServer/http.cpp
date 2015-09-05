#include "server_pch.h"
#include "http.h"

// ---------------------
// HTTP header commands
// ---------------------
void THTTPHeaderCommands::Clear()
{
	TValueList<THTTPHeaderCommand>::Clear();

	m_Result.Empty();
}

// ----------------
// Global routines
// ----------------
bool IsSupportedHTTPProtocol(LPCTSTR pProtocol)
{
	return	!_tcsicmp(pProtocol, TEXT("http")) ||
			!_tcsicmp(pProtocol, TEXT("https"));
}

void ParseHTTPHeaderCommand(const KString&		s,
							THTTPHeaderCommand&	RCommand)
{
	int i = 0;

	i = s.Find(TEXT(":"));

	if(i == -1)
		RCommand.m_Command = s, RCommand.m_Content = TEXT("");
	else
		RCommand.m_Command = s.Left(i), RCommand.m_Content = s.Mid(i + 1);

	RCommand.m_Command = RCommand.m_Command.Trim();
	RCommand.m_Content = RCommand.m_Content.Trim();
}

static TCHAR DigToHex(BYTE v)
{
	if(v < 10)
		return TEXT('0') + v;

	if(v < 16)
		return TEXT('A') + (v - 10);

	return '0';
}

KString EncodeHTTPParameter(LPCTSTR s)
{
	size_t i;

	KString res;

	for(i = 0 ; s[i] ; i++)
	{
		if(isalpha(s[i]) || isdigit(s[i]) || s[i]==TEXT('@') || s[i]==TEXT('.'))
			res += s[i];
		else if(s[i] == TEXT(' '))
			res += TEXT('+');
		else
			res += TEXT('%'), res += DigToHex(s[i] >> 4), res += DigToHex(s[i] & 0xF);
	}

	return res;
}