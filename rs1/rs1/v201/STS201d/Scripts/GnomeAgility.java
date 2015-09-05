/* 
 * STS gnome agility script, based on RscJakes SBot198 script.
 */

public class GnomeAgility extends Methods
{
    public GnomeAgility(mudclient mc) {super(mc); }
    
    public void Body(String Args[])
    {
        Display("Gnome agility script started.");
        while(Running())
        {
            Sleep();
            while(GetY()!= 499)
            {
                AtObject(692,495);
                Wait(1000);
            } 
            Sleep();
            while(GetY()!= 1448)
            {
                AtObject(692,503); 
                Wait(1000);
            }
            Sleep();
            while(GetY() != 2394)
            {
                AtObject(693,1452);
                Wait(1000);
            }
            Sleep();
            while(GetY()!= 2396)
            {
                AtObject(689,2395);
                Wait(1000);
            }
            Sleep();
            while(GetY()!= 506)
            {
                AtObject(683,2396);
                Wait(1000);
            }
            Wait(1000);
            Sleep();
            while(GetY()!= 501)
            {
                AtObject(683,502);
                Wait(1000);
            }
            Sleep(); 
            while(GetY()!= 494)
            {
                AtObject(683,497);
                Wait(1000);
            }
            Sleep();
            WalkToWait(686,494);
            WalkToWait(689,494);
            WalkToWait(691,494);
        }
        End();
    }
    
    public void Sleep()
    {
        Wait(1000);
        if(GetFatigue() > 90 && Running()) 
        { 
            while(!Sleeping() && Running()) 
            {
                if(CountInv(1263) < 1)
                {
                    Display("No sleeping bag found!");
                    End();
                }
                UseItem(GetItemPos(1263)); 
                Wait(2500); 
            } 
            while(Sleeping() && Running()) 
                Wait(100); 
        }
    }
}