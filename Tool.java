public class Tool extends Item {

	public Tool(String name, int weight) {
		this.itemName = name;
		this.weight = weight;
	}
	public void useItem(Player player) 
	{
		System.out.println("You picked away into the cliff and some minerals fell out.");
		
		if(player.getCurrentRoom().getName().equalsIgnoreCase("outside"))
		{
			System.out.println("You think to yourself: Picking away into the dirt isn't the best way to get ores.");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("mineEntrance"))
		{
			System.out.println("I'm at least near the entrance of the mine, but I should get in to it to actually find some valuable things.");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("Floor1"))
		{
			System.out.println("Not much here... only normal rocks.");
			System.out.println("I should get to where the actual ores are.");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("Floor2"))
		{
			System.out.println("Not much here... only normal rocks.");
			System.out.println("I should get to where the actual ores are.");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("Floor3"))
		{
			System.out.println("Not much here... only normal rocks.");
			System.out.println("I should get to where the actual ores are.");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("Floor4"))
		{
			System.out.println("Not much here... only normal rocks.");
			System.out.println("I should get to where the actual ores are.");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("Floor5"))
		{
			System.out.println("Not much here... only normal rocks.");
			System.out.println("I should get to where the actual ores are.");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("coalMine"))
		{
			player.getCurrentRoom().getRoomInventory().AddItemToInv(player.getCurrentRoom().getHiddenInventory().GetItem("coal"));
			System.out.println("Some rocks fell down, there may be some coal in there too.");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("ironMine"))
		{
			player.getCurrentRoom().getRoomInventory().AddItemToInv(player.getCurrentRoom().getHiddenInventory().GetItem("Iron"));
			System.out.println("Some rocks fell down, there seems to be traces of red iron ore in the rubble.");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("goldMine"))
		{
			player.getCurrentRoom().getRoomInventory().AddItemToInv(player.getCurrentRoom().getHiddenInventory().GetItem("Gold"));
			System.out.println("Some rocks fell down, there's certainly shiny chunks in there!");
		}
		if(player.getCurrentRoom().getName().equalsIgnoreCase("platMine"))
		{
			double v =  Math.random()*10;
			
			if (v > 8)
			{
			player.getCurrentRoom().getRoomInventory().AddItemToInv(player.getCurrentRoom().getHiddenInventory().GetItem("Uranium"));
			} 
			else 
			{
				player.getCurrentRoom().getRoomInventory().AddItemToInv(player.getCurrentRoom().getHiddenInventory().GetItem("Platinum"));
			}
			player.getCurrentRoom().getRoomInventory().AddItemToInv(player.getCurrentRoom().getHiddenInventory().GetItem("Platinum"));
			System.out.println("Some rocks fell down, it's a bit hard to see but you do see some platinum!");
			System.out.println("There may even be some uranium in there... better watch out for that.");
		}
	}
	/*public void sellItem()
	{
		System.out.println("You can not sell this item.");
	}*/
}
