/*
 *      RIAA.java
 */
 
import org.apello.plugins.*;
import org.apello.util.*;
import org.apello.irc.*;

import java.io.*;
import java.net.*;

public class RIAA extends PluginAdapter {
    public RIAA(){}
    
    public String getPluginName(){
        return "RIAA";
    }
    
    public void init(String args){}
    public void process(){}
    public void dispose(){}
    public void onCommandMessage(String replyMethod, String nick, String ident, String host, String cmd, String msg) {
        //log("onCommandMessage() " + cmd + " " + msg);
        try{
            String[] args = msg.length() > 0 ? msg.split(" ") : null;
            for(int id = 0; id < skillArray.length; id++){
                if(cmd.equalsIgnoreCase(skillArray[id])){
                    handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, charInfo(msg, cmd)});
                    return;
                }
            }
                
            if(cmd.equalsIgnoreCase("combat")){
                log("!combat " + msg);
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, charInfo(msg, "combat")});
            }else if(cmd.equalsIgnoreCase("stats")) {
                String[] temp = charInfo(msg, "stats").split("\n");
                for(int stats = 0; stats < temp.length; stats++) {
                    if(temp[stats].contains("null") == true) {
                        handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, "Player \"" + msg + "\" wasn't found"});
                        break;
                    }
                    handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, temp[stats]});
                }
            }
            else if(cmd.equalsIgnoreCase("kpd"))
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, charInfo(msg, "kpd")});
            else if(cmd.equalsIgnoreCase("owner"))
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, owner(msg, true)});
            else if(cmd.equalsIgnoreCase("status"))
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, owner(msg, false)});
            else if(cmd.equalsIgnoreCase("online")){
                String online = online();
                if(isNumeric(online))
                    handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, "There are " + online + " players online"});
                else
                    handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, online});
            }
            else if(cmd.equalsIgnoreCase("top5"))
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, getTop5(msg)});
            /*else if(cmd.equalsIgnoreCase("top5") && msg == null)
                commandRespond(replyMethod, nick, getTop5());*/
            else if(cmd.startsWith("google"))
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, google(msg)});
            else if(cmd.startsWith("youtube"))
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, youtube(msg)});
            else if(cmd.equalsIgnoreCase("help")){
                if(replyMethod.startsWith("#") && !replyMethod.toLowerCase().contains("rscd"))
                    return;
                for(int i = 0; i < HALP.length; i++)
                    handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, HALP[i]});
            }else if(cmd.equalsIgnoreCase("xp"))
                for(int i = 0; i < experienceArray.length; i++)
                    if(i == toNumeric(args[0]))
                        handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, "Experience needed for level " + i + ": " + experienceArray[i - 1]});
            try{
                Boolean b = (Boolean)handler.globalMethod("isAdmin", new Object[]{nick, ident, host});
                if(b != null && b.booleanValue())
                    processAdminCommand(replyMethod, nick, ident, host, cmd, msg);
            }catch(Exception e){//admin plugin probably isnt loaded.
                return;
            }
        }catch(Exception e){
            e.printStackTrace();
            try{
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, "Error: " + e.getMessage()});
            }catch(Exception ee){}
            return;
        }
    }
    
    public void processAdminCommand(String replyMethod, String nick, String ident, String host, String cmd, String msg) {
        try {
            String[] args = msg.length() > 0 ? msg.split(" ") : null;
            if(cmd.equalsIgnoreCase("values")) {
                handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, "siteToUse: " + siteToUse});
                handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, "cookieValue: " + cookieValue});
                handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, "readTimeout: " + readTimeout});
                handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, "connectTimeout: " + connectTimeout});
            }
            else if(cmd.equalsIgnoreCase("sitetouse")) {
                siteToUse = msg;
                handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, "siteToUse: " + siteToUse});
            }
            else if(cmd.equalsIgnoreCase("cookievalue")) {
                cookieValue = msg;
                handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, "cookieValue: " + cookieValue});
            }
            else if(cmd.equalsIgnoreCase("readtimeout")) {
                readTimeout = Integer.parseInt(msg);
                handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, "readTimeout: " + readTimeout});
            }
            else if(cmd.equalsIgnoreCase("connecttimeout")) {
                connectTimeout = Integer.parseInt(msg);
                handler.globalMethod("commandRespond", new Object[]{"NOTICE", nick, "connectTimeout: " + connectTimeout});
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            try{
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, "Error: " + e.getMessage()});
            }catch(Exception ee){}
            return;
        }
    }
    
    /** Methods **/
    public String[] infoNames = {
        "Username", "Combat", "Skilltotal", "Kills", "Deaths", "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking",
        "Woodcut", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility",
        "Thieving"};
    public String[] infoDetails = new String[infoNames.length];
    public String charInfo(String who, String what) {
        try {
            URLConnection connection = new URL(siteToUse + "char.php?user=" + usernameToHash(who) + "&universe=1&display=xml").openConnection();
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            boolean found = false;
            while ((str = in.readLine()) != null) {
                if(str.contains("<username>"))
                    found = true;
                if(found == true) {
                    for(int i = 0; i < infoNames.length; i++) {
                        if(str.contains("<" + infoNames[i].toLowerCase() + ">") && str.contains("</" + infoNames[i].toLowerCase() + ">"))
                            if(infoNames[i].equals("Username") || infoNames[i].equals("Combat") || infoNames[i].equals("Kills")
                             || infoNames[i].equals("Deaths"))
                            infoDetails[i] = str.substring(("<" + infoNames[i].toLowerCase() + ">").length() + 1, str.lastIndexOf("</" + infoNames[i].toLowerCase() + ">"));
                        else
                            infoDetails[i] = str.substring(("<" + infoNames[i].toLowerCase() + ">").length() + 2, str.lastIndexOf("</" + infoNames[i].toLowerCase() + ">"));
                    }
                }
            }
            in.close();
            String returned = null;
            for(int x = 0; x < infoDetails.length; x++)
                if(infoNames[x].equalsIgnoreCase(what) && infoDetails[x] != null)
                    returned = infoDetails[0] + "'s " + infoNames[x] + " level: " + infoDetails[x];
                else if(what.equalsIgnoreCase("combat") && infoDetails[x] != null) {
                    returned = infoDetails[0] + "'s combat stats: " + infoDetails[5] + " " + infoDetails[6] + " " + infoDetails[7] + " " + infoDetails[8] + " (level-" + infoDetails[1] + ")";
                }
                else if(what.equalsIgnoreCase("kpd") && infoDetails[x] != null) {
                    double kills = Double.parseDouble(infoDetails[3]);
                    double deaths = Double.parseDouble(infoDetails[4]);
                    double kpd = kills / deaths;
                    return infoDetails[0] + "'s kpd: " + String.valueOf(kpd);
                }
                else if(what.equalsIgnoreCase("stats")) {
                    returned = infoDetails[0] + "'s stats are:\n";
                    for(int a = 0; a < infoNames.length; a++) {
                        if(a >= 5)
                            returned += infoNames[a] + ": " + infoDetails[a] + "\n";
                    }
                }
            if(returned == null)
                returned = "Player \"" + who + "\" wasn't found";
            for(int l = 0; l < infoDetails.length; l++)
                infoDetails[l] = null;
            return returned;
        }
        catch(Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
    public long usernameToHash(String s) {
        s = s.toLowerCase();
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                s1 = s1 + c;
            else if (c >= '0' && c <= '9')
                s1 = s1 + c;
            else
                s1 = s1 + ' ';
        }

        s1 = s1.trim();
        if (s1.length() > 12)
            s1 = s1.substring(0, 12);
        long l = 0L;
        for (int j = 0; j < s1.length(); j++) {
            char c1 = s1.charAt(j);
            l *= 37L;
            if (c1 >= 'a' && c1 <= 'z')
                l += (1 + c1) - 97;
            else if (c1 >= '0' && c1 <= '9')
                l += (27 + c1) - 48;
        }
        return l;
    }
    public String owner(String who, boolean Bowner) {
        try {
            URLConnection connection = new URL(siteToUse + "char.php?user=" + usernameToHash(who) + "&universe=1&display=xml").openConnection();
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            boolean found = false;
            String owner = "", username = "", status = "";
            while ((str = in.readLine()) != null) {
                if(str.contains("<username>"))
                    username = str.substring(str.indexOf("me>") + 3, str.indexOf("</username>"));
                if(str.contains("<owner>"))
                    owner = str.substring(str.indexOf("er>") + 3, str.indexOf("</owner>"));
                if(str.contains("status"))
                    status = str.substring(str.indexOf("us>") + 3, str.indexOf("</status>"));
            }
            in.close();
            String returned = null;
            if(owner.equals("") == false && username.equals("") == false && Bowner == true)
                returned = username + "'s owner is " + owner;
            if(status.equals("") == false && username.equals("") == false && Bowner == false)
                returned = username + "'s status is " + status;
            if(returned == null)
                returned = "Player \"" + who + "\" wasn't found";
            return returned;
        }
        catch(Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
    public String online() {
        try {
            URLConnection connection = new URL(siteToUse + "status.php").openConnection();
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            connection.setRequestProperty("Cookie", "rscdforums=" + cookieValue);
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            String return_ = "none";
            boolean hax = false;
            while ((str = input.readLine()) != null) {
                if(str.contains("<th scope=\"row\">Players Online:</th>"))
                    hax = true;
                if(str.contains("<td>") && str.contains("</td>") && hax == true)
                    return_ = str.substring(str.indexOf("<td>") + 4, str.lastIndexOf("</td>"));
                if(str.contains("<th scope=\"row\">Start Time:</th>"))
                    hax = false;
            }
            input.close();
            return return_;
        }
        catch(Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
    public int toNumeric(String value) {
        try {
            return Integer.parseInt(value);
        }
        catch(Exception e) {return -1;}
    }
    public boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        }
        catch(Exception e) {return false;}
    }
    public String underline() {return "";}
    public String u() {return underline();}
    public String bold() {return "";}
    public String b() {return bold();}
    public String getTop5(String skill) {
        try {
            URLConnection connection = new URL(siteToUse + "highscores.php?skill=" + skill).openConnection();
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            connection.setRequestProperty("Cookie", "punbb_cookie=" + cookieValue);
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            String return_ = "Top 5 players for " + skill + " (by level): ";
            int getcounter = 1;
            int getcounter2 = 1;
            int arraycounter = 0;
            int arraycounter2 = 0;
            String[] names = new String[5];
            int[] levels = new int[5];
            boolean gotlevel = false;
            while ((str = input.readLine()) != null) {
                if(str.contains("<td class=\"tc3\">") && getcounter2 <= 5 && gotlevel == false) {
                    String s = str;
                    s = s.replaceAll("</td>", "");
                    s = s.replaceAll("<td class=\"tcl\">", "");
                    s = s.substring(s.lastIndexOf("\">") + 2);
                    if(isNumeric(s)) {
                        levels[arraycounter2] = Integer.parseInt(s);
                        gotlevel = true;
                        arraycounter2 ++;
                        getcounter2 ++;
                    }
                }
                if(str.contains("<a href=\"char.php?user=") && getcounter <= 5) {
                    String s = str;
                    s = s.replaceAll("</a></td>", "");
                    s = s.replaceAll("<td class=\"tcl\">", "");
                    s = s.substring(s.lastIndexOf("\">") + 2);
                    names[arraycounter] = s;
                    arraycounter ++;
                    getcounter ++;
                    gotlevel = false;
                }
            }
            for(int i = 0; i < names.length; i++)
                return_ += b() + names[i] + "(" + levels[i] + ")" + b() + ", ";
            input.close();
            if(return_.contains("null"))
                return "Invalid skill \"" + skill + "\"";
            return return_.substring(0, (return_.length() - 2));
        }
        catch(Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
    public String getTop5() {
        try {
            URLConnection connection = new URL(siteToUse + "highscores.php").openConnection();
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            connection.setRequestProperty("Cookie", "punbb_cookie=" + cookieValue);
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            String return_ = "Top 5 players (by skilltotal): ";
            int getcounter = 1;
            int getcounter2 = 1;
            int arraycounter = 0;
            int arraycounter2 = 0;
            String[] names = new String[5];
            String[] levels = new String[5];
            int gotlevel = 0;
            while ((str = input.readLine()) != null) {
                if(str.contains("<td class=\"tc3\">") && str.contains("profile.php") == false && getcounter2 <= 5) {
                    String s = str;
                    s = s.replaceAll("</td>", "");
                    s = s.substring(s.lastIndexOf("tc3\">") + 5);
                    if(gotlevel == 1) {
                        levels[arraycounter2] = s;
                        gotlevel = 0;
                        arraycounter2 ++;
                        getcounter2 ++;
                        System.out.println("-->" +s);
                    }
                    else
                        gotlevel ++;
                }
                if(str.contains("<a href=\"char.php?user=") && getcounter <= 5) {
                    String s = str;
                    s = s.replaceAll("</a></td>", "");
                    s = s.substring(s.lastIndexOf("\">") + 2);
                    names[arraycounter] = s;
                    arraycounter ++;
                    getcounter ++;
                }
            }
            for(int i = 0; i < names.length; i++)
                return_ += b() + names[i] + "(" + levels[i] + ")" + b() + ", ";
            input.close();
            return return_.substring(0, (return_.length() - 2));
        }
        catch(Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
    public String google(String query) {
        try {
            URLConnection connection = new URL("http://www.google.com/search?q=" + URLEncoder.encode(query)).openConnection();
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            connection.setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; fi; rv:1.8.1.6) Gecko/20070725 Firefox/2.0.0.6");
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            boolean hax = false;
            while ((str = input.readLine()) != null) {
                if(str.contains("<h2 class=r><a href=\"http"))
                    return str.substring(str.indexOf("<h2 class=r><a href=\"http") + 21, str.indexOf("\" class=l onmo"));
            }
            input.close();
            return query + " did not match any results";
        }
        catch(Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
    public String youtube(String query) {
        try {
            URLConnection connection = new URL("http://www.youtube.com/results?search_query=" + URLEncoder.encode(query)).openConnection();
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            connection.setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; fi; rv:1.8.1.6) Gecko/20070725 Firefox/2.0.0.6");
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            boolean hax = false;
            while ((str = input.readLine()) != null) {
                if(str.contains("<a class=\"newvtitlelink\" href"))
                    return "http://youtube.com" + str.substring(str.indexOf("href=\"") + 6, str.indexOf("\" rel="));
            }
            input.close();
            return query + " did not match any results";
        }
        catch(Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
    

    /** String **/
    public String channelAllowed = "#rsca";
    public String[] HALP = {"'!skillName character name' - Gives you the level of given stat from the given character",
        "'!stats character name' - Sends all skill levels from given character to you by private message",
        //"'!top5' - Gives you the skilltotals of the five players that have the greatest skilltotal",
        "'!top5 skillName' - Gives you the names of top five players of the given skill",
        "'!online' - Says the amount of players currently online",
        "'!google search phrase' - Searches for the given search phrase on google and says the first site if found",
        "'!youtube search phrase' - Searches for the given phrase on youtube and says the first video's link if found"};
    public String cookieValue = "punbb_cookie=";
    public String siteToUse = "http://boxxy.rscangel.org/";
    public String skillArray[] = {
            "attack", "defense", "strength", "hits", "ranged", "prayer", "magic", "cooking", "woodcut", "fletching",
            "fishing", "firemaking", "crafting", "smithing", "mining", "herblaw", "agility", "thieving"
    };
    /** Integer **/
    public int readTimeout = 30000;
    public int connectTimeout = 30000;
    public int[] experienceArray = {0, 83, 174, 276, 388, 512, 650, 801, 969, 1154, 1358, 1584, 1833, 2107, 2411, 2746, 3115, 3523, 3973, 4470, 5018, 5624, 6291, 7028, 7842, 8740, 9730, 10824, 12031, 13363, 14833, 16456, 18247, 20224, 22406, 24815, 27473, 30408, 33648, 37224, 41171, 45529, 50339, 55649, 61512, 67983, 75127, 83014, 91721, 101333, 111945, 123660, 136594, 150872, 166636, 184040, 203254, 224466, 247886, 273742, 302288, 333804, 368599, 407015, 449428, 496254, 547953, 605032, 668051, 737627, 814445, 899257, 992895, 1096278, 1210421, 1336443, 1475581, 1629200, 1798808, 1986068, 2192818, 2421087, 2673114,2951373, 3258594, 3597792, 3972294, 4385776, 4842295, 5346332, 5902831, 6517253, 7195629, 7944614, 8771558, 9684577, 10692629, 11805606, 13034431, 14391160};

}
