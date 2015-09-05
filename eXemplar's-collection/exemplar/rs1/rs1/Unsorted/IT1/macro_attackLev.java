/*
 * macro_attackLev.java
 *
 * Created on September 20, 2003, 3:28 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_attackLev extends Macro
{
    
    /** Creates a new instance of macro_attackLev */
    public macro_attackLev(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"attacklev"};
    }
    public void start(String command)
    {
        final int lev = Integer.parseInt(command.substring("attacklev ".length()));
        final Object player = rs.getYourself();
        //final mudclient_Debug.Commander attackScript = rs.new Commander(0,0,0,0, 0,715);
        while(rs.macroOn)
        {
            if(rs.getFatigue()>= 0.99)
                rs.sleeper.sleep();
            while(rs.getFatigue() >= 0.99)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                }
            }
            int min = Integer.MAX_VALUE;
            int minI = -1;
            for(int i = 0;i < rs.getNpcCount();i++)
            {
                Object npc = rs.getNpc(i);
                if(npc == null)
                    continue;
                Thread.yield();
                float npcLevel = rs.getNpcLevel(npc);
                if(rs.isNpcAttackable(npc) && npcLevel > 0 && npcLevel < lev+1 && !rs.isMobInCombat(npc))
                {
                    int eval = Math.abs(rs.getMobXPosition(player)-rs.getMobXPosition(npc))+Math.abs(rs.getMobYPosition(player)-rs.getMobYPosition(npc));
                    if(eval < min)
                    {
                        minI = i;
                        min = eval;
                    }
                }
            }
            if(minI != -1)
            {
                final int minD = minI;
                rs.directAttack(rs.getNpc(minI));
                //broad cast what you are doing to everyone
                //a.a.Accessor.access_e_t(rs.eG,"Currently after:"+b.o[rs.cW[minI].g]);
                //rs.eG.b(10);
            }
            else
                System.out.println("can't find them");
            do
            {
                try
                {
                    Thread.sleep(1500);
                }
                catch(InterruptedException e)
                {
                    System.out.println("intrupted!");
                }
            }while(rs.isMobInCombat(player));
        }
    }
}
