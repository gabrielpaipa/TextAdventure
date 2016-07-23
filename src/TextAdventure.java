/** Text adventure game. */

/*
 * Note: I know the way I did the descriptions for the monster doesn't work if I
 * wanted to use different monsters for different rooms. If I was doing a larger
 * map, I would of stuck to how it was originally set up and reused the
 * monsters. Considering the size of the game I decided it would be more
 * worthwhile and a richer experience to individually tailor each monster.
 */

/*
 * To do:
 * -Finish map & descriptions
 * -Create retreat system
 * -Create armor system
 */
public class TextAdventure {

	public static void main(String[] args) {
		new TextAdventure().run();
	}

	/** Minimum damage dealt by current weapon */
	private int bestWeaponDamageMin;
	
	/** Maximum damage dealt by current weapon */
	private int bestWeaponDamageMax;

	/** The room where the player currently is. */
	private Room currentRoom;

	/** Total value of all treasures taken by the player. */
	private int score;

	/** The player's max health */
	private int playerMaxHealth;

	/** The player's current health */
	private int playerHealth;
	
	/** The direction to retreat to */
	private String retreatDirection;

	public TextAdventure() {
		// Create rooms
		Room DesertDesolate = new Room("field", "in a barren valley, with"
				+ " distant mountains off in the horizon. You can see your base far off to the south");
		Room DesertOutskirt = new Room("field still. Your radio is blaring urgently",
				"in the valley. Your " + "base is closer, but still a distance off");
		Room DesertBorder = new Room("excursion launch site", "at the massive fortified doors of your base");
		Room AirLock = new Room("airlock", "surrounded by control panels lining the walls to lock the doors. A"
						+ " row of shower heads is above you to decontaminate people after a specimen collection"
						+ " mission. No time for that now");
		Room Equipment = new Room("equipment room", "in a room filled with gear for specimen collection");
		Room Conference = new Room("excursion planning center",
				"standing at the front of a long room "
						+ "with a table in the middle. There are maps of the planet you're exploring, Terronda,"
						+ " scattered about the room");
		Room LightArmory = new Room("excursion defense armory", "surrounded by spacesuits for work outside"
				+ " the base");
		Room Communications = new Room("communications room",
				"in a small, cramped room. Emergency alerts are flashing on screens in every direction");
		Room Medical = new Room("medical facility", "in a medical facility suited to treat minor injuries");
		Room Lab = new Room("specimen analysis room", "in a room filled with empty cages. There is no apparent"
				+ " sign of the locks being broken. Someone must of let all of these aliens out intentionally");
		Room LivingQuarters = new Room("living quarters", "in the crew's bunk room. There are a series of bunkbeds"
				+ " and footlockers along the wall to either side");
		Room Kitchen = new Room("kitchen", "standing in a small cramped kitchen. The stench of the goulash you've"
				+ " been eating for the past week envelopes you as soon as you walk in");

		// Create connections
		DesertDesolate.addNeighbor("south", DesertOutskirt);

		DesertOutskirt.addNeighbor("north", DesertDesolate);
		DesertOutskirt.addNeighbor("south", DesertBorder);

		DesertBorder.addNeighbor("north", DesertOutskirt);
		DesertBorder.addNeighbor("south", AirLock);

		AirLock.addNeighbor("north", DesertBorder);
		AirLock.addNeighbor("south", Equipment);

		Equipment.addNeighbor("north", AirLock);
		Equipment.addNeighbor("east", Medical);
		Equipment.addNeighbor("south", Conference);
		Equipment.addNeighbor("west", LightArmory);

		Medical.addNeighbor("east", Lab);
		Medical.addNeighbor("west", Equipment);

		LightArmory.addNeighbor("east", Equipment);
		LightArmory.addNeighbor("south", Communications);

		Lab.addNeighbor("west", Medical);

		Communications.addNeighbor("north", LightArmory);
		Communications.addNeighbor("east", Conference);

		Conference.addNeighbor("north", Equipment);
		Conference.addNeighbor("east", Kitchen);
		Conference.addNeighbor("west", Communications);

		Kitchen.addNeighbor("east", LivingQuarters);
		Kitchen.addNeighbor("west", Conference);

		LivingQuarters.addNeighbor("west", Kitchen);

		// Create and install monsters
		Monster SandWorm = new Monster("sand-worm", 8, 1, 3,
				"There is a large sand-worm that " + "gnashes its pincers menacingly at you.");
		DesertOutskirt.setMonster(SandWorm);
		Monster Golzan = new Monster("golzan", 12, 2, 5, "There is a small, impish golzan in the middle"
				+ " of the room. It locks its gold reptillian eyes on you and bares its teeth, revealing dozens"
				+ " of razor sharp fangs."); AirLock.setMonster(Golzan);
		Monster Entirian = new Monster("entirian", 12, 3, 6, "A small, cute entirian is sitting in the Captain's"
				+ " chair, rocking back and forth. As adorable as its little ears and nose are, you"
				+ " remember your study on entirians and how they lure they prey in with their"
				+ " enamoring fluffiness."); Conference.setMonster(Entirian);
		Monster Neblunion = new Monster("neblunion", 15, 4, 8, "A short, blue neblunion is bent over the"
				+ " communications officer, enjoying him as a snack. It's back is turned to you, not"
				+ " seeming to notice you."); Communications.setMonster(Neblunion);
		Monster Bustaurus = new Monster("bustaurus", 12, 0, 2, "A bustaurus is thrashing about for no apparent"
				+ " reason in the middle of the room. Despite the slightly larger than average stature and"
				+ " unbearably loud battle cry of the bustaurus, it is actually quite weak."); Medical.setMonster(Bustaurus);
		Monster Gazorpazorp = new Monster("gazorpazorp", 14, 5, 9, "A dangerously aggressive gazorpazorp is"
				+ " ransacking the supply shelves."); Lab.setMonster(Gazorpazorp);
		Monster Birdperson = new Monster("birdperson", 25, 4, 11, "Birdperson is standing over a pot, boiling what"
				+ " looks like worm stew. Suddenly your radio crackles telling you to hurry up."
				+ " Bird person looks up from the stew and narrows his eyes."); Kitchen.setMonster(Birdperson);
		Monster GlipGlop = new Monster("glip-glop", 30, 5, 13, "A gelatinous glip-glop is sitting in your bunk. Though"
				+ " it seems to have no motive to attack you, it's getting its ooze all over your bed!"); LivingQuarters.setMonster(GlipGlop);

		// Create and install treasures
		DesertOutskirt.setTreasure(new Treasure("sample", 1, " "));
		AirLock.setTreasure(new Treasure("sample", 1, " "));
		Conference.setTreasure(new Treasure("sample", 1, " "));
		Communications.setTreasure(new Treasure("sample", 1, " "));
		Medical.setTreasure(new Treasure("sample", 1, " "));
		Lab.setTreasure(new Treasure("sample", 1, " "));
		Kitchen.setTreasure(new Treasure("sample", 1, " "));
		LivingQuarters.setTreasure(new Treasure("sample", 1, " "));


		// Create and install weapons
		Weapon rock = new Weapon("rock", 1, 5, "You are surround only by your specimen collection kit, "
				+ "provisions pail, and a few rocks"); DesertDesolate.setWeapon(rock);
		Weapon tool = new Weapon("tool", 3, 6, "There are a few boxes stacked up on the side of the wall."
				+ " A few spare tools are scattered around you."); DesertBorder.setWeapon(tool);
		Weapon stunRod = new Weapon("stun rod", 3, 8, "Racks of specimen collection stun rods are on either " 
				+ "side of the room"); LightArmory.setWeapon(stunRod);
		Weapon bottle = new Weapon("bottle", 4, 7, "A few reconnaissance instruments are laying on the "
				+ "table. Next to the coffee maker in the corner you notice Captain Carver's bottle");
		Conference.setWeapon(bottle);
		Weapon syringe = new Weapon("syringe", 5, 8, "There is a syringe sitting on the counter to your "
				+ "left. It appears to be filled with blood, though clearly not from a human.");
		Medical.setWeapon(syringe);
		Weapon gloc = new Weapon("gloc", 8, 16, "You remember Captain Carver always kept his Gamma Laser "
				+ "Obliteration Cannon, or gloc for short, under his pillow.");
		LivingQuarters.setWeapon(gloc);
		Weapon fryingPan = new Weapon("frying pan", 9, 11, "A few pots and pans hang above the stove. Though "
				+ "most look useless, there is a comically large frying pan that you haven't noticed before.");
		Kitchen.setWeapon(fryingPan);

		// Create and install medicine
		Medicine rag = new Medicine("decontamination rag", 12, "There is an emergency decontamination rag hanging"
				+ " on the hook to your left"); AirLock.setMedicine(rag);
		Medicine sandwich = new Medicine("sandwich", 5, "There is a moldy sandwich sitting on the file cabinet"
				+ " to your right. You remember leaving it there a week ago."); Conference.setMedicine(sandwich);
		Medicine coffee = new Medicine("coffee", 7, "The familiar smell of coffee still overpowers the smell of the "
				+ "corpse. Clearly he was just killed."); Communications.setMedicine(coffee);
		Medicine bandage = new Medicine("bandage", 20, "A cabinet has been knocked over by the bustaurus. There"
				+ " are several bandages falling out of it."); Medical.setMedicine(bandage);
		Medicine supplement = new Medicine("supplement", 15, "Your excursion partner, Mac, left his trunk has"
				+ " been left open. You see his supplements he takes to gain mass."); LivingQuarters.setMedicine(supplement);
		Medicine stew = new Medicine("stew", 10, "Despite birdperson's aggression, his stew does look"
				+ " delicious"); Kitchen.setMedicine(stew);
		
		// The player starts in the field, armed with nothing
		currentRoom = DesertDesolate;
		bestWeaponDamageMax = 1;
		bestWeaponDamageMin = 0;
		playerMaxHealth = 75;
		playerHealth = playerMaxHealth;
		retreatDirection = null;
	}

