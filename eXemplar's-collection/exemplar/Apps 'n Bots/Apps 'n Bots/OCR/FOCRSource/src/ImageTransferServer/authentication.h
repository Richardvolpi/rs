#ifndef authentication_h
#define authentication_h

// ----------------
// Global routines
// ----------------
bool Authenticate(	const KString& Login,
					const KString& Password,
					const KString& IP);

void PostReply(	const KString& Login,
				const KString& Password,
				const KString& IP);

#endif // authentication_h