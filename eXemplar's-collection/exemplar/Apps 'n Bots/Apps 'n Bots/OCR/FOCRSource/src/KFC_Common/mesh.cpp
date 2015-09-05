#include "kfc_common_pch.h"
#include "mesh.h"

#include <KFC_KTL\bounding.h>

// -----
// Mesh
// -----
TMesh::TMesh()
{
	m_bAllocated = false;
}

void TMesh::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		m_Vertices.	Release();
		m_Faces.	Release();
	}
}

void TMesh::Allocate(size_t szNVertices, size_t szNFaces)
{
	Release();

	try
	{
		DEBUG_VERIFY(szNVertices > 0 && szNFaces > 0);

		m_Vertices.	Allocate(szNVertices),	m_Vertices.	Add(szNVertices);
		m_Faces.	Allocate(szNFaces),		m_Faces.	Add(szNFaces);

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

TMesh::TVertex* TMesh::GetVerticesDataPtr(size_t szIndex)
{
	DEBUG_VERIFY_ALLOCATION;
	
	return m_Vertices.GetDataPtr(szIndex);
}

const TMesh::TVertex* TMesh::GetVerticesDataPtr(size_t szIndex) const
{
	DEBUG_VERIFY_ALLOCATION;
	
	return m_Vertices.GetDataPtr(szIndex);
}

TMesh::TFace* TMesh::GetFacesDataPtr(size_t szIndex)
{
	DEBUG_VERIFY_ALLOCATION;

	return m_Faces.GetDataPtr(szIndex);
}

const TMesh::TFace* TMesh::GetFacesDataPtr(size_t szIndex) const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_Faces.GetDataPtr(szIndex);
}

void TMesh::ReevaluateBounds()
{
	DEBUG_VERIFY_ALLOCATION;

	m_MinCoords = m_MaxCoords = m_Vertices[0].m_Coords;
	for(size_t i = 1 ; i < m_Vertices.GetN() ; i++)
	{
		const TVector3& Coords = m_Vertices[i].m_Coords;

		if(Coords.x < m_MinCoords.x)
			m_MinCoords.x = Coords.x;
		if(Coords.y < m_MinCoords.y)
			m_MinCoords.y = Coords.y;
		if(Coords.z < m_MinCoords.z)
			m_MinCoords.z = Coords.z;

		if(Coords.x > m_MaxCoords.x)
			m_MaxCoords.x = Coords.x;
		if(Coords.y > m_MaxCoords.y)
			m_MaxCoords.y = Coords.y;
		if(Coords.z > m_MaxCoords.z)
			m_MaxCoords.z = Coords.z;
	}
}

void TMesh::AverageNormals(bool bNormalize)
{
	DEBUG_VERIFY_ALLOCATION;

	size_t i;

	TVertex*		pVertex;
	const TFace*	pFace;

	pVertex = m_Vertices.GetDataPtr();
	for(i = m_Vertices.GetN() ; i ; i--, pVertex++)
		pVertex->m_Normal.Set(0.0f, 0.0f, 0.0f);

	// Summing
	pFace = m_Faces.GetDataPtr();
	for(i = m_Faces.GetN() ; i ; i--, pFace++)
	{
		TVertex& Vertex1 = m_Vertices[pFace->v1];
		TVertex& Vertex2 = m_Vertices[pFace->v2];
		TVertex& Vertex3 = m_Vertices[pFace->v3];

		const TVector3& Coords1 = Vertex1.m_Coords;
		const TVector3& Coords2 = Vertex2.m_Coords;
		const TVector3& Coords3 = Vertex3.m_Coords;

		TVector3 FaceNormal = (Coords2 - Coords1) * (Coords3 - Coords1);

		Vertex1.m_Normal += FaceNormal;
		Vertex2.m_Normal += FaceNormal;
		Vertex3.m_Normal += FaceNormal;
	}

	// Normalizing
	if(bNormalize)
		NormalizeNormals();
}

void TMesh::NormalizeNormals()
{
	DEBUG_VERIFY_ALLOCATION;

	TVertex* pVertex = GetVerticesDataPtr();
	for(size_t i = m_Vertices.GetN() ; i ; i--, pVertex++)
		pVertex->m_Normal.Normalize();
}

void TMesh::CreateFace(	const TVector3& Coord1,
						const TVector3& Coord2,
						const TVector3& Coord3)
{
	Release();

	try
	{
		Allocate(3, 1);

		// Vertices
		m_Vertices[0].m_Coords = Coord1;
		m_Vertices[1].m_Coords = Coord2;
		m_Vertices[2].m_Coords = Coord3;

		// Faces
		m_Faces[0].Set(0, 1, 2);

		// Processing
		ReevaluateBounds();
		AverageNormals	();
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TMesh::CreateFlatGrid(	const FPOINT&	Corner1,
							const FPOINT&	Corner2,
							size_t			szNXSegs,
							size_t			szNYSegs)
{
	Release();

	try
	{
		DEBUG_VERIFY(szNXSegs > 0 && szNYSegs > 0);

		Allocate((szNXSegs + 1) * (szNYSegs + 1), (szNXSegs * szNYSegs) << 1);

		size_t x, y;

		// Vertices
		float yc = BOUNDC(0, szNYSegs, Corner1.y, Corner2.y);
		float xc = BOUNDC(0, szNXSegs, Corner1.x, Corner2.x);

		TVertex* pVertex = m_Vertices.GetDataPtr();

		for(y=0 ; y<=szNXSegs ; y++)
		{
			float cy = BOUNDR(y, 0, Corner1.y, yc);

			for(x=0 ; x<=szNXSegs ; x++)
			{
				float cx = BOUNDR(x, 0, Corner1.x, xc);
				
				pVertex->m_Coords.Set(cx,	cy,		0.0f);
				pVertex++;
			}
		}

		// Faces
		TFace* pFace = m_Faces.GetDataPtr();

		for(y=0 ; y<szNYSegs ; y++)
		{
			size_t szIndex = y * (szNXSegs + 1);
			for(x=0 ; x<szNXSegs ; x++, szIndex++)
			{
				pFace++->Set(szIndex,		szIndex + 1,			szIndex + szNXSegs + 1);
				pFace++->Set(szIndex + 1,	szIndex + szNXSegs + 1,	szIndex + szNXSegs + 2);
			}
		}

		// Processing
		ReevaluateBounds();
		AverageNormals	();
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}
