import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CheckParenthesesTest {

    @Test
    void checkParenthesesTest() {
        String parentheses = "(())()()";
        assertThat(CheckParentheses.parenthesesBalance(parentheses)).isTrue();
    }
}