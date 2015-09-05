public class drunkwalker extends Script
{
   public drunkwalker(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"fally2dray", "barb2fally", "dray2barb", "lumby2edge", "fally2edge", "var2fally", "fally2var", "edge2castle", "var2al", "var2castle"};
   }
   public void start(String command, String parameter[])
   {
      DisplayMessage("@cya@ultimate @ora@walker - @gre@drunkenmuzz",3);
      while (Running())
      {
         if (command.equalsIgnoreCase("fally2dray"))
   {
         //Walk(291,582);
   Walk(279,602);
   Walk(268,610);
   Walk(250,609);
   Walk(232,609);
   Walk(229,625);
   Walk(220,632);
      }
   if (command.equalsIgnoreCase("barb2fally"))
   {
         //Walk(226,513);
   Walk(245,515);
   Walk(264,511);
   Walk(281,503);
   Walk(299,507);
   Walk(315,521);
   Walk(314,542);
   Walk(326,542);
   Walk(327,552);
      }
   if (command.equalsIgnoreCase("dray2barb"))
   {
         //Walk(232,625);
   Walk(238,607);
   Walk(239,585);
   Walk(240,568);
   Walk(240,550);
   Walk(239,532);
   Walk(240,515);
      }
   if (command.equalsIgnoreCase("fally2edge"))
    {
         Walk(295,550);
   Walk(312,537);
   Walk(314,518);
   Walk(295,503);
   Walk(277,505);
   Walk(255,513);
   Walk(299,514);
   Walk(220,489);
   Walk(221,470);
   Walk(225,458);
   Walk(219,446);
      }
   if (command.equalsIgnoreCase("var2fally"))
         {
     Walk(172,508);
   Walk(192,509);
   Walk(210,512);
   Walk(231,512);
   Walk(246,515);
   Walk(268,508);
   Walk(288,504);
   Walk(306,512);
   Walk(314,523);
   Walk(314,547);
   Walk(296,552);
      }
   if (command.equalsIgnoreCase("fally2var"))
         {
     Walk(296,552);
   Walk(314,547);
   Walk(314,523);
   Walk(306,512);
   Walk(288,504);
   Walk(268,508);
   Walk(246,515);
   Walk(231,512);
   Walk(210,512);
   Walk(192,509);
   Walk(172,508);
      }
   if (command.equalsIgnoreCase("edge2castle"))
        {
     Walk(220,434);
   Walk(241,432);
   Walk(257,417);
   Walk(256,392);
   Walk(252,378);
   Walk(261,363);
   Walk(264,351);
      }
   if (command.equalsIgnoreCase("var2al"))
       {
     Walk(84,508);
   Walk(75,531);
   Walk(76,570);
   Walk(81,589);
   Walk(89,598);
   Walk(90,622);
   Walk(88,645);
   Walk(80,668);
   Walk(83,686);
   Walk(85,695);
      }
   if (command.equalsIgnoreCase("var2cas"))
   {
     Walk(110,508);
   Walk(110,482);
   Walk(109,461);
   Walk(113,441);
   Walk(116,422);
   Walk(134,417);
   Walk(158,419);
   Walk(169,406);
   Walk(186,398);
   Walk(208,399);
   Walk(235,401);
   Walk(249,378);
   Walk(266,368);
      }
   
   if (command.equalsIgnoreCase("lumby2edge"))
   {
         Walk(114,653);
   Walk(107,656);
   Walk(100,649);
   Walk(102,639);
   Walk(105,632);
   Walk(106,622);
   Walk(111,613);
   Walk(113,604);
   Walk(110,597);
   Walk(107,587);
   Walk(101,580);
   Walk(100,572);
   Walk(107,571);
   Walk(115,566);
   Walk(123,560);
   Walk(127,553);
   Walk(130,544);
   Walk(131,535);
   Walk(130,526);
   Walk(131,518);
   Walk(134,511);
   Walk(140,509);
   Walk(147,508);
   Walk(157,508);
   Walk(167,507);
   Walk(176,512);
   Walk(186,516);
   Walk(196,514);
   Walk(204,513);
   Walk(214,512);
   Walk(217,506);
   Walk(215,496);
   Walk(215,486);
   Walk(216,480);
   Walk(218,475);
   Walk(222,470);
   Walk(225,465);
   Walk(225,458);
   Walk(221,453);
   Walk(220,449);
      }
      }
      DisplayMessage("@red@STOPPED", 3);
   }
} 