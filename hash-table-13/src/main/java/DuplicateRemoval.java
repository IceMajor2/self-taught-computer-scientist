import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DuplicateRemoval {

    private static List<Character> excludedChars = List.of
            ('!', '?', '{', '}', '[', ']', '(', ')', ',', '.', '-', ':', ';');

    /**
     * Passing a text with duplicates into this function will return
     * a {@code String} where each word is appearing at most once.
     */
    public static String removeDuplicates(String str) {
        Map<String, Boolean> words = new HashMap<>();
        Scanner scanner = new Scanner(str);
        StringBuilder builder = new StringBuilder("");

        int index = 0;
        while (scanner.hasNext()) {
            String next = scanner.next();
            String pureWord = getPureWord(next);
            if (words.containsKey(pureWord)) {
                index += next.length() + 1; // the + 1 is for accounting a space
                continue;
            }
            words.put(pureWord, true);
            builder.append(next);
            index += next.length();
            while (index < str.length()) {
                char whitespace = str.charAt(index);
                if (!Character.isWhitespace(whitespace)) break;
                builder.append(whitespace);
                index++;
            }
        }
        String string = removeWhitespacesAtEnd(builder.toString());
        return string;
    }

    private static String removeWhitespacesAtEnd(String str) {
        StringBuilder sb = new StringBuilder(str);
        int finalIndex = -1;
        for (int i = sb.length() - 1; ; i--) {
            char ch = sb.charAt(i);
            if (!Character.isWhitespace(ch)) break;
            finalIndex = finalIndex == -1 ? i : finalIndex - 1;
        }
        if (finalIndex != -1) sb.delete(finalIndex, sb.length());
        return sb.toString();
    }

    /**
     * Returns a 'distilled' form of string provided on input.
     * Distilled, in this context, means a pure, dictionary word i.e.
     * without commas, parentheses, in lowercase, etc.
     * Characters that get removed: ['!', '?', '{', '}', '[', ']', '(', ')', ',', '.', '-', ':', ';']
     */
    private static String getPureWord(String word) {
        StringBuilder sb = new StringBuilder(word.toLowerCase());
        if (excludedChars.contains(word.charAt(0))) {
            sb.deleteCharAt(0);
        }
        int lastIndex = sb.length() - 1;
        if (lastIndex >= 0 && excludedChars.contains(word.charAt(lastIndex))) {
            sb.deleteCharAt(lastIndex);
        }
        return sb.toString();
    }
}
