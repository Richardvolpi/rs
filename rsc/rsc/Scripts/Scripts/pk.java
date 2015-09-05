public class pk extends Script 
{    
public pk(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"pk"}; 
     } 
     public void start(String command, String parameter[]) 
       { 
DisplayMessage("@red@Tidus: @ran@PK Script By Tidus - @whi@Look In The DOS Screen For HotKey Commands", 3);  
System.out.print("F3 - Toggle Ultimate Strength && Incredible Reflex On and Off         "); 
System.out.print("F4 - Toggle Protect Items On and Off                                  "); 
System.out.print("F5 - Eats Lobster/Swordy if you need to heal                          "); 
System.out.print("F6 - Wields R2H if in Inventory                                       "); 
System.out.print("F7 - Wields Long Bow if in Inventory                                  "); 
System.out.print("F8 - Walk Lumby to Edge                                               "); 
System.out.print("End - Walk Back To The Castle (Dont Forget Your PKng Items)           "); 
   }        
        int p = 0; 
        int pp = 0; 
     public void KeyPressed(int id) 
       { 
        if (id == 1013 && InvCount(81) > 0) 
        { 
          Wield(FindInv(81)); 
          id = 0; 
   } 
        if (id == 1014 && InvCount(188) > 0) 
        { 
          Wield(FindInv(188)); 
          id = 0; 
   } 
        if(id == 1012) 
        { 
     if (InvCount(373) > 0 && GetStat(3) - GetCurrentStat(3) >= 12) 
     { 
            Use(FindInv(373)); 
            id = 0; 
          } 
     if (InvCount(370) > 0 && GetStat(3) - GetCurrentStat(3) >= 14) 
     {    
            Use(FindInv(370)); 
            id = 0; 
          } 
    } 

        if(id == 1011) 
        { 
    if (p == 0) 
    { 
            PrayerOn(8); 
            id = 0; 
            p = 1; 
    } else { 
            PrayerOff(8); 
            id = 0; 
            p = 0; 
    } 
   } 

        if(id == 1010) 
        { 
    if (pp == 0) 
    { 
            PrayerOn(10); 
            PrayerOn(11); 
            id = 0; 
            pp = 1; 
    } else { 
            PrayerOff(10); 
            PrayerOff(11); 
            id = 0; 
            pp = 0; 
    } 
   } 
        if(id == 1015) 
        { 
   Walk(132,636); 
   Walk(134,625); 
   Walk(135,619); 
   Walk(140,617); 
   Walk(145,616); 
   Walk(153,614); 
   Walk(162,612); 
   Walk(171,610); 
   Walk(180,606); 
   Walk(190,605); 
   Walk(191,596); 
   Walk(191,587); 
   Walk(191,578); 
   Walk(191,569); 
   Walk(193,559); 
   Walk(192,550); 
   Walk(191,543); 
   Walk(198,535); 
   Walk(206,529); 
   Walk(210,525); 
   Walk(216,518); 
   Walk(216,511); 
   Walk(216,503); 
   Walk(217,495); 
   Walk(218,487); 
   Walk(219,480); 
   Walk(220,473); 
   Walk(225,466); 
   Walk(223,458); 
   Walk(222,452); 
   Walk(217,450);  
        } 
        if(id == 1001) 
        { 
   Walk(228, 631); 
   Walk(235, 624);; 
   Walk(240, 616); 
   Walk(240, 606); 
   Walk(239, 594); 
   Walk(238, 583); 
   Walk(243, 573); 
   Walk(241, 563); 
   Walk(242, 564); 
   Walk(241, 553); 
   Walk(240, 543); 
   Walk(239, 533);; 
   Walk(239, 523);; 
   Walk(238, 513); 
   Walk(227, 513); 
   Walk(220, 505); 
   Walk(216, 494); 
   Walk(217, 483); 
   Walk(220, 473); 
   Walk(226, 458); 
   Walk(221, 449); 
   Walk(216, 450); 
   } 
        } 
        } 
