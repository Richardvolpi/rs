public class Calculator extends Script
{
    public Calculator(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"add","subtract","multiply","divide"};
     }
     
       public void start(String command, String parameter[])
    {
       DisplayMessage("", 3);

      int addend1 = Integer.parseInt(parameter[0]);
      int addend2 = Integer.parseInt(parameter[1]);
      if (command.equalsIgnoreCase("add"))
      {if (Running())
   {
     int sum = (addend1 + addend2);
     DisplayMessage("@whi@" + addend1 + " + " + addend2 + " = " + sum + " Hit f9 now to do another problem",  3);
     System.out.println("" + addend1 + " + " + addend2 + " = " + sum + "");
   }}
         if (command.equalsIgnoreCase("subtract"))
      {if (Running())
   {
     int sum = (addend1 - addend2);
     DisplayMessage("@whi@" + addend1 + " - " + addend2 + " = " + sum + " Hit f9 now to do another problem",  3);
     System.out.println("" + addend1 + " - " + addend2 + " = " + sum + "");
   }}
         if (command.equalsIgnoreCase("multiply"))
      {if (Running())
   {
     int sum = (addend1 * addend2);
     DisplayMessage("@whi@" + addend1 + " * " + addend2 + " = " + sum + " Hit f9 now to do another problem",  3);
     System.out.println("" + addend1 + " * " + addend2 + " = " + sum + "");
   }}
         if (command.equalsIgnoreCase("divide"))
      {if (Running())
   {
     int sum = (addend1 / addend2);
     DisplayMessage("@whi@" + addend1 + " / " + addend2 + " = " + sum + " Hit f9 now to do another problem",  3);
     System.out.println("" + addend1 + " / " + addend2 + " = " + sum + "");
   }}
   
DisplayMessage("@dre@=@whi@=@dre@=  @red@Calculator by Fert @dre@=@whi@=@dre@=", 3);
    }
}