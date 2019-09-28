package coloradocollege.ifroning;

/**
 * A teleporter is a specialized item that moves the player from their current location to a new location.
 * @author Ian Froning
 * @version 1.0
 */
public class Teleporter extends Item
{
	Location destination;
	
	/**
	 * Constructs a teleporter item with the default name, description and teleportation destination.
	 */
	public Teleporter()
	{
		super();
		destination = new Location();
	}
	
	/**
	 * Constructs a teleporter item with a given name, description and teleportation destination.
	 * @param aName the teleporter name - the name the player gives when they want to interact with the teleporter
	 * @param aDescription the teleporter description - the text displayed when the player enters the room that contains the teleporter or looks in their inventory
	 * @param aDestination the location the teleporter teleports the player to
	 */
	public Teleporter(String aName, String aDescription, Location aDestination)
	{
		super(aName, aDescription);
		destination = aDestination;
	}
	
	/**
	 * Gets the teleporter destination.
	 * @return the destination
	 */
	public Location getDestination()
	{
		return destination;
	}
	
	/**
	 * Uses the teleporter.
	 * @param thePlayer the player to be teleported
	 */
	public String useTeleporter(Player thePlayer)
	{
		thePlayer.teleport(destination);
		return "You begin to feel very strange...\n\n" + thePlayer.getLocation().getDescription();
	}
}
