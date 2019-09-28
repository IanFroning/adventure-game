package coloradocollege.ifroning;

import java.util.HashMap;

/**
 * A location has a static description, activators that may change in state and items that may be added or removed. Every location has 6 potential neighbors: north, east, south, west, up and down. 
 * @author Ian Froning
 * @version 1.0
 */
public class Location
{	
	private String description;
	private ActivatorList activators;
	private HashMap<String, ActivatorList> requiredActivators;
	private LocationInventory inventory;
	private HashMap<String, Location> map;
	private boolean finalLocation;
	
	/**
	 * Constructs an empty location.
	 */
	public Location()
	{
		description = "You are in a boudless void.";
		activators = new ActivatorList();
		requiredActivators = new HashMap<String, ActivatorList>();
		inventory = new LocationInventory();
		map = new HashMap<String, Location>(6);
		finalLocation = false;
	}
	
	/**
	 * Constructs a location.
	 * @param aDescription the description of the room - what the player sees when they enter the location
	 * @param anActivatorList the ActivatorList that contains the activators in the room 
	 * @param anInventory the inventory of items in the room
	 */
	public Location(String aDescription, ActivatorList anActivatorList, LocationInventory anInventory)
	{
		description = aDescription;
		activators = anActivatorList;
		requiredActivators = new HashMap<String, ActivatorList>();
	    inventory = anInventory;
	    map = new HashMap<String, Location>(6);
	    finalLocation = false;
	}
	
	/**
	 * Constructs a final location (the location that stops all player input).
	 * @param aDescription the description of the room - what the player sees when they enter the location
	 * @param isFinalLocation set to true if the location is the final location
	 */
	public Location(String aDescription, boolean isFinalLocation)
	{
		description = aDescription;
		activators = new ActivatorList();
		requiredActivators = new HashMap<String, ActivatorList>();
		inventory = new LocationInventory();
		map = new HashMap<String, Location>(6);
		finalLocation = isFinalLocation;
	}
	
	
	
	/**
	 * Gets the location's inventory
	 * @return the inventory
	 */
	public LocationInventory getInventory()
	{
		return inventory;
	}
	
	/**
	 * Gets the location's activator list.
	 * @return the list of activators
	 */
	public ActivatorList getActivators()
	{
		return activators;
	}
	
	/**
	 * Gets the list of activators that must be activated in order for travel to the location in the given direction to be possible.
	 * @param direction the direction
	 * @return the list of required activators
	 */
	public ActivatorList getRequiredActivators(String direction)
	{
		return requiredActivators.get(direction);
	}
	
	/**
	 * Gets the description of the location and the activators and items in it.
	 * @return the description
	 */
	public String getDescription()
	{
		return description + " " + activators.getDescription() + " " + inventory.getDescription();
	}
	
		
	/**
	 * Returns true if the correct activators are in their altered state
	 * @return true if the correct activators are in their altered state
	 */
	public boolean theWayIsClear(String direction)
	{
		if (requiredActivators.get(direction) == null)
			return true;
		else
		{
			if (requiredActivators.get(direction).areActivated())
				return true;
			else
				return false;
		}
	}
	
	/**
	 * Returns true if this location has a neighbor in the given direction.
	 * @param direction the direction in which the neighbor is
	 * @return true if this location has a neighbor in that direction
	 */
	public boolean hasNeighbor(String direction)
	{
		if (map.containsKey(direction))
				return true;
			else
				return false;
	}
	
	/**
	 * Returns true if this location is the final location (the location that stops all player input).
	 * @return true if this location is the final location
	 */
	public boolean isFinalLocation()
	{
		return finalLocation;
	}
	
	/**
	 * Adds a neighbor North, East, South, West, above or below this location.
	 * @param direction "N" for North, "E" for East, "S" for South, "W" for West "U" for up, or "D" for down
	 * @param location the location to be added as a neighbor
	 */
	public void addNeighbor(String direction, Location location)
	{
		if ((direction.equals("N") || direction.equals("E") || direction.equals("S") || direction.equals("W") || direction.equals("U") || direction.equals("D")))
			map.put(direction, location);
	}
	
	/**
	 * Blocks a direction to the player and adds an activator list whose activators must all be activated in order to allow passage.
	 * @param direction the direction that will be blocked until all the required activators have been activated
	 * @param theRequiredActivators the activator list of activators that must be activated
	 * @param anErrorMessage the message displayed if the player tries to move in the blocked direction
	 */
	public void addRequiredActivators(String direction, ActivatorList theRequiredActivators, String anErrorMessage)
	{
		if ((direction.equals("N") || direction.equals("E") || direction.equals("S") || direction.equals("W") || direction.equals("U") || direction.equals("D")))
		{
			requiredActivators.put(direction, theRequiredActivators);
			theRequiredActivators.setErrorMessage(anErrorMessage);
		}
	}
	
	/**
	 * Changes the location to the location that is in the given direction.
	 * @param direction "N" for North, "E" for East, "S" for South, "W" for West "U" for up, or "D" for down
	 * @return the new location or void if there is no location
	 */
	public Location changeLocation(String direction)
	{
		return (Location) map.get(direction);
	}
		
}