package scripts.fc.missions.fcdoricsquest.data;

import org.tribot.api2007.Game;

import scripts.fc.framework.quest.QuestBool;
import scripts.fc.missions.fcdoricsquest.FCDoricsQuest;
import scripts.fc.missions.fcdoricsquest.data.bools.MaterialsBool;

public enum DoricSettings
{
	START_QUEST(new int[][]{{FCDoricsQuest.QUEST_PROGRESS_SETTING, 0}}),
	FINISH_QUEST(new int[][]{{FCDoricsQuest.QUEST_PROGRESS_SETTING, 10}});
	
	private int[][] settings;
	private QuestBool[] bools;
	public final static MaterialsBool HAS_MATERIALS = new MaterialsBool(true);
	
	DoricSettings(int[][] settings, QuestBool... bools)
	{
		this.settings = settings;
		this.bools = bools;
	}
	
	
	public boolean isValid()
	{
		if(!HAS_MATERIALS.validate())
			return false;
		
		for(int i = 0; i < settings.length; i++)
		{
			if(Game.getSetting(settings[i][0]) != settings[i][1])
				return false;
		}
		
		for(QuestBool b : bools)
		{
			if(!b.validate())
				return false;
		}
		
		return true;
	}
}
