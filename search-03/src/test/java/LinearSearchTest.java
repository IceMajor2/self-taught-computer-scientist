import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinearSearchTest {

	@ParameterizedTest
	@ValueSource(ints = { 0, 10, 3, 19 })
	void findStringTest(int index) {
		String[] strings = TestUtils.getNames(20);
		String toFind = strings[index];
		String found = LinearSearch.get(strings, toFind);
		assertNotNull(found);
		assertEquals(toFind, found);
	}

	@ParameterizedTest
	@ValueSource(ints = { 60, 2, 73, 22, 0, 74 })
	void findIntegerTest(int index) {
		Integer[] numbers = TestUtils.getNumbersFromTo(-5, 70);
		Collections.shuffle(Arrays.asList(numbers));
		Integer toFind = numbers[index];
		Integer found = LinearSearch.get(numbers, toFind);
		assertNotNull(found);
		assertEquals(toFind, found);
	}

	@ParameterizedTest
	@ValueSource(ints = { 9, -5, -2 })
	void findIntegerNotInArrayTest(int toFind) {
		Integer[] numbers = TestUtils.getNumbersFromTo(-1, 8);
		Integer found = LinearSearch.get(numbers, toFind);
		assertNull(found);
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 5821, 92100, 10, 299999, 111111 })
	void findIntegersInBigDataSetTest(int index) {
		Integer[] numbers = TestUtils.getNumbersFromTo(-250000, 50000);
		Collections.shuffle(Arrays.asList(numbers));
		Integer toFind = numbers[index];
		Integer found = LinearSearch.get(numbers, toFind);
		assertNotNull(found);
		assertEquals(toFind, found);
	}

	/**
	 * TODO: Write a method that will create a chart
	 * for user to determine the time complexity.
	 * Or compare the amount of steps!
	 */
}