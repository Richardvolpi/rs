#include "stdafx.h"
#include "Line.h"

#include <math.h>

Line::Line()
{
	a = 0;
	b = 0;
	c = 0;
}

Line::~Line()
{
}

bool Line::init(Point& p1, Point& p2)
{
	if (p1 == p2)
	{
		a = 1;
		b = 0;
		c = -p1.x;
		return true;

	}
	a = p1.y - p2.y;
	b = p2.x - p1.x;
	c = p1.x * p2.y - p1.y * p2.x;

	if ((a == 0) && (b == 0) && (c == 0)) return false;

	return true;
}

bool Line::isOnLine(Point& p)
{
	int res = a * p.x + b * p.y + c;

	return (res == 0);
}

Line Line::getParallel(Point& p)
{
	Line tmp;

	tmp.a = a;
	tmp.b = b;
	tmp.c = -tmp.a * p.x - tmp.b * p.y;

	return tmp;
}

Line Line::getPerpendicular(Point& p)
{
	Line tmp;

	tmp.a = -b;
	tmp.b = a;
	tmp.c = -tmp.a * p.x - tmp.b * p.y;

	return tmp;
}

int Line::getSign(Point& p)
{
	int tmp = a * p.x + b * p.y + c;

	if (tmp < 0) return -1;
	if (tmp > 0) return 1;
	return 0;
}

float Line::getDistance(Line& l)
{
	float x, y;

	//choose a point on the line
	if (b != 0)
	{
		x = 0.f;
		y = (float)(-c) / (float)b;
	}
	else
	{
		y = 0.f;
		x = (float)(-c) / (float)a;
	}

	return fabs((float)a * (float)x + (float)b *(float)y + (float)c) / 
			sqrt((float)a * (float)a + (float)b * (float)b);



}

float Line::getSignedDistance(Point& p)
{
	return ((float)a * (float)p.x + (float)b *(float)p.y + (float)c) / 
		sqrt((float)a * (float)a + (float)b * (float)b);
}


float Line::getDistance(Point& p)
{
	return fabs(getSignedDistance(p));
}


Point Line::intersect(Line& l)
{
	float x, y;
	x = ((float)c * (float)l.b - (float)l.c * (float)b)/((float)l.a * (float)b - (float)a * (float)l.b);
	y = ((float)c * (float)l.a - (float)l.c * (float)a)/((float)a * (float)l.b - (float)l.a * (float)b);

	return Point(x, y);
}

void Line::translate(int deltaX, int deltaY)
{
	c -= deltaX * a + deltaY * b;
}


float Line::angle()
{
	
	if (b == 0) return 0.f;

	if (a == 0)
	{
		if (b > 0) return acos(0.f);
		return -acos(0.f);
	}

	return atan(-(float)b/(float)a);
}
