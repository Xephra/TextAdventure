import java.util.*;
public class Inventory 
{
	
	private List<Item> itemList;
	private int maxInventoryWeigth = 250;
	
	public int getMaxInventoryWeigth() 
	{
		return maxInventoryWeigth;
	}

	public void setMaxInventoryWeigth(int maxInventoryWeigth) 
	{
		this.maxInventoryWeigth = maxInventoryWeigth;
	}

	public int getTotalWeight() 
	{
		return CheckTotalInventoryWeight();
	}
	
	public Inventory() 
	{
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
    private int CheckTotalInventoryWeight()
	{
    	int weight = 0;
        for(int i=0; i< itemList.size(); i++)
        {
        	weight += itemList.get(i).getWeight();
        	//System.out.println(itemList.get(i).getWeight());
        }
        return weight;
	}
	/*public Integer getTotalItemWeight() {
		return totalItemWeight;
	}
	public void setTotalItemWeight(Integer totalItemWeight) {
		this.totalItemWeight = totalItemWeight;
	}*/
}