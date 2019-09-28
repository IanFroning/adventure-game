package coloradocollege.ifroning;

/**
 * Tests the project using the GUI.
 * @author Ian Froning
 * @version 1.0
 */
public class TesterGUI
{

	/**
	 * Creates a test game world and runs it.
	 * @param args not used
	 */
	public static void main(String[] args)
	{			
		//LOCATIONS
		
		// Location 1
		ActivatorList loc1List = new ActivatorList();
		LocationInventory loc1Inv = new LocationInventory();
		Location loc1 = new Location("You are in a very boring room.", loc1List, loc1Inv);
			
		// Location 2
		ActivatorList loc2List = new ActivatorList();
		LocationInventory loc2Inv = new LocationInventory();
		Location loc2 = new Location("You are in a slightly less boring room.", loc2List, loc2Inv);
			
		
		// Location 3
		ActivatorList loc3List = new ActivatorList();
		LocationInventory loc3Inv = new LocationInventory();
		Location loc3 = new Location("You are in an exciting room. Ooo look, a unicorn!", loc3List, loc3Inv);
		
		// Connect locations
		loc2.addNeighbor("N", loc3);
		loc3.addNeighbor("S", loc2);
		
		
		//ITEMS
				
		// Location 1
		Teleporter eatme = new Teleporter("potion", "a potion labeled \"Eat Me!\"", loc2);
			loc1Inv.addItem(eatme);
		// Location 2
		Key bigStick = new Key("stick", "big stick diplomacy");
			loc2Inv.addItem(bigStick);
		
			
		//ACTIVATORS
		
		// Location 2
		Activator panamaCanal = new Activator("Panama Canal", "There is a Panama Canal here, which is closed.", "There is a Panama Canal here, which is open.", "The Panama Canal is now open.", bigStick);
			loc2List.addActivator(panamaCanal);
			loc2.addRequiredActivators("N", loc2List, "You cannot go that way until the canal has been opened.");
			
			
		//PLAYER
		Player player = new Player("The Player", loc1);
		
			
		//FRAME
		GameFrame frame = new GameFrame("Zipa do dah", player);
	}

}
