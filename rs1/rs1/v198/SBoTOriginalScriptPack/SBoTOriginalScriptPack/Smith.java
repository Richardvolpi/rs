public class Smith extends Script
{
    public Smith(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"smith"};
    }
    public void start(String command, String parameter[])
    {
      if (parameter.length != 2)
      {
         DisplayMessage("@gre@Jake: @whi@Invalid number of parameters. /run smith [bar] [item]", 3);
      } else {
         String Bar = parameter[0];
         String Item = parameter[1];

       while (Running() == true)
       {
          int B = 10;
          int Aone = 10;
          int Atwo = 10;
          int Athree = 10;
          int I = 10;
          int Ineed = 10;
          String sayB = "null";
          String sayI = "null";
            if (Bar.equalsIgnoreCase("Bronze"))  {
              B = 169;
              sayB = "Bronze";
               if (Item.equalsIgnoreCase("legs"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 2;
              I = 206;
         Ineed = 3;
              sayI = "Plate Mail Legs";
             }
               if (Item.equalsIgnoreCase("plate"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 1;
              I = 117;
         Ineed = 5;
              sayI = "Plate Mail Body";
             }
               if (Item.equalsIgnoreCase("Skirt"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 3;
              I = 214;
         Ineed = 3;
              sayI = "Plated Skirt";
             }
               if (Item.equalsIgnoreCase("chain"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 0;
              I = 113;
         Ineed = 3;
              sayI = "Chain Mail Body";
             }
               if (Item.equalsIgnoreCase("twohander"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 3;
              I = 76;
         Ineed = 3;
              sayI = "Two-handed Sword";
             }
               if (Item.equalsIgnoreCase("kite"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 1;
              I = 128;
         Ineed = 3;
              sayI = "Kite Shield";
             }
               if (Item.equalsIgnoreCase("battle"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 1;
              I = 205;
         Ineed = 3;
              sayI = "Battle Axe";
             }
               if (Item.equalsIgnoreCase("square"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 0;
              I = 124;
         Ineed = 2;
              sayI = "Square Shield"; 
             }
               if (Item.equalsIgnoreCase("large"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 1;
              I = 108;
         Ineed = 2;
              sayI = "Great Helmet"; 
             }
               if (Item.equalsIgnoreCase("long"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 1;
              I = 70;
         Ineed = 2;
              sayI = "Long Sword"; 
             }
               if (Item.equalsIgnoreCase("scim"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 2;
              I = 82;
         Ineed = 2;
              sayI = "Scimitar"; 
             }
               if (Item.equalsIgnoreCase("short"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 0;
              I = 66;
         Ineed = 1;
              sayI = "Short Sword"; 
             }
               if (Item.equalsIgnoreCase("heads"))  {
              Aone = 2;
              Atwo = 0;
              I = 669;
         Ineed = 1;
              sayI = "Arrow Heads"; 
             }
               if (Item.equalsIgnoreCase("med"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 0;
              I = 104;
         Ineed = 1;
              sayI = "Medium Helmet"; 
             }
               if (Item.equalsIgnoreCase("mace"))  {
              Aone = 0;
              Atwo = 4;
              I = 94;
         Ineed = 1;
              sayI = "Mace"; 
             }
               if (Item.equalsIgnoreCase("hatchet"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 0;
              I = 87;
         Ineed = 1;
              sayI = "Hatchet"; 
             }
               if (Item.equalsIgnoreCase("Dagger"))  {
              Aone = 0;
              Atwo = 0;
              I = 62;
         Ineed = 1;
              sayI = "Dagger"; 
             }
       }   
if (Bar.equalsIgnoreCase("iron"))  {
              B = 170;
              sayB = "Iron";
               if (Item.equalsIgnoreCase("legs"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 2;
              I = 9;
         Ineed = 3;
              sayI = "Plate Mail Legs";
             }
               if (Item.equalsIgnoreCase("plate"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 1;
              I = 8;
         Ineed = 5;
              sayI = "Plate Mail Body";
             }
               if (Item.equalsIgnoreCase("Skirt"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 3;
              I = 215;
         Ineed = 3;
              sayI = "Plated Skirt";
             }
               if (Item.equalsIgnoreCase("chain"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 0;
              I = 7;
         Ineed = 3;
              sayI = "Chain Mail Body";
             }
               if (Item.equalsIgnoreCase("twohander"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 3;
              I = 77;
         Ineed = 3;
              sayI = "Two-handed Sword";
             }
               if (Item.equalsIgnoreCase("kite"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 1;
              I = 2;
         Ineed = 3;
              sayI = "Kite Shield";
             }
               if (Item.equalsIgnoreCase("battle"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 1;
              I = 89;
         Ineed = 3;
              sayI = "Battle Axe";
             }
               if (Item.equalsIgnoreCase("square"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 0;
              I = 3;
         Ineed = 2;
              sayI = "Square Shield"; 
             }
               if (Item.equalsIgnoreCase("large"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 1;
              I = 6;
         Ineed = 2;
              sayI = "Great Helmet"; 
             }
               if (Item.equalsIgnoreCase("long"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 1;
              I = 71;
         Ineed = 2;
              sayI = "Long Sword"; 
             }
               if (Item.equalsIgnoreCase("scim"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 2;
              I = 83;
         Ineed = 2;
              sayI = "Scimitar"; 
             }
               if (Item.equalsIgnoreCase("short"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 0;
              I = 67;
         Ineed = 1;
              sayI = "Short Sword"; 
             }
               if (Item.equalsIgnoreCase("heads"))  {
              Aone = 2;
              Atwo = 0;
              I = 670;
         Ineed = 1;
              sayI = "Arrow Heads"; 
             }
               if (Item.equalsIgnoreCase("med"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 0;
              I = 5;
         Ineed = 1;
              sayI = "Medium Helmet"; 
             }
               if (Item.equalsIgnoreCase("mace"))  {
              Aone = 0;
              Atwo = 4;
              I = 0;
         Ineed = 1;
              sayI = "Mace"; 
             }
               if (Item.equalsIgnoreCase("hatchet"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 0;
              I = 12;
         Ineed = 1;
              sayI = "Hatchet"; 
             }
               if (Item.equalsIgnoreCase("Dagger"))  {
              Aone = 0;
              Atwo = 0;
              I = 63;
         Ineed = 1;
              sayI = "Dagger"; 
             }
       }   
if (Bar.equalsIgnoreCase("steel"))  {
              B = 171;
              sayB = "Steel";
               if (Item.equalsIgnoreCase("plate"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 1;
              I = 118;
         Ineed = 5;
              sayI = "Plate Mail Body";
             }
               if (Item.equalsIgnoreCase("Skirt"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 3;
              I = 215;
         Ineed = 3;
              sayI = "Plated Skirt";
             }
               if (Item.equalsIgnoreCase("chain"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 0;
              I = 114;
         Ineed = 3;
              sayI = "Chain Mail Body";
             }
               if (Item.equalsIgnoreCase("legs"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 2;
              I = 207;
         Ineed = 3;
              sayI = "Plate Mail Legs";
             }
               if (Item.equalsIgnoreCase("twohander"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 3;
              I = 78;
         Ineed = 3;
              sayI = "Two-handed Sword";
             }
               if (Item.equalsIgnoreCase("kite"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 1;
              I = 129;
         Ineed = 3;
              sayI = "Kite Shield";
             }
               if (Item.equalsIgnoreCase("battle"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 1;
              I = 206;
         Ineed = 3;
              sayI = "Battle Axe";
             }
               if (Item.equalsIgnoreCase("square"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 0;
              I = 125;
         Ineed = 2;
              sayI = "Square Shield"; 
             }
               if (Item.equalsIgnoreCase("large"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 1;
              I = 109;
         Ineed = 2;
              sayI = "Great Helmet"; 
             }
               if (Item.equalsIgnoreCase("long"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 1;
              I = 71;
         Ineed = 2;
              sayI = "Long Sword"; 
             }
               if (Item.equalsIgnoreCase("scim"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 2;
              I = 83;
         Ineed = 2;
              sayI = "Scimitar"; 
             }
               if (Item.equalsIgnoreCase("short"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 0;
              I = 67;
         Ineed = 1;
              sayI = "Short Sword"; 
             }
               if (Item.equalsIgnoreCase("heads"))  {
              Aone = 2;
              Atwo = 0;
              I = 671;
         Ineed = 1;
              sayI = "Arrow Heads"; 
             }
               if (Item.equalsIgnoreCase("med"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 0;
              I = 105;
         Ineed = 1;
              sayI = "Medium Helmet"; 
             }
               if (Item.equalsIgnoreCase("mace"))  {
              Aone = 0;
              Atwo = 4;
              I = 95;
         Ineed = 1;
              sayI = "Mace"; 
             }
               if (Item.equalsIgnoreCase("hatchet"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 0;
              I = 88;
         Ineed = 1;
              sayI = "Hatchet"; 
             }
               if (Item.equalsIgnoreCase("Dagger"))  {
              Aone = 0;
              Atwo = 0;
              I = 63;
         Ineed = 1;
              sayI = "Dagger"; 
             }
       }   
if (Bar.equalsIgnoreCase("mith"))  {
              B = 173;
              sayB = "Mithril";
               if (Item.equalsIgnoreCase("plate"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 1;
              I = 119;
         Ineed = 5;
              sayI = "Plate Mail Body";
             }
               if (Item.equalsIgnoreCase("Skirt"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 3;
              I = 216;
         Ineed = 3;
              sayI = "Plated Skirt";
             }
               if (Item.equalsIgnoreCase("chain"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 0;
              I = 115;
         Ineed = 3;
              sayI = "Chain Mail Body";
             }
               if (Item.equalsIgnoreCase("legs"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 2;
              I = 208;
         Ineed = 3;
              sayI = "Plate Mail Legs";
             }
               if (Item.equalsIgnoreCase("twohander"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 3;
              I = 79;
         Ineed = 3;
              sayI = "Two-handed Sword";
             }
               if (Item.equalsIgnoreCase("kite"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 1;
              I = 130;
         Ineed = 3;
              sayI = "Kite Shield";
             }
               if (Item.equalsIgnoreCase("battle"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 1;
              I = 207;
         Ineed = 3;
              sayI = "Battle Axe";
             }
               if (Item.equalsIgnoreCase("square"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 0;
              I = 126;
         Ineed = 2;
              sayI = "Square Shield"; 
             }
               if (Item.equalsIgnoreCase("large"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 1;
              I = 110;
         Ineed = 2;
              sayI = "Great Helmet"; 
             }
               if (Item.equalsIgnoreCase("long"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 1;
              I = 72;
         Ineed = 2;
              sayI = "Long Sword"; 
             }
               if (Item.equalsIgnoreCase("scim"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 2;
              I = 84;
         Ineed = 2;
              sayI = "Scimitar"; 
             }
               if (Item.equalsIgnoreCase("short"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 0;
              I = 68;
         Ineed = 1;
              sayI = "Short Sword"; 
             }
               if (Item.equalsIgnoreCase("heads"))  {
              Aone = 2;
              Atwo = 0;
              I = 672;
         Ineed = 1;
              sayI = "Arrow Heads"; 
             }
               if (Item.equalsIgnoreCase("med"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 0;
              I = 106;
         Ineed = 1;
              sayI = "Medium Helmet"; 
             }
               if (Item.equalsIgnoreCase("mace"))  {
              Aone = 0;
              Atwo = 4;
              I = 96;
         Ineed = 1;
              sayI = "Mace"; 
             }
               if (Item.equalsIgnoreCase("hatchet"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 0;
              I = 89;
         Ineed = 1;
              sayI = "Hatchet"; 
             }
               if (Item.equalsIgnoreCase("Dagger"))  {
              Aone = 0;
              Atwo = 0;
              I = 64;
         Ineed = 1;
              sayI = "Dagger"; 
             }
       }   
if (Bar.equalsIgnoreCase("addy"))  {
              B = 174;
              sayB = "Adamantite";
               if (Item.equalsIgnoreCase("plate"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 1;
              I = 120;
         Ineed = 5;
              sayI = "Plate Mail Body";
             }
               if (Item.equalsIgnoreCase("Skirt"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 3;
              I = 217;
         Ineed = 3;
              sayI = "Plated Skirt";
             }
               if (Item.equalsIgnoreCase("chain"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 0;
              I = 116;
         Ineed = 3;
              sayI = "Chain Mail Body";
             }
               if (Item.equalsIgnoreCase("legs"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 2;
              I = 209;
         Ineed = 3;
              sayI = "Plate Mail Legs";
             }
               if (Item.equalsIgnoreCase("twohander"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 3;
              I = 80;
         Ineed = 3;
              sayI = "Two-handed Sword";
             }
               if (Item.equalsIgnoreCase("kite"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 1;
              I = 131;
         Ineed = 3;
              sayI = "Kite Shield";
             }
               if (Item.equalsIgnoreCase("battle"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 1;
              I = 208;
         Ineed = 3;
              sayI = "Battle Axe";
             }
               if (Item.equalsIgnoreCase("square"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 0;
              I = 127;
         Ineed = 2;
              sayI = "Square Shield"; 
             }
               if (Item.equalsIgnoreCase("large"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 1;
              I = 111;
         Ineed = 2;
              sayI = "Great Helmet"; 
             }
               if (Item.equalsIgnoreCase("long"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 1;
              I = 73;
         Ineed = 2;
              sayI = "Long Sword"; 
             }
               if (Item.equalsIgnoreCase("scim"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 2;
              I = 85;
         Ineed = 2;
              sayI = "Scimitar"; 
             }
               if (Item.equalsIgnoreCase("short"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 0;
              I = 69;
         Ineed = 1;
              sayI = "Short Sword"; 
             }
               if (Item.equalsIgnoreCase("heads"))  {
              Aone = 2;
              Atwo = 0;
              I = 673;
         Ineed = 1;
              sayI = "Arrow Heads"; 
             }
               if (Item.equalsIgnoreCase("med"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 0;
              I = 107;
         Ineed = 1;
              sayI = "Medium Helmet"; 
             }
               if (Item.equalsIgnoreCase("mace"))  {
              Aone = 0;
              Atwo = 4;
              I = 97;
         Ineed = 1;
              sayI = "Mace"; 
             }
               if (Item.equalsIgnoreCase("hatchet"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 0;
              I = 90;
         Ineed = 1;
              sayI = "Hatchet"; 
             }
               if (Item.equalsIgnoreCase("Dagger"))  {
              Aone = 0;
              Atwo = 0;
              I = 65;
         Ineed = 1;
              sayI = "Dagger"; 
             }
       }   
if (Bar.equalsIgnoreCase("rune"))  {
              B = 408;
              sayB = "Rune"; 
               if (Item.equalsIgnoreCase("plate"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 1;
              I = 401;
         Ineed = 5;
              sayI = "Plate Mail Body";
             }
               if (Item.equalsIgnoreCase("Skirt"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 3;
              I = 406;
         Ineed = 3;
              sayI = "Plated Skirt";
             }
               if (Item.equalsIgnoreCase("chain"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 0;
              I = 401;
         Ineed = 3;
              sayI = "Chain Mail Body";
             }
               if (Item.equalsIgnoreCase("legs"))  {
              Aone = 1;
              Atwo = 2;
              Athree = 2;
              I = 402;
         Ineed = 3;
              sayI = "Plate Mail Legs";
             }
               if (Item.equalsIgnoreCase("twohander"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 3;
              I = 81;
         Ineed = 3;
              sayI = "Two-handed Sword";
             }
               if (Item.equalsIgnoreCase("kite"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 1;
              I = 404;
         Ineed = 3;
              sayI = "Kite Shield";
             }
               if (Item.equalsIgnoreCase("battle"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 1;
              I = 93;
         Ineed = 3;
              sayI = "Battle Axe";
             }
               if (Item.equalsIgnoreCase("square"))  {
              Aone = 1;
              Atwo = 1;
              Athree = 0;
              I = 403;
         Ineed = 2;
              sayI = "Square Shield"; 
             }
               if (Item.equalsIgnoreCase("large"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 1;
              I = 112;
         Ineed = 2;
              sayI = "Great Helmet"; 
             }
             if (Item.equalsIgnoreCase("long"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 1;
              I = 75;
         Ineed = 2;
              sayI = "Long Sword"; 
             }
               if (Item.equalsIgnoreCase("scim"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 2;
              I = 398;
         Ineed = 2;
              sayI = "Scimitar"; 
             }
               if (Item.equalsIgnoreCase("short"))  {
              Aone = 0;
              Atwo = 2;
              Athree = 0;
              I = 397;
         Ineed = 1;
              sayI = "Short Sword"; 
             }
               if (Item.equalsIgnoreCase("heads"))  {
              Aone = 2;
              Atwo = 0;
              I = 674;
         Ineed = 1;
              sayI = "Arrow Heads"; 
             }
               if (Item.equalsIgnoreCase("med"))  {
              Aone = 1;
              Atwo = 0;
              Athree = 0;
              I = 399;
         Ineed = 1;
              sayI = "Medium Helmet"; 
             }
              if (Item.equalsIgnoreCase("mace"))  {
              Aone = 0;
              Atwo = 4;
              I = 98;
         Ineed = 1;
              sayI = "Mace"; 
             }
               if (Item.equalsIgnoreCase("hatchet"))  {
              Aone = 0;
              Atwo = 3;
              Athree = 0;
              I = 405;
         Ineed = 1;
              sayI = "Hatchet"; 
             }
               if (Item.equalsIgnoreCase("Dagger"))  {
              Aone = 0;
              Atwo = 0;
              I = 396;
         Ineed = 1;
              sayI = "Dagger"; 
             }
       }   
    String start = ("@gre@Jake: @whi@Smithing " + sayB + " " + sayI + "");
    DisplayMessage(start, 3);
    while (QuestMenu() == false && Running() == true)
        {
            int BankerID = GetNearestNPC(95);
            TalkToNPC(BankerID);
            Wait(2000);
        }
        Answer(0);
        while (Bank() == false && Running() == true)
        {
            Wait(50);
        }
        while (Bank() == true && Running() == true)
        {
            while(InvCount(I) > 0)
            {
                Deposit(I,1);
                Wait(50);
            }
            while(InvCount() < 30)
            {
                Withdraw(B,1);
                Wait(50);
            }

      CloseBank();
        }
       Walk(150,503);
       Walk(150,507);
       Walk(148,512);
       while (InvCount(B) > Ineed && Running() == true)
       {
            if(Fatigue() > 99 && Running() == true)
            {
                while (Sleeping() == false)
                {
                    Use(FindInv(1263));
                    Wait(3000);
                }
                while (Sleeping() == true)
                {
                    Wait(200);
                }
            }   
         UseOnObject(148,513,FindInv(B));
         Wait(500);
         for(; !QuestMenu(); Wait(100));
         Answer(Aone);
         for(; !QuestMenu(); Wait(100));
         Answer(Atwo);
    if(Athree != 10) {
          for(; !QuestMenu(); Wait(100));
          Answer(Athree);
    }
    Wait(500);
         }
        Walk(150,503);
}
      DisplayMessage("@gre@Jake: @red@Smither Stopped", 3);
    }
    }
} 