	/**
	 * Attacks the specified monster and prints the result. If the monster is
	 * present, this either kills it (if the player's weapon is good enough) or
	 * results in the player's death (and the end of the game).
	 */
	public void attack(String name) {
		Monster monster = currentRoom.getMonster();
		int monsterHealth = monster.getArmor();
		int playerAttack = StdRandom.uniform(bestWeaponDamageMin, bestWeaponDamageMax);
		int monsterAttack = StdRandom.uniform(monster.getAttackMin(), monster.getAttackMax());
		if (monster != null && monster.getName().equals(name)) {
			playerHealth = playerHealth - monsterAttack;
			monsterHealth = monsterHealth - playerAttack;
			monster.setArmor(monsterHealth);
			StdOut.println("You deal " + playerAttack + " damage. The " + monster.getName() + " dealt " + monsterAttack
					+ " damage");
			StdOut.println("You have " + playerHealth + " health remaining");
			if (monsterHealth <= 0) {
				StdOut.println();
				StdOut.println("You strike the " + monster.getName() + " dead!");
				StdOut.println("Be sure to pick up a sample.");
				currentRoom.setMonster(null);
				if (playerHealth <= 0) {
					StdOut.println("Though you killed the " + monster.getName()
							+ ", it managed to kill you in its final" + " breath. You are dead.");
					StdOut.println();
					StdOut.println("GAME OVER");
					System.exit(0);
				}
			}
			
			if (playerHealth <= 0 && monsterHealth > 0) {
				StdOut.println("The " + monster.getName() + " eats your head!");
				StdOut.println();
				StdOut.println("GAME OVER");
				System.exit(0);
			}

		} else {
			StdOut.println("There is no " + monster.getName() + " here.");
		}

	}

