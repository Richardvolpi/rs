import javax.swing.JOptionPane;
public class LeetFighter extends Methods
{
    public LeetFighter(mudclient mc){super(mc);}
    public int a3;
    public int a4;
    public int a5;
    public int a6;
    public int a7;
    public int a8;
    public int a9;
    public int a10;
    public int a11;
    public String[] i1;
    public String i3;
    public String i4;
    public String i5;
    public String i6;
    public String i7;
    public String i8;
    public String i9;
    public String i10;

    public void Main(String Args[])
    {
    i1 = JOptionPane.showInputDialog("Please type in Npc IDs(separated by : )").split(":");
    String[] i2 = {"0"};
    i3 = GetInput( "Please choose your Fight Mode(0-3)" );
    i4 = "400";
    i5 = "0";
    i6 = GetInput( "Walk Back?(0 for no, 1 for yes)" );
    i7 = GetInput( "Please type in Anti-Wander range(squares, 999 for no AW)" );
    i8 = GetInput( "Please enter Door Limit(squares, 0 for no door opening)" );
    i9 = GetInput( "Sleeping Fatigue?" );
    i10 = GetInput( "Please enter Food ID(even if no eating, enter a food id)" );
    int[] a1 = new int[i1.length];
    for(int i = 0; i < a1.length; i++) { a1[i] = StrToInt(i1[i]); }
    int[] a2 = new int[i2.length];
    for(int a = 0; a < a2.length; a++) { a2[a] = StrToInt(i2[a]); }
    a3 = Integer.parseInt(i3);
    a4 = Integer.parseInt(i4);
    a5 = Integer.parseInt(i5);
    a6 = Integer.parseInt(i6);
    a7 = Integer.parseInt(i7);
    a8 = Integer.parseInt(i8);
    a9 = Integer.parseInt(i9);
    a10 = Integer.parseInt(i10);
    if(a7 == 0) { int a11 = 9999; } else if(a7 != 0) { a11 = a7; }
    int[] Doors = {2};
    int[] Doors2 = {64,60};
    int startx = GetX();
    int starty = GetY();
    LockMode(a3);
    AutoLogin(true);
    //Display("LeetFighter by @cya@OMFG");
    //Display("Eating: " + a10 + ", FightMode: " + a3 + ", Door Limit: " + a8 + "");
    //Display("WalkBack?: " + a6 + ", Sleeping At: " + a9 + "");
    while(Running() && HitsPercent() > 40)
        {
    int[] b1 = GetNpcById(a1);
    int[] b2 = GetItemById(a2);
    int[] Bone = GetItemById(20);
    int[] Door = GetWallObjectById(Doors);
    int[] Door2 = GetObjectById(Doors2);
    if(GetFatigue() < a9 && GetMaxLvl(3) - GetCurLvl(3) < 14 && DistanceTo(startx,starty) < a11)
        {
        if(a8 != 0 && Door[0] != -1 && DistanceTo(Door[1],Door[2]) < a8 && DistanceTo(startx,starty,Door[1],Door[2]) < a11)
                {
                Display("Dam niggers trying to lock us!");
                AtWallObject(Door[1],Door[2]);
                Wait(1000);
                }
            else
            if(a8 != 0 && Door2[0] != -1 && DistanceTo(Door2[1],Door2[2]) < a8 && DistanceTo(startx,starty,Door2[1],Door2[2]) < a11)
                {
                Display("Dam niggers trying to lock us!");
                AtObject(Door2[1],Door2[2]);
                Wait(1000);
                }
        else
        if(b1[0] != -1 && !InCombat() && GetFatigue() < a9 && !Sleeping() && DistanceTo(startx,starty,b1[1],b1[2]) < a11)
            {
            AttackNpc(b1[0]);
            Wait(a4);
            }
        else
        if(b2[0] != -1 && !InCombat() && DistanceTo(startx,starty,b2[1],b2[2]) < a11 && CountInv() != 30)
            {
            PickupItem(b2[1],b2[2],b2[0]);
            }
        else
        if(a5 != 0 && Bone[0] != -1 && GetMaxLvl(5) < a5 && !InCombat() && DistanceTo(startx,starty,Bone[1],Bone[2]) < a11)
            {
            PickupItem(Bone[1],Bone[2],Bone[0]);
            }
        else
        if(a6 != 0 && (GetX() != startx || GetY() != starty) && !InCombat())
            {
            WalkTo(startx,starty);
            Wait(a4);
            }
        else { Wait(10); }
        }
    if(GetMaxLvl(3) - GetCurLvl(3) >= 14 && Running() && CountInv(a10) > 0 && !InCombat())
        {
                Display("Eating Pls?");
                Wait(500);
                UseItem(GetItemPos(a10));
                Wait(3000);
        }else
    if(GetFatigue() >= a9 && Running())
        {
        while(!Sleeping() && Running())
            {
            UseItem(GetItemPos(1263));
            Wait(2000);
            }
        while(Sleeping() && Running())
            Wait(1000);
        }
    while(a5 != 0 && GetMaxLvl(5) < a5 && CountInv(20) > 0 && GetFatigue() < a9)
        {
        UseItem(GetItemPos(20));
        Wait(400);
        }
    if(DistanceTo(startx,starty) >= a11)
        {
        WalkTo(startx,starty);
        Wait(1000);
        }
        }
        End();
    }

    public void OnChatMessage(String sender, String message)
    {
    }

    public void OnServerMessage(String message)
    {
    }
}