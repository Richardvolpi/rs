#ifndef _____IMAGE_TRANSFORM___H_____
#define _____IMAGE_TRANSFORM___H_____

#include "Image.h"
#include <vector>
#include "Line.h"

class Rectangle
{
public:
	Line l1, l2, p1, p2;
	float area;
};



class ImageTransform
{
public:
	ImageTransform(){};
	~ImageTransform(){};

	Rectangle getMinAreaRectangle(std::vector<Point>& r);
//private:

	std::vector<Point> getConvexHull(std::vector<Point>& r);

	//returns 
	//        < 0 if p2 is to the right of the segment p0 p1
	//        = 0 if p2 is on the line  =||=
	//        > 0 if p2 is to the left  =||=
	int info(Point& p0, Point &p1, Point& p2);

	Rectangle getMinAreaRectangle(Point& p0, Point& p1, std::vector<Point>& points);


	
};


#endif


