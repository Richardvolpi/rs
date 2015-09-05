#ifndef ___SEGMENTOR___H_____
#define ___SEGMENTOR___H_____


#include "Image.h"
#include "ImageTransform.h"

//this class does what its name states: it segments an image and returns 
//the letters 

class Segmentor;

typedef bool (Segmentor::*JoiningCriterionT)(Region* r1, Region* r2);//this returns true if the regions should be joined
			//and false if they shouldn't


class Segmentor
{
public:
	Segmentor();
	~Segmentor();

	void setOutputDimensions(int width, int height);

	void process(Image& im);//this segments the image

	int getNrOfLetters(); //returns the number of letters obtained after the segmentation
	Rectangle getRectangle(int imageNo); //this gets the rectangle enclosing a letter (for display purposes)
	Image getLetter(int imageNo, bool rotated = false);//returns the image of the letter. The image is rotated if necessary
								//and also scaled

private:

	void sortLetters();


	void joinRegions(JoiningCriterionT joinCritFunc);//joins the regions together to form the letters
	bool overlapCriterion(Region* r1, Region* r2);
	bool smallRegionsCrowdingCriterion(Region* r1, Region* r2);


	float overlap(Region* r1, Region* r2); //returns how much r2 overlaps with r1 on the x axis
	void collapse(std::vector<int>& regionId);//collapse the regions into less regions based on regionId
	Region* collapse(std::vector<Region*>& regs);

	void buildRectangles();

	ImageTransform imt;

	std::vector<Region*> letters;
	std::vector<Rectangle> rectangles;

	void clearLetters();

	Rectangle getRegionRectangle(Region& r);

};


#endif