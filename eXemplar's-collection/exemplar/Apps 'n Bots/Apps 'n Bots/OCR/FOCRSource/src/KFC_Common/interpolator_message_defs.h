#ifndef interpolator_message_defs_h
#define interpolator_message_defs_h

#include "message.h"
#include "interpolator_defs.h"
#include "kfc_common_api.h"

// ------------------------------
// Interpolator finished message
// ------------------------------
struct KFC_COMMON_API TInterpolatorFinishedMessage : public TMessage
{
	TInterpolatorHandle m_InterpolatorHandle;


	TInterpolatorFinishedMessage(TInterpolatorHandle SInterpolatorHandle) :
		m_InterpolatorHandle(SInterpolatorHandle) {}	
};

#endif // interpolator_message_defs_h