	/** Moves in the specified direction, if possible. */
	public void go(String direction) {
		Room destination = currentRoom.getNeighbor(direction);
		if (destination == null) {
			StdOut.println("You can't go that way from here.");
		} else {
			currentRoom = destination;
			retreatDirection = opposite(direction);
		}
	}
	
	/** Returns the opposite direction of the input */
	public String opposite(String inputDirection) {
		if(inputDirection.equals("north")) {
			return ("south");
		} else if (inputDirection.equals("east")) {
			return("west");
		} else if (inputDirection.equals("south")) {
			return("north");
		} else if(inputDirection.equals("west")) {
			return("east");
		} else {
			return null;
		}
	}
	
	/** Retreat! */
	public void retreat() {
		Room destination = currentRoom.getNeighbor(retreatDirection);
		currentRoom = destination;
	}

	/** Handles a command read from standard input. */
	public void handleCommand(String line) {
		String[] words;

		if (line.startsWith("attack")) {
		  int i = line.indexOf(" "); // Find the space
		  words = new String[] {line.substring(0, i), line.substring(i + 1)}; // The part before the space and the part after
		} else {
		  words = line.split(" ");
		}
		if (line.startsWith("take")) {
			  int i = line.indexOf(" "); // Find the space
			  words = new String[] {line.substring(0, i), line.substring(i + 1)}; // The part before the space and the part after
			} else {
			  words = line.split(" ");
			}
		if (currentRoom.getMonster() != null && !(words[0].equals("attack") || words[0].equals("look") || 
				words[0].equals("view") || words[0].equals("retreat"))) {
			StdOut.println("You can't do that with unfriendlies about.");
			listCommands();
		} else if (words[0].equals("attack")) {
			attack(words[1]);
		} else if (words[0].equals("go")) {
			go(words[1]);
		} else if (words[0].equals("look")) {
			look();
		} else if (words[0].equals("take")) {
			take(words[1]);
		} else if(words[0].equals("help")) {
			help();
		} else if(words[0].equals("view")) {
			if(words[1].equals("weapon") || words[1].equals("weapons")) {
				listWeapons();
			} else if(words[1].equals("monster") || words[1].equals("monsters")) {
				listMonsters();
			} else if(words[1].equals("medicine")) {
				listMedicine();
			}
		} else if(words[0].equals("retreat")) {
			retreat();
		} else {
			StdOut.println("I don't understand that.");
			listCommands();
		}
	}

