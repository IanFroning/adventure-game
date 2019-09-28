package coloradocollege.ifroning;

import java.util.ArrayList;

/**
 * An inventory is a list of items stored in an array.
 * @author Ian Froning
 * @version 1.0
 */
public class Inventory
{
	private ArrayList<Item> inventory;
	
	/**
	 * Constructs an empty inventory.
	 */
	public Inventory()
	{
		inventory = new ArrayList<Item>();
	}
	
	/**
	 * Gets the number of items in the inventory.
	 * @return the number of items
	 */
	public int getLength()
	{
		return inventory.size();
	}
	
	/**
	 * Gets an item of a given index from the inventory, if it exists.
	 * @param index the index
	 * @return the item or null if item was not found
	 */
	public Item getItem(int index)
	{
		if (0 <= index && index < inventory.size())
			return inventory.get(index);
		else
			return null;
	}
	
	/**
	 * Gets an item of the given name from the inventory, if it exists.
	 * @param itemName the name of the item
	 * @return the item or null if item was not found
	 */
	public Item getItem(String itemName)
	{
		for (Item item : inventory)
		{
			if (itemName.equalsIgnoreCase(item.getName()))
			return item;
		}
		return null;
	}
	
	/**
	 * Returns true if the given item is in the inventory.
	 * @param anItem the item to look for
	 * @return true if the item is found
	 */
	public boolean hasItem(Item anItem)
	{
		for (Item item : inventory)
		{
			if (item.equals(anItem))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns true if there is an item of the given name in the inventory.
	 * @param itemName the name of the item to look for
	 * @return true if the name is found
	 */
	public boolean hasItem(String itemName)
	{
		for (Item item : inventory)
		{
			if (itemName.equalsIgnoreCase(item.getName()))
				return true;
		}
		return false;
	}
		
	/**
	 * Adds an item to the inventory.
	 * @param anItem the item to be added
	 * @return the confirmation
	 */
	public void addItem(Item anItem)
	{
		inventory.add((Item) anItem);
	}
	
	/**
	 * Removes an item from the inventory.
	 * @param anItem the item to be removed
	 * @return the confirmation
	 */
	public void removeItem(Item anItem)
	{
		if (this.hasItem(anItem))
			inventory.remove((Item) anItem);
	}
	
	/**
	 * Gets a list of the items in the inventory as a string.
	 * @return a list of the items
	 */
	public String getDescription()
	{
		String itemDescrptions = "";
		for (Item item : inventory)
			itemDescrptions = itemDescrptions + item.getDescription() + "\n";	
		return itemDescrptions;
	}
}
