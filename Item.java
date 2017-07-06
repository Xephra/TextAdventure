
public abstract class Item {
	protected String itemName;
	protected int weight;
	
	public String GetItemName()
	{
		return itemName;
	}
	
	public int getWeight() 
	{
		return weight;
	}
	
	public void setWeight(Integer weight) 
	{
		this.weight = weight;
	}
	public abstract void useItem(Player player);
	//public abstract void sellItem();
}
