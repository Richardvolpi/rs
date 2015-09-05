#include "Main.h"
#include "jawt_md.h"
JNIEXPORT void JNICALL Java_Main_setTopWindow
  (JNIEnv * env, jclass clazz, jobject window)
{
	/*jclass componentClazz = env->FindClass("java/awt/Component");
	jmethodID peerMethod = env->GetMethodID(componentClazz,"getPeer","()Ljava/awt/peer/ComponentPeer;");
	jobject peer = env->CallObjectMethod(window,peerMethod);
	jclass objectPeerClass = env->FindClass("sun/awt/windows/WObjectPeer");
	jfieldID objectPeerField = env->GetFieldID(objectPeerClass,"pData","J");
	jlong pData = env->GetLongField(peer,objectPeerField);
	HWND hwnd = (HWND)pData;*/
	JAWT awt;
	JAWT_DrawingSurface* ds;
    JAWT_DrawingSurfaceInfo* dsi;
    JAWT_Win32DrawingSurfaceInfo* dsi_win;
	jboolean result;
	jint lock;

     // Get the AWT
    awt.version = JAWT_VERSION_1_3;
    result = JAWT_GetAWT(env, &awt);
	
    // Get the drawing surface
    ds = awt.GetDrawingSurface(env, window);
	lock = ds->Lock(ds);
	dsi = ds->GetDrawingSurfaceInfo(ds);
	dsi_win = (JAWT_Win32DrawingSurfaceInfo*)dsi->platformInfo;
	SetWindowPos(dsi_win->hwnd,HWND_TOPMOST,0,0,0,0,SWP_NOMOVE|SWP_NOSIZE);
	ds->FreeDrawingSurfaceInfo(dsi);
	ds->Unlock(ds);
	awt.FreeDrawingSurface(ds);
}