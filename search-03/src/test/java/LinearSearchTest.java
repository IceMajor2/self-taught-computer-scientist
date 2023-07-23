import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinearSearchTest {

	@Test
	void findStringTest() {
		String[] strings = new String[] { "Adrian", "Jakub", "Alicja", "Justyna", "Leonardo",
				"Grzegorz", "Natalia", "Jerzy", "Jacek" };
		String found = LinearSearch.get(strings, "Jacek");
		assertNotNull(found);
		assertEquals("Jacek", found);
	}

	@Test
	void findIntegerTest() {
		Integer[] numbers = new Integer[] {-1, -5, 2, 123, -9, 0, 8943, 321, 832, 59423, 12, 13};
		Integer found = LinearSearch.get(numbers, -5);
		assertNotNull(found);
		assertEquals(-5, found);
	}

	@Test
	void findIntegerNotInArrayTest() {
		Integer[] numbers = new Integer[] {-1, -5, 2, 123, -9, 0, 8943, 321, 832, 59423, 12, 13};
		Integer found = LinearSearch.get(numbers, -3);
		assertNull(found);
	}

	@Test
	void findIntegersInBigDataSetTest() {
		Integer[] ints = TestUtils.getUniqueRandomArray(100000);
		for(int i = 0; i < ints.length; i += 1) {
			Integer find = ints[ints.length - 1];
			Integer found = LinearSearch.get(ints, find);
			assertNotNull(found);
			assertEquals(find, found);
		}
	}

	/**
	 * TODO: Write a method that will create a chart
	 * for user to determine the time complexity.
	 * Or compare the amount of steps!
	 */
}