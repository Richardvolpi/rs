public class Shop extends Methods
{

     public  Shop(mudclient rs)
     {
          super(rs);
     }

    public void Main(String[] args)
     {
        while(Running())
        {
      int pos = FindShopSlot(1263);
      Display("Bag is in position " + pos);
      Wait(2000);
      Display("Bag costs " + ShopBuyPrice(1263));
         Wait(2000);
    Display("Attempting to buy bag using its id");
    BuyShopItem(1263);
    Wait(2000);
  
    
      
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