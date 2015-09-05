#include "stdafx.h"

#include "Image.h"

#include <windows.h>
#include <stdio.h>
#include <stack>

#include <assert.h>
#include <math.h>



Image::Image()
{
	width = 0;
	height = 0;
	image = NULL;
}

Image::Image(const Image& im)
{
	width = -1;
	height = -1;
	image = NULL;
	copy(im);
}


Image::Image(int w, int h)
{
	width = w;
	height = h;

	image = new unsigned char[w * h];
}

Image::~Image()
{
	if (image != NULL) delete image;
}


void Image::operator =(const Image& im)
{
	copy(im);
}


void Image::copy(const Image& im)
{
	if ((width != im.width) || (height != im.height))
	{
		width = im.width; 
		height = im.height;

		if (image != NULL) delete image;
		image = new unsigned char[width * height];
	}

	memcpy(image, im.image, width * height);
}

unsigned long Image::Height() const 
{
	return height;
}

unsigned long Image::Width() const 
{
	return width;
}


void Image::clear(unsigned char color)
{
	unsigned int i;
	for (i = 0; i < width * height; i++)
	{
		image[i] = color;
	}
}

unsigned char& Image::operator ()(int i, int j)
{
	assert(i >= 0);
	assert(j >= 0);
	assert(i < width);
	assert(j < height);

	return image[j * width + i];
}


bool Image::load(const char* filename)
{

const short BITMAP_MAGIC_NUMBER=19778;
const int RGB_BYTE_SIZE=3;

#pragma pack(push,bitmap_data,1)

typedef struct tagRGBQuad {
	char rgbBlue;
	char rgbGreen;
	char rgbRed;
	char rgbReserved;
} RGBQuad;

typedef struct tagBitmapFileHeader {
	unsigned short bfType;
	unsigned int bfSize;
	unsigned short bfReserved1;
	unsigned short bfReserved2;
	unsigned int bfOffBits;
} BitmapFileHeader;

typedef struct tagBitmapInfoHeader {
	unsigned int biSize;
	int biWidth;
	int biHeight;
	unsigned short biPlanes;
	unsigned short biBitCount;
	unsigned int biCompression;
	unsigned int biSizeImage;
	int biXPelsPerMeter;
	int biYPelsPerMeter;
	unsigned int biClrUsed;
	unsigned int biClrImportant;
} BitmapInfoHeader;

#pragma pack(pop,bitmap_data)


    BitmapFileHeader bmfh;
    BitmapInfoHeader bmih;


    FILE *in;                  //file stream for reading
    unsigned char *tempData;       //temp storage for image data


    //open the file for reading in binary mode
    in=fopen(filename,"rb");

    //if the file does not exist return in error
    if(in==NULL) {
        //error="File not found";
        fclose(in);
        return false;
    }

    //read in the entire BITMAPFILEHEADER
    fread(&bmfh,sizeof(BitmapFileHeader),1,in);
    //check for the magic number that says this is a bitmap
    if(bmfh.bfType!=BITMAP_MAGIC_NUMBER) {
        fclose(in);
        return false;
    }

    //read in the entire BITMAPINFOHEADER
    fread(&bmih,sizeof(BitmapInfoHeader),1,in);

    //save the width, height and bits per pixel for external use
    width=bmih.biWidth;
    height=bmih.biHeight;
    int bpp=bmih.biBitCount;

	if (bpp != 1) return false;

	RGBQuad colors[2];

	fread(&colors, sizeof(RGBQuad), 2, in);

	//calculate the size of the image data with padding
	
	//first calculate the size of one row
	int rowSize = width / 8;
	if ((width % 8) != 0) rowSize++;

	//adjust the row size to the next multiple of 4 bytes
	if ((rowSize % 4) != 0) 
	{
		rowSize += 4 - (rowSize % 4);
	}
    int dataSize=height * rowSize;

    //set up the temporary buffer for the image data
    tempData=new unsigned char[dataSize];

    //exit if there is not enough memory
    if(tempData==NULL) {
        fclose(in);
        return false;
    }

    //read in the entire image
    fread(tempData,sizeof(char),dataSize,in);

    //close the file now that we have all the info
    fclose(in);


	if (image != NULL) delete image;
	image = new unsigned char[width * height];

	unsigned int i;
	unsigned int j;

	for (i = 0; i < height; i++)
	{
		for (j = 0; j < width; j++)
		{
			unsigned char tmp = (tempData[i * rowSize + (j / 8)] >> (7 - j % 8)) & 1;
			if (tmp == 0)
			{
				this->operator ()(j,i) = 0;
			}
			else
			{
				this->operator ()(j,i) = 255;
			}
		}
	}


    //clean up memory
    delete[] tempData;


    //return success
    return true;
}



