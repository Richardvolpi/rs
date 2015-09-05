#pragma once
#include <ostream>
#include "image.h"
#include "svm.h"


class ImageClassifier: public Image
{
public:
	ImageClassifier(const Image& im);
	ImageClassifier();

	virtual ~ImageClassifier(void);

	bool loadModel(const char* filename);
	char getCharacter(float* probs);
	
	friend std::ostream& operator<<(std::ostream& o, ImageClassifier& im);//serializing operator

private:

	svm_node* toSvmNode();

	static svm_model* model;
	static int count;
};
