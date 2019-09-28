package coloradocollege.ifroning;

/**
 * A key is an item that is used on an activator.
 * @author Ian Froning
 * @version 1.0
 */
public class Key extends Item
{	
	/**
	 * Constructs a key item with the default name and description.
	 */
	public Key()
	{
		super();
	}
	
	/**
	 * Constructs a key item with a given name and description.
	 * @param aName the key name - the name the player gives when they want to interact with the key
	 * @param aDescription the key description - the text displayed when the player enters the room that contains the key or looks in their inventory
	 */
	public Key(String aName, String aDescription)
	{
		super(aName, aDescription);
	}
	
	/**
	 * Uses the key.
	 * @param activator the activator the key is used on
	 */
	public String useKey(Activator anActivator, Player thePlayer)
	{
		ActivatorList currentList = thePlayer.getLocation().getActivators();
		if (currentList.hasActivator(anActivator))
		{
			return anActivator.changeState(this, thePlayer) + "\n";
		}
		else
			return "You can't use that here." + "\n";
	}
}
