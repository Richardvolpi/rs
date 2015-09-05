#ifndef interpolator_defs_h
#define interpolator_defs_h

#include <KFC_KTL\stacked_storage.h>
#include <KFC_KTL\varray.h>

// Interpolator IDs
#define INTERPOLATOR_ID_NONE	(UINT_MAX)

// -------------
// Declarations
// -------------
class TInterpolator;
class TInterpolatorProcessor;

// Interpolator handle
typedef TStackedStorageIterator<TInterpolator> TInterpolatorHandle;

// Interpolator handles
typedef TValueArray<TInterpolatorHandle, true> TInterpolatorHandles;

// Interpolator iterator
typedef TStackedStorageConstIterator<TInterpolator> TInterpolatorIterator;

// Interpolator iterators
typedef TValueArray<TInterpolatorIterator, true> TInterpolatorIterators;

#endif // interpolator_defs_h
