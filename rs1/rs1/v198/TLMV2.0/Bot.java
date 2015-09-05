import java.util.*;
import java.io.*;
import java.net.*;

public class Bot extends mudclient {
    public List<KeyHandler> keyHandlers = new ArrayList<KeyHandler>();
    public List<CommandHandler> commandHandlers = new ArrayList<CommandHandler>();
    public List<Script> runningScripts = new ArrayList<Script>();
    public HashMap<String,Script> Scripts = new HashMap<String,Script>();
    private final Bot REFERANCE_TO_BOT = this;
    public boolean needToReload=false,needToStop;
    public String scriptToStop=null;
    private List<String> commandEventQue = new ArrayList<String>();
    private List<KeyState> keyEventQue = new ArrayList<KeyState>();
    private List<MessageListener> messageListeners = new ArrayList<MessageListener>();
    private List<Message> messageQue = new ArrayList<Message>();
    private File HCPath, SLPath;
    public boolean autosleep;
    public int fatThreshold=100;
    public Bot() {
        HCPath = new File(".","HC.bmp");
        SLPath = new File(".","slword.txt");
    }
    public AccessorMethods state = new Helper();
    {
        state.rs = REFERANCE_TO_BOT;
    }
    public void processCommandLine(String s) {
        //System.out.println("processCommandLine("+s+")");
        insertIntoEventQue(s);
        startScript(s);
    }
    public void reloadUserFiles() {
        Scripts.clear();
        keyHandlers.clear();
        commandHandlers.clear();
        messageListeners.clear();
        loadUserFiles();
    }
    public void startScript(String s) {
        s = s.trim();
        //System.out.println("StartScript("+s+")");
        String args[];
        String name;
        if (s.indexOf(" ") > -1) {
            name = s.substring(0,s.indexOf(" ")).trim();
            args = s.substring(s.indexOf(" ")).trim().split("\\s");
        }
        else {
            args = new String[0];
            name=s;
        }
        if (Scripts.containsKey(name)) {
            Script script = Scripts.get(name);
            if(script.start(name, args))
                runningScripts.add(script);
        }                 
    }
    public void reload() {
        needToReload = true;
    }
    public void stopScript(String name) {
        needToStop = true;
        scriptToStop = name;
    }
    public void stop(String name) {
        Iterator it = runningScripts.iterator();
        while (it.hasNext()) {
            Script script = (Script)it.next();
            for (String s : script.getCommands())
                if (name.equals("") || s.trim().equalsIgnoreCase(name.trim())) {
                    script.stop();
                    it.remove();
                }
        }
    }
    public void loadUserFiles()
    {
        //System.out.println("load user files");
        SimpleClassLoader simpleclassloader = new SimpleClassLoader("/userFiles/");
        File file = new File(".", "/userFiles/");
        if(file.exists())
        {
            String as[] = file.list();
            if(as != null)
            {
                for(int i = 0; i < as.length; i++)
                {
                    if(!as[i].endsWith(".class") || as[i].indexOf("$") != -1)
                        continue;
                    System.out.println((new StringBuilder()).append("loading user file ").append(as[i].substring(0, as[i].length() - 6)).toString());
                    try
                    {
                        Class class1 = simpleclassloader.loadClass(as[i].substring(0, as[i].length() - 6));
                        Object obj = class1.newInstance();
                        try {
                            if(AccessorMethods.class.isAssignableFrom(class1))
                                ((AccessorMethods)obj).rs = REFERANCE_TO_BOT;
                        } catch (Exception e) {
                            System.out.println("Setting up rs");
                        }
                        if(Script.class.isAssignableFrom(class1))
                        {
                            Script script = (Script)obj;
                            String as2[] = script.getCommands();
                            for(int l = 0; l < as2.length; l++)
                            {
                                System.out.println((new StringBuilder()).append("Script command loaded::").append(as2[l]).toString());
                                Scripts.put(as2[l].trim(), script);
                            }

                        } else
                        {
                            System.out.println((new StringBuilder()).append(class1).append(" isnt a script").toString());
                        }
                        if(KeyHandler.class.isAssignableFrom(class1))
                        {
                            keyHandlers.add((KeyHandler)obj);
                            int ai[] = ((KeyHandler)obj).getAssociatedKeys();
                            int j = ai.length;
                            for(int i1 = 0; i1 < j; i1++)
                            {
                                int k1 = ai[i1];
                                System.out.println((new StringBuilder()).append("KeyHandler added for key::").append(k1).toString());
                            }

                        }
                        if(CommandHandler.class.isAssignableFrom(class1)) {
                            try {
                                commandHandlers.add((CommandHandler)obj);
                                String as1[] = ((CommandHandler)obj).getPrefixList();
                                int k = as1.length;
                                for(int j1 = 0; j1 < k; j1++)
                                    {
                                        String s = as1[j1];
                                        System.out.println((new StringBuilder()).append("CommandHandler prefix loaded::").append(s).toString());
                                    }
                            } catch (Exception e) { System.out.println("getting prefix list"); }
                        }

                    }
                    catch(Exception exception)
                    {
                        System.out.println(exception);
                    }
                }

            }
        }
        System.out.println("user files loaded");
    }
    public long lastChecked=0;
    public String word = "NOT-YET-RECIEVED";
    public void processScripts() {
        if (!state.loggedIn())
            return;
        //System.out.println(autosleep + " " + state.getFatigue() + " " + fatThreshold);
        if (safeToRun && autosleep && state.getFatigue() >= fatThreshold ) {
            if (!state.sleeping()) {
                if (lastSentSleepReq+5000 < System.currentTimeMillis()) {
                    state.sleep();
                    lastSentSleepReq = System.currentTimeMillis();
                }
            } else {
                //                System.out.println(word);
                if (word.equals("NOT-YET-RECIEVED")) {
                    if (lastChecked+500 < System.currentTimeMillis() && SLPath.lastModified() != slLastMod) {
                        lastChecked = System.currentTimeMillis();
                        slLastMod = SLPath.lastModified();
                        try {
                            word = new BufferedReader(new FileReader(SLPath)).readLine();
                            System.out.println("The word is " + word);
                            
                        } catch (Exception e) {}
                    }
                }
                else  if (state.getSleepingFatigue() < 4) {
                    System.out.println("Sending word " + word);
                    state.sendWord(word.trim());
                    word = "NOT-YET-RECIEVED";                    
                }
            }
            return;
        }            
        Iterator it = runningScripts.iterator();
        while (it.hasNext()) {
            Script script = (Script)it.next();
            long l = System.currentTimeMillis();
            if(script.lastRan + script.pauseTime < l) {
                if (state.isMobFighting(state.getPlayer()))
                    script.pauseTime = script.runCombat(l);
                else
                    script.pauseTime = script.run(l);
                script.lastRan=l;
                if(script.pauseTime < 0)
                    it.remove();
            }
        }
    }
    public void processingHook() {
        if (needToReload) {
            reloadUserFiles();
            needToReload=false;
        }
        if (needToStop) {
            stop(scriptToStop);
            needToStop=false;
            scriptToStop=null;
        }
        notifyCommandHandlers();
        notifyKeyHandlers();
        notifyMessageListeners();
        processScripts();
    }
    public void download(String f, File output) {
        try {
            System.out.println("Downloading " + f + " to " + output);
            URL file = new URL(f);
            File folder = new File(".","/rsfiles/");
            if (!folder.exists())
                folder.mkdir();
            if (output.exists())
                output.delete();
            output.createNewFile();
            byte[] buffer = new byte[1024];
            int len;
            BufferedInputStream bis = new BufferedInputStream(file.openStream());
            FileOutputStream fos = new FileOutputStream(output);
            while ((len = bis.read(buffer)) != -1)
                fos.write(buffer,0,len);
            bis.close();
            fos.flush();
            fos.close();
        } catch (Exception e) {
            System.out.println("Problem downloading " + f);
            e.printStackTrace();
        }
    }
    public void load(String f, File file) {
        System.out.println("Loading up " + f);
        try {
            InputStream is = new FileInputStream(file);
            long length = file.length();
            byte[] bytes = new byte[(int)length];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                   && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
                offset += numRead;
            }
            
            is.close();
            link.gae(f,bytes);
        }catch(Exception e) {}
    }
    public static  void main(String args[])
    {
        Bot mudclient1 = new Bot();
        mudclient1.elb = false;
        mudclient1.egg = true;
        mudclient1.loadUserFiles();
        mudclient1.flc(mudclient1.ddg, mudclient1.ddh + 11, "Runescape by Andrew Gower", false);
        mudclient1.fkd = 10;
    }
    public void updateServerInfo() {
        aac = ServerList.getServer();
       aad  = 43594+ServerList.getPortOffset();
       egg  = ServerList.isMembers();
    }
    private void notifyCommandHandlers() {
        List<String> temp;
        synchronized (commandEventQue) {
            temp = (List<String>)((ArrayList)commandEventQue).clone();
            commandEventQue.clear();
        }
        for (String s : temp) {
            s = s.trim();
            System.out.println("notifyCommandHandlers("+s+")");
            String args[];
            String name;
            if (s.indexOf(" ") > -1) {
                name = s.substring(0,s.indexOf(" ")).trim();
                args = s.substring(s.indexOf(" ")).trim().split("\\s");
            }
            else {
                args = new String[0];
                name=s;
            }
            for (CommandHandler c : commandHandlers)
                for (String p : c.getPrefixList())
                    if (p.equalsIgnoreCase(name))
                        c.activated(name,args);
        }
    }
    public synchronized void insertIntoEventQue(KeyState ks) {
        synchronized (keyEventQue) {
            keyEventQue.add(ks);
        }
    }
    public synchronized void insertIntoEventQue(String command) {
        synchronized (commandHandlers) {
            commandEventQue.add(command);
        }
    }
    private void notifyKeyHandlers() {
        List<KeyState> temp;
        synchronized (keyEventQue) {
            temp = (List<KeyState>)((ArrayList<KeyState>)keyEventQue).clone();
            keyEventQue.clear();
        }
        for (KeyState ks : temp) {
            int eventID = ks.getID();
            for (KeyHandler kh : keyHandlers)
                for (int ID : kh.getAssociatedKeys())
                    if (eventID == ID)
                        kh.activate(eventID,ks,ks.keyDown());
        }
    }
    public synchronized void insertIntoMessageQue(Message m) {
        messageQue.add(m);
    }
    private void notifyMessageListeners() {
        List<Message> temp;
        temp = (List<Message>)((ArrayList<Message>)messageQue).clone();
        messageQue.clear();
        List<MessageListener> temp2 = (List<MessageListener>)((ArrayList<MessageListener>)messageListeners).clone();
        for (Message m : temp) {
              System.out.println("Notifying messagelisteners of " + m.getType() + " " + m.getMessage() + " " + m.getExtraInfo());
              for (MessageListener ml : temp2) {              
                if (m.getType() == Message.SERVER_MESSAGE && ml.isServerMessageListener())
                    ((ServerMessageListener)ml).serverMessage(m.getMessage(), Integer.parseInt(m.getExtraInfo()));
                else if (m.getType() == Message.CHAT_MESSAGE && ml.isChatMessageListener())
                    ((ChatMessageListener)ml).chatMessage(m.getMessage(),m.getExtraInfo());
                else if (m.getType() == Message.PRIVATE_MESSAGE && ml.isPrivateMessageListener())
                    ((PrivateMessageListener)ml).privateMessage(m.getMessage(),m.getExtraInfo());
            }
        }
    }
    public void addMessageListener(Object o) {
        messageListeners.add(new MessageListener(o));
    }
    public long slLastMod=0, lastSentSleepReq=0;
    public void startedSleeping(byte[] pic) {
        try {
            if (!SLPath.exists()) 
                SLPath.createNewFile();
            word = "NOT-YET-RECIEVED";
            slLastMod = SLPath.lastModified();
            lastSentSleepReq = 0;
            savePic(pic);
        } catch(Exception e) {}
    }
    public void savePic(byte abyte0[]) throws IOException
    {
        int i1 = 1;
        byte byte0 = 0;
        int j1;
        byte picBytes[] = new byte[10200];
        for(j1 = 0; j1 < 255;)
            {
                int k1 = abyte0[i1++] & 0xff;
                for(int i2 = 0; i2 < k1; i2++)
                    picBytes[j1++] = byte0;
                
                byte0 = (byte)(255 - byte0);
            }
        
        for(int l1 = 1; l1 < 40; l1++)
            {
                for(int j2 = 0; j2 < 255;)
                    {
                        int k2 = abyte0[i1++] & 0xff;
                        for(int l2 = 0; l2 < k2; l2++)
                            {
                                picBytes[j1] = picBytes[j1 - 255];
                                j1++;
                                j2++;
                            }
                        
                        if(j2 < 255)
                            {
                                picBytes[j1] = (byte)(255 - picBytes[j1 - 255]);
                                j1++;
                                j2++;
                            }
                    }
                
            }
        
        System.out.println("Writing HC.BMP");
        saveOutput(HCPath, picBytes);
   }

      
   public void saveOutput(File out, byte abyte0[]) throws IOException
   {
      try
          {
              if (!out.exists())
                  out.createNewFile();
         FileOutputStream fileoutputstream = new FileOutputStream(out);
         fileoutputstream.write(66);
         fileoutputstream.write(77);
         int i1 = 1342;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 62;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 40;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 256;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 40;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 1;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         i1 = 1;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         i1 = 0;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 0;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 0;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 0;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 0;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         i1 = 0;
         fileoutputstream.write(i1 & 0xff);
         fileoutputstream.write(i1 >> 8 & 0xff);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         fileoutputstream.write(0);
         fileoutputstream.write(255);
         fileoutputstream.write(255);
         fileoutputstream.write(255);
         fileoutputstream.write(0);
         int j1 = 9945;
         for(int k1 = 0; k1 < 40; k1++)
         {
            for(int l1 = 0; l1 < 32; l1++)
            {
               byte byte0 = 0;
               for(int i2 = 0; i2 < 8; i2++)
               {
                  byte0 = (byte)(2 * byte0);
                  if(l1 != 31 || i2 != 7)
                  {
                     if(abyte0[j1] != 0)
                        byte0++;
                     j1++;
                  }
               }

               fileoutputstream.write(byte0);
            }

            j1 -= 510;
         }

         fileoutputstream.close();
      }
      catch(IOException ioexception)
      {
         System.out.println("EXCEPTION");
      }
   }
}
