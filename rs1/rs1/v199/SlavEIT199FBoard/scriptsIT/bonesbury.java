
public class bonesbury extends Macro
{

    public bonesbury(slave rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"bonesbury"};
    }
    public String[] getComments()
    {
    return new String[]{"Usage: /bonesbury Start in middle of area, picks 8 steps from start point"};
    }
    
    public void start(String command)
    {
            final MessageListener l = new MessageListener()
            {
                public void messageRecieved(String msg,int filter)
                {
                    System.err.println(msg);
                }
            };
            rs.addMessageListener(l);
            
	   int myx = -1;
	   int myy = -1;
	   int itemx = -1;
	   int itemy = -1;
    	   int startX = 0;
    	   int startY = 0;
    	   if(startX == 0)
    	   {
		    startX = myX();
		    startY = myY();
	   }
		   while(rs.Macro)
		   {
		    	if(getFatigue() == 100)
			{
			wait(2000);
			if(FindInv(1263) != -1)
			UseItem(FindInv(1263));
			else
			{
			rs.Macro = false;
			System.err.println("no sleeping bag!");
			kill();
			}
			wait(2000);
			int time = 28;
			time = time * 1000; 
			int curtime = 0;
			while(Sleeping())
			{
			    wait(10);
			    curtime += 10;
			    if(!Sleeping())
				break;
			    if(curtime >= time)
				break;
			}
			}
		    	if(InvCount() == 30 && getFatigue() < 100)
		    	{
		    	   while(getFatigue() < 100 && InvCount(20) > 0)
		    	   {
		    	   	UseItem(FindInv(20));
		    	   	wait(700 + random(10,70));
		    	   }
		    	}
		    	
			    int curDist = -1;
			    int Dist = 999;
			    int fin = -1;
			    
			    	for(int e = 0; e < groundItemCount(); e++)
			    	{
			    	
			    	myx = myX();
			    	myy = myY();
			    	itemx = groundItemX(e);
			    	itemy = groundItemY(e);
			    	if(myx != -1 && myy != -1 && itemx != -1 && itemy != -1)
			    	{
			    	try{
			    	     curDist = PathLength(myx,myy,itemx, itemy);
			    	     }catch(Exception edf)
				     			    {
				     			    System.err.println(myx + " " + myy + " " + itemx + " " + itemy);
				     			    edf.printStackTrace();
			    }
			    	     if(curDist < Dist && curDist != -1 && groundItemType(e) == 20 && curDist <=8)
			    	     {
			    	     	  Dist = curDist;
			    	     	  fin = e;
			    	     }
			    	}
			    	}
			    
			    
    
		    	    //System.err.println(fin);
		    	    if(fin != -1)
			    {
			    int x = groundItemX(fin);
			    int y = groundItemY(fin);
			    
			    int Dist2 = PathLength(startX,startY,x,y);
			    	if(Dist2 <= 8 && x != -1 && y != -1)
			    	{
					TakeItem(fin);
					wait(700 + random(10,70));
				}
			    }
			    try
			    {
				Thread.currentThread().sleep(100);
			    }
			    catch(InterruptedException e)
			    {
			    }  
		    }
		    }
		    
    	    
    }