Region* Image::extract(unsigned int x, unsigned int y, bool eightWay)
{
	Image tmpImage(width, height);

	if ((x < 0) || (y < 0) || ( x >= width) || (y >= height))	return NULL;

	if (this->operator ()(x, y) != 255)
	{
		return NULL;
	}

	//if the pixel at (x, y) is white, then we can do a flood fill



	tmpImage.clear(0);


	int minX, maxX, minY, maxY;


	std::stack<Point> floodStack;
	
	Point p(x, y);

	minX = p.x;
	maxX = p.x;
	minY = p.y;
	maxY = p.y;

	tmpImage(p.x, p.y) = 255;

	floodStack.push(p);

	do
	{
		p = floodStack.top();
		floodStack.pop();

		//now push all unvisited neighbours on stack
		int i, j;
		for (i = -1; i <= 1; i++)
		{
			for (j = -1; j <= 1; j++)
			{
				if (((signed int)(p.x + i) < 0) || ((signed int)(p.y + j) < 0) || ( (p.x + i) >= width) || ((p.y + j) >= height))
				{
					continue;
				}

				if (!eightWay)
				{
					if ((i != 0) && (j != 0))
					{
						continue;
					}
				}

				//now add that point
				if ((tmpImage(p.x + i, p.y + j) != 255) && (this->operator ()(p.x + i, p.y + j) == 255))
				{
					//mark it as visited
					tmpImage(p.x + i, p.y + j) = 255;

					//and add it
					floodStack.push(Point(p.x + i, p.y + j));

					//now update the min and max

					if (p.x + i < minX) minX = p.x + i;
					if (p.x + i > maxX) maxX = p.x + i;

					if (p.y + j < minY) minY = p.y + j;
					if (p.y + j > maxY) maxY = p.y + j;
				}
			}
		}


	}while (!floodStack.empty());


	//now we know the flood fill is included in the rectable delimited by minX, maxX, minY, maxY

	//This will be the region that we'll return
	Region* r = new Region(maxX - minX + 1, maxY - minY + 1, minX, minY);

	int i, j;
	for (j = minY; j <= maxY; j++)
	{
		for (i = minX; i <= maxX; i++)
		{
			(*r)(i - minX, j - minY) = tmpImage(i, j);
		}
	}

	return r;

}



void Image::remove(Region& reg)
{
	int minX, minY, maxX, maxY;

	minX = reg.OffsetX();
	minY = reg.OffsetY();

	maxX = width < minX + reg.Width() ? width : minX + reg.Width();
	maxY = height < minY + reg.Height() ? height : minY + reg.Height();

	int i, j;

	for (j = minY; j < maxY; j++)
	{
		for (i = minX; i < maxX; i++)
		{
			if (reg(i - minX, j - minY) == 255)
			{
				this->operator ()(i, j) = 0;
			}
		}
	}

}


void Image::rotate(float angle)
{
	float minX, maxX, minY, maxY; //these are the limits of the rotated image

	float x, y;

	float sina, cosa;

	sina = sin(angle);
	cosa = cos(angle);

	//this is the first point (0,0)
	minX = 0.f;
	maxX = 0.f;
	minY = 0.f;
	maxY = 0.f;



	//check where the second point will go (0,height)
	x = sina * (float)height;
	y = cosa * (float)height;

	if (minX > x) minX = x;
	if (maxX < x) maxX = x;
	if (minY > y) minY = y;
	if (maxY < y) maxY = y;

	
	//check where the third point will go (width, height)

	x =  cosa * (float)width + sina * (float)height;
	y = -sina * (float)width + cosa * (float)height;

	if (minX > x) minX = x;
	if (maxX < x) maxX = x;
	if (minY > y) minY = y;
	if (maxY < y) maxY = y;


	//check where the fourth point will go (width, 0)

	x =  cosa * (float)width;
	y = -sina * (float)width;

	if (minX > x) minX = x;
	if (maxX < x) maxX = x;
	if (minY > y) minY = y;
	if (maxY < y) maxY = y;


	//round minimums towards -\infty and maximums towards +\infty

	minX = floor(minX);
	minY = floor(minY);

	maxX = ceil(maxX);
	maxY = ceil(maxY);

	Image tmpIm(maxX - minX, maxY - minY);

	tmpIm.clear(0);

	float i, j;

	for (i = 0; i < maxY - minY; i++)
	{
		for (j = 0; j < maxX - minX; j++)
		{
			x =  cosa * (j + minX) - sina * (i + minY);
			y =  sina * (j + minX) + cosa * (i + minY);

			//see if x and y arewithin the image
			int xx, yy;
			xx = x;
			yy = y;

			if ((xx < 0) || (yy < 0) || (xx >= width) || (yy >= height)) continue;

			//if we got here then xx and yy are valid
			tmpIm(j,i) = this->operator ()(xx, yy);

		}
	}

	(*this) = tmpIm;

}


