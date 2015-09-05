#include "stdafx.h"
#include "imageclasifier.h"

#include <iostream>

int ImageClassifier::count = 0;
svm_model* ImageClassifier::model = NULL;

ImageClassifier::ImageClassifier(const Image& im): Image(im)
{
}

ImageClassifier::ImageClassifier()
{
}

ImageClassifier::~ImageClassifier(void)
{
}


bool ImageClassifier::loadModel(const char* filename)
{
	model = svm_load_model(filename);
	if (model == NULL) return false;
	return true;
}

char ImageClassifier::getCharacter(float* probabilities)
{
	svm_node* svmNode = toSvmNode();
	if (svmNode == NULL) return -1;

	int nrClasses = svm_get_nr_class(model);
	int* labels = new int[nrClasses];
	double* probs = new double[nrClasses];
//	char result = (char)svm_predict_probability(model, svmNode);

	svm_get_labels(model, labels);

	svm_predict_probability(model, svmNode, probs);

	int i;
	for (i = 0; i < 256; i++)
	{
		probabilities[i] = 0;
	}

	

	for (i = 0; i < nrClasses; i++)
	{
		probabilities['a' + labels[i]] = probs[i];
	}


	int index = 0;
	for (i = 0; i < nrClasses; i++)
	{
		if (probs[i] > probs[index]) index = i;
	}

	char result = labels[index] + 'a';

	delete labels;
	delete probs;

	delete[] svmNode;

	return result;
}


std::ostream& operator<<(std::ostream& o, ImageClassifier& im)
{	
	//this serializes the image as a svm_node (index:value)
	svm_node* node = im.toSvmNode();

	if (node == NULL) return o;

	svm_node* tmp = node;

	while (node->index >= 0)
	{
		o << " " << node->index << ":" << node->value;
		node++;

	}

	delete[] tmp;
	

	return o;

}



svm_node* ImageClassifier::toSvmNode()
{

    int pixelCount = 0;
    unsigned int i, j;

    for (i = 0; i < height; i++)
    {

        for (j = 0; j < width; j++)
        {

            if ((*this)(j,i) != 0) pixelCount++;

        }

    }

    svm_node* output = new svm_node[pixelCount + 1];

    unsigned int pos = 0;

    float max = -1.;
	float min = 256.;

    for (i = 0; i < height; i++)
    {

        for (j = 0; j < width; j++)
        {

						

            if ((*this)(j,i) != 0) 
            {

                output[pos].index = i * width + j + 1;
                output[pos].value = (float)(*this)(j,i) / 255.f;
                if (max < output[pos].value) max = (float)output[pos].value;
				if (min > output[pos].value) min = (float)output[pos].value;
                pos++;

            }

        }

    }

/*
    for (i = 0; i < pos; i++)
    {

        output[i].value = ;

    }
*/
    output[pos].index = -1;

    return output;
}