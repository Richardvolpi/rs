public class template extends Methods
{

     public template(mudclient rs)
     {
          super(rs);
     }

     public void Main(String[] args)
     {
          //In here you type whatever you want to do when the script starts
          while(Running())
          {
               //This is the main loop, Everything the script does while running goes in here
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
          //When there is a private message, This void is triggered.
     }

     public void OnKeyPress(long keycode)
     {
          //When the user clicks on a button, This void is called.
     }
}
// 3rxbot is an 3rxnet(3rxnet.org) product, Created by Ben Barkay aka OMFG
