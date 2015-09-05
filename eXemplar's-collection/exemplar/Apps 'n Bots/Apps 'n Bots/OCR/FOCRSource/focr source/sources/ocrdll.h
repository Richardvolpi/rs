// The following ifdef block is the standard way of creating macros which make exporting 
// from a DLL simpler. All files within this DLL are compiled with the OCRDLL_EXPORTS
// symbol defined on the command line. this symbol should not be defined on any project
// that uses this DLL. This way any other project whose source files include this file see 
// OCRDLL_API functions as being imported from a DLL, whereas this DLL sees symbols
// defined with this macro as being exported.
#ifdef OCRDLL_EXPORTS
#define OCRDLL_API __declspec(dllexport)
#else
#define OCRDLL_API __declspec(dllimport)
#endif


//OCRDLL_API void loadModel(const char* filename);
//OCRDLL_API void getString(const char* imageFilename, char* string);
