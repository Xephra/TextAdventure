import java.util.*;
public class Inventory {
	
	private List<Item> itemList;
	private Integer totalItemWeight;
	public Inventory() {
		itemList = new ArrayList<Item>();
	}
	public void AddItemToInv(Item item)
	{
		itemList.add(item);
	}
	public void RemoveItemFromInv(Item item)
	{
		itemList.remove(item);
	}
	public List<Item> GetItemList()
	{
		return itemList;
	}
	
	public boolean hasItem(String itemName)
	{
		for (Item item : itemList)
		{
			if(item.GetItemName().equalsIgnoreCase(itemName))
			{
				return true;
			}
		}
		return false;
	}

	public Item GetItem(String itemName)
	{
		for (Item item : itemList)
		{
			if(item.GetItemName().equalsIgnoreCase(itemName))
			{
				return item;
			}
		}
		return null;
	}
	
	public boolean isEmpty()
	{
		if(itemList.isEmpty())
		{
			return true;
		}
		return false;
	}
    public void getTotalInventoryWeight()
	{
        for(int i=1; i<= itemList.size(); i++)
        {
        	//weight = itemList.size() += itemList[GetItem(itemName)];
        	
        }
	}
	/*public Integer getTotalItemWeight() {
		return totalItemWeight;
	}
	public void setTotalItemWeight(Integer totalItemWeight) {
		this.totalItemWeight = totalItemWeight;
	}*/
}