public class atobject extends Methods
{

     public atobject(mudclient rs)
     {
          super(rs);
     }

    public void Main(String[] args)
     {
        while(Running())
        {
			Display("Clicking on Fish with atobject2");
			AtObject2(GetObjectById(193)[1],GetObjectById(193)[2]);
			Wait(5000);
			if(Running()) {
			Display("Clicking on Fish with atobject2");
			AtObject2(GetObjectById(193)[1],GetObjectById(193)[2]);
			Wait(5000); }
		}
      }

    public void OnServerMessage(String message)
    {
        //When there is a server message, This void is triggered.
    }

    public void OnChatMessage(String sender, String message)
    {
        //When there is a chat message, This void is triggered.
    }

    public void OnPrivateMessage(String sender, String message)
	{
	   System.out.println("Sender: " + sender + ", Message: " + message);
    }

    public void OnKeyPress(long keycode)
    {
        //When the user clicks on a button, This void is called.
    }

}