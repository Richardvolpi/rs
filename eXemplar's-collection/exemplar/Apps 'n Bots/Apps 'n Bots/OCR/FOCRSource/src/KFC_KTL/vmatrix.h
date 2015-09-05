#ifndef vmatrix_h
#define vmatrix_h

#include "basic_types.h"
#include "basic_bitypes.h"

// -------------
// Value matrix
// -------------
template <class t>
class TValueMatrix
{
private:
	bool m_bAllocated;

	t*		m_pData;
	SZSIZE	m_Size;

public:
	TValueMatrix();

	~TValueMatrix() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(const SZSIZE& SSize);

	void Transpose();

	void FlipHorizontal();

	void FlipVertical();
	
	t& GetDataRef(const SZPOINT& Coords)
	{
		DEBUG_VERIFY_ALLOCATION;

		DEBUG_VERIFY(Coords.x < m_Size.cx && Coords.y < m_Size.cy);

		return m_pData[Coords.y * m_Size.cx + Coords.x];
	}

	const t& GetDataRef(const SZPOINT& Coords) const
	{
		DEBUG_VERIFY_ALLOCATION;

		DEBUG_VERIFY(Coords.x < m_Size.cx && Coords.y < m_Size.cy);

		return m_pData[Coords.y * m_Size.cx + Coords.x];
	}

	t* GetDataPtr(const SZPOINT& Coords)
	{
		DEBUG_VERIFY_ALLOCATION;

		DEBUG_VERIFY(Coords.x < m_Size.cx && Coords.y < m_Size.cy);

		return m_pData + (Coords.y * m_Size.cx + Coords.x);
	}

	const t* GetDataPtr(const SZPOINT& Coords) const
	{
		DEBUG_VERIFY_ALLOCATION;

		DEBUG_VERIFY(Coords.x < m_Size.cx && Coords.y < m_Size.cy);

		return m_pData + (Coords.y * m_Size.cx + Coords.x);
	}

	t* GetDataPtr()
	{
		DEBUG_VERIFY_ALLOCATION;

		return m_pData;
	}

	const t* GetDataPtr() const
	{
		DEBUG_VERIFY_ALLOCATION;

		return m_pData;
	}

	t& operator () (size_t y, size_t x)
	{
		DEBUG_VERIFY_ALLOCATION;

		DEBUG_VERIFY(y < m_Size.cy && x < m_Size.cx);

		return m_pData[y * m_Size.cx + x];
	}

	const t& operator () (size_t y, size_t x) const
	{
		DEBUG_VERIFY_ALLOCATION;

		DEBUG_VERIFY(y < m_Size.cy && x < m_Size.cx);

		return m_pData[y * m_Size.cx + x];
	}

	// ---------------- TRIVIALS ----------------
	const SZSIZE& GetSize() const { return m_Size; }
};

template <class t>
TValueMatrix<t>::TValueMatrix()
{
	m_bAllocated = false;

	m_pData = NULL;
}

template <class t>
void TValueMatrix<t>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		delete[] m_pData, m_pData = NULL;
	}
}

template <class t>
void TValueMatrix<t>::Allocate(const SZSIZE& SSize)
{
	Release();

	try
	{
		m_Size = SSize;

		size_t szLength = m_Size.GetSquare();
		m_pData = szLength ? new t[szLength] : NULL;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class t>
void TValueMatrix<t>::Transpose()
{
	DEBUG_VERIFY_ALLOCATION;

	size_t y, x;
	t tmp;

	for(y = 0 ; y < m_Size.cy ; y++)
	{
		for(x = 0 ; x < y ; x++)
		{
			t& v1 = GetDataRef(SZPOINT(x, y));
			t& v2 = GetDataRef(SZPOINT(y, x));

			tmp = v1, v1 = v2, v2 = tmp;
		}
	}
}

template <class t>
void TValueMatrix<t>::FlipHorizontal()
{
	DEBUG_VERIFY_ALLOCATION;

	size_t y, x;
	t tmp;

	for(y = 0 ; y < m_Size.cy / 2 ; y++)
	{
		for(x = 0 ; x < m_Size.cx ; x++)
		{
			t& v1 = GetDataRef(SZPOINT(x, y));
			t& v2 = GetDataRef(SZPOINT(x, m_Size.cy - y - 1));

			tmp = v1, v1 = v2, v2 = tmp;
		}
	}
}

template <class t>
void TValueMatrix<t>::FlipVertical()
{
	DEBUG_VERIFY_ALLOCATION;

	size_t x, y;
	t tmp;

	for(x = 0 ; x < m_Size.cx / 2 ; x++)
	{
		for(y = 0 ; y < m_Size.cy ; y++)
		{
			t& v1 = GetDataRef(SZPOINT(x, y));
			t& v2 = GetDataRef(SZPOINT(m_Size.cx - x - 1, y));

			tmp = v1, v1 = v2, v2 = tmp;
		}
	}
}

#endif // vmatrix_h
