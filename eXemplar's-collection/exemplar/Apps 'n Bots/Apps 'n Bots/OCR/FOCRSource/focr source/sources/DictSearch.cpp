#include "stdafx.h"
#include "DictSearch.h"

#include <stdio.h>
#include <string.h>
#include <iostream>

#include <fstream>
#include <string.h>



DictSearch::DictSearch()
{
	ed.loadCosts(NULL);
	clearWrdList();
}


DictSearch::~DictSearch()
{
	clearWrdList();
}

void DictSearch::clearWrdList()
{
	int i;
	for (i =0; i < wrdList.size(); i++)
	{
		for (int j = 0; j < wrdList[i].size(); j++)
		{
			delete wrdList[i][j].word;
		}
		wrdList[i].clear();
	}

	wrdList.clear();

	wrdList.resize(32);
}

int DictSearch::initialize(const char* dictPath)
{

	clearWrdList();

	std::fstream f;

	f.open(dictPath, std::ios::in);


	char word[1000];

	while (!f.eof())
	{
		f.getline(word, 1000);
		int len = strlen(word);
		char* wrd = new char[len + 1];
		strcpy(wrd, word);

		WordAndLetterCount wlc;
		wlc.word = wrd;

		//now add the letter counts in wlc.count
		wlc.count.clear();
		
		int count[256];
		for (int i = 0; i < 256; i++)
		{
			count[i] = 0;
		}

		for (i =0; i < len; i++)
		{
			count[(unsigned char)word[i]]++;
		}

		for (i = 0; i < 256; i++)
		{
			if (count[i] != 0)
			{
				LetterAndCount lc;
				lc.letter = i;
				lc.count = count[i];

				wlc.count.push_back(lc);
			}
		}

		wrdList[strlen(word)].push_back(wlc);
	}
	
	f.close();

	ed.loadCosts(NULL);
    return 1;
	
}



char* DictSearch::getMatch(char* string, float** probs)
{

    const char * word; 

	int i;
	float dist = 1000.f;
	int index1 = -1;
	int index2 = -1;
	int len = strlen(string);

	int min, max;
	min = len - 1 > 0 ? len - 1 : 0;
	max = len + 1 < 32 ? len + 1 : 32;


	//get a letter count for string
	float totalLength = strlen(string);

	WordAndLetterCount wlc;
	wlc.count.clear();

		int count[256];
		for (i = 0; i < 256; i++)
		{
			count[i] = 0;
		}

		for (i =0; i < len; i++)
		{
			count[(unsigned char)string[i]]++;
		}

		for (i = 0; i < 256; i++)
		{
			if (count[i] != 0)
			{
				LetterAndCount lc;
				lc.letter = i;
				lc.count = count[i];

				wlc.count.push_back(lc);
			}
		}


	for (i = min; i <= max; i++)
	{
		for (int j =0; j < wrdList[i].size(); j++)
		{
			//now check the percentage of common letters
			if (getPercentage(wlc, wrdList[i][j]) / totalLength < 0.49)
			{
				continue;
			}

			float tmpDist = ed.getDistance(string, wrdList[i][j].word, probs);
			if (dist > tmpDist)
			{
				dist = tmpDist;
				index1 = i;
				index2 = j;
			}
		}

	}

	if ((index1 >= 0) && (index2 >= 0))
	{

		char* match = new char[strlen(wrdList[index1][index2].word) + 1];

		strcpy(match, wrdList[index1][index2].word);

		return match;
	}
	else
	{
		char * match = new char[10];
		strcpy(match, "unknown");
		return match;
	}

}

float DictSearch::getPercentage(WordAndLetterCount& wlc1, WordAndLetterCount& wlc2)
{
	float total1 = 0.f;
	float common = 0.f;

	int i, j;
	i = 0; j = 0;

	int sz1 = wlc1.count.size();
	int sz2 = wlc2.count.size();

	while ((i < sz1) && (j < sz2))
	{
		if (wlc1.count[i].letter < wlc2.count[j].letter)
		{
			i++;
		}
		else
		{
			if (wlc1.count[i].letter > wlc2.count[j].letter)
			{
				j++;
			}
			else
			{
				common += wlc1.count[i].count < wlc2.count[i].count ? wlc1.count[i].count : wlc2.count[i].count;
				i++;
				j++;
			}
		}
	}

	return common;

}



