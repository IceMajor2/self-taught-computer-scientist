import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
				.withFailMessage("The actual array was not sorted.")
				.containsExactly(expectedArr);
	}

	private Integer[] parseCsvSourceToIntArray(String csvSource) {
		csvSource = csvSource.replace("[", "").replace("]", "");
		String[] strNums = csvSource.split(";");
		Integer[] intArray = new Integer[strNums.length];
		int index = 0;
		for(String strNum :strNums) {
			intArray[index] = Integer.valueOf(strNum);
			index++;
		}
		return intArray;
	}
}