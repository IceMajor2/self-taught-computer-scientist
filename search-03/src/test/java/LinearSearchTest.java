import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinearSearchTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 10, 3, 19})
	void findStringTest(int index) {
		String[] strings = TestUtils.getNames(20);
		String toFind = strings[index];
		String found = LinearSearch.get(strings, toFind);
		assertNotNull(found);
		assertEquals(toFind, found);
	}

	@ParameterizedTest
	@ValueSource(ints = {60, 2, 73, 22, 0, 74})
	void findIntegerTest(int index) {
		Integer[] numbers = TestUtils.getNumbersFromTo(-5, 70);
		Collections.shuffle(Arrays.asList(numbers));
		Integer toFind = numbers[index];
		Integer found = LinearSearch.get(numbers, toFind);
		assertNotNull(found);
		assertEquals(toFind, found);
	}

	@Test
	void findIntegerNotInArrayTest() {
		Integer[] numbers = new Integer[] { -1, -5, 2, 123, -9, 0, 8943, 321, 832, 59423, 12, 13 };
		Integer found = LinearSearch.get(numbers, -3);
		assertNull(found);
	}

	@Test
	void findIntegersInBigDataSetTest() {
//		Integer[] ints = TestUtils.getUniqueRandomArray(100000);
//		for (int i = 0; i < ints.length; i += 1) {
//			Integer find = ints[ints.length - 1];
//			Integer found = LinearSearch.get(ints, find);
//			assertNotNull(found);
//			assertEquals(find, found);
//		}
	}

	/**
	 * TODO: Write a method that will create a chart
	 * for user to determine the time complexity.
	 * Or compare the amount of steps!
	 */
}