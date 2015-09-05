#ifndef memory_stream_h
#define memory_stream_h

// --------------
// Memory stream
// --------------
class TMemoryStream : public TStream
{
private:
	TValueArray<BYTE, true> m_Data;

	size_t m_szOffset;


	TMemoryStream();

public:
	TMemoryStream(const TArrayAllocation& Allocation);

	void StreamRead(void* pRData, size_t szLength);

	void StreamWrite(const void* pData, size_t szLength);

	void Clear();

	void Rewind();

	const void* GetDataPtr() const
		{ return m_Data.GetDataPtr(); }

	size_t GetN() const
		{ return m_Data.GetN(); }
};

#endif // memory_stream_h