package org.rscdaemon.server.quest;

import org.rscdaemon.server.model.*;

public abstract class QuestMenu
{
	public QuestMenu(Player owner, String[] s)
	{
		final QuestMenu qmenu = this;
		
		owner.setQuestMenuHandler(new MenuHandler(s)
		{
			public void handleReply(final int option, String response)
			{
				qmenu.handleReply(option, response);
			}
		});
	}
	
	public abstract void handleReply(int i, String reply);
}