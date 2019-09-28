package coloradocollege.ifroning;

/**
 * Interprets a string of text as a command and attempts to follow it.
 * @author Ian Froning
 * @version 1.0
 */
public class Command
{
	private Player player;
	private String input;
	
	/**
	 * Constructs a command based on the player's inputed text
	 * @param thePlayer the player
	 * @param text the text inputed by the player
	 */
	public Command(Player thePlayer, String text)
	{
		player = thePlayer;
		input = text;
	}
	
	/**
	 * Searches a given inventory for an item whose name is contained in the input text.
	 * @param anInventory the inventory to search in
	 * @return the item or null of nothing is found
	 */
	private Item searchForItem(Inventory anInventory)
	{
		Item item = null;
		for (int i = 0; i < anInventory.getLength(); i++)
		{
			String itemName = anInventory.getItem(i).getName();
			if (input.toLowerCase().contains(itemName.toLowerCase()))
				item = anInventory.getItem(itemName);
		}
		return item;
	}
	
	/**
	 * Searches a given activator list for an activator whose name is contained in the input text.
	 * @param aList the activator list to search in
	 * @return the activator or null of nothing is found
	 */
	private Activator searchForActivator(ActivatorList aList)
	{
		Activator activator = null;
		for (int i = 0; i < aList.getLength(); i++)
		{
			String activatorName = aList.getActivator(i).getName();
			if (input.toLowerCase().contains(activatorName.toLowerCase()))
				activator = aList.getActivator(activatorName);
		}
		return activator;
	}
	
	/**
	 * Interprets user input, following the command if there is one and returning a confirmation message to describe what happened.
	 * @return the output
	 */
	public String interpret()
	{
		String out = "";
		
		// Pick up / Drop
		if (input.toLowerCase().contains("take ") || input.toLowerCase().contains("pick up "))
		{
			Item item = this.searchForItem(player.getLocation().getInventory());
			out = player.getInventory().pickUp(item);
		}	
		else if (input.toLowerCase().contains("drop "))
		{
			Item item = this.searchForItem(player.getInventory());
			out = player.getInventory().drop(item);
		}
		
		// Use Item
		else if (input.toLowerCase().contains("use ") || input.toLowerCase().contains("give "))
		{
			Item item = this.searchForItem(player.getInventory());
			Activator activator = this.searchForActivator(player.getLocation().getActivators());
			
			// Use Key
			if (item instanceof Key)
			{
				if (input.toLowerCase().contains(" on ") || input.toLowerCase().contains(" to "))
					out = player.getInventory().use(item, activator, player);
				else
					out = "What do you want to use that on?\n";
			}
			// Use Teleporter or Potion
			else
				out = player.getInventory().use(item, activator, player);
		}
		
		// Move
		else if (input.toLowerCase().contains("move "))
		{
			if (input.toLowerCase().contains(" north") && !input.toLowerCase().contains("east") && !input.toLowerCase().contains("west"))
				out = player.move("N");
			else if (input.toLowerCase().contains(" east"))
				out = player.move("E");
			else if (input.toLowerCase().contains(" south") && !input.toLowerCase().contains("east") && !input.toLowerCase().contains("west"))
				out = player.move("S");
			else if (input.toLowerCase().contains(" west"))
				out = player.move("W");
			else if (input.toLowerCase().contains(" up"))
				out = player.move("U");
			else if (input.toLowerCase().contains(" down"))
				out = player.move("D");
			else
				out = player.move(null);
		}
		// Move - Short Commands
		else if (input.toLowerCase().equals("n"))
			out = player.move("N");
		else if (input.toLowerCase().equals("e"))
			out = player.move("E");
		else if (input.toLowerCase().equals("s"))
			out = player.move("S");
		else if (input.toLowerCase().equals("w"))
			out = player.move("W");
		else if (input.toLowerCase().equals("u"))
			out = player.move("U");
		else if (input.toLowerCase().equals("d"))
			out = player.move("D");
		
		// Display location
		else if (input.toLowerCase().equals("look") || input.toLowerCase().equals("l") || input.toLowerCase().equals("where the crap am i?"))
		{
			out = player.getLocation().getDescription();
		}
		
		// Display inventory
		else if (input.toLowerCase().equals("inventory") || input.toLowerCase().equals("i") || input.toLowerCase().equals("what's in my pockets?"))
		{
			out = player.getInventory().getDescription();
		}
		
		// Help
		else if (input.toLowerCase().equals("help"))
			out = "This is the kind of game that MEN played back in the days before there were fineries like \"graphics\" or \"buttons\" and as such it is somewhat unforgiving. Here are the basics (single quotes denote commands you could type in. Don't type the quotes, obviously):\n\nMOVEMENT:\n'moves north' or 'n' - move north\n'move up' or 'u' - moves up...\nYou get the idea.\n\nITEMS\n'take potion' - takes potion (or any other item)\n'drop potion' - drops potion\n'use potion' - uses potion\n'use key on door' - open door\n'give food to hungry man' - uses food on hungry man\n\nA note on item and object names: I have very specific ideas about what things are called. The name of the item or object you're trying to interact with is usually obvious from the description: for example, to pick up an item described as \"A bottle of absinthe\" type 'take absinthe'. However, since every item needs to have a different name so that I know what you mean when you give me the name, try to be as specific as possible. For instance, in the previous example the command 'take bottle' would not work since there are probably other bottles you'll want to pick up later. If you're having trouble finding the name, just type in the whole description i.e. 'take a bottle of absinthe'.\n\nOTHER USEFUL COMMANDS:\n'look' or 'l' - display location descripiton\n'inventory' or 'i' - display inventory\n";
		
		// Unrecognized command
		else
			out = "I don't understand that. I'm sorry!\n";
		
		// And finally...
		return out;
	}
}
