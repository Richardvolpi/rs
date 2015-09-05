// Usage: /run ownage type@playerid
// where type 1=guthix 2=sarrodamin and 3=zammy

public class Guthix extends Script {
    public Guthix(mudclient mudclient) {
        super(mudclient);
    }
    public String[] getCommands() {
        return (new String[] {"ownage"});
    }
    public void start(String s, String as[]) {
        int spell_type = spell_type = Integer.parseInt(as[0]);
        int player_id = Integer.parseInt(as[1]);
        int spell_id = 0;
        switch(spell_type) {
            case 1:
                spell_id = 33;
                break;
            case 2:
                spell_id = 34;
                break;
            case 3:
                spell_id = 35;
                break;
            default:
                spell_id = 33;
                break;
        }
        DisplayMessage("@gre@SBoT: @blu@Goodluck ;)", 3);
        for(; Running(); Wait(1000))
            MagicPlayer(player_id,spell_id);
        DisplayMessage("@gre@You're welcome", 3);
    }
}
