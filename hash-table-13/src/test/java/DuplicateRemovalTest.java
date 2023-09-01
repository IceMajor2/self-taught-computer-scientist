import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateRemovalTest {

    @ParameterizedTest
    @CsvSource(value = {
            "being book bad breaking being break bad | being book bad breaking break",
            "joey steven michael george george george mike | joey steven michael george mike",
            "They're playing the piano while flying in the plane | They're playing the piano while flying in plane",
            "You can provide only 1 parameter with Value Source, but you can have multiple parameters with Csv Source | " +
                    "You can provide only 1 parameter with Value Source, but have multiple parameters Csv"
    }, delimiter = '|')
    void shouldReturnDuplicateWordsFromString(String str, String expected) {
        assertThat(DuplicateRemoval.removeDuplicates(str)).isEqualTo(expected);
    }

}