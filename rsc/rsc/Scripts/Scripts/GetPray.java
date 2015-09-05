public class GetPray extends Script 
{ 
    public GetPray(mudclient rs) 
    { 
        super(rs);     
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getpray"}; 
    } 
    
   public void start(String command, String parameter[]) 
    { 
   DisplayMessage("@red@Headin' to Monks", 3); 
   DisplayMessage("@blu@Get yourself a drink while I charge my prayer ;)", 3); 
      Wait(2000);    
      Walk(217,447); 
      Walk(221,452); 
      Walk(224,470); 
      Walk(227,482); 
      Walk(236,491); 
      Walk(243,510); 
      Walk(250,505); 
      Walk(253,494); 
      Walk(253,479); 
      Walk(253,467); 
      Walk(250,466); 
      Wait(1000); 
      AtObject(251,468); 
      Walk(258,1412); 
      AtObject(264,1409); 
      Wait(5000); 
      Walk(256,1412); 
      Wait(1000); 
      AtObject(251,1412); 
      Walk(250,466); 
      Walk(253,471); 
      Walk(251,501); 
      Walk(245,513); 
      Walk(237,494); 
      Walk(229,485); 
      Walk(223,475); 
      Walk(220,471);    
      Walk(224,461); 
      Walk(217,451); 
      Wait(2000); 
   DisplayMessage("@red@Prayer Charged @Yel@ Now it's time to kick some ass!", 3); 
       } 

}
