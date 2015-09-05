#if !defined ___________klasjfbvhlwekuvfeq7456q2983475629856___________
#define ___________klasjfbvhlwekuvfeq7456q2983475629856___________

#include "EditDistance.h"

#include <vector>

class DictSearch
{

    public:
        DictSearch();
        ~DictSearch();

        int initialize(const char* dictPath);//loads the dictionary

		char* getMatch(char* string, float** probs); //returns the match based on the initial string 
						//and the probabilities of alternative letters

    private:

		EditDistance ed;// a class that implements the weighted edit distance algorithm


		//used for speeding up the algorithm
		struct LetterAndCount
		{
			unsigned char letter;
            int count;
		};
		struct WordAndLetterCount
		{
			char* word;
			std::vector<LetterAndCount> count;
		};
		std::vector<std::vector<WordAndLetterCount> > wrdList;

		void clearWrdList();

		__forceinline float getPercentage(WordAndLetterCount& wlc1, WordAndLetterCount& wlc2); 

};

#endif
