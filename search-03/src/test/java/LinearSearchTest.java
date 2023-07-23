import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

	@Test
	void getString() {
		String[] strings = new String[] { "Adrian", "Jakub", "Alicja", "Justyna", "Leonardo",
				"Grzegorz", "Natalia", "Jerzy", "Jacek" };
		String found = LinearSearch.get(strings, "Jacek");
		assertNotNull(found);
		assertEquals("Jacek", found);
	}

	@Test
	void getInteger() {
		Integer[] numbers = new Integer[] {-1, -5, 2, 123, -9, 0, 8943, 321, 832, 59423, 12, 13};
		Integer found = LinearSearch.get(numbers, -5);
		assertNotNull(found);
		assertEquals(-5, found);
	}

	@Test
	void getInteger_whenNotInArrayTest() {
		Integer[] numbers = new Integer[] {-1, -5, 2, 123, -9, 0, 8943, 321, 832, 59423, 12, 13};
		Integer found = LinearSearch.get(numbers, -3);
		assertNull(found);
	}

	@Test
	void getFloatFromBigDataSetTest() {
		Float[] floats = getBigFloatArray(10000000);
		Float find = floats[floats.length - 1];
		Float found = LinearSearch.get(floats, find);
		assertNotNull(found);
		assertEquals(find, found);
	}

	private Float[] getBigFloatArray(int size) {
		Random random = new Random();
		Set<Float> set = new HashSet<>();
		Float[] floats = new Float[size];

		int i = 0;
		while(set.size() < size) {
			float number = random.nextFloat(1000) - 500;
			if(set.add(number)) {
				floats[i] = number;
				i++;
			}
		}
		return floats;
	}

	/**
	 * TODO: Write a method that will create a chart
	 * for user to determine the time complexity.
	 */
}