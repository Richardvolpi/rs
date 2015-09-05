#ifndef bounding_h
#define bounding_h

// Bound coef from [s1;s2] to [t1;t2]
#define BOUNDC(s1, s2, t1, t2)	(((t2) - (t1)) / ((s2) - (s1)))
 
// Bound result from [s1;s2] to [t1;t2] using precalculated coef
#define BOUNDR(s, s1, t1, c)	((t1) + ((s) - (s1)) * (c))

#endif // bounding_h
