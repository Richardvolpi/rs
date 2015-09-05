import org.rscdaemon.client.script.Commands;
import org.rscdaemon.client.mudclient;

public class WalkEdge extends Commands
{
    public WalkEdge(mudclient c)
    {
        super(c);
    }
    
    public boolean runStartupScripts()
    {
    	return false;
    }
    
    public void start(String[] args)
    {
        walkToWait(128, 647);
        walkToWait(138, 644);
        walkToWait(146, 640);
        walkToWait(156, 637);
        walkToWait(166, 632);
        walkToWait(173, 627);
        walkToWait(182, 624);
        walkToWait(191, 623);
        walkToWait(202, 623);
        walkToWait(211, 621);
        walkToWait(219, 609);
        walkToWait(223, 602);
        walkToWait(229, 593);
        walkToWait(235, 584);
        walkToWait(238, 572);
        walkToWait(239, 563);
        walkToWait(240, 553);
        walkToWait(240, 543);
        walkToWait(237, 532);
        walkToWait(234, 523);
        walkToWait(223, 511);
        walkToWait(221, 500);
        walkToWait(219, 490);
        walkToWait(221, 473);
        walkToWait(224, 459);
        walkToWait(221, 451);
        walkToWait(218, 447);
        walkTo(216, 451);
    }
}