void Image::center(float x_y_ratio)
{
	//first remove the black borders
	leaveMinimal();

	//then find the enclosing rectangle
	float x, y;
	float w1, h1;

	w1 = width;
	h1 = height;
	if ((float)width < (float) height * x_y_ratio)
	{
		w1 = (float)height * x_y_ratio;
	}
	else
	{
		h1 = (float)width / (float)x_y_ratio;
	}

	//now w1 and h1 are the dimensions of the new image
	w1 = ceil(w1);
	h1 = ceil(h1);

	Image tmpIm(w1 ,h1);

	//now find the x and y offsets of the original image in the new image
	float offsetX, offsetY;

	offsetX = ((float)w1 - (float)width) / 2.f;
	offsetY = ((float)h1 - (float)height) / 2.f;

	int i, j;
	tmpIm.clear(0);
	for (i = 0; i < height; i++)
	{
		for (j = 0; j < width; j++)
		{
			tmpIm(j + offsetX, i + offsetY) = this->operator ()(j, i);
		}
	}

	(*this) = tmpIm;
}


void Image::leaveMinimal()
{
	int minX = width, minY = height, maxX = -1, maxY = -1;

	int i, j;
	for (i = 0;i < height; i++)
	{
		for (j = 0; j < width; j++)
		{
			if (this->operator ()(j, i) != 0)
			{
				if (j < minX) minX = j;
				if (j > maxX) maxX = j;
				if (i < minY) minY = i;
				if (i > maxY) maxY = i;
			}
		}
	}

	if (minX < width) //then we have at least a point that is not black
	{
		Image tmpIm(maxX - minX + 1, maxY - minY + 1);
		tmpIm.clear(0);

		//now copy the part of the image to tmpIm;
		int i, j;
		for (i = 0; i < maxY - minY + 1; i++)
		{
			for (j = 0; j < maxX - minX + 1; j++)
			{
				tmpIm(j, i) = this->operator ()(j + minX, i + minY);
			}
		}

		(*this) = tmpIm;
	}
	else
	{
		//the image is all black.
		Image tmpIm(1, 1);
		tmpIm.clear(0);
		(*this) = tmpIm;
	}

}



float Image::R(float x)
{

  float a, b, c, d;

  // Implement Eq 4.3-5 in four parts
  
  if((x + 2.0F) <= 0.0F) {
    a = 0.0F;
  }
  else {
    a = pow((x + 2.0F), 3.0F);
  }


  if((x + 1.0F) <= 0.0F) {
    b = 0.0F;
  }
  else {
    b = pow((x + 1.0F), 3.0F);
  }    

  if(x <= 0) {
    c = 0.0F;
  }
  else {
    c = pow(x, 3.0F);
  }  

  if((x - 1.0F) <= 0.0F) {
    d = 0.0F;
  }
  else {
    d = pow((x - 1.0F), 3.0F);
  }
  
  return (1.f/6.f * (a - (4.0F * b) + (6.0F * c) - (4.0F * d)));


}


void Image::scale(int sizeX, int sizeY)
{
	Image tmpImage(sizeX, sizeY);

    int ip, jp,m,n;
    float x, y, dx, dy;
	int i, j;

    for (ip = 0; ip < sizeY; ip++)
    {

        for (jp = 0; jp < sizeX; jp++)
        {

            x = (float)jp * (float)width / (float)sizeX;
            dx = x - floor(x);
            j = (int)floor(x);

            y = (float)ip * (float)height / (float)sizeY;
            dy = y - floor(y);
            i = (int)floor(y);

            float res = 0;

            for (m = -1; m <= 2; m++)
            {

                for (n = -1; n <= 2; n++)
                {

					unsigned char val;
					int yy = i + m;
					int xx = j + n;

					//xx = xx < 0 ? 0 : xx;
					if (xx < 0) xx = 0;
					xx = xx >= width ? width - 1 : xx;

					yy = yy < 0 ? 0 : yy;
					yy = yy >= height ? height - 1 : yy;

                    res += (*this)(xx, yy) * R(n - dx) * R(m - dy);

                }

            }

            tmpImage(jp,ip) = (unsigned char)res;
        }

    }


	(*this) = tmpImage;

}



//serialization routines
std::ostream& operator<<(std::ostream& os, Image& im)
{
	if (im.image != NULL)
	{
		os << im.width << " " << im.height;

		//now write the actual data
		unsigned int i;
		for (i = 0; i < im.width * im.height; i++)
		{
			os << " " << (int)im.image[i];
		}
	}

	return os;
}

std::istream& operator>>(std::istream& is, Image& im)
{
	if (im.image != NULL) delete im.image;

	is >> im.width;
	is >> im.height;

	im.image = new unsigned char[im.width * im.height];

	unsigned int i;
	for (i = 0; i < im.width * im.height; i++)
	{
		int tmpInt;
		is >> tmpInt;
		im.image[i] = tmpInt;
	}

	return is;
}




Region::Region(): Image(), offsetX(0), offsetY(0)
{
}


Region::Region(const Region& r): Image((const Image&)r), offsetX(r.offsetX), offsetY(r.offsetY)
{
}

Region::Region(int w, int h, int offsetX1, int offsetY1): Image(w, h), offsetX(offsetX1), offsetY(offsetY1)
{
}

Region::~Region()
{
}

unsigned int Region::OffsetX() const
{
	return offsetX;
}

unsigned int Region::OffsetY() const
{
	return offsetY;
}


