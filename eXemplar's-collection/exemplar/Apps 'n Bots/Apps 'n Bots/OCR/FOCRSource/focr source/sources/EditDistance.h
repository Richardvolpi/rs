#pragma once


class EditDistance
{
public:
	EditDistance();
	~EditDistance();

	bool loadCosts(const char* filename);

	float getDistance(const char* s1, const char* s2);//returns the weighted edit distance to get 
			//from s1 to s2


	float getDistance(const char* s1, const char* s2, float** probs);

private:
	float insCost[256];//the insertion cost
	float delCost[256];//the deletion cost
	float substCost[256][256];//the substitution cost
	           //substCost[i][j] is the cost of subtituting i with j

	int l1, l2;//the lengths of the words
	float table[10000];//supports only words with l1 * l2 < 10000

	__forceinline float& operator()(int i, int j){return table[i * (l2 + 1) + j];}

};