#include "stdafx.h"

#include "ImageTransform.h"

#include <vector>
#include <algorithm>
#include <functional>
#include <list>
#include <stack>

namespace ITHelperFuncs
{
	Point basePoint;

	bool sortPointFunc(Point& p1, Point& p2)
	{

		//Let the basepoint be P0. P1 < P2 if the angle between P0P1 and Ox is smaller
		//than the angle between P0P2 and Ox or if the angles are equal and P1 is farther
		//than P2 from P0. This will let me eliminate quickly the points with the same angle

		int y1, x1, x2, y2;

		x1 = p1.x - basePoint.x;
		y1 = p1.y - basePoint.y;

		x2 = p2.x - basePoint.x;
		y2 = p2.y - basePoint.y;

		if (y1 * x2 < y2 * x1)
		{
			return true;
		}
		if (y1 * x2 == y2 * x1)
		{
			return (x1 * x1 + y1 * y1 > x2 * x2 + y2 * y2);
		}

		return false;

	}

	bool areEqual(Point& p1, Point& p2)
	{
		int y1, x1, x2, y2;

		x1 = p1.x - basePoint.x;
		y1 = p1.y - basePoint.y;

		x2 = p2.x - basePoint.x;
		y2 = p2.y - basePoint.y;

		return (y1 * x2 == y2 * x1);

	}

};

std::vector<Point> ImageTransform::getConvexHull(std::vector<Point>& points)
{
	//this function implements the Graham's scan algorithm for finding the convex hull
	//Here is a link to some explanation: http://en.wikipedia.org/wiki/Graham_scan

	std::vector<Point> result;
	result.clear();

	//check to see if we have any points
	if (points.empty()) return result;

	//first find the lowest, leftmost point
	ITHelperFuncs::basePoint = points.front();

	std::vector<Point>::iterator it;

	for(it = points.begin(); it != points.end(); it++)
	{
		if (ITHelperFuncs::basePoint.y >= it->y)
		{
			//check for strict inequality
			if (ITHelperFuncs::basePoint.y > it->y)
			{
				ITHelperFuncs::basePoint = *it;
			}
			else
			{
				if (ITHelperFuncs::basePoint.x > it->x)
				{
					ITHelperFuncs::basePoint = *it;
				}
			}
		}
	}


	//now remove the basePoint

	for (it = points.begin(); it != points.end(); it++)
	{
		if (ITHelperFuncs::basePoint != *it)
		{
			result.push_back(*it);
		}
	}


	std::make_heap(result.begin(), result.end(), ITHelperFuncs::sortPointFunc);
	std::sort_heap(result.begin(), result.end(), ITHelperFuncs::sortPointFunc);

	//now look through the points and if two points have the same angle keep only 
	//the farthest point from the basePoint
	
	points.clear();

	Point current;

	if (result.empty())
	{
		//there is no point left

		//push the basepoint into result and return
		result.push_back(ITHelperFuncs::basePoint);
		return result;
	}

	it = result.begin();

	current = *it;

	points.push_back(current);

	do
	{
		//if the angles are not equal then insert the point in the vector
		if (!ITHelperFuncs::areEqual(current, *it))
		{
			current = *it;
			points.push_back(current);
		}
		it++;
	}while (it != result.end());


	//now walk this set 
	//the points will be kept in a stack

	it = points.begin();

	result.clear();

	result.push_back(ITHelperFuncs::basePoint);

	result.push_back(*it);
	it++;
//	result.push_back(*it);

	while(it != points.end())
	{
		if (info(result[result.size() - 2], result[result.size() - 1], *it) > 0)
		{
			//the new point should be included into the hull
			result.push_back(*it);
			it++;
		}
		else
		{
			//pop a point from the stack
			result.pop_back();
		}
	}

	return result;
}



int ImageTransform::info(Point& P0, Point& P1, Point& P2)
{
	return (P1.x - P0.x)*(P2.y - P0.y) - (P2.x - P0.x)*(P1.y - P0.y);
}


Rectangle ImageTransform::getMinAreaRectangle(Point& p0, Point& p1, std::vector<Point>& points)
{
	Rectangle res;
	res.area = -1.f;

	//this function assumes that P0 P1 is a segment from the convex hull !!!

	Line baseLine;
	Line baseLineParallel;
	Line perpendicular1, perpendicular2;
	baseLine.init(p0, p1);

	//now get the point that is farthest to the line
	float distance = baseLine.getDistance(points[0]);
	int index = 0;

	int i;
	for (i = 0; i < points.size(); i++)
	{
		float tmpDistance = baseLine.getDistance(points[i]);
		if (distance < tmpDistance)
		{
			distance = tmpDistance;
			index = i;
		}
	}

	//now index is the index of the farthest point from the line P0 P1
	if (distance < 10e-6) //the distance is 0
	{
		//error
		return res;
	}

	//if distance != 0 then draw a parallel line through the point

	baseLineParallel = baseLine.getParallel(points[index]);

	//now get a perpendicular on baseline and keep the points with the smallest and the greatest signed distance

	Line perp;

	perp = baseLine.getPerpendicular(points[index]);

	//scan for the point with the smallest and greatest signed distance

	int indexMin;
	int indexMax;
	float distMin;
	float distMax;

	indexMin = 0;
	indexMax = 0;
	distMin = perp.getSignedDistance(points[indexMin]);
	distMax = perp.getSignedDistance(points[indexMax]);

	for (i =0; i < points.size(); i++)
	{
		float tmpDist = perp.getSignedDistance(points[i]);
		if (distMin > tmpDist)
		{
			distMin = tmpDist;
			indexMin = i;
		}

		if (distMax < tmpDist)
		{
			distMax = tmpDist;
			indexMax = i;
		}
	}

	//we now have the 2 points

	perpendicular1 = perp.getParallel(points[indexMin]);
	perpendicular2 = perp.getParallel(points[indexMax]);

	res.l1 = baseLine;
	res.l2 = baseLineParallel;
	res.p1 = perpendicular1;
	res.p2 = perpendicular2;
	res.area = (distMax - distMin) * distance;

	return res;

}



Rectangle ImageTransform::getMinAreaRectangle(std::vector<Point>& points)
{

	points = getConvexHull(points);

	Rectangle res;
	res.area = -1.f;

	if (points.size() <= 2) 
	{
		return res;
	}

	int i;
	for (i = 0; i < points.size() - 2; i++)
	{
		Rectangle tmp = getMinAreaRectangle(points[i], points[i+1], points);
		if (tmp.area > 0)
		{
			if (res.area < 0)
			{
				res = tmp;
			}
			else
			{
				if (res.area > tmp.area)
				{
					res = tmp;
				}
			}
		}
	}

	//now consider the last point and the first point
	Rectangle tmp = getMinAreaRectangle(points[points.size() - 1], points[0], points);
	if (tmp.area > 0)
	{
		if (res.area < 0)
		{
			res = tmp;
		}
		else
		{
			if (res.area > tmp.area)
			{
				res = tmp;
			}
		}
	}

	return res;

}


