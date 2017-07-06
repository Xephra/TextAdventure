
public class Player {
	
	private Room currentRoom;
    //private Inventory playerInventory;
	//Player Variables
	private int playerHealth = 50;
	private boolean radiationSick;
	
	
	
	public Player()
	{
		radiationSick = false;
		//playerInventory = new Inventory();
	}
	/*public Inventory getInventory()
	{
		return playerInventory;
	}*/
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	public void setCurrentRoom(Room room)
	{
		this.currentRoom=room;
	}
	public void damage(int damageAmount)
	{
		this.playerHealth-=damageAmount;
		if (radiationSick){
			this.playerHealth-=5;
			System.out.println("You're suffering from radiation sickness! + -5 health.");
		}
	}
	public void heal(int healingAmount)
	{
		this.playerHealth+=healingAmount;
	}
	public Boolean isAlive()
	{
		if(playerHealth <= 0)
		{	
			return false;
			
		}
		return true;
	}
	public void printHealth(){
		 System.out.println("You are bleeding, you lost 1 health. (Current Health: " + playerHealth + ")");
	}
	public boolean isRadiationSick() {
		return radiationSick;
	}
	public void setRadiationSick(boolean radiationSick) {
		this.radiationSick = radiationSick;
	}
}