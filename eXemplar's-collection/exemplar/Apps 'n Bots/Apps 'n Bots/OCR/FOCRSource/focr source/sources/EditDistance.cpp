#include "stdafx.h"
#include "EditDistance.h"

#include <string.h>

#include <iostream>

EditDistance::EditDistance()
{
}


EditDistance::~EditDistance()
{
}

float EditDistance::getDistance(const char* s1, const char* s2)
{
	int i, j;
	l1 = strlen(s1);
	l2 = strlen(s2);

	for (i = 0; i <= l1; i++)
	{
		for (j = 0; j <= l2; j++)
		{
			if ((i == 0) && (j == 0))
			{
				(*this)(i, j) = 0.f;
				continue;
			}
			if (i == 0)
			{
				(*this)(i, j) = (*this)(i, j-1) + insCost[s2[j-1]]; //add the cost of the insertion of a letter from the
					//second word
				continue;
			}

			if (j == 0)
			{
				(*this)(i, j) = (*this)(i-1, j) + delCost[s1[i-1]];
				continue;
			}

			

			float minVal =(*this)(i-1, j-1);
			if (s1[i-1] != s2[j-1]) minVal += substCost[s1[i-1]][s2[j-1]];
			if (minVal > (*this)(i, j-1) + insCost[s2[j-1]]) minVal = (*this)(i, j-1) + insCost[s2[j-1]];
			if (minVal > (*this)(i-1, j) + delCost[s1[i-1]]) minVal = (*this)(i-1, j) + delCost[s1[i-1]];	

			(*this)(i, j) = minVal;

		}
	}

	return (*this)(l1, l2);
}

float EditDistance::getDistance(const char* s1, const char* s2, float** probs)
{
	int i, j;
	l1 = strlen(s1);
	l2 = strlen(s2);

	(*this)(0, 0) = 0;



	for (i = 1; i <= l1; i++) (*this)(i, 0) = (*this)(i-1, 0) + delCost[s1[i-1]];
	for (j = 1; j <= l2; j++) (*this)(0, j) = (*this)(0, j-1) + insCost[s2[j-1]];

	for (i = 1; i <= l1; i++)
	{
		for (j = 1; j <= l2; j++)
		{
	
			float minVal =(*this)(i-1, j-1);
			if (s1[i-1] != s2[j-1]) minVal += probs[i-1][s2[j-1]];
			float tmp = (*this)(i, j-1) + insCost[s2[j-1]];
			if (minVal > tmp) minVal = tmp;
			float tmp1 = (*this)(i-1, j) + delCost[s1[i-1]];
			if (minVal > tmp1) minVal = tmp1;	

			(*this)(i, j) = minVal;

		}
	}


#if 0

	std::cout <<"dist";

	for (i = 0; i <= l1; i++)
	{
		for (j = 0; j <= l2; j++)
		{
			if ((i == 0) && (j == 0))
			{
				(*this)(i, j) = 0.f;
				continue;
			}
			if (i == 0)
			{
				(*this)(i, j) = (*this)(i, j-1) + insCost[s2[j-1]]; //add the cost of the insertion of a letter from the
					//second word
				continue;
			}

			if (j == 0)
			{
				(*this)(i, j) = (*this)(i-1, j) + delCost[s1[i-1]];
				continue;
			}

			

			float minVal =(*this)(i-1, j-1);
			if (s1[i-1] != s2[j-1]) minVal += probs[i-1][s2[j-1]];
			if (minVal > (*this)(i, j-1) + insCost[s2[j-1]]) minVal = (*this)(i, j-1) + insCost[s2[j-1]];
			if (minVal > (*this)(i-1, j) + delCost[s1[i-1]]) minVal = (*this)(i-1, j) + delCost[s1[i-1]];	

			(*this)(i, j) = minVal;

		}
	}

#endif

	return (*this)(l1, l2);
}


bool EditDistance::loadCosts(const char* filename)
{
	int i;
	for (i =0; i < 256; i++)
	{
		insCost[i] = 1.f;
		delCost[i] = 1.f;
	}

	for (i = 0; i < 256; i++)
	{
		for (int j = 0; j < 256; j++)
		{
			substCost[i][j] = 1.f;
		}
	}

	return true;
}