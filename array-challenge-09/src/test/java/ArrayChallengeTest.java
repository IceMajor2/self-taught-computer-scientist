
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.TestUtils;

import static org.assertj.core.api.Assertions.*;

class ArrayChallengeTest {

	@ParameterizedTest
	@CsvSource({
			"[1, 0, 9, 15, 109, 12, 15], [0, 12, 1, 9, 15, 109, 15]",
			"[11, 16, 7, 9, 98, 68, 33], [16, 98, 68, 11, 7, 9, 33]",
			"[20, 24, 32, 19, 22, 100, 1], [20, 24, 32, 22, 100, 22, 1]"
	})
	void sortTest(String inputStr, String expectedStr) {
		int[] input = TestUtils.parseCsvSourceToIntArray(inputStr);
		int[] expected = TestUtils.parseCsvSourceToIntArray(expectedStr);
		int[] actual = ArrayChallenge.sort(input);
		assertThat(actual).containsExactly(expected);
	}
}