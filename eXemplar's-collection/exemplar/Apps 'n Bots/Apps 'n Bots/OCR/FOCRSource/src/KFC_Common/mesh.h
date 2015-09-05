#ifndef mesh_h
#define mesh_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_bitypes.h>
#include <KFC_KTL\varray.h>
#include "kfc_common_api.h"
#include "vector.h"
#include "matrix.h"

// -----
// Mesh
// -----
class KFC_COMMON_API TMesh
{
public:
	// Vertex
	struct TVertex
	{
		TVector3	m_Coords;
		TVector3	m_Normal;
		FPOINT		m_TextureCoords;
	};

	// Face
	struct TFace
	{
		size_t v1, v2, v3;

		void Set(size_t sv1, size_t sv2, size_t sv3)
			{ v1=sv1, v2=sv2, v3=sv3; }
	};

private:
	bool m_bAllocated;

	TValueArray<TVertex,	true> m_Vertices;
	TValueArray<TFace,		true> m_Faces;

	TVector3 m_MinCoords;
	TVector3 m_MaxCoords;
	
public:
	TMesh();

	~TMesh() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(size_t szNVertices, size_t szNFaces);

	TVertex*		GetVerticesDataPtr(size_t szIndex = 0);
	const TVertex*	GetVerticesDataPtr(size_t szIndex = 0) const;

	TFace*			GetFacesDataPtr(size_t szIndex = 0);
	const TFace*	GetFacesDataPtr(size_t szIndex = 0) const;

	void ReevaluateBounds();

	void AverageNormals(bool bNormalize = true);
	
	void NormalizeNormals();

	void CreateFace(const TVector3& Coord1,
					const TVector3& Coord2,
					const TVector3& Coord3);

	void CreateFlatGrid(const FPOINT&	Corner1,
						const FPOINT&	Corner2,
						size_t			szNXSegs = 1,
						size_t			szNYSegs = 1);

	// {{{ texture mapping

	// ---------------- TRIVIALS ----------------
	size_t GetNVertices	() const { return m_Vertices.	GetN(); }
	size_t GetNFaces	() const { return m_Faces.		GetN(); }
};

#endif // mesh_h
