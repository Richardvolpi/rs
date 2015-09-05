public class Ebus extends Script
{
   public Ebus(mudclient rs)
    {
        super(rs);
    }

   public String[] getCommands()
    {
        return new String[]{ "ebus" };
    }

   public void ServerMessage(String message)
   {

   }
    public String SayMsg = "";
 
   public void SayAfterTime()
   {
      new Thread
      (
         new Runnable()
         {
            public void run()
            {
               while (Running())
               {
                  if(SayMsg != "")
                  {
                     Wait(3000);
                     Say(SayMsg);
                     SayMsg = "";
                  }

                  Wait(10);
               }
            }
         }
      ).start();
   }
   
    // Checks if one string occures in another
   public boolean StrStr(String haystack, String needle)
   {
      if(haystack.toLowerCase().indexOf(needle.toLowerCase()) != -1)
      {
         return true;
      }

      return false;
   }

   
    // Chooses a random answer from an array
   public void RandomAnswer(String[] Answers, String ChatMsg)
   {
      int Possibilities = 0;
      double Random = 0;
      int Key = 0;

      Possibilities = Answers.length;
      Random = Math.random();
        Key = (int)Math.round(Random*Possibilities);

      if(Key == Possibilities)
      {
         Key--;
      }
       
      SayMsg = Answers[Key];

      Println("Chat message: "+ChatMsg);
      Println("Answer: "+Answers[Key]);
      Println("");

   }
   
   // Answer arrays.. make up more if you like..
   // And then share with other on the forums ;)

   public String[] GreetingAnswers =
   {
      "@dre@Hi..",
      "@dre@Sup..",
      "@dre@Hi.. how are you cexy?",
      "@dre@Hmm.. hi..",
      "@dre@It sure is boring here..",
      "@dre@Bah.. another",
      "@dre@Hi..cex thx plz",
      "@dre@:(",
      "@dre@hello im a bus",
      "@dre@Ahh.. I'm going bananas here",
      "@dre@Dont say,that you are here for a ride..", 
      "@dre@B00ring :P", 
      "@dre@Hi to you too.."
   };


   public String[] ThanksAnswers =
   {
      "@dre@have a nice day..",
      "@dre@add me if u wish?",
      "@dre@good luck",
      "@dre@np",
      "@dre@anytime..",
     
   };

   public String[] AutoAnswers =
   {
      "@dre@I dont auto :S",
      "@dre@I never auto..",
      "@dre@Heh?",
      "@dre@I dun auto..",
      "@dre@Me?",
      "@dre@Wdf?",
      "@dre@Why should i auto?",
      "@dre@Ahh.. why does everyone think everyone autos?",
      "@dre@I have never cheated...",
      "@dre@I hate cheating..",
      "@dre@There sure are so many cheaters out there..",
      "@dre@Everyone else here prolly does..",
      "@dre@Hmm..",
      "@dre@Never!",
      "@dre@What are you talking about?",
      "@dre@?",
      "@dre@Aww..?",
      "@dre@I love you too.. but I dont auto..",
      "@dre@Just because i train here.. I'm defenately autoing?",
      "@dre@No I dont..",
      "@dre@I dont know what you are talking about...",
      "@dre@You are accuseing me?",
      "@dre@I sure as hell dont..",
      "@dre@Sdfu...",
      "@dre@Nvm that..",
      "@dre@I'm a honest player..",
      "@dre@Dont annoy me with this..",
      "@dre@Bug someone else with this.."
   };

   public String[] Auto2Answers =
   {
      "@dre@None of your business..",
      "@dre@nope i just get bored",
      "@dre@i just have no life",
      "@dre@no never",
      "@dre@autoers r for newbs",
      "@dre@im payed to do this by jagex.. jk",
      "@dre@u mine and train and pk, i walk",
      "@dre@nopers",
      "@dre@never ever",
      "@dre@where do u get that",
      "@dre@Hmm.. secret..",
      "@dre@You dont really have to know them..",
      "@dre@a better one.. not",
      "@dre@i wish..",
      "@dre@Aww..u caught me.. jk",
      "@dre@Hmm..."
   };

   public String[] NoobAnswers =
   {
      "@whi@Me?", 
      "@dre@Are you talking to meh?.. fauk u",
      "@dre@Whos the..",
      "@dre@And you are better?",
      "@dre@I dont think so..",
      "@dre@?",
      "@dre@I love you too.. newb",
      "@dre@Look who's talking...",
      "@dre@Who gave you the permission to talk?",
      "@dre@And that makes you?",
      "@dre@Whatever you say..",
      "@dre@And you are?",
      "@dre@Me.... heh"
   };

   public String[] ReportAnswers =
   {
      "I dont auto :S",
      "I never auto..",
      "Heh?",
      "Wdf?",
      "Why should i auto?",
      "Ahh.. why does everyone think everyone autos?",
      "I have never cheated...",
      "I hate cheating..",
      "What are you talking about?",
      "?",
      "Aww..?",
      "I love you too.. but I dont auto..",
      "Just because i train here.. I'm defenately autoing?",
      "I dont know what you are talking about...",
      "You are accuseing me?",
      "I'm a honest player..",
      "Dont annoy me with this..",
      "Go ahead.. I dont auto",
      "Me.... heh",
      "I dont auto :S",
      "I never auto..",
      "Me?",
      "?",
      "Heh?",
      "I dun auto..",
      "And you are?",
      "Me?",
      "Wdf?",
      "Hmm..."
   };

   public String[] BusAnswers =
   {
      "@dre@Me?",
      "@dre@Hmm..",
      "@dre@Aww...so cexy",
      "@dre@hello!",
      "@dre@ok",
      "@dre@what...",
      "@dre@yes i do.."
   };

   public String[] DoAnswers =
   {
      "@whi@Im very cexy..",
      "@whi@Everyone likes me",
      "@whi@I need beer!!..",
      "@whi@ok then",
      "@whi@:)",
      "@whi@im gai.. jk ..",
      "@dre@do u like in the ass?",
      "@dre@I dont know..",
      "@dre@Sure.. but not in this life..",
      "@dre@Walking.. gets all the girls"
   };

   public String[] GoAnswers =
   {
      "@dre@why?",
      "@dre@this bus is powered by Mp",
      "@dre@hold on let me hit the nos",
      "@dre@im going as fast as i can!!",
      "@dr@faster how about i stop?",
      "@dre@walk ur self",
      "@dre@haha.. no",
      "@dre@what do i look like? a slave .. rofl",
      "@dre@quiting... in 9seconds.lol not!!"
   };
   
   // Checks the message and if finds a keyword, then answers randomly to it..
   public void ChatMessage(String message)
   {
    if(StrStr(message, "hi") || StrStr(message, "sup") || StrStr(message, "hello") || StrStr(message, "bus"))
      {
         RandomAnswer(GreetingAnswers, message); 
      }
      else if(StrStr(message, "ty") || StrStr(message, "thanks"))
      {
         RandomAnswer(ThanksAnswers, message);
      }
      else if(StrStr(message, "autoing") || StrStr(message, "au2er") || StrStr(message, "autominer") || StrStr(message, "r00n"))
      {
         RandomAnswer(AutoAnswers, message);
      }
      else if(StrStr(message, "autowalk") || StrStr(message, "st") || StrStr(message, "script") || StrStr(message, "sbot") || StrStr(message, "ar") || StrStr(message, "hax") || StrStr(message, "cheets") || StrStr(message, "scar") || StrStr(message, "walker") || StrStr(message, "autotalk") || StrStr(message, "autotalker"))
      {
         RandomAnswer(Auto2Answers, message);
      }
      else if(StrStr(message, "noob") || StrStr(message, "n00b") || StrStr(message, "newb") || StrStr(message, "newbie") || StrStr(message, "fking"))
      {
         RandomAnswer(NoobAnswers, message);
      }
      else if(StrStr(message, "report"))
      {
         RandomAnswer(ReportAnswers, message);
      }
      else if(StrStr(message, "bus") || StrStr(message, "hey") || StrStr(message, "you"))
      {
         RandomAnswer(BusAnswers, message);
      }
      else if(StrStr(message, "love") || StrStr(message, "cex") || StrStr(message, "hot") || StrStr(message, "sweet"))
      {
         RandomAnswer(DoAnswers, message);
      }
      else if(StrStr(message, "comeon") || StrStr(message, "hurry") || StrStr(message, "faster") || StrStr(message, "slow") || StrStr(message, "go"))
      {
         RandomAnswer(GoAnswers, message);
      }
   }
   public void start(String command, String parameter[])
   {
   DisplayMessage("@cya@bus106 edge to lumby@whi@by",3);
   DisplayMessage("@or2@Mp",3);
   SayAfterTime();
   while (Running())
   {
      if (Fatigue() >= 95 && Running() == true)
      {
         while (Sleeping() == false && Running() == true)
         {
            Use(FindInv(1263));
            Wait(2500);
         }
         while (Sleeping() == true && Running() == true)
            Wait(100);
}
       
Say("@blu@Meep Meep!!");
Wait(1000);
Beep();
Say("@whi@Bangbus - Next stop EDGEVille");
Wait(500);
Say("@whi@Bus108 - Departing to Edge in 30seconds");
Wait(1000);
Say("@whi@Bus108 - Departing to Edge in 20seconds");
Wait(1000);
Say("@whi@Bus108 - Departing to Edge in 10seconds");
Wait(5000);
Say("@whi@Bus108 - Departing to Edge in 5seconds");
Wait(5000);
Say("@whi@Bus108 - Departing to Edge follow me!!");
Walk(135,631);
Say("@whi@i am bus 108 - heading2edge");
Walk(152,615);
Walk(172,607);
Say("@whi@i am bus 108 - heading2edge");
Walk(178,595);
Walk(187,579);
Say("@whi@i am bus 108 - heading2edge");
Walk(189,563);
Walk(190,546);
Walk(199,534);
Say("@whi@i am bus 108 - heading2edge");
Walk(215,520);
Say("@whi@i am bus 108 - heading2edge");
Walk(216,502);
Walk(215,495);
Say("@whi@i am bus 108 - heading2edge");
Walk(216,490);
Walk(218,474);
Walk(222,456);
Say("@whi@i am bus 108 - heading2edge"); 
Walk(216,450);
Say("@whi@Bus108 - Departing to Lumby in 30seconds");
Wait(20000);
Beep();
Say("@whi@BangBus - going back To Lumby");
Wait(3000);
Walk(217,450);
Say("@whi@BangBus - going back To Lumby");
Walk(222,452);
Walk(223,458);
Walk(225,466);
Walk(220,473);
Say("@whi@BangBus - going back To Lumby");
Walk(219,480);
Walk(218,487);
Walk(217,495);
Say("@whi@BangBus - going back To Lumby");
Walk(216,503);
Walk(216,511);
Walk(216,518);
Say("@whi@BangBus - going back To Lumby");
Walk(210,525);
Walk(206,529);
Walk(198,535);
Say("@whi@BangBus - going back To Lumby");
Walk(191,543);
Walk(192,550);
Walk(193,559);
Say("@whi@Bus106 -Destination Lumby");
Walk(191,569);
Say("@whi@BangBus - going back To Lumby");
Walk(191,578);
Walk(191,587);
Say("@whi@BangBus - going back To Lumby");
Walk(191,596);
Say("@whi@Bus106 -Destination Lumby");
Walk(190,605);
Say("@whi@BangBus - going back To Lumby");
Walk(180,606);
Walk(171,610);
Walk(162,612);
Walk(153,614);
Say("@whi@For more info on bus routes and times");
Say("@whi@Im [i4mmp] on aim");
Walk(145,616);
Walk(140,617);
Walk(135,619);
Walk(134,625);
Walk(132,636);
Walk(120,649);
        }
   DisplayMessage("@cya@Mp tells you hey is your mom there?",3);
    }
} 