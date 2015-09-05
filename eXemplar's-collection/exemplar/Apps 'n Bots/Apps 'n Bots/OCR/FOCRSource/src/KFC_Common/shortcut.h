#ifndef shortcut_h
#define shortcut_h

// ----------------
// Global routines
// ----------------
KFC_COMMON_API KString GetShortcutTarget(	const KString&	FileName,
											bool			bResolve	= false,
											flags_t			flFlags		= SLGP_UNCPRIORITY);

KFC_COMMON_API void CreateShortcut(const KString& FileName, const KString& Target);

#endif // shortcut_h