	/** Prints examples of possible commands as a hint to the player. */
	public void listCommands() {
		StdOut.println("Examples of commands:");
		StdOut.println("  attack wolf");
		StdOut.println("  go north");
		StdOut.println("  look");
		StdOut.println("  take sample");
		StdOut.println("  help");
		StdOut.println("  retreat");
	}
	
	/** Prints the monsters names */
	public void listMonsters() {
		String monster = currentRoom.getMonster().getName();
		StdOut.println(monster);
	}
	
	/** Prints the weapons names */
	public void listWeapons() {
		StdOut.println(currentRoom.getWeapon().getName());
	}
	
	/** Prints the medicines names */
	public void listMedicine() {
		StdOut.println(currentRoom.getMedicine().getName());
	}

	/** Prints a description of the current room and its contents. */
	public void look() {
		StdOut.println("You are " + currentRoom.getDescription() + ".");
		if (currentRoom.getWeapon() != null) {
			StdOut.println(currentRoom.getWeapon().getDescription());
		}
		if (currentRoom.getMonster() != null) {
			StdOut.println(currentRoom.getMonster().getDescription());
		}
		if (currentRoom.getTreasure() != null) {
			StdOut.println(currentRoom.getTreasure().getDescription());
		}
		if (currentRoom.getMedicine() != null) {
			StdOut.println(currentRoom.getMedicine().getDescription());
		}
		StdOut.println();
		StdOut.println("Exits: " + currentRoom.listExits());
	}
	
	/** Prints suggestions to help the player. */
	public void help() {
		StdOut.println();
		StdOut.println("If you would like more information about where you are, type look");
		StdOut.println("If you are having trouble attacking or taking something, be sure it is singular");
		StdOut.println("and you aren't using superfluous adjectives.");
		StdOut.println("If you are still stuck, you can type view monster, weapon or medicine");
		StdOut.println();
		listCommands();
		
	}

	/** Runs the game. */
	public void run() {
		StdOut.println("While you are out in the field looking for alien species your radio goes off.");
		StdOut.println("It is your commander. He tells you that someone let all of the gathered aliens out");
		StdOut.println("of their cages. There is no chance of putting them back in the cages. You have been");
		StdOut.println("given orders to clear the base of hostiles and collect samples from them.");
		StdOut.println("Hurry, before the monsters get away from the base!");
		StdOut.println();
		listCommands();
		StdOut.println();
		while (true) {
			StdOut.println("You are in the " + currentRoom.getName() + ".");
			StdOut.print("> ");
			handleCommand(StdIn.readLine());
			StdOut.println();
		}
	}

	/** Attempts to pick up the specified treasure or weapon. */
	public void take(String name) {
		Treasure treasure = currentRoom.getTreasure();
		Weapon weapon = currentRoom.getWeapon();
		Medicine medicine = currentRoom.getMedicine();
		if (treasure != null && treasure.getName().equals(name)) {
			currentRoom.setTreasure(null);
			score += treasure.getValue();
			StdOut.println("You have collected samples from " + score + " out of 9 aliens.");
			if (score == 9) {
				StdOut.println();
				StdOut.println("YOU WIN!");
				System.exit(0);
			}
		} else if (weapon != null && weapon.getName().equals(name)) {
			currentRoom.setWeapon(null);
			if (weapon.getDamageMax() >= bestWeaponDamageMax) {
				bestWeaponDamageMax = weapon.getDamageMax();
				bestWeaponDamageMin = weapon.getDamageMin();
				StdOut.println("You'll be a more effective fighter with this!");
			} else if (weapon.getDamageMax() < bestWeaponDamageMax && weapon.getDamageMin() < bestWeaponDamageMin) {
				StdOut.println("Do you really think that is better than what you have now?");
			}
		} else if(medicine != null && medicine.getName().equals(name)) {
			if((playerHealth + medicine.getValue()) > playerMaxHealth) {
				int healthRestored = playerMaxHealth - playerHealth;
				StdOut.println();
				StdOut.println("You restored " + healthRestored + " health!");
				StdOut.println("You are at full health.");
				StdOut.println();
				playerHealth = playerMaxHealth;
			} else {
				playerHealth = playerHealth + medicine.getValue();
				StdOut.println();
				StdOut.println("You restored " + medicine.getValue() + " health!");
				StdOut.println("You have " + playerHealth + " health.");
				StdOut.println();
			}
		} else {
			StdOut.println("There is no " + name + " here.");
		}
	}

}
