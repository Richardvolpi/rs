package org.rscdaemon.server.entityhandling.defs.extras;

public class AdvertDef
{
	public String message = null;
	public boolean f2ponly = false;
	public boolean p2ponly = false;
	
	public String getMessage()
	{
		return message;
	}
	
	public boolean isF2pOnly()
	{
		return f2ponly;
	}
	
	public boolean isP2pOnly()
	{
		return p2ponly;
	}
}
