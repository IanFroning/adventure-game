package coloradocollege.ifroning;

/**
 * A player has a name, location and inventory.
 * @author Ian Froning
 * @version 1.0
 */
public class Player
{
	private String name;
	private PlayerInventory inventory;
	private Location location;
	
	/**
	 * Constructs a nameless player.
	 */
	public Player()
	{
		name = "noname";
		inventory = new PlayerInventory(this);
		location = new Location();
	}
	
	/**
	 * Constructs a player.
	 * @param aName the player's name
	 * @param startingLocation the location the player will start from
	 */
	public Player(String aName, Location startingLocation)
	{
		name = aName;
		inventory = new PlayerInventory(this);
		location = startingLocation;
	}
	
	/**
	 * Gets player's name.
	 * @return the player's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the player's inventory.
	 * @return the player's inventory
	 */
	public PlayerInventory getInventory()
	{
		return inventory;
	}
	
	/**
	 * Gets the player's location.
	 * @return the player's location
	 */
	public Location getLocation()
	{
		return location;
	}
	
	/**
	 * Moves the player one cell in the given direction.
	 * @param direction "N" for North, "E" for East, "S" for South, "W" for West "U" for up, or "D" for down
	 * @return the confirmation
	 */
	public String move(String direction)
	{
		
		if (location.hasNeighbor(direction))
		{
			if (location.theWayIsClear(direction))
			{
				location = location.changeLocation(direction);
				return location.getDescription();
			}
			else
				return location.getRequiredActivators(direction).getErrorMessage() + "\n";
		}
		else
			return "You can't go that way.\n";
	}
	
	/**
	 * Teleports the player to a given location
	 * @param newLocation the destination
	 */
	public void teleport(Location newLocation)
	{
		location = newLocation;
	}
}
