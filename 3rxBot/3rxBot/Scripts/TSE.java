/**
 * Crappy Text Script Emulator (TSE) by Stork
 * Feel free to modify as you wish
 *
 * Ownership rights are retained by me (Stork)
 *
 * author: Alex Storkey
 * date: 12:58, 24/10/05
 */

import java.io.*;
import java.util.HashMap;

public class TSE extends Methods implements FilenameFilter {

    public TSE(mudclient rs) {super(rs);}
    String[] line;
    int curPos;
    HashMap<String,Integer> vars = new HashMap<String,Integer>();
    HashMap<String,Integer> lines = new HashMap<String,Integer>();

    public void Main(String[] argu) {
        if(argu.length != 1) {
            Display("Proper usage: /run tse (scriptname)");
            End();
            return;
        }
        File script = new File("textscripts/"+argu[0]+".txt");
        if(!script.isFile()) {
            Display("Invalid file: "+argu[0]);
            End();
            return;
        }
        String temp="";
        String[] temp2;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(script));
            String s1;
            while((s1 = bufferedReader.readLine()) != null)
                temp += s1.trim() + System.getProperty("line.separator");
            bufferedReader.close();
            temp2 = temp.split(System.getProperty("line.separator"));
            line = new String[temp2.length];
            for(int i = 0; i < temp2.length; i++) {
                line[i] = temp2[i];
                if(line[i].startsWith("@") && line[i].endsWith(":")) {
                    lines.put(line[i].substring(0, line[i].indexOf(":")), new Integer(i));
                }
            }
            System.gc();
        } catch(Exception e) {
            e.printStackTrace();
            End();
            return;
        }
        curPos = 0;
        while(Running()) {
            if(curPos >= line.length) curPos = 0;
            Doline(line[curPos]);
            System.gc();
            curPos++;
        }
    }

    public int ParseString(String s)
    {
        try { return Integer.parseInt(s); } catch(Exception e) { return 0; }
    }

    public int getLabelLine(String s)
    {
        return lines.get(s).intValue();
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
    }

    public void setVar(String var, int value)
    {
        vars.put(var,new Integer(value));
        return;
    }

    public int getValue(String s)
    {
         s = s.trim();
        if(s.startsWith("%"))
        {
            return vars.get(s).intValue();
        }
        return ParseString(s);
    }

    void DebugLine(String s) {}

    public String trim(String s)
    {
        s = s.substring(s.indexOf("(")+1,s.indexOf(")"));
        return s.trim();
    }

    String[] splitLine(String s) {
        String[] s1 = s.split(",");
        for(int i=0; i<s1.length; i++)
        s1[i] = s1[i].trim();
        return s1;
    }

    public void Doline(String line)
    {
        if(line == null) return;
        if(line.startsWith("goto"))
        Goto(line);
        else
        {
            if(line.startsWith("wait(") && line.endsWith(")"))
            {

                Wait(getValue(trim(line)));
                return;
            }
            if(line.startsWith("Display(") && line.endsWith(")"))
            {

                System.out.println(trim(line));
                return;
            }
            if(line.startsWith("debugrs(") && line.endsWith(")"))
            {

                Display(trim(line));
                return;
            }
            if(line.startsWith("atobject(") && line.endsWith(")"))
            {

                String s[] = splitLine(trim(line));

                AtObject(getValue(s[0]),getValue(s[1]));
            }
            if(line.startsWith("atladder(") && line.endsWith(")"))
            {

                String s[] = splitLine(trim(line));
                while(DistanceTo(getValue(s[0]),getValue(s[1])) < 32)
                {
                    AtObject(getValue(s[0]),getValue(s[1]));
                    Wait(1000);
                }
            }
            if(line.startsWith("atobject2(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                AtObject2(getValue(s[0]),getValue(s[1]));
            }
            if(line.startsWith("attacknpc(") && line.endsWith(")"))
            {
                String s1[] = splitLine(trim(line));
                int npc[] = GetNpcById(getValue(s1[0]));
                AttackNpc(npc[0]);
                return;
            }
            if(line.startsWith("thievenpc(") && line.endsWith(")"))
            {
                String s1[] = splitLine(trim(line));
                int npc[] = GetNpcById(getValue(s1[0]));
                ThieveNpc(npc[0]);
                return;
            }
            if(line.startsWith("buy(") && line.endsWith(")"))
            {
                int id = getValue(trim(line));
                BuyShopItem(id);
                return;
            }
            if(line.startsWith("sell(") && line.endsWith(")"))
            {
                int id = getValue(trim(line));
                SellShopItem(id);
                return;
            }
            if(line.startsWith("equipbyid(") && line.endsWith(")"))
            {
                int id = getValue(trim(line));
                WearItem(GetItemPos(id));
                return;
            }
            if(line.startsWith("unequipbyid(") && line.endsWith(")"))
            {
                int id = getValue(trim(line));
                RemoveItem(GetItemPos(id));
                return;
            }
            if(line.startsWith("talktonpc(") && line.endsWith(")"))
            {
                String s1[] = splitLine(trim(line));
                int npc[] = GetNpcById(getValue(s1[0]));
                TalkToNpc(npc[0]);
                return;
            }
            if(line.startsWith("talktountil(") && line.endsWith(")"))
            {
                while(!QuestMenu())
                {
                    int npc[] = GetNpcById(getValue(trim(line)));
                    TalkToNpc(npc[0]);
                    Wait(1000);
                }
                return;
            }
            if(line.startsWith("waitfor(") && line.endsWith(")"))
            {
                String e = trim(line);
                if(e.equals("shop"))
                {
                    DebugLine("waiting for shop");
                    while(!InShop())
                        Wait(100);
                }
                if(e.equals("questmenu"))
                {
                    DebugLine("waiting for quest menu");
                    for(int c = 0; c < 100 && !QuestMenu(); c++)
                        Wait(100);
                }
                return;
            }
            if(line.startsWith("waitforquestmenu(") && line.endsWith(")"))
            {
                    while(!QuestMenu())
                        Wait(100);
                return;
            }
            if(line.startsWith("magicnpc(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                int npc[] = GetNpcById(getValue(s[0]));
                    CastOnNpc(getValue(s[1]),npc[0]);
                return;
            }
            if(line.startsWith("withdraw(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                Withdraw(getValue(s[0]),getValue(s[1]));
                return;
            }
            if(line.startsWith("deposit(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                Deposit(getValue(s[0]),getValue(s[1]));
                return;
            }
            if(line.startsWith("getitem(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                while(CountInv(getValue(s[0])) != getValue(s[1]))
                {
                    if(CountInv(getValue(s[0])) > getValue(s[1]))
                    {
                        Deposit(getValue(s[0]),1);
                        Wait(200);
                    }
                    if(CountInv(getValue(s[0])) < getValue(s[1]))
                    {
                        Withdraw(getValue(s[0]),1);
                        Wait(200);
                    }
                }
                return;
            }
            if(line.startsWith("depositeverything(") && line.endsWith(")"))
            {
                DebugLine("Depositing everything...");
                for(int i1 = 0; i1 <= 1289; i1++)
                {
                    while(CountInv(i1) > 0)
                    {
                        Deposit(i1,1);
                        Wait(200);
                    }
                }
                return;
            }
            if(line.startsWith("depositgems(") && line.endsWith(")"))
            {
                DebugLine("Depositing gems...");
                while(CountInv(157) > 0)
                {
                    Deposit(157,1);
                    Wait(200);
                }
                while(CountInv(158) > 0)
                {
                    Deposit(158,1);
                    Wait(200);
                }
                while(CountInv(159) > 0)
                {
                    Deposit(159,1);
                    Wait(200);
                }
                while(CountInv(160) > 0)
                {
                    Deposit(160,1);
                    Wait(200);
                }
                return;
            }
            if(line.startsWith("answer(") && line.endsWith(")"))
            {
                Answer(getValue(trim(line)));
                return;
            }
            if(line.startsWith("useitem(") && line.endsWith(")"))
            {
                UseItem(getValue(trim(line)));
                return;
            }
            if(line.startsWith("useitembyid(") && line.endsWith(")"))
            {
                UseItem(GetItemPos(getValue(trim(line))));
                return;
            }
            if(line.startsWith("sleep(") && line.endsWith(")"))
            {
                while(GetFatigue() > 94 && !Sleeping())
                {
                    UseItem(GetItemPos(1263));
                    Wait(1000);
                }
                while(Sleeping())
                Wait(300);
                return;
            }
            if(line.startsWith("closebank(") && line.endsWith(")"))
            {
                CloseBank();
                return;
            }
            if(line.startsWith("autologin(") && line.endsWith(")"))
            {
                if(getValue(trim(line)) == 1)
                AutoLogin(true);
                else if(getValue(trim(line)) == 0) AutoLogin(false);
            }
            if(line.startsWith("server(") && line.endsWith(")"))
            {
                if(getValue(trim(line)) >= 1 && getValue(trim(line)) <= 6) {
                    ChangeWorld(getValue(trim(line)));
                }
                else
                Display("Could not switch server: Invalid server: "+getValue(trim(line)));

            }
            if(line.startsWith("closeshop(") && line.endsWith(")"))
            {
                CloseShop();
                return;
            }
            if(line.startsWith("die(") && line.endsWith(")"))
            {
                System.exit(0);
                return;
            }
            if(line.startsWith("logout(") && line.endsWith(")"))
            {
                LogOut();
                return;
            }
            if(line.startsWith("dropitem(") && line.endsWith(")"))
            {
                DropItem(getValue(trim(line)));
                return;
            }
            if(line.startsWith("dropitembyid(") && line.endsWith(")"))
            {
                DropItem(GetItemPos(getValue(trim(line))));
                return;
            }
            if(line.startsWith("takeitem(") && line.endsWith(")"))
            {
                PickupItemById(getValue(trim(line)));
                return;
            }
            if(line.startsWith("fightmode(") && line.endsWith(")"))
            {
                SetMode(getValue(trim(line)));
                return;
            }
            if(line.startsWith("opendoor(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                if(GetIdWallObject(getValue(s[0]),getValue(s[1])) == 2)
                {
                    AtWallObject(getValue(s[0]),getValue(s[1]));
                }
                return;
            }
            if(line.startsWith("walkto(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                WalkTo(getValue(s[0]),getValue(s[1]));
                return;
            }
            if(line.startsWith("force(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                ForceWalkTo(getValue(s[0]),getValue(s[1]));
                return;
            }
            if(line.startsWith("walkwait(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                WalkToWait(getValue(s[0]),getValue(s[1]));
                return;
            }
            if(line.startsWith("setvar(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                setVar(s[0],getValue(s[1]));
                return;
            }
            if(line.startsWith("setvarmyx(") && line.endsWith(")"))
            {
                setVar(trim(line),GetX());
                return;
            }
            if(line.startsWith("setvarmyy(") && line.endsWith(")"))
            {
                setVar(trim(line),GetY());
                return;
            }
            if(line.startsWith("setvarinvcount(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                setVar(s[0],CountInv(getValue(s[1])));
                return;
            }
            if(line.startsWith("setvarnearestobj(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                int i1[] = GetObjectById(getValue(s[2]));
                setVar(s[0],i1[1]);
                setVar(s[1],i1[2]);
                return;
            }
            if(line.startsWith("setvarnearestitem(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                int i1[] = GetItemById(getValue(s[2]));
                setVar(s[0],i1[1]);
                setVar(s[1],i1[2]);
                return;
            }
            if(line.startsWith("setvarbankcount(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                setVar(s[0],CountInBank(getValue(s[1])));
                return;
            }
            if(line.startsWith("setvarshopcount(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                setVar(s[0],CountShop(getValue(s[1])));
                DebugLine("Variable "+s[0]+" set as (shopcount) "+CountShop(getValue(s[1])));
                return;
            }
            if(line.startsWith("addvar(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                setVar(s[0],getValue(s[0]) + getValue(s[1]));
                return;
            }
            if(line.startsWith("subvar(") && line.endsWith(")"))
            {
                String s[] = splitLine(trim(line));
                setVar(s[0],getValue(s[0]) - getValue(s[1]));
                return;
            }
        }
    }

    public void Goto(String line)
    {
        if(line.startsWith("goto(") && line.endsWith(")"))
        {
            DebugLine("Switching to label "+trim(line)+" (line: "+getLabelLine(trim(line))+")");
            curPos = getLabelLine(trim(line));
            return;
        }
        if(line.startsWith("gotoifbagfull(") && line.endsWith(")"))
        {
            if(CountInv() == 30)
            {
                curPos = getLabelLine(trim(line));
            }
            return;
        }
        if(line.startsWith("gotoifincombat(") && line.endsWith(")"))
        {
            if(InCombat())
            {
                curPos = getLabelLine(trim(line));
            }
            return;
        }
        if(line.startsWith("gotoifinbank(") && line.endsWith(")"))
        {
            if(InBank())
            {
                curPos = getLabelLine(trim(line));
            }
            return;
        }
        if(line.startsWith("gotoifinshop(") && line.endsWith(")"))
        {
            if(InShop())
            {
                curPos = getLabelLine(trim(line));
            }
            return;
        }
        if(line.startsWith("gotoifloggedin(") && line.endsWith(")"))
        {
            if(LoggedIn())
            {
                curPos = getLabelLine(trim(line));
            }
            return;
        }
        if(line.startsWith("gotoifsleeping(") && line.endsWith(")"))
        {
            if(Sleeping())
            {
                curPos = getLabelLine(trim(line));
            }
            return;
        }
        if(line.startsWith("gotoifvarabove(") && line.endsWith(")"))
        {
            String s[] = splitLine(trim(line));
            if(getValue(s[1]) > getValue(s[2]))
            {
                curPos = getLabelLine(s[0]);
                return;
            }
            return;
        }
        if(line.startsWith("gotoifvarbelow(") && line.endsWith(")"))
        {
            String s[] = splitLine(trim(line));
            if(getValue(s[1]) < getValue(s[2]))
            {
                curPos = getLabelLine(s[0]);
                return;
            }
            return;
        }
        if(line.startsWith("gotoifvarequals(") && line.endsWith(")"))
        {
            String s[] = splitLine(trim(line));
            if(getValue(s[1]) == getValue(s[2]))
            {
                curPos = getLabelLine(s[0]);
                return;
            }
            return;
        }
        if(line.startsWith("gotoifvardoesntequal(") && line.endsWith(")"))
        {
            String s[] = splitLine(trim(line));
            if(getValue(s[1]) != getValue(s[2]))
            {
                curPos = getLabelLine(s[0]);
                return;
            }
            return;
        }
        if(line.startsWith("gotoifcoordsat(") && line.endsWith(")"))
        {
            String s[] = splitLine(trim(line));
            if(getValue(s[1]) == GetX() && getValue(s[2]) == GetY())
            {
                curPos = getLabelLine(s[0]);
                return;
            }
            return;
        }
        if(line.startsWith("gotoifcoordsnotat(") && line.endsWith(")"))
        {
            String s[] = splitLine(trim(line));
            if(getValue(s[1]) != GetX() || getValue(s[2]) != GetY())
            {
                curPos = getLabelLine(s[0]);
                return;
            }
            return;
        }
        if(line.startsWith("gotoifnpcwithinrad(") && line.endsWith(")"))
        {
            String s[] = splitLine(trim(line));
            int npc[] = GetNpcById(getValue(s[1]));
            int rad = getValue(s[2]);
            int smallx = GetX() - rad;
            int bigx = GetX() + rad;
            int smally = GetY() - rad;
            int bigy = GetY() + rad;
            int npcx = npc[1];
            int npcy = npc[2];
            if(npcx >= smallx && npcx <= bigx && npcy >= smally && npcy <= bigy)
            {
                DebugLine("NPC is within rad "+getValue(s[2])+"; Switching to label "+s[0]+" (line: "+getLabelLine(s[0])+")");
                curPos = getLabelLine(s[0]);
                return;
            }
            return;
        }
        if(line.startsWith("gotoifnpcwithinradfrompoint(") && line.endsWith(")"))
        {
            String s[] = splitLine(trim(line));
            int npc[] = GetNpcById(getValue(s[1]));
            int rad = getValue(s[4]);
            int smallx = getValue(s[2]) - rad;
            int bigx = getValue(s[2]) + rad;
            int smally = getValue(s[3]) - rad;
            int bigy = getValue(s[3]) + rad;
            int npcx = npc[1];
            int npcy = npc[2];
            if(npcx >= smallx && npcx <= bigx && npcy >= smally && npcy <= bigy)
            {
                DebugLine("NPC is within rad from ("+getValue(s[2])+","+getValue(s[3])+") "+getValue(s[4])+"; Switching to label "+s[0]+" (line: "+getLabelLine(s[0])+")");
                curPos = getLabelLine(s[0]);
                return;
            }
            return;
        }
    }

}