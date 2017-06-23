package scripts.fc.fcdoricsquest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Starting;

import scripts.fc.framework.mission.Mission;
import scripts.fc.framework.paint.FCPaintable;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.missions.fcdoricsquest.FCDoricsQuest;

@ScriptManifest(
		authors     = { 
		    "Final Calibur",
		}, 
		category    = "Quests", 
		name        = "FC Doric's Quest", 
		version     = 0.2, 
		description = "Completes Doric's Quest for you. Start anywhere.", 
		gameMode    = 1)

public class FCDoricsQuestScript extends FCMissionScript implements FCPaintable, Painting, Starting, Ending
{

	@Override
	protected Queue<Mission> getMissions()
	{
		return new LinkedList<>(Arrays.asList(new FCDoricsQuest(this)));
	}

	@Override
	protected String[] scriptSpecificPaint()
	{
		return new String[]{};
	}

}
