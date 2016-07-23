import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MedicineTest {

	private Medicine bandage;

	@Before
	public void setUp() throws Exception {
		bandage = new Medicine("bandage", 10, "a medical wrap soaked in alcohol");
	}

	@Test
	public void testGetName() {
		assertEquals("bandage", bandage.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("a medical wrap soaked in alcohol", bandage.getDescription());
	}

	@Test
	public void testGetValue() {
		assertEquals(10, bandage.getValue());
	}

}