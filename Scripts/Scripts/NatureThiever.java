// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 9/2/04 11:19:07 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   NatureThiever.java


public class NatureThiever extends Script
{

    public NatureThiever(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "thievenats"
        });
    }

    public void start(String s, String as[])
    {
        DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Nature Rune Chest Thiever Activated! @ran@=@ran@=@ran@=@ran@=@ran@=", 3);
        DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Created by SaladFork! @ran@=@ran@=@ran@=@ran@=@ran@=", 3);
        for(; Running(); Wait(500))
            AtObject2(582, 1527);

        DisplayMessage("@ran@STOPPED: @gre@made by deFT", 3);
    }
}