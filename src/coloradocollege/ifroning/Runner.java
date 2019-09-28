package coloradocollege.ifroning;

/**
 * Runs the game.
 * @author Ian Froning
 * @version 1.0
 */
public class Runner
{
	/**
	 * Creates the game world and runs it.
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		
		//LOCATIONS
		
		/* Empty location to cut and paste
		ActivatorList List = new ActivatorList();
		LocationInventory Inv = new LocationInventory();
		Location  = new Location("", List, Inv);
		*/
		
		// Seaside
		ActivatorList seasideList = new ActivatorList();
		LocationInventory seasideInv = new LocationInventory();
		Location seaside = new Location("It is a quiet, lonely day. You are standing at the seaside, dreaming of a lost love. To the east is a run down old snack bar. To the west, a boundless ocean.", seasideList, seasideInv);
		
		// Snack bar
		ActivatorList snackbarList = new ActivatorList();
		LocationInventory snackbarInv = new LocationInventory();
		Location snackbar = new Location("You are at a run down old snack bar, which is open to the ocean to the west.", snackbarList, snackbarInv);
		
		// Seabed
		ActivatorList seabedList = new ActivatorList();
		LocationInventory seabedInv = new LocationInventory();
		Location seabed = new Location("You are standing on the seabed west of the beach. There is a trapdoor here which appears to be unlocked.", seabedList, seabedInv);
		
		// Beyond the sea
		ActivatorList beyondTheSeaList = new ActivatorList();
		LocationInventory beyondTheSeaInv = new LocationInventory();
		Location beyondTheSea = new Location("You are in a pleasent grove on a path that runs to the north and south. To the south you can make out a cozy little cottage. To the north you note the sight of rising smoke and the stench of pure evil.", beyondTheSeaList, beyondTheSeaInv);
		
		// Cottage outside
		ActivatorList cottageOutsideList = new ActivatorList();
		LocationInventory cottageOutsideInv = new LocationInventory();
		Location cottageOutside = new Location("You are standing just north of a nice little cottage.", cottageOutsideList, cottageOutsideInv);
		
		// Cottage outside, stooped down
		ActivatorList cottageStoopedList = new ActivatorList();
		LocationInventory cottageStoopedInv = new LocationInventory();
		Location cottageStooped = new Location("Stooping down, you see a mouse in full regalia", cottageStoopedList, cottageStoopedInv);
		
		// East of cottage outside, stooped down
		ActivatorList cottageStoopedEastList = new ActivatorList();
		LocationInventory cottageStoopedEastInv = new LocationInventory();
		Location cottageStoopedEast = new Location("A small patch of grass.", cottageStoopedEastList, cottageStoopedEastInv);
		
		// Lookout
		ActivatorList lookoutList = new ActivatorList();
		LocationInventory lookoutInv = new LocationInventory();
		Location lookout = new Location("The ravine opens up to a breathtaking view of the whole area. It appears you are on the western slope of a lush valley that runs from south to north with the cottage you found at the upper end of it, just east of you. You can see a plume of smoke in the center of the valley, just north of here. The path continues to the south, towards what appears to be a shrine.", lookoutList, lookoutInv);
		
		// Courage shrine
		ActivatorList courageShrineList = new ActivatorList();
		LocationInventory courageShrineInv = new LocationInventory();
		Location courageShrine = new Location("You are at a small shrine, hidden away in the valley's western slope. The path you took leads north of here.", courageShrineList, courageShrineInv);
		
		// Cottage inside
		ActivatorList cottageInsideList = new ActivatorList();
		LocationInventory cottageInsideInv = new LocationInventory();
		Location cottageInside = new Location("You are standing inside a small cottage furnished in rustic decor, yet displaying a refined sense of taste. At first it all appears to be a single room, but then you notice a tiny doorway on the eastern wall. It's way to small for you to fit through, although you can see a faint, pulsating glow emanating from within. The front door is to the north.", cottageInsideList, cottageInsideInv);
		
		// Cottage inside shrunk
		ActivatorList cottageInsideShrunkList = new ActivatorList();
		LocationInventory cottageInsideShrunkInv = new LocationInventory();
		Location cottageInsideShrunk = new Location("You are standing inside a gigantic cottage furnished in rustic decor, yet displaying a refined sense of taste. In the distance, you can make out a doorway on the eastern wall. A strange light pulsates from within.", cottageInsideShrunkList, cottageInsideShrunkInv);
		
		// Cottage strange room
		ActivatorList cottageStrangeRoomList = new ActivatorList();
		LocationInventory cottageStrangeRoomInv = new LocationInventory();
		Location cottageStrangeRoom = new Location("You are in a very strange room. Lots of crazy stuff going on. Woah! Holy crap what was that.", cottageStrangeRoomList, cottageStrangeRoomInv);
		
		// Cottage inside shrunk 2
		ActivatorList cottageInsideShrunk2List = new ActivatorList();
		LocationInventory cottageInsideShrunk2Inv = new LocationInventory();
		Location cottageInsideShrunk2 = new Location("You are standing inside a gigantic cottage furnished in rustic decor, yet displaying a refined sense of taste. In the distance, you can make out a doorway on the eastern wall. A strange light pulsates from within.", cottageInsideShrunk2List, cottageInsideShrunk2Inv);
		
		// Chapter 2: The Next Stage
		Location chap2Start = new Location("You step boldly into the adventure that lies ahead.\n\nWILL YOU SURVIVE?\n\nI don't know cause I haven't written that part yet.", true);
		
