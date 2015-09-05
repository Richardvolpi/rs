//For You Lazy SOB's! walks right over to edge bank.
//By: Random

public class EdgeBankWalker  extends Script {
    public EdgeBankWalker(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"EdgeWalker"};
    }
    public void start(String command, String params[]) {
        DisplayMessage("@cya@Sbot: @whi@You Lazy Bastard! Walking To Edge! - @or2@By Random",3);
        Walk(125,644);
        Walk(129,639);
        Walk(133,542);
        Walk(134,627);
        Walk(135,621);
        Walk(139,617);
        Walk(147,617);
        Walk(155,613);
        Walk(165,611);
        Walk(172,606);
        Walk(176,599);
        Walk(179,586);
        Walk(179,578);
        Walk(179,569);
        Walk(182,559);
        Walk(184,552);
        Walk(186,543);
        Walk(195,538);
        Walk(206,529);
        Walk(210,524);
        Walk(214,517);
        Walk(216,509);
        Walk(216,500);
        Walk(216,492);
        Walk(216,482);
        Walk(221,472);
        Walk(225,466);
        Walk(224,458);
        Walk(222,452);
        Walk(221,447);
        Walk(218,449);
        DisplayMessage("@whi@You Have Arrived at EdgeVille Bank Fatty", 3);
    }
}