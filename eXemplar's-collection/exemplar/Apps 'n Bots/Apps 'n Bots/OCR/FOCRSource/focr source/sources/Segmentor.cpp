#include "stdafx.h"
#include "Segmentor.h"

#include <math.h>
#include <algorithm>
#include <functional>

Segmentor::Segmentor()
{
	letters.clear();
	rectangles.clear();
}

Segmentor::~Segmentor()
{
	clearLetters();
}


void Segmentor::clearLetters()
{
	std::vector<Region*>::iterator it;

	for(it = letters.begin(); it != letters.end(); it++)
	{
		delete (*it);
	}

	letters.clear();
}

void Segmentor::process(Image& im)
{

	clearLetters();
	rectangles.clear();

	Image tmpIm(im);

	unsigned int i, j;

	for (i = 0; i < im.Height(); i++)
	{
		for(j = 0; j < im.Width(); j++)
		{
			if (tmpIm(j,i) == 255)
			{
				//find the region
				Region* r = tmpIm.extract(j,i, true);

				//remove it from the image
				tmpIm.remove(*r);
				
				//push the region on the vector
				letters.push_back(r);

				//now find the rectangle
				rectangles.push_back(getRegionRectangle(*r));

			}
		}
	}

	joinRegions(&Segmentor::smallRegionsCrowdingCriterion);
	joinRegions(&Segmentor::overlapCriterion);

	sortLetters();

	buildRectangles();

}


Rectangle Segmentor::getRegionRectangle(Region& r)
{
	std::vector<Point> input;
	input.clear();

	unsigned int i, j;
	for (i = 0; i < r.Height(); i++)
	{
		for (j = 0; j < r.Width(); j++)
		{
			if (r(j, i) == 255)
			{
				input.push_back(Point(j,i));
			}
		}
	}

	return imt.getMinAreaRectangle(input);
}


int Segmentor::getNrOfLetters()
{
	return (int)letters.size();
}


Image Segmentor::getLetter(int imageNo, bool rotated)
{
	rotated = true;

	Image tmp(1, 1);

	if (imageNo < 0) return tmp;
	if (imageNo >= letters.size()) return tmp;

	tmp = *letters[imageNo];

	//now rotate the image if necessary
	if (rotated)
	{

		Rectangle r = getRectangle(imageNo);

		if (r.area > 0)
		{
			float angle;

			float a1 = r.l1.angle();
			float a2 = r.p1.angle();

			if (fabs((float)r.l1.angle()) < fabs((float)r.p1.angle()))
			{
				angle = r.l1.angle();
			}
			else
			{
				angle = r.p1.angle();
			}

//			tmp.scale(tmp.Width() * 2, tmp.Height() * 2);
			tmp.rotate(-angle);
//			tmp.scale(tmp.Width() / 2, tmp.Height() / 2);		
		}
	}


//	tmp.center(1.f);

//	tmp.scale(10, 10);

	return tmp;

}

Rectangle Segmentor::getRectangle(int imageNo)
{
	Rectangle tmp;
	tmp.area = -1.f;

	if (imageNo < 0) return tmp;
	if (imageNo >= letters.size()) return tmp;

    Rectangle r = rectangles[imageNo];
	if (r.area < 0) return r;
	int deltaX, deltaY;
	deltaX = letters[imageNo]->OffsetX();
	deltaY = letters[imageNo]->OffsetY();
	r.l1.translate(deltaX, deltaY);
	r.l2.translate(deltaX, deltaY);
	r.p1.translate(deltaX, deltaY);
	r.p2.translate(deltaX, deltaY);

	return r;

}



void Segmentor::joinRegions(JoiningCriterionT joinCritFunc)
{
	std::vector<int> regionId;

	regionId.resize(letters.size());

	int i;
	for (i = 0; i < regionId.size(); i++)
	{
		regionId[i] = i;
	}


	int j;
	for (i = 0; i < letters.size(); i++)
	{
		for (j = i + 1; j < letters.size(); j++)
		{
			if (((*this).*joinCritFunc)(letters[i], letters[j]))
			{
				regionId[j] = regionId[j] < regionId[i] ? regionId[j] : regionId[i];
				regionId[i] = regionId[j];
			}
		}
	}

	collapse(regionId);
}


bool Segmentor::overlapCriterion(Region* r1, Region* r2)
{
	float overlapFactor = 0.3;
	return ((overlap(r1, r2) >= overlapFactor) || (overlap(r2, r1) >= overlapFactor));
}

