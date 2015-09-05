// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 19/09/2004 20:04:12
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   CommandHandler.java


public interface CommandHandler
{

    public abstract String[] getPrefixList();

    public abstract void activated(String s, String as[]);
}