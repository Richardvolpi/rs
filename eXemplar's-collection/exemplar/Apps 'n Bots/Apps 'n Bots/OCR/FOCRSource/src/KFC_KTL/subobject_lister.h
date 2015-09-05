#ifndef subobject_lister_h
#define subobject_lister_h

// ------------------
// Sub-object lister
// ------------------
template <class ObjectType>
class TSubObjectLister
{
public:
	virtual ObjectType* GetSubObject(size_t szIndex) = 0;

	virtual const ObjectType* GetSubObject(size_t szIndex) const = 0;

	virtual size_t GetNSubObjects() const = 0;
};

#endif // subobject_lister_h