		// Connect locations
		seaside.addNeighbor("E", snackbar);
		snackbar.addNeighbor("W", seaside);
		seaside.addNeighbor("W", seabed);
		seabed.addNeighbor("E", seaside);
		seabed.addNeighbor("D", beyondTheSea);
		beyondTheSea.addNeighbor("N", chap2Start);
		beyondTheSea.addNeighbor("S", cottageOutside);
		cottageOutside.addNeighbor("N", beyondTheSea);
		cottageOutside.addNeighbor("S", cottageInside);
		cottageOutside.addNeighbor("D", cottageStooped);
		cottageOutside.addNeighbor("W", lookout);
		cottageStooped.addNeighbor("U", cottageOutside);
		cottageStooped.addNeighbor("E", cottageStoopedEast);
		cottageStoopedEast.addNeighbor("W", cottageStooped);
		cottageStoopedEast.addNeighbor("U", cottageOutside);
		cottageInside.addNeighbor("N", cottageOutside);
		cottageInsideShrunk.addNeighbor("E", cottageStrangeRoom);
		cottageStrangeRoom.addNeighbor("W", cottageInsideShrunk2);
		lookout.addNeighbor("E", cottageOutside);
		lookout.addNeighbor("S", courageShrine);
		courageShrine.addNeighbor("N", lookout);
		
		
		//ITEMS
		
		// Snack bar
		Key cheesePuffs = new Key("puffs", "A bag of cheese puffs");
			snackbarInv.addItem(cheesePuffs);
		Key birthdayCake = new Key("birthday cake", "An exquisitely decorated birthday cake");
			snackbarInv.addItem(birthdayCake);
		// East of cottage outside, stooped down
		Key cottageKey = new Key("brass key", "A brass key");
			cottageStoopedEastInv.addItem(cottageKey);
		// Cottage inside
		Teleporter eatme = new Teleporter("bundt", "A bundt cake labeled \"Eat Me!\"", cottageInsideShrunk);
			cottageInsideInv.addItem(eatme);
		// Cottage strange room
		Key positiveAttitude = new Key("unguent", "The Unguent of Positive Attitude");
			cottageStrangeRoomInv.addItem(positiveAttitude);
		// Cottage inside shrunk 2
		Teleporter drinkme = new Teleporter("pellegrino", "A bottle of pellegrino labeled \"Drink Me!\"", cottageInside);
			cottageInsideShrunk2Inv.addItem(drinkme);
		
		
		//ACTIVATORS
		
		// Seaside
		Activator wizard = new Activator("Wizard", "There is a wizard here. It is his birthday today.", "There is a wizard here. You no longer have anything that he wants.", "You give the wizard his birthday cake. He begins to speak:\n\n\"This is a fine birthday cake. Very fine indeed. You're quite the can-do kind of fellow aren't you? A real go-getter, hmm? Well you're in luck, my friend, because I've just the thing for you. See this ocean? Poof it's gone. Look at that. Taken by surprise, hmm? No, you're not surprised at all, are you? I thought you had real gusto but you a sad-sack kind of fellow. Totally unphased. Rollin' with the punches as they hitcha. Well guess what? Get offa that horse, caballero. No good gonna come of that. You need adventure. Change of pace. See that trapdoor over there on the seabed where the ocean was? Go through it to get to the super cool land on the other side. Try it. Why not? Can't hurt. Cya.\"", birthdayCake);
			seasideList.addActivator(wizard);
			seaside.addRequiredActivators("W", seasideList, "That's the ocean. You cannont go into the ocean.");
		// Cottage outside
		Activator cottageDoor = new Activator("Door", "The door is locked. To the west you can just make out a faint path leading up a narrow ravine.", "To the west you can just make out a faint path leading up a narrow ravine.", "You unlock the door.", cottageKey);
			cottageOutsideList.addActivator(cottageDoor);
			cottageOutside.addRequiredActivators("S", cottageOutsideList, "The door is locked tight. You hear a small squeeking noise below you.");
		// Cottage outside stooped
		Activator mouse = new Activator("Mouse", ".", "munching on cheese puffs.", "You offer the mouse the cheese puffs and he seems pleased. He cordially accepts your offer and points out a brass key on the ground just east of you.", cheesePuffs);
			cottageStoopedList.addActivator(mouse);
			cottageStooped.addRequiredActivators("E", cottageStoopedList, "There's nothing interesting over there.");
		// Courage shrine
		Activator courageAltar = new Activator("Altar", "Before you you see the Altar of Renewed Sense of Self-Worth.", "Before you you see the Altar of Renewed Sense of Self-Worth. You are feeling pretty good about yourself and don't really need it anymore.", "You smear the Unguent of Positive Attitude around on the altar. All of a sudden, there is a loud *CRACK* and the ghost of Batman appears, flashing you the \"thumbs up\" before fading back into the twisting nether.\n\nNeedless to say, you feel pretty good about yourself.", positiveAttitude);
			courageShrineList.addActivator(courageAltar);
			ActivatorList beyondTheSeaReqList = new ActivatorList();
				beyondTheSeaReqList.addActivator(courageAltar);
				beyondTheSea.addRequiredActivators("N", beyondTheSeaReqList, "You don't have the guts.");
		
		
		//PLAYER
		Player player = new Player("Intrepid explorer number one", seaside);

			
		//FRAME
		GameFrame frame = new GameFrame("(Type 'help' for help.)", player);
	}
}
