public class NewLogin extends Methods
{

    public NewLogin(mudclient mudclient){super(mudclient);}

    public void run() // Called everytime we login
    {
        if(!Running())
            SetMode(1); // Set us to fightmode
    }
}