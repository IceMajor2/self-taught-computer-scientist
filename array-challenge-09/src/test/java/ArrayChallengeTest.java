
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.TestUtils;

import static org.assertj.core.api.Assertions.*;

class ArrayChallengeTest {

	@ParameterizedTest
	@CsvSource(value = {
			"[1;0;9;15;109;12;15],[0;12;1;9;15;109;15]",
			"[11;16;7;9;98;68;33],[16;98;68;11;7;9;33]",
			"[20;24;32;19;22;100;1],[20;24;32;22;100;19;1]",
			"[21;24;7;4;19;0;11;300;15;12],[24;4;0;300;12;21;7;19;11;15]"
	})
	void sortTest(String inputStr, String expectedStr) {
		int[] input = TestUtils.parseCsvSourceToIntArray(inputStr);
		int[] expected = TestUtils.parseCsvSourceToIntArray(expectedStr);
		int[] actual = ArrayChallenge.sort(input);
		assertThat(actual).containsExactly(expected);
	}
}