public class blood extends Script 
{ 

    public blood(mudclient mudclient) 
    { 
        super(mudclient); 
    } 

    public String[] getCommands() 
    { 
        return (new String[] { 
            "blood" 
        }); 
    } 

    public void start(String s, String as[]) 
    { 
        DisplayMessage("@reD@theving Them Dam Bloods", 3); 
        for(; Running(); Walk(615, 3394)) 
        { 
            do 
            { 
                if(InvCount(330) <= 0) 
                    break; 
                SetFightMode(2); 
                if(GetY() > 3000 && !InCombat()) 
                { 
                    AtObject2(614, 3401); 
                    Wait(1000); 
                } 
                if(GetX() >= 611 && GetX() <= 617 && GetY() >= 568 && GetY() <= 572 && Running()) 
                { 
                    Walk(612, 572); 
                    OpenDoor(612, 573, 0); 
                    Wait(100); 
                    Walk(609, 569); 
                    Walk(613, 561); 
                    Walk(617, 556); 
                    for(; GetY() >= 556; Wait(500)) 
                        CloseDoor(617, 556, 0); 

                    Walk(618, 552); 
                    for(; GetY() < 3000 && GetY() <= 555; Wait(500)) 
                        AtObject(618, 551); 

                    Walk(615, 3394); 
                } 
                if(GetY() > 3000 && !InCombat()) 
                { 
                    AtObject2(614, 3399); 
                    Wait(1000); 
                } 
                if(GetX() >= 611 && GetX() <= 617 && GetY() >= 568 && GetY() <= 572 && Running()) 
                { 
                    Walk(612, 572); 
                    OpenDoor(612, 573, 0); 
                    Wait(100); 
                    Walk(609, 569); 
                    Walk(613, 561); 
                    Walk(617, 556); 
                    for(; GetY() >= 556; Wait(500)) 
                        CloseDoor(617, 556, 0); 

                    Walk(618, 552); 
                    AtObject(618, 551); 
                    Walk(615, 3394); 
                } 
                for(; InCombat(); Wait(500)) 
                { 
                    SetFightMode(2); 
                    WalkNoWait(614, 3400); 
                } 

                if(GetStat(3) - GetCurrentStat(3) >= 12 && GetY() > 3000) 
                { 
                    for(; InvCount(335) > 0 && GetStat(3) - GetCurrentStat(3) >= 8 && GetY() > 3000; Println("You Have: " + InvCount(335) + " Cake Slices Left.")) 
                    { 
                        for(; InCombat(); Wait(500)) 
                            WalkNoWait(GetX(), GetY()); 

                        Use(FindInv(335)); 
                        Wait(1500); 
                        Println("Eating slice of cake.... HP now at: " + GetCurrentStat(3) + "."); 
                    } 

                    for(; InvCount(333) > 0 && GetStat(3) - GetCurrentStat(3) >= 8 && GetY() > 3000; Println("You Have: " + InvCount(333) + " Cake Portions Left.")) 
                    { 
                        for(; InCombat(); Wait(500)) 
                            WalkNoWait(GetX(), GetY()); 

                        Use(FindInv(333)); 
                        Wait(1500); 
                        Println("Eating Portion of cake... HP now at: " + GetCurrentStat(3) + "."); 
                    } 

                    for(; InvCount(330) > 0 && GetStat(3) - GetCurrentStat(3) >= 8 && GetY() > 3000; Println("You have: " + InvCount(330) + " Cakes Left.")) 
                    { 
                        for(; InCombat(); Wait(500)) 
                            WalkNoWait(GetX(), GetY()); 

                        Use(FindInv(330)); 
                        Wait(1500); 
                        Println("Eating Cake... Hp now at: " + GetCurrentStat(3) + "."); 
                    } 

                    for(; InvCount(335) == 0 && InvCount(333) == 0 && InvCount(330) == 0 && InvCount(373) > 0 && GetStat(3) - GetCurrentStat(3) >= 8 && GetY() > 3000; Println("You Have: " + InvCount(373) + " Lobsters Left.")) 
                    { 
                        for(; InCombat(); Wait(500)) 
                            WalkNoWait(GetX(), GetY()); 

                        Use(FindInv(373)); 
                        Wait(1500); 
                        Println("Eating Lobster... HP now at: " + GetCurrentStat(3) + "."); 
                    } 

                } 
                if(Fatigue() >= 90 && Running()) 
                { 
                    for(; GetY() > 3000 && GetY() != 3389; Walk(618, 3389)) 
                    { 
                        Walk(615, 3396); 
                        Walk(616, 3392); 
                    } 

                    for(; !Sleeping() && Running(); Println("Sleeping...")) 
                    { 
                        Use(FindInv(1263)); 
                        Wait(2500); 
                    } 

                    for(; Sleeping() && Running(); Wait(100)); 
                    Println("Sleeping Complete... Fighting Again.."); 
                } 
            } while(true); 
            Walk(616, 3391); 
            for(; GetY() >= 3000; Wait(100)) 
                AtObject(618, 3383); 

            Walk(617, 555); 
            for(; GetY() <= 555; Wait(1000)) 
                OpenDoor(617, 556, 0); 

            Walk(613, 561); 
            Walk(609, 567); 
            Walk(610, 572); 
            Walk(611, 578); 
            Walk(611, 584); 
            Walk(611, 590); 
            Walk(607, 595); 
            Walk(600, 597); 
            Walk(594, 603); 
            Walk(588, 603); 
            Walk(583, 604); 
            Walk(578, 605); 
            Walk(572, 605); 
            Walk(564, 605); 
            Walk(559, 606); 
            Walk(554, 607); 
            Walk(549, 606); 
            Walk(544, 602); 
            ForceWalk(543, 600); 
            do 
            { 
                if(InvCount() >= 30) 
                    break; 
                AtObject2(544, 599); 
                Wait(100); 
                if(Fatigue() >= 90 && Running()) 
                { 
                    for(; !Sleeping() && Running(); Println("Sleeping...")) 
                    { 
                        Use(FindInv(1263)); 
                        Wait(2500); 
                    } 

                    for(; Sleeping() && Running(); Wait(100)); 
                    Println("Sleeping Complete... Fighting Again.."); 
                } 
            } while(true); 
            Walk(551, 604); 
            Walk(556, 607); 
            Walk(559, 606); 
            Walk(565, 606); 
            Walk(573, 605); 
            Walk(580, 605); 
            Walk(586, 604); 
            Walk(593, 603); 
            Walk(596, 602); 
            Walk(599, 599); 
            Walk(603, 595); 
            Walk(609, 594); 
            Walk(611, 587); 
            Walk(611, 582); 
            Walk(611, 573); 
            Walk(609, 569); 
            Walk(612, 562); 
            Walk(617, 556); 
            for(; GetY() >= 556; Wait(500)) 
                CloseDoor(617, 556, 0); 

            Walk(618, 552); 
            AtObject(618, 551); 
        } 

        DisplayMessage("@whi@Hope you Die With Them too...", 3); 
    } 
}