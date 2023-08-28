public class CheckParentheses {

    private static final char[] OPENING_PARENTHESES = {'[', '{', '('};
    private static final char[] CLOSING_PARENTHESES = {']', '}', ')'};

    public static boolean parenthesesBalance(String parentheses) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (char ch : parentheses.toCharArray()) {
            if (Character.isWhitespace(ch)) continue;
            if (isOpeningParenthesis(ch)) {
                stack.push(ch);
            } else if (isClosingParenthesis(ch)) {
                if (stack.size() == 0) return false;
                else {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }

    private static boolean isClosingParenthesis(char ch) {
        for (char closing : CLOSING_PARENTHESES) {
            if (ch == closing) return true;
        }
        return false;
    }

    private static boolean isOpeningParenthesis(char ch) {
        for (char opening : OPENING_PARENTHESES) {
            if (ch == opening) return true;
        }
        return false;
    }
}
