package coloradocollege.ifroning;

import java.util.ArrayList;

/**
 * An activator list is a list of activators stored in an array.
 * @author Ian Froning
 * @version 1.0
 */
public class ActivatorList
{
	private ArrayList<Activator> list;
	private String errorMessage;
	
	/**
	 * Constructs an activator list.
	 */
	public ActivatorList()
	{
		list = new ArrayList<Activator>();
	}
	
	/**
	 * Gets the number of activators in the list.
	 * @return the number of activators
	 */
	public int getLength()
	{
		return list.size();
	}
	
	/**
	 * Gets an activator of a given index from the activator list, if it exists.
	 * @param index the activator's index
	 * @return the activator or null if activator was not found
	 */
	public Activator getActivator(int index)
	{
		if (0 <= index && index < list.size())
			return list.get(index);
		else
			return null;
	}
	
	/**
	 * Gets an activator of the given name from the activator list, if it exists.
	 * @param activatorName the activator's name
	 * @return the activator or null if activator was not found
	 */
	public Activator getActivator(String activatorName)
	{
		for (Activator activator : list)
		{
			if (activatorName.equalsIgnoreCase(activator.getName()))
			return activator;
		}
		return null;
	}
	
	/**
	 * Gets the error message.
	 * @return the error message
	 */
	public String getErrorMessage()
	{
		return errorMessage;
	}
	
	/**
	 * Returns true if the given activator is in the list
	 * @param anActivator the activator to look for
	 * @return true if the activator is found
	 */
	public boolean hasActivator(Activator anActivator)
	{
		for (Activator activator : list)
		{
			if (activator.equals(anActivator))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns true if all of the activators in the list are activated.
	 * @return true if all of the activators in the list are activated
	 */
	public boolean areActivated()
	{
		for (Activator activator : list)
		{
			if (!activator.isActivated())
				return false;		
		}
		return true;
	}
	
	/**
	 * Adds an activator to the list.
	 * @param anActivator the activator to be added
	 * @return the confirmation
	 */
	public void addActivator(Activator anActivator)
	{
		list.add(anActivator);
	}
	
	/**
	 * Removes an activator from the list.
	 * @param anActivator the activator to be removed
	 * @return the confirmation
	 */
	public void removeActivator(Activator anActivator)
	{
		if (this.hasActivator(anActivator))
			list.remove(anActivator);
	}
	
	/**
	 * Sets the error message.
	 * @param anErrorMessage the error message
	 */
	public void setErrorMessage(String anErrorMessage)
	{
		errorMessage = anErrorMessage;
	}
	
	/**
	 * Displays the list of activator descriptions in this location.
	 * @return the activator descriptions
	 */
	public String getDescription()
	{
		String activatorDescription = "";
		for (Activator activator : list)
			activatorDescription = activatorDescription + activator.getState();
		
		return activatorDescription;
	}
}
