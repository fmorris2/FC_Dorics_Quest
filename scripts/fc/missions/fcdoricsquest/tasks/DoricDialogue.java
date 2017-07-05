package scripts.fc.missions.fcdoricsquest.tasks;

import org.tribot.api.General;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.skills.mining.data.RockType;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fcdoricsquest.data.DoricSettings;

public class DoricDialogue extends Task implements ItemsRequiredTask
{
	private static final long serialVersionUID = -2799862046107080194L;
	
	private final Positionable DORIC_TILE = new RSTile(2951, 3451, 0);
	private final int DISTANCE_THRESHOLD = 2;

	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(DORIC_TILE) > DISTANCE_THRESHOLD)
			Travel.webWalkTo(DORIC_TILE);
		else
			if(new NpcDialogue("Talk-to", "Doric", 10, 0, 0, 1).execute())
				General.sleep(600, 1800);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return true;
	}

	@Override
	public String getStatus()
	{
		return "Doric dialogue";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(6, false, RockType.CLAY.getItemId()),
			new FCItem(4, false, RockType.COPPER.getItemId()),
			new FCItem(2, false, RockType.IRON.getItemId())
		};
	}

}
