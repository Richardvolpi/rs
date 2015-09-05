#ifndef data_alignment_h
#define data_alignment_h

#define DATA_ALIGNMENT	(sizeof(void*))

#define ALIGN_DATA_SIZE(Value)	(((Value) += (DATA_ALIGNMENT - 1)) &= ~(DATA_ALIGNMENT - 1))

#endif // data_alignment_h