import java.util.ArrayList;

public class Room {

	private ArrayList<Room> neighbors = new ArrayList<Room>();

	private ArrayList<String> directions = new ArrayList<String>();

	private Treasure treasures;

	private Monster monsters;
	
	private Weapon weapons;
	
	private Medicine medicine;

	/** A description of this room. */
	private String description;

	/** This room's name. */
	private String name;

	
	public Room(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/** Returns a description of this room. */
	public String getDescription() {
		return this.description;
	}

	/** Returns this room's name. */
	public String getName() {
		return this.name;
	}
	
	/** Lists the treasure in a room */
	public Treasure getTreasure() {
		return this.treasures;
	}
	
	/** Lists the monster in the room */
	public Monster getMonster() {
		return this.monsters;
	}
	
	/** Lists the weapon in the room */
	public Weapon getWeapon() {
		return this.weapons;
	}
	
	/** Lists the medicine in the room */
	public Medicine getMedicine() {
		return this.medicine;
	}

	/**
	 * Returns the directional neighbors for a room
	 * 
	 * @param side
	 * The direction to find the neighboring room (if south find southern neighbor)
	 */
	public Room getNeighbor(String side) {
		return this.neighbors.get(directions.indexOf(side));
	}

	/** Adds the neighboring room and the direction it is */
	public void addNeighbor(String direction, Room name) {
		directions.add(direction);
		neighbors.add(name);
	}
	
	/** Adds treasure to a room */
	public void setTreasure(Treasure diamond) {
		this.treasures = diamond;
	}
	
	/** Adds a monster to a room */
	public void setMonster(Monster wolf) {
		this.monsters = wolf;
	}
	
	/** Adds a weapon to a room */
	public void setWeapon(Weapon sword){
		this.weapons = sword;
	}
	
	/** Adds medicine to a room */
	public void setMedicine(Medicine bandage){
		this.medicine = bandage;
	}

	/** Lists the directions that there are exits */
	public String listExits() {
		String exits = directions.toString();
		return exits;
	}


	
}