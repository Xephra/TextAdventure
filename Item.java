
public /*abstract*/ class Item {
	protected String itemName;
	private int weight;
	
	public Item(String name, Integer weight)
	{
		this.itemName = name;
		this.weight = weight;
	}
	
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

}
