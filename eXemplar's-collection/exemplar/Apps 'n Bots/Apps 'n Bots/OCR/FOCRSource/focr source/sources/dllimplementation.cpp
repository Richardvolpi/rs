#include "stdafx.h"
#include "ocrdll.h"

#include "Segmentor.h"
#include "ImageClasifier.h"
#include "DictSearch.h"

#include <fstream>

Image image;
ImageClassifier imClass(image);
Segmentor segmentor;

DictSearch ds;

extern float *probs[256];

extern "C" __stdcall OCRDLL_API void loadDictionary(const char* dict)
{
	ds.initialize(dict);

	int i;

	for (i = 0; i < 256; i++)
	{
		probs[i] = new float[256];
	}

}

extern "C" __stdcall OCRDLL_API void loadModel(const char* filename)
{

	imClass.loadModel(filename);
}
extern "C" __stdcall OCRDLL_API void getString(const char* imageFilename, char* result)
{

	image.load(imageFilename);
	segmentor.process(image);

	result[0] = '\0';

	if (segmentor.getNrOfLetters() == 0) return;

	char* strng = new char[segmentor.getNrOfLetters() + 1];

	int i;
	for (i = 0; i < segmentor.getNrOfLetters(); i++)
	{
		image = segmentor.getLetter(i, true);
		image.center(1);
		image.scale(15, 15);
		ImageClassifier ic(image);

		strng[i] = ic.getCharacter(probs[i]);
	}

	strng[i] = '\0';


		int k, t;
		for (k = 0; k < strlen(strng); k++)
		{
			float sum = 0.f;
			for (t = 0; t < 256; t++)
			{
				sum += probs[k][t];//probs[k][t] = 1 - probs[k][t];
			}

			for (t = 0; t < 256; t++)
			{
				probs[k][t] = 1 - probs[k][t] / sum;
			}
		}

		
		char* res = ds.getMatch(strng, probs);

		delete strng;

		strcpy(result, res);
		delete res;

//	return result;
}
