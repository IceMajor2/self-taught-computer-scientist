package cs.intro;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinearSearchTest {

	@ParameterizedTest
	@ValueSource(ints = { 0, 10, 3, 19 })
	void findStringTest(int index) {
		String[] strings = FileUtils.getNames(20);
		Collections.shuffle(Arrays.asList(strings));
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
	@ValueSource(ints = { -10000000, 0, -93782, -320000, 9999999 })
	void findIntegersInBigDataSetTest(int number) {
		Integer[] numbers = TestUtils.getNumbersFromTo(-10000000, 10000000);
		Integer toFind = number;
		Integer found = LinearSearch.get(numbers, toFind);
		assertNotNull(found);
		assertEquals(toFind, found);
	}
}