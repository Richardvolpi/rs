public class allsmith2 extends Methods
{
    public allsmith2(mudclient mc){super(mc);}
    private long l = -1;
    private int a = -1;
    private int b = -1;
    private String WhatItem;
    private int barID = -1;
    private int ItemID = 62;
    private int Need = -1;
    private int ans1 = -1;
    private int ans2 = -1;
    private int ans3 = -1;
    private int chk1 = -1;
    private int chk2 = -1;
    private int chk3 = -1;
    private String[] option1 = {"Bronze","Iron","Steel","Mithril","Adamantite","Runite"};
    private String[] option2 = {"Dagger","Hatchet","Mace","Medium Helmet","Arrow Heads","Short Sword","Scimitar","Long Sword","Large Helmet","Square Shield","Battle Axe","Kite Shield","2-Handed Sword","Chain Mail Body","Plated Skirt","Plate Mail Body","Plate Mail Leg"};

    public void MainBody(String[] Args)
    {
        a = GetOption("Which kind of bar would you like to smith?",option1);
        if(a == 0) barID = 169;
        else if(a == 1) barID = 170;
        else if(a == 2) barID = 171;
        else if(a == 3) barID = 173;
        else if(a == 4) barID = 174;
        else if(a == 5) barID = 408;
        b = GetOption("Which kind of item would you like to smith?",option2);
        if(a == 0 && b == 0)
        {
           WhatItem = "Bronze Dagger";
           ItemID = 62;
           Need = 1;
           ans1 = 0;
           ans2 = 0;
        }
        else if(a == 0 && b == 1)
        {
           WhatItem = "Bronze Hatchet";
           ItemID = 87;
           Need = 1;
           ans1 = 0;
           ans2 = 3;
           ans3 = 0;
        }
        else if(a == 0 && b == 2)
        {
           WhatItem = "Bronze Mace";
           ItemID = 94;
           Need = 1;
           ans1 = 0;
           ans2 = 4;
        }
        else if(a == 0 && b == 3)
        {
           WhatItem = "Medium Bronze Helmet";
           ItemID = 104;
           Need = 1;
           ans1 = 1;
           ans2 = 0;
           ans3 = 0;
        }
        else if(a == 0 && b == 4)
        {
           WhatItem = "Bronze Arrow Heads";
           ItemID = 669;
           Need = 1;
           ans1 = 2;
           ans2 = 0;
        }
        else if(a == 0 && b == 5)
        {
           WhatItem = "Bronze Short Sword";
           ItemID = 66;
           Need = 1;
           ans1 = 0;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 0 && b == 6)
        {
           WhatItem = "Bronze Scimitar";
           ItemID = 82;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 2;
        }
        else if(a == 0 && b == 7)
        {
           WhatItem = "Bronze Long Sword";
           ItemID = 70;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 0 && b == 8)
        {
           WhatItem = "Large Bronze Helmet";
           ItemID = 108;
           Need = 2;
           ans1 = 1;
           ans2 = 0;
           ans3 = 1;
        }
        else if(a == 0 && b == 9)
        {
           WhatItem = "Bronze Square Shield";
           ItemID = 124;
           Need = 2;
           ans1 = 1;
           ans2 = 1;
           ans3 = 0;
        }
        else if(a == 0 && b == 10)
        {
           WhatItem = "Bronze Battle Axe";
           ItemID = 205;
           Need = 3;
           ans1 = 0;
           ans2 = 3;
           ans3 = 1;
        }
        else if(a == 0 && b == 11)
        {
           WhatItem = "Bronze Kite Shield";
           ItemID = 128;
           Need = 3;
           ans1 = 1;
           ans2 = 1;
           ans3 = 1;
        }
        else if(a == 0 && b == 12)
        {
           WhatItem = "Bronze 2-Handed Sword";
           ItemID = 76;
           Need = 3;
           ans1 = 0;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 0 && b == 13)
        {
           WhatItem = "Bronze Chain Mail Body";
           ItemID = 113;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 0 && b == 14)
        {
           WhatItem = "Bronze Plated Skirt";
           ItemID = 214;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 0 && b == 15)
        {
           WhatItem = "Bronze Plate Mail Body";
           ItemID = 117;
           Need = 5;
           ans1 = 1;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 0 && b == 16)
        {
           WhatItem = "Bronze Plate Mail Leg";
           ItemID = 206;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 2;
        }



        else if(a == 1 && b == 0)
        {
           WhatItem = "Iron Dagger";
           ItemID = 63;
           Need = 1;
           ans1 = 0;
           ans2 = 0;
        }
        else if(a == 1 && b == 1)
        {
           WhatItem = "Iron Hatchet";
           ItemID = 12;
           Need = 1;
           ans1 = 0;
           ans2 = 3;
           ans3 = 0;
        }
        else if(a == 1 && b == 2)
        {
           WhatItem = "Iron Mace";
           ItemID = 0;
           Need = 1;
           ans1 = 0;
           ans2 = 4;
        }
        else if(a == 1 && b == 3)
        {
           WhatItem = "Medium Iron Helmet";
           ItemID = 5;
           Need = 1;
           ans1 = 1;
           ans2 = 0;
           ans3 = 0;
        }
        else if(a == 1 && b == 4)
        {
           WhatItem = "Iron Arrow Heads";
           ItemID = 670;
           Need = 1;
           ans1 = 2;
           ans2 = 0;
        }
        else if(a == 1 && b == 5)
        {
           WhatItem = "Iron Short Sword";
           ItemID = 1;
           Need = 1;
           ans1 = 0;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 1 && b == 6)
        {
           WhatItem = "Iron Scimitar";
           ItemID = 83;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 2;
        }
        else if(a == 1 && b == 7)
        {
           WhatItem = "Iron Long Sword";
           ItemID = 71;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 1 && b == 8)
        {
           WhatItem = "Large Iron Helmet";
           ItemID = 6;
           Need = 2;
           ans1 = 1;
           ans2 = 0;
           ans3 = 1;
        }
        else if(a == 1 && b == 9)
        {
           WhatItem = "Iron Square Shield";
           ItemID = 3;
           Need = 2;
           ans1 = 1;
           ans2 = 1;
           ans3 = 0;
        }
        else if(a == 1 && b == 10)
        {
           WhatItem = "Iron Battle Axe";
           ItemID = 89;
           Need = 3;
           ans1 = 0;
           ans2 = 3;
           ans3 = 1;
        }
        else if(a == 1 && b == 11)
        {
           WhatItem = "Iron Kite Shield";
           ItemID = 2;
           Need = 3;
           ans1 = 1;
           ans2 = 1;
           ans3 = 1;
        }
        else if(a == 1 && b == 12)
        {
           WhatItem = "Iron 2-Handed Sword";
           ItemID = 77;
           Need = 3;
           ans1 = 0;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 1 && b == 13)
        {
           WhatItem = "Iron Chain Mail Body";
           ItemID = 7;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 1 && b == 14)
        {
           WhatItem = "Iron Plated Skirt";
           ItemID = 215;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 1 && b == 15)
        {
           WhatItem = "Iron Plate Mail Body";
           ItemID = 8;
           Need = 5;
           ans1 = 1;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 1 && b == 16)
        {
           WhatItem = "Iron Plate Mail Leg";
           ItemID = 9;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 2;
        }




        else if(a == 2 && b == 0)
        {
           WhatItem = "Steel Dagger";
           ItemID = 63;
           Need = 1;
           ans1 = 0;
           ans2 = 0;
        }
        else if(a == 2 && b == 1)
        {
           WhatItem = "Steel Hatchet";
           ItemID = 88;
           Need = 1;
           ans1 = 0;
           ans2 = 3;
           ans3 = 0;
        }
        else if(a == 2 && b == 2)
        {
           WhatItem = "Steel Mace";
           ItemID = 95;
           Need = 1;
           ans1 = 0;
           ans2 = 4;
        }
        else if(a == 2 && b == 3)
        {
           WhatItem = "Medium Steel Helmet";
           ItemID = 105;
           Need = 1;
           ans1 = 1;
           ans2 = 0;
           ans3 = 0;
        }
        else if(a == 2 && b == 4)
        {
           WhatItem = "Steel Arrow Heads";
           ItemID = 671;
           Need = 1;
           ans1 = 2;
           ans2 = 0;
        }
        else if(a == 2 && b == 5)
        {
           WhatItem = "Steel Short Sword";
           ItemID = 67;
           Need = 1;
           ans1 = 0;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 2 && b == 6)
        {
           WhatItem = "Steel Scimitar";
           ItemID = 84;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 2;
        }
        else if(a == 2 && b == 7)
        {
           WhatItem = "Steel Long Sword";
           ItemID = 72;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 2 && b == 8)
        {
           WhatItem = "Large Steel Helmet";
           ItemID = 109;
           Need = 2;
           ans1 = 1;
           ans2 = 0;
           ans3 = 1;
        }
        else if(a == 2 && b == 9)
        {
           WhatItem = "Steel Square Shield";
           ItemID = 125;
           Need = 2;
           ans1 = 1;
           ans2 = 1;
           ans3 = 0;
        }
        else if(a == 2 && b == 10)
        {
           WhatItem = "Steel Battle Axe";
           ItemID = 90;
           Need = 3;
           ans1 = 0;
           ans2 = 3;
           ans3 = 1;
        }
        else if(a == 2 && b == 11)
        {
           WhatItem = "Steel Kite Shield";
           ItemID = 129;
           Need = 3;
           ans1 = 1;
           ans2 = 1;
           ans3 = 1;
        }
        else if(a == 2 && b == 12)
        {
           WhatItem = "Steel 2-Handed Sword";
           ItemID = 78;
           Need = 3;
           ans1 = 0;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 2 && b == 13)
        {
           WhatItem = "Steel Chain Mail Body";
           ItemID = 114;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 2 && b == 14)
        {
           WhatItem = "Steel Plated Skirt";
           ItemID = 225;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 2 && b == 15)
        {
           WhatItem = "Steel Plate Mail Body";
           ItemID = 118;
           Need = 5;
           ans1 = 1;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 2 && b == 16)
        {
           WhatItem = "Steel Plate Mail Leg";
           ItemID = 121;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 2;
        }





        else if(a == 3 && b == 0)
        {
           WhatItem = "Mithril Dagger";
           ItemID = 64;
           Need = 1;
           ans1 = 0;
           ans2 = 0;
        }
        else if(a == 3 && b == 1)
        {
           WhatItem = "Mithril Hatchet";
           ItemID = 203;
           Need = 1;
           ans1 = 0;
           ans2 = 3;
           ans3 = 0;
        }
        else if(a == 3 && b == 2)
        {
           WhatItem = "Mithril Mace";
           ItemID = 96;
           Need = 1;
           ans1 = 0;
           ans2 = 4;
        }
        else if(a == 3 && b == 3)
        {
           WhatItem = "Medium Mithril Helmet";
           ItemID = 106;
           Need = 1;
           ans1 = 1;
           ans2 = 0;
           ans3 = 0;
        }
        else if(a == 3 && b == 4)
        {
           WhatItem = "Mithril Arrow Heads";
           ItemID = 672;
           Need = 1;
           ans1 = 2;
           ans2 = 0;
        }
        else if(a == 3 && b == 5)
        {
           WhatItem = "Mithril Short Sword";
           ItemID = 68;
           Need = 1;
           ans1 = 0;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 3 && b == 6)
        {
           WhatItem = "Mithril Scimitar";
           ItemID = 85;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 2;
        }
        else if(a == 3 && b == 7)
        {
           WhatItem = "Mithril Long Sword";
           ItemID = 73;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 3 && b == 8)
        {
           WhatItem = "Large Mithril Helmet";
           ItemID = 110;
           Need = 2;
           ans1 = 1;
           ans2 = 0;
           ans3 = 1;
        }
        else if(a == 3 && b == 9)
        {
           WhatItem = "Mithril Square Shield";
           ItemID = 126;
           Need = 2;
           ans1 = 1;
           ans2 = 1;
           ans3 = 0;
        }
        else if(a == 3 && b == 10)
        {
           WhatItem = "Mithril Battle Axe";
           ItemID = 91;
           Need = 3;
           ans1 = 0;
           ans2 = 3;
           ans3 = 1;
        }
        else if(a == 3 && b == 11)
        {
           WhatItem = "Mithril Kite Shield";
           ItemID = 130;
           Need = 3;
           ans1 = 1;
           ans2 = 1;
           ans3 = 1;
        }
        else if(a == 3 && b == 12)
        {
           WhatItem = "Mithril 2-Handed Sword";
           ItemID = 79;
           Need = 3;
           ans1 = 0;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 3 && b == 13)
        {
           WhatItem = "Mithril Chain Mail Body";
           ItemID = 115;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 3 && b == 14)
        {
           WhatItem = "Mithril Plated Skirt";
           ItemID = 226;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 3 && b == 15)
        {
           WhatItem = "Mithril Plate Mail Body";
           ItemID = 119;
           Need = 5;
           ans1 = 1;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 3 && b == 16)
        {
           WhatItem = "Mithril Plate Mail Leg";
           ItemID = 122;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 2;
        }





        else if(a == 4 && b == 0)
        {
           WhatItem = "Adamantite Dagger";
           ItemID = 65;
           Need = 1;
           ans1 = 0;
           ans2 = 0;
        }
        else if(a == 4 && b == 1)
        {
           WhatItem = "Adamantite Hatchet";
           ItemID = 204;
           Need = 1;
           ans1 = 0;
           ans2 = 3;
           ans3 = 0;
        }
        else if(a == 4 && b == 2)
        {
           WhatItem = "Adamantite Mace";
           ItemID = 97;
           Need = 1;
           ans1 = 0;
           ans2 = 4;
        }
        else if(a == 4 && b == 3)
        {
           WhatItem = "Medium Adamantite Helmet";
           ItemID = 107;
           Need = 1;
           ans1 = 1;
           ans2 = 0;
           ans3 = 0;
        }
        else if(a == 4 && b == 4)
        {
           WhatItem = "Adamantite Arrow Heads";
           ItemID = 673;
           Need = 1;
           ans1 = 2;
           ans2 = 0;
        }
        else if(a == 4 && b == 5)
        {
           WhatItem = "Adamantite Short Sword";
           ItemID = 69;
           Need = 1;
           ans1 = 0;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 4 && b == 6)
        {
           WhatItem = "Adamantite Scimitar";
           ItemID = 86;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 2;
        }
        else if(a == 4 && b == 7)
        {
           WhatItem = "Adamantite Long Sword";
           ItemID = 74;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 4 && b == 8)
        {
           WhatItem = "Large Adamantite Helmet";
           ItemID = 111;
           Need = 2;
           ans1 = 1;
           ans2 = 0;
           ans3 = 1;
        }
        else if(a == 4 && b == 9)
        {
           WhatItem = "Adamantite Square Shield";
           ItemID = 127;
           Need = 2;
           ans1 = 1;
           ans2 = 1;
           ans3 = 0;
        }
        else if(a == 4 && b == 10)
        {
           WhatItem = "Adamantite Battle Axe";
           ItemID = 92;
           Need = 3;
           ans1 = 0;
           ans2 = 3;
           ans3 = 1;
        }
        else if(a == 4 && b == 11)
        {
           WhatItem = "Adamantite Kite Shield";
           ItemID = 131;
           Need = 3;
           ans1 = 1;
           ans2 = 1;
           ans3 = 1;
        }
        else if(a == 4 && b == 12)
        {
           WhatItem = "Adamantite 2-Handed Sword";
           ItemID = 80;
           Need = 3;
           ans1 = 0;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 4 && b == 13)
        {
           WhatItem = "Adamantite Chain Mail Body";
           ItemID = 116;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 4 && b == 14)
        {
           WhatItem = "Adamantite Plated Skirt";
           ItemID = 227;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 4 && b == 15)
        {
           WhatItem = "Adamantite Plate Mail Body";
           ItemID = 120;
           Need = 5;
           ans1 = 1;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 4 && b == 16)
        {
           WhatItem = "Adamantite Plate Mail Leg";
           ItemID = 123;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 2;
        }





        else if(a == 5 && b == 0)
        {
           WhatItem = "Rune Dagger";
           ItemID = 396;
           Need = 1;
           ans1 = 0;
           ans2 = 0;
        }
        else if(a == 5 && b == 1)
        {
           WhatItem = "Rune Hatchet";
           ItemID = 405;
           Need = 1;
           ans1 = 0;
           ans2 = 3;
           ans3 = 0;
        }
        else if(a == 5 && b == 2)
        {
           WhatItem = "Rune Mace";
           ItemID = 98;
           Need = 1;
           ans1 = 0;
           ans2 = 4;
        }
        else if(a == 5 && b == 3)
        {
           WhatItem = "Medium Rune Helmet";
           ItemID = 399;
           Need = 1;
           ans1 = 1;
           ans2 = 0;
           ans3 = 0;
        }
        else if(a == 5 && b == 4)
        {
           WhatItem = "Rune Arrow Heads";
           ItemID = 674;
           Need = 1;
           ans1 = 2;
           ans2 = 0;
        }
        else if(a == 5 && b == 5)
        {
           WhatItem = "Rune Short Sword";
           ItemID = 397;
           Need = 1;
           ans1 = 0;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 5 && b == 6)
        {
           WhatItem = "Rune Scimitar";
           ItemID = 398;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 2;
        }
        else if(a == 5 && b == 7)
        {
           WhatItem = "Rune Long Sword";
           ItemID = 75;
           Need = 2;
           ans1 = 0;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 5 && b == 8)
        {
           WhatItem = "Large Rune Helmet";
           ItemID = 112;
           Need = 2;
           ans1 = 1;
           ans2 = 0;
           ans3 = 1;
        }
        else if(a == 5 && b == 9)
        {
           WhatItem = "Rune Square Shield";
           ItemID = 403;
           Need = 2;
           ans1 = 1;
           ans2 = 1;
           ans3 = 0;
        }
        else if(a == 5 && b == 10)
        {
           WhatItem = "Rune Battle Axe";
           ItemID = 93;
           Need = 3;
           ans1 = 0;
           ans2 = 3;
           ans3 = 1;
        }
        else if(a == 5 && b == 11)
        {
           WhatItem = "Rune Kite Shield";
           ItemID = 404;
           Need = 3;
           ans1 = 1;
           ans2 = 1;
           ans3 = 1;
        }
        else if(a == 5 && b == 12)
        {
           WhatItem = "Rune 2-Handed Sword";
           ItemID = 81;
           Need = 3;
           ans1 = 0;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 5 && b == 13)
        {
           WhatItem = "Rune Chain Mail Body";
           ItemID = 400;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 0;
        }
        else if(a == 5 && b == 14)
        {
           WhatItem = "Rune Skirt";
           ItemID = 406;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 3;
        }
        else if(a == 5 && b == 15)
        {
           WhatItem = "Rune Plate Mail Body";
           ItemID = 401;
           Need = 5;
           ans1 = 1;
           ans2 = 2;
           ans3 = 1;
        }
        else if(a == 5 && b == 16)
        {
           WhatItem = "Rune Plate Mail Leg";
           ItemID = 402;
           Need = 3;
           ans1 = 1;
           ans2 = 2;
           ans3 = 2;
        }
        else
    End("Invalid Item");
        AutoLogin(true);
        Display("@ran@The Ultimate Everything smither script!!! -- @gre@Nattawat");
        Display("@whi@You chose to smith @red@" + WhatItem + "@whi@...");
        while(Running())
        {
           smithing();
           Wait(300);
           banking();
           Wait(300);
        }
    }

    public void smithing()
    {
       Display("@whi@Smithing " + WhatItem + "...");
       while(CountInv(barID) >= Need && Running())   //while you have enough bars to smith the item
       {
           clearChk();   //call public void clearChk()
           if(!SleepIfAt(95)) {End("No sleeping bag found, SCRIPTED STOPPED!");}   //if the fatigue reached 95, it will sleep, stop the script if there's no sleeping bag
           UseOnObject(GetItemPos(barID), 148, 513);   //use your bar with an anvil
           Wait(1000);   //wait...
           if(QuestMenu() && chk1 == -1 && chk2 == -1 && chk3 == -1 && Running())   //if the it ask you the 1st question...
           {
               Answer(ans1);   //you answer the 1st question as you selected
               chk1 = 1;   //like a boolean, chk1 turn from -1 into 1 after you answer 1st question
           }
           l = System.currentTimeMillis();   //declare l as system's current time milliseconds
           while(!QuestMenu() && chk1 == 1 && chk2 == -1 && chk3 == -1 && System.currentTimeMillis() - l < 6000 && Running())   //while chk1 = 1 (already answer 1st question) it will wait for next question.  This loop will break after 6 seconds or after the question appear.
           {
               Wait(10);   //wait and repeat until next question appear
           }
           if(QuestMenu() && chk1 == 1 && chk2 == -1 && chk3 == -1 && Running())   //if you already answer 1st question and next question appear
           {
               Answer(ans2);   //answering the 2nd question
               chk2 = 1;   //turn from chk2 = -1 into 1
           }
           l = System.currentTimeMillis();   //declare l as system's current time milliseconds
           while(!QuestMenu() && chk1 == 1 && chk2 == 1 && ans3 != -1 && chk3 == -1 && System.currentTimeMillis() - l < 6000 && Running())   //while chk1 = 1 and chk2 = 2 (already answer 1st and 2nd question) and ans3 not equal to -1 (if there's a valid answer for question 3) it will wait for next question.  This loop will break after 6 seconds or after the question appear.
           {
               Wait(10);   //wait and repeat until next question appear
           }
           if(QuestMenu() && chk1 == 1 && chk2 == 1 && ans3 != -1 && chk3 == -1 && Running())   //if you already answer 1st and 2nd question and 3rd answer is valid and next question appear
           {
               Answer(ans3);   //answering the 3rd question
               chk3 = 1;   //chk3 = 1 doesnt really do anything, but it should make you get out of the loop
           }
           Wait(1000);   //wait for 1 second for next item to smith
       }
    }

    public void clearChk()
    {
        chk1 = -1;   //clear chk1 from 1 to -1
        chk2 = -1;   //clear chk2 from 1 to -1
        chk3 = -1;   //clear chk3 from 1 to -1
    }

    public void banking()
    {
        while(!QuestMenu() && Running())
        {
           int[] Npc = GetNpcById(95);   //get array of the banker
           if(Npc[0] != -1)   //if there is a banker
           TalkToNpc(Npc[0]);   //it will talk to the banker
           Wait(1500);   //wait for 1.5 second
        }
        while(QuestMenu() && Running())   //wait for answer to appear
        {
           Answer(0);   //answer I'd like to access my bank account
           Wait(8000);   //wait for 8 second before going to next procedure
        }
        while (!InBank() && CountInv(ItemID) > 0)   //if it havn't fully finish banking and still not inside the bank screen...
           banking();   //call banking() to start the banking method all over again
        while (InBank() && CountInv(ItemID) > 0)   //while it havn't fully finish banking and IS inside the bank screen...
        {
           while (CountInv(ItemID) > 0 && InBank())   //if you have the item you smith in your inventory...
           {
              Deposit(ItemID,CountInv(ItemID));   //it will deposit them ALL at once
              Wait(Rand(600,800));   //wait, randomly from 600ms to 800ms
           }
           while (CountInv() < 30 && InBank())   //while you didnt have full inventory...
           {
              Withdraw(barID,1);   //withdrawing the bars until are full inventory
              Wait(Rand(150,300));   //wait, randomly from 150ms to 300ms
           }
           while (CountInv() < 30 && !InBank())   //checking... if you didn't have full inventory YET you are out of bank screen...
           {
              banking();   //call the banking() method again to make sure you did the banking complete and make sure it's flawless
           }
           CloseBank();   //close the bank window when everything is perfect
        }
    }

    public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")))
        {
            Wait(Rand(4000,7000));
            Speak("Wow, you are really " + sender + "?!?");
            Wait(Rand(5000,6000));
            Speak("let me take a screenshot woopies!!");
            Wait(Rand(5000,6000));
            Speak("brb 1 sec, i gotta paste it in paint :)");
            Wait(Rand(5000,6000));
            LogOut();
            Die();
        }
    }
    
    public void OnPrivateMessage(String sender, String message)
    {
        if((sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")))
        {
            AddToFriends(sender);
            Wait(Rand(5000,8000));
            SendPM(sender, "Hey " + sender + " what do you need? :P");
            Wait(Rand(5000,6000));
            SendPM(sender, "hold on, my dad is coming, ill be dead if he caught me playing");
            Wait(Rand(5000,6000));
            LogOut();
            Die();
        }
    }

    public void OnServerMessage(String message)
    {
    }
}
