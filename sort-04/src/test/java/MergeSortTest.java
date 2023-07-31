import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortTest {

	@ParameterizedTest
	@CsvSource({
			"[0;9;-10;5;-6],[-10;-6;0;5;9]",
			"[-1;2;0;4],[-1;0;2;4]",
			"[-15;-100;5239;91;-20;1;2],[-100;-20;-15;1;2;91;5239]"
	})
	void shouldReturnSortedArrayTest(Object array, Object expected) {
		Integer[] input = parseCsvSourceToIntArray(array.toString());
		Integer[] expectedArr = parseCsvSourceToIntArray(expected.toString());
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
		Integer[] array = getBigArray(size);
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

		Integer[] input = getBigArray(size);

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

	private Integer[] getBigArray(int size) {
		Integer[] ints = new Integer[size];
		for (int i = 0; i < ints.length; i++) {
			Random random = new Random();
			Integer randNum = random.nextInt(8232658) - 523980;
			ints[i] = randNum;
		}
		return ints;
	}

	private Integer[] parseCsvSourceToIntArray(String csvSource) {
		csvSource = csvSource.replace("[", "").replace("]", "");
		String[] strNums = csvSource.split(";");
		Integer[] intArray = new Integer[strNums.length];
		int index = 0;
		for (String strNum : strNums) {
			intArray[index] = Integer.valueOf(strNum);
			index++;
		}
		return intArray;
	}
}