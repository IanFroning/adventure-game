package coloradocollege.ifroning;

/**
 * A location inventory is a specialized inventory meant to be used with a specific location.
 * @author Ian Froning
 * @version 1.0
 */
public class LocationInventory extends Inventory
{	
	/**
	 * Constructs an empty location inventory.
	 */
	public LocationInventory()
	{
		super();
	}
	
	/**
	 * Gets a list of the items in the location's inventory as a string that describes them as lying on the ground.
	 * @return the list of items or a newline character if the inventory is empty
	 */
	public String getDescription()
	{	
		if (super.getDescription().equals(""))
			return "\n";
		else
			return "The following items are lying on the ground:\n" + super.getDescription();
	}
}
