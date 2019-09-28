package coloradocollege.ifroning;

/**
 * A potion is a specialized item that can be used on the player.
 * @author Ian Froning
 * @version 1.0
 */
public class Potion extends Item
{
	/**
	 * Constructs a potion item with the default name and description.
	 */
	public Potion()
	{
		super();
	}
	
	/**
	 * Constructs a potion item with a given name and description.
	 * @param aName the potion name - the name the player gives when they want to interact with the potion
	 * @param aDescription the potion description - the text displayed when the player enters the room that contains the potion or looks in their inventory
	 */
	public Potion(String aName, String aDescription)
	{
		super(aName, aDescription);
	}
	
	/**
	 * Uses the potion.
	 * @return the confirmation
	 */
	public String usePotion()
	{
		return "Potions haven't been implemented yet!";
	}
}
