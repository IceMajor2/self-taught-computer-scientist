import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

	@Test
	void findNumberSmallArrayTest() {
		Integer[] numbers = new Integer[] { 1, 5, 6, 10, 11, 19 };
		for (int i = 0; i < numbers.length; i++) {
			int find = numbers[i];
			Integer result = BinarySearch.get(numbers, find, Comparator.comparing(Integer::intValue));
			assertNotNull(result);
			assertEquals(i, result);
		}
	}

	@Test
	void findNumberBigArrayTest() {
		Integer[] numbers = TestUtils.getUniqueRandomArray(1000000);
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i += 1) {
			int find = numbers[i];
			Integer result = BinarySearch.get(numbers, find, Comparator.comparing(Integer::intValue));
			assertNotNull(result);
			assertEquals(i, result);
		}
	}

	// TODO: Not sorted -> throw error

	@Test
	void findNumberSmallArrayDescendingTest() {
		Integer[] numbers = new Integer[] { 2, 0, -1, -2, -3, -9, -27, -33 };
		for (int i = 0; i < numbers.length; i++) {
			int find = numbers[i];
			Integer result = BinarySearch.get(numbers, find, Comparator.comparing(Integer::intValue));
			assertNotNull(result);
			assertEquals(i, result);
		}
	}

	@Test
	void findNumberBigArrayDescendingTest() {
		Integer[] numbers = TestUtils.getUniqueRandomArray(1000000);
		Arrays.sort(numbers, Comparator.reverseOrder());
		for (int i = 0; i < numbers.length; i += 1) {
			int find = numbers[i];
			Integer result = BinarySearch.get(numbers, find, Comparator.comparing(Integer::intValue));
			assertNotNull(result);
			assertEquals(i, result);
		}
	}

	@Test
	void findNumberArrayNotDescendingTest() {
		Integer[] numbers = new Integer[] { 1, 2, 3, 3, 9, 10, 11, 12, 12 };
		int expected1 = 2;
		int expected2 = 3;
		int result = BinarySearch.get(numbers, 3, Comparator.comparing(Integer::intValue));
		assertTrue(result == expected1 || result == expected2, "Was searching for number '3'. "
				+ "Expected is 2 or 3, but was: %d".formatted(result));
	}

	@Test
	void findNumberNotInArrayTest() {
		Integer[] numbers = new Integer[]{0, 0, 0, 1, 9, 19};

		Integer result = BinarySearch.get(numbers, 25, Comparator.comparing(Integer::intValue));
		assertNull(result);
		result = BinarySearch.get(numbers, 15, Comparator.comparing(Integer::intValue));
		assertNull(result);
		result = BinarySearch.get(numbers, -1, Comparator.comparing(Integer::intValue));
		assertNull(result);
	}
}