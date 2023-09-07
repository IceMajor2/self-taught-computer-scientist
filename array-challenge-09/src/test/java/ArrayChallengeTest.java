
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.TestUtils;

import java.util.Arrays;

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
        int[] input = toIntArray(TestUtils.parseCsvSourceToArray(inputStr, Integer.class));
        int[] expected = toIntArray(TestUtils.parseCsvSourceToArray(expectedStr, Integer.class));
        int[] actual = ArrayChallenge.sort(input);
        assertThat(actual).containsExactly(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "[1;0],[0;1]",
            "[2],[2]",
            "[0;1],[0;1]",
            "[9],[9]"
    })
    void sortSmallArrayTest(String inputStr, String expectedStr) {
        int[] input = toIntArray(TestUtils.parseCsvSourceToArray(inputStr, Integer.class));
        int[] expected = toIntArray(TestUtils.parseCsvSourceToArray(expectedStr, Integer.class));
        int[] actual = ArrayChallenge.sort(input);
        assertThat(actual).containsExactly(expected);
    }

    @Test
    void sortArrayWithNegativeValuesTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ArrayChallenge.sort(new int[]{-5, 0, 198, 1298, 432, 2}));
    }

    @Test
    void sortArrayWithEmptyArrayTest() {
        int[] input = {};
        int[] expected = {};
        int[] actual = ArrayChallenge.sort(input);
        assertThat(actual).containsExactly(expected);
    }

    private int[] toIntArray(Integer[] integerArray) {
        return Arrays.stream(integerArray)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}