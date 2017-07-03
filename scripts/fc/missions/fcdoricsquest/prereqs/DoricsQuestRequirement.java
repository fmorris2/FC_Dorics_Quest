package scripts.fc.missions.fcdoricsquest.prereqs;

import java.util.List;

import org.tribot.api2007.Skills.SKILLS;

import scripts.fc.api.skills.GatheringMode;
import scripts.fc.api.skills.ProgressionType;
import scripts.fc.api.skills.mining.data.RockType;
import scripts.fc.api.skills.mining.data.locations.impl.RimmingtonMine;
import scripts.fc.framework.WorldHopSettings;
import scripts.fc.framework.goal.impl.ResourceGoal;
import scripts.fc.framework.goal.impl.SkillGoal;
import scripts.fc.framework.mission.Mission;
import scripts.fc.framework.requirement.item.ItemRequirement;
import scripts.fc.framework.requirement.item.ReqItem;
import scripts.fc.framework.requirement.item.SingleReqItem;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.missions.fcmining.FCMining;

public class DoricsQuestRequirement extends ItemRequirement
{
	public DoricsQuestRequirement(FCMissionScript script)
	{
		super(script);
	}

	@Override
	public ReqItem[] getReqItems()
	{
		WorldHopSettings hopSettings = new WorldHopSettings(-1, 20, false);
		hopSettings.resourceStolen = 20;
		
		return new ReqItem[]
		{
			new SingleReqItem(RockType.CLAY.getItemId(), 6, true, true,
					new FCMining(script, true, true, hopSettings, RockType.CLAY, GatheringMode.BANK, null, ProgressionType.EXPERIENCE, new ResourceGoal(6, RockType.CLAY.getItemId()))), 
			
			new SingleReqItem(RockType.COPPER.getItemId(), 4, true, true,
					new FCMining(script, true, true, hopSettings, RockType.COPPER, GatheringMode.BANK, null, ProgressionType.EXPERIENCE, new ResourceGoal(4, RockType.COPPER.getItemId()))), 
			
			new SingleReqItem(RockType.IRON.getItemId(), 2, true, true,
					new FCMining(script, true, true, hopSettings, RockType.IRON, GatheringMode.BANK, null, ProgressionType.EXPERIENCE, new ResourceGoal(2, RockType.IRON.getItemId())),
					new FCMining(script, true, true, hopSettings, null, GatheringMode.BANK, new RimmingtonMine(), ProgressionType.EXPERIENCE, new SkillGoal(SKILLS.MINING, 15)))
		};
	}

	@Override
	public List<Mission> getReqMissions()
	{
		return null;
	}

}
