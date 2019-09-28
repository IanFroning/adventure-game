package coloradocollege.ifroning;

/**
 * A player inventory is a specialized inventory that is assigned to a player.
 * @author Ian Froning
 * @version 1.0
 */
public class PlayerInventory extends Inventory
{
	private Player player;
	
	/**
	 * Constructs an inventory belonging to a player.
	 * @param thePlayer the player
	 */
	public PlayerInventory(Player thePlayer)
	{
		super();
		player = thePlayer;
	}
	
	/**
	 * Picks up an item in the player's current location.
	 * @param anItem the item to be picked up
	 * @return the confirmation
	 */
	public String pickUp(Item anItem)
	{
		if (anItem != null)
		{
			this.addItem(anItem);
			player.getLocation().getInventory().removeItem(anItem);
			return anItem.getDescription() + " added to inventory.\n";
		}
		else
			return "Um...there aren't any of those here.";
	}
	
	/**
	 * Drops an item from the inventory so that it lands in the player's current location.
	 * @param anItem the item to be removed
	 * @return the confirmation
	 */
	public String drop(Item anItem)
	{
		if (anItem != null)
		{
			this.removeItem(anItem);
			player.getLocation().getInventory().addItem(anItem);
			return "Dropped " + anItem.getDescription() + ".\n";
		}
		else
			return "You don't have any of those.\n";
	}
	
	/**
	 * Uses a given item to receive its effect.
	 * @param anItem the item to be used
	 * @param activator the activator the item is used on, if it's a key (use an empty Activator object if it's not)
	 * @param thePlayer the player using the object
	 * @return the confirmation
	 */
	public String use(Item anItem, Activator anActivator, Player thePlayer)
	{
		if (anItem != null)
		{	
			if (anItem instanceof Potion)
			{
				Potion aPotion = (Potion) anItem;
				this.removeItem(anItem);
				return aPotion.usePotion();
			}
			else if (anItem instanceof Key)
			{
				Key aKey = (Key) anItem;
				return aKey.useKey(anActivator, thePlayer);
			}
			else if (anItem instanceof Teleporter)
			{
				Teleporter aTeleporter = (Teleporter) anItem;
				this.removeItem(anItem);
				return aTeleporter.useTeleporter(thePlayer);
			}
			else
				return "I don't know what that does.\n";
		}
		else
			return "You don't have any of those.\n";
	}
	
	/**
	 * Gets a list of the items in the player's inventory as a string.
	 * @return the list of items or an appropriate message if the inventory is empty
	 */
	public String getDescription()
	{
		if (super.getDescription().equals(""))
			return "I'm afraid you don't have any items. Better go and get some.\n";
		else
			return "Turning out your pockets, you find the following:\n\n" + super.getDescription();
	}
}
