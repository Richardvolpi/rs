#ifndef ____LINE__H____
#define ____LINE__H____

#include "Image.h"

//this class will help me find the minimal area encasing rectangle. 
class Line
{
public:
	Line();
	~Line();

	bool init(Point& p1, Point& p2); //creates the line that passes between those two points

	bool isOnLine(Point& p);//returns true if "p" is contained by the line

	Line getParallel(Point& p);//returns a line parallel to this line and passes through the point "p"
	Line getPerpendicular(Point& p);//returns a line that is perpendicular to this line and passes through "p"

	int getSign(Point& p); //returns 0 if p is on the line, +1 if p is in one semiplane and -1 if it is in the other

	float getDistance(Line& l);//gets the distance between those two lines (they have to be parallel
	float getSignedDistance(Point& p);
	float getDistance(Point& p);

	void translate(int deltaX, int deltaY);//translates the line 

	Point intersect(Line& l);

	float angle();//returns the angle this line is making with the Line: x = 0;

private:
	int a, b, c;//the equation is ax + by + c = 0




};


#endif