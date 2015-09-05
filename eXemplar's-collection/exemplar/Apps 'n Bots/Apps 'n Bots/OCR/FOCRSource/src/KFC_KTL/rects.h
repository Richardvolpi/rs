#ifndef rects_h
#define rects_h

// ------
// Rects
// ------
template <class t>
class TRects : public TValueList< TRect<t> >
{
public:
	TRects() {}

	TRects(const TRect<t>& Start)
	{
		*AddLast() = Start;
	}

	TRects<t>& operator -= (const TRect<t>& Rect);
};

template <class t>
TRects<t>& TRects<t>::operator -= (const TRect<t>& Rect)
{
	if(IsEmpty())
		return *this;

	TIterator LastIter = GetLast();

	TIterator Iter, NIter;
	for(Iter = GetFirst() ; ; Iter = NIter)
	{
		NIter = Iter.GetNext();

		const bool bLast = Iter == LastIter;

		IRECT ResRects[4];
		const size_t szN = SubtractRect(*Iter, Rect, ResRects);

		size_t i;
		for(i = 0 ; i < szN ; i++)
			*AddLast() = ResRects[i];

		Del(Iter);

		if(bLast)
			break;
	}

	return *this;
}

#endif // rects_h