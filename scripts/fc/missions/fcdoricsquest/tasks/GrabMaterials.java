package scripts.fc.missions.fcdoricsquest.tasks;

import org.tribot.api.Timing;
import org.tribot.api2007.Banking;

import scripts.fc.api.banking.FCBanking;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fcdoricsquest.FCDoricsQuest;
import scripts.fc.missions.fcdoricsquest.data.DoricSettings;
import scripts.fc.missions.fcdoricsquest.data.bools.MaterialsBool;

public class GrabMaterials extends Task
{
	private static final long serialVersionUID = 8860378162856920333L;
	
	private final int FAILURE_THRESHOLD = 5;
	
	private FCDoricsQuest script;
	private int failSafe;
	
	public GrabMaterials(FCDoricsQuest script)
	{
		this.script = script;
	}

	@Override
	public boolean execute()
	{
		if(failSafe >= FAILURE_THRESHOLD)
			script.noMaterials = true;
		else
		{
			if(Banking.isInBank())
			{
				if(Banking.isBankScreenOpen())
					handleBanking();
				else if(Banking.openBank())
					Timing.waitCondition(FCConditions.BANK_LOADED_CONDITION, 4500);
			}
			else
				Travel.walkToBank();
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return !DoricSettings.HAS_MATERIALS.validate();
	}

	@Override
	public String getStatus()
	{
		return "Grab materials";
	}
	
	private void handleBanking()
	{
		if(!FCBanking.withdraw(MaterialsBool.ITEM_LIST))
			failSafe++;
	}

}
