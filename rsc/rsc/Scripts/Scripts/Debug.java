public class Debug extends Script
{
  public Debug(mudclient rs)
  {
     super(rs);
  }
  public String[] getCommands()
  {
     return new String[]{"debug"};
  }
  public void NPCMessage(String message)
  {
      if(!message.equals(""))
      {Println("NPC Message: "+message);ResetLastNPCMessage();}       
  }
  public void ServerMessage(String message)
  {
      if(!message.equals(""))
      {Println("Server Message: "+message);ResetLastServerMessage();}       
  }
  public void ChatMessage(String message)
  {
      if(!message.equals(""))
      {Println("Chat Message: "+message);ResetLastChatMessage();}       
  }
  public void KeyPressed(int id)
  {
      if(id != 0)
      {Println("Key Pressed: "+id);}
  }
  public void KeyReleased(int id)
  {
      if(id != 0)
      {Println("Key Released: "+id);}
  }

  public void start(String command, String parameter[])
  {
     DisplayMessage("@bla@Debug",3);
     DisplayMessage("@gre@By: Davis Zanot",3);
  }
}