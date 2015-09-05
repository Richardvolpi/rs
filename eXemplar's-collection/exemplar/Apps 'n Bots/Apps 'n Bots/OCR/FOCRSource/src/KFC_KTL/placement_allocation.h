#ifndef placement_allocation_h
#define placement_allocation_h

#include "basic_types.h"

// ----------------
// Global routines
// ----------------
inline void* operator new(size_t, void* pPtr)
	{ return pPtr; }

inline void operator delete(void*, void*) {}

#endif // placement_allocation_h
