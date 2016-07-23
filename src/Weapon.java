public class Weapon {
	
	/** A description of this weapon. */
	private String description;

	/** This weapon's name. */
	private String name;

	/** The maximum damage this weapon can inflict */
	private int damageMin;
	
	/** The maximum damage this weapon can inflict */
	private int damageMax;
	
	/**
	 * @param name
	 *            This weapons's name.
	 * @param damageMin
	 *            The minimum damage this weapon can inflict.
	 * @param damageMax
	 *            The maximum damage a weapon can inflict.
	 * @param description
	 *            A description of this weapon.
	 */
	public Weapon(String name, int damageMin, int damageMax, String description) {
		this.name = name;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.description = description;
	}

	/** Returns a description of this weapon. */
	public String getDescription() {
		return description;
	}

	/** Returns this weapon's name. */
	public String getName() {
		return name;
	}

	/** Returns the minimum damage value of this weapon. */
	public int getDamageMin() {
		return damageMin;
	}
	
	/** Returns the maximum damage value of this weapon. */
	public int getDamageMax() {
		return damageMax;
	}
}
