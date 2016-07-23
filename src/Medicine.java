/** A treasure. */
public class Medicine {

	/** A description of this treasure. */
	private String description;

	/** This treasure's name. */
	private String name;

	/** The value of this treasure. */
	private int value;

	/**
	 * @param name
	 *            This medicine's name.
	 * @param value
	 *            How much health this item heals.
	 * @param description
	 *            A description of the medicine.
	 */
	public Medicine(String name, int value, String description) {
		this.name = name;
		this.value = value;
		this.description = description;
	}

	/** Returns a description of this medicine. */
	public String getDescription() {
		return description;
	}

	/** Returns this medicine's name. */
	public String getName() {
		return name;
	}

	/** Returns the value of this medicine. */
	public int getValue() {
		return value;
	}

}