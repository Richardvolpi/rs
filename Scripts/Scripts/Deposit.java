public class Deposit extends Script 
{
    public Deposit(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"deposit", "withdraw"}; 
    }
	public void ServerMessage(String message)
	{
	}
    public void start(String command, String parameter[])
    {
		int Count = Integer.parseInt(parameter[0]);
		int LowCount = Count;
		while (LowCount > 2500)
		{
			LowCount -= 2500;
			if (command.equalsIgnoreCase("deposit"))
				Deposit(10,2500);
			else
				Withdraw(10,2500);
			Wait(25);
		}
		while (LowCount > 500)
		{
			LowCount -= 500;
			if (command.equalsIgnoreCase("deposit"))
				Deposit(10,500);
			else
				Withdraw(10,500);
			Wait(25);
		}
		while (LowCount > 100)
		{
			LowCount -= 100;
			if (command.equalsIgnoreCase("deposit"))
				Deposit(10,100);
			else
				Withdraw(10,100);
			Wait(25);
		}
		while (LowCount > 25)
		{
			LowCount -= 25;
			if (command.equalsIgnoreCase("deposit"))
				Deposit(10,25);
			else
				Withdraw(10,25);
			Wait(25);
		}
		while (LowCount > 5)
		{
			LowCount -= 5;
			if (command.equalsIgnoreCase("deposit"))
				Deposit(10,5);
			else
				Withdraw(10,5);
			Wait(25);
		}
		while (LowCount >= 1)
		{
			LowCount -= 1;
			if (command.equalsIgnoreCase("deposit"))
				Deposit(10,1);
			else
				Withdraw(10,1);
			Wait(25);
		}
		DisplayMessage("@red@STOPPED", 3);
    }
}
