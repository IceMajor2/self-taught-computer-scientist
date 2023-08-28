import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CheckParenthesesTest {

    @ParameterizedTest
    @ValueSource(strings = {"(())()()", "( )( )()", "() () (( (())))", " () ", "{}({})", "{)"})
    void checkParenthesesCorrectTest(String parentheses) {
        assertThat(CheckParentheses.parenthesesBalance(parentheses)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"())(", "}{}{", "( ( )))", "){))", "{}{ { ){))"})
    void checkParenthesesWrongTest(String parentheses) {
        assertThat(CheckParentheses.parenthesesBalance(parentheses)).isFalse();
    }
}