package coloradocollege.ifroning;

/**
 * An activator is any object that the player can interact with that is not an item.
 * @author Ian Froning
 * @version 1.0
 */
public class Activator
{
	private String name;
	private String state;
	private String initialState;
	private String activatedState;
	private String changeMessage;
	private Key keyItem;
	
	/**
	 * Constructs an empty activator.
	 */
	public Activator()
	{
		name = "";
		initialState = "";
		activatedState = " ";
		changeMessage = "";
		keyItem = new Key();
		state = initialState;
	}
	
	/**
	 * Constructs an activator with a given initial state, altered state, change message and key item. The state is set to the initial state. 
	 * @param aName the name
	 * @param anInitialState the initial state
	 * @param anActivatedState the activated state (make sure this is not the same as the initial state or the game won't be able to tell the two apart)
	 * @param aChangeMessage the message displayed when the activator is changed to its altered state
	 * @param keyItem the key item
	 */
	public Activator(String aName, String anInitialState, String anActivatedState, String aChangeMessage, Key aKeyItem)
	{
		name = aName;
		initialState = anInitialState;
		activatedState = anActivatedState;
		changeMessage = aChangeMessage;
		keyItem = aKeyItem;
		state = initialState;	
	}
	
	/**
	 * Gets the activator's name.
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the description of the activator's state as the player will see it as they enter the room that contains it.
	 * @return the description
	 */
	public String getState()
	{
		return state;
	}
	
	/**
	 * Returns true if the activator is in its altered state.
	 * @return true if the activator is in its altered state
	 */
	public boolean isActivated()
	{
		if (state.equals(activatedState))
			return true;
		else
			return false;
	}
	
	/**
	 * Changes the state to the altered state and returns the new description.
	 * @return the description of the new state
	 */
	public String changeState(Key aKeyItem, Player thePlayer)
	{
		if (state.equals(activatedState))
			return "You've already done that.";
		else
		{
			if (aKeyItem.equals(keyItem))
			{
				state = activatedState;
				thePlayer.getInventory().removeItem(keyItem);
				return changeMessage;
			}
			else
				return "You can't use " + aKeyItem.getName().toLowerCase() + " on that. Keep trying if you want though.";
		}
	}

}
