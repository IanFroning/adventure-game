package coloradocollege.ifroning;

/**
 * An item has a name. It is intended to be picked up and used.
 * @author Ian Froning
 * @version 1.0
 */
public class Item
{
	String name;
	String description;
	
	/**
	 * Constructs an item with the default name.
	 */
	public Item()
	{
		name = "defaultItem";
		description = "An item which doesn't really do anything.";
	}
	
	/**
	 * Constructs an item with a given name and description.
	 * @param aName the item name - the name the player gives when they want to interact with the item
	 * @param aDescription the item description - the text displayed when the player enters the room that contains the item or looks in their inventory
	 */
	public Item(String aName, String aDescription)
	{
		name = aName;
		description = aDescription;
	}
	
	/**
	 * Gets the name the player calls the item by
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the description of the item as the player will see it as they enter the room that contains it or look in their inventory.
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	
}
