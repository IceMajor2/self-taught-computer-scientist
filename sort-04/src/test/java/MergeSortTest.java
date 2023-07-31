import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MergeSortTest {

	@ParameterizedTest
	@CsvSource({
			"[0;9;-10;5;-6],[-10;-6;0;5;9]"
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
		List<Integer> list = new ArrayList<>();
		for (int i = csvSource.indexOf('[') + 1; i < csvSource.lastIndexOf(']'); i++) {
			char charAt = csvSource.charAt(i);
			if (charAt == ';') {
				continue;
			}
			list.add(Integer.valueOf(charAt));
		}
		Integer[] intArray = new Integer[list.size()];
		intArray = list.toArray(intArray);
		return intArray;
	}
}