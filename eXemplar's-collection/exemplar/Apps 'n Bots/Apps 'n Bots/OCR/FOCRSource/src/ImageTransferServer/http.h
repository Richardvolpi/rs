#ifndef http_h
#define http_h

// --------------------
// HTTP header command
// --------------------
struct THTTPHeaderCommand
{
	KString m_Command;
	KString m_Content;


	THTTPHeaderCommand& Set(LPCTSTR pSCommand,
							LPCTSTR pSContent)
	{
		m_Command	= pSCommand;
		m_Content	= pSContent;

		return *this;
	}
};

// ---------------------
// HTTP header commands
// ---------------------
class THTTPHeaderCommands : public TValueList<THTTPHeaderCommand>
{
public:
	KString m_Result;


	void Clear();
};

// ----------------
// Global routines
// ----------------
bool IsSupportedHTTPProtocol(LPCTSTR pProtocol);

void ParseHTTPHeaderCommand(const KString&		s,
							THTTPHeaderCommand&	RCommand);

KString EncodeHTTPParameter(LPCTSTR s);

#endif // http_h