bool Segmentor::smallRegionsCrowdingCriterion(Region* r1, Region* r2)
{
	if ((r1->Width() >= 8) || (r1->Height() >= 8) || (r2->Width() >= 8) || (r2->Height() >= 8))
	{
		//they are not small regions
		return false;
	}

	int x1, x2, y1, y2;

	x1 = r1->OffsetX() + r1->Width() / 2;
	x2 = r2->OffsetX() + r2->Width() / 2;

	y1 = r1->OffsetY() + r1->Height() / 2;
	y2 = r2->OffsetY() + r2->Height() / 2;

	if (abs(x2 - x1) + abs(y1 - y2) < 15) return true;

	return false;

}

void Segmentor::buildRectangles()
{
	rectangles.clear();
	int i;
	for (i = 0; i < letters.size(); i++)
	{
		rectangles.push_back(getRegionRectangle(*(letters[i])));
	}
}

void Segmentor::collapse(std::vector<int>& regionId)
{
	if (regionId.size() != letters.size()) return;

	std::vector<Region*>* regList = new std::vector<Region*>[letters.size()];

	int i;
	for (i = 0; i < letters.size(); i++)
	{
		regList[i].clear();
	}

	//now fill regList

	for (i = 0; i < regionId.size(); i++)
	{
		regList[regionId[i]].push_back(letters[i]);
	}

	//now collapse the regions
	std::vector<Region*> tmpLetters;
	tmpLetters.clear();
	
	for (i = 0; i < regionId.size(); i++)
	{
		if (regList[i].size() > 0)
		{
			tmpLetters.push_back(collapse(regList[i]));
		}
	}

	delete[] regList;

	clearLetters();
	letters = tmpLetters;

}

float Segmentor::overlap(Region* r1, Region* r2)
{

    int oX, oY;
    
	int r1minX = r1->OffsetX();
	int r1maxX = r1->OffsetX() + r1->Width();

	int r2minX = r2->OffsetX();
	int r2maxX = r2->OffsetX() + r2->Width();

	if (r1maxX < r2minX) return 0;
    if (r1minX > r2maxX) return 0;

    if (r1minX >= r2minX)
    {

        if(r1maxX <= r2maxX)
        {

            oX = r1maxX - r1minX + 1;

        }
        else
        {

            oX = r2maxX - r1minX + 1;

        }

    }
    else
    {

        if (r1maxX <= r2maxX)
        {

            oX = r1maxX - r2minX + 1;

        }
        else
        {

            oX = r2maxX - r2minX + 1;

        }

    }
    

    return (float)oX/(r2maxX - r2minX + 1);

}





Region* Segmentor::collapse(std::vector<Region*>& regs)
{
	if (regs.size() == 0) return NULL;
	//adds more regions together
	int minX, maxX, minY, maxY;

	minX = regs[0]->OffsetX();
	minY = regs[0]->OffsetY();

	maxX = minX + regs[0]->Width();
	maxY = minY + regs[0]->Height();

	int i;
	for (i = 0; i < regs.size(); i++)
	{
		if (regs[i]->OffsetX() < minX) minX = regs[i]->OffsetX();
		if (regs[i]->OffsetY() < minY) minY = regs[i]->OffsetY();

		if (regs[i]->OffsetX() + regs[i]->Width()  > maxX) maxX = regs[i]->OffsetX() + regs[i]->Width();
		if (regs[i]->OffsetY() + regs[i]->Height() > maxY) maxY = regs[i]->OffsetY() + regs[i]->Height();
	}

	//now minX, maxX, minY, maxY define a rectangle that includes all the regions

	//add all the regions to the new region
	Region* tmpReg = new Region(maxX - minX + 1, maxY - minY + 1, minX, minY);

	tmpReg->clear(0);

	int j, k;

	for (k = 0; k < regs.size(); k++)
	{
		for (i = 0; i < regs[k]->Height(); i++)
		{
			for (j = 0; j < regs[k]->Width(); j++)
			{
				if ((*regs[k])(j,i) != 0)
				{
					(*tmpReg)(j + regs[k]->OffsetX() - minX, i + regs[k]->OffsetY() - minY) = (*regs[k])(j,i);
				}
			}
		}
	}

	return tmpReg;

}


bool lettersSortFunc(Region* r1, Region* r2)
{
	return r1->OffsetX() < r2->OffsetX();
}

void Segmentor::sortLetters()
{
	std::sort(letters.begin(), letters.end(), lettersSortFunc);
}