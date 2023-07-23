import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

	@Test
	void getString() {
		String[] strings = new String[] { "Adrian", "Jakub", "Alicja", "Justyna", "Leonardo",
				"Grzegorz", "Natalia", "Jerzy", "Jacek" };
		String found = LinearSearch.get(strings, "Jacek");
		assertNotNull(found);
		assertEquals(found, "Jacek");
	}
}