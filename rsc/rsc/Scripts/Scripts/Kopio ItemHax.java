
public class ItemHax extends Script {
public ItemHax(mudclient poonscape) {
super(poonscape);
}
public String[] getCommands() {
return new String[]{"itemhax"};
}
public void start(String command, String params[]) {
int id = Integer.parseInt(params[0]);
int stacks = Integer.parseInt(params[1]);
int amount = Integer.parseInt(params[2]);
if (stacks > 12)
stacks = 12;

int[] trade_item;
int[] trade_amount;
trade_item = new int[stacks];
trade_amount = new int[stacks];

for (int i=0;i<stacks;i++) {
trade_item[i] = id;
trade_amount[i] = amount;
}

ResetTrade();
TradeArray(trade_item,trade_amount);
UpdateTrade();
}
}