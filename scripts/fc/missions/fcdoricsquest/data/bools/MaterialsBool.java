package scripts.fc.missions.fcdoricsquest.data.bools;

import scripts.fc.api.items.FCItem;
import scripts.fc.api.items.FCItemList;
import scripts.fc.framework.quest.QuestBool;

public class MaterialsBool extends QuestBool
{
	public static final FCItemList ITEM_LIST = new FCItemList(
			new FCItem(6, false, "Clay"), 
			new FCItem(2, false, "Iron ore"), 
			new FCItem(4, false, "Copper ore")
	);
	
	public MaterialsBool(boolean normal)
	{
		super(normal);
	}

	@Override
	public boolean value()
	{
		return ITEM_LIST.hasListInInv();
	}

}
