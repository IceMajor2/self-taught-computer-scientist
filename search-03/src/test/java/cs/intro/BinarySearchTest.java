package cs.intro;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinarySearchTest {

	@ParameterizedTest
	@ValueSource(ints = { -15, -9, 11, 14 })
	void findNumberSmallArrayAscendingTest(int toFind) {
		Integer[] numbers = TestUtils.getNumbersFromTo(-15, 15);
		Integer result = BinarySearch.get(numbers, toFind, Comparator.comparing(Integer::intValue));
		assertNotNull(result);
		assertEquals(toFind, numbers[result]);
	}

	@ParameterizedTest
	@ValueSource(ints = { -10, 9, 2, -5 })
	void findNumberSmallArrayDescendingTest(int toFind) {
		Integer[] numbers = TestUtils.getNumbersFromTo(-10, 10);
		Integer result = BinarySearch.get(numbers, toFind, Comparator.comparing(Integer::intValue));
		assertNotNull(result);
		assertEquals(toFind, numbers[result]);
	}

	@ParameterizedTest
	@ValueSource(ints = { -10000000, 9999999, 0, -584239, 28190, 127839 })
	void findNumberBigArrayAscendingTest(int toFind) {
		Integer[] numbers = TestUtils.getNumbersFromTo(-10000000, 10000000);
		Integer result = BinarySearch.get(numbers, toFind, Comparator.comparing(Integer::intValue));
		assertNotNull(result);
		assertEquals(toFind, numbers[result]);
	}

	@ParameterizedTest
	@ValueSource(ints = { -10000000, 9999999, 0, -74329, 95230, 7652347 })
	void findNumberBigArrayDescendingTest(int toFind) {
		Integer[] numbers = TestUtils.getNumbersFromTo(-10000000, 10000000);
		Collections.reverse(Arrays.asList(numbers));
		Integer result = BinarySearch.get(numbers, toFind, Comparator.comparing(Integer::intValue));
		assertNotNull(result);
		assertEquals(toFind, numbers[result]);
	}

	@ParameterizedTest
	@ValueSource(ints = { 3, 12 })
	void findNumberArrayNotDescendingTest(int toFind) {
		Integer[] numbers = new Integer[] { 1, 2, 3, 3, 9, 10, 11, 12, 12 };
		int result = BinarySearch.get(numbers, toFind, Comparator.comparing(Integer::intValue));
		assertNotNull(result);
		assertEquals(toFind, numbers[result]);
	}

	@ParameterizedTest
	@ValueSource(ints = { 10, 0, -1 })
	void findNumberArrayNotAscendingTest(int toFind) {
		Integer[] numbers = new Integer[] { 15, 10, 10, 7, 0, 0, -1, -1, -1, -15 };
		int result = BinarySearch.get(numbers, toFind, Comparator.comparing(Integer::intValue));
		assertNotNull(result);
		assertEquals(toFind, numbers[result]);
	}

	@Test
	void findNumberArraySameObjectsTest() {
		Integer[] numbers = new Integer[] { 9, 9, 9, 9 };
		int result = BinarySearch.get(numbers, 9, Comparator.comparing(Integer::intValue));
		assertNotNull(result);
		assertEquals(9, numbers[result]);
	}

	@Test
	void findNumberNotInArrayTest() {
		Integer[] numbers = new Integer[] { 0, 0, 0, 1, 9, 19 };

		Integer result = BinarySearch.get(numbers, 25, Comparator.comparing(Integer::intValue));
		assertNull(result);
		result = BinarySearch.get(numbers, 15, Comparator.comparing(Integer::intValue));
		assertNull(result);
		result = BinarySearch.get(numbers, -1, Comparator.comparing(Integer::intValue));
		assertNull(result);
	}

	@ParameterizedTest
	@ValueSource(strings = { "Faye", "Eddie", "Joey", "Alicia" })
	void findStringTest(String toFind) {
		String[] strings = FileUtils.getNames();
		Integer result = BinarySearch.get(strings, toFind, Comparator.comparing(String::toString));
		assertNotNull(result);
		assertEquals(toFind, strings[result]);
	}

	@Test
	void findStringNotInArrayTest() {
		String[] strings = new String[] { "AAa", "BbB", "CcC" };
		String find = "dDD";
		Integer result = BinarySearch.get(strings, find, Comparator.comparing(String::toString));
		assertNull(result);
	}

	@Test
	void findCharsTest() {
		Character[] asciiChars = new Character[] { 32, 57, 58, 65, 91, 123, 127 };
		for (int i = 0; i < asciiChars.length; i++) {
			char find = asciiChars[i];
			Integer result = BinarySearch.get(asciiChars, find, Comparator.comparing(Character::charValue));
			assertNotNull(result);
			assertEquals(i, result);
		}
	}
}