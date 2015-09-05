#ifndef interpolator_macros_h
#define interpolator_macros_h

#include <KFC_KTL\debug.h>

// Interpolator

// --------------------------
// Value mapper interpolator
// --------------------------
#define SEGMENTED_VALUE_MAPPER_INTERPOLATOR(SrcType, DstType, GetterTemplate, SetterType, SegmentValueMapperType, szNSegments)	\
	TValueMapperInterpolator<	SrcType,																						\
								DstType,																						\
								GetterTemplate<SrcType>,																		\
								SetterType,																						\
								TSegmentedValueMapper<	SrcType,																\
														DstType,																\
														SegmentValueMapperType,													\
														szNSegments> >															\

// -------------------------------------
// Float time value mapper interpolator
// -------------------------------------
#define FLOAT_TIME_SEGMENTED_VALUE_MAPPER_INTERPOLATOR(DstType, SetterType, SegmentValueMapperType, szNSegments)				\
	SEGMENTED_VALUE_MAPPER_INTERPOLATOR(float, DstType, TTimeSrcValueGetter, SetterType, SegmentValueMapperType, szNSegments)	\
	
#endif // interpolator_macros_h
