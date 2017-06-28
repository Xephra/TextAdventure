
public /*abstract*/ class Item {
	protected String itemName;
	
	public Item(String name){
		this.itemName = name;
	}
	public String GetItemName()
	{
		return itemName;
	}
	//public abstract void use();
}
