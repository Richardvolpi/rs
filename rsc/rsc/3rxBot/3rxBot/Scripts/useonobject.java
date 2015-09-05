public class useonobject extends Methods
{

     public  useonobject(mudclient rs)
     {
          super(rs);
     }

    public void Main(String[] args)
     {
        while(Running())
        {
        int rawid = 545;
        int rangeid = 11;
        Display("Using sharks with the range");
        int[] range = GetObjectById(rangeid);
        UseOnObject(GetItemPos(rawid),range[1],range[2]);
        Wait(3000);
        Display("Should of cooked");
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