public class Bus extends Script
{
   public Bus(mudclient rs)
    {
        super(rs);
    }

   public String[] getCommands()
    {
        return new String[]{ "bus" };
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
Say("@blu@Meep Meep");
Beep();
Wait(500);
Say("@whi@bus 256 - leaving to fally");
Wait(500);
Say("@whi@Next stop  Dray");
Walk(139,637);
Walk(150,638);
Say("@whi@Free rides around runescape , Follow me");
Walk(162,637);
Walk(177,636);
Say("@whi@Free rides around runescape , Follow me");
Walk(193,635);
Walk(211,633);
Say("@whi@welcome to - draynor");
Beep();
Wait(1000);
Say("@whi@bus 256- next stop fally");
Walk(236,625);
Walk(252,610);
Say("@whi@bus 256 - avoiding Road Hazards");
Walk(256,591);
Walk(272,583);
Say("@whi@Free rides around runescape , Follow me");
Walk(290,573);
Say("@whi@welcome to - Fally");
Beep();
Walk(296,549);
Say("@whi@Free rides around runescape , Follow me");
Walk(314,529);
Say("@red@Bus 256 - next stop barb vill");
Wait(1000);
Say("@whi@sir,plz keep hands and feet inside the bus at all times");
Walk(265,510);
Say("@whi@Free rides around runescape , Follow me");
Walk(240,515);
Say("@whi@Free rides around runescape , Follow me");
Walk(224,511);
Say("@whi@welcome to - barb village");
Wait(1000);
Say("@whi@Bus 256 - next stop Edge");
Walk(225,488);
Say("@whi@Free rides around runescape , Follow me");
Walk(225,467);
Say("@whi@Free rides around runescape , Follow me");
Walk(220,445);
Say("@whi@Welcome to - edgeville");
Wait(1000);
Walk(224,468);
Say("@whi@bus 256 -heading to verrok in 30seconds");
Wait(30000);
Beep();
Walk(220,491);
Say("@whi@Free rides around runescape , Follow me");
Walk(203,510);
Say("@whi@Free rides around runescape , Follow me");
Walk(183,515);
Say("@whi@Free rides around runescape , Follow me");
Walk(155,508);
Say("@whi@Free rides around runescape , Follow me");
Walk(136,508);
Say("@whi@welcome to - verrok");
Wait(1000);
Beep();
Say("@whi@bus 256 - Next Stop Alkarid");
Walk(118,508);
Say("@whi@Free rides around runescape , Follow me");
Walk(96,508);
Say("@whi@Free rides around runescape , Follow me");
Walk(81,517);
Say("@whi@Free rides around runescape , Follow me");
Walk(72,533);
Say("@whi@Free rides around runescape , Follow me");
Walk(66,553);
Say("@whi@Free rides around runescape , Follow me");
Walk(67,570);
Say("@whi@Welcome to - Alkarid");
Wait(1000);
Say("@whi@Fhq, i need a beer");
Walk(92,576);
Say("@whi@Free rides around runescape , Follow me");
Walk(109,596);
Say("@whi@Free rides around runescape , Follow me");
Walk(110,622);
Walk(127,644);
Wait(3000);
Say("@whi@welcome to the town of newbs");
Walk(120,649);
Wait(1500);
Say("@Ran@For Donations please Im I4mmp aim");
}
//This is the end of your script, so you can put some message here:
DisplayMessage("@red@STOPPED", 3);
}
}