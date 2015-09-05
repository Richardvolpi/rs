#ifndef _____IMAGE___H_____
#define _____IMAGE___H_____

#include <istream>
#include <ostream>
#include <vector>

class Region;

struct Point
{
	Point(int x1 = 0, int y1 = 0){x = x1; y = y1;}
	int x, y;

	bool operator != (const Point& p){ return (x != p.x) || (y != p.y);}
	bool operator == (const Point& p){ return (x == p.x) && (y == p.y);}
};


//This is a simple image
class Image
{
public:
	Image();
	Image(const Image& im);
	Image(int w, int h);
	virtual ~Image();

	bool load(const char* filename);
	bool load(const void* memory);

	friend std::ostream& operator<<(std::ostream& o, Image& im);
	friend std::istream& operator>>(std::istream& i, Image& im);

	unsigned char& operator()(int i, int j);

	unsigned long Width() const;
	unsigned long Height() const;

	void operator=(const Image& im);
	void remove(Region& reg);
	void add(const Region& reg);
	

	//this is the worst method I could implement to rotate an image, but it works well enough.
	//I wanted to implement a better method but it looks like I don't have to
	void rotate(float angle);//the angle is given in radians
	void scale(int newSizeX, int newSizeY); //scales the image to fit the new dimensions



	void center(float x_y_ratio);//the input is the ratio of x/y.
	    //The output will be an image with width/heigh = x_y_ratio. At first all the black pixels will be removed
		//from the image, leaving the minimum image that includes the white pixels. This image will 
	    //be centered into a minimum rectangle whose width/height ratio is x_y_ratio and includes it.

		

	Region* extract(unsigned int x, unsigned int y, bool eightWay = false);//returns a region that contains 
		//the point at (x,y). If eightWay is true the region will be 8-way connected. If not, it will be 4-way connected
		//This function does not remove the region from the image

	void clear(unsigned char color);

protected:

	float R(float);//auxiliary function for scaling

	void copy(const Image& i);

	void leaveMinimal();//crops the black borders of the image

    unsigned long width, height;
	unsigned char* image;

};


//this is an image with some additional information (an x and an y offset)
class Region: public Image
{
public:
	Region();
	Region(const Region& r);
	Region(int w, int h, int offsetX = 0, int offsetY = 0);
	~Region();

	unsigned int OffsetX() const;
	unsigned int OffsetY() const;

private:
	unsigned int offsetX, offsetY;
};



#endif