public class JailRanger extends Script
{
   public JailRanger(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"range"};
   }
public void JailArch(int Prisoners[], int Cell)
{
    SetFightMode(1);
    Cell = GetNearestNPC(Prisoners);
    if (Cell != -1 && !CanReach(NPCX(Cell),NPCY(Cell)))
        AttackNPC(GetNearestNPC(Prisoners));
    Wait(100);
}
   public void start(String command, String parameter[])
   {
      DisplayMessage("@bla@Port Sarim Jail Ranger",3);;;
      DisplayMessage("@gre@By: Davis Zanot",3);
      int X = GetX();
      int Y = GetY();
      while (Running() && InvCount(11) > 0)
      {
          SetFightMode(1);
          while (Running() && InvCount(11) > 0 && Fatigue() < 95)
          {
              ForceWalkNoWait(X,Y);
              Wait(100);
              JailArch(new int[] {192,137,21,189,64},0);
          }
          while (Running() && Fatigue() >= 95)
          {
              while (Sleeping() && Running())
                  Wait(15);
              while (!Sleeping() && Running())
              {
                  Use(FindInv(1263));
                  Wait(3000);
              }
          }                   
      }
      DisplayMessage("@red@STOPPED", 3);
   }
}