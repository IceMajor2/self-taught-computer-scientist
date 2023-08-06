import java.util.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.TestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortTest {

	@ParameterizedTest
	@CsvSource({
			"[0;9;-10;5;-6],[-10;-6;0;5;9]",
			"[-1;2;0;4],[-1;0;2;4]",
			"[-15;-100;5239;91;-20;1;2],[-100;-20;-15;1;2;91;5239]"
	})
	void shouldReturnSortedArrayTest(Object array, Object expected) {
		Integer[] input = TestUtils.parseCsvSourceToIntegerArray(array.toString());
		Integer[] expectedArr = TestUtils.parseCsvSourceToIntegerArray(expected.toString());
		Integer[] actualSorted = MergeSort.sort(input);
		assertThat(actualSorted)
				.withFailMessage("The actual array was null")
				.isNotNull();
		assertThat(actualSorted)
				.withFailMessage("The actual array was not sorted correctly.")
				.containsExactly(expectedArr);
	}

	@ParameterizedTest
	@ValueSource(ints = { 500000, 1000000, 2000000, 5000000 })
	void thisMergeSortIsFasterThanJavaArraySortTest(int size) {
		Integer[] array = TestUtils.getBigArray(size);
		Integer[] arrayCopy = array.clone();
		long start = System.currentTimeMillis();
		Arrays.sort(array);
		long end = System.currentTimeMillis();
		long javaTime = end - start;

		start = System.currentTimeMillis();
		MergeSort.sort(arrayCopy);
		end = System.currentTimeMillis();
		long thisTime = end - start;
		assertThat(thisTime)
				.withFailMessage("MergeSort.sort was not faster than Arrays.sort")
				.isLessThan(javaTime);
		double howFaster = javaTime / (double) thisTime;
		System.out.println("MergeSort.sort was faster than Arrays.sort by " + howFaster + " times!");
	}

	@ParameterizedTest
	@ValueSource(ints = { 10000, 200000, 300000 })
	void shouldSortBigDataArrayTest(int size) {
		Integer[] input = TestUtils.getBigArray(size);
		Integer[] actualSorted = MergeSort.sort(input);

		assertThat(actualSorted)
				.withFailMessage("The actual array was null")
				.isNotNull();
		Arrays.sort(input);
		// The below assertion is very time-consuming,
		// thus not testing for bigger arrays
		assertThat(actualSorted)
				.withFailMessage("The actual array was not sorted correctly.")
				.containsExactly(input);
	}
}