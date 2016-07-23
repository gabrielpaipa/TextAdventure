
public class Monster {

	/** A description of this monster. */
	private String description;

	/** This monster's name. */
	private String name;

	/** The armor of the monster. */
	private int armor;
	
	/** The minimum attack of the monster */
	private int attackMin;

	/** The maximum attack of the monster */
	private int attackMax;
	
	/**
	 * @param name
	 *            This monsters's name.
	 * @param armor
	 *            The health of the monster.
	 * @param description
	 *            A description of this treasure.
	 * @param attackMin
	 * 			  The least a monster can attack.
	 * @param attackMax
	 *      	  The most a monster can attack.
	 */
	public Monster(String name, int armor, int attackMin, int attackMax, String description) {
		this.name = name;
		this.armor = armor;
		this.attackMin = attackMin;
		this.attackMax = attackMax;
		this.description = description;
	}

	/** Returns a description of this monster. */
	public String getDescription() {
		return description;
	}

	/** Returns this monster's name. */
	public String getName() {
		return name;
	}

	/** Returns the value of this monster's armor. */
	public int getArmor() {
		return armor;
	}
	
	/** Returns the minimum value of this monster's attack. */
	public int getAttackMin() {
		return attackMin;
	}
	
	/** Returns the maximum value of this monster's attack */
	public int getAttackMax() {
		return attackMax;
	}
	
	/** Sets the monsters armor */
	public void setArmor(int newHealth){
		this.armor = newHealth;
	}
}
