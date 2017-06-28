
public /*abstract*/ class Item {
	protected String itemName;
	private Integer weight;
	
	public Item(String name, Integer weight)
	{
		this.itemName = name;
		this.weight = weight;
	}
	
	public String GetItemName()
	{
		return itemName;
	}
	
	public Integer getWeight() 
	{
		return weight;
	}
	
	public void setWeight(Integer weight) 
	{
		this.weight = weight;
	}

}
