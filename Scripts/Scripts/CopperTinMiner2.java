public class CopperTinMiner2 extends Script
{
   
    public CopperTinMiner2(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"coppertinminer2"};
    }
    public void start(String command, String parameter[])
    {

      
   DisplayMessage("@cya@CopperTinMiner2: @or2@Copper @gre@and @or2@Tin Miner @ran@Start Near Varock East Bank! @gre@- @blu@Kimi", 3);
   while (Running())   
        {

if (Fatigue() > 98)
{
         while (Sleeping() == false && Running() == true)
         {
            Use(FindInv(1263));
            Wait(2500);
         }
         while (Sleeping() == true && Running() == true)
         {
         Wait(100);
         }
}
}
Walk(73,538);
Wait(100);
Walk(75,529);
Wait(100);
Walk(80,522);
Wait(100);
Walk(83,513);
Wait(100);
Walk(92,509);
Wait(100);
Walk(99,508);
Wait(100);
Walk(105,512);

}
}