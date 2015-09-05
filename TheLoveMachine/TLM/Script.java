
public abstract class Script extends AccessorMethods{
    public long pauseTime=0,lastRan=0;
    public abstract String[] getCommands();
    public abstract boolean start(String macro,String[] params);
    public abstract long run(long ticks);
    public void stop() {}
    public long runCombat(long ticks) { return 0; }    
}
