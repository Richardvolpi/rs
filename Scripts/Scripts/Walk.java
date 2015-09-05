public class Walk extends Script
{
   public Walk(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"walk"};
   }
public int NPC[] = new int [793];
public int Mode = 1;
public void KeyPressed(int id)
{
    //right
    if (id == 54)
    {
        if (!CanReach(GetX()-1,GetY()))
        {
            AtObject(GetX()-1,GetY());
            Wait(25);
            AtObject(GetX(),GetY());
            Wait(25);
        }
        ForceWalkNoWait(GetX()-1,GetY());
        Wait(25);
    }
    //left
    if (id == 52)
    {
        if (!CanReach(GetX()+1,GetY()))
        {
            AtObject(GetX()+1,GetY());
            Wait(25);
            AtObject(GetX(),GetY());
            Wait(25);
        }
        ForceWalkNoWait(GetX()+1,GetY());
        Wait(25);
    }
    //up
    if (id == 56)
    {
        if (!CanReach(GetX(),GetY()-1))
        {
            AtObject(GetX(),GetY()-1);
            Wait(25);
            AtObject(GetX(),GetY());
            Wait(25);
        }
        ForceWalkNoWait(GetX(),GetY()-1);
        Wait(25);
    }
    //down
    if (id == 50)
    {
        if (!CanReach(GetX(),GetY()+1))
        {
            AtObject(GetX(),GetY()+1);
            Wait(25);
            AtObject(GetX(),GetY());
            Wait(25);
        }
        ForceWalkNoWait(GetX(),GetY()+1);
        Wait(25);
    }
    //downright
    if (id == 51)
    {
        if (!CanReach(GetX()-1,GetY()+1))
        {
            AtObject(GetX()-1,GetY()+1);
            Wait(25);
            AtObject(GetX(),GetY());
            Wait(25);
        }
        ForceWalkNoWait(GetX()-1,GetY()+1);
        Wait(25);
    }
    //downleft
    if (id == 49)
    {
        if (!CanReach(GetX()+1,GetY()+1))
        {
            AtObject(GetX()+1,GetY()+1);
            Wait(25);
            AtObject(GetX(),GetY());
            Wait(25);
        }
        ForceWalkNoWait(GetX()+1,GetY()+1);
        Wait(25);
    }
    //upleft
    if (id == 55)
    {
        if (!CanReach(GetX()+1,GetY()-1))
        {
            AtObject(GetX()+1,GetY()-1);
            Wait(25);
            AtObject(GetX(),GetY());
            Wait(25);
        }
        ForceWalkNoWait(GetX()+1,GetY()-1);
        Wait(25);
    }
    //upright
    if (id == 57)
    {
        if (!CanReach(GetX()-1,GetY()-1))
        {
            AtObject(GetX()-1,GetY()-1);
            Wait(25);
            AtObject(GetX(),GetY());
            Wait(25);
        }
        ForceWalkNoWait(GetX()-1,GetY()-1);
        Wait(25);
    }
    //attack npc
    if (id == 47)
    {
        DisplayMessage("@Dre@Looking for a fight...",3);
        AttackNPC(GetNearestNPC(NPC));
        Wait(100);
    }
    //talk to npc
    if (id == 42)
    {
        DisplayMessage("@Dre@Looking for conversation...",3);
        TalkToNPC(GetNearestNPC(NPC));
        Wait(100);
    }
    //fightmode
    if(id == 1011)
    {
        Mode++;
        if(Mode == 5)
        {
            Mode = 0;
            DisplayMessage("@Dre@Controlled",3);
            SetFightMode(Mode);
        }
        if(Mode == 1)
        {
            DisplayMessage("@Dre@Agressive",3);
            SetFightMode(Mode);
        }
        if(Mode == 2)
        {
            DisplayMessage("@Dre@Accurate",3);
            SetFightMode(Mode);
        }
        if(Mode == 3)
        {
            DisplayMessage("@Dre@Defensive",3);
            SetFightMode(Mode);
        }
    }     
   
}
   public void start(String command, String parameter[])
   {
      DisplayMessage("@bla@KeyBoard Walker",3);
      DisplayMessage("@gre@By: Davis Zanot",3);
      for(int i = 0;i<794; i++)
      {
          NPC[i] = i;
      }
   }
}