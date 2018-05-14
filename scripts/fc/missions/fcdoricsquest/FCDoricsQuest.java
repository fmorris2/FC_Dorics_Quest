package scripts.fc.missions.fcdoricsquest;

import java.util.Arrays;
import java.util.LinkedList;

import org.tribot.api2007.Game;

import scripts.fc.framework.quest.QuestScriptManager;
import scripts.fc.framework.requirement.Requirement;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fcdoricsquest.prereqs.DoricsQuestRequirement;
import scripts.fc.missions.fcdoricsquest.tasks.DoricDialogue;

public class FCDoricsQuest extends QuestScriptManager
{
	public static final int QUEST_PROGRESS_SETTING = 31;
	
	public FCDoricsQuest(FCMissionScript fcScript)
	{
		super(fcScript);
	}
	
	@Override
	public boolean hasReachedEndingCondition()
	{
		return Game.getSetting(QUEST_PROGRESS_SETTING) == 100;
	}

	@Override
	public String getMissionName()
	{
		return "Doric's Quest";
	}
	
	@Override
	public String getEndingMessage()
	{
		return "Doric's Quest has been completed.";
	}

	@Override
	public void execute()
	{
		executeTasks();
	}

	@Override
	public LinkedList<Task> getTaskList()
	{
		return new LinkedList<>(Arrays.asList(new DoricDialogue()));
	}

	@Override
	public Requirement[] getRequirements()
	{
		return new Requirement[]{new DoricsQuestRequirement(missionScript)};
	}
	
	public String toString()
	{
		return getMissionName();
	}

	@Override
	public String[] getMissionSpecificPaint()
	{
		return new String[0];
	}

	@Override
	public void resetStatistics()
	{
	}

	@Override
	public boolean canStart()
	{
		return true;
	}

	@Override
	public int getQuestPointReward() {
		return 1;
	}

}
