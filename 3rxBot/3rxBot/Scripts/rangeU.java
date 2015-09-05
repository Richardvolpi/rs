public class rangeU extends Methods {
	public String[] ids;
	public rangeU(mudclient rs) {
		super(rs);
	}

	public void Main(String[] args) {
		ids = GetInput("Enter the ids you want to range. Seperate with a ,").split(",");
		int[] Ids = new int[ids.length];
		for(int s1 = 0; s1 < Ids.length; s1++) {
			Ids[s1] = Integer.parseInt(ids[s1]);
		}
		int x = GetX();
		int y = GetY();
		Display("Script started fighting selected Npcs. Starting in position " + x +","+y);
		while(Running()) {
			if(GetX() != x || GetY() != y) {
				Display("Bugger. Moved off starting position");
				while(GetX() != x || GetY() != y) {
					Display("Yes i am moving back zym");
					ForceWalkToWait(x,y);
					Wait(1000);
				}
				Display("Back at start position");
			}
			int[] npc = GetAllNpcById(Ids);
			if(DistanceTo(x,y,npc[1],npc[2]) <= 4) {
				AttackNpc(npc[0]);
				Wait(100);
			} else {
				Display("No fucking Npcs nearby");
				HopServer();
				Wait(5000);
			}


		}

	}

}