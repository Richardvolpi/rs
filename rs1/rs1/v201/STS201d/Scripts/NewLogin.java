/* 
 * This script is run every time you Login into RS using STS.
 * It can be left blank, but cannot be deleted. You can use this to
 * set a custom FightMode for example when you login.
 * 
 * All Scriptable commands can be used here, but obviously some will
 * not work as normal.
 */
public class NewLogin extends Methods
{
    public NewLogin(mudclient mc){super(mc);}

    public void run()
    {
        if(!Running())
        {
            Display("We logged in pls");
            SetMode(1); // Set FightMode to Strength
        }
    }
}