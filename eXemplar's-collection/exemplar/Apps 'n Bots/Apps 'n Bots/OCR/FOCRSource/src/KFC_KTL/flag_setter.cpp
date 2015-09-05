#include "kfc_ktl_pch.h"
#include "flag_setter.h"

// ------------
// Flag setter
// ------------
TFlagSetter::TFlagSetter(bool& bSFlag)
{
	*(m_pFlag = &bSFlag) = true;
}

TFlagSetter::~TFlagSetter()
{
	*m_pFlag = false;
}