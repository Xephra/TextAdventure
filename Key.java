
public class Key extends Item {

	private Room room;
	
	public Key(String name, int weight) {
		this.itemName = name;
		this.weight = weight;
	}

	public void useItem(Player player) 
	{
		if(player.getCurrentRoom().getName().equalsIgnoreCase("Floor5"))
		{
			room.setIsLocked(false);
			System.out.println("The door to the platinum mine is now unlocked!");
		}
	}
	
	public void setLockedRoom(Room room) {
		this.room = room;
